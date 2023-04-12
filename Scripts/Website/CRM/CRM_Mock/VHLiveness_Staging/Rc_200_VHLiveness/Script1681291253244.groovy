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

/*
 * This part I want to set RC 200 Verihub Liveness
 * */

'Logging init'
KeywordUtil keylogger = new KeywordUtil()

'Open Mock Web'
WebUI.openBrowser(GlobalVariable.UrlWiremock)

'Set window is maximize'
WebUI.maximizeWindow()

'Identify We are on Mock'
TestObject mockServer = new TestObject().addProperty('text',ConditionType.CONTAINS,'Available Mappings')

boolean checkConditionMockServer = WebUI.waitForElementVisible(mockServer, 5)

if (checkConditionMockServer == true) {
	
	if (WebUI.waitForElementVisible(fieldInputKeyword, 5)) {
		
		WebUI.setText(fieldInputKeyword, 'CRMF Verihub Liveness')
		
		WebUI.sendKeys(fieldInputKeyword, Keys.chord(Keys.ENTER))
		
		TestObject checkConfigAvailable = new TestObject().addProperty('text',ConditionType.CONTAINS,'CRMF Verihub Liveness')
		
		boolean isAvailable = WebUI.waitForElementVisible(checkConfigAvailable, 5)
		
		if (isAvailable == true) {
			
			keylogger.logInfo('Already to setup status internal server error')
			
			WebUI.click(iconViewConf)
			
			boolean isAvailaibleDrpDwn = WebUI.waitForElementVisible(drpDwnStatus, 5)
			
			if (isAvailaibleDrpDwn == true) {
				
				WebUI.selectOptionByValue(drpDwnStatus, "200", false)
				
				String body = '{"liveness":{"status":true,"probability":"100"}}'
				
				WebUI.setText(txtFieldBodyRes, body)
				
				WebUI.delay(3)
				
				WebUI.click(btnJsnFormat)
				
				WebUI.click(btnSubmit)
				
				WebUI.closeBrowser()
				
			} else {
				
				keylogger.markFailed('Failed to check drop down')
				
			}
			
			WebUI.closeBrowser()
			
		} else {
			
			keylogger.markFailed('Failed to disable FM Dukcapil')
			
		}
		
	} else {
		
		keylogger.markFailed('Field input keyword')
		
	}
	
}