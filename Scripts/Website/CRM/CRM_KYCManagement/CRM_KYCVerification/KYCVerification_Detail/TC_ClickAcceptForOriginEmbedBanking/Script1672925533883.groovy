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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

/*'Declaration keylog forloggin'*/
KeywordUtil keyLogger = new KeywordUtil()

/* Precondition
 * The button FM Dukcapil must be enable and success then click button check dukcapil
 * */

/*'We want to makesure we can access KYC Management'*/
boolean checkMenuKYC = WebUI.verifyElementVisible(menuKYCManagement, FailureHandling.OPTIONAL)

if (checkMenuKYC == true) {
    WebUI.click(menuKYCManagement)

    WebUI.click(menuKYCVerification)
	
	WebUI.waitForPageLoad(5)
		
	WebUI.delay(3)
} else {
    keyLogger.markFailed('Something happen with menu KYC Management')
}

/* Verify KYC Verification Bucketlist*/
WebUI.verifyElementVisible(headerKYCVerificationElement)

'I want makesure we have data with conditional this testcase'
loopCheckData = false
loopVerif:
while (loopCheckData == false) {
	
	WebDriver driver = DriverFactory.getWebDriver()
	
	WebElement kycVerifTable = driver.findElement(By.xpath('//table/tbody'))
	
	List<WebElement> kycVerifRows = kycVerifTable.findElements(By.tagName('tr'))
	
	for (int i=0;i < kycVerifRows.size();i ++) {
		
		WebUI.selectOptionByLabel(drpEmailType, EmailisVerified, false)
		
		WebUI.selectOptionByLabel(drpCustomerType, NewCustomer, false)
		
		kycVerifTable = driver.findElement(By.xpath('//table/tbody'))
		
		kycVerifRows = kycVerifTable.findElements(By.tagName('tr'))
		
		List<WebElement> kycVerifColums = kycVerifRows.get(i).findElements(By.tagName('td'))
		
		if (kycVerifColums.get(4).getText().equalsIgnoreCase('Nasabah Baru')) {
			
			kycVerifColums.get(7).findElement(By.xpath('a')).click()
			
		} else {
			
			keyLogger.markFailed('We dont have data in bucket list')
		}
		
		'This part I want check firtst the conditional'
		if (WebUI.waitForElementClickable(btnFacematchDukcapil, 5)) {
			
			WebUI.click(btnFacematchDukcapil)
			
			if (WebUI.waitForElementVisible(btnConfirmationFacematch, 0)) {
				
				WebUI.click(btnConfirmationFacematch)
				
				WebUI.waitForPageLoad(5)
				
				WebUI.delay(3)
				
				break loopVerif
				
			}
		} else {
			
			WebUI.click(btnBack)
			
			WebUI.waitForPageLoad(5)
			
			WebUI.delay(3)
			
			kycVerifTable = driver.findElement(By.xpath('//table/tbody'))
			
			kycVerifRows = kycVerifTable.findElements(By.tagName('tr'))
			
		}
		
	}
	
}

'I want to check available button'
if (WebUI.waitForElementClickable(BtnCheckDukcapil, 5)) {
	
	WebUI.click(BtnCheckDukcapil)
	
	if (WebUI.waitForElementVisible(BtnModalCheckDukcapil, 5)) {
		
		WebUI.click (BtnModalCheckDukcapil)
		
		WebUI.waitForPageLoad(5)
		
		WebUI.delay(3)
		
	} else {
		
		keyLogger.markFailed('Button modal Dukcapil not visible please check again the button modal')
		
	}
	
} else {
	
	keyLogger.markFailed('Button check dukcapil not visible please check again')
	
}

if (WebUI.waitForElementVisible(BtnAccept1, 5)) {

	WebUI.click(BtnAccept1)
	
	WebUI.waitForPageLoad(5)
	
	WebUI.delay(3)
	
	if (WebUI.waitForElementVisible(BtnAccept2, 5)) {
		
		WebUI.click(BtnAccept2)
		
		WebUI.waitForPageLoad(5)
		
		WebUI.delay(3)
		
	} else {
		
		keyLogger.markFailed('Button Terima 1 not visible')
		
	}
		
} else {
	
	keyLogger.markFailed('Button Terima 2 not visible')
	
}

/* We want capture the result*/
WebUI.takeScreenshot()

WebUI.delay(5)

WebUI.click(BtnModalBackToBucketlist)

WebUI.verifyElementVisible(headerKYCVerificationElement)

/* We want capture the result*/
WebUI.takeScreenshot()

/* We want to refresh for the next process*/
WebUI.refresh()

