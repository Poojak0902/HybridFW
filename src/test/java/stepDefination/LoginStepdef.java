package stepDefination;

import org.junit.Assert;

import com.PageActions.LoginActions;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdef {
	static String actualtitel;
	private LoginActions login = new LoginActions(DriverFactory.getdriver());
	
	@Given("user is on Landing page")
	public void user_is_on_landing_page() {
		DriverFactory.getdriver().get("https://www.facebook.com/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}

	@When("user gets the title of page")
	public void user_gets_the_title_of_page() {
		actualtitel=login.gettitle();
		System.out.println(actualtitel);
	   
	}

	@Then("user validates the title of the page {string}")
	public void user_validates_the_title_of_the_page(String expected) {
		Assert.assertEquals(expected, actualtitel);
	  
	}

	@Then("user valdates that Create new account button is enabled and visible")
	public void user_valdates_that_create_new_account_button_is_enabled_and_visible() {
		Assert.assertTrue("Create Account link is not enabled ",login.createnewAccountlinkenabled());
	    
	}

}
