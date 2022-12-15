import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

'Initial function'
KeywordUtil keylogger = new KeywordUtil()

'Scenario Test'
/* 	Precondition
 * User already login to CRM
 * 
 * 	Steps
 * - Click roles KYC Management
	- Click sub-roles KYC Automate Process
	
	Expected Result
	- Show bucketlist KYC Automate Process
	- All data request id in bucketlist only with status email is verified (in KYC verification and CSR Management)
	- Only show Customer type Nasabah baru  with origin Senyumku
	- Sorting by first in first out ( last in will appear on first indext)
	- Show search request id field
	- id LinkAutomateProcess
 * */

'we want access the KYC Automate Process'
if (WebUI.waitForElementVisible(linkMenuKycManagement, 5)) {
	WebUI.click(linkMenuKycManagement)
	if (WebUI.waitForElementVisible(linkMenuKycAutomateProcess, 5)) {
		WebUI.click(linkMenuKycAutomateProcess)
	} else {keylogger.markError("We not found menu KYC Management")}
} else {keylogger.markError("We not found menu KYC Automate")}

WebDriver driverBucketKycAutomate = DriverFactory.getWebDriver()
WebElement tblBucketKycAutomate
List<WebElement> rowsBucketKycAutomate
List<WebElement> colsBucketKycAutomate

'We want check bucket list in KYC Automate'
TestObject AccessKycAutomate = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Automate Process')
if (WebUI.waitForElementVisible(AccessKycAutomate, 5)) {
	WebUI.verifyElementVisible(txtReqId)
	WebUI.verifyElementVisible(btnSearchReqId)
	if (WebUI.waitForElementVisible(btnNextPage, 5)) {
		WebUI.verifyElementVisible(btnNextPage)
	} else {keylogger.logInfo("We just have one page")}
	tblBucketKycAutomate = driverBucketKycAutomate.findElement(By.xpath("//table/thead"))
	rowsBucketKycAutomate = tblBucketKycAutomate.findElements(By.tagName("tr"))
	colsBucketKycAutomate = rowsBucketKycAutomate.get(0).findElements(By.tagName("th"))
	if (colsBucketKycAutomate.get(0).getText().equalsIgnoreCase("No")) {
		colsBucketKycAutomate.get(1).getText().equalsIgnoreCase("Request ID")
		colsBucketKycAutomate.get(2).getText().equalsIgnoreCase("Request Type")
		colsBucketKycAutomate.get(3).getText().equalsIgnoreCase("Name")
		colsBucketKycAutomate.get(4).getText().equalsIgnoreCase("Customer Type")
		colsBucketKycAutomate.get(5).getText().equalsIgnoreCase("Request Date")
	} else {keylogger.markError("We not found text")}
} else {keylogger.markError("Element not visible")}

'We want check the data in bucket list'
tblBucketKycAutomate = driverBucketKycAutomate.findElement(By.xpath("//table/tbody"))
rowsBucketKycAutomate = tblBucketKycAutomate.findElements(By.tagName("tr"))
colsBucketKycAutomate = rowsBucketKycAutomate.get(0).findElements(By.tagName("td"))
if (colsBucketKycAutomate.get(4).getText().equalsIgnoreCase("Nasabah Baru")) {
	colsBucketKycAutomate.get(2).getText().equalsIgnoreCase("Registrasi Baru")
	WebUI.takeScreenshot()
} else {keylogger.markError("We not found the text")}