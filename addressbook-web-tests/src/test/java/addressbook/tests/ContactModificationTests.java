package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

    @Test (enabled = false)
    public void contactModificationTests(){
        if(! app.group().isThereAContact()){
            app.group().createContact(new ContactData("RON", "null", "Bob"));
        }
        app.group().ContactModification(new ContactData("2222", "null", null));
        app.goTo().returnToHomePage();
    }
}






