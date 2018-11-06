package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckMainMenuTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver();

        authenticate(driver);

        testSubmenu(driver, By.id("tab-AdminDashboard"));
        testSubmenu(driver, By.id("subtab-AdminParentOrders"));
        testSubmenu(driver, By.id("subtab-AdminCatalog"));
        // Id is not stable for "Клиенты" tab
        testSubmenu(driver, By.cssSelector("[data-submenu=\"23\"]"));
        testSubmenu(driver, By.id("subtab-AdminParentCustomerThreads"));
        testSubmenu(driver, By.id("subtab-AdminStats"));
        testSubmenu(driver, By.id("subtab-AdminParentModulesSf"));
        // Id is not stable for "Design" tab
        testSubmenu(driver, By.cssSelector("[data-submenu=\"46\"]"));
        testSubmenu(driver, By.id("subtab-AdminParentShipping"));
        testSubmenu(driver, By.id("subtab-AdminParentPayment"));
        testSubmenu(driver, By.id("subtab-AdminInternational"));
        testSubmenu(driver, By.id("subtab-ShopParameters"));
        testSubmenu(driver, By.id("subtab-AdminAdvancedParameters"));
        testSubmenu(driver, By.className("menu-collapse"));

        driver.quit();
    }

    private static void testSubmenu(WebDriver driver, By locator) throws InterruptedException {
        WebElement tab = driver.findElement(locator);
        // Print a submenu title
        System.out.println(tab.getText());
        tab.click();

        // Save URL before refresh
        String urlBeforeRefresh = driver.getCurrentUrl();
        driver.navigate().refresh();
        // Wait for refresh
        Thread.sleep(3000);
        // Check that URL after does not change
        System.out.print(" " + driver.getCurrentUrl().equals(urlBeforeRefresh));
    }
}
