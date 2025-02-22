import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.awt.Robot
import java.awt.event.KeyEvent
import java.sql.Driver

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

'Initial loggin in katalon'
KeywordUtil keylogger = new KeywordUtil()

/* we want to check availability elemet h1 dashboard */
WebUI.waitForElementVisible(headerDashboardElement, 10)

/* we want check the text as we know is dashboard */
WebUI.verifyTextPresent(headerDashboardText, false)

if (WebUI.verifyElementClickable(menuKYCManagement)) {
	WebUI.click(menuKYCManagement)
	if (WebUI.verifyElementClickable(videoKYCRequest)) {
		WebUI.click(videoKYCRequest)
		WebUI.waitForPageLoad(5)
		WebUI.delay(3)
		TestObject alertActiveCall = new TestObject().addProperty('text',ConditionType.CONTAINS,'Konfirmasi')
		boolean popUpActiveCall = WebUI.waitForElementVisible(alertActiveCall, 5)
		if (popUpActiveCall == true) {
			WebUI.click(btnResumActive)
			TestObject KycVidReq = new TestObject().addProperty('text',ConditionType.CONTAINS,"KYC Video Request")
			boolean inKycVidReq = WebUI.waitForElementVisible(KycVidReq, 5)
			if (inKycVidReq == true) {
				keylogger.logInfo("We want to cancel active call")
				WebUI.click(btnCancel)
			} else {
				keylogger.markFailed("We aren't in kyc video call")
			}
		} else {
			keylogger.logInfo("We can continue the process")
		}
	} else {keylogger.markError('Button KYC video request')}
}else {keylogger.markError('Button cannot click able')}

'We in page KYC video request'
TestObject kycVideoPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
if (WebUI.verifyElementPresent(kycVideoPage, 5)) {
	keylogger.markPassed('We are in kyc page')
	if (WebUI.verifyElementClickable(idleCallsTab)) {
		WebUI.click(idleCallsTab)
		'We want unblock process'
		if (WebUI.waitForElementVisible(txtNotifBlockConfirmation,5)) {
			WebUI.click(btnAbortBlock)
		} else {keylogger.logInfo('notification not pop up')}
	} else {keylogger.markError('Tab idle calls is disable')}
} else {keylogger.markError('We are not in kyc page')}

'Initial HTML choosen process'
checkData = false
checkLoopData:
while (checkData == false) {
	WebDriver driverKycVideo = DriverFactory.getWebDriver()
	WebElement tblKycVideo = driverKycVideo.findElement(By.xpath('//table/tbody'))
	List<WebElement> rowsKycVideo = tblKycVideo.findElements(By.tagName('tr'))
	if (WebUI.verifyOptionsPresent(drpDwnCustType, listCustType)) {
		WebUI.selectOptionByLabel(drpDwnCustType, 'Nasabah Senyumku', false)
		WebUI.delay(5)
		for (i = 0;i < rowsKycVideo.size(); i++) {
			List<WebElement> colsKycVideo = rowsKycVideo.get(i).findElements(By.tagName('td'))
			if (colsKycVideo.get(5).getText().equalsIgnoreCase('Nasabah Senyumku')) {
				keylogger.markPassed('We already to click the Kyc Vidio')
				colsKycVideo.get(1).findElement(By.tagName('a')).click()
				WebUI.waitForPageLoad(5)
				WebUI.delay(3)
				break checkLoopData
			} else {keylogger.logInfo('we cannot get name Nasabah Senyumku')}
		}
	} else {keylogger.markError('Drop down not present')}
}

TestObject kycVideoDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
if (WebUI.verifyElementPresent(kycVideoDetail, 5)) {
	if (WebUI.verifyElementVisible(txtReqId)) {
		reqIdDetail = WebUI.getText(txtReqId)
	} else {keylogger.markError('We not find the request Id')}
	reqIdUsed = reqIdDetail
	println(reqIdUsed)
	String currentPage = WebUI.getUrl()
	int currentTab = WebUI.getWindowIndex()
	WebDriver driver = DriverFactory.getWebDriver()
	JavascriptExecutor js = ((driver) as JavascriptExecutor)
	js.executeScript('window.open();')
	WebUI.switchToWindowIndex(currentTab + 1)
	String requestIdProcess = path +reqIdUsed
	WebUI.navigateToUrl((((('https://' + GlobalVariable.authUsername) + ':') + GlobalVariable.authPassword) + '@') + requestIdProcess.substring(
		8))
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
} else {keylogger.markError('we are not in KYC video detail')}

'We want ended the video call'
if (WebUI.verifyElementClickable(btnEndVideoCall)) {
	WebUI.click(btnEndVideoCall)
	WebUI.takeScreenshot()
} else {keylogger.markError('button is disable')}

boolean checkData = false
loopCheckKelurahan:
while (checkData == false) {
		WebUI.scrollToElement(btnAbortKyc, 5)
			WebUI.delay(5)
			if (WebUI.verifyElementVisible(btnAbortKyc)) {
				WebUI.takeScreenshot()
				WebUI.click(btnAbortKyc)
				WebUI.delay(5)
				WebUI.click(linkDashboard)
				WebUI.waitForPageLoad(5)
				if (WebUI.waitForElementNotPresent(pendingRequest, 5)) {
					WebUI.takeScreenshot()
					keylogger.markPassed('Notification dissapear')
				} else {keylogger.markError('Pending request still visible')}
				break loopCheckKelurahan
			}else {keylogger.markError('button not visible')}
}
