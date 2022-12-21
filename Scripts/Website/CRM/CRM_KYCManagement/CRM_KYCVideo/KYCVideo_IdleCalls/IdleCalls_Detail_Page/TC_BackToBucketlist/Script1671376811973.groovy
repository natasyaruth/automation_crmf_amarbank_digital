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

/* Verify there are data in KYC Video Tab Iddle calls by checking button request id in the first row of bucketlist*/
if(WebUI.waitForElementPresent(reqID, 10)) {
	
	/* Declarate variable driver */
	WebDriver driver = DriverFactory.getWebDriver()
	
	/* We will declarated variable 'tableKYC' to store the location of the table*/
	WebElement tableKYC
	
	/* We will declarated variable 'listRows' with type List to store
	 all the element with tag 'tr' which means element that represent rows*/
	List<WebElement> listRows
	
	/* We will declarated variable 'listColumn' with type List to store
	 all the element with tag 'td' which means element that represent column*/
	List<WebElement> listColumn
	
	/* Declarate variable flagLoopPage as boolean and iniatiate with false */
	boolean flagLoop = false
	
	/* This looping is represent to search customer that available to opened. */
	Loop:
	while(flagLoop == false) {
		
		/* Storing table to variable tableKYC*/
		tableKYC = driver.findElement(By.xpath('//tbody'))
		
		/* Storing all rows to variable listRows*/
		listRows = tableKYC.findElements(By.tagName('tr'))
	
		/* Looping through number of rows of bucketlist KYC Verification*/
		for(int i=0;i<listRows.size();i++) {
			
			/* Storing again column to variable listColumn to prevent stale element*/
			listColumn = listRows.get(i).findElements(By.tagName('td'))
			
			/* Declarate variable txtReqId and store value of request id */
			String txtReqId = listColumn.get(1).getText()
			
			/* Click button detail of customer*/
			listColumn.get(1).findElement(By.tagName('a')).click()
			
			/* Verify button back should be present */
			if(WebUI.waitForElementPresent(btnBack, 5)) {
				
				/* Click button back*/
				WebUI.click(btnBack)
				
				/* Verify header KYC Video Request should be present */
				if(WebUI.waitForElementVisible(headerKYCVideoRequestElement, 5, FailureHandling.OPTIONAL)) {
					
					/* Verify text header of KYC Video Request */
					if(WebUI.verifyElementText(headerKYCVideoRequestElement, headerKYCVideoRequestText)) {
						
						/* Mark passed */
						keyLogger.markPassed("State is in KYC Video Bucketlist Iddle calls. Case SUCCESS")
						
					} else {
						
						/* Take screenshoot and mark as failed */
						WebUI.takeScreenshot()
						keyLogger.markFailed("Header text KYC Video is not correct. Case FAILED")
					}
					
				} else {
					
					/* Take screenshoot and mark as failed */
					WebUI.takeScreenshot()
					keyLogger.markFailed("State is not in KYC Video Bucketlist Iddle calls. Case FAILED")
				}
				
				/* Break the loop */
				break Loop
				
			} else {
				
				/* Verify if the modal, customer is locked, is appear */
				if(WebUI.waitForElementVisible(mdlBlocked, 3, FailureHandling.OPTIONAL)){
					
					/* Check the text of alert and store to checkAlert as boolean value*/
					boolean checkAlert = WebUI.verifyElementVisible(elementTxtIsBlocked)
					
					/* Verify if the checkAlert is true */
					if(checkAlert){
						
						/* Verify element text of modal */
						WebUI.verifyElementText(elementTxtIsBlocked, txtIsBlocked)
						
						/* Click button 'Kembali' in modal */
						WebUI.click(btnCloseModalBlocked)
						
						/* Wait 'till header KYC Video request is visible */
						WebUI.waitForElementVisible(headerKYCVideoRequestElement, 5)
						
						/* Verify text of header KYC Video request */
						WebUI.verifyElementText(headerKYCVideoRequestElement, headerKYCVideoRequestText)
						
					} else {
						
						/* Take screenshoot and mark as failed */
						WebUI.takeScreenshot()
						keyLogger.markFailed("We don't find alert confirmation")
						
						/* Click link direct to KYC Video */
						WebUI.click(linkKYCVideo)
						
						/* Wait 'till modal customer is in process */
						WebUI.waitForElementPresent(mdlBlocked, 3)
						
						/* Click button 'Batal' in modal */
						WebUI.click(btnCancelProcess)
						
						/* We will wait for 4 second till page finish load*/
						WebUI.waitForPageLoad(4)
						
						/* Delay the process until 2sec*/
						WebUI.delay(2)
						
						/* Wait until table KYC Video request is present */
						WebUI.waitForElementPresent(table, 5)
						
						/* Storing again table to variable tableKYC to prevent stale element*/
						tableKYC = driver.findElement(By.xpath('//tbody'))
						
						/* Storing again rows to variable listRows to prevent stale element*/
						listRows = tableKYC.findElements(By.tagName('tr'))
					}
					
				} else {
					
					/* Take screenshoot and print info to console */
					WebUI.takeScreenshot()
					println "Can't open request id "+txtReqId+". Open other request id!"
					
					/* Click link direct to KYC Video */
					WebUI.click(linkKYCVideo)
					
					/* Wait 'till modal customer is in process */
					WebUI.waitForElementPresent(mdlBlocked, 3)
					
					/* Click button 'Batal' in modal */
					WebUI.click(btnCancelProcess)
					
					/* We will wait for 4 second till page finish load*/
					WebUI.waitForPageLoad(4)
					
					/* Delay the process until 2sec*/
					WebUI.delay(2)
					
					/* Wait until table KYC Verification is present */
					WebUI.waitForElementPresent(table, 5)
					
					/* Storing again table to variable tableKYC to prevent stale element*/
					tableKYC = driver.findElement(By.xpath('//tbody'))
					
					/* Storing again rows to variable listRows to prevent stale element*/
					listRows = tableKYC.findElements(By.tagName('tr'))
				}
			}
		}
		
		/* Change value flagLoop into true */
		flagLoop = true
	}
	
} else {
	
	/* Verify if text not found is visible */
	if(WebUI.verifyElementVisible(txtNotFound, FailureHandling.STOP_ON_FAILURE)) {
		
		/* Take screenshoot and mark as failed */
		WebUI.takeScreenshot()
		keyLogger.markFailed("There is no data available in KYC Video Iddle Calls")
		
	} else {
		
		/* Take screenshoot and mark as failed */
		WebUI.takeScreenshot()
		keyLogger.markFailed("Something went wrong in KYC Video Tab Iddle Calls")
	}
	
}



