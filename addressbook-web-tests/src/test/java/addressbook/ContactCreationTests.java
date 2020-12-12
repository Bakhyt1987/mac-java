package addressbook;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ContactCreationTests {
    private WebDriver driver;

    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "/Users/bakhyt/Documents/GitHub/mac-java/addressbook-web-tests/browsers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        login("admin", "secret");
    }

    public void login(String username, String password) {
        driver.get("http://localhost/addressbook/index.php");
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void contactCreationTests() throws Exception {
        driver.get("http://localhost/addressbook/index.php");
        goToContactForm();
        fillContactForm(
                "John", "Robert",
                "Lennon", "Jerk",
                "Big Boss", "Kuderina street",
                "7777777", "5554433", "5553355",
                "5553434", "b-root@list.ru",
                "b-root@mail.ru", "b-root@gmail.com",
                "b.com", "13", "July", "1987");
        submitContactCreation();
        returnToHomePage();
    }

    public void returnToHomePage() {
        driver.findElement(By.linkText("home")).click();
    }

    public void submitContactCreation() {
        driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void fillContactForm(
            String firstname, String middlename,String lastname,
            String nickname, String company, String address,
            String home, String mobile, String work, String fax,
            String email, String email2, String email3,
            String homepage, String bday, String bmonth, String byear) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(firstname);
        driver.findElement(By.name("middlename")).clear();
        driver.findElement(By.name("middlename")).sendKeys(middlename);
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.name("nickname")).clear();
        driver.findElement(By.name("nickname")).sendKeys(nickname);
        driver.findElement(By.name("title")).click();
        driver.findElement(By.name("company")).click();
        driver.findElement(By.name("company")).clear();
        driver.findElement(By.name("company")).sendKeys(company);
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(address);
        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).clear();
        driver.findElement(By.name("home")).sendKeys(home);
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(mobile);
        driver.findElement(By.name("work")).click();
        driver.findElement(By.name("work")).clear();
        driver.findElement(By.name("work")).sendKeys(work);
        driver.findElement(By.name("fax")).click();
        driver.findElement(By.name("fax")).clear();
        driver.findElement(By.name("fax")).sendKeys(fax);
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("email2")).click();
        driver.findElement(By.name("email2")).clear();
        driver.findElement(By.name("email2")).sendKeys(email2);
        driver.findElement(By.name("email3")).clear();
        driver.findElement(By.name("email3")).sendKeys(email3);
        driver.findElement(By.name("homepage")).click();
        driver.findElement(By.name("homepage")).clear();
        driver.findElement(By.name("homepage")).sendKeys(homepage);
        driver.findElement(By.name("bday")).click();
        new Select(driver.findElement(By.name("bday"))).selectByVisibleText(bday);
        driver.findElement(By.name("bmonth")).click();
        new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(bmonth);
        driver.findElement(By.name("byear")).click();
        driver.findElement(By.name("byear")).clear();
        driver.findElement(By.name("byear")).sendKeys(byear);
    }

    public void goToContactForm() {
        driver.findElement(By.linkText("add new")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
