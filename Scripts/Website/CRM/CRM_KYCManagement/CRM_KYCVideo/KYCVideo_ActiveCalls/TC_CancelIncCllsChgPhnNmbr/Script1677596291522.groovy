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

import org.openqa.selenium.Alert
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

import groovy.transform.ConditionalInterrupt
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.remote.server.handler.RefreshPage
import org.apache.commons.lang.RandomStringUtils
import com.github.javafaker.Faker

'Init keylogger'
KeywordUtil keylogger = new KeywordUtil()

/*Scenario Test
 * Precondition:
	-User has access to KYC video request active calls
	-Active incoming call for "Ganti Nomor Hp Nasabah Senyumku"
	
	Steps:
	- Click incoming call "Ganti Nomor Hp Nasabah Senyumku" request id
	
	Expected Result:
	-System display detail customer "Ganti Nomor Hp Nasabah Senyumku" with active KYC video call page
	-System display new phone number in "Nomor HP Baru" section
 */
'We want to process CSR Detail'
if (WebUI.waitForElementPresent(linkMenuCsrManagement, 5)) {
	WebUI.click(linkMenuCsrManagement)
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
	if (WebUI.waitForElementPresent(alertConfirmation, 5)) {
		WebUI.click(btnAbort)
		WebUI.waitForPageLoad(5)
		WebUI.delay(3)
	} else {keylogger.logInfo("We not found the element")}
} else {keylogger.markError("We not found the CSR Management")}

'init HTML Webdriver'
WebDriver driverCsr = DriverFactory.getWebDriver()
WebElement tblCsr
List<WebElement> rawCsr

checkData = false
loopCheckData:
while (checkData == false) {
	tblCsr = driverCsr.findElement(By.xpath("//table/tbody"))
	rawCsr = tblCsr.findElements(By.tagName("tr"))
	for (int i=0; i < rawCsr.size(); i++) {
	TestObject csrManagementBucketList = new TestObject().addProperty('text',ConditionType.CONTAINS,'CSR Management')
	if (WebUI.verifyElementPresent(csrManagementBucketList, 5, FailureHandling.OPTIONAL)) {
		WebUI.selectOptionByLabel(drpDwnCardStats, 'Sudah Aktivasi', false)
		WebUI.selectOptionByLabel(drpDwnCstType, 'Nasabah Senyumku', false)
		WebUI.delay(3)
	} else {keylogger.markError('We are not in CSR Management')}
		List<WebElement> colsCsr = rawCsr.get(i).findElements(By.tagName('td'))
		if (colsCsr.get(5).getText().equalsIgnoreCase("Nasabah Senyumku")) {
			colsCsr.get(6).findElement(By.xpath('button')).click()
		} else {keylogger.markError('We not found the element')}
		TestObject csrManagementDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
		if (WebUI.verifyElementPresent(csrManagementDetail, 5)) {
			TestObject statusCust = new TestObject().addProperty('text',ConditionType.CONTAINS,'Selesai')
			if (WebUI.waitForElementVisible(statusCust, 5)) {
				WebUI.click(linkDataPhoneNumber)
				WebUI.click(btnEditPhoneNumber)
				if (WebUI.waitForElementPresent(txtPhoneNumber, 5)) {
					WebUI.setText(txtPhoneNumber, '+6285'+RandomStringUtils.randomNumeric(7))
					
					if (WebUI.waitForElementVisible(btnSavePhoneNumber, 5)) {
						WebUI.verifyElementClickable(btnSavePhoneNumber)
						WebUI.click(btnSavePhoneNumber)
					} else {keylogger.markError("Element not visible")}
				} else {keylogger.markError("Element not present")}
				TestObject successSaveNumber = new TestObject().addProperty('text',ConditionType.CONTAINS,'No. Handphone berhasil disimpan')
				if (WebUI.verifyElementPresent(successSaveNumber, 5)) {
					WebUI.refresh()
					WebUI.delay(5)
					WebUI.scrollToElement(btnBack, 5)
					csrReqId = WebUI.getText(csrReqIdDetail)
					WebUI.click(btnBack)
					WebUI.refresh()
					break loopCheckData
				} else {keylogger.markError('element not present')}
			} else {
				WebUI.click(btnBack)
				WebUI.delay(3)
				tblCsr = driverCsr.findElement(By.xpath("//table/tbody"))
				rawCsr = tblCsr.findElements(By.tagName("tr"))
			}
		} else {keylogger.markError('We not in detail request Id')}
	}
}

