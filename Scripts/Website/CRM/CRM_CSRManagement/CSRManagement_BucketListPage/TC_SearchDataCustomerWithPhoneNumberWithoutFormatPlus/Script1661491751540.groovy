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

/* Fill field KTP number with existing phonenumber*/
WebUI.setText(fieldPhoneNumber, "0"+phoneNumber)

/* Press enter from keyboard in field phonenumber*/
WebUI.sendKeys(fieldPhoneNumber, Keys.chord(Keys.ENTER))

/* Declarate variable isObjectNotFound as boolean
 * to save value from verify element objectNotFound is exists or not*/
boolean isObjectNotFound = WebUI.waitForElementPresent(objectNotFound, 3)
	
/* The purpose of this conditional is to verify if the customer data is not found or not.
 * If data is found, move to else for the next checking*/
if(isObjectNotFound) {
	
	/* Take screenshot, mark as failed case and print info message error*/
	WebUI.takeScreenshot()
	keyLogger.markFailed("Customer with Phonenumber "+"0"+phoneNumber+" is not found")
	
} else {
	
	/* Declarate variable WebDriver as driver */
	WebDriver driver = DriverFactory.getWebDriver()
	
	/* We will declarated variable 'tableCSR' to store the location of the table*/
    WebElement tableCSR = driver.findElement(By.xpath('//tbody'))

    /* We will declarated variable 'listRows' with type List to store
    all the element with tag 'tr' which means element that represent rows*/
    List<WebElement> listRows = tableCSR.findElements(By.tagName('tr'))

	/* We will declarated variable 'listColumn' with type List to store
	 all the element with tag 'td' which means element that represent column*/
    List<WebElement> listColumn = listRows.get(0).findElements(By.tagName('td'))
	
	/* Get phonenumber of customer from column with index 3 */
	actPhoneNumber = listColumn.get(3).getText()
	
	/* The purpose of this conditional is to verify the actual customer phonenumber same
	 * with expected customer phonenumber. */
	if(actPhoneNumber.equals("+62"+phoneNumber)) {
		
		/* Mark the case as Passed and print the message info*/
		keyLogger.markPassed("Customer with Phonenumber "+"0"+phoneNumber+" is found")
		
	} else {
		
		/* Take screenshot, mark as failed case and print info message error*/
		WebUI.takeScreenshot()
		keyLogger.markFailed("Customer with Phonenumber "+"0"+phoneNumber+" is not same")
		
		println "Actual Phone Number : "+actPhoneNumber+"\n"
                "Expected Phone Number : +62"+phoneNumber
	}
}

