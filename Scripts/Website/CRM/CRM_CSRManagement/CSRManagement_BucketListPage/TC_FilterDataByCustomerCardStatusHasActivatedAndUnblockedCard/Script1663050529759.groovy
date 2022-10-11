import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.util.concurrent.locks.Condition as Condition
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.org.apache.bcel.internal.generic.RETURN as RETURN
import groovy.transform.ConditionalInterrupt as ConditionalInterrupt
import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.server.handler.RefreshPage as RefreshPage
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

/*'Declaration keylog forloggin'*/
KeywordUtil keyLogger = new KeywordUtil()

/*'We want to makesure we can access CSR Management'*/
boolean checkMenuCsr = WebUI.verifyElementVisible(menuCSRManagement, FailureHandling.OPTIONAL)

if (checkMenuCsr == true) {
    WebUI.click(menuCSRManagement)
} else {
    keyLogger.markFailed('Something happen with menu CSR Management')
}

/*'We want to check blocked notification and check for text blocked 
 * if alert confirmation pop up enable is true'*/
if (WebUI.waitForElementVisible(blockBylockedUserElement, 5, FailureHandling.OPTIONAL)) {
    boolean checkAlertProcess = WebUI.verifyElementVisible(alertConfirmationPopUpElement)

    if (checkAlertProcess == true) {
        WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)

        WebUI.click(btnCancelPopUpElement)

        WebUI.waitForElementVisible(headerCSRManagementElement, 15)

        WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
    } else {
        keyLogger.markFailed('We don\'t find alert confirmation')
    }
    
    WebUI.waitForElementVisible(headerCSRManagementElement, 5)

    WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
} else {
    WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}

WebDriver driver = DriverFactory.getWebDriver()
WebElement tableBucketListCsr
List<WebElement> listRows
/* We want to setup to block card as a precondition*/
loopCondition:
while (flagLoop == false) {
	tableBucketListCsr = driver.findElement(By.xpath('//table/tbody'))
	listRows = tableBucketListCsr.findElements(By.tagName('tr'))
	for (int i=0;i<listRows.size();i++) {
		if (WebUI.verifyElementVisible(drpDwnChooseStatusCard, FailureHandling.OPTIONAL)) {
			WebUI.selectOptionByLabel(drpDwnChooseStatusCard, 'Sudah Aktivasi', false)
			WebUI.selectOptionByLabel(drpDwnCustType, 'Nasabah Senyumku', false)
		}
		println('No. of rows: ' + listRows.size()+ ' row number '+i)
		List<WebElement> listCols = listRows.get(i).findElements(By.tagName('td'))
		if (i < listRows.size()) {
			if (listCols.get(6).getText().equalsIgnoreCase('Detail')) {
				listCols.get(6).findElement(By.tagName('button')).click()
				if (WebUI.verifyElementClickable(MaximizeATMDataInfo,FailureHandling.OPTIONAL)) {
					WebUI.click(MaximizeATMDataInfo)
					if (WebUI.verifyElementClickable(btnBlockCard,FailureHandling.OPTIONAL)) {
						WebUI.click(btnBlockCard)
						TestObject statusCardBlock = new TestObject().addProperty('text',ConditionType.CONTAINS,'Block Kartu ATM')
						if (WebUI.verifyElementPresent(statusCardBlock, 5,FailureHandling.OPTIONAL)) {
							WebUI.click(CheckAskMotherName)
							WebUI.click(CheckAccountNumber)
							WebUI.click(CheckAskPhoneNumber)
							WebUI.click(rbTemporaryBlock)
							WebUI.click(btnSubmitBlock)
							WebUI.click(BtnBack)
							break loopCondition
						} else {
							/*Back to Bucketlist*/
							WebUI.click(BtnBack)
							tableBucketListCsr = driver.findElement(By.xpath('//table/tbody'))
							listRows = tableBucketListCsr.findElements(By.tagName('tr'))
						}
					}else {
					/*Back to Bucketlist*/
					WebUI.click(BtnBack)
					tableBucketListCsr = driver.findElement(By.xpath('//table/tbody'))
					listRows = tableBucketListCsr.findElements(By.tagName('tr'))
				}
				}
			}
		} else {
			WebUI.click(btnNextPage)
			tableBucketListCsr = driver.findElement(By.xpath('//table/tbody'))
			listRows = tableBucketListCsr.findElements(By.tagName('tr'))
		}
	}
}

