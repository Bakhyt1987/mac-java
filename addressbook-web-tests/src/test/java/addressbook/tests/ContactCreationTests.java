package addressbook.tests;

import addressbook.model.ContactData;
import org.testng.annotations.Test;

import java.io.File;

public class ContactCreationTests extends TestBase {

    @Test
    public void contactCreationTests() {
        app.goTo().goToHomePage();
        app.contact().initContactCreation();
        File photo = new File("src/resources/Baha.png");
        app.contact().fillContactForm(
                new ContactData().withFirstname("test_name1").withLastname("test_surname1").withGroup("test1").withPhoto(photo),true);
        app.contact().submitContactCreation();
        app.goTo().returnToHomePage();
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