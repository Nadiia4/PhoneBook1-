package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;
    @BeforeMethod
    public void preconditions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();

        wd = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:/Users/Nadii/PhoneBook1-/chromedriver.exe");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
    }

    @AfterMethod
    public void postconditions(){
        wd.close();
        wd.quit();
    }
    public void type(By locator, String text) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);

    }
    //public void type(By locator, String text) {
     //if (text != null && !text.isEmpty()) {
    //WebElement element = wd.findElement(locator);
    //element.click();
    //element.clear();
    //element.sendKeys(text);
    //}}


    public void click(By locator) {
        wd.findElement(locator).click();
    }
}
