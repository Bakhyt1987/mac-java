package addressbook.tests;

import addressbook.model.ContactData;
import addressbook.model.Groups;
import org.testng.annotations.Test;

import java.io.File;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        Groups groups = app.db().groups();
        File photo = new File("src/test/resources/stru.png");
        ContactData newContact = new ContactData().withFirstname("test_name").withLastname("test_surname").withPhoto(photo)
                .inGroup(groups.iterator().next());
        app.goTo().gotoHomePage();
        app.contact().initContactCreation();
        app.contact().fillContactForm(newContact, true);
        app.contact().submitContactCreation();
        app.contact().returnToHomePage();
    }

//    @Test
//    public void testCurrentDir() {
//        File currentDir =new File("");
//        System.out.println(currentDir.getAbsolutePath());
//        File photo = new File("src/resources/Baha.png");
//        System.out.println(photo.getAbsolutePath());
//        System.out.println(photo.exists());
//    }

}