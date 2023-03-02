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

/* Declarate variable countNotMatchValue, countStateButton and iniatiate with zero */
int countNotMatchValue, countStateButton = 0

/* Declarate variable flagLoopPage as boolean and iniatiate with false */
boolean flagLoopPage = false

/* This looping is represent to search new customer with origin from embed banking such as eFishery, Dagangan or Finku. */
LoopPage:
while(flagLoopPage == false) {
	/* Storing table to variable tableKYC*/
	tableKYC = driver.findElement(By.xpath('//tbody'))
	
	/* Storing all rows to variable listRows*/
	listRows = tableKYC.findElements(By.tagName('tr'))
	
	/* Looping through number of rows of bucketlist KYC Verification*/
	for(int i=0;i<listRows.size();i++) {
	
	/* Select filter customer type*/
	WebUI.selectOptionByLabel(drpDwnCustType, 'Nasabah Baru', false)
	
	/* Select filter email verification */
	WebUI.selectOptionByLabel(drpDwnEmailVerf, "Terverifikasi", false)	
	WebUI.waitForPageLoad(5)
	WebUI.delay(3)
		
		/* Storing again column to variable listColumn to prevent stale element*/
		listColumn = listRows.get(i).findElements(By.tagName('td'))
		
		/* Click button detail of customer*/
		listColumn.get(7).findElement(By.tagName('a')).click()
		
		/* We will wait for 2 second till page finish load*/
		WebUI.waitForPageLoad(2)
		
		/* Verify if the button 'Kembali' is clickable, if it's not clickable will move to else statement */
		if(WebUI.waitForElementClickable(btnBack, 5)) {
			
			/* Insert value origin customer by get the text customer origin from KYC Verification detail */
			actSourceOrigin = WebUI.getText(txtSourceOrigin)
			
			/* Print to console origin customer */
			println actSourceOrigin
			
			/* Verify if the origin customer is from eFishery or Finku or Dagangan */
			if(actSourceOrigin.equals(srcOriginEfishery) || actSourceOrigin.equals(srcOriginFinku) || 
				actSourceOrigin.equals(srcOriginDagangan) || actSourceOrigin.equals(srcOriginInvestreeIOS) ||
				actSourceOrigin.equals(srcOriginInvestreeAndroid)){
				
				/* Looping through number of rows of listElement. ListElement consist of all element web that we want to check*/
				for(int j=0;j<listElement.size();j++) {
					
					/* Looping index <3 filled with logic comparing value text such as customer type, request type and status request*/
					if(j<3) {
						
						/* Store value actual text from element listed to variable actText*/
						String actText = WebUI.getText(listElement.get(j))
						
						/* Compare actual text to expected*/
						if(actText != listContent.get(j)) {
							
							/* Increment variable countNotMatchValue*/
							countNotMatchValue++
						}

					/* Looping index >3 filled with logic comparing state button such as button Terima, Lanjutkan KYC and Tolak*/
					} else {
						
						/* Store state of button as boolean to variable actStateButton*/
						boolean actStateButton = WebUI.verifyElementClickable(listElement.get(j), FailureHandling.OPTIONAL)
						
						/* Compare actual state to expected*/
						if (actStateButton != listContent.get(j)) {
							
							/* If loop checking at button 'Terima' which mean at index 3, we will check result of Liveness,
							 * Cek data Dukcapil and Facematch*/
							if(j==3) {
								
								/* Check element result liveness is visible*/
								if(WebUI.waitForElementVisible(resultLiveness, 2)) {
									
									/* Store value actual result from element liveness */
									String valueLiveness = WebUI.getText(resultLiveness)
									
									/* Store value actual result from FM Dukcapil, FM Verihub, Cek data Dukcapil and Liveness */
									boolean isFMDukcapil = WebUI.waitForElementNotVisible(resultFMDukcapil,1)
									boolean	isFMVerihub = WebUI.waitForElementNotVisible(resultFMVerihub,1)
									boolean isMatchDukcapil = WebUI.waitForElementNotVisible(resultDukcapilMatch, 1)
									boolean isLiveness = valueLiveness.equals("-")
									
									/* Compare all result */
									if(isLiveness || isMatchDukcapil || isFMDukcapil || isFMVerihub){
										
										/* Mark case as passed */
										keyLogger.markPassed("All condition for button Terima is disabled are fulfilled")
										
									} else {
										
										/* Increment variable countStateButton and print info to console*/
										countStateButton++
										println "Button Terima is disabled while result of Liveness, Cek data Dukcapil, and Facematch already exists"
									}
			
								}
								
							} else {
								
								/* Increment variable countStateButton*/
								countStateButton++
							}	
						}
						
					}
				}
				
				/* Click button 'Kembali' */
				WebUI.click(btnBack)
				
				/* Break the loop */
				break LoopPage
	
			} else {
				
				/* Click button 'Kembali' */
				WebUI.click(btnBack)
				
				/* Delay the process until 2sec*/
				WebUI.delay(2)
				
				/* Wait until table KYC Verification is present */
				WebUI.waitForElementPresent(table, 5)
				
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

/* Make sure all value text is match */
if(countNotMatchValue.equals(0)) {
	
	/* Make sure all state button is match */
	if(countStateButton.equals(0)) {
		
		/* Mark case is passed */
		keyLogger.markPassed("All state button and information are correct. Case SUCCESS")
		
	/* If there is state button is not match, will mark as failed */
	} else {
		keyLogger.markFailed("There is button is not in correct state. Case FAILED")
	}
	
/* If there is value text is not match will mark as failed */
} else {
	keyLogger.markPassed("There is missmatch information. Case FAILED")
}