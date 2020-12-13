package contact.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends HelperBase {


    public NavigationHelper(ChromeDriver driver) {
        super(driver);
    }


    public void goToContactForm() {
        click(By.linkText("add new"));
    }
}
