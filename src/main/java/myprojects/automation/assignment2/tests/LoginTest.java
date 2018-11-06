package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver();
        // Test of the authentication process
        authenticate(driver);

        System.out.println(driver.getTitle().contains("Dashboard"));

        driver.quit();
    }


}
