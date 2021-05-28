package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{


    @Test (enabled = false)
    public void contactDeletionTests(){
        if(!app.group().isThereAContact()){
            app.group().createContact(new ContactData("RON", null, null));
        }
        app.group().selectContact();
        app.group().deleteSelectedContact();
        app.goTo().returnToHomePage();
    }
}
