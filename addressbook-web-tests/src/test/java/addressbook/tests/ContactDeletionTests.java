package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{


    @Test
    public void contactDeletionTests(){
        if(!app.getGroupHelper().isThereAContact()){
            app.getGroupHelper().createContact(new ContactData("RON", null, null));
        }
        app.getGroupHelper().selectContact();
        app.getGroupHelper().deleteSelectedContact();
        app.getNavigationHelper().returnToHomePage();
    }
}
