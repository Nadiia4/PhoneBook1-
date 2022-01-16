package tests;

import org.testng.annotations.Test;

public class Registration extends TestBase{


    @Test
public void registrationSuccessTest(){
        int index = (int)(System.currentTimeMillis()/1000)%3600;

        app.getUserHelper().openLoginRegistrationForm();

        app.getUserHelper().fillLoginRegistrationForm("noa" + index + "@gmail.com", "Nnoa12345$");

        app.getUserHelper().submitRegistrationForm();

    }

}
