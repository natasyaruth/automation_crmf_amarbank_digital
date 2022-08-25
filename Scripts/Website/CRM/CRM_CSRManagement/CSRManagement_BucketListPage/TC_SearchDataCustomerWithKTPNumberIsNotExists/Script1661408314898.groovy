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

WebUI.waitForElementPresent(table, 10)

WebUI.setText(fieldKTP, ktpNumber)

WebUI.sendKeys(fieldKTP, Keys.chord(Keys.ENTER))

boolean isObjectNotFound = WebUI.waitForElementPresent(objectNotFound, 3)
	
if(isObjectNotFound) {
	
	actTxtNotFound = WebUI.getText(objectNotFound)
	
	if(actTxtNotFound.equals(expTxtNotFound)){
		
		if (WebUI.verifyTextPresent(expSecTxtNotFound, false)) {
			
			println "Customer with KTP Number "+ktpNumber+" is not found. Case success"
			
		} else {
			
			WebUI.takeScreenshot()
			keyLogger.markFailed("Text "+expSecTxtNotFound+" is not present")
			
		}
		
	} else {
		
		WebUI.takeScreenshot()
		keyLogger.markFailed("Text "+expTxtNotFound+" is not present")
		
	}
	
	
} else {
	
	WebUI.takeScreenshot()
	keyLogger.markFailed("Customer with KTP Number "+ktpNumber+" is found. Case failed")
	
}

