package tests;

import models.Contact;
import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.getUserHelper().isLogOutPresent()) {
            app.getUserHelper().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        }

    }

    @Test
    public void addNewContactSuccess() {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        System.out.println(index);

        Contact contact = Contact.builder()
                .name("Olga")
                .lastName("Semenko")
                .phone("0648712589" + index)
                .email("olga" + index + "@gmail.com")
                .address("Tel Aviv, Rotshild,14")
                .description("work")
                .build();

        app.getContactHelper().openAddContactForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitForm();
        //app.getContactHelper().pause(5000);


        //  Assert.assertTrue(app.isContactAdded());

    }

    @Test
    public void addNewContactSuccess2() {
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        System.out.println(index);

        Contact contact = Contact.builder()
                .name("Olga")
                .lastName("Semenko")
                .phone("0648712589" + index)
                .email("olga" + index + "@gmail.com")
                .address("Tel Aviv, Rotshild,14")
                .description("work")
                .build();

        app.getContactHelper().openAddContactForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitForm();
        //app.getContactHelper().pause(5000);


        //  Assert.assertTrue(app.isContactAdded());
        //.contact-item_card__2SOIM
    }

    @AfterMethod
    public void postCondition() {

        app.getUserHelper().logout();

    }
}
