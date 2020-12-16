package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper  extends HelperBase{


    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void goToGroupPage() {
        click(By.linkText("groups"));
    }

    public void goToContactForm() {
        click(By.linkText("add new"));
    }
}
