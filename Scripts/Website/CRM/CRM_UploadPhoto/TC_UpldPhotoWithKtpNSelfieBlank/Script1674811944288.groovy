import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.nio.file.Files as Files
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths

import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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

'Init Logging'
KeywordUtil keylogger = new KeywordUtil()

'Init Upload path KTP'
String custIdPict = RunConfiguration.getProjectDir()
Path custIdPictPath = Paths.get(custIdPict)
Path custIdPictDataFile = custIdPictPath.resolve('resources/images/KTP.jpeg')
File custIdPictFileDir = custIdPictDataFile.toFile()
println(custIdPictFileDir)
String fileUploadKtp = custIdPictFileDir

'Init Upload path Photo Selfie'
String custPhotoSelfie = RunConfiguration.getProjectDir()
Path custPhotoSelfiePath = Paths.get(custPhotoSelfie)
Path custPhotoSelfieDataFile = custPhotoSelfiePath.resolve('resources/images/FotoSelfie.jpeg')
File custPhotoSelfieFileDir = custPhotoSelfieDataFile.toFile()
println(custPhotoSelfieFileDir)
String fileUploadPhotoSelfie = custPhotoSelfieFileDir

'Scenario Test'
/*
 Precondition
	- Has roles upload photo in Keycloak
	- Already login to CRMF
	- Already search request id with Customer type: Nasabah Senyumku, Origin: Tunaiku Reject, and Status: Selesai
	- Both photo Selfie and eKTP of customer are blank

 Steps
 	- Click button choose file in section photo eKTP
	- Choose photo
	- Click OK
	- Click button choose file in section photo Selfie
	- Choose photo
	- Click OK
	- Click button 'Upload Foto'

 Expected Result
	- Button 'Upload Foto' will enable
	- Show message success 'Foto berhasil diupload'
	- Show file name of images selfie and eKTP
	- Message success can be closed
	- Buton "Choose file" still enable
	- In DB log agent who uploaded the photo will recorded
	- In DB photo eKTP will convert into link to GCS photo
	- In GCS photo will uploaded with format name image [app_id]-ktp and [app-id]-selfie without the extension file
	- Both photo will updated in CSR Detail
	- Both photo will updated in KYC Verification (if the customer do request like changephone or reactivation)

 * */

'I want to access CSR Management'
WebUI.click(linkMenuCsrMgt)
if (WebUI.waitForElementVisible(alertText, 5)) {
	WebUI.click(btnCancel)
	keylogger.logInfo('We success to unblock the pending')
	WebUI.waitForPageLoad(5)
} else {
	keylogger.logInfo('We can continue the process')
	WebUI.waitForPageLoad(5)
}

'I want to search request ID based on the condition'
if (WebUI.waitForElementVisible(txtFieldAccountBank, 5)) {
	WebUI.setText(txtFieldAccountBank, GlobalVariable.accountBank)
	WebUI.click(btnSearch)
	keylogger.markPassed('We already to check the data')
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
} else {
	keylogger.markFailed('Field text account bank doesn"t exist')
}

'I want to check the data to keep the request ID'
WebDriver driver = DriverFactory.getWebDriver()
WebElement tblCsr = driver.findElement(By.xpath('//table/tbody'))
List<WebElement> rowCsr = tblCsr.findElements(By.tagName('tr'))
List<WebElement> colsCsr = rowCsr.get(0).findElements(By.tagName('td'))

'I want makesure the data available'
if (colsCsr.get(4).getText().equalsIgnoreCase(GlobalVariable.accountBank)) {
	colsCsr.get(6).findElement(By.xpath('button')).click()
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
	keylogger.markPassed('We success to access the data to take the request Id')
} else {
	keylogger.markFailed('We doesnt get the data')
}

'We try to get the request ID'
TestObject weInTheDetailCsr = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
if (WebUI.waitForElementVisible(weInTheDetailCsr, 5)) {
	reqIdCsr = WebUI.getText(txtReqIdCsr)
	keylogger.markPassed('We already capture the request ID')
	WebUI.click(btnBackBucket)
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
	TestObject weInBucketList = new TestObject().addProperty('text',ConditionType.CONTAINS,'CSR Management')
	WebUI.waitForElementVisible(weInBucketList, 5)
} else {
	keylogger.markFailed('We failed to capture request ID')
}

String reqId = reqIdCsr

