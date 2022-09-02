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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil
import org.bouncycastle.crypto.ec.CustomNamedCurves
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

/*'Declaration keylog forloggin'*/
KeywordUtil keyLogger = new KeywordUtil()

/* Wait until table CSR Management is exists*/
WebUI.waitForElementPresent(table, 10)

/* Fill field KTP number with existing account number*/
WebUI.setText(fieldKTP, ktpNumber)

/* Press enter from keyboard in field KTP number*/
WebUI.sendKeys(fieldKTP, Keys.chord(Keys.ENTER))

/* Declarate variable isObjectNotFound as boolean
 * to save value from verify element objectNotFound is exists or not*/
boolean isObjectNotFound = WebUI.waitForElementPresent(objectNotFound, 3)
	
/* The purpose of this conditional is to verify if the customer data is not found or not.*/
if(isObjectNotFound) {
	
	/* Storing text of not found to variable actTxtNotFound*/
	actTxtNotFound = WebUI.getText(objectNotFound)
	
	/* The purpose of this conditional is to verify the present first text of data not found*/
	if(actTxtNotFound.equals(expTxtNotFound)){
		
		/* The purpose of this conditional is to verify the present second text of data not found*/
		if (WebUI.verifyTextPresent(expSecTxtNotFound, false)) {
			
			/* Print info the customer is found*/
			println "Customer with KTP Number "+ktpNumber+" is not found. Case success"
			
		} else {
			
			/* Take screenshot, mark as failed case and print info message error*/
			WebUI.takeScreenshot()
			keyLogger.markFailed("Text "+expSecTxtNotFound+" is not present")
			
		}
		
	} else {
		
		/* Take screenshot, mark as failed case and print info message error*/
		WebUI.takeScreenshot()
		keyLogger.markFailed("Text "+expTxtNotFound+" is not present")
		
	}
	
	
} else {
	
	/* Take screenshot, mark as failed case and print info message error*/
	WebUI.takeScreenshot()
	keyLogger.markFailed("Customer with KTP Number "+ktpNumber+" is found. Case failed")
	
}

