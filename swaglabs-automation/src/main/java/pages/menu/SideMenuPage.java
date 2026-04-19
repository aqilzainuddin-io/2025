package pages.menu;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.base.BasePage;

public class SideMenuPage extends BasePage {
    
    private By menuButton = By.id("react-burger-menu-btn");
    private By allItemsLink = By.id("inventory_sidebar_link");
    private By logoutLink = By.id("logout_sidebar_link");

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickMenuButton() {
        click(menuButton);
    }

    public boolean isMenuButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(menuButton));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean isAllItemsLinkVisible() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(allItemsLink));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public boolean isLogoutLinkVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void clickAllItemsLink() {
        click(allItemsLink);
    }
    public void clickLogoutLink() {
        click(logoutLink);
    }

}