'We want access menu upload photo'
if (WebUI.waitForElementVisible(linkMenuUploadPhoto, 5)) {
	WebUI.click(linkMenuUploadPhoto)
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
	TestObject weInUploadPhoto = new TestObject().addProperty('text',ConditionType.CONTAINS,'Upload Photo')
	WebUI.waitForElementVisible(weInUploadPhoto, 5)
	keylogger.markPassed('We are success to access the menu Upload Photo')
} else {
	keylogger.markFailed('Menu Upload Photo not visible')
}

'We want check the data in upload photo'
WebUI.setText(txtFieldReqId, reqId)
WebUI.click(btnSearchUplPhto)
if (WebUI.waitForElementVisible(txtReqIdPhtUpl, 5)) {
	reqIdUpPht = WebUI.getText(txtReqIdPhtUpl)
	if (WebUI.verifyEqual(reqIdUpPht, reqId, FailureHandling.OPTIONAL)) {
		'I want to upload foto KTP'
		if (WebUI.waitForElementVisible(btnUplKtp, 5)) {
			WebUI.uploadFile(btnUplKtp, fileUploadKtp)
			WebUI.waitForPageLoad(5)
			WebUI.delay(3)
			keylogger.markPassed('Upload KTP Success')
		} else {
			keylogger.markFailed('Upload KTP Failed')
		}
		'I want to upload Photo Selfie'
		if (WebUI.waitForElementVisible(btnUplSelfie, 5)) {
			WebUI.uploadFile(btnUplSelfie, fileUploadPhotoSelfie)
			WebUI.waitForPageLoad(5)
			WebUI.delay(3)
			keylogger.markPassed('Upload Photo Selfie Success')
		} else {
			keylogger.markFailed('Upload Photo Selfie Failed')
		}
		'I want click button upload'
		if (WebUI.waitForElementClickable(btnUpload, 5)) {
			WebUI.click(btnUpload)
			WebUI.waitForPageLoad(5)
			WebUI.delay(3)
			TestObject successMessage = new TestObject().addProperty('text',ConditionType.CONTAINS,'Foto berhasil diupload')
			if (WebUI.waitForElementVisible(successMessage, 5)) {
				keylogger.markPassed('Photo Success to Upload')
			} else {
				keylogger.markFailed('Foto Failed to Upload')
			}
			keylogger.markPassed('Button Upload Success to click')
		} else {
			keylogger.markFailed('Button Upload cannot click')
		}
	} else {
		keylogger.markFailed('request ID existing not same')
	}
} else {
	keylogger.markFailed('Field Request ID is Not Visible')
}

'I want to access again CSR Management to check the photo'
WebUI.click(linkMenuCsrMgt)
if (WebUI.waitForElementVisible(alertText, 5)) {
	WebUI.click(btnCancel)
	keylogger.logInfo('We success to unblock the pending')
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
} else {
	keylogger.logInfo('We can continue the process')
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
}

'I want to check photo upload'
if (WebUI.waitForElementVisible(txtFieldReqID, 5)) {
	WebUI.setText(txtFieldReqID, reqId)
	WebUI.click(btnSearch)
	keylogger.markPassed('We already to check the data')
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
} else {
	keylogger.markFailed('Field text account bank doesn"t exist')
}

'I want to check the data to keep the request ID'
WebDriver driverCsr = DriverFactory.getWebDriver()
WebElement tblCsrBack = driverCsr.findElement(By.xpath('//table/tbody'))
List<WebElement> rowCsrBack = tblCsrBack.findElements(By.tagName('tr'))
List<WebElement> colsCsrBack = rowCsrBack.get(0).findElements(By.tagName('td'))

'I want makesure the data available'
if (colsCsrBack.get(4).getText().equalsIgnoreCase(GlobalVariable.accountBank)) {
	colsCsrBack.get(6).findElement(By.xpath('button')).click()
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
	keylogger.markPassed('We success to access the data to check the photo')
} else {
	keylogger.markFailed('We doesnt get the data')
}

'We try to get the request ID'
TestObject weBackInTheDetailCsr = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
if (WebUI.waitForElementVisible(weBackInTheDetailCsr, 5)) {
	keylogger.markPassed('We already in CSR Details')
	WebUI.scrollToElement(dataEmail, 5)
	WebUI.click(dataFotoAndKtp)
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
	WebUI.takeScreenshot()
} else {
	keylogger.markFailed('We failed to access CSR Detail')
}
