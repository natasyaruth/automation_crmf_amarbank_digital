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

WebUI.waitForElementPresent(table, 10)

WebUI.verifyTextPresent(titleCSRManagement, false)

WebDriver driver = DriverFactory.getWebDriver()

/* We will declarated variable 'tableCSR' to store the location of the table*/
WebElement tableCSR

/* We will declarated variable 'listRows' with type List to store
 all the element with tag 'tr' which means element that represent rows*/
List<WebElement> listRows

List<WebElement> listColumn

int countNotFound,countFailed = 0

for(String specialChar: listSpecialChar) {
	
	WebUI.setText(fieldName, specialChar)
	
	WebUI.click(btnSearch)
	
	tableCSR = driver.findElement(By.xpath('//tbody'))
	
	listRows = tableCSR.findElements(By.tagName('tr'))
	
	boolean isObjectNotFound = WebUI.waitForElementPresent(objectNotFound, 3)
	
	if(isObjectNotFound) {
		
		WebUI.takeScreenshot()
		
		countNotFound++
		
		if(countNotFound == 4) {
			keyLogger.markFailed("All special character is not found")
		}
		
	} else {
		
		boolean flagLoop = false
		
		while(flagLoop == false) {
			
			for(int i=0; i<listRows.size();i++) {
				
				tableCSR = driver.findElement(By.xpath('//tbody'))
				
				listRows = tableCSR.findElements(By.tagName('tr'))
				
				listColumn = listRows.get(i).findElements(By.tagName('td'))
				
				custName = listColumn.get(1).getText()
				
				if (custName.contains(specialChar)) {
					
					println "Nama customer: "+custName+" mengandung special character "+specialChar
					
				} else {
					
					println "Nama customer: "+custName+" tidak mengandung special character "+specialChar
					
					countFailed++
				}
			}
			
			WebUI.takeScreenshot()
			
			if(flagLoop == false){
				
				/* Define variable 'expectedFirstReceipt' and store the current page */
				def expectedFirstReceipt = WebUI.getText(txtFirstPage)
		
				/* Define variable 'expectedLastReceipt' and store the last page */
				def expectedLastReceipt = WebUI.getText(txtLastPage)
				
				/* This conditional represent if it's on the last page,
				 * system will stop the looping by change the flag loop 'flagNextLoop' into true.
				 * But if it still not in the last page, it will go to the next page */
				if (expectedFirstReceipt.equals(expectedLastReceipt)) {
					
					/* Assert flagNextLoop into true*/
					flagLoop = true
					
				} else {
					
					/* We will click the next page */
					WebUI.click(btnNextPageCSRBucketlist)
		
					/* We will wait for 3 second till page finish load*/
					WebUI.waitForPageLoad(3)
				}
			}
		}
		
		if(WebUI.verifyEqual(countFailed, 0)) {
			
			keyLogger.markPassed("Case Special char "+specialChar+" berhasil")

		} else {
			
			keyLogger.markFailed("Case Special char "+specialChar+" gagal")
						
		}
	}
}

