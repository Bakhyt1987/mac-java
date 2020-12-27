package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

    @Test
    public void contactModificationTests(){
        if(! app.getGroupHelper().isThereAContact()){
            app.getGroupHelper().createContact(new ContactData("RON", null, null));
        }
        app.getGroupHelper().ContactModification(new ContactData("2222", null, null));
        app.getNavigationHelper().returnToHomePage();
    }
}






