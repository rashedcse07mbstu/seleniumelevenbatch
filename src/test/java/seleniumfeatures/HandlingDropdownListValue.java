package seleniumfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HandlingDropdownListValue {
    public static void main(String[] args) {
        //Open Browser
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();

        //open Login Page
        driver.get("https://demoqa.com/select-menu");

        //wait for 3 second -- implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Selecting value from drop down list
//        Select select = new Select(WebElement webelement);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        WebElement element = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(element);
        select.selectByIndex(2);
//        select.selectByValue("red");
//        select.selectByVisibleText("Red");
    }
}
