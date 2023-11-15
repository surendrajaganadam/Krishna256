package scripts.SeleniumFramework4X.Utilities;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * The Class LocalDriverManager.
 *
 * 
 */
public class LocalTestDataManager {

	/** The testdatahashmap. */
	private static ThreadLocal<HashMap<String, String>> testdatahashmap = new ThreadLocal<HashMap<String, String>>();

	/** The scenarioname. */
	private static ThreadLocal<String> scenarioname = new ThreadLocal<String>();
	
	/** The ExtentReportPath. */
	private static ThreadLocal<String> extentReportPath = new ThreadLocal<String>();
	
private static ThreadLocal<Boolean> isGalenScenario = new ThreadLocal<Boolean>();
	
	private static ThreadLocal<String> testingDevice = new ThreadLocal<String>();
	
	public static String getTestingDevice(){
		return testingDevice.get();
	}
	
	public static void setTestingDevice(String testingondevice){
		testingDevice.set(testingondevice);
	}
	
	public static Boolean getIsGalenScenario(){
		return isGalenScenario.get();
	}
	
	public static void setIsGalenScenario(Boolean isGalen){
		isGalenScenario.set(isGalen);
	} 


	/**
	 * Gets the scenarioname.
	 *
	 * @return the scenarioname
	 */
	public static String getScenarioname() {
		return scenarioname.get();
	}

	/**
	 * Sets the scenarioname.
	 *
	 * @param scenname
	 *            the new scenarioname
	 */
	public static void setScenarioname(String scenname) {
		scenarioname.set(scenname);
	}

	/** The featurename. */
	private static ThreadLocal<String> featurename = new ThreadLocal<String>();

	/**
	 * Gets the featurename.
	 *
	 * @return the featurename
	 */
	public static String getFeaturename() {
		return featurename.get();
	}

	/**
	 * Sets the featurename.
	 *
	 * @param nameFeature
	 *            the new featurename
	 */
	public static void setFeaturename(String nameFeature) {
		featurename.set(nameFeature);
	}

	/** The step number. */
	private static ThreadLocal<Integer> stepNumber = new ThreadLocal<Integer>();

	/**
	 * Gets the step number.
	 *
	 * @return the step number
	 */
	public static Integer getStepNumber() {
		return stepNumber.get();
	}

	/**
	 * Sets the step number.
	 *
	 * @param numberStep
	 *            the new step number
	 */
	public static void setStepNumber(Integer numberStep) {
		stepNumber.set(numberStep);
	}

	/** The current zephyr scenario id. */
	private static ThreadLocal<Integer> currentZephyrScenarioId = new ThreadLocal<Integer>();

	/**
	 * Gets the current zephyr scenario id.
	 *
	 * @return the current zephyr scenario id
	 */
	public static Integer getCurrentZephyrScenarioId() {
		return currentZephyrScenarioId.get();
	}

	/**
	 * Sets the current zephyr scenario id.
	 *
	 * @param _currentZephyrScenarioId
	 *            the new current zephyr scenario id
	 */
	public static void setCurrentZephyrScenarioId(Integer _currentZephyrScenarioId) {
		currentZephyrScenarioId.set(_currentZephyrScenarioId);
	}

	/** The current zephyr scenario issue id. */
	private static ThreadLocal<Integer> currentZephyrScenarioIssueId = new ThreadLocal<Integer>();

	/**
	 * Gets the current zephyr scenario id.
	 *
	 * @return the current zephyr scenario id
	 */
	public static Integer getCurrentZephyrScenarioIssueId() {
		return currentZephyrScenarioIssueId.get();
	}

	/**
	 * Sets the current zephyr scenario id.
	 *
	 * @param _currentZephyrScenarioIssueId
	 *            the new current zephyr scenario issue id
	 */
	public static void setCurrentZephyrScenarioIssueId(Integer _currentZephyrScenarioIssueId) {
		currentZephyrScenarioIssueId.set(_currentZephyrScenarioIssueId);
	}

	/** The current zephyr step id. */
	private static ThreadLocal<Integer> currentZephyrStepId = new ThreadLocal<Integer>();

	/**
	 * Gets the current zephyr step id.
	 *
	 * @return the current zephyr step id
	 */
	public static Integer getCurrentZephyrStepId() {
		return currentZephyrStepId.get();
	}

	/**
	 * Sets the current zephyr step id.
	 *
	 * @param _currentZephyrStepId
	 *            the new current zephyr step id
	 */
	public static void setCurrentZephyrStepId(Integer _currentZephyrStepId) {
		currentZephyrStepId.set(_currentZephyrStepId);
	}

	/** The scenario status. */
	private static ThreadLocal<String> scenarioStatus = new ThreadLocal<String>();

	/**
	 * Gets the scenario status.
	 *
	 * @return the scenario status
	 */
	public static String getScenarioStatus() {
		return scenarioStatus.get();
	}

