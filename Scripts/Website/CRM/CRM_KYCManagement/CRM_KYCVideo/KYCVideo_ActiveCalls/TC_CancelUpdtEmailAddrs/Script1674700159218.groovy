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
import org.openqa.selenium.WebDriver as Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

'init Keylogger'
KeywordUtil keylogger = new KeywordUtil()

'Scenario Testing'
/* 	PRECONDITION
 * 	User has access to KYC video call customer details
	Customer has not verified the email
	
	STEPS
	Click "Batal" button in Alamat Email section

	EXPECTED RESULT
	System display uneditable email field, the data is back to the previous email
	System display enable "Edit" button
	System display disable "Save" button
 */

'We want to access KYC Video Request'
WebUI.click(linkMenuKycManagement)
if (WebUI.waitForElementVisible(linkMenuKycVideoVerif, 5)) {
	WebUI.click(linkMenuKycVideoVerif)
	'I want handle if any pending items in idle calls'
	if (WebUI.waitForElementVisible(alertText, 5)) {
		WebUI.click(btnCancelPending)
		WebUI.waitForPageLoad(5)
	} else {
		keylogger.logInfo('We dont see pending request active call')
	}
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
	WebDriver driverGetData = DriverFactory.getWebDriver()
	WebElement tableBucketVerif
	List<WebElement> rowBucketVerif
	List<WebElement> colsBucketVerif
	if (WebUI.waitForElementVisible(drpEmailType, 5)) {
		WebUI.selectOptionByLabel(drpEmailType, "Belum Terverifikasi", false)
		WebUI.selectOptionByLabel(drpCustType, 'Nasabah Baru', false)
		tableBucketVerif = driverGetData.findElement(By.xpath('//table/tbody'))
		rowBucketVerif = tableBucketVerif.findElements(By.tagName('tr'))
		colsBucketVerif = rowBucketVerif.get(0).findElements(By.tagName('td'))
		if (colsBucketVerif.get(2).getText().equalsIgnoreCase('Registrasi Baru')) {
			colsBucketVerif.get(7).findElement(By.xpath('a')).click()
			WebUI.waitForPageLoad(5)
			TestObject accessKycCustDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Customer Detail')
			if (WebUI.waitForElementVisible(accessKycCustDetail, 5)) {
				reqIdEmailNotVerif = WebUI.getText(reqIdKycDetail)
				WebUI.scrollToElement(btnProcessKycVideoCall, 5)
				WebUI.click(btnProcessKycVideoCall)
				WebUI.waitForPageLoad(5)
				WebUI.delay(3)
				TestObject reasonContKyc = new TestObject().addProperty('text',ConditionType.CONTAINS,'Alasan Lanjutkan KYC')
				if (WebUI.waitForElementVisible(reasonContKyc, 5)) {
					WebUI.click(chkLowLivenessScore)
					WebUI.click(btnSendReason)
					WebUI.waitForPageLoad(5)
					WebUI.delay(3)
				} else {
					keylogger.markError('Pop up "Alasa Lanjutkan KYC" not visible')
				}
			} else {
				keylogger.markError('We are not in KYC Customer Detail')
			}
		}
	} else {
		keylogger.markError('Drop down email type not visible')
	}
	if (WebUI.waitForElementVisible(linkMenuKycVideoReq, 5)) {
		WebUI.click(linkMenuKycVideoReq)
		WebUI.waitForPageLoad(5)
	} else {
		WebUI.click(linkMenuKycManagement)
		WebUI.click(linkMenuKycVideoReq)
		WebUI.waitForPageLoad(5)
	}
	
	'I want handle if any pending items in active calls'
	if (WebUI.waitForElementVisible(alertText, 5)) {
		WebUI.click(btnResume)
		'I want to click button batal KYC'
		WebUI.scrollToElement(btnCancelKyc,5)
		if (WebUI.verifyElementVisible(btnCancelKyc)) {
			WebUI.click(btnCancelKyc)
			WebUI.delay(5)
			TestObject backToKycBucket = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
			WebUI.waitForElementVisible(backToKycBucket, 5)
		} else {
			keylogger.markError('Button batal KYC not visible')
		}
	} else {
		keylogger.logInfo('element not visible we can continue the process')
	}
	WebUI.click(tabIdleCalls)
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
	WebDriver driver = DriverFactory.getWebDriver()
	WebElement tableBucketList
	List<WebElement> rowBucketList
	List<WebElement> colsBucketList
	checkReqId = false
	loopCheckData:
	while (checkReqId == false) {
		WebUI.selectOptionByLabel(drpCustType, 'Nasabah Baru', false)
		tableBucketList = driver.findElement(By.xpath('//table/tbody'))
		rowBucketList = tableBucketList.findElements(By.tagName('tr'))
		for (int i=0;i < rowBucketList.size();i++) {
			colsBucketList = rowBucketList.get(i).findElements(By.tagName('td'))
			if (colsBucketList.get(3).getText().equalsIgnoreCase('Registrasi Baru') && colsBucketList.get(7).getText().equalsIgnoreCase('Menunggu')) {
				colsBucketList.get(1).findElement(By.xpath('a')).click()
				WebUI.waitForPageLoad(5)
				TestObject inKycVideoReq = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
				if (WebUI.waitForElementVisible(inKycVideoReq, 5)) {
					requestIdKycVideo = WebUI.getText(reqId)
					break loopCheckData
				}
			} else {
				keylogger.logInfo('We want try to check another Request ID')
				tableBucketList = driver.findElement(By.xpath('//table/tbody'))
				rowBucketList = tableBucketList.findElements(By.tagName('tr'))
			}
		}
	}
} else {
	keylogger.markError('Link menu KYC Video Request Not Available')
}

