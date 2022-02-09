package manager;

import models.Contact;
import org.openqa.selenium.*;

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
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());///Name isportili dlya testa
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
            if (el.getText().equals(name)) ;
            return true;
        }
        return false;
    }


    public boolean isContactCreateByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone)) ;
            return true;
        }
        return false;
    }

    public void removeOneContact() {
        WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
        contact.click();
        click(By.xpath("//button[.='Remove']"));
    }

    public int removeOneContactCount() {
        int countBefore = countOfContacts();
        logger.info("Before remove 'One contact tests' count was --->" + countBefore);

        if (!isContactsListIsEmpty()) {
            String phone = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
            logger.info("The phone number of removed contact was -->" + phone);

            wd.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
            wd.findElement(By.xpath("//button[text()='Remove']")).click();
            pause(500);
        }

        int countAfter = countOfContacts();
        logger.info("After remove one contact the count is --->" + countAfter);

        return countAfter - countBefore;
    }

    public boolean isContactsListIsEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();

    }

    public void removeAllContactsNotWork() {
        List<WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));

        for (WebElement el : list) {
            el.click();
            wd.findElement(By.xpath("//button[.='Remove']")).click();
            pause(1000);

        }

    }

    public void removeAllContacts() {

        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() != 0) {
            removeOneContactCount();
        }
    }

    public void controlAmountContacts() {

        if (countOfContacts() > 5) {
            removeAllContacts();
        }
    }


}
