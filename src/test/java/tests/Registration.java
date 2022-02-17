package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        //if logged(logout present???)--->logout

        if(app.getUserHelper().isLogOutPresent()){
            app.getUserHelper().logout();
        }

    }

    @Test(groups = {"web"})
public void registrationSuccessTest(){
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        System.out.println(index);
        app.getUserHelper().openLoginRegistrationForm();
        app.getUserHelper().fillLoginRegistrationForm("noa" + index + "@gmail.com", "Nnoa12345$");
        app.getUserHelper().submitRegistrationForm();
        app.getUserHelper().pause(2000);

        Assert.assertTrue(app.getUserHelper().isLoginRegistrationSuccess());

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
        Assert.assertTrue(app.getUserHelper().isLoginRegistrationSuccess());

    }

}
