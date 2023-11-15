package scripts.SeleniumFramework4X.config;



import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import scripts.SeleniumFramework4X.Constants.Constants;
import scripts.SeleniumFramework4X.Exceptions.AutomationException;
import scripts.SeleniumFramework4X.Utilities.PropertyUtils;


/**
 * The Class DriverConfig.
 *
 */
public class DriverConfig {

	/** The base project path. */
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);
	
	/** The configprops. */
	public static PropertyUtils configprops = new PropertyUtils(baseProjectPath.concat(Constants.CONFIG_PROPERTY));

	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(DriverConfig.class);
	
	public static File folder;
	
	public DesiredCapabilities capabilities = new DesiredCapabilities();
	
	public WebDriver driver ;
	
	/**
	 * This method returns the driver object for the given browser type with the
	 * page loaded with the given url.
	 *
	 * @param browserType
	 *   the browser type
	 * @param url
	 *   the url
	 * @throws Throwable
	 *    the throwable
	 */


	public void setup(String browserName, String applicaionURL) throws Throwable {
		try {
			switch(browserName) {
			case "chrome":
//				System.setProperty("webdriver.chrome.driver", "");
				driver= new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			}
			LocalDriverManager.setWebDriver(driver);
			LocalDriverManager.getDriver().manage().window().maximize();
			LocalDriverManager.getDriver().get(applicaionURL);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}



}
