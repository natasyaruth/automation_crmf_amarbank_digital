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
}else {
	WebUI.verifyElementText(headerAssignCardElement, headerAssignCardText)
}

/* We want to verify feature search request ID by identify label */
WebUI.verifyElementText(labelReqIdElement, labelReqIdText)

/* We want verify field from request ID */
WebUI.verifyElementPresent(fieldReqIdElement, 5)

/* We want to verify first request ID*/
WebUI.verifyElementPresent(firstReqIdElement, 5)

/* We want to verify first name ID*/
WebUI.verifyElementPresent(firstNameIdElement, 5)

/* We want grab first attribute name from name ID*/
firstNameId = WebUI.getText(firstNameIdElement)

/* We want grab first attribute from request ID*/
firstReqId = WebUI.getText(firstReqIdElement)

/* We want insert request ID in field request ID*/
WebUI.setText(fieldReqIdElement, firstReqId)

/* We want verify button search in request Id visible*/
WebUI.verifyElementVisible(btnSearchReqId)

/* We want click button search request Id*/
WebUI.click(btnSearchReqId)

/* We want to verify the request Id*/
WebUI.verifyElementText(firstReqIdElement, firstReqId)

/* We want to verify the name Id*/
WebUI.verifyElementText(firstNameIdElement, firstNameId)

/* We want capture the result*/
WebUI.takeScreenshot()

/* We want to refresh for the next process*/
WebUI.refresh()