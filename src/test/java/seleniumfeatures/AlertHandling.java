package seleniumfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class AlertHandling {
    public static void main(String[] args) {
        //Open Browser
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();

        //open Login Page
        driver.get("https://demoqa.com/alerts");

        //wait for 3 second -- implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        driver.findElement(By.id("alertButton")).click();
//        driver.switchTo().alert().accept();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Object o = js.executeScript("window.scrollBy(0,250)", "");

        driver.findElement(By.id("promtButton")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Shaila Apu");
        alert.accept();

        WebElement promptResult =driver.findElement(By.id("promptResult"));
        promptResult.getText();

        System.out.println("prompt Result text is" + promptResult);


    }
}
