package contact.tests;


import contact.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


    @Test
    public void contactCreationTests() throws Exception {
        app.navigationHelper.goToContactForm();
        app.contactHelper.fillContactForm(new ContactData(
                "John", "Robert",
                "Lennon", "Jerk",
                "Big Boss", "Kuderina street",
                "7777777", "5554433", "5553355",
                "5553434", "b-root@list.ru",
                "b-root@mail.ru", "b-root@gmail.com",
                "b.com", "13", "July", "1987"));
        app.contactHelper.submitContactCreation();
        app.contactHelper.returnToHomePage();
    }


}
