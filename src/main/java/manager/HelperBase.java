package manager;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class HelperBase {

    WebDriver wd;
    Logger logger = LoggerFactory.getLogger(HelperBase.class);
    public HelperBase(WebDriver wd) {

        this.wd = wd;
    }

    public void type(By locator, String text) {
        if (text != null && !text.isEmpty())
        {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
       }
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;

    }
    public void takeScreenShot(String pathToFile){
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screen = new File(pathToFile);//ssilka kyda skiduvatj files

        try{
            Files.copy(tmp,screen);//iz kakogo file i v kakoy
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
