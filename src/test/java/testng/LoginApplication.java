package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class LoginApplication {
    public static void main(String[] args) {
       /* 1. Open a browser - -done
        2. Open URL - done
        3. Enter User Name - done
        4. Enter password - done
        5. Click on login button
*/
        //Open Browser
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();

        //open Login Page
        driver.get("https://opensource-demo.orangehrmlive.com");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Enter User name
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("Admin");

        //Enter password
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin123");

        //click on login button

        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

    }
}
