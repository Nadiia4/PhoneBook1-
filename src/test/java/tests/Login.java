package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {

@BeforeMethod
public void preCondition(){
    //if logged(logout present???)--->logout

    if(app.getUserHelper().isLogOutPresent()){
        app.getUserHelper().logout();
    }

}

    @Test
    public void loginSuccessTest() {

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm("noa@gmail.com", "Nnoa12345$");
        app.getUserHelper().submitLoginForm();

        logger.info("The test start with email:[noa@gmail.com] & password: [Nnoa12345$]");
        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isLoginRegistrationSuccess());

    }
    @Test
    public void loginSuccessModel() {

        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
logger.info("The test start with data: " + user.toString());
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(user);
        app.getUserHelper().submitLoginForm();

        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isLoginRegistrationSuccess());

    }

    @Test
    public void loginNegativeTestWrongPassword() {//????????????????????

        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa");

        logger.info("The test start with data: " + user.toString());
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(user);
        app.getUserHelper().submitLoginForm();

        Assert.assertTrue(app.getUserHelper().IsAlertDisplayed());
        Assert.assertTrue(app.getUserHelper().isErrorWrongEmailPasswordFormat());
        Assert.assertFalse(app.getUserHelper().isLoginRegistrationSuccess());

    }


}
