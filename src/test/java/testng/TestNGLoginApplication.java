package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNGLoginApplication extends BaseClass {
     /* 1. Open a browser - -e
        2. Open URL -
        3. Enter User Name -
        4. Enter password -
        5. Click on login button
        6. Check page title after login
     */

    WebElement userEle = driver.findElement(By.name("username"));
    WebElement passEle = driver.findElement(By.name("password"));
    WebElement eleBtn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));

    @BeforeMethod
    public void setUp() {
        //Open Browser
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        driver = new FirefoxDriver();

        //open Login Page
        driver.get("https://opensource-demo.orangehrmlive.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void loginApplication() {
        //Enter User name
        userEle.clear();
        userEle.sendKeys("Admin");

        //Enter password
        passEle.clear();
        passEle.sendKeys("admin123");

        //click on login button
        clickBtn(eleBtn);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }

    @Test
    public void verifyLoginPageTitle() {
        //Enter User name
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("Admin");

        //Enter password
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin123");

        //click on login button
        clickBtn(eleBtn);

        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        String expectedPageTitle = driver.getTitle();
        String actualPageTitle = getPageTitle();

        //Assertion
        Assert.assertEquals(expectedPageTitle, actualPageTitle);

        Assert.assertTrue(Boolean.parseBoolean(expectedPageTitle));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }
}
