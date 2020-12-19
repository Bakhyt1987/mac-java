package contact.tests;

import contact.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
    @Test
    public void contactModificationTests(){
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("John", "Robert",null),false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
