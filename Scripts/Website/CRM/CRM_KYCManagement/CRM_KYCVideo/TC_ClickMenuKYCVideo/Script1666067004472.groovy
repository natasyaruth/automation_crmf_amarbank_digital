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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil

/*'Declaration keylog forloggin'*/
KeywordUtil keyLogger = new KeywordUtil()
/*'We want to makesure we can access KYC Management'*/
boolean checkMenuKYC = WebUI.verifyElementVisible(menuKYCManagement, FailureHandling.OPTIONAL)
if (checkMenuKYC == true) {
	WebUI.click(menuKYCManagement)
	
	WebUI.click(menuKYCVideo)
} else {
	keyLogger.markFailed("Something happen with menu KYC Management")
}

/*'We want to check blocked notification and check for text blocked
 * if alert confirmation pop up enable is true'*/
if (WebUI.waitForElementVisible(blockBylockedUserElement, 5, FailureHandling.OPTIONAL)) {
	
	boolean checkAlertProcess = WebUI.waitForElementPresent(btnCancelPopUpElement, 5)
	
	if (checkAlertProcess == true) {
		
		WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)
		WebUI.click(btnCancelPopUpElement)
		WebUI.waitForElementVisible(headerKYCVideoRequestElement, 10)
		WebUI.verifyElementText(headerKYCVideoRequestElement, headerKYCVideoRequestText)
		
	} else {
		
		WebUI.click(btnResumeKycVideo)
		WebUI.waitForElementVisible(headerKYCVideoRequestElement, 10)
		WebUI.verifyElementText(headerKYCVideoRequestElement, headerKYCVideoRequestText)
		WebUI.scrollToElement(btnCancelKycVideoActiveCalls, 3)
		WebUI.click(btnCancelKycVideoActiveCalls)
		WebUI.waitForPageLoad(5)
		WebUI.waitForElementVisible(headerKYCVideoRequestElement, 10)
		WebUI.verifyElementText(headerKYCVideoRequestElement, headerKYCVideoRequestText)
		WebUI.click(tabIddleCalls)
		WebUI.waitForPageLoad(5)
		
	}
	
} else {
	
	WebUI.verifyElementText(headerKYCVideoRequestElement, headerKYCVideoRequestText)
	
}