package addressbook.appmanager;

import addressbook.model.ContactData;
import addressbook.model.GroupData;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }



    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroup() {
        click(By.name("delete"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    private AgentBuilder.RawMatcher closeAlertAndGetItsText() {
        return null;
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void submitContactModification() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }
    public void createGroup(GroupData group) {
        initGroupCreation();
        fillGroupForm(new GroupData("RON", null, null));
        submitGroupCreation();
        returnToGroupPage();

    }

    public void createContact(ContactData contact) {
        goToContactCreationForm();
        fillContactForm(new ContactData("rrr", null, null));
        submitContactCreation();

    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }
    public void GroupModification(GroupData group) {
        selectGroup();
        initGroupModification();
        fillGroupForm(new GroupData("Gyle", "Tony", "Trey"));
        submitGroupModification();

    }

    public void ContactModification(ContactData contact) {
        selectContact();
        initContactModification();
        fillContactModification(new ContactData("2222", null, null));
        submitContactModification();
    }

    public void goToContactCreationForm() {
        click(By.linkText("add new"));
    }


    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("company"), contactData.getCompany());
    }



    public void fillContactModification(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("company"), contactData.getCompany());
    }



}