'I want store request ID'
reqIKycVideo = requestIdKycVideo

'I want to open KYC Video Call'
TestObject kycVideoDetail = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
if (WebUI.verifyElementPresent(kycVideoDetail, 5)) {
	String currentPage = WebUI.getUrl()
	int currentTab = WebUI.getWindowIndex()
	WebDriver driver = DriverFactory.getWebDriver()
	JavascriptExecutor js = ((driver) as JavascriptExecutor)
	js.executeScript('window.open();')
	WebUI.switchToWindowIndex(currentTab + 1)
	String requestIdProcess = path +reqIKycVideo
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
				WebUI.waitForPageLoad(5)
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
	WebUI.click(chkAddressDeliveryCard)
	WebUI.click(chkShowIdCard)
	WebUI.click(ChkShowClearFace)
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
				TestObject saveIdPhoto = new TestObject().addProperty('text',ConditionType.CONTAINS,'Foto berhasil disimpan')
				WebUI.verifyElementPresent(saveIdPhoto, 5)
				keylogger.markPassed('Foto Success to save')
				WebUI.takeScreenshot()
			} else {keylogger.markError('element not present')}
		} else {keylogger.markError('Photo not enable')}
		
		'I want to see the button edit email and cancel for save Edit email'
		if (WebUI.waitForElementVisible(btnEditEmail, 5)) {
			WebUI.verifyElementClickable(btnEditEmail)
			WebUI.click(btnEditEmail)
			if (WebUI.waitForElementVisible(btnCancelUpdateEmail, 5)) {
				WebUI.verifyElementClickable(btnCancelUpdateEmail)
				WebUI.takeScreenshot()
				WebUI.click(btnCancelUpdateEmail)
				keylogger.markPassed('We already to cancel update email')
			} else {
				keylogger.markFailed('Button cancel update email disabled')
			}
		} else {
			keylogger.markFailed('Button is disable')
		}
	} else {keylogger.markError('Button selfie belum dapat di lakukan')}
} else {keylogger.markError('Element not present')}

'We want ended the video call'
if (WebUI.verifyElementClickable(btnEndVideoCall)) {
	WebUI.click(btnEndVideoCall)
	WebUI.takeScreenshot()
} else {keylogger.markError('button is disable')}

'I want to click button Success KYC'
WebUI.scrollToElement(btnEndKycVideoRequest,5)
if (WebUI.verifyElementVisible(btnEndKycVideoRequest)) {
	WebUI.click(btnEndKycVideoRequest)
	TestObject historyText = new TestObject().addProperty('text',ConditionType.CONTAINS,'Keterangan History Call')
	if (WebUI.waitForElementVisible(historyText, 5)) {
		WebUI.click(chkPhotoNotSame)
		WebUI.click(btnSendKycVideo)
		WebUI.waitForPageLoad(5)
		if (WebUI.waitForElementVisible(btnCloseKycVideo, 5)) {
			WebUI.click(btnCloseKycVideo)
		} else {
			keylogger.markError('Button close KYC Video doesn"t Appear')	
		}
	} else {
		keylogger.markFailed('text Keterangan History Call not available')
	}
	WebUI.delay(5)
	TestObject backToBucketList = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
	WebUI.waitForElementVisible(backToBucketList, 5)
} else {
	keylogger.markError('Button batal KYC not visible')
}
