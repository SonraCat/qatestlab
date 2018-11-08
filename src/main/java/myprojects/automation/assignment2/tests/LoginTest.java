package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseScript {

    public static void main(String[] args) {
        WebDriver driver = getDriver();
        // Test of the authentication process
        authenticate(driver);

        System.out.println(driver.getTitle().contains("Dashboard"));

        WebElement employeeDropdown = driver.findElement(By.className("imgm"));
        employeeDropdown.click();

        timeout(1000);

        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();

        timeout(5000);

        driver.quit();
    }


}
