package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    UserHelper userHelper;//ssilka na class pomoshnik
    ContactHelper contactHelper;


    public  void init(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.chrome.driver", "C:/Users/Nadii/PhoneBook1-/chromedriver.exe");
       wd = new ChromeDriver();
       wd.manage().window().maximize();
       wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
       wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       userHelper = new UserHelper(wd);
       contactHelper = new ContactHelper(wd);

    }

    public void stop(){
    wd.quit();
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public ContactHelper getContactHelper() {
        //generiruem getter
        return contactHelper;
    }



}
//znakomstvo, realizaciya, oformlenie ---> v tri hoda