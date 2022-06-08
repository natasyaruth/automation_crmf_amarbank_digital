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

/* We want to verify Request ID*/
WebUI.verifyElementPresent(requestIdElement, 5)

/* We want to click Request ID*/
WebUI.click(requestIdElement)

/* We want to verify element and text "Detail Nasabah"*/
WebUI.verifyElementText(headerCustomerDetailElement, headerCustomerDetailText)

/* We want to verify button re-assign detail card*/
WebUI.verifyElementPresent(btnReassignElement, 5)

/* We want to verify card number*/
WebUI.verifyElementPresent(fieldCardNumberElement, 5)

/* We want to get existing card number*/
existingCardNumber = WebUI.getAttribute(fieldCardNumberElement, "value")

/* We want to click button re-assign detail request*/
WebUI.click(btnReassignElement)

/* We want to verify pop up re-assign detail request*/
WebUI.verifyElementPresent(popUpNotifReassignElement, 5)

/* We want to verify element and text pop up konfirmasi*/
WebUI.verifyElementText(confirmationReAssignTextElement, confirmationReAssignText)

/* We want capture the notification*/
WebUI.takeScreenshot()

/* We want to verify button "Re-Assign"*/
WebUI.verifyElementPresent(btnReAssignNotificationElement, 5)

/* We want to click button "Re-Assign"*/
WebUI.click(btnReAssignNotificationElement)

/* We we want to makesure card number not same with existing card number*/
WebUI.verifyTextNotPresent(existingCardNumber, false)

/* We want capture the new card number*/
WebUI.takeScreenshot()

/* We want to verify button "kembali" to unblock the request*/
WebUI.verifyElementPresent(btnBackElement, 5)

/* We want to click button "kembali" to unblock the request*/
WebUI.click(btnBackElement)

/* We want capture new card*/
WebUI.takeScreenshot()

/* We want to refresh for the next process*/
WebUI.refresh()