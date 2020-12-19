package contact.tests;


import contact.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


    @Test
    public void contactCreationTests() throws Exception {
        app.getNavigationHelper().goToContactForm();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData(
                "John", "Robert", "Gyle"), true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }


}
