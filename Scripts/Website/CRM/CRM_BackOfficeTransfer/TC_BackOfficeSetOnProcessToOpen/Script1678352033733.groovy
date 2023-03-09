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

/*Scenario
 * 
 * Test Case
 * This Part I created for set data on Process to Open in Back Office
 * Because The Data still in process and doesn't have in Open List
 * */

'Initial log in katalon'
KeywordUtil keylogger = new KeywordUtil()

'I want to identification we are on landing page on dashboard'
TestObject landingInDashboard = new TestObject().addProperty('text',ConditionType.CONTAINS,'DashBoard')

boolean landingDashboard = WebUI.waitForElementVisible(landingInDashboard, 5)

if (landingDashboard == true) {
	
	keylogger.markPassed("We are login in dashboard")
	
	'I want to verify and choose Rows'
	boolean checkShowData = WebUI.verifyOptionsPresent(drpDwnRows, listDrpDwnRows)
	
	if (checkShowData == true) {
		
		keylogger.markPassed("Optional Rows is Correct")
		
		WebUI.selectOptionByIndex(drpDwnRows, 1)
		
		WebUI.click(chkAllBtnSelect)
		
	} else {
		
		keylogger.markFailed("Optional Rows is Wrong")
		
	}
	
	'I want to verify and choose status'
	boolean checkDrpDwnStatus = WebUI.verifyOptionsPresent(drpDwnStatus, listDrpDwnStatus)
	
	if (checkDrpDwnStatus == true) {
		
		keylogger.markPassed("Status is match")
		
		WebUI.selectOptionByIndex(drpDwnStatus, 0)
		
	} else {
		
		keylogger.markFailed("Status is not match")
		
	}
	
	'I want to verify and check the button already to click and available'
	boolean checkButtonUpdate = WebUI.verifyElementClickable(btnUpdateAll)
	
	if (checkButtonUpdate == true) {
		
		keylogger.markPassed("Button is click able")
		
		WebUI.click(btnUpdateAll)
		
	} else {
		
		keylogger.markFailed("Button can't click")
		
	}
	
} else {
	keylogger.markFailed('We not in dashboard landing page')
}
