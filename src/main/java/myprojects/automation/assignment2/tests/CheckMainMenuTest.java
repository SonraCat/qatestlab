package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckMainMenuTest extends BaseScript {

    public static void main(String[] args) {
        WebDriver driver = getDriver();

        authenticate(driver);

        By[] locators = {
                By.id("tab-AdminDashboard"),
                By.id("subtab-AdminParentOrders"),
                // Id is not stable for "Каталог" tab
                By.cssSelector("[data-submenu=\"9\"]"),
                // Id is not stable for "Клиенты" tab
                By.cssSelector("[data-submenu=\"23\"]"),
                By.id("subtab-AdminParentCustomerThreads"),
                By.id("subtab-AdminStats"),
                By.cssSelector("[data-submenu=\"42\"]"),
                // Id is not stable for "Design" tab
                By.cssSelector("[data-submenu=\"46\"]"),
                By.id("subtab-AdminParentShipping"),
                By.id("subtab-AdminParentPayment"),
                By.id("subtab-AdminInternational"),
                By.id("subtab-ShopParameters"),
                By.id("subtab-AdminAdvancedParameters"),
                By.className("menu-collapse")
        };

        for (By locator : locators) {
            testSubmenu(driver, locator);
        }

        driver.quit();
    }

    private static void testSubmenu(WebDriver driver, By locator) {
        WebElement tab = driver.findElement(locator);
        // Save a submenu title before refresh
        String submenuTitle = tab.getText();
        // Print a submenu title
        System.out.print(submenuTitle);
        tab.click();

        driver.navigate().refresh();
        // Wait for refresh
        timeout(2000);
        tab = driver.findElement(locator);
        // Check that the page title start from the submenu title
        System.out.println(" " + tab.getText().equals(submenuTitle));
    }
}
