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

/*'This case can be run with precondition FM Dukcapil
 * should be mock to Internal Server Error (500)
 * and please turn off any mock and configuration related to Facematch Verihub
 *
 * '*/


/*'Declaration keylog forloggin'*/
KeywordUtil keyLogger = new KeywordUtil()

/* Declarate variable driver */
WebDriver driver = DriverFactory.getWebDriver()

/* We will declarated variable 'tableKYC' to store the location of the table*/
WebElement tableKYC, tableFaceAccuracy, tableChangeLog

/* We will declarated variable 'listRows' with type List to store
 all the element with tag 'tr' which means element that represent rows*/
List<WebElement> listRows, listRowsFace, listRowsChangeLog

/* We will declarated variable 'listColumn' with type List to store
 all the element with tag 'td' which means element that represent column*/
List<WebElement> listColumn, listColumnFace, listColumnChangeLog

int countSnackbarError,countNothingHappened = 0

/* Declarate variable flagLoopPage as boolean and iniatiate with false */
boolean flagLoopPage, flagCSR = false

String reqID, actIconFMVerihubAccuracyKYC, actIconFMVerihubAccuracyCSR

def valueFMVerihubKYC, valueFMVerihubCSR

/* This looping is represent to search new customer with origin from embed banking such as eFishery, Dagangan or Finku. */
LoopPage:
while(flagLoopPage == false) {
	
	WebUI.selectOptionByIndex(drpCustType, indexCustType)
	
	WebUI.selectOptionByIndex(drpEmailType, indexEmailType)
	
	WebUI.waitForPageLoad(3)
	
	/* Storing table to variable tableKYC*/
	tableKYC = driver.findElement(By.xpath('//tbody'))
	
	/* Storing all rows to variable listRows*/
	listRows = tableKYC.findElements(By.tagName('tr'))

	/* Looping through number of rows of bucketlist KYC Verification*/
	for(int i=0;i<listRows.size();i++) {
		
		/* Storing again column to variable listColumn to prevent stale element*/
		listColumn = listRows.get(i).findElements(By.tagName('td'))
		
		/* Click button detail of customer*/
		listColumn.get(7).findElement(By.tagName('a')).click()
		
		/* We will wait for 2 second till page finish load*/
		WebUI.waitForPageLoad(2)
		
		/* Verify if the button 'Kembali' is clickable, if it's not clickable will move to else statement */
		if(WebUI.waitForElementClickable(btnBack, 5)) {
			
			reqID = WebUI.getText(txtReqID)
			
			WebUI.scrollToElement(btnCheckLiveness, 3)
			
			/* Verify if the origin customer is from eFishery or Finku or Dagangan */
			if(WebUI.waitForElementNotPresent(txtValueFMDukcapil, 2) && WebUI.waitForElementNotPresent(txtValueFMVerihub, 2)) {
				
				WebUI.click(btnCheckFMDukcapil)
				
				WebUI.waitForElementPresent(btnConfirmFM, 3)
				
				WebUI.click(btnConfirmFM)
				
				WebUI.waitForElementPresent(snackBarError, 5)
				
				WebUI.waitForElementNotPresent(snackBarError, 10)

				if(WebUI.waitForElementClickable(btnCheckFMVerihub, 5)) {
					
					WebUI.click(btnCheckFMVerihub)
					
					WebUI.waitForElementPresent(btnConfirmFM, 3)
					
					WebUI.click(btnConfirmFM)
					
					if(WebUI.waitForElementPresent(snackBarError, 5)) {
						
						String msgSnackbarError = WebUI.getText(snackBarError)
						
						countSnackbarError++
						
						WebUI.takeScreenshot()
						println "Got error snackbar: "+msgSnackbarError+", when hit request id "+reqID+", will try another data"
						
						if(countSnackbarError.equals(3)) {
							keyLogger.markFailed("Something went wrong with the Facematch Verihub."+"\n"+
												 "Trying 3 data got error snackbar. Please hit FM Verihub manually for this request id:")
							println reqID
							
							break LoopPage
						}
						
						WebUI.click(btnBack)
						
						/* Delay the process until 2sec*/
						WebUI.delay(2)
						
						/* Wait until table KYC Verification is present */
						WebUI.waitForElementPresent(table, 5)
						
						WebUI.selectOptionByIndex(drpCustType, indexCustType)
						
						WebUI.selectOptionByIndex(drpEmailType, indexEmailType)
						
						WebUI.waitForPageLoad(3)
						
						/* Storing table to variable tableKYC*/
						tableKYC = driver.findElement(By.xpath('//tbody'))
						
						/* Storing all rows to variable listRows*/
						listRows = tableKYC.findElements(By.tagName('tr'))
						
					} else if(WebUI.waitForElementNotPresent(txtValueFMVerihub, 2, FailureHandling.OPTIONAL)) {
						
						countNothingHappened++
						
						WebUI.takeScreenshot()
						println "Already hit Facematch Verihub for request id "+reqID+" but nothing happened, will try another data"
						
						if(countNothingHappened.equals(3)) {
							keyLogger.markFailed("Something went wrong with the Facematch Verihub."+"\n"+
												 "Trying 3 data but didn't return the result or any error. Please hit FM Verihub manually for this request id:")
							println reqID
							
							break LoopPage
						}
						
						WebUI.click(btnBack)
						
						/* Delay the process until 2sec*/
						WebUI.delay(2)
						
						/* Wait until table KYC Verification is present */
						WebUI.waitForElementPresent(table, 5)
						
						WebUI.selectOptionByIndex(drpCustType, indexCustType)
						
						WebUI.selectOptionByIndex(drpEmailType, indexEmailType)
						
						WebUI.waitForPageLoad(3)
						
						/* Storing table to variable tableKYC*/
						tableKYC = driver.findElement(By.xpath('//tbody'))
						
						/* Storing all rows to variable listRows*/
						listRows = tableKYC.findElements(By.tagName('tr'))
						
					} else {
						
						tableFaceAccuracy = driver.findElement(By.xpath('//*[@id="root"]//section[2]/div/div[1]/div[2]/table/tbody'))
						
						listRowsFace = tableFaceAccuracy.findElements(By.tagName('tr'))
						
						listColumnFace = listRowsFace.get(2).findElements(By.tagName('td'))
						
						actIconFMVerihubAccuracyKYC = listColumnFace.get(1).findElement(By.tagName('svg')).getAttribute('class')
						
						valueFMVerihubKYC = WebUI.getText(txtValueFMVerihub).replace("%", "")
						
						def thresholdFMVerihub = 80
						
						if(WebUI.verifyGreaterThanOrEqual(valueFMVerihubKYC, thresholdFMVerihub, FailureHandling.OPTIONAL)) {
							
							if(actIconFMVerihubAccuracyKYC.equals(iconGreenFMVerihub)) {
								
								WebUI.takeScreenshot()
								println "Facematch Verihub succesfully hit with value above threshold: "+valueFMVerihubKYC+"%"
								
								WebUI.click(btnBack)
								
								flagCSR = true
								break LoopPage
								
							} else {
								
								WebUI.takeScreenshot()
								keyLogger.markFailed("Facematch Verihub succesfully hit with value above threshold: "+valueFMVerihubKYC+"%"+"/n"+
													 "But icon is not green")
								
								WebUI.click(btnBack)
								break LoopPage
								
							}
							
						} else if (WebUI.verifyLessThan(valueFMVerihubKYC, thresholdFMVerihub, FailureHandling.OPTIONAL)){
							
							if(actIconFMVerihubAccuracyKYC.equals(iconRedFMVerihub)) {
								
								WebUI.takeScreenshot()
								println "Facematch Verihub succesfully hit with value under threshold: "+valueFMVerihubKYC+"%"
								
								flagCSR = true
								WebUI.click(btnBack)
								break LoopPage
								
							} else {
								
								WebUI.takeScreenshot()
								keyLogger.markFailed("Facematch Verihub succesfully hit with value under threshold: "+valueFMVerihubKYC+"%"+"/n"+
													 "But icon is not red")
								
								WebUI.click(btnBack)
								break LoopPage
								
							}
						}
						
					}

				} else {
					
					WebUI.takeScreenshot()
					keyLogger.markFailed("Button Facematch Verihub still disabled after got error 500 when hit Facematch Dukcapil."+"/n"+
										  "Case FAILED")
						
					WebUI.click(btnBack)
					break LoopPage
					
				}
	
			} else {
				
				/* Click button 'Kembali' */
				WebUI.click(btnBack)
				
				/* Delay the process until 2sec*/
				WebUI.delay(2)
				
				/* Wait until table KYC Verification is present */
				WebUI.waitForElementPresent(table, 5)
				
				WebUI.selectOptionByIndex(drpCustType, indexCustType)
				
				WebUI.selectOptionByIndex(drpEmailType, indexEmailType)
				
				WebUI.waitForPageLoad(3)
				
				/* Storing again table to variable tableKYC to prevent stale element*/
				tableKYC = driver.findElement(By.xpath('//tbody'))
				
				/* Storing again rows to variable listRows to prevent stale element*/
				listRows = tableKYC.findElements(By.tagName('tr'))
			}
			
		} else {
			
			/* Refresh the page */
			WebUI.refresh()
			
			/* We will wait for 3 second till page finish load*/
			WebUI.waitForPageLoad(3)
			
			/* Verify if the button 'Kembali' is exists and clickable, if it's not exists will move to else statement */
			if(WebUI.waitForElementNotClickable(btnBack, 5)) {
				
				/* Mark case as failed and print info message*/
				keyLogger.markFailed("Something happened when open KYC Verification Detail. Case FAILED")
				
				/* Take the screenshot*/
				WebUI.takeScreenshot()
				
				/* Break the loop */
				break LoopPage
				
			} else {
				
				/* Storing again table to variable tableKYC to prevent stale element*/
				tableKYC = driver.findElement(By.xpath('//tbody'))
				
				/* Storing again rows to variable listRows to prevent stale element*/
				listRows = tableKYC.findElements(By.tagName('tr'))
				
			}
		}	
	}
	
	/* This conditional represent if the all the data was check in current page,
	 * system will direct to the next page. */
	if (flagLoopPage == false) { 
		
		/* Define variable 'expectedCurrentPage' and store the current page */
		def expectedCurrentPage = WebUI.getText(txtCurrentPage)

		/* Define variable 'expectedLastPage' and store the last page */
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

listRowsFace.clear()
listColumnFace.clear()

if(flagCSR) {
	
	WebUI.callTestCase(findTestCase(testCaseName), [('menuCSRManagement'):menuCSRManagement, ('blockBylockedUserElement'):blockBylockedUserElement, 
					  ('alertConfirmationPopUpElement'):alertConfirmationPopUpElement, ('alertConfirmationPopUpText'):alertConfirmationPopUpText, 
					  ('btnCancelPopUpElement'):btnCancelPopUpElement, ('headerCSRManagementElement'):headerCSRManagementElement, 
					  ('headerCSRManagementText'):headerCSRManagementText])
	
	WebUI.setText(txtReqId, reqID)
	
	WebUI.click(btnSearch)
	
	if(WebUI.waitForElementPresent(btnDetailReqID, 5)) {
		
		WebUI.click(btnDetailReqID)
		
		if(WebUI.waitForElementPresent(btnBack, 10)) {
			
			WebUI.scrollToElement(btnDataNoHandphone, 3)
			
			WebUI.click(btnDataSelfieAndKtpImages)
			
			WebUI.waitForElementPresent(txtPhotoKTP, 5)
			
			tableFaceAccuracy = driver.findElement(By.xpath('//*[@id="images"]//tbody'))
			 
			listRowsFace = tableFaceAccuracy.findElements(By.tagName('tr'))
			 
			listColumnFace = listRowsFace.get(2).findElements(By.tagName('td'))
			 
			actIconFMVerihubAccuracyCSR = listColumnFace.get(1).findElement(By.tagName('svg')).getAttribute('class')
			 
			valueFMVerihubCSR = WebUI.getText(txtValueFMVerihub).replace("%", "")
			 
			if(valueFMVerihubCSR.equals(valueFMVerihubKYC)) {
				 
				if(actIconFMVerihubAccuracyCSR.equals(actIconFMVerihubAccuracyKYC)) {
				
					WebUI.scrollToElement(btnDataChangeLog, 3)
					
					WebUI.click(btnDataChangeLog)
					
					WebUI.waitForElementPresent(drpFilterActions, 5)
					
					WebUI.selectOptionByValue(drpFilterActions, optionEdited, false)
					
					WebUI.delay(2)
					
					WebUI.selectOptionByValue(drpFilterSource, optionSource, false)
					
					WebUI.delay(2)
					
					tableChangeLog = driver.findElement(By.xpath('//*[@id="changelog"]//tbody'))
					 
					listRowsChangeLog = tableChangeLog.findElements(By.tagName('tr'))
					 
					listColumnChangeLog = listRowsChangeLog.get(0).findElements(By.tagName('td'))
					
					String actNewValueVerihubChangeLog = listColumnChangeLog.get(5).getText()
					
					int index = 1
					
					for(int j=0;j<listContentName.size();j++) {
						
						String actValue
						index++
						
						actValue = listColumnChangeLog.get(index).getText()
						
						if(j!=3){
							
							if(actValue.equals(listExpValue.get(j))) {
								
								keyLogger.markPassed("Value "+listContentName+" is correct.")
								
							} else {
								
								keyLogger.markFailed("Value "+listContentName+" is wrong. Actual value: "+actValue+" and Expected value: "+listExpValue.get(j))
								
							}
							
						} else {
							
							if(actValue.equals(valueFMVerihubCSR+"%")) {
								
								keyLogger.markPassed("Value "+listContentName+" is correct.")
								
							} else {
								
								keyLogger.markFailed("Value "+listContentName+" is wrong. Actual value: "+actValue+" and Expected value: "+valueFMVerihubCSR+"%")
								
							}
							
						}						
						
					}
					
					WebUI.takeScreenshot()
				
				} else {
						
					WebUI.takeScreenshot()
					keyLogger.markFailed("Icon color of result Facematch verihub between KYC and CSR are different."+"/n"+
										  "Case FAILED")
					
				}
				 
			} else{
				 
				WebUI.takeScreenshot()
				keyLogger.markFailed("Result value of Facematch verihub between KYC and CSR are different."+"/n"+
									  "Case FAILED")
			}
			
		} else {
			
			WebUI.takeScreenshot()
			keyLogger.markFailed("Can't open request id detail "+reqID+" in CSR Management. Please check manually.")
			
		}
		
		
	} else {
		
		WebUI.takeScreenshot()
		keyLogger.markFailed("Can't find the request id detail "+reqID+" in CSR Bucketlist. Please check manually.")
		
	}
	
}