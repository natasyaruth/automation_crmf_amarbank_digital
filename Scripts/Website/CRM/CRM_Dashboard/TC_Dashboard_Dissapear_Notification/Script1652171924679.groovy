import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebElement as Keys
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

'Initial loggin in katalon'
KeywordUtil keylogger = new KeywordUtil()

/* we want to check availability elemet h1 dashboard */
WebUI.waitForElementVisible(headerDashboardElement, 10)

/* we want check the text as we know is dashboard */
WebUI.verifyTextPresent(headerDashboardText, false)

if (WebUI.verifyElementClickable(menuKYCManagement,FailureHandling.OPTIONAL)) {
	WebUI.click(menuKYCManagement)
	if (WebUI.verifyElementClickable(videoKYCRequest,FailureHandling.OPTIONAL)) {
		WebUI.click(videoKYCRequest)
	} else {keylogger.markError('Button KYC video request')}
}else {keylogger.markError('Button cannot click able')}
'We want unblock process'
if (WebUI.verifyElementVisible(txtNotifBlockConfirmation,FailureHandling.OPTIONAL)) {
	WebUI.click(btnAbortBlock)
} else {keylogger.logInfo('notification not pop up')}

///* We want handle if we have notification to continue kyc process*/
//if (WebUI.verifyElementPresent(notificationVideoPendingElement, 5, FailureHandling.OPTIONAL)) {
//	kycVideoText = WebUI.getText(notificationVideoPendingElement)
//	WebUI.verifyElementText(notificationVideoPendingElement, kycVideoText)
//	WebUI.click(notificationVideoPendingElement)
//	WebUI.verifyElementPresent(btnBackVideoRequestElement, 5)
//	WebUI.click(btnBackVideoRequestElement)
//}else {
//	if (WebUI.verifyElementVisible(videoKYCRequest, FailureHandling.OPTIONAL)) {
//		/* We want goes to access video kyc request*/		
//		WebUI.verifyElementPresent(videoKYCRequest, 5)
//		WebUI.click(videoKYCRequest)
//	} else {
//		/* we want to verify element on KYC video request*/
//		WebUI.verifyElementPresent(menuKYCManagement, 10)
//		WebUI.click(menuKYCManagement)
//		WebUI.verifyElementPresent(videoKYCRequest, 5)
//		WebUI.click(videoKYCRequest)
//	}
//}

'We in page KYC video request'
TestObject kycVideoPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
if (WebUI.verifyElementPresent(kycVideoPage, 5,FailureHandling.OPTIONAL)) {
	keylogger.markPassed('We are in kyc page')
	if (WebUI.verifyElementClickable(idleCallsTab,FailureHandling.OPTIONAL)) {
		WebUI.click(idleCallsTab)
	} else {keylogger.markError('Tab idle calls is disable')}
} else {keylogger.markError('We are not in kyc page')}

'Initial HTML choosen process'
WebDriver driverKycVideo = DriverFactory.getWebDriver()
WebElement tblKycVideo = driverKycVideo.findElement(By.xpath('//table/tbody'))
List<WebElement> rowsKycVideo = tblKycVideo.findElements(By.tagName('tr'))
if (WebUI.verifyOptionsPresent(drpDwnCustType, listCustType,FailureHandling.OPTIONAL)) {
	WebUI.selectOptionByLabel(drpDwnCustType, 'Nasabah Baru', false)
	List<WebElement> colsKycVideo = rowsKycVideo.get(0).findElements(By.tagName('td'))
	if (colsKycVideo.get(5).getText().equalsIgnoreCase('Nasabah Baru')) {
		keylogger.markPassed('We already to click the Kyc Vidio')
		colsKycVideo.get(1).findElement(By.tagName('a')).click()
	} else {keylogger.logInfo('we cannot get name Nasabah Baru')}
} else {keylogger.markError('Drop down not present')}

