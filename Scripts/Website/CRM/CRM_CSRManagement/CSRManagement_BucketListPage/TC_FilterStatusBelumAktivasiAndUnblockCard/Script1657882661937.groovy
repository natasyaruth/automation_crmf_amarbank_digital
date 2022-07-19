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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.org.apache.bcel.internal.generic.RETURN

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.remote.server.handler.RefreshPage
import org.apache.commons.lang.RandomStringUtils

/*'Declaration keylog forloggin'*/
KeywordUtil keyLogger = new KeywordUtil()
/*'We want to makesure we can access CSR Management'*/
boolean checkMenuCsr = WebUI.verifyElementVisible(menuCSRManagement, FailureHandling.OPTIONAL)
if (checkMenuCsr == true) {
	WebUI.click(menuCSRManagement)
} else {
	keyLogger.markFailed("Something happen with menu CSR Management")
}
/*'We want to check blocked notification and check for text blocked 
 * if alert confirmation pop up enable is true'*/
if (WebUI.waitForElementVisible(blockBylockedUserElement, 5, FailureHandling.OPTIONAL)) {
	boolean checkAlertProcess = WebUI.verifyElementVisible(alertConfirmationPopUpElement)
	if (checkAlertProcess == true) {
		WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)
		WebUI.click(btnCancelPopUpElement)
	} else {
		keyLogger.markFailed("We don't find alert confirmation")
	}
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}else {
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}
/*'We want to check element visible filter card status , select that and
 *  then we want to capture account number before and after'*/
if (WebUI.verifyElementVisible(drpDwnChooseStatusCard ,FailureHandling.OPTIONAL)) {
	/*'We want to choose text "Block Kartu ATM"'*/	
	WebUI.selectOptionByLabel(drpDwnChooseStatusCard, "Block Kartu ATM", false)
	if (WebUI.verifyElementVisible(firstRowRequestIdElement , FailureHandling.OPTIONAL)) {
		/* 'We want to inspect Customer Name & No rekening' */		
		noRek = WebUI.getText(firstRowNoRek)
		custName = WebUI.getText(firstRowCustName)
		WebUI.click(firstRowRequestIdElement)
	} else {
		keyLogger.markFailed("We dont find request ID with these condition")
	}
} else {
	keyLogger.markFailed("We dont find the filter")
}
noRekText = noRek
custNameText = custName
/*'We want to find menu "Data Kartu ATM"'*/
if (WebUI.verifyElementVisible(headerCustDataElement,FailureHandling.OPTIONAL)) {
	/*	'We verify we can access Customer Detail'*/
	TestObject txtAccountNumb = new TestObject().addProperty('text', ConditionType.CONTAINS , headerCustDataText)
	boolean txtRekening = WebUI.verifyElementVisible(txtAccountNumb)
	if (txtRekening == true) {
		WebUI.click(btnDataCardATM)
	} else {
		keyLogger.markFailed("We cannot find the info about " + txtRekening)
	}
}
/*'We want matching No Rekeing'*/
String accountNumberUnblock = WebUI.getAttribute(dataAccountNumber, "value")
WebUI.verifyEqual(accountNumberUnblock, noRekText)
/*'We want to matching Name'*/
String dataCustNameUnblock = WebUI.getAttribute(dataCustName, "value")
WebUI.verifyEqual(dataCustNameUnblock, custNameText)
/*'We want to check notification block ATM card'*/
WebUI.verifyElementVisible(notifiBlockCardText)
/*'We want to inspect button "Unlock Kartu"'*/
boolean btnCardUnlock = WebUI.verifyElementVisible(btnCardUnlockElement , FailureHandling.OPTIONAL)
if (btnCardUnlock == true) {
	/*'We want to click button "Unlock Kartu"'*/	
	WebUI.click(btnCardUnlockElement)
	if (WebUI.verifyElementVisible(headerTextUnblockCard , FailureHandling.OPTIONAL)) {
		String questionMother = WebUI.getText(motherElementText)
		String questionAccount = WebUI.getText(accountNumberText)
		String questionPhone = WebUI.getText(phoneNumberText)
		List infoList = new ArrayList()
		infoList.add(questionMother)
		infoList.add(questionAccount)
		infoList.add(questionPhone)
		if (infoList.contains("Menanyakan nama ibu kandung")) {
			WebUI.click(chkMotherName)
		} else {
			keyLogger.markFailed("We not found " +questionMother)
		}
		if (infoList.contains("Menanyakan No. Rekening")) {
			WebUI.click(chkAccountNumber)
		} else {
			keyLogger.markFailed("We not found" +questionAccount)
		}
		if (infoList.contains("Menanyakan No. Handphone yang terdaftar")) {
			WebUI.click(chkPhoneNumber)
		} else {
			keyLogger.markFailed("We not found" +questionPhone)
		}
		String reCheckAccountNumber = WebUI.getText(accountNumberElement)
		String generateText = RandomStringUtils.randomAlphanumeric(10)
		WebUI.verifyEqual(reCheckAccountNumber, noRekText)
		WebUI.setText(txtUnblockCardReason , generateText)
		WebUI.takeScreenshot()
		WebUI.click(btnSubmitUnlockCard)
	} else {
		keyLogger.markFailed("We not find header from text unblock card page")
	}
} else {
	keyLogger.markFailed("Button unlock didn't showing")
}
/*'We want check notification block card is disappear'*/
WebUI.waitForElementVisible(notifiBlockCardText, 5)
/*'We want to click button back'*/
WebUI.verifyElementVisible(btnBackBucketList)
WebUI.click(btnBackBucketList)
WebUI.refresh()