package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{


    @Test (enabled = false)
    public void contactDeletionTests(){
        if(!app.contact().isThereAContact()){
            app.contact().createContact(new ContactData().withLastname("Baha"));
        }
        app.contact().selectContact();
        app.contact().deleteSelectedContact();
        app.goTo().returnToHomePage();
    }
}
