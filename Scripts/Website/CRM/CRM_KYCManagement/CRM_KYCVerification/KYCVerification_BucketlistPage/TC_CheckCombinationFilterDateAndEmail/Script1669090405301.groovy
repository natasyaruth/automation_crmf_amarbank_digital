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
import java.time.LocalDateTime

/*'Declaration keylog forloggin'*/
KeywordUtil keyLogger = new KeywordUtil()

/* Declarate variable driver */
WebDriver driver = DriverFactory.getWebDriver()

/* We will declarated variable 'tableKYCVerif' to store the location of the table*/
WebElement tableKYCVerif

/* We will declarated variable 'listRows' with type List to store
 all the element with tag 'tr' which means element that represent rows*/
List<WebElement> listRows

/* We will declarated variable 'listColumn' with type List to store
 all the element with tag 'td' which means element that represent column*/
List<WebElement> listColumn

/* Declarate variable countBlank and iniatiate with zero */
int countFalseDate, countEmailFalse = 0

/* Declarate variable flagLoop as boolean and iniatiate with false */
boolean flagLoop = false

/* Declarate variable startDate and endDate with Date */
def startDate, endDate = new Date()

/* Declarate variable calendar and get the instance */
def calendar = Calendar.getInstance()

/* Set date with range D-1 */
calendar.add(Calendar.DATE, -1)

/* Set format date with dd/MM/yyyy */
startDate = calendar.getTime().format('d/M/yyyy')

/* Choose customer type Nasabah Senyumku*/
WebUI.setText(dtpStartDate, startDate)

/* Set date with current date */
calendar.add(Calendar.DATE, 1)

/* Set format date with dd/MM/yyyy */
endDate = calendar.getTime().format('d/M/yyyy')

/* Choose email type is verified*/
WebUI.setText(dtpEndDate, endDate)

/* Click button 'Tampilkan' */
WebUI.click(btnShow)

/* Loop based on the email type */
for(int j=0;j<listOptionEmail.size();j++) {
	
	/* Choose email based on the index listOptionEmail */
	WebUI.selectOptionByValue(drpEmailType, listOptionEmail.get(j), false)
	
	/* We will wait for 3 second till page finish load*/
	WebUI.delay(3)
	
	/* Declarate variable isObjectNotFound as boolean
	 * to save value from verify element objectNotFound is exists or not*/
	boolean isObjectNotFound = WebUI.waitForElementPresent(objectNotFound, 3)
	
	if(isObjectNotFound) {
		
		WebUI.takeScreenshot()
		
		keyLogger.markPassed("No available data between date "+startDate+" until "+endDate+", with type email is "+listContentEmail.get(j))
		
	} else {
		
		/* If state loop is in index 2, break the loop */
		if(j==2){
			
			break
		
		} else {
			
			/* Store the location of the table*/
			tableKYCVerif = driver.findElement(By.xpath('//tbody'))
			
			/* Store all rows table*/
			listRows = tableKYCVerif.findElements(By.tagName('tr'))
			
			/* This looping is represent to check data in bucketlist showed based on the choosen date and email type*/
			while(flagLoop == false) {
				
				/* Looping through number of rows of bucketlist KYC Verification*/
				for(int i=0;i<listRows.size();i++){
					
					/* Get all column and storing to variable 'listColumn' at row with index i*/
					listColumn = listRows.get(i).findElements(By.tagName('td'))
					
					/* Get text and storing to variable 'actDate' at column with index 5*/
					String actDate = listColumn.get(5).getText()
					
					/* Get attribute class and storing to variable 'actIconEmail' at column with index 6*/
					String actIconEmail = listColumn.get(6).findElement(By.tagName('svg')).getAttribute('class')
			
					/* Compare actual date with expected date */
					if(actDate != startDate) {
						
						if(actDate != endDate) {
							
							/* Increment variable countFalseDate */
							countFalseDate++
							
							println "Actual date: "+actDate+", Start Date: "+startDate+", End Date: "+endDate
							
						} else if (actIconEmail != listClass.get(j)){
						
							/* Increment variable countEmailFalse */
							countEmailFalse++
						}
						
					/* Compare actual icon email type and expected icon email type */
					} else if (actIconEmail != listClass.get(j)){
						
						/* Increment variable countEmailFalse */
						countEmailFalse++
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
	
		}
		
		/* Make sure there is no customer out of the range date */
		if(countFalseDate.equals(0)) {
			
			/* Make sure there is no email type other than email verified */
			if(countEmailFalse.equals(0)) {
				
				/* Mark case is passed */
				keyLogger.markPassed("All data in bucketlist are in range from "+startDate+" until "+endDate+" with email choosen in filter email type. Case SUCCESS")
				
			/* If there is email type other than verified will mark as failed */
			} else {
				keyLogger.markFailed("There is data customer other than email choosen in filter email type. Case FAILED")
			}
			
		/* If there is customer out of the range date will mark as failed */
		} else {
			keyLogger.markFailed("There is data customer not in range "+startDate+" until "+endDate+". Case FAILED")
			
		}
		
	}
	
}