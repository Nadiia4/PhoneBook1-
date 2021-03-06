package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//naslednik helperBase
public class UserHelper extends HelperBase {


    public UserHelper(WebDriver wd) {

        super(wd);//konstruktor superklassa
    }

    public void openLoginRegistrationForm() {
        click(By.cssSelector("[href= '/login']"));

    }

    public void fillLoginRegistrationForm(String email, String password) {

        type(By.cssSelector("[placeholder='Email']"), email);
        type(By.cssSelector("[placeholder='Password']"), password);
    }

    public void fillLoginRegistrationForm(User user) {

        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
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

    public boolean isLoginRegistrationSuccess() {
//        WebElement signOut = wd.findElement(By.xpath("//button[text()='Sign Out']"));
//        String button = signOut.getText();
//        return button.equals("Sign Out");
        return wd.findElements(By.xpath("//button[text()='Sign Out']")).size()>0;

    }

    public boolean isLogOutPresent() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));

    }


    public void logout() {
        click(By.xpath("//button[text()='Sign Out']"));
    }

    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLoginForm();

    }

    public boolean IsAlertDisplayed() {
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            return true;
        }
    }


    public boolean isErrorWrongEmailPasswordFormat() {
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());

        wd.switchTo().alert();//method alert
        String error = alert.getText();
        alert.accept();//click 'ok' button
        //alert.dismiss();//click cancel
        //alert.sendKeys("email");
        return error.contains("Wrong email or password format");
    }
}
