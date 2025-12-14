package stepDefinitions;  // same package as your step definitions

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;

public class Hooks {

    WebDriver driver;

    @Before
    public void setUp() {
        DriverFactory.initDriver();      // Only ONE call
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();               // Closes one browser
    }
    
    @AfterStep
    public void takeScreenshot(Scenario scenario) throws IOException {
    	if(scenario.isFailed()) {
    		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		byte[] fileContent = FileUtils.readFileToByteArray(src);
    		scenario.attach(fileContent, "image/png", "image");
    		
    	}
    }
}



