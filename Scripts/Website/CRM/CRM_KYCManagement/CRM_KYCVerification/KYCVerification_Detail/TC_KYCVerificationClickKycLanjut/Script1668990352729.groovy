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
	4.Click button "Lanjutkan KYC"
	5.Choose the reason
	6.Click button "Kirim"
	
	Expectaion
	Display data on changes log with detail:
	Tanggal -> date with time when the changes was created
	User/Agent -> agent name
	Source -> KYC Verification
	Field -> Reason
	Data lama -> -
	Data baru -> (the reason)
	Action -> Lanjutkan KYC
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
tblKycVerif = driver.findElement(By.xpath('//table/tbody'))
rowsKycVerif = tblKycVerif.findElements(By.tagName('tr'))
colsKycVerif = rowsKycVerif.get(0).findElements(By.tagName('td'))
if (colsKycVerif.get(7).getText().equalsIgnoreCase("Menunggu")) {
	colsKycVerif.get(7).findElement(By.xpath('a')).click()
	TestObject kycDetailPageAfterFilter = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Customer Detail')
	if (WebUI.verifyElementPresent(kycDetailPageAfterFilter, 5)) {
		WebUI.scrollToElement(lbReqId, 5)
		reqId = WebUI.getText(lbReqId)
		WebUI.scrollToElement(btnKycLanjut, 5)
		WebUI.click(btnKycLanjut)
		TestObject reasonContKyc = new TestObject().addProperty('text',ConditionType.CONTAINS,'Alasan Lanjutkan KYC')
		if (WebUI.verifyElementPresent(reasonContKyc, 5)) {
			WebUI.click(chkLowLiveness)
			WebUI.click(btnSendReasonContKyc)
		} else {keylogger.markError('We are not in Cont KYC')}
		WebUI.waitForPageLoad(10)
		TestObject kycBucketListAfterFilter = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Verification')
		WebUI.verifyElementPresent(kycBucketListAfterFilter, 5)
	} else {keylogger.markError('Element not present')}
}
String reqIdKyc = reqId
println(reqIdKyc)

'We want check the request Id in KYC Verification'
WebUI.setText(txtReqIdKycVerif, reqIdKyc)
WebUI.sendKeys(txtReqIdKycVerif, Keys.chord(Keys.ENTER))
TestObject notFoundReqId = new TestObject().addProperty('text',ConditionType.CONTAINS,'Oops, Hasil pencarian tidak ditemukan')
if (WebUI.verifyElementPresent(notFoundReqId, 5)) {
	keylogger.markPassed('Condition is passed')
	WebUI.click(linkKycVideo)
	WebUI.click(tabIdleCalls)
	WebUI.setText(txtReqIdKycVideo, reqIdKyc)
	WebUI.sendKeys(txtReqIdKycVideo, Keys.chord(Keys.ENTER))
	WebUI.verifyElementText(btnReqIdKycVideo, reqIdKyc)
} else {keylogger.markError('Element is present')}

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
	} else {keylogger.markError('Text not found Check Nasabah Baru')}
} else {keylogger.markError('Element not found CSR Management')}

'Check data in change log'
WebDriver driverCsrDtl = DriverFactory.getWebDriver()
WebElement tblCsrDtl
List<WebElement> rowsCsrDtl

TestObject txtCsrDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
if (WebUI.verifyElementPresent(txtCsrDetail, 5)) {
	WebUI.scrollToElement(btnChangeLog, 5)
	WebUI.click(btnChangeLog)
	WebUI.verifyOptionsPresent(drpDwnFilterByActivity, listFilterByActivity)
	WebUI.selectOptionByLabel(drpDwnFilterByActivity, "Semua", false)
	WebUI.verifyOptionsPresent(drpDwnFilterBySource, listFilterBySource)
	WebUI.selectOptionByLabel(drpDwnFilterBySource, "KYC Verification", false)
	WebUI.takeScreenshot()
} else {keylogger.markError('Element not present')}
tblCsrDtl = driverCsrDtl.findElement(By.xpath('//*[@id="changelog"]//table/tbody'))
 rowsCsrDtl = tblCsrDtl.findElements(By.tagName('tr'))
 boolean loopFlag = false
 LoopCsr:
 while (loopFlag == false) {
	  for (int i = 0;i < rowsCsrDtl.size(); i++) {
		  List<WebElement> colsCsrDtl = rowsCsrDtl.get(i).findElements(By.tagName('td'))
		  if (colsCsrDtl.get(2).getText().equalsIgnoreCase("KYC Verification")) {
			  colsCsrDtl.get(3).getText().equalsIgnoreCase("Reason")
			  colsCsrDtl.get(5).getText().equalsIgnoreCase("Liveness low")
			  colsCsrDtl.get(6).getText().equalsIgnoreCase("Lanjutkan KYC")
			  break LoopCsr
		  } else {keylogger.logInfo('We try again to check another row')}
	  }
  }