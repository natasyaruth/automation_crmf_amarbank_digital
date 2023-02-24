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

'init function logging'
KeywordUtil keylogger = new KeywordUtil()

'Scenario Testing'
/*Precondition
 * 	- Already open CRM
	- Already open KYC Verification
	- Already open the detail one of customer type nasabah baru which email has verified
	- Photo Selfie is not matched with dukcapil data

	Steps
	- Click on button "Cek" on facematch dukcapil
	- Click on "Lakukan Facematch Dukcapil' in pop up confirmation check facematch dukcapil
	
	Expected Result
	- Got response 200 from dukcapil
	- Show status message "Image not match" and value in table section Facematch Dukcapil
	- Button "Cek" Facematch Verihub is enable & FM Dukcapil is disable
	- Value is record on changes log and CSR
 */
'Noted for this cases currently I just catch the existing data with these condition and also I see the next API process if any provide it will use with that'

'Init access HTML'
WebDriver driverKycVerif = DriverFactory.getWebDriver()
WebElement tblKycVerif
List<WebElement> rowsKycVerif
List<WebElement> colsKycVerif

'We want access to KYC Verification'
if (WebUI.waitForElementVisible(linkMenuKycManagement, 5)) {
	WebUI.click(linkMenuKycManagement)
	WebUI.delay(5)
	WebUI.waitForPageLoad(5)
	if (WebUI.waitForElementVisible(linkMenuKycVerification, 5)) {
		WebUI.click(linkMenuKycVerification)
		WebUI.delay(5)
		WebUI.waitForPageLoad(5)
		tblKycVerif = driverKycVerif.findElement(By.xpath('//table/tbody'))
		rowsKycVerif = tblKycVerif.findElements(By.tagName('tr'))
		colsKycVerif = rowsKycVerif.get(0).findElements(By.tagName('td'))
		if (colsKycVerif.get(4).getText().equalsIgnoreCase('Nasabah Baru')) {
			colsKycVerif.get(7).findElement(By.xpath('a')).click()
			TestObject accessInKycVerifDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Customer Detail')
			if (WebUI.waitForElementVisible(accessInKycVerifDetail, 5)) {
				WebUI.click(btnBackToKyc)
			} else {keylogger.markError('We are not in KYC Detail')}
		} else {keylogger.logInfo('We can continue the process')}
	} else {keylogger.markError('ELement not visible please check again')}
} else {keylogger.markError('Element not visible please check again')}

'We want access the request ID'
WebUI.verifyOptionsPresent(drpDwnCustType, listDrpDwnCustType)
WebUI.selectOptionByLabel(drpDwnCustType, 'Nasabah Baru', false)
WebUI.setText(txtReqIdKycVerif, reqIdWithImageNotMatch)
WebUI.sendKeys(txtReqIdKycVerif, Keys.chord(Keys.ENTER))

tblKycVerif = driverKycVerif.findElement(By.xpath('//table/tbody'))
rowsKycVerif = tblKycVerif.findElements(By.tagName('tr'))
colsKycVerif = rowsKycVerif.get(0).findElements(By.tagName('td'))
if (colsKycVerif.get(1).getText().equalsIgnoreCase(reqIdWithImageNotMatch)) {
	colsKycVerif.get(4).getText().equalsIgnoreCase('Nasabah Baru')
	colsKycVerif.get(7).findElement(By.xpath('a')).click()
} else {keylogger.markError('Request ID not match')}
TestObject accessKycCustDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Customer Detail')
if (WebUI.waitForElementPresent(accessKycCustDetail, 5)) {
	WebUI.scrollToElement(txtImageNotFound, 5)
	WebUI.verifyElementText(txtImageNotFound, "Image is not match")
	WebUI.verifyElementNotClickable(btnFmDukcapil)
	WebUI.verifyElementClickable(btnFmVerihub)
	WebUI.scrollToElement(btnBackToKyc, 0)
	WebUI.click(btnBackToKyc)
} else {keylogger.markError('We are not in KYC Customer Detail')}

'Init access HTML'
WebDriver driverCsrMgt = DriverFactory.getWebDriver()
WebElement tblCsrMgt
List<WebElement> rowsCsrMgt
List<WebElement> colsCsrMgt

'We want check in CSR Management'
if (WebUI.waitForElementVisible(linkMenuCsrManagement, 5)) {
	WebUI.click(linkMenuCsrManagement)
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
	if (WebUI.waitForElementVisible(alertNotif, 5)) {
		WebUI.click(btnAbort)
		WebUI.waitForPageLoad(5)
		WebUI.delay(3)
	} else {keylogger.logInfo('We can continue the process')}
	WebUI.setText(txtReqIdCsrMgt, reqIdWithImageNotMatch)
	WebUI.sendKeys(txtReqIdCsrMgt, Keys.chord(Keys.ENTER))
	tblCsrMgt = driverCsrMgt.findElement(By.xpath('//table/tbody'))
	rowsCsrMgt = tblCsrMgt.findElements(By.tagName('tr'))
	colsCsrMgt = rowsCsrMgt.get(0).findElements(By.tagName('td'))
	if (colsCsrMgt.get(5).getText().equalsIgnoreCase('Nasabah Baru')) {
		colsCsrMgt.get(6).findElement(By.xpath('button')).click()
		TestObject accessToCustDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
		if (WebUI.waitForElementPresent(accessToCustDetail, 5)) {
			keylogger.markPassed('We are success to access in customer detail')
			WebUI.takeScreenshot()
		} else {keylogger.markError('We are not access Customer Detail')}
	} else {keylogger.markError('We are not get the nasabah baru')}
} else {keylogger.markError('Element not visible')}

'Init access HTML'
WebDriver driverCsrMgtDtl = DriverFactory.getWebDriver()
WebElement tblCsrMgtDtl
List<WebElement> rowsCsrMgtDtl
List<WebElement> colsCsrMgtDtl

'We want check on changelog CSR Detail'
WebUI.scrollToElement(btnDataChangeLog, 5)
WebUI.click(btnDataChangeLog)
checkLoop = false
fmDukcapil:
while (checkLoop == false) {
	WebUI.verifyOptionsPresent(drpDwnFilterBySource, listDrpDwnFilterBySource)
	WebUI.selectOptionByLabel(drpDwnFilterBySource, 'KYC Verification', false)
	tblCsrMgtDtl = driverCsrMgtDtl.findElement(By.xpath('//*[@id="changelog"]//table/tbody'))
	rowsCsrMgtDtl = tblCsrMgtDtl.findElements(By.tagName('tr'))
	for (int i; i < rowsCsrMgtDtl.size() ; i++) {
		colsCsrMgtDtl = rowsCsrMgtDtl.get(i).findElements(By.tagName('td'))
		if (colsCsrMgtDtl.get(2).getText().equalsIgnoreCase('KYC Verification')) {
			colsCsrMgtDtl.get(3).getText().equalsIgnoreCase('Facematch Dukcapil')
			colsCsrMgtDtl.get(5).getText().equalsIgnoreCase('48.7%')
			colsCsrMgtDtl.get(6).getText().equalsIgnoreCase('Melakukan face match')
			keylogger.markPassed('We already to check Face Match Dukcapil')
			WebUI.scrollToElement(btnBackCsrBucket, 5)
			WebUI.click(btnBackCsrBucket)
			break fmDukcapil
		} else {
			keylogger.logInfo('We must check in another row')
			tblCsrMgtDtl = driverCsrMgtDtl.findElement(By.xpath('//*[@id="changelog"]//table/tbody'))
			rowsCsrMgtDtl = tblCsrMgtDtl.findElements(By.tagName('tr'))
		}
	}
}