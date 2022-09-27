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
import org.openqa.selenium.support.ui.Select as Select
import com.tunaiku.keyword.RandomData as RandomData
/*'Declaration keylog forloggin'*/
KeywordUtil keyLogger = new KeywordUtil()

/* Choose customer type 'Nasabah Senyumku'*/
WebUI.selectOptionByValue(drpDownCustType, custType, false)

/* We will wait for 2 second till page finish load*/
WebUI.waitForPageLoad(2)

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

/* Declarate variable countBlank and iniatiate with zero */
int countBlank = 0

/* Declarate variable flagLoopPage as boolean and iniatiate with false */
boolean flagLoopPage = false

/* This looping is represent to edit NPWP customer with data is not in status Diblokir/Ditolak,
 * NPWP length is 15 and button edit in personal data is enabled.
 * Looping will stop if the flagLoopPage return into true*/
LoopPage:
while(flagLoopPage == false) {
	
	/* Storing table to variable tableCSR*/
	tableCSR = driver.findElement(By.xpath('//tbody'))
	
	/* Storing all rows to variable listRows*/
	listRows = tableCSR.findElements(By.tagName('tr'))

	/* Looping through number of rows of bucketlist CSR Management*/
	for(int i=0;i<listRows.size();i++) {
		
		/* Storing again column to variable listColumn to prevent stale element*/
		listColumn = listRows.get(i).findElements(By.tagName('td'))
		
		/* Click button detail of customer*/
		listColumn.get(6).findElement(By.tagName('button')).click()
		
		/* We will wait for 2 second till page finish load*/
		WebUI.waitForPageLoad(2)
		
		/* Verify if the button 'Kembali' is exists, if it's not exists will move to else statement */
		if(WebUI.waitForElementClickable(btnBack, 5)) {
			
			/* Insert value status customer by get the text customer status from CSR detail */
			actStatusCust = WebUI.getText(txtStatusRequest)
			
			/* Print actual status to console */
			println actStatusCust
			
			/* Verify if actual status is 'Dalam Proses' or 'Selesai',
			 * other than will move to else statement */
			if(actStatusCust.equals(onProcessStat) || actStatusCust.equals(completedStat)) {
				
				/* Click section employment data */
				WebUI.click(sectionEmployementData)
				
				/* Verify if the button 'Edit' is exists, if it's not exists will move to else statement */
				if(WebUI.waitForElementClickable(btnEditEmploymentData, 3)) {
					
					/* Click button 'Edit' in section Employment data */
					WebUI.click(btnEditEmploymentData)
					
					/* Wait till button 'Simpan' is shown */
					WebUI.waitForElementClickable(btnSaveEmploymentData, 3)
					
					/* Select empty value (at index 0) in dropdown monthly income*/
					WebUI.selectOptionByIndex(drpMonthlyIncome, 0)
					
					/* Click button 'Save' in section Employment data */
					WebUI.click(btnSaveEmploymentData)
					
					/* Verify if the message error is appear */
					if(WebUI.waitForElementPresent(msgErrorMonthlyIncome, 2)) {
						
						/* Storing text of not found to variable actMsgError*/
						actMsgError = WebUI.getText(msgErrorMonthlyIncome)
						
						/* Verify message text error */
						if(actMsgError.equals(msgError)) {
							
							/* Take screenshot, mark as passed case and print info message to console*/
							WebUI.takeScreenshot()
							keyLogger.markPassed("Message error "+msgError+" is appear. Case SUCCESS")
							
						} else {
							
							/* Take screenshot, mark as failed case and print info message error*/
							WebUI.takeScreenshot()
							keyLogger.markFailed("Text message error is not same. Case FAILED")
							
							println "Actual message error: "+actMsgError+"\n"
									"Expected message error: "+msgError
	
						}
						
					} else {
						
						/* Take screenshot, mark as failed case and print info message error*/
						WebUI.takeScreenshot()
						keyLogger.markFailed("Message error "+msgError+" is not appear. Case FAILED")
					}
					
					/* Click button 'Cancel' in section Employment data */
					WebUI.click(btnEditEmploymentData)
					
					/* Click button 'Kembali' */
					WebUI.click(btnBack)
					
					/* Break from loop statement LoopPage*/
					break LoopPage
					
				} else {
					
					/* Click button 'Kembali' */
					WebUI.click(btnBack)
					
					/* We will wait for 3 second till page finish load*/
					WebUI.waitForPageLoad(3)
					
					/* Storing again table to variable tableCSR to prevent stale element*/
					tableCSR = driver.findElement(By.xpath('//tbody'))
					
					/* Storing again rows to variable listRows to prevent stale element*/
					listRows = tableCSR.findElements(By.tagName('tr'))
					
				}
				
			} else {
				
				/* Print to console current status of  */
				println actStatusCust
				
				/* Click button 'Kembali' */
				WebUI.click(btnBack)
				
				/* We will wait for 3 second till page finish load*/
				WebUI.waitForPageLoad(3)
				
				/* Storing again table to variable tableCSR to prevent stale element*/
				tableCSR = driver.findElement(By.xpath('//tbody'))
				
				/* Storing again rows to variable listRows to prevent stale element*/
				listRows = tableCSR.findElements(By.tagName('tr'))
			}
			
		} else {
			
			/* Refresh the page */
			WebUI.refresh()
			
			/* We will wait for 3 second till page finish load*/
			WebUI.waitForPageLoad(3)
			
			/* Verify if the button 'Kembali' is exists, if it's not exists will move to else statement */
			if(WebUI.waitForElementNotClickable(btnBack, 5)) {
				
				/* Increment countBlank as long detail page was blank */
				countBlank++
				
				/* Verify if countBlank is 10 which mean 10 request id in 1 page are blank */
				if(countBlank.equals(10)) {
					
					/* Mark case as failed and print info message*/
					keyLogger.markFailed("All data in bucketlist is blank. Something happened in CSR Detail")
					
					/* Break from loop statement Looppage*/
					break LoopPage
					
				} else {
					
					/* Call test case for click menu CSR Management */
					WebUI.callTestCase(findTestCase(testCaseName), [('menuCSRManagement'):menuCSRManagement,('blockBylockedUserElement'):blockBylockedUserElement,
						('alertConfirmationPopUpElement'):alertConfirmationPopUpElement, ('alertConfirmationPopUpText'):alertConfirmationPopUpText,
						('btnCancelPopUpElement'):btnCancelPopUpElement, ('headerCSRManagementElement'):headerCSRManagementElement,
						('headerCSRManagementText'):headerCSRManagementText])
				}
				
			} else {
				
				/* Storing again table to variable tableCSR to prevent stale element*/
				tableCSR = driver.findElement(By.xpath('//tbody'))
				
				/* Storing again rows to variable listRows to prevent stale element*/
				listRows = tableCSR.findElements(By.tagName('tr'))
				
			}
		}
	}
	
	/* This conditional represent if the all the data was check in current page,
	 * system will direct to the next page. */
	if (flagLoopPage == false) {
		
		/* Define variable 'expectedFirstReceipt' and store the current page */
		def expectedCurrentPage = WebUI.getText(txtCurrentPage)

		/* Define variable 'expectedLastReceipt' and store the last page */
		def expectedLastPage = WebUI.getText(txtLastPage)

		/* This conditional represent if it's on the last page,
		 * system will stop the looping by change the flag loop 'flagNextLoop' into true.
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