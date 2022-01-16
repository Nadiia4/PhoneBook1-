package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//naslednik helperBase
public class UserHelper extends HelperBase{


    public UserHelper(WebDriver wd) {

        super(wd);//konstruktor superklassa
    }

    public void openLoginRegistrationForm(){
        click(By.cssSelector("[href= '/login']"));

    }

    public void fillLoginRegistrationForm(String email, String password){

        type(By.cssSelector("[placeholder='Email']"),email);
        type(By.cssSelector("[placeholder='Password']"), password);
    }

    public void submitLoginForm() {

        click(By.cssSelector("button"));
        //click(By.xpath("//button[text()='Login']"));
        //click(By.xpath("//button[1]"));
    }

    public void submitRegistrationForm() {
        click(By.xpath("//button[2]"));
        //click(By.cssSelector("//button[text()= 'Registration']"));
    }
}
