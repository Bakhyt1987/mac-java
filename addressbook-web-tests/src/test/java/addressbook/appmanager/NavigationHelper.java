package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper  extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void GroupPage() {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new")))
            return;
         {
            click(By.linkText("groups"));
        }
    }

    public void returnToGroupPage() {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new")))
            return;
        {
            click(By.linkText("groups"));
        }
    }

    public void returnToHomePage(){
        if(isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
    }

    public void goToHomePage() {
        if (!isElementPresent(By.tagName("h1"))
                || !driver.findElement(By.tagName("h1")).getText().equals("Address book"))
            return;
        {
            click(By.linkText("home"));
        }
    }
}