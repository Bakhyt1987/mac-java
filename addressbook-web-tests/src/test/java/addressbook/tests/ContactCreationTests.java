package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void contactCreationTests() {
        app.getGroupHelper().createContact(new ContactData("rrr",  "sss", "Bob"));
        app.getNavigationHelper().returnToHomePage();
    }
}