package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    //WebDriver wd;// v obichnom WebDriver nevozmozhno rabotatj c Lissiner
    //EventFiringWebDriver - webdraiver kotoruy sposoben vzaimodeystvovatj c lissiner
    EventFiringWebDriver wd;//(((---1---)))
    UserHelper userHelper;//ssilka na class pomoshnik
    ContactHelper contactHelper;//contact
    String browser;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);//sozdanie ekzemplyara loggera

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public  void init(){
        //ChromeOptions chromeOptions = new ChromeOptions();//

//
//      System.setProperty("webdriver.chrome.driver", "C:/Users/Nadii/PhoneBook1-/chromedriver.exe");//---------------------
//       wd = new ChromeDriver();
//logger.info("All tests start in 'Chrome' browser");//zapis v consol
//       wd.manage().window().maximize();
//       wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
//       wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//       userHelper = new UserHelper(wd);
//       contactHelper = new ContactHelper(wd);

        //wd = new ChromeDriver();
        if(browser.equals(BrowserType.CHROME)){
            WebDriverManager.chromedriver().setup();//dlya vipolneniya testov v chrome
            wd = new EventFiringWebDriver(new ChromeDriver());//(((---2---)))//teper driver sposoben delitsya sobitiyami
            logger.info("All tests start in 'Chrome' browser");//zapis v consol
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("All tests start in 'FIREFOX' browser");
        }else if(browser.equals(BrowserType.EDGE)){
            wd = new EventFiringWebDriver(new EdgeDriver());
            logger.info("All tests start in 'EDGE' browser");
        }


        wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.register(new MyListener());//(((---3---))) registraziya Lissiner

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