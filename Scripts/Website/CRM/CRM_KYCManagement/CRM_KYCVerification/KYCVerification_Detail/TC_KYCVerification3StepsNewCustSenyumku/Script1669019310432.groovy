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
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.DBData
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

'Init Random'
Random rand = new Random()

/* Precondition
	- Already Do KYC Video
	- Agent has click detail on bucketlist
	- Agent has process all steps in KYC Verification Detail
	- Agent has choose and filled history call
	
	Step
	- Agent click Terima 3 in steps 3 of detail
	
	Expected Result
	- Button "Terima 3" is enabled and agent can click it
	- Request ID is created as Nasabah Senyumku
	- The request id in KYC Verification bucketlist is dissapear
	- CIF dan bank account already created
	- When edit type delivery address -> "Kantor" in field "Alamat Pengiriman Kartu" CSR/KYC Video, show mapping address in CBS:

	- 01 get value from - KTP address
	- 02 get value from - alamat pengiriman kartu (delivery address)
	- 03 get value from - KTP adress
	- When edit type delivery address except "Kantor"in field "Alamat Pengiriman Kartu" CSR/ KYC Video, show mapping address in CBS :        

	- 01 get value from - KTP address
	- 02 get value from - alamat pengiriman kartu (delivery address)
	- 03 get value from - alamat pengiriman kartu (delivery address)

 * */

/* we want to check availability elemet h1 dashboard */
WebUI.waitForElementVisible(headerDashboardElement, 10)

/* we want check the text as we know is dashboard */
WebUI.verifyTextPresent(headerDashboardText, false)

if (WebUI.verifyElementClickable(menuKYCManagement)) {
	WebUI.click(menuKYCManagement)
	if (WebUI.verifyElementClickable(videoKYCRequest)) {
		WebUI.click(videoKYCRequest)
		TestObject confirmationContinueProcess = new TestObject().addProperty('text',ConditionType.CONTAINS,'Konfirmasi')
		if (WebUI.verifyElementPresent(confirmationContinueProcess, 5, FailureHandling.OPTIONAL)) {
			WebUI.click(btnBatalkan)
		} else {keylogger.logInfo('We continue the process')}
	} else {keylogger.markError('Button KYC video request')}
}else {keylogger.markError('Button cannot click able')}

'We in page KYC video request'
TestObject kycVideoPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
if (WebUI.verifyElementPresent(kycVideoPage, 5)) {
	keylogger.markPassed('We are in kyc page')
	if (WebUI.verifyElementClickable(idleCallsTab)) {
		WebUI.click(idleCallsTab)
		'We want unblock process'
		if (WebUI.waitForElementPresent(txtNotifBlockConfirmation,3)) {
			WebUI.click(btnAbortBlock)
		} else {keylogger.logInfo('notification not pop up')}
	} else {keylogger.markError('Tab idle calls is disable')}
} else {keylogger.markError('We are not in kyc page')}

