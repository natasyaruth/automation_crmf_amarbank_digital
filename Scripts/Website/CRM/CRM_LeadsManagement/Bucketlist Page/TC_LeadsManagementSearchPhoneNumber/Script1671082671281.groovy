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

'Initial Setup Keylogger'
KeywordUtil keylogger = new KeywordUtil()

'Scenario Testing'
/* 	Precondition
 * -L ogin with  user CSR in CRM Senyumku
	- User has click Leads Management in side bar

	Step
	1. User click search field 'Cari No. Handphone'
	2. User input No.Handphone using Indonesia format
	3. User click button search
	
	Expectation
	- User can click button search
	- System will display the data which has been searching by No. Handphone in Leads Management bucketlist
 * */

'We want to access the menu leads management'
if (WebUI.waitForElementVisible(linkMenuLeadsManagement, 5)) {
	WebUI.click(linkMenuLeadsManagement)
} else {keylogger.markError("Leads Management not shown")}

WebDriver driverBucketLeads = DriverFactory.getWebDriver()
WebElement headerBucketList
List<WebElement> headerRowsBucketList
List<WebElement> headerColsBucketList

TestObject accessMenuLeads = new TestObject().addProperty('text',ConditionType.CONTAINS,"Leads Management")
if (WebUI.waitForElementVisible(accessMenuLeads, 5)) {
	WebUI.verifyElementVisible(txtPhoneNumberLeads)
	WebUI.verifyElementVisible(btnSearchPhoneNumberLeads)
	headerBucketList = driverBucketLeads.findElement(By.xpath('//table/thead'))
	headerRowsBucketList = headerBucketList.findElements(By.tagName('tr'))
	headerColsBucketList = headerRowsBucketList.get(0).findElements(By.tagName('th'))
	if (headerColsBucketList.get(0).getText().equalsIgnoreCase("No")) {
		headerColsBucketList.get(1).getText().equalsIgnoreCase("Nama")
		headerColsBucketList.get(2).getText().equalsIgnoreCase("No. Handphone")
		headerColsBucketList.get(3).getText().equalsIgnoreCase("Tanggal")
		headerColsBucketList.get(4).getText().equalsIgnoreCase("Lihat Detail")
	} else {keylogger.markError("Text is not match")}
	WebUI.verifyElementVisible(btnIsDisable)
	WebUI.verifyElementVisible(btnNextPage)
	WebUI.takeScreenshot()
'Search phone number with numeric phone number'

	WebUI.setText(txtPhoneNumberLeads, phoneNumber)
	WebUI.click(btnSearchPhoneNumberLeads)
	WebUI.takeScreenshot()
	headerBucketList = driverBucketLeads.findElement(By.xpath('//table/tbody'))
	headerRowsBucketList = headerBucketList.findElements(By.tagName('tr'))
	headerColsBucketList = headerRowsBucketList.get(0).findElements(By.tagName('td'))
	if (headerColsBucketList.get(4).getText().equalsIgnoreCase("Detail")) {
		headerColsBucketList.get(2).getText().equalsIgnoreCase(phoneNumber)
	} else {keylogger.markError("Text is not match")}
} else {keylogger.markError("Element not visible")}
