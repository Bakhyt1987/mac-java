package addressbook.appmanager;

import addressbook.model.ContactData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        goToContactCreationForm();
        fillContactForm(contact, true);
        submitContactCreation();


    }

    public void ContactModification(ContactData contact) {
        selectContact();
        initContactModification();
        fillContactModification(contact, false);

        submitContactModification();
    }

    public void goToContactCreationForm() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        attach(By.name("photo"), contactData.getPhoto());
        if (creation) {
            if (contactData.getGroup() != null) {
                new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
            } else {
                Assert.assertFalse(isElementPresent(By.name("new_group")));
            }

        }
    }

    public void fillContactModification(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());

        if (creation) {
            if (contactData.getGroup() != null) {
                new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
            } else {
                Assert.assertFalse(isElementPresent(By.name("new_group")));
            }
        }
    }

    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> rows = driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String allPhones = cells.get(5).getText();
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withAllPhones(allPhones));
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
        String home = driver.findElement(By.name("home")).getAttribute("value");
        String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
        String work = driver.findElement(By.name("work")).getAttribute("value");
        driver.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }

    public void initContactModificationById(int id) {
        WebElement checkbox = driver.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }
}