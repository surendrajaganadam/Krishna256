package scripts.SeleniumFramework4X.StepDefinition;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import scripts.SeleniumFramework4X.config.SeleniumNGSuite;
import scripts.SeleniumFramework4X.config.LocalDriverManager;
import scripts.SeleniumFramework4X.PageObjects.LoginPage;

@Listeners(ListenerImplementation.class)
public class LoginPageStepDefiniton {
	
	public String scenarioName;
	Scenario sce;
	
	@BeforeMethod
	@Before()
	public void beforeHook(Scenario scenario) throws Throwable {
		this.sce = scenario;
		scenarioName = scenario.getName();
		System.out.println("scenario name is : " +scenarioName);
		LoginPage.testResultUtilities.logger.log(LogStatus.PASS, "Started Execution for scenario:: "+scenarioName);
	}

	@AfterMethod
	public void afterHook() throws Throwable{
		LoginPage.testResultUtilities.logger.log(LogStatus.PASS, "Execution Completed for scenario:: "+scenarioName);		
		scenarioName = null;
	}
	
@Given("I want to write a step with precondition")
public void i_want_to_write_a_step_with_precondition() throws Throwable {
	System.out.println("successfullly launched app");
	SeleniumNGSuite instance = new SeleniumNGSuite();
	instance.setUpSuite();
	
	
	instanceLoginPage().enterCrdentails();
	instanceLoginPage().clickLoginBtn();

}



private LoginPage instanceLoginPage() {
	LoginPage ap = new LoginPage(LocalDriverManager.getDriver());
	return ap;
}

}

