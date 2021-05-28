package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test (enabled = false)
    public void contactCreationTests() {
        app.group().createContact(new ContactData("rrr",  "sss", "Bob"));
        app.goTo().returnToHomePage();
    }
}