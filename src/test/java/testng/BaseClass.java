package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseClass {
    public WebDriver driver;
    public String applicationUrl = "https://opensource-demo.orangehrmlive.com";
    public String userName = "Admin";
    public String password = "admin123";

    public abstract String getPageTitle();

    public void clickBtn(WebElement elementBtn) {
        elementBtn.click();
    }


}
