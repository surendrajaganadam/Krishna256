package scripts.SeleniumFramework4X.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.LogStatus;

import scripts.SeleniumFramework4X.StepDefinition.ListenerImplementation;
import scripts.SeleniumFramework4X.Utilities.TestResultsUtils;

@Listeners(ListenerImplementation.class)
public class LoginPage {


	public static TestResultsUtils testResultUtilities = new TestResultsUtils();
	WebDriver driver;
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	private WebElement usernameTextField;
	
	@FindBy(id = "password")
	private WebElement passwordTextField;
	
	@FindBy(id = "login-button")
	private WebElement loginBttn;
	

	public void enterCrdentails() {
		try {
		usernameTextField.sendKeys("standard_user");
		passwordTextField.sendKeys("secret_sauce");
		String input=testResultUtilities.takescreenshot("shaila1");
		testResultUtilities.logger.log(LogStatus.PASS, "message" + input);
		}catch(Throwable e) {
			testResultUtilities.logger.log(LogStatus.FAIL, "unable to login to the app");	
		}
	}
	
	public void clickLoginBtn() {
		try {
		loginBttn.click();
		testResultUtilities.logger.log(LogStatus.PASS, "Clicked on login btn" );
		}catch(Throwable e) {
			testResultUtilities.logger.log(LogStatus.FAIL, "unable to click on login btn");	
		}
	}
	
	


}
