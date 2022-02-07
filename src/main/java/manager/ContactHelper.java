package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        //generiruem construktor super klassa
        super(wd);
    }

    public void openAddContactForm() {
        click(By.cssSelector("[href='/add']"));

    }

    public void fillContactForm(Contact contact) {

        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());
    }

    public void submitForm() {
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.elementToBeClickable(wd.findElement(By.xpath("//b"))));
        click(By.xpath("//b"));

    }

    public int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();

    }

    public boolean isContactCreateByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if(el.getText().equals(name));
            return true;
        }
        return false;
    }


    public boolean isContactCreateByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if(el.getText().equals(phone));
            return true;
        }
        return false;
    }

    public void removeOneContact() {
        WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
    contact.click();
    click(By.xpath("//button[.='Remove']"));
    }


}
