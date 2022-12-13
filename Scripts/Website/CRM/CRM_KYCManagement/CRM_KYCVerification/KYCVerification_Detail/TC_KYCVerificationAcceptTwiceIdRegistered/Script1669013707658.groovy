import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.github.javafaker.Faker
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
import com.tunaiku.keyword.RandomDate

import internal.GlobalVariable

import org.apache.commons.lang.RandomStringUtils
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

'Initial logging in katalon studio'
KeywordUtil keylogger = new KeywordUtil()
'Init Name Faker'
Faker faker = new Faker()
String fullName = faker.name().fullName()
'Init birth place'
String birthPlace = faker.address().city()
String birthDate = faker.date().birthday()
def randDate = RandomDate.getDateStringForDateBefore()

'This TC must be disable the config cek dukcapil must be same the process'
/* Precondition 
 * 	Customer Register using the same KTP as much as 2 times until KYC Verification
	Agent has process the first data until success registered

	Step:
	Click button Terima 2 after the first data with same KTP already Accepted in KYC verification
	
	Expectaion
	-Show pop up "KTP sudah terdaftar"
	-Create account is failed
	-Status in CSR Management still "Dalam Proses"
 * 
 * */

'Init selected web element KYC'
WebDriver driver = DriverFactory.getWebDriver()
WebElement tblKycVerif
List<WebElement> rowsKycVerif 
List<WebElement> colsKycVerif

'We want to access to KYC Verification'
if (WebUI.waitForElementPresent(menuKycManagement, 5)) {
	WebUI.click(menuKycManagement)
	if (WebUI.waitForElementPresent(menuKycVerification, 5)) {
		WebUI.click(menuKycVerification)
		tblKycVerif = driver.findElement(By.xpath('//table/tbody'))
		rowsKycVerif = tblKycVerif.findElements(By.tagName('tr'))
		colsKycVerif = rowsKycVerif.get(0).findElements(By.tagName('td'))
		if (colsKycVerif.get(7).getText().equalsIgnoreCase('Sedang diproses')) {
			colsKycVerif.get(7).findElement(By.xpath('a')).click()
			TestObject kycDetailPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Customer Detail')
			if (WebUI.verifyElementPresent(kycDetailPage, 5)) {
				WebUI.click(btnBackDashboard)
				TestObject kycBucketList = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Verification')
				WebUI.verifyElementPresent(kycBucketList, 5)
			} else {keylogger.markError('Element not present')}
		} else {keylogger.logInfo('Text is not found')}
	} else {keylogger.markError('element not present')}
} else {keylogger.markError('element not present')}

'we want choose the filter'
if (WebUI.waitForElementPresent(drpDwnCustType, 5)) {
	WebUI.verifyOptionsPresent(drpDwnCustType, listCustType)
	WebUI.selectOptionByLabel(drpDwnCustType, "Nasabah Baru", false)
} else {keylogger.markError("Element not present")}
if (WebUI.waitForElementPresent(drpDwnEmailVerif, 5)) {
	WebUI.verifyOptionsPresent(drpDwnEmailVerif, listEmailVerif)
	WebUI.selectOptionByLabel(drpDwnEmailVerif, "Terverifikasi", false)
} else {keylogger.markError('Element not present')}
WebUI.setText(txtReqIdKyc, invalidId)
WebUI.sendKeys(txtReqIdKyc, Keys.chord(Keys.ENTER))
tblKycVerif = driver.findElement(By.xpath('//table/tbody'))
rowsKycVerif = tblKycVerif.findElements(By.tagName('tr'))
colsKycVerif = rowsKycVerif.get(0).findElements(By.tagName('td'))
if (colsKycVerif.get(7).getText().equalsIgnoreCase("Menunggu")) {
	colsKycVerif.get(7).findElement(By.xpath('a')).click()
	TestObject kycDetailPageAfterFilter = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Customer Detail')
	if (WebUI.verifyElementPresent(kycDetailPageAfterFilter, 5)) {
		WebUI.scrollToElement(btnCheckDukCapil, 5)
		WebUI.click(btnCheckDukCapil)
		if (WebUI.waitForElementPresent(alretText, 5)) {
			WebUI.click(btnModalDukcapil)
			WebUI.takeScreenshot()
		} else {keylogger.markError('alert not present to konfirmation')}
		TestObject alertNikNotFound = new TestObject().addProperty('text',ConditionType.CONTAINS,'NIK tidak ditemukan')
		if (WebUI.verifyElementPresent(alertNikNotFound, 5)) {
			WebUI.scrollToElement(lbReqId, 5)
			reqId = WebUI.getText(lbReqId)
			WebUI.scrollToElement(labelInProcess, 5)
			WebUI.verifyElementText(labelInProcess, "Sedang diproses")
			WebUI.click(btnBackDashboard)
		} else {keylogger.markError('Alert NIK Not Found doesnt appear')}
		TestObject kycBucketListAfterFilter = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Verification')
		WebUI.verifyElementPresent(kycBucketListAfterFilter, 5)
	} else {keylogger.markError('Element not present')}
}