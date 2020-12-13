package contact.appmanager;

import contact.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper extends HelperBase{

    public ContactHelper(ChromeDriver driver) {
        super(driver);
    }


    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"),contactData.getMiddlename());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("nickname"),contactData.getNickname());
        click(By.name("title"));
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHome());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("work"), contactData.getWork());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("homepage"), contactData.getHomepage());
        click(By.name("bday"));
        new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
        click(By.name("bmonth"));
        new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
        type(By.name("byear"), contactData.getByear());
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

}
