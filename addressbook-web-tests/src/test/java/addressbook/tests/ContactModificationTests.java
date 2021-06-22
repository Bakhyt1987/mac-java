package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

    @Test (enabled = false)
    public void contactModificationTests(){
        if(! app.contact().isThereAContact()){
            app.contact().createContact(new ContactData().withLastname("work"));
        }
        app.contact().ContactModification(new ContactData().withLastname("rick"));
        app.goTo().gotoHomePage();
    }
}






