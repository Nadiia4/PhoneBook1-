package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Registration extends TestBase{


    @Test
public void registrationSuccessTest(){
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        //open form
        click(By.cssSelector("[href= '/login']"));
        //fill email
        type(By.cssSelector("[placeholder='Email']"), "noa" + index + "@gmail.com");
        //fill password
        type(By.cssSelector("[placeholder='Password']"),"Nnoa12345$");
        //confirm registration - click registration button
        //click(By.cssSelector("//button[text()= 'Registration']"));
        click(By.xpath("//button[2]"));
    }


}
