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

/* Verify title CSR Management */
WebUI.verifyTextPresent(titleCSRManagement, false)

/* Declarate variable driver */
WebDriver driver = DriverFactory.getWebDriver()

/* We will declarated variable 'tableCSR' to store the location of the table*/
WebElement tableCSR

/* We will declarated variable 'listRows' with type List to store
 all the element with tag 'tr' which means element that represent rows*/
List<WebElement> listRows

/* We will declarated variable 'listColumn' with type List to store
 all the element with tag 'td' which means element that represent column*/
List<WebElement> listColumn

/* Declarate variable countNotFound and countFailed and iniatiate with zero */
int countNotFound,countFailed = 0

/* This looping is represent to check all special char such as .,'- */
for(String specialChar: listSpecialChar) {
	
	/* Fill field name with special char*/
	WebUI.setText(fieldName, specialChar)
	
	/* Click button search */
	WebUI.click(btnSearch)
	
	/* Storing table to variable tableCSR*/
	tableCSR = driver.findElement(By.xpath('//tbody'))
	
	/* Storing all rows to variable listRows*/
	listRows = tableCSR.findElements(By.tagName('tr'))
	
	/* Declarate variable isObjectNotFound as boolean
	 * to save value from verify element objectNotFound is exists or not*/
	boolean isObjectNotFound = WebUI.waitForElementPresent(objectNotFound, 3)
	
	/* The purpose of this conditional is to verify if the customer data is not found or not.
	 * If data is found, move to else for the next checking*/
	if(isObjectNotFound) {
		
		/* Take screenshot */
		WebUI.takeScreenshot()
		
		/* Increment countNotFound as we're not found the data */
		countNotFound++
		
		/* If all special char is not found (which is size of our list special char are 4), 
		 * mark as failed case and print info message error*/
		if(countNotFound == 4) {
			keyLogger.markFailed("All special character is not found")
		}
		
	} else {
		
		/* Declarate variable flagloop as boolean and iniatiate value as false*/
		boolean flagLoop = false
		
		/* This looping is represent to check all data based on the inputted special char.
		 * Looping will stop if the flagloop return into true*/
		while(flagLoop == false) {
			
			/* Looping through number of rows of bucketlist CSR Management*/
			for(int i=0; i<listRows.size();i++) {
				
				/* Storing again table to variable tableCSR to prevent stale element*/
				tableCSR = driver.findElement(By.xpath('//tbody'))
				
				/* Storing again rows to variable listRows to prevent stale element*/
				listRows = tableCSR.findElements(By.tagName('tr'))
				
				/* Storing again column to variable listColumn to prevent stale element*/
				listColumn = listRows.get(i).findElements(By.tagName('td'))
				
				/* Insert value custName by get the text customer name from bucketlist CSR.
				 * As we see that column Name is on index 1 in the table*/
				custName = listColumn.get(1).getText()
				
				/* Assert if customer name from CSR is contain with inputted special char*/
				if (custName.contains(specialChar)) {
					
					/* Print the info into console*/
					println "Nama customer: "+custName+" mengandung special character "+specialChar
					
				} else {
					
					/* Print the info into console*/
					println "Nama customer: "+custName+" tidak mengandung special character "+specialChar
					
					/* Increment countFailed as we found data isn't contain with inputted special char */
					countFailed++
				}
			}
			
			/* Take screenshot */
			WebUI.takeScreenshot()
			
			/* This conditional represent if the all the data was check in current page,
			 * system will direct to the next page. */
			if(flagLoop == false){
				
				/* Define variable 'expectedFirstReceipt' and store the current page */
				def expectedFirstReceipt = WebUI.getText(txtFirstPage)
		
				/* Define variable 'expectedLastReceipt' and store the last page */
				def expectedLastReceipt = WebUI.getText(txtLastPage)
				
				/* This conditional represent if it's on the last page,
				 * system will stop the looping by change the flag loop 'flagLoop' into true.
				 * If it is not, it will go to the next page */
				if (expectedFirstReceipt.equals(expectedLastReceipt)) {
					
					/* Assert flagLoop into true*/
					flagLoop = true
					
				} else {
					
					/* We will click the next page */
					WebUI.click(btnNextPageCSRBucketlist)
		
					/* We will wait for 3 second till page finish load*/
					WebUI.waitForPageLoad(3)
				}
			}
		}
		
		/* This conditional is to make sure all the checking is passed or failed.
		 * The way to know it is to make sure the countFailed should be 0*/
		if(WebUI.verifyEqual(countFailed, 0)) {
			
			/* Mark case as passed and print info message*/
			keyLogger.markPassed("Case Special char "+specialChar+" SUCCESS")

		} else {
			
			/* Mark case as failed and print info message*/
			keyLogger.markFailed("Case Special char "+specialChar+" FAILED")
						
		}
	}
}