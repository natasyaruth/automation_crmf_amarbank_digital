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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

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
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}
/*'We want to check element visible filter card status , select that and
 *  then we want to capture account number before and after'*/
if (WebUI.verifyElementVisible(drpDwnChooseStatusCard ,FailureHandling.OPTIONAL)) {
	/*'We want to choose text "Block Kartu ATM"'*/
	WebUI.selectOptionByLabel(drpDwnChooseStatusCard, "Permintaan Kartu Baru", false)
	if (WebUI.verifyElementVisible(firstRowRequestIdElement , FailureHandling.OPTIONAL)) {
		WebUI.click(firstRowRequestIdElement)
	} else {
		keyLogger.markFailed("We dont find request ID with these condition")
	}
} else {
	keyLogger.markFailed("We dont find the filter")
}
/* We want to back at bucket list*/
WebUI.waitForElementVisible(btnBackToBucketList, 5)
WebUI.click(btnBackToBucketList)
/* We want go to menu assign card*/
WebUI.waitForElementVisible(headerCSRManagementElement, 5)
boolean prepareToAssignCard = WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
if (prepareToAssignCard == true) {
	TestObject goToMenuAssignCard = new TestObject().addProperty("text", ConditionType.CONTAINS , "Card Management")
	if (WebUI.verifyElementPresent(goToMenuAssignCard, 5)) {
		/* We want to makesure we can identify element assign card*/
		if (WebUI.verifyElementVisible(menuAssignCardElement, FailureHandling.OPTIONAL)) {
			/* We want to click menu assign card element*/
			WebUI.click(menuAssignCardElement)
		} else {
			/* We want to verify menu card management element*/
			WebUI.verifyElementPresent(menuCardManagementElement, 5)
			/* We want to click menu card management to exand sub menu*/
			WebUI.click(menuCardManagementElement)
			/* We want to verify menu assign card element*/
			WebUI.verifyElementPresent(menuAssignCardElement, 5)
			/* We want to click menu assign card element*/
			WebUI.click(menuAssignCardElement)
		}
		
		/* We want handling the execption in Assign Card if available when the process is locked*/
		if (WebUI.verifyElementPresent(blockBylockedUserElement, 5, FailureHandling.OPTIONAL)) {
			WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)
			WebUI.verifyElementText(btnCancelPopUpElement, btnCancelPopUpText)
			WebUI.click(btnCancelPopUpElement)
			WebUI.waitForElementVisible(headerAssignCardElement, 5)
			WebUI.verifyElementText(headerAssignCardElement, headerAssignCardText)
		}else {
			WebUI.verifyElementText(headerAssignCardElement, headerAssignCardText)
		}
	}
}