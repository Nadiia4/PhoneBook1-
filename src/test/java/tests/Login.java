package tests;

import org.testng.annotations.Test;

public class Login extends TestBase {


    @Test
    public void loginSuccessTest() throws InterruptedException {

        app.getUserHelper().openLoginRegistrationForm();

        app.getUserHelper().fillLoginRegistrationForm("noa@gmail.com", "Nnoa12345$");

        app.getUserHelper().submitLoginForm();

    }


}
