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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.inspect.swingui.BytecodeCollector
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil
import org.bouncycastle.crypto.ec.CustomNamedCurves
import org.openqa.selenium.By
import org.openqa.selenium.By.ByClassName
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

/*'Declaration keylog forloggin'*/
KeywordUtil keyLogger = new KeywordUtil()

/* Choose customer type Nasabah Senyumku*/
WebUI.selectOptionByValue(drpCustType, optionNasabahSenyumku, false)

/* Choose email type is verified*/
WebUI.selectOptionByValue(drpEmailType, optionEmail, false)

/* We will wait for 3 second till page finish load*/
WebUI.waitForPageLoad(3)

/* Declarate variable driver */
WebDriver driver = DriverFactory.getWebDriver()

/* We will declarated variable 'tableKYCVerif' to store the location of the table*/
WebElement tableKYCVerif = driver.findElement(By.xpath('//tbody'))

/* We will declarated variable 'listRows' with type List to store
 all the element with tag 'tr' which means element that represent rows*/
List<WebElement> listRows = tableKYCVerif.findElements(By.tagName('tr'))

/* We will declarated variable 'listColumn' with type List to store
 all the element with tag 'td' which means element that represent column*/
List<WebElement> listColumn

/* Declarate variable countBlank and iniatiate with zero */
int countIsnotNasabahSenyumku, countIsNotverified = 0

/* Declarate variable flagLoop as boolean and iniatiate with false */
boolean flagLoop = false

/* This looping is represent to check data in bucketlist showed based on the choosen filter
 * in customer type and email type*/
while(flagLoop == false) {
	
	/* Looping through number of rows of bucketlist KYC Verification*/
	for(int i=0;i<listRows.size();i++){
		
		/* Get all column and storing to variable 'listColumn' at row with index i*/
		listColumn = listRows.get(i).findElements(By.tagName('td'))
		
		/* Get text and storing to variable 'actCustType' at column with index 4*/
		String actCustType = listColumn.get(4).getText()
		
		String actIconEmail = listColumn.get(6).findElement(By.tagName('svg')).getAttribute('class')
		
		/* Compare actual customer type and expected customer type */
		if(actCustType != custType) {
			
			/* Increment variable countIsnotNasabahSenyumku */
			countIsnotNasabahSenyumku++
			
			println "Actual Customer Type: "+actCustType+", Expected Customer Type: "+custType
			
		/* Compare actual icon email type and expected icon email type */
		} else if (actIconEmail != classIsVerified){
			
			/* Increment variable countIsNotverified */
			countIsNotverified++
			
			println "Actual Class Email Type: "+actIconEmail+", Expected Class Email Type: "+classNotVerified
		}
		
	}
	
	/* This conditional represent if the all the data was check in current page,
	 * system will direct to the next page. */
	if (flagLoop == false) { 
		
		/* Define variable 'expectedCurrentPage' and store the current page */
		def expectedCurrentPage = WebUI.getText(txtCurrentPage)

		/* Define variable 'expectedLastPage' and store the last page */
		def expectedLastPage = WebUI.getText(txtLastPage)

		/* This conditional represent if it's on the last page,
		 * system will stop the looping by change the flag loop 'flagLoop' into true.
		 * But if it still not in the last page, it will go to the next page */
		if (expectedCurrentPage.equals(expectedLastPage)) {
			
			/* Assert flagNextLoop into true*/
			flagLoop = true
			
		} else {
			
			/* We will click the next page */
			WebUI.click(btnNextPage)

			/* We will wait for 3 second till page finish load*/
			WebUI.waitForPageLoad(3)
		}
	}
}

/* Make sure there is no customer type other than Nasabah Senyumku */
if(countIsnotNasabahSenyumku.equals(0)) {
	
	/* Make sure there is no email type other than email verified */
	if(countIsNotverified.equals(0)) {
		
		/* Mark case is passed */
		keyLogger.markPassed("All data in bucketlist is Nasabah Senyumku and email is verified. Case SUCCESS")
		
	/* If there is email type other than verified will mark as failed */
	} else {
		keyLogger.markFailed("There is data customer with email is not verified. Case FAILED")
	}
	
/* If there is customer type other than Nasabah Senyumku will mark as failed */
} else {
	keyLogger.markPassed("There is data customer with type is not Nasabah Senyumku. Case FAILED")
}