	/**
	 * Sets the scenario status.
	 *
	 * @param statusScenario
	 *            the new scenario status
	 */
	public static void setScenarioStatus(String statusScenario) {
		scenarioStatus.set(statusScenario);
	}

	/** The iscurrent step definition having nesting. */
	private static ThreadLocal<Boolean> iscurrentStepDefinitionHavingNesting = new ThreadLocal<Boolean>();

	/**
	 * Gets the iscurrent step definition having nesting.
	 *
	 * @return the iscurrent step definition having nesting
	 */
	public static Boolean getIscurrentStepDefinitionHavingNesting() {
		return iscurrentStepDefinitionHavingNesting.get();
	}

	/**
	 * Sets the iscurrent step definition having nesting.
	 *
	 * @param _iscurrentStepDefinitionHavingNesting
	 *            the new iscurrent step definition having nesting
	 */
	public static void setIscurrentStepDefinitionHavingNesting(Boolean _iscurrentStepDefinitionHavingNesting) {
		iscurrentStepDefinitionHavingNesting.set(_iscurrentStepDefinitionHavingNesting);
	}

	/**
	 * Gets the test data hash map.
	 *
	 * @return the test data hash map
	 */
	public static HashMap<String, String> getTestDataHashMap() {
		return testdatahashmap.get();
	}

	/**
	 * Sets the test data hash map.
	 *
	 * @param data
	 *            the data
	 */
	static void setTestDataHashMap(HashMap<String, String> data) {
		testdatahashmap.set(data);
	}

	/** The scenario ID. */
	private static ThreadLocal<String> scenarioID = new ThreadLocal<String>();

	/**
	 * Gets the scenario ID.
	 *
	 * @return the scenario ID
	 */
	public static String getScenarioID() {
		return scenarioID.get();
	}

	/**
	 * Sets the scenario ID.
	 *
	 * @param idScenario
	 *            the new scenario ID
	 */
	public static void setScenarioID(String idScenario) {
		scenarioID.set(idScenario);
	}

	/** The exec result set. */
	private static ThreadLocal<HashMap<String, Integer>> execResultSet = new ThreadLocal<HashMap<String, Integer>>();

	/**
	 * Gets the exec result set.
	 *
	 * @return the exec result set
	 */
	public static HashMap<String, Integer> getExecResultSet() {
		return execResultSet.get();
	}

	/**
	 * Sets the exec result set.
	 *
	 * @param data
	 *            the data
	 */
	static void setExecResultSet(HashMap<String, Integer> data) {
		execResultSet.set(data);
	}

	/** The exec result set pojo. */
	private static ThreadLocal<HashMap<String, Execution>> execResultSetPojo = new ThreadLocal<HashMap<String, Execution>>();

	/**
	 * Gets the exec result set pojo.
	 *
	 * @return the exec result set pojo
	 */
	public static HashMap<String, Execution> getExecResultSetPojo() {
		return execResultSetPojo.get();
	}

	/**
	 * Sets the exec result set pojo.
	 *
	 * @param data
	 *            the data
	 */
	static void setExecResultSetPojo(HashMap<String, Execution> data) {
		execResultSetPojo.set(data);
	}

	/** The step result set. */
	private static ThreadLocal<HashMap<Integer, Integer>> stepResultSet = new ThreadLocal<HashMap<Integer, Integer>>();

	/**
	 * Gets the step result set.
	 *
	 * @return the step result set
	 */
	public static HashMap<Integer, Integer> getStepResultSet() {
		return stepResultSet.get();
	}

	/**
	 * Sets the step result set.
	 *
	 * @param _stepResultSet
	 *            the step result set
	 */
	static void setStepResultSet(HashMap<Integer, Integer> _stepResultSet) {
		stepResultSet.set(_stepResultSet);
	}

	/** The Stepi order id and issue id result set. */
	private static ThreadLocal<HashMap<Integer, Integer>> StepiOrderIdAndIssueIdResultSet = new ThreadLocal<HashMap<Integer, Integer>>();

	/**
	 * Gets the stepi order id and issue id result set.
	 *
	 * @return the stepi order id and issue id result set
	 */
	public static HashMap<Integer, Integer> getStepiOrderIdAndIssueIdResultSet() {
		return StepiOrderIdAndIssueIdResultSet.get();
	}

	/**
	 * Sets the stepi order id and issue id result set.
	 *
	 * @param _stepResultSet
	 *            the step result set
	 */
	static void setStepiOrderIdAndIssueIdResultSet(HashMap<Integer, Integer> _stepResultSet) {
		StepiOrderIdAndIssueIdResultSet.set(_stepResultSet);
	}

	/** The cart. */

	/**
	 * Gets the cart.
	 *
	 * @return the cart
	 */


