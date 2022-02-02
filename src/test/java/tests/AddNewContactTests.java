package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (!app.getUserHelper().isLogOutPresent()) {
            User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
            app.getUserHelper().login(user);
            logger.info("Contact was added for user" + user.toString());
        }

    }

    @Test
    public void addNewContactSuccess() {

//        if(count>5){
//            removeall contact();
//        }

        int countStart = app.getContactHelper().countOfContacts();//????
        //int countStart = app.contact().countOfContacts();
        System.out.println(countStart);
        int index = (int) (System.currentTimeMillis() / 1000) % 3600;
        System.out.println(index);

        Contact contact = Contact.builder()
                .name("Olga"+ index)
                .lastName("Semenko")
                .phone("0648712589" + index)
                .email("olga" + index + "@gmail.com")
                .address("Tel Aviv, Rotshild,14")
                .description("work")
                .build();

        logger.info("Contact was added" + contact.toString());

        app.getContactHelper().openAddContactForm();
        // app.contact().openAddContactForm();
        app.getContactHelper().fillContactForm(contact);
        // app.contact().fillContactForm(contact);
        app.getContactHelper().submitForm();
        // app.contact().submitForm();


        int countEnd = app.getContactHelper().countOfContacts();
        //int countEnd = app.contact().countOfContacts();
        System.out.println(countEnd);
        //  Assert.assertTrue(app.isContactPageDisplayed());
        //if countStart - countEnd = -1
        Assert.assertEquals(countEnd-countStart,1);
        //tEquals(countEnd-countStart, 1);
        //if list contact with name + phone
        Assert.assertTrue(app.getContactHelper().isContactCreateByName(contact.getName()));
        Assert.assertTrue(app.getContactHelper().isContactCreateByPhone(contact.getPhone()));
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

        logger.info("Contact was added" + contact.toString());

        app.getContactHelper().openAddContactForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitForm();
        //app.getContactHelper().pause(5000);




    }

    @AfterMethod
    public void postCondition() {

        app.getUserHelper().logout();

    }
}