'Initial HTML choosen process'
WebDriver driverKycVideo = DriverFactory.getWebDriver()
WebElement tblKycVideo = driverKycVideo.findElement(By.xpath('//table/tbody'))
List<WebElement> rowsKycVideo = tblKycVideo.findElements(By.tagName('tr'))
if (WebUI.verifyOptionsPresent(drpDwnCustType, listCustType)) {
	WebUI.selectOptionByLabel(drpDwnCustType, 'Nasabah Baru', false)
	WebUI.delay(5)
	int optionRand = 4
	Random randTimes = new Random()
	int indexElement = randTimes.nextInt(optionRand + 1)
	List<WebElement> colsKycVideo = rowsKycVideo.get(indexElement).findElements(By.tagName('td'))
	if (colsKycVideo.get(5).getText().equalsIgnoreCase('Nasabah Baru')) {
		keylogger.markPassed('We already to click the Kyc Vidio')
		colsKycVideo.get(1).findElement(By.tagName('a')).click()
	} else {keylogger.logInfo('we cannot get name Nasabah Baru')}
} else {keylogger.markError('Drop down not present')}

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
reqIdUsedGlobal = reqIdDetail
println(reqIdUsedGlobal)
'We want to confirmation process'
TestObject checkConfProcess = new TestObject().addProperty('text',ConditionType.CONTAINS,'Hal-hal yang perlu dikonfirmasi')
if (WebUI.verifyElementPresent(checkConfProcess, 5)) {
	WebUI.click(chkNamaKtp)
	WebUI.click(chkKtpNumber)
	WebUI.click(chkBirtDate)
	WebUI.click(chkMotherName)
	WebUI.click(chkDeliveryAddress)
	WebUI.click(chkShowKtp)
	WebUI.click(chkShowFace)
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

		WebUI.scrollToElement(btnKycFinished,5)
		if (WebUI.verifyElementVisible(btnKycFinished)) {
			WebUI.click(btnKycFinished)
			WebUI.delay(5)
			'We try to fill the history call'
			TestObject historyCallCheck = new TestObject().addProperty('text',ConditionType.CONTAINS,'Keterangan History Call')
			if (WebUI.verifyElementPresent(historyCallCheck, 5)) {
				WebUI.click(chkCustNotSame)
				WebUI.delay(5)
				if (WebUI.verifyElementClickable(btnSentKycVideo)) {
					WebUI.click(btnSentKycVideo)
					WebUI.delay(5)
					TestObject successSendKyc = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video berhasil dikirim')
					if (WebUI.verifyElementPresent(successSendKyc, 5)) {
						WebUI.takeScreenshot()
						WebUI.click(btnCloseKyc)
						WebUI.delay(5)
						WebUI.click(linkDashboard)
						WebUI.waitForPageLoad(5)
						if (WebUI.waitForElementNotPresent(pendingRequest, 5)) {
							WebUI.takeScreenshot()
							keylogger.markPassed('Notification dissapear')
						} else {keylogger.markError('Pending request still visible')}
					} else {keylogger.markError('Element not present')}
				} else {keylogger.markError('Button send KYC video not click able')}
			} else {keylogger.markError('We cannot in check history')}
		}else {keylogger.markError('button not visible')}

'Init selected web element KYC'
WebDriver driver = DriverFactory.getWebDriver()
WebElement tblKycVerif
List<WebElement> rowsKycVerif
List<WebElement> colsKycVerif

'We want do the 3 Steps button "terima"'
if (WebUI.verifyElementClickable(menuKYCManagement)) {
	WebUI.click(menuKYCManagement)
	if (WebUI.verifyElementClickable(menuKycVerification)) {
		WebUI.click(menuKycVerification)
	} else {keylogger.markError('Button KYC video request')}
}else {keylogger.markError('Button cannot click able')}
if (WebUI.waitForElementPresent(menuKycVerification, 5)) {
	tblKycVerif = driver.findElement(By.xpath('//table/tbody'))
	rowsKycVerif = tblKycVerif.findElements(By.tagName('tr'))
	colsKycVerif = rowsKycVerif.get(0).findElements(By.tagName('td'))
	if (colsKycVerif.get(7).getText().equalsIgnoreCase('Sedang diproses')) {
		colsKycVerif.get(7).findElement(By.xpath('a')).click()
		TestObject kycDetailPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Customer Detail')
		if (WebUI.verifyElementPresent(kycDetailPage, 5)) {
			WebUI.click(btnBackDashboard)
			WebUI.waitForPageLoad(5)
			TestObject kycBucketList = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Verification')
			WebUI.verifyElementPresent(kycBucketList, 5)
		} else {keylogger.markError('Element not present')}
	} else {keylogger.logInfo('Text is not found')}
} else {keylogger.markError('element not present')}

'We want to access the KYC Verif'
WebUI.setText(txtReqIdKycVerif, reqIdUsedGlobal)
WebUI.sendKeys(txtReqIdKycVerif, Keys.chord(Keys.ENTER))
tblKycVerif = driver.findElement(By.xpath('//table/tbody'))
rowsKycVerif = tblKycVerif.findElements(By.tagName('tr'))
colsKycVerif = rowsKycVerif.get(0).findElements(By.tagName('td'))
if (colsKycVerif.get(7).getText().equalsIgnoreCase('Menunggu')) {
	colsKycVerif.get(7).findElement(By.xpath('a')).click()
	TestObject kycDetailPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Customer Detail')
	if (WebUI.verifyElementPresent(kycDetailPage, 5)) {
		WebUI.scrollToElement(btnLiveness, 5)
		WebUI.click(btnLiveness)
		if (WebUI.waitForElementPresent(alretText, 5)) {
			WebUI.click(btnDoLiveness)
			WebUI.delay(5)
		} else {keylogger.markError('alert not present to konfirmation')}
		WebUI.scrollToElement(btnFaceMatch, 5)
		WebUI.click(btnFaceMatch)
		WebUI.delay(5)
		if (WebUI.waitForElementPresent(alretText, 5)) {
			WebUI.click(btnFmConfirmation)
			WebUI.delay(5)
		} else {keylogger.markError('alert not present to konfirmation')}
				WebUI.click(btnCheckDukcapil)
				WebUI.delay(5)
				TestObject ConfirmationCheckDukcapil = new TestObject().addProperty('text',ConditionType.CONTAINS,'Konfirmasi')
				if (WebUI.verifyElementPresent(ConfirmationCheckDukcapil, 5)) {
					WebUI.click(btnConfirmCheckDukcapil)
				} else {keylogger.logInfo('Dukcapil Already Process')}
				if (WebUI.waitForElementPresent(txtPersentageDukcapil, 5)) {
					WebUI.scrollToElement(btnTerima1, 5)
					WebUI.verifyElementClickable(btnTerima1)
					WebUI.click(btnTerima1)
					if (WebUI.waitForElementPresent(btnTerima2, 5)) {
					 	WebUI.scrollToElement(btnTerima2, 5)
						WebUI.verifyElementClickable(btnTerima2)
						WebUI.click(btnTerima2)
						if (WebUI.waitForElementPresent(btnTerima3, 5)) {
							WebUI.scrollToElement(btnTerima3, 5)
							WebUI.verifyElementClickable(btnTerima3)
							WebUI.click(btnTerima3)
						} else {keylogger.logInfo("element not present")}
					} else {keylogger.logInfo("element not present")}
					WebUI.delay(10)
					TestObject successProcessKyc = new TestObject().addProperty('text',ConditionType.CONTAINS,'Nasabah berhasil diverifikasi')
					if (WebUI.verifyElementPresent(successProcessKyc, 5)) {
						WebUI.click(btnBackToKycManagement)
					} else {keylogger.logInfo('Element not present')}
					if (WebUI.waitForElementPresent(txtReqIdKycVerif, 5)) {
						WebUI.setText(txtReqIdKycVerif, reqIdUsedGlobal)
					} else {keylogger.logInfo("Element not present")}
				} else {
					TestObject nikNotFound = new TestObject().addProperty('text',ConditionType.CONTAINS,'NIK tidak ditemukan')
					WebUI.verifyElementPresent(nikNotFound, 5)
					WebUI.click(btnEditDataKtp)
					DBData listIdUsers = findTestData("Data Files/Website/Dataset_KTP/Dataset_KTP")
					int rowCount = listIdUsers.getRowNumbers()
					rowNum= (rand.nextInt(rowCount - 1) + 1)
					String KtpNumberRandomize = listIdUsers.getValue(2, rowNum)
					if (WebUI.waitForElementPresent(txtNikField, 5)) {
						WebUI.setText(txtNikField, KtpNumberRandomize)
					} else {keylogger.logInfo("element not present")}
					WebUI.click(btnSaveKtpData)
					WebUI.verifyElementClickable(btnCheckDataDukcapil)
				}
	} else {keylogger.markError('Element not present')}
} else {keylogger.logInfo('Text is not found')}