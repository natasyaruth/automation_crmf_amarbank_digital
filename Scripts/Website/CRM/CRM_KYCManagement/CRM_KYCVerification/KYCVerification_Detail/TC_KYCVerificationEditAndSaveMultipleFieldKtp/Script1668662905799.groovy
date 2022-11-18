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


/* Precondition 
 * Already Login to CRMF Web

	Step:
	1.Click section KYC Management
	2.Click section KYC Verification
	3.Click detail customer
	4.Click button Edit on section Data eKTP
	5.Edit field "NIK/Nama sesuai di ktp/ tempat lahir/ tanggal lahir/RT/RW" with new value
	6.Click button Simpan
	
	Expectaion
	-Show all data on changes log in different rows with details:

	- Show "tanggal" with time when the changes was created
	- Show agent name in User/Agent row
	- Show KYC Verification in Source row
	- Show Field "NIK/Nama sesuai di ktp/ tempat lahir/ tanggal lahir/RT/RW"
	- Show old NIK/Nama sesuai di ktp/ tempat lahir/ tanggal lahir/RT/RW in "Data Lama"
	- Show new NIK/Nama sesuai di ktp/ tempat lahir/ tanggal lahir/RT/RW in "Data Baru"
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
		} else {keylogger.markError('Text is not found')}
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
tblKycVerif = driver.findElement(By.xpath('//table/tbody'))
rowsKycVerif = tblKycVerif.findElements(By.tagName('tr'))
colsKycVerif = rowsKycVerif.get(0).findElements(By.tagName('td'))
if (colsKycVerif.get(7).getText().equalsIgnoreCase("Menunggu")) {
	colsKycVerif.get(7).findElement(By.xpath('a')).click()
	TestObject kycDetailPageAfterFilter = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Customer Detail')
	if (WebUI.verifyElementPresent(kycDetailPageAfterFilter, 5)) {
		WebUI.scrollToElement(btnEditKycVerif, 5)
		int optionListLength = 3
		Random rand = new Random()
		String index = rand.nextInt(optionListLength + 1)
		WebUI.click(btnEditKycVerif)
		WebUI.setText(txtNik, "3173" +RandomStringUtils.randomNumeric(12))
		WebUI.setText(txtNameBaseNik, fullName)
		WebUI.setText(txtBirthPlace, birthPlace)
		WebUI.clearText(txtBirthDate)
		WebUI.setText(txtBirthDate, "01/01/2000")
		WebUI.sendKeys(txtBirthDate,Keys.chord(Keys.ENTER))
		WebUI.setText(txtRt, RandomStringUtils.randomNumeric(3))
		WebUI.setText(txtRw, RandomStringUtils.randomNumeric(3))
		if (WebUI.waitForElementPresent(btnSimpan, 5)) {
			WebUI.click(btnSimpan)
		} else {keylogger.markError('Element not present')}
		WebUI.scrollToElement(lbReqId, 5)
		reqId = WebUI.getText(lbReqId)
		WebUI.click(btnBackDashboard)
		TestObject kycBucketListAfterFilter = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Verification')
		WebUI.verifyElementPresent(kycBucketListAfterFilter, 5)
	} else {keylogger.markError('Element not present')}
}
String reqIdKyc = reqId
println(reqIdKyc)
'Init selected web element KYC'
WebDriver driverCsr = DriverFactory.getWebDriver()
WebElement tblCsr
List<WebElement> rowsCsr
List<WebElement> colsCsr
'We want check change log in CSR Management Detail'
if (WebUI.waitForElementPresent(menuCsrManagement, 5)) {
	WebUI.click(menuCsrManagement)
	if (WebUI.waitForElementPresent(alretText, 5)) {
		WebUI.click(abortBtn)
	} else {keylogger.logInfo('Process not block')}
	WebUI.setText(txtReqIdCsr, reqIdKyc)
	WebUI.click(btnSearchCsr)
	tblCsr = driverCsr.findElement(By.xpath('//table/tbody'))
	rowsCsr = tblCsr.findElements(By.tagName('tr'))
	colsCsr = rowsCsr.get(0).findElements(By.tagName('td'))
	if (colsCsr.get(5).getText().equalsIgnoreCase("Nasabah Baru")) {
		colsCsr.get(6).findElement(By.xpath('button')).click()
		TestObject txtCsrDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
		if (WebUI.verifyElementPresent(txtCsrDetail, 5)) {
			WebUI.scrollToElement(btnChangeLog, 5)
			WebUI.click(btnChangeLog)
			WebUI.verifyOptionsPresent(drpDwnFilterByActivity, listFilterByActivity)
			WebUI.selectOptionByLabel(drpDwnFilterByActivity, "Edited", false)
			WebUI.verifyOptionsPresent(drpDwnFilterBySource, listFilterBySource)
			WebUI.selectOptionByLabel(drpDwnFilterBySource, "KYC Verification", false)
			WebUI.takeScreenshot()
		} else {keylogger.markError('Element not present')}
	} else {keylogger.markError('Text not found')}
} else {keylogger.markError('Element not found')}