TestObject kycVideoDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
if (WebUI.verifyElementPresent(kycVideoDetail, 5,FailureHandling.OPTIONAL)) {
	if (WebUI.verifyElementVisible(txtReqId,FailureHandling.OPTIONAL)) {
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
	WebUI.navigateToUrl((((('https://' + GlobalVariable.authUsername) + ':') + GlobalVariable.authPassword) + '@') + path +reqIdUsed.substring(
		8))
//	WebUI.navigateToUrl(currentPage)
//	WebUI.navigateToUrl(path +reqIdUsed)
//	WebUI.switchToWindowIndex(currentTab)
//	WebUI.navigateToUrl(currentPage)
	TestObject videoCallValidation = new TestObject().addProperty('text',ConditionType.CONTAINS,'Verifikasi datamu lewat video call!')
	if (WebUI.verifyElementPresent(videoCallValidation, 5,FailureHandling.OPTIONAL)) {
		if (WebUI.verifyElementClickable(btnCallSenyumku,FailureHandling.OPTIONAL)) {
			WebUI.click(btnCallSenyumku)
			TestObject txtVerifConnect = new TestObject().addProperty('text',ConditionType.CONTAINS,'Kamu akan terhubung dengan tim Senyumku')
			if (WebUI.verifyElementPresent(txtVerifConnect, 0,FailureHandling.OPTIONAL)) {
				WebUI.switchToWindowIndex(0)
				TestObject backToKycVideo = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
				WebUI.verifyElementPresent(backToKycVideo, 5)
				WebUI.refresh()
				WebUI.delay(5)
			} else {keylogger.logInfo('Element not present')}
		} else {keylogger.markError('button cannot click able')}
	} else {keylogger.markError('We are not in verification data')}
} else {keylogger.markError('we are not in KYC video detail')}

'We want to confirmation process'
TestObject checkConfProcess = new TestObject().addProperty('text',ConditionType.CONTAINS,'Hal-hal yang perlu dikonfirmasi')
if (WebUI.verifyElementPresent(checkConfProcess, 5,FailureHandling.OPTIONAL)) {
	WebUI.click(chkNamaKtp)
	WebUI.click(chkKtpNumber)
	WebUI.click(chkBirtDate)
	WebUI.click(chkMotherName)
	WebUI.click(chkDeliveryAddress)
	WebUI.click(chkShowKtp)
	WebUI.click(chkShowFace)
	WebUI.click(chkCaptureFace)
	if (WebUI.verifyElementClickable(btnSelfie,FailureHandling.OPTIONAL)) {
		WebUI.click(btnSelfie)
		if (WebUI.verifyElementVisible(imgSelfPhoto,FailureHandling.OPTIONAL)) {
			WebUI.verifyImagePresent(imgSelfPhoto, FailureHandling.STOP_ON_FAILURE)
			keylogger.markPassed('Photo is enable')
			WebUI.click(btnSaveSelfPhoto)
			TestObject saveConfirmation = new TestObject().addProperty('text',ConditionType.CONTAINS,'Konfirmasi')
			if (WebUI.verifyElementPresent(saveConfirmation, 5,FailureHandling.OPTIONAL)) {
				WebUI.click(btnSaveKyc)
				WebUI.verifyTextPresent('Foto berhasil disimpan', false)
			} else {keylogger.markError('element not present')}
		} else {keylogger.markError('Photo not enable')}
		WebUI.click(btnSelfie)
		if (WebUI.verifyElementVisible(imgKtpPhoto,FailureHandling.OPTIONAL)) {
			WebUI.verifyImagePresent(imgKtpPhoto, FailureHandling.STOP_ON_FAILURE)
			keylogger.markPassed('Photo is enable')
			WebUI.click(btnSaveKtpPhoto)
			TestObject saveConfirmation = new TestObject().addProperty('text',ConditionType.CONTAINS,'Konfirmasi')
			if (WebUI.verifyElementPresent(saveConfirmation, 5,FailureHandling.OPTIONAL)) {
				WebUI.click(btnSaveKyc)
				WebUI.verifyTextPresent('Foto berhasil disimpan', false)
			} else {keylogger.markError('element not present')}
		} else {keylogger.markError('Photo not enable')}
	} else {keylogger.markError('Button selfie belum dapat di lakukan')}
} else {keylogger.markError('Element not present')}
'We want ended the video call'
if (WebUI.verifyElementClickable(btnEndVideoCall,FailureHandling.OPTIONAL)) {
	WebUI.click(btnEndVideoCall)
	WebUI.takeScreenshot()
} else {keylogger.markError('button is disable')}

//
///* we want to capture KYC Management and KYC Video Request*/
//WebUI.takeScreenshot(FailureHandling.OPTIONAL)
//
///* we want to choose the idle calls tab*/
//WebUI.verifyElementPresent(idleCallsTab, 10)
//
///* we want click idle calls tab*/
//WebUI.click(idleCallsTab)
//
///* we want to verify element for request Id*/
//WebUI.verifyElementVisible(requestIdElement)
//
///* we want capture request Id in video request*/
//WebUI.takeScreenshot(FailureHandling.OPTIONAL)
//
///* we want to click the request Id*/
//WebUI.click(requestIdElement)
//
///* We just want to makesure we are in KYC Video detail*/
//WebUI.verifyElementText(headerPersonalIdentifierElement, headerPersonalIdentifierText)
//
///* we want check dashboard menu element*/
//WebUI.verifyElementPresent(dashboardMenuElement, 10)
//
///* we want to click dashboard menu*/
//WebUI.click(dashboardMenuElement)
//
///* we want check notification video pending*/
//WebUI.verifyElementPresent(notificationVideoPendingElement, 10)
//
///* we want capture the pending notification request*/
//WebUI.takeScreenshot(FailureHandling.OPTIONAL)
//
///* we want to click notification video pending*/
//WebUI.click(notificationVideoPendingElement)
//
///* we want to check element present video KYC request */
//WebUI.verifyElementPresent(headerKYCVideoRequestElement, 10)
//
///* we want to check text header KYC video request*/
//WebUI.verifyTextPresent(headerKYCVideoRequestText, false)
//
///* we want to check element present personal identifier*/
//WebUI.verifyElementPresent(headerPersonalIdentifierElement, 10)
//
///* we want verify text personal identifier*/
//WebUI.verifyTextPresent(headerPersonalIdentifierText, false)
//
///* we want to capture details in request ID*/
//WebUI.takeScreenshot(FailureHandling.OPTIONAL)
//
///* we want to verify button back for unlock pending request*/
//WebUI.verifyElementPresent(btnBackVideoRequestElement, 10)
//
///* we want to click button "kembali" to makesure the request id is unlock*/
//WebUI.click(btnBackVideoRequestElement)
//
///* we want check dashboard menu element*/
//WebUI.verifyElementPresent(dashboardMenuElement, 10)
//
///* we want to click dashboard menu*/
//WebUI.click(dashboardMenuElement)
//
///* we want to capture notification has been dissapear*/
//WebUI.takeScreenshot()
//
///* We want to verify to menu dashboard*/
//WebUI.verifyElementPresent(menuDashboardElement, 5)
//
///* We want to click back to dashboard*/
//WebUI.click(menuDashboardElement)