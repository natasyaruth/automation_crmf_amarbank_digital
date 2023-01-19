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

WebUI.click(reqID)

if(WebUI.waitForElementVisible(btnReject, 10)) {
	
	WebUI.click(btnReject)
	
	if(WebUI.waitForElementVisible(modalReject, 10)) {
		
		WebUI.click(btnCancel)
		
		WebUI.waitForPageLoad(2)
		
		if(WebUI.waitForElementNotPresent(modalReject, 5)) {
			
			keyLogger.markPassed("Modal reject KYC Verification is dissapear. Case Success")
			
		} else {
			keyLogger.markFailed("Modal reject KYC Verification is not dissapear. Case Failed")
		}
	} else {
		keyLogger.markFailed("Modal reject KYC Verification is not appear. Case Failed")
	}
} else {
	keyLogger.markFailed("Something happened in KYC Verification detail. Page is not successfully loaded")
}

WebUI.click(btnBack)

