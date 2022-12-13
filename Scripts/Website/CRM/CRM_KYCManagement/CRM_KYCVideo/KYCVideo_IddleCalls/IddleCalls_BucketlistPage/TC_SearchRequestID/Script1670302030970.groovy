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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory

/*Declaration keylog forloggin*/
KeywordUtil keyLogger = new KeywordUtil()

/* Click tab Iddle Calls*/
WebUI.click(tabIddleCalls)

/* Declarate variable driver */
WebDriver driver = DriverFactory.getWebDriver()

/* We will declarated variable 'tableKYC' to store the location of the table*/
WebElement tableKYC

/* We will declarated variable 'listRows' with type List to store
 all the element with tag 'tr' which means element that represent rows*/
List<WebElement> listRows

/* Verify there are data in KYC Video Tab Iddle calls by checking button request id in the first row of bucketlist*/
if(WebUI.waitForElementVisible(btnNextPage, 3)) {
	
	WebUI.click(btnNextPage)
	
	/* We will wait for 3 second till page finish load*/
	WebUI.waitForPageLoad(3)
	
}

String reqID = WebUI.getText(txtReqID)

WebUI.refresh()

WebUI.waitForPageLoad(3)

WebUI.setText(searchReqID, reqID)

WebUI.click(btnSearch)

/* We will declarated variable 'tableKYC' to store the location of the table*/
tableKYC = driver.findElement(By.xpath('//tbody'))

/* We will declarated variable 'listRows' with type List to store
 all the element with tag 'tr' which means element that represent rows*/
listRows = tableKYC.findElements(By.tagName('tr'))

/* Declarate variable isObjectNotFound as boolean
* to save value from verify element objectNotFound is exists or not*/
boolean isObjectNotFound = WebUI.waitForElementPresent(objectNotFound, 3)

/* The purpose of this conditional is to verify if the customer data is not found or not.
* If data is found, move to else for the next checking*/
if(isObjectNotFound) {
	
	/* Take screenshot, mark as failed case and print info message error*/
	WebUI.takeScreenshot()
	keyLogger.markFailed("Customer with request id "+reqID+" is not found")
	
} else {
	
	if(listRows.size().equals(1)) {
		String actReqId = WebUI.getText(txtReqID)
		
		if(actReqId.equals(reqID)) {
			keyLogger.markPassed("Request ID "+actReqId+" is appear in bucketlist. Case PASSED")
		} else {
			WebUI.takeScreenshot()
			keyLogger.markFailed("Request ID search doesn't match."+"\n"
								+"Expected Request ID: "+reqID+"\n"
								+"Actual Request ID: "+actReqId)
		}
		
	} else {
		
		WebUI.takeScreenshot()
		keyLogger.markFailed("There are more than 1 request id is shown in the KYC Video Iddle Calls bucketlist. Case FAILED")
	}
}