reqIdCsr = csrReqId
if (WebUI.waitForElementPresent(menuKYCManagement, 5)) {
	WebUI.click(menuKYCManagement)
	if (WebUI.waitForElementPresent(menuKycVideo, 5)) {
		WebUI.click(menuKycVideo)
		if (WebUI.verifyElementPresent(idleCallsTab, 5)) {
			WebUI.click(idleCallsTab)
			if (WebUI.waitForElementPresent(alertConfirmation, 5)) {
				WebUI.click(btnAbort)
			} else {keylogger.logInfo("We not found the element")}
		} else {keylogger.markError("We not found tab Idle Calls")}
	} else {keylogger.markError("Menu KYC video not present")}
} else {keylogger.markError("Menu KYC management not present")}

WebUI.setText(txtReqIdKycVideo, reqIdCsr)
WebUI.sendKeys(txtReqIdKycVideo, Keys.chord(Keys.ENTER))
WebDriver driverKycVideo = DriverFactory.getWebDriver()
WebElement tblKycVideo = driverKycVideo.findElement(By.xpath("//table/tbody"))
List<WebElement> rawKycVideo = tblKycVideo.findElements(By.tagName("tr"))
List<WebElement> colsKycVideo = rawKycVideo.get(0).findElements(By.tagName('td'))
if (colsKycVideo.get(3).getText().equalsIgnoreCase("Ganti Nomor HP")) {
	colsKycVideo.get(5).getText().equalsIgnoreCase("Nasabah Senyumku")
	colsKycVideo.get(1).findElement(By.xpath('a')).click()
	WebUI.delay(3)
} else {keylogger.markError('We not found the ')}
TestObject kycVideoDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
if (WebUI.verifyElementPresent(kycVideoDetail, 5)) {
	String currentPage = WebUI.getUrl()
	int currentTab = WebUI.getWindowIndex()
	WebDriver driver = DriverFactory.getWebDriver()
	JavascriptExecutor js = ((driver) as JavascriptExecutor)
	js.executeScript('window.open();')
	WebUI.switchToWindowIndex(currentTab + 1)
	String requestIdProcess = path +reqIdCsr
	WebUI.navigateToUrl((((('https://' + GlobalVariable.authUsername) + ':') + GlobalVariable.authPassword) + '@') + requestIdProcess.substring(
		8))
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
	TestObject videoCallValidation = new TestObject().addProperty('text',ConditionType.CONTAINS,'Verifikasi datamu lewat video call!')
	if (WebUI.verifyElementPresent(videoCallValidation, 5)) {
		if (WebUI.verifyElementClickable(btnCallSenyumku)) {
			WebUI.delay(5)
			WebUI.click(btnCallSenyumku)
			TestObject txtVerifConnect = new TestObject().addProperty('text',ConditionType.CONTAINS,'Kamu akan terhubung dengan tim Senyumku')
			if (WebUI.verifyElementPresent(txtVerifConnect, 0)) {
				WebUI.switchToWindowIndex(0)
				TestObject backToKycVideo = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
				WebUI.verifyElementPresent(backToKycVideo, 5)
				WebUI.click(linkDashboard)
				'We want to check notification'
				if (WebUI.waitForElementVisible(pendingRequest, 5)) {
					WebUI.click(pendingRequest)
				} else {keylogger.markError('Notification didnt shown')}
				WebUI.delay(5)
				WebUI.switchToWindowIndex(1)
				WebUI.delay(5)
				WebUI.switchToWindowIndex(0)
				WebUI.scrollToElement(btnSelfie, 5)
				WebUI.delay(10)
			} else {keylogger.logInfo('Element not present')}
		} else {keylogger.markError('button cannot click able')}
	} else {keylogger.markError('We are not in verification data')}
} else {keylogger.markError("We aren't in KYC video detail")}

