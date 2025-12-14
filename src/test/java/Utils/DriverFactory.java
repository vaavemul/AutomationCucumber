package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	 private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	 
	 public static WebDriver getDriver() {
	        return driver.get();
	    }
   
    private static Properties prop;

    static {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\GlobalData.properties"
            );
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initDriver() {
    	ChromeOptions options = new ChromeOptions();
        driver.set(new ChromeDriver(options)); // Each thread gets its OWN driver
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();   // Quit ONLY the driver of this thread
            driver.remove();       // Remove from thread
        }
    
    }
}
