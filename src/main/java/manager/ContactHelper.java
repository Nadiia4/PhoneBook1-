package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.elementToBeClickable(wd.findElement(By.xpath("//b"))));
        click(By.xpath("//b"));

    }
   }
