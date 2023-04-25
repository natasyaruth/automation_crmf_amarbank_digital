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


'init logging in katalon studio'
KeywordUtil keylogger = new KeywordUtil()

/*Scenario Test
 * 	
 * Precondition:
 * User already in KYC Verification detail
 * 
 * Steps
 * 	- Customer registration in Indonesia area
	- User click on request ID customer no.1
	- Verify section "Device Data"
	
	Expected Result
	 - Section "Device Data" doesn't show any Stopper level 4
 * 
 * */
 
'We want to check new user in Kyc Verif'
if (WebUI.waitForElementPresent(menuKycManagement, 5)) {
	WebUI.click(menuKycManagement)
	if (WebUI.waitForElementPresent(menuKycVerif, 5)) {
		WebUI.click(menuKycVerif)
	} else {keylogger.markError("We not found the element")}
} else {keylogger.markError("We not found the element")}

'We want to check request Id in KYC Verif as new registration'
TestObject kycVerifBucketList = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Verification')
if (WebUI.verifyElementPresent(kycVerifBucketList, 5)) {
	WebUI.setText(txtReqIdKycVerif, reqIdStopper4)
	WebUI.sendKeys(txtReqIdKycVerif, Keys.chord(Keys.ENTER))
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
} else {keylogger.markError("Element not present")}
WebDriver driverKycVerif = DriverFactory.getWebDriver()
WebElement tblKycVerif = driverKycVerif.findElement(By.xpath("//table/tbody"))
List<WebElement> rowKycVerif = tblKycVerif.findElements(By.tagName('tr'))
List<WebElement> colsKycVerif = rowKycVerif.get(0).findElements(By.tagName('td'))
if (colsKycVerif.get(2).getText().equalsIgnoreCase("Ganti Nomor HP")) {
	colsKycVerif.get(4).getText().equalsIgnoreCase("Nasabah Senyumku")
	newUserName = colsKycVerif.get(3).getText()
	colsKycVerif.get(1).getText().equalsIgnoreCase(reqIdStopper4)
	keylogger.markPassed("We verify request Id in new registration in KYC verif")
} else {keylogger.markError("Request Id not in new registration")}

String newUserName = newUserName
'We want to check in Card Management as stopper 4'
WebUI.click(menuCsrManagement)
if (WebUI.waitForElementPresent(notifAlert, 5)) {
	WebUI.click(btnAbort)
	TestObject csrBucketList = new TestObject().addProperty('text',ConditionType.CONTAINS,'CSR Management')
	if (WebUI.verifyElementPresent(csrBucketList, 5)) {
		keylogger.markPassed('We are in CSR bucket list')
	} else {keylogger.markError('Element not present')}
} else {
	TestObject csrBucketList = new TestObject().addProperty('text',ConditionType.CONTAINS,'CSR Management')
	if (WebUI.verifyElementPresent(csrBucketList, 5)) {
		keylogger.markPassed('We are in CSR bucket list')
	} else {keylogger.markError('Element not present')}
}
WebUI.setText(txtReqIdCsrBucketList, reqIdStopper4)
WebUI.sendKeys(txtReqIdCsrBucketList, Keys.chord(Keys.ENTER))
WebDriver driverCsrBucket = DriverFactory.getWebDriver()
WebElement tblCsrBucket = driverCsrBucket.findElement(By.xpath("//table/tbody"))
List<WebElement> rowCsrBucket = tblCsrBucket.findElements(By.tagName('tr'))
List<WebElement> colsCsrBucket = rowCsrBucket.get(0).findElements(By.tagName('td'))
if (colsCsrBucket.get(5).getText().equalsIgnoreCase("Nasabah Senyumku")) {
	colsCsrBucket.get(1).getText().equalsIgnoreCase(newUserName)
	colsCsrBucket.get(6).findElement(By.xpath('button')).click()
} else {keylogger.markError("Request Id not in Bucket List")}

'We are in CSR Detail'
TestObject csrDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
if (WebUI.verifyElementPresent(csrDetail, 5)) {
	keylogger.markPassed('We are in CSR detail')
	WebUI.click(btnDeviceData)
	if (WebUI.waitForElementPresent(lbStopper, 5)) {
		WebUI.verifyElementVisible(lbStopper)
		TestObject checkStopper = new TestObject().addProperty('text',ConditionType.CONTAINS,'Stopper 4')
		if (WebUI.verifyElementPresent(checkStopper, 5)) {
			keylogger.markPassed("Stopper 4 already shown")
		} else {keylogger.markError("expectation is not same")}
		WebUI.takeScreenshot()
	} else {keylogger.markError('Stopper not shown')}
	WebUI.click(btnBack)
} else {keylogger.markError('Element not present')}