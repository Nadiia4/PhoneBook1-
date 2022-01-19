package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {


    @Test
    public void loginSuccessTest() {

        app.getUserHelper().openLoginRegistrationForm();

        app.getUserHelper().fillLoginRegistrationForm("noa@gmail.com", "Nnoa12345$");

        app.getUserHelper().submitLoginForm();
        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());

    }
    public void loginSuccessModel() {

        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(user);
        app.getUserHelper().submitLoginForm();

        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());

    }

}