/* We want to filter data in CSR by Customer card status with Status 'Block Kartu ATM'*/
/* We want to select Status card */
WebUI.verifyElementVisible(drpDwnChooseStatusCard, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(drpDwnChooseStatusCard, BlockedCardATM, false)

WebUI.delay(5)

/* Verify data is found page*/
WebUI.waitForElementVisible(FirstRowCustomerType, 5)

WebUI.verifyElementVisible(FirstRowCustomerType, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(FirstRowCustomerType, 15)

WebUI.verifyTextPresent(SenyumkuCustomerType, false)

/* Take Screenshot*/
WebUI.takeScreenshot()

/*Click button detail for the customer data in row 1*/
WebUI.click(BtnDetail)

WebUI.delay(5)

/*Verify flag card type status "Block Kartu ATM"*/
WebUI.waitForElementVisible(MaximizeATMDataInfo, 15)

WebUI.verifyElementVisible(MaximizeATMDataInfo, FailureHandling.OPTIONAL)

WebUI.click(MaximizeATMDataInfo)

WebUI.waitForElementVisible(FlagBlockedCardATM, 15)

WebUI.verifyElementVisible(FlagBlockedCardATM, FailureHandling.OPTIONAL)

WebUI.verifyTextPresent(BlockedCardATM, false)

/* Do Unblock Card ATM*/
WebUI.click(ButtonUnblockCard)

WebUI.waitForElementVisible(HeaderUnblockCardPopUp, 15)

WebUI.verifyElementVisible(HeaderUnblockCardPopUp, FailureHandling.OPTIONAL)

WebUI.click(CheckAskMotherName)

WebUI.click(CheckAccountNumber)

WebUI.click(CheckAskPhoneNumber)

WebUI.setText(TxtUnblockCardReason, TxtReasonUnblockCard)

WebUI.delay(3)

WebUI.click(ButtonSubmitUnblockCard)

/*Verify flag card type status "Sudah Aktivasi"*/
WebUI.waitForElementVisible(FlagHasActivated, 15)

WebUI.verifyElementVisible(FlagHasActivated, FailureHandling.OPTIONAL)

WebUI.verifyElementNotPresent(FlagBlockedCardATM, 5)

TestObject statusCard = new TestObject().addProperty('text',ConditionType.CONTAINS,'Sudah Aktivasi')

WebUI.verifyElementPresent(statusCard, 5)

WebUI.delay(5)

/* We want to get bank account number text*/
def BankAccountNumber = WebUI.getAttribute(dataAccountNumber, 'value')
println(BankAccountNumber)

/* Take Screenshot*/
WebUI.takeScreenshot()

/*Back to Bucketlist*/
WebUI.click(BtnBack)

/* We want to filter data in CSR by Customer card status with Status 'Sudah Aktivasi'*/
/* We want to select Status card */
WebUI.waitForElementVisible(drpDwnChooseStatusCard, 5)

WebUI.verifyElementVisible(drpDwnChooseStatusCard, FailureHandling.OPTIONAL)

/* We want to search by bank account number*/
WebUI.waitForElementVisible(fieldAccountNumber, 5)

WebUI.verifyElementVisible(fieldAccountNumber, FailureHandling.OPTIONAL)

WebUI.setText(fieldAccountNumber, BankAccountNumber)
WebUI.delay(5)

WebUI.click(btnSearch)

/* Verify data is found page*/
WebUI.waitForElementVisible(FirstRowCustomerType, 5)

WebUI.verifyElementVisible(FirstRowCustomerType, FailureHandling.OPTIONAL)

WebUI.verifyElementPresent(FirstRowCustomerType, 15)

WebUI.verifyTextPresent(SenyumkuCustomerType, false)
WebUI.verifyElementAttributeValue(dataAccountNumber, 'value', BankAccountNumber, 5)

/* Take Screenshot*/
WebUI.takeScreenshot()

/*Click button detail for the customer data in row 1*/
WebUI.click(BtnDetail)

WebUI.delay(5)

/*Verify flag card type status*/
WebUI.waitForElementVisible(MaximizeATMDataInfo, 15)

WebUI.verifyElementVisible(MaximizeATMDataInfo, FailureHandling.OPTIONAL)

WebUI.click(MaximizeATMDataInfo)

TestObject statusCardBlocked = new TestObject().addProperty('text',ConditionType.CONTAINS,'Sudah Aktivasi')
if (WebUI.verifyElementPresent(statusCardBlocked, 5,FailureHandling.OPTIONAL)) {
	WebUI.waitForElementVisible(FlagHasActivated, 15)
	WebUI.verifyElementVisible(FlagHasActivated, FailureHandling.OPTIONAL)
	WebUI.verifyElementNotPresent(FlagBlockedCardATM, 5)
} else {keyLogger.logInfo('element not present')}

WebUI.verifyElementAttributeValue(dataAccountNumber, 'value', BankAccountNumber, 5)
WebUI.delay(5)

/* We want change back the data is blocked for furthure task*/
if (WebUI.verifyElementClickable(btnBlockCard,FailureHandling.OPTIONAL)) {
	WebUI.click(btnBlockCard)
	TestObject changeToBlock = new TestObject().addProperty('text',ConditionType.CONTAINS,'Block Kartu ATM')
		if (WebUI.verifyElementPresent(changeToBlock, 5,FailureHandling.OPTIONAL)) {
			WebUI.click(CheckAskMotherName)
			WebUI.click(CheckAccountNumber)
			WebUI.click(CheckAskPhoneNumber)
			WebUI.click(rbTemporaryBlock)
			WebUI.click(btnSubmitBlock)
		}
} else {keyLogger.logInfo('Button is disable')}

/* Take Screenshot*/
WebUI.takeScreenshot()

/*Back to Bucketlist*/
WebUI.click(BtnBack)

/* Take Screenshot*/
WebUI.takeScreenshot()

/* Do refresh to the page*/
WebUI.refresh()