	/** The current product no. */
	private static ThreadLocal<String> currentProductNo = new ThreadLocal<String>();

	/**
	 * Gets the current product no.
	 *
	 * @return the current product no
	 */
	public static String getCurrentProductNo() {
		return currentProductNo.get();
	}

	/**
	 * Sets the current product no.
	 *
	 * @param _currentProductNo
	 *            the new current product no
	 */
	public static void setCurrentProductNo(String _currentProductNo) {
		currentProductNo.set(_currentProductNo);
	}

	/** The list. */

	private static ThreadLocal<ArrayList<String>> excelOutputList = new ThreadLocal<ArrayList<String>>();

	/**
	 * Gets the excel output list.
	 *
	 * @return the excel output list
	 */
	public static ArrayList<String> getExcelOutputList() {
		return excelOutputList.get();
	}

	/**
	 * Sets the excel output list.
	 *
	 * @param _currentProductNo
	 *            the new excel output list
	 */
	public static void setExcelOutputList(ArrayList<String> _currentProductNo) {
		excelOutputList.set(_currentProductNo);

	}

	/** The output. */
	private static ThreadLocal<BufferedWriter> output = new ThreadLocal<BufferedWriter>();

	/**
	 * Gets the output.
	 *
	 * @return the output
	 */
	public static BufferedWriter getOutput() {
		return output.get();
	}

	/**
	 * Sets the output.
	 *
	 * @param _output
	 *            the new output
	 */
	public static void setOutput(BufferedWriter _output) {
		output.set(_output);
	}

	/** The output. */
	private static ThreadLocal<FileOutputStream> fout = new ThreadLocal<FileOutputStream>();

	/**
	 * Gets the fout.
	 *
	 * @return the fout
	 */
	public static FileOutputStream getFout() {
		return fout.get();
	}

	/**
	 * Sets the fout.
	 *
	 * @param _fout
	 *            the new fout
	 */
	public static void setFout(FileOutputStream _fout) {
		fout.set(_fout);
	}

	/** The fullmap. */
	private static ThreadLocal<HashMap<String, ArrayList<String>>> fullmap = new ThreadLocal<HashMap<String, ArrayList<String>>>();

	/**
	 * Gets the fullmap.
	 *
	 * @return the fullmap
	 */
	public static HashMap<String, ArrayList<String>> getFullmap() {
		return fullmap.get();
	}

	/**
	 * Sets the fullmap.
	 *
	 * @param _fullmap
	 *            the fullmap
	 */
	public static void setFullmap(HashMap<String, ArrayList<String>> _fullmap) {
		fullmap.set(_fullmap);

	}

	/** The finalmap. */
	private static ThreadLocal<HashMap<String, ArrayList<String>>> finalmap = new ThreadLocal<HashMap<String, ArrayList<String>>>();

	/**
	 * Gets the finalmap.
	 *
	 * @return the finalmap
	 */
	public static HashMap<String, ArrayList<String>> getFinalmap() {
		return finalmap.get();
	}

	/**
	 * Sets the finalmap.
	 *
	 * @param _finalmap
	 *            the finalmap
	 */
	public static void setFinalmap(HashMap<String, ArrayList<String>> _finalmap) {
		finalmap.set(_finalmap);

	}

	/** The workbook. */

	private static ThreadLocal<XSSFWorkbook> workbook = new ThreadLocal<XSSFWorkbook>();

	/**
	 * Gets the workbook.
	 *
	 * @return the workbook
	 */
	public static XSSFWorkbook getWorkbook() {
		return workbook.get();
	}

	/**
	 * Sets the workbook.
	 *
	 * @param _workbook
	 *            the new workbook
	 */
	public static void setWorkbook(XSSFWorkbook _workbook) {
		workbook.set(_workbook);
	}

	/** The sheet. */
	private static ThreadLocal<XSSFSheet> sheet = new ThreadLocal<XSSFSheet>();

	/**
	 * Gets the sheet.
	 *
	 * @return the sheet
	 */
	public static XSSFSheet getSheet() {
		return sheet.get();
	}

	/**
	 * Sets the sheet.
	 *
	 * @param _sheet
	 *            the new sheet
	 */
	public static void setSheet(XSSFSheet _sheet) {
		sheet.set(_sheet);
	}

	/** The row. */
	private static ThreadLocal<XSSFRow> row = new ThreadLocal<XSSFRow>();

	/**
	 * Gets the row.
	 *
	 * @return the row
	 */
	public static XSSFRow getRow() {
		return row.get();
	}

	/**
	 * Sets the row.
	 *
	 * @param _row
	 *            the new row
	 */
	public static void setRow(XSSFRow _row) {
		row.set(_row);
	}
	public static void setExtentReportPath(String ExtentReportPath) {
		extentReportPath.set(ExtentReportPath);
	}

	public static String getExtentReportPath() {
		return extentReportPath.get();
	}
}