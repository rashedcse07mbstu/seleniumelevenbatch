package seleniumfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserNavigation {
    public static void main(String[] args) throws InterruptedException {
        //Open Browser
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();

        //open Login Page
        driver.navigate().to("https://www.selenium.dev");
        //wait for 3 second -- implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

//        driver.findElement(By.linkText("Documentation")).click();

        driver.findElement(By.partialLinkText("Doc")).click();



        /*driver.navigate().refresh();
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();*/
        //driver.get("https://www.linkedin.com/events/seleniumcommunitylive-episode37288096807144894464/");
        Thread.sleep(5000);
        driver.quit();

    }
}
