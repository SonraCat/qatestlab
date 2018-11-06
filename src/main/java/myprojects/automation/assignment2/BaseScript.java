package myprojects.automation.assignment2;

import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     *
     * @return New instance of {@link WebDriver} object.
     */
    protected static WebDriver getDriver() {
        // Do not forget uncomment it for Windows
        // System.setProperty("webdriver.chrome.driver", System.clearProperty("user.dir") + "//resources//chromedriver.exe ");
        return new ChromeDriver();
    }

    /**
     * Authenticate the test user to the admin tool
     */
    protected static void authenticate(WebDriver driver) throws InterruptedException {
        driver.get(Properties.getBaseAdminUrl());
        // Type the email as a login
        WebElement loginInput = driver.findElement(By.id("email"));
        loginInput.sendKeys(Properties.getLogin());
        // Type the password
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys(Properties.getPassword());
        // Submit the login form
        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        submitButton.click();
        // Wait enough for an authentication step
        Thread.sleep(5000);
    }

}
