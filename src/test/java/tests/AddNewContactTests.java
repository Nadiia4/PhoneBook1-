package tests;

import manager.MyDataProvider;
import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (!app.getUserHelper().isLogOutPresent()) {
            User user = new User().withEmail("lina@gmail.com").withPassword("Lina12345$");
            app.getUserHelper().login(user);
            logger.info("Contact was added for user" + user.toString());
        }

    }

    @Test(groups = {"web"})
    //(invocationCount = 3)  // test zapystitsya 3 raza
    public void addNewContactSuccess() {

//        if(count>5){
//            removeall contact();
//        }

        app.getContactHelper().controlAmountContacts();//DOMASHKA

        int countStart = app.getContactHelper().countOfContacts();
        //int countStart = app.contact().countOfContacts();
        System.out.println(countStart);
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

        logger.info("Contact was added" + contact.toString());

        app.getContactHelper().openAddContactForm();
        // app.contact().openAddContactForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitForm();

        int countEnd = app.getContactHelper().countOfContacts();
        //int countEnd = app.contact().countOfContacts();
        System.out.println(countEnd);
        //  Assert.assertTrue(app.isContactPageDisplayed());

        Assert.assertEquals(countEnd - countStart, 1);

        Assert.assertTrue(app.getContactHelper().isContactCreateByName(contact.getName()));
        Assert.assertTrue(app.getContactHelper().isContactCreateByPhone(contact.getPhone()));
    }


    @Test(dataProvider = "addContactValidDataCSV", dataProviderClass = MyDataProvider.class)  // test zapystitsya 3 raza
    public void addNewContactSuccessProvider(Contact contact) {
//TEST VUCHITKA IZ FAILA


//        if(count>5){
//            removeall contact();
//        }

        int countStart = app.getContactHelper().countOfContacts();

        logger.info("The test 'Add new contact' start with count of contact in start--->" + countStart);
        logger.info("The test 'Add new contact' start with data---->" + contact.toString());

        app.getContactHelper().openAddContactForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitForm();

        int countEnd = app.getContactHelper().countOfContacts();
        logger.info("The test 'Add new contact' end with count of contact in end--->" + countEnd);

        Assert.assertEquals(countEnd - countStart, 1);
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

    @Test(dataProvider = "addContactValidDataModel", dataProviderClass = MyDataProvider.class, enabled = false)//ne budet zapyskatj
    // test zapystitsya 3 raza
    public void addNewContactSuccessDT(Contact contact) {//DataProvider

//        if(count>5){
//            removeall contact();
//        }

        int countStart = app.getContactHelper().countOfContacts();
        logger.info("The test 'Add new contact' start with count of contact in start--->" + countStart);
        logger.info("The test 'Add new contact' start with data---->" + contact.toString());

        app.getContactHelper().openAddContactForm();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitForm();


        int countEnd = app.getContactHelper().countOfContacts();
        logger.info("The test 'Add new contact' end with count of contact in end--->" + countEnd);

        Assert.assertEquals(countEnd - countStart, 1);
        Assert.assertTrue(app.getContactHelper().isContactCreateByName(contact.getName()));
        Assert.assertTrue(app.getContactHelper().isContactCreateByPhone(contact.getPhone()));
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {

        app.getUserHelper().logout();

    }
}
