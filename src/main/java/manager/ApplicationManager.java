package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    //WebDriver wd;// v obicnom WebDriver nevozmozhno rabotatj s Lissiner
    //EventFiringWebDriver - webdraiver kotoruy sposoben vzaimodeystvovatj c lissiner
    EventFiringWebDriver wd;//(((---1---)))
    UserHelper userHelper;//ssilka na class pomoshnik
    ContactHelper contactHelper;//contact

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);//sozdanie ekzemplyara loggera

    public  void init(){
//        ChromeOptions chromeOptions = new ChromeOptions();//-------------------
//        WebDriverManager.chromedriver().setup();//------------
//
//        System.setProperty("webdriver.chrome.driver", "C:/Users/Nadii/PhoneBook1-/chromedriver.exe");//---------------------
//       wd = new ChromeDriver();
//logger.info("All tests start in 'Chrome' browser");//zapis v consol
//       wd.manage().window().maximize();
//       wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
//       wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//       userHelper = new UserHelper(wd);
//       contactHelper = new ContactHelper(wd);

        //wd = new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());//(((---2---)))//teper driver sposoben delitsya sobitiyami

        logger.info("All tests start in 'Chrome' browser");//zapis v consol
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