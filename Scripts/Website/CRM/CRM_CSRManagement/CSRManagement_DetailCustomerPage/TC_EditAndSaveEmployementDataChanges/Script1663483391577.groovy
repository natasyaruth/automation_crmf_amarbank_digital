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
	tableCSR = driver.findElement(By.xpath('//table/tbody'))
	
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
			/* Give delay for check the status*/
			WebUI.delay(5)			
			
			/* Insert value status customer by get the text customer status from CSR detail */
			actStatusCust = WebUI.getText(txtStatusRequest)
			
			/* Print actual status to console */
			println actStatusCust
			
			/* Verify if actual status is 'Dalam Proses' or 'Selesai',
			 * other than will move to else statement */
			if(actStatusCust.equals(onProcessStat) || actStatusCust.equals(completedStat)) {
				/* Check button until available*/
				WebUI.waitForElementVisible(sectionEmployementData, 5)				
				
				/* Click section employment data */
				WebUI.click(sectionEmployementData)
				
				/* Verify if the button 'Edit' is exists, if it's not exists will move to else statement */
				if(WebUI.waitForElementClickable(btnEditEmploymentData, 3)) {
					
					/* Click button 'Edit' in section Employment data */
					WebUI.click(btnEditEmploymentData)
					
					/* Wait till button 'Simpan' is shown */
					WebUI.waitForElementClickable(btnSaveEmploymentData, 3)
					
					/* This loop is represent to fill all field in Employment Data*/
					LoopDropdown:
					for(int j=0;j<listDropDown.size();j++) {
						
						/* Statement if will run if the index is not 5, which is filled the text*/
						if (j!=5) {
							
							/* Declarate variable totalIndex and store value total index of each dropdown*/
							int totalIndex = WebUI.getNumberOfTotalOption(listDropDown.get(j))
							
							/* Declarate variable random */
							Random random = new Random()
							
							/* Declarate variable index and store value random index */
							int index = random.internalNextInt(1, totalIndex)
							
							/* Select dropdown based on random index*/
							WebUI.selectOptionByIndex(listDropDown.get(j), index)
							
							/* Give delay 3 second after choose value*/
							WebUI.delay(3)
							
							/* Statement if will run if the index is 1, to prevent the behaviour other fields that will
							 * dissappear after choose index 5,6,7 and 8.*/
							if (j==2) {
								
								/* Statement if will run if the index is 5,6,7, 0r 8*/
								if(index.equals(5)||index.equals(6)||index.equals(7)||index.equals(8)) {
									
									/* Break from loop statement LoopDropdown*/
									break LoopDropdown
									
								}
								
							}
							
						} else {
							
							/* Set Company name */
							WebUI.setText(listDropDown.get(j), compName)
							
						}
					}
					
					/* Click button 'Save' in section Employment data */
					WebUI.click(btnSaveEmploymentData)
					
					/* Wait message save success*/
					WebUI.waitForElementPresent(msgSuccessEmploymentData, 4)
					
					/* Take a screenshot */
					WebUI.takeScreenshot()
					
					/* Click button 'Kembali' */
					WebUI.click(btnBack)
					
					/* We will wait for 3 second till page finish load*/
					WebUI.waitForPageLoad(3)
					
					/* Break from loop statement LoopPage*/
					break LoopPage
					
				} else {
					
					/* Click button 'Kembali' */
					WebUI.click(btnBack)
					
					/* Adding delay*/
					WebUI.delay(5)					
					
					/* We will wait for 3 second till page finish load*/
					WebUI.waitForPageLoad(3)
					
					/* Storing again table to variable tableCSR to prevent stale element*/
					tableCSR = driver.findElement(By.xpath('//table/tbody'))
					
					/* Storing again rows to variable listRows to prevent stale element*/
					listRows = tableCSR.findElements(By.tagName('tr'))
					
				}
				
			} else {
				
				/* Print to console current status of  */
				println actStatusCust
				
				/* Click button 'Kembali' */
				WebUI.click(btnBack)
				
				/* We will wait for 3 second till page finish load*/
				WebUI.delay(3)
				WebUI.waitForPageLoad(3)
				
				/* Storing again table to variable tableCSR to prevent stale element*/
				tableCSR = driver.findElement(By.xpath('//table/tbody'))
				
				/* Storing again rows to variable listRows to prevent stale element*/
				listRows = tableCSR.findElements(By.tagName('tr'))
			}
			
		} else {
			
			/* Refresh the page */
			WebUI.refresh()
			
			/* Adding delay*/
			WebUI.delay(5)
			
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
				tableCSR = driver.findElement(By.xpath('//table/tbody'))
				
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
			
			/* Adding delay*/
			WebUI.delay(5)

			/* We will wait for 3 second till page finish load*/
			WebUI.waitForPageLoad(3)
		}
	}

}