package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Registration extends TestBase{


    @Test
public void registrationSuccessTest(){
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        System.out.println(index);
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm("noa" + index + "@gmail.com", "Nnoa12345$");
        app.getUserHelper().submitRegistrationForm();
        app.getUserHelper().pause(2000);

        Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());

    }
    @Test
    public void registrationSuccessModel(){

        int index = (int)(System.currentTimeMillis()/1000)%3600;
        System.out.println(index);

        User user = new User().withEmail("noa" + index + "@gmail.com").withPassword("Nnoa12345$");

        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm(user);
        app.getUserHelper().submitRegistrationForm();

        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isRegistrationSuccess());

    }

}
