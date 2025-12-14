package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.LandingPage;
import Utils.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LandingPageSteps {

    WebDriver driver;
    LandingPage lp;

    String prodName;
    String offerProdName;

    @Given("User is on the landing page")
    public void landingPage() {
        driver = DriverFactory.getDriver();       // get existing driver initialized in Hooks
        lp = new LandingPage(driver);             // create page object now

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }

    @When("^User searched with shortname (.+) and extracted the name$")
    public void getName(String shortName) throws InterruptedException {
        prodName = lp.searchItem(shortName);
    }

    @When("^User navigates to offers page and get the product name (.+)$")
    public void topDealsPage(String shortName) {
        driver.findElement(By.linkText("Top Deals")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> i1 = windows.iterator();
        String parent = i1.next();
        String child = i1.next();
        driver.switchTo().window(child);
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
        offerProdName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText().trim();
    }

    @Then("Verify the prod name and offer name matches")
    public void verifyNames() {
        Assert.assertEquals(offerProdName, prodName);
    }
}
