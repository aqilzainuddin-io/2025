package setup;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initializeDriver() {

        if (driver == null) {

            ChromeOptions options = new ChromeOptions();

            // Set Chrome preferences to disable password manager popups
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.password_manager_leak_detection", false); 
            prefs.put("credentials_enable_service", false); 
            options.setExperimentalOption("prefs", prefs);

            if ("true".equalsIgnoreCase(EnvReader.get("HEADLESS"))) {
                options.addArguments("--headless=new");
            }

            driver = new ChromeDriver(options);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; 
        }
    }
}