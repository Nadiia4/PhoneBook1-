package tests;

import models.Contact;
import models.User;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RemoveContactTests extends TestBase {


    @BeforeMethod
    public void preCondition() {
        if (!app.getUserHelper().isLogOutPresent()) {
            User user = new User().withEmail("lina@gmail.com").withPassword("Lina12345$");
            app.getUserHelper().login(user);
            logger.info("Login was completed for user" + user.toString());
        }
//providerContact ===> add 3 contacts
        if (app.getContactHelper().countOfContacts() < 2) {
            do {
                providerContact();
            }
            while (app.getContactHelper().countOfContacts() < 2);
        }

    }


    private void providerContact() {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        System.out.println(index);

        Contact contact = Contact.builder()
                .name("Olga" + index)
                .lastName("Semenko")
                .phone("0648712589" + index)
                .email("olga" + index + "@gmail.com")
                .address("Tel Aviv, Rotshild,14")
                .description("work")
                .build();

        logger.info("Contact was added to " + contact.toString());

        app.getContactHelper().openAddContactForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitForm();


    }


    @Test
    public void removeOneContact() {
        int countStart = app.getContactHelper().countOfContacts();
        System.out.println(countStart);

        app.getContactHelper().removeOneContact();

        app.getUserHelper().pause(1000);
        int countEnd = app.getContactHelper().countOfContacts();
        System.out.println(countEnd);

        Assert.assertEquals(countStart - countEnd, 1);
        //Assert.assertTrue(countStart - countEnd == 1);

    }

    @Test
    public void removeAllContacts() {

        app.getContactHelper().removeAllContacts();
        Assert.assertTrue(app.getContactHelper().isContactsListIsEmpty());

    }
}
