package seleniumfeatures;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class FindElements {
    public static void main(String[] args) {
        //Open Browser
        WebDriverManager.firefoxdriver().clearDriverCache().setup();
        WebDriver driver = new FirefoxDriver();

        //open Login Page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //wait for 3 second -- implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        List<WebElement> elements = driver.findElements(By.tagName("a"));
//        System.out.println("Links are: " + elements.toString());
        for (int i=0; i<elements.size();i++){
            System.out.println("Link Texts:" + elements.get(i).getText());
        }
    }
}
