package tests;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager();
    //inizializaciya ApplicationManager

     Logger logger = LoggerFactory.getLogger(TestBase.class);

@BeforeMethod
public void startLogger(Method m){
    logger.info("Name of test --->" + m.getName());
//peredacha v consol nazvanie testa
}

    @BeforeSuite
    public void setUp() {
        app.init();
//        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {

        //app.stop();
    }

}
