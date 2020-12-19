package contact.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final String browser;
    public WebDriver driver;

    public SessionHelper sessionHelper;
    public NavigationHelper navigationHelper;
    public ContactHelper contactHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
            System.setProperty("webdriver.gecko.driver",
                    "/Users/bakhyt/Documents/GitHub/mac-java/addressbook-web-tests/browsers/geckodriver");
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver",
                    "/Users/bakhyt/Documents/GitHub/mac-java/addressbook-web-tests/browsers/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            System.setProperty("webdriver.edge.driver",
                    "/Users/bakhyt/Documents/GitHub/mac-java/addressbook-web-tests/browsers/msedgedriver");
            driver = new EdgeDriver();
        }
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook/index.php");
        contactHelper = new ContactHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin", "secret");
    }


    public void stop() {
        driver.quit();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}