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

/* Declarate variable countBlank and iniatiate with zero */
int countFalseDate, countCustTypeFalse = 0

/* Declarate variable flagLoop as boolean and iniatiate with false */
boolean flagLoop = false

/* Click tab 'Idlle Calls' */
WebUI.click(tabIddleCalls)

/* Wait table of KYC Video */
WebUI.waitForElementPresent(table, 5)

/* Declarate variable startMonth and endMonth with Date */
def startMonth, endMonth  = new Date()

/* Declarate variable calendar and get the instance */
def calendar = Calendar.getInstance()

/* Set month with range D-1 */
calendar.add(Calendar.MONTH, -1)

/* Set format date with MM/yyyy */
startMonth = "01/"+calendar.getTime().format('MM/yyyy')

/* Set start date*/
WebUI.setText(dtpStartDate, startMonth)

/* Set month with current month */
calendar.add(Calendar.MONTH, 1)

/* Set format date with MM/yyyy */
endMonth = "01/"+calendar.getTime().format('MM/yyyy')

/* Set month with end month */
WebUI.setText(dtpEndDate, endMonth)

/* Click button 'Tampilkan' */
WebUI.click(btnShow)

WebUI.waitForPageLoad(5)

WebUI.delay(3)

/* Choose customer type based on the index optionCustType */
WebUI.selectOptionByValue(drpCustType, optionCustType, false)
	
/* We will wait for 3 second till page finish load*/
WebUI.waitForPageLoad(3)
	
/* Declarate variable driver */
WebDriver driver = DriverFactory.getWebDriver()

/* We will declarated variable 'tableKYC' to store the location of the table*/
WebElement tableKYC = driver.findElement(By.xpath('//table/tbody'))

/* We will declarated variable 'listRows' with type List to store
 all the element with tag 'tr' which means element that represent rows*/
List<WebElement> listRows = driver.findElements(By.tagName('tr'))

/* This looping is represent to check data in bucketlist showed based on the choosen date and cust type*/
while(flagLoop == false) {
	
	/* Looping through number of rows of bucketlist KYC Video*/
	for(int i=0;i<listRows.size();i++){
		
		/* Get all column and storing to variable 'listColumn' at row with index i*/
		List<WebElement> listColumn = listRows.get(i).findElements(By.tagName('td'))
		println(listRows.size())
		
		/* Get text and storing to variable 'actDate' at column with index 5*/
		String actDate = listColumn.get(6).getText()
		
		/* Get text and storing to variable 'actCustType' at column with index 6*/
		String actCustType = listColumn.get(5).getText()

		println actDate+" , "+startMonth
		
		println actDate+" , "+endMonth
		
		/* Compare actual date with expected date */
		if(actDate != startMonth || actDate != endMonth) {
			
			/* Increment variable countFalseDate */
			countFalseDate++
			
		/* Compare actual cust type and expected cust type */
		} else if (actCustType != custType){
			
			/* Increment variable countCustTypeFalse */
			countCustTypeFalse++
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
		 * system will stop the looping by change the flag loop 'flagLoopPage' into true.
		 * But if it still not in the last page, it will go to the next page */
		if (expectedCurrentPage.equals(expectedLastPage)) {
			
			/* Assert flagNextLoop into true*/
			flagLoopPage = true
			
		} else {
			
			/* We will click the next page */
			WebUI.click(btnNextPage)

			/* We will wait for 3 second till page finish load*/
			WebUI.waitForPageLoad(3)
		}
	}
}

/* Make sure there is no customer out of the range date */
if(countFalseDate.equals(0)) {
	
	/* Make sure there is no cust type other than choosen option */
	if(countCustTypeFalse.equals(0)) {
		
		/* Mark case is passed */
		keyLogger.markPassed("All data in bucketlist are in range from "+startMonth+" until "+endMonth+" with customer type "+custType+". Case SUCCESS")
		
	/* If there is cust type other than choosen option mark as failed */
	} else {
		keyLogger.markFailed("There is data customer other than "+custType+". Case FAILED")
	}
	
/* If there is customer out of the range date will mark as failed */
} else {
	keyLogger.markFailed("There is data customer not in range "+startMonth+" until "+endMonth+". Case FAILED")
}