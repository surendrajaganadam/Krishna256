package scripts.SeleniumFramework4X.StepDefinition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import scripts.SeleniumFramework4X.Exceptions.AutomationException;
import scripts.SeleniumFramework4X.Utilities.LocalTestDataManager;
import scripts.SeleniumFramework4X.Utilities.TestResultsUtils;
import scripts.SeleniumFramework4X.config.SeleniumNGSuite;

public class ListenerImplementation implements ITestListener{
	
	TestResultsUtils testResultUtils = new TestResultsUtils(); 
	private static final Logger LOG = LoggerFactory.getLogger(LoginPageStepDefiniton.class);
	
	@Override
	public void onStart(ITestContext Result) {
		try {
			TestResultsUtils.outputFolder();
		} catch (AutomationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult Result) {
		try {
			TestResultsUtils.extentReportInitialize();
			testResultUtils.logger = testResultUtils.extent.startTest(LocalTestDataManager.getFeaturename());
			LOG.info("in before step", LocalTestDataManager.getScenarioname());
		} catch (AutomationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void onTestFailure(ITestResult Result) {
		
		try {
			LOG.info("in before step", LocalTestDataManager.getScenarioStatus());
			testResultUtils.extentReportFlush();
			SeleniumNGSuite.tearDown();
		} catch (AutomationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void onTestSuccess(ITestResult Result) {
		
		try {
			LOG.info("in before step", LocalTestDataManager.getScenarioStatus());
			testResultUtils.extentReportFlush();
			SeleniumNGSuite.tearDown();
		} catch (AutomationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void onTestSkipped(ITestResult Result) {
		
		try {
			LOG.info("in before step", LocalTestDataManager.getScenarioStatus());
			testResultUtils.extentReportFlush();
			SeleniumNGSuite.tearDown();
		} catch (AutomationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
