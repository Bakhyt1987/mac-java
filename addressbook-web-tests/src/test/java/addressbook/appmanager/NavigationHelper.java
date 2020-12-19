package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper  extends HelperBase {


    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void goToGroupPage() {
        if (isElementPresent(By.tagName("h1"))) {
            click(By.linkText("groups"));
        }

    }
    public void goToHomePage(){
        click(By.linkText("home"));
    }
}