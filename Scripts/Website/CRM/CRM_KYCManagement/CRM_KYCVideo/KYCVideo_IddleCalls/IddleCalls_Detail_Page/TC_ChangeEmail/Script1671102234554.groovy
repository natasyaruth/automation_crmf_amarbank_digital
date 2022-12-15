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

'init function'
KeywordUtil keylogger = new KeywordUtil()

'Scenario Testing'
/* 	Preconditions
 * 	- User has access to KYC video call customer details
	- Customer has not verified the email
	- User has click "Edit" button
	
	Steps
	- Input valid email address
	- Click "Save" button
	
	Expected Result
	- System display "Email berhasil disimpan" toast message
	- Email is updated to the new in CSR
 * */

'We want access to KYC Video Request'
if (WebUI.waitForElementVisible(menuKycManagement, 5)) {
	WebUI.click(menuKycManagement)
	if (WebUI.waitForElementVisible(menuKycVideoRequest, 5)) {
		WebUI.click(menuKycVideoRequest)
		'This part if we handle the "Konfirmasi alert"'
		if (WebUI.waitForElementVisible(alertNotif, 5)) {
			WebUI.click(btnAbort)
		} else {keylogger.logInfo("We can continue the process")}
		if (WebUI.waitForElementVisible(alertNotif, 5)) {
			WebUI.click(btnContinue)
			WebUI.scrollToElement(btnCancelVideoRequest, 5)
			WebUI.click(btnCancelVideoRequest)
		} else {keylogger.logInfo("We can continue the process")}
		TestObject accessKycVideoRequest = new TestObject().addProperty('text',ConditionType.CONTAINS,'KYC Video Request')
		if (WebUI.waitForElementVisible(accessKycVideoRequest, 5)) {
			WebUI.click(tabIdleCalls)
		} else {keylogger.markError("We are not in KYC Video Request")}
	} else {keylogger.markError("Menu KYC video request not visible")}
} else {keylogger.markError("Menu KYC Management not visible")}

