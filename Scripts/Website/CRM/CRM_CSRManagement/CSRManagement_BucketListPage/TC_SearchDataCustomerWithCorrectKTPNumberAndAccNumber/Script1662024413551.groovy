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

/* Press enter from keyboard in field KTP number*/
WebUI.setText(fieldKTP, ktpNumber)

/* Press enter from keyboard in field Account number*/
WebUI.setText(fieldAccNumber, accNumber)

/* Click button search */
WebUI.click(btnSearch)

/* Declarate variable isObjectNotFound as boolean
 * to save value from verify element objectNotFound is exists or not*/
boolean isObjectNotFound = WebUI.waitForElementPresent(objectNotFound, 3)
	
/* The purpose of this conditional is to verify if the customer data is not found or not.
 * If data is found, move to else for the next checking*/
if(isObjectNotFound) {
	
	/* Take screenshot, mark as failed case and print info message error*/
	WebUI.takeScreenshot()
	keyLogger.markFailed("Customer with data "+ktpNumber+" and "+accNumber+" is not found")
	
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
	
	/* Get account number of customer from column with index 4 */
	actAccNumber = listColumn.get(4).getText()
	
	/* The purpose of this conditional is to verify the actual account number same
	* with expected account number. */
	if(actAccNumber.equals(accNumber)) {
		
		/* Mark the case as Passed and print the message info*/
		WebUI.takeScreenshot()
		keyLogger.markPassed("Customer with KTP Number: "+ktpNumber+" and Account number: "+accNumber+" is found")
		
	} else {
		
		/* Take screenshot, mark as failed case and print info message error*/
		WebUI.takeScreenshot()
		keyLogger.markFailed("Account number customer with KTP Number "+ktpNumber+" is not same")
		
		println "Actual Account number: "+actAccNumber+"\n"
				"Expected Account number: "+accNumber
	}	
}

