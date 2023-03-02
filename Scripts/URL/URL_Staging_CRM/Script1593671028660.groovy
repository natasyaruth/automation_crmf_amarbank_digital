import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.util.CryptoUtil
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

'Initial logging'
KeywordUtil keylogger = new KeywordUtil()

/* Set up list value set web driver preferences property*/
RunConfiguration.setWebDriverPreferencesProperty('args', listValue)
RunConfiguration.setWebDriverPreferencesProperty('prefs', listOfPrefs)
RunConfiguration.setWebDriverPreferencesProperty('pageLoadStrategy', 'eager')

'Set access keyclock for by pass google auth'
WebUI.openBrowser(GlobalVariable.siteUrlKeyclock)

'Set window is maximize'
WebUI.maximizeWindow()

'Set access username & password for staging keyclock'
TestObject keyclockLoginPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'Sign in to your account')

if (WebUI.waitForElementVisible(keyclockLoginPage, 5)) {
	
	
	WebUI.setText(FieldUsernameKeyclock, CryptoUtil.decode(CryptoUtil.getDefault(usernameKeyclock)))
	
	WebUI.setText(FieldPasswordKeyclock, CryptoUtil.decode(CryptoUtil.getDefault(passwordKeyclock)))
	
	boolean ButtonLogin = WebUI.waitForElementVisible(btnLoginKeyclock, 5)
	
	if (ButtonLogin == true) {
		
		WebUI.click(btnLoginKeyclock)
		
		keylogger.markPassed("Success to access keyclock for by pass google auth")
		
		WebUI.waitForPageLoad(10)
		
	} else {
		
		keylogger.markFailed("Failed to access keyclock please check login account")
		
	}
	
} else {
	
	keylogger.markFailed("Keyclock access cannto found")
	
}

'try get new URL'
String newUrl = WebUI.getUrl()


/* Set input username & password basic auth on browser web page */
WebUI.navigateToUrl((((('https://' + GlobalVariable.authUsername) + ':') + GlobalVariable.authPassword) + '@') + newUrl.substring(
        8))

/* Set navigate to setup URL */
//WebUI.navigateToUrl(GlobalVariable.siteUrl)
WebUI.navigateToUrl(newUrl)

