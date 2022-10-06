import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.concurrent.locks.Condition

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
	WebUI.waitForElementVisible(headerCSRManagementElement, 5)
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}else {
	WebUI.waitForElementVisible(headerCSRManagementElement, 5)
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}
/* We want to add data with status blocked. we will add the request Id as hardcode data test to fill the requirement unblock card*/
if (WebUI.waitForElementVisible(drpDwnChooseStatusCard , 5, FailureHandling.OPTIONAL)) {
	/*'We want to choose text "Sudah Aktivasi"'*/
	WebUI.selectOptionByLabel(drpDwnChooseStatusCard, "Sudah Aktivasi", false)
	if (WebUI.verifyElementVisible(firstRowRequestIdElement , FailureHandling.OPTIONAL)) {
	/* We want to redirect by url to using ref Id*/		
	WebUI.navigateToUrl(urlRefIdWithCondition)
	} else {
		keyLogger.markFailed("We dont find request ID with these condition")
	}
} else {
	keyLogger.markFailed("We dont find the filter")
}
/*'We want to find menu "Data Kartu ATM"'*/
if (WebUI.verifyElementVisible(headerCustDataElement, FailureHandling.OPTIONAL)) {
	/*	'We verify we can access Customer Detail'*/
	TestObject txtAccountNumb = new TestObject().addProperty('text', ConditionType.CONTAINS , headerCustDataText)
	WebUI.verifyElementPresent(txtAccountNumb, 5)
	boolean txtRekening = WebUI.verifyElementVisible(txtAccountNumb)
	if (txtRekening == true) {
		WebUI.click(btnDataCardATM)
		WebUI.takeScreenshot()
		WebUI.delay(2)
	} else {
		keyLogger.markFailed("We cannot find the info about ")
	}
}
if (WebUI.verifyElementClickable(btnCardUnlockElement,FailureHandling.OPTIONAL)) {
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
		String generateText = RandomStringUtils.randomAlphanumeric(200)
		WebUI.setText(txtUnblockCardReason , generateText)
		WebUI.takeScreenshot()
		WebUI.click(btnSubmitUnlockCard)
		WebUI.refresh()
	} else {
		keyLogger.markFailed("We not find header from text unblock card page")
	}
} else {
	/*'We want to click button "Block Kartu"'*/
	WebUI.waitForElementVisible(btnWantToBlockCard, 5)
	WebUI.click(btnWantToBlockCard)
	WebUI.waitForElementVisible(txtHeaderBlockATM, 5)
	WebUI.verifyElementText(txtHeaderBlockATM, "Block Kartu ATM")
	String questionMother = WebUI.getText(motherElementText)
	String questionAccount = WebUI.getText(accountNumberText)
	String questionPhone = WebUI.getText(phoneNumberText)
	String questionReasonBlock = WebUI.getText(temporaryBlockText)
	List infoList = new ArrayList()
	infoList.add(questionMother)
	infoList.add(questionAccount)
	infoList.add(questionPhone)
	infoList.add(questionReasonBlock)
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
	if (infoList.contains("Blokir sementara")) {
		WebUI.click(radioBox)
	} else {
		keyLogger.markFailed("We not found"  +questionReasonBlock)
	}
	WebUI.waitForElementClickable(btnBlockATMCard, 5)
	WebUI.click(btnBlockATMCard)
	WebUI.refresh()
}
WebUI.click(btnDataCardATM)
/* We want to block card again*/
if (WebUI.verifyElementClickable(btnWantToBlockCard,FailureHandling.OPTIONAL)) {
	WebUI.click(btnWantToBlockCard)
	WebUI.waitForElementVisible(txtHeaderBlockATM, 5)
	WebUI.verifyElementText(txtHeaderBlockATM, "Block Kartu ATM")
	String questionMother = WebUI.getText(motherElementText)
	String questionAccount = WebUI.getText(accountNumberText)
	String questionPhone = WebUI.getText(phoneNumberText)
	String questionReasonBlock = WebUI.getText(temporaryBlockText)
	List infoList = new ArrayList()
	infoList.add(questionMother)
	infoList.add(questionAccount)
	infoList.add(questionPhone)
	infoList.add(questionReasonBlock)
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
	if (infoList.contains("Blokir sementara")) {
		WebUI.click(radioBox)
	} else {
		keyLogger.markFailed("We not found"  +questionReasonBlock)
	}
	WebUI.waitForElementClickable(btnBlockATMCard, 5)
	WebUI.click(btnBlockATMCard)
	/*'We want to click button back'*/
	WebUI.waitForElementVisible(btnBackBucketList, 5)
	WebUI.click(btnBackBucketList)
	WebUI.refresh()
} else {
	/*'We want to click button back'*/
	WebUI.waitForElementVisible(btnBackBucketList, 5)
	WebUI.click(btnBackBucketList)
	WebUI.refresh()
}
