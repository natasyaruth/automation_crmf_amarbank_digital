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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
//import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('google.com')
openTab()

Void openTab() {

String currentPage = WebUI.getUrl()

int currentTab = WebUI.getWindowIndex()

WebUI.navigateToUrl('https://www.mediawiki.org/wiki/Special:Contributions/')

//TestObject helpButton = new TestObject('Help')
//
////helpButton.addProperty('class', ConditionType.EQUALS, 'mw-helplink', true)
//
//helpButton.addProperty('text', ConditionType.EQUALS, 'Help', true)
//
////helpButton.addProperty('tag', ConditionType.EQUALS, 'a', true)
//
//WebUI.click(helpButton)

//WebUI.sendKeys(findTestObject('txt_Comment'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(testObject, Keys.chord(Keys.CONTROL,Keys.click()))

WebUI.switchToWindowIndex(currentTab+1)

WebUI.navigateToUrl(currentPage)

/*TestObject body = new TestObject('body')

body.addProperty('tag', ConditionType.EQUALS, 'body')

WebUI.sendKeys(body, Keys.chord(Keys.CONTROL + Keys.SHIFT + Keys.TAB))*/

WebUI.switchToWindowIndex(currentTab)

WebUI.navigateToUrl(currentPage)

WebUI.switchToWindowIndex(currentTab+1)
}

WebUI.closeBrowser(FailureHandling.OPTIONAL)