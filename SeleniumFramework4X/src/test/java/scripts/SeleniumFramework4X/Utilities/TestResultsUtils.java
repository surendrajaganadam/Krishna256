package scripts.SeleniumFramework4X.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import scripts.SeleniumFramework4X.config.SeleniumNGSuite;
import scripts.SeleniumFramework4X.config.DriverConfig;
import scripts.SeleniumFramework4X.config.LocalDriverManager;
import scripts.SeleniumFramework4X.Constants.Constants;
import scripts.SeleniumFramework4X.Exceptions.AutomationException;


/**
 * The Class TestResultsUtils.
 */
public class TestResultsUtils {

	/** The sub dir name. */
	public static String subDirName;

	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(TestResultsUtils.class);

	/** The screenshot dir. */
	public static String screenshotDir;

	/** The base project path. */
	public static String baseProjectPath = System.getProperty(Constants.USER_DIR);

	/** The execution start time. */
	public static String executionStartTime;

	/** The execution start date. */
	public static String executionStartDate;

	/** The browser directory. */
	public static String browserDirectory;

	/** The date directory. */
	public static String dateDirectory;

	/** The timestamp directory. */
	public static String timestampDirectory;

	/** The screenshot directory. */
	public static String screenshotDirectory;

	/** The extent report directory. */
	public static String extentReportDirectory;

	/** The log directory. */
	public static String logDirectory;

	/** The zapi directory. */
	public static String zapiDirectory;

	/** The log file path. */
	public static String logFilePath;

	/** The zapi results file path. */
	public static String zapiResultsFilePath;

	/** The excel directory. */
	public static String excelDirectory;

	/** The excel file path. */
	public static String excelFilePath;
	
	public static ExtentReports extent;

	public static ExtentTest logger;

	/**
	 * willc reate folder structure for us like : 
	 * 	browsername
	 * 			date
	 * 				time
	 * 					report, log, screenshots
	 */
	public static void outputFolder() throws AutomationException {
		try {

			if (null == executionStartDate) {
				Date curDate = new Date();
				SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT_YYYY_MM_DD);
				String DateToStr = format.format(curDate);
				format = new SimpleDateFormat(Constants.TIME_STAMP_FORMAT_DD_MM_YYYY_HH_MM_SS);
				DateToStr = format.format(curDate);
				System.out.println("Complete Date is ::" + DateToStr);
				executionStartDate = DateToStr.substring(0, 10);
				System.out.println("Date is ::" + executionStartDate);
				executionStartTime = DateToStr.substring(11, 19);
				System.out.println(executionStartTime);
				executionStartTime = executionStartTime.replace(Constants.SPACE.charAt(0), Constants.HYPHEN.charAt(0));
				System.out.println(executionStartTime);
				String baseDirectory = DriverConfig.baseProjectPath.concat(Constants.DOUBLE_FORWARD_SLASH)
						.concat(Constants.TEST_RESULTS);
				if (null != baseDirectory) {
					browserDirectory = baseDirectory.concat(Constants.DOUBLE_FORWARD_SLASH)
							.concat(SeleniumNGSuite.browserType);
					System.out.println("browser directory is directoryName" + browserDirectory);
					DCTUtils.createDirTree(browserDirectory);

					if (null != browserDirectory) {
						// creating date folder
						dateDirectory = browserDirectory.concat(Constants.DOUBLE_FORWARD_SLASH)
								.concat(executionStartDate);
						System.out.println("dateDirectory directory is directoryName" + dateDirectory);
						DCTUtils.createDirTree(dateDirectory);
						if (null != dateDirectory) {
							// creating time stamp folder
							timestampDirectory = dateDirectory.concat(Constants.DOUBLE_FORWARD_SLASH)
									.concat(executionStartTime);
							System.out.println("timestamp directory is directoryName" + timestampDirectory);
							DCTUtils.createDirTree(timestampDirectory);
							if (null != timestampDirectory) {
								// creating screenshot folder
								screenshotDirectory = timestampDirectory.concat(Constants.DOUBLE_FORWARD_SLASH)
										.concat(Constants.SCREENSHOTS);
								System.out.println("screenshot directory is directoryName" + screenshotDirectory);
								DCTUtils.createDirTree(screenshotDirectory);

								// creating extentReportDirectory folder
								extentReportDirectory = timestampDirectory.concat(Constants.DOUBLE_FORWARD_SLASH)
										.concat(Constants.EXTENT_REPORT);
								System.out.println(
										"extent report dir directory is directoryName" + extentReportDirectory);
								DCTUtils.createDirTree(extentReportDirectory);

								// creating extentReportDirectory folder
								logDirectory = timestampDirectory.concat(Constants.DOUBLE_FORWARD_SLASH)
										.concat(Constants.LOGS);
								System.out.println("log directory is directoryName" + logDirectory);
								DCTUtils.createDirTree(logDirectory);
								if (null != logDirectory) {
									// Creating log file
									logFilePath = logDirectory.concat(Constants.DOUBLE_FORWARD_SLASH)
											.concat(Constants.LOG_FILE_NAME);
									System.out.println("log file name is ::" + logFilePath);
									DCTUtils.createNewFile(logFilePath);
									try {
										Properties properties = new Properties();
										InputStream configStream = new FileInputStream(
												baseProjectPath.concat(Constants.LOG4J_FILE_PATH));
										properties.load(configStream);
										configStream.close();
										properties.setProperty("log4j.appender.R.File", logFilePath);
										LogManager.resetConfiguration();
										PropertyConfigurator.configure(properties);

									} catch (Exception exception) {
										System.out.println("Error in finding the log file::" + exception.getMessage());
									}


								
							}
						}
					}
				}
			}
		} 
		}
			catch (

		Exception exception) {
			System.out.println("Error occured while creating files and directories" + exception.getMessage());
			throw new AutomationException(exception);
		}

	}
	
/*	public String takescreenshot(String scenario) throws Exception {
		try {
			String startedAt = "";
			String screenshotPath = "";	
	File srcfile = ((TakesScreenshot) LocalDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcfile, new File(TestResultsUtils.screenshotDirectory + "/sc-" + scenario + startedAt + ".png"));
	screenshotPath = TestResultsUtils.screenshotDirectory + "/sc-" + scenario + startedAt + ".png";			return screenshotPath;
		} catch (Exception exception) {
throw new AutomationException(exception);
	}	
		}
	*/
	public String takescreenshot(String scenario) throws Exception {
		try {
			String startedAt = "";
			String screenshotPath = "";	
			String encodedBase64 = null;
			FileInputStream fisreader = null;
	File srcfile = ((TakesScreenshot) LocalDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
	fisreader = new FileInputStream(srcfile);
	byte[] bytes = new byte[(int)srcfile.length()];
	fisreader.read(bytes);
	encodedBase64 = new String(Base64.encodeBase64(bytes));
	
		return "data:image/png;base64,"+encodedBase64;
		} catch (Exception exception) {
throw new AutomationException(exception);
	}	
		}
	
	public static void extentReportInitialize() throws AutomationException {
		try {
			String extentReport = extentReportDirectory + "/" + "ExtentReport.html";
			LocalTestDataManager.setExtentReportPath(extentReport);
			System.out.println("extentReport" + extentReport);
			extent = new ExtentReports(extentReport, false);
		} catch (Exception exception) {

		}
	}

	public static void extentReportFlush() throws AutomationException {
		try {
			extent.endTest(logger);
			extent.flush();
			extent.close();
		} catch (Exception exception) {

		}
	}


}