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

/* Open Tab Active Call KYC Video*/
	WebUI.waitForElementVisible(TabActiveCall, 5)
	
	WebUI.click(TabActiveCall)
	
	/* We want grab first attribute from request ID*/
	def firstReqId = WebUI.getText(firstReqIdElement)
	
	/* We want insert request ID in search field request ID*/
	WebUI.setText(TxtSearchRequestID, firstReqId)
	
	/* We want verify button search in request Id visible*/
	WebUI.verifyElementVisible(BtnSearch)
	
	/* We want click button search request Id*/
	WebUI.click(BtnSearch)
	WebUI.delay(3)
	/* We want to verify the request Id*/
	WebUI.waitForElementVisible(firstReqIdElement, 5)
	def firstRequestID = WebUI.getText(firstReqIdElement)
	//def searchRequestId = WebUI.getText(TxtSearchRequestID)
	WebUI.verifyMatch(firstRequestID, firstReqId, false)
	
	/* We want capture the result*/
	WebUI.takeScreenshot()
	
	/* We want to refresh for the next process*/
	WebUI.refresh()