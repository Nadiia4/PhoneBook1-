package tests;

import manager.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager();
    //inizializaciya ApplicationManager


    @BeforeMethod
    public void setUp() {
        app.init();
//        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
