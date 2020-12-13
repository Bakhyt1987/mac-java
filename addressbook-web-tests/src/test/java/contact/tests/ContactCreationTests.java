package contact.tests;


import addressbook.tests.TestBase;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


    @Test
    public void contactCreationTests() throws Exception {
        app.navigationHelper.goToContactForm();
        app.groupHelper.fillContactForm(
                "John", "Robert",
                "Lennon", "Jerk",
                "Big Boss", "Kuderina street",
                "7777777", "5554433", "5553355",
                "5553434", "b-root@list.ru",
                "b-root@mail.ru", "b-root@gmail.com",
                "b.com", "13", "July", "1987");
        app.groupHelper.submitContactCreation();
        app.groupHelper.returnToHomePage();
    }


}