'We want to confirmation process'
TestObject checkConfProcess = new TestObject().addProperty('text',ConditionType.CONTAINS,'Hal-hal yang perlu dikonfirmasi')
if (WebUI.verifyElementPresent(checkConfProcess, 5)) {
	WebUI.click(chkNamaKtp)
	WebUI.click(chkKtpNumber)
	WebUI.click(chkBirtDate)
	WebUI.click(chkMotherName)
	WebUI.click(chkChangePhoneNumber)
	WebUI.click(chkEmail)
	WebUI.click(chkReasonChangePhoneNumber)
	WebUI.click(chkCaptureFace)
	WebUI.scrollToElement(btnSelfie, 5)
	if (WebUI.verifyElementClickable(btnSelfie)) {
		WebUI.click(btnSelfie)
		if (WebUI.verifyElementVisible(imgSelfPhoto)) {
			keylogger.markPassed('Photo is enable')
			WebUI.click(btnSaveSelfPhoto)
			TestObject saveConfirmation = new TestObject().addProperty('text',ConditionType.CONTAINS,'Konfirmasi')
			if (WebUI.verifyElementPresent(saveConfirmation, 5)) {
				WebUI.click(btnSaveKyc)
				TestObject saveSelfPhoto = new TestObject().addProperty('text',ConditionType.CONTAINS,'Foto berhasil disimpan')
				WebUI.verifyElementPresent(saveSelfPhoto, 5)
			} else {keylogger.markError('element not present')}
		} else {keylogger.markError('Photo not enable')}
		WebUI.click(btnSelfie)
		if (WebUI.verifyElementVisible(imgKtpPhoto)) {
			keylogger.markPassed('Photo is enable')
			WebUI.click(btnSaveKtpPhoto)
			TestObject saveConfirmation = new TestObject().addProperty('text',ConditionType.CONTAINS,'Konfirmasi')
			if (WebUI.verifyElementPresent(saveConfirmation, 5)) {
				WebUI.click(btnSaveKyc)
				TestObject saveKtpPhoto = new TestObject().addProperty('text',ConditionType.CONTAINS,'Foto berhasil disimpan')
				WebUI.verifyElementPresent(saveKtpPhoto, 5)
			} else {keylogger.markError('element not present')}
		} else {keylogger.markError('Photo not enable')}
	} else {keylogger.markError('Button selfie belum dapat di lakukan')}
} else {keylogger.markError('Element not present')}
'We want ended the video call'
if (WebUI.verifyElementClickable(btnEndVideoCall)) {
	WebUI.click(btnEndVideoCall)
	WebUI.takeScreenshot()
} else {keylogger.markError('button is disable')}

'We want to cancel KYC Video'
WebUI.scrollToElement(BtnCancelKYC,5)
if (WebUI.verifyElementVisible(BtnCancelKYC)) {
	WebUI.click(BtnCancelKYC)
	WebUI.delay(5)
	WebUI.waitForPageLoad(20)
	WebUI.click(btnRequestID)
	WebUI.delay(3)
	WebUI.click(btnBackDashboard)
}else {keylogger.markError('button not visible')}
WebUI.delay(5)

'We want validate changes phone number'
WebUI.click(linkMenuCsrManagement)
TestObject notifProcessCsrDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'Konfirmasi')
if (WebUI.verifyElementPresent(notifProcessCsrDetail, 5,FailureHandling.OPTIONAL)) {
	WebUI.click(btnAbort)
} else {keylogger.logInfo("We continue the process")}
TestObject csrManagementDetailCsrManagement = new TestObject().addProperty('text',ConditionType.CONTAINS,'CSR Management')
if (WebUI.verifyElementPresent(csrManagementDetailCsrManagement, 5, FailureHandling.OPTIONAL)) {
	WebUI.delay(3)
	WebUI.setText(txtRequestId, reqIdCsr)
	WebUI.sendKeys(txtRequestId, Keys.chord(Keys.ENTER))
} else {keylogger.markError('We are not in CSR Management')}
WebUI.delay(5)
'We want access the changes phone number'
WebDriver driverCsrCheck = DriverFactory.getWebDriver()
WebElement tblCsrCheck = driverCsrCheck.findElement(By.xpath("//table/tbody"))
List<WebElement> rawCsrCheck = tblCsrCheck.findElements(By.tagName("tr"))
List<WebElement> colsCsrCheck = rawCsrCheck.get(0).findElements(By.tagName('td'))
if (colsCsrCheck.get(5).getText().equalsIgnoreCase("Nasabah Senyumku")) {
	colsCsrCheck.get(6).findElement(By.xpath('button')).click()
	WebUI.delay(3)
} else {keylogger.markError('We not found the ')}
TestObject csrManagementDetailCheck = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
if (WebUI.verifyElementPresent(csrManagementDetailCheck, 5)) {
	WebUI.click(linkDataPhoneNumber)
} else {keylogger.markError('We not in detail request Id')}


WebUI.delay(5)
'We want check the changelog'
/* We will define new test object with spesific condition */
WebUI.scrollToElement(SectionChangelog,5)
WebUI.click(SectionChangelog)
TestObject SectionChangelogCheck = new TestObject().addProperty('text', ConditionType.CONTAINS,'Batal')
if (WebUI.waitForElementVisible(SectionChangelogCheck, 5)) {
	(WebUI.verifyElementVisible(SectionChangelogCheck))
	(WebUI.verifyElementPresent(SectionChangelogCheck, 5))
} else {
keylogger.markFailed("Error Process")
}

WebUI.delay(5)

WebUI.takeScreenshot()
WebUI.scrollToElement(btnBackToBucketList,5)
WebUI.waitForElementVisible(btnBackToBucketList, 5)

WebUI.click(btnBackToBucketList)

WebUI.delay(5)
WebUI.refresh()

WebUI.waitForPageLoad(50)