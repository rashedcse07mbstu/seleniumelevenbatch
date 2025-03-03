package seleniumfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RadioButtonHandling {

    public static void main(String[] args) {
        //Open Browser
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();

        //open Login Page
        driver.get("https://demo.guru99.com/test/radio.html");

        //wait for 3 second -- implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Select Radio button option
        boolean isAvailableElement = driver.findElement(By.id("vfb-7-1")).isDisplayed();
        System.out.println("Is element available: " + isAvailableElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vfb-7-1")));
        driver.findElement(By.id("vfb-7-1")).click();

        //Select Checkbox option
        boolean isSelectedElement = driver.findElement(By.id("vfb-6-0")).isSelected();
        System.out.println("Is Selected available: " + isSelectedElement);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("vfb-6-0")));

        if (!isSelectedElement) {
            driver.findElement(By.id("vfb-6-0")).click();
        }

    }

}
