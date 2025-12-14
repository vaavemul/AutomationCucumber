package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainSteps {
	
	@Given("User is on NetBanking Landing page")
	public void user_is_on_net_banking_landing_page() {
	    System.out.print("User is on netbanking page");
	}
	@When("^User logs into application with (.+) and (.+)$")
	public void user_logs_into_application(String uname, String pwd) {
		System.out.print(uname+"and password is"+pwd);
	}
	@Then("Homepage is displayed")
	public void homepage_is_displayed() {
		System.out.print("Homepage is displayed");
	}

}
