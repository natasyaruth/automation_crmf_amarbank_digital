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

/* Wait until table CSR Management is exists*/
WebUI.waitForElementPresent(table, 10)

/* Fill field name with existing customer name */
WebUI.setText(fieldName, custNameContainNumber)

/* Press enter from keyboard in field customer name*/
WebUI.sendKeys(fieldName, Keys.chord(Keys.ENTER))

/* The purpose of this conditional is to validate the message error in field customer name
 * is appear or not*/
if(WebUI.waitForElementPresent(msgValidationFieldName, 3)) {
	
	/* Verify the text message error */
	WebUI.verifyTextPresent(msgErrorFormatName, false)
	
} else {
	
	/* Take screenshot, mark as failed case and print info message error*/
	WebUI.takeScreenshot()
	keyLogger.markFailed("Message error "+msgErrorFormatName+" is not present")
	
}