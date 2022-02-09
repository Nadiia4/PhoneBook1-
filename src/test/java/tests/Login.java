package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeMethod
    public void preCondition() {
        //if logged(logout present???)--->logout

        if (app.getUserHelper().isLogOutPresent()) {
            app.getUserHelper().logout();
        }

    }

    @Test
    public void loginSuccessTest() {

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm("lina@gmail.com", "Lina12345$");
        app.getUserHelper().submitLoginForm();

        logger.info("The test start with email:[lina@gmail.com] & password: [Lina12345$]");
        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isLoginRegistrationSuccess());//isLogged

    }


    @Test(dataProvider = "LoginValidDataCSV", dataProviderClass = MyDataProvider.class)
//DOMASHKA!!!!!!!!!!!!!!!!!!!!!!!!
    //TEST VUCHITKA IZ FAILA
    public void loginSuccessTestDataProvider(User user) {
        logger.info("The test 'Login valid data' start with data---->" + user.toString());

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(user);
        app.getUserHelper().submitLoginForm();

        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isLoginRegistrationSuccess());//isLogged


    }

    @Test(dataProvider = "LoginValidData", dataProviderClass = MyDataProvider.class)
    // etot test rabotaet c dataprovider - LoginValidData(zapisan v MyDataProvider)
    public void loginSuccessTestDataProvider(String email, String password) {

        logger.info("The test start with email:" + email + " && password :" + password);

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(email, password);
        app.getUserHelper().submitLoginForm();

        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isLoginRegistrationSuccess());//isLogged

    }

    @Test(dataProvider = "LoginValidDataModel", dataProviderClass = MyDataProvider.class)
    public void loginSuccessModelDataProvider(User user) {
        //ybrali sozdanie usera
        logger.info("The test start with data: " + user.toString());

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(user);
        app.getUserHelper().submitLoginForm();

        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isLoginRegistrationSuccess());

    }


    @Test
    public void loginSuccessModel() {

        User user = new User().withEmail("lina@gmail.com").withPassword("Lina12345$");
        logger.info("The test start with data: " + user.toString());
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(user);
        app.getUserHelper().submitLoginForm();

        app.getUserHelper().takeScreenShot("src/test/screenshots/scr1.png");

        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isLoginRegistrationSuccess());

    }

    @Test
    public void loginNegativeTestWrongPassword() {

        User user = new User().withEmail("lina@gmail.com").withPassword("Lina");

        logger.info("The test start with data: " + user.toString());
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(user);
        app.getUserHelper().submitLoginForm();

        Assert.assertTrue(app.getUserHelper().IsAlertDisplayed());
        Assert.assertTrue(app.getUserHelper().isErrorWrongEmailPasswordFormat());
        Assert.assertFalse(app.getUserHelper().isLoginRegistrationSuccess());

    }


}
