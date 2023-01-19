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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Initial logging'
KeywordUtil keylogger = new KeywordUtil()

'Scenario testing'
/* 
 Precondition
 User has access to KYC video request active calls

 Steps
 1. Input not valid request id in the request id search bar field
 2. Click search icon
 
 Expected Result
 -Clickable search icon
 -System display "Oops, Hasil pencarian tidak ditemukan" error message
 */

'We want to access Menu KYC Video Request'
if (WebUI.waitForElementVisible(menuKycManagement, 5)) {
	WebUI.click(menuKycManagement)
	if (WebUI.waitForElementVisible(menuKycVideoReq, 5)) {
		WebUI.click(menuKycVideoReq)
		
		'I want handle if drop off in idle calls'
		if (WebUI.waitForElementVisible(alertPending, 5)) {
			WebUI.click(btnCancelPending)
		} else {
			keylogger.logInfo('We dont have pending request')
		}
		
		' I want access to tab active calls'
		if (WebUI.waitForElementVisible(tabActiveCalls, 5)) {
			WebUI.click(tabActiveCalls)
		} else {
			keylogger.markError('We not found tab active calls')
		}
	} else {
		keylogger.markError('we not found the menu KYC video request')
	}
} else {
	keylogger.markError('we not found the KYC Management')
}

'I want to input invalid request ID in Active Calls'
WebUI.verifyElementClickable(btnSearchActiveCalls)
WebUI.verifyElementClickable(searchFieldActiveCalls)

'I want try search'
WebUI.setText(searchFieldActiveCalls, invalidReqId)
WebUI.click(btnSearchActiveCalls)
TestObject checkPopUp = new TestObject().addProperty('text',ConditionType.CONTAINS,'Oops, Hasil pencarian tidak ditemukan')
if (WebUI.waitForElementVisible(checkPopUp, 5)) {
	keylogger.markPassed('System display "Oops, Hasil pencarian tidak ditemukan" error message')
	WebUI.takeScreenshot()
} else {
	keylogger.markError('Handling Error not available')
}