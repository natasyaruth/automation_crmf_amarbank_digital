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

/* We want check we are in bucketlist data assign card*/
WebUI.verifyElementPresent(headerAssignCardElement, 5)

/* We want to check title page of assign card*/
WebUI.verifyElementText(headerAssignCardElement, headerAssignCardText)

/* Expected Result : -Show "Cari Request ID atau Ref ID Nasabah", "Filter Tanggal",
 * "Button Tampilkan", "Filter by Request Card Type", "Filter by Customer Origin"*/

/* We want to check element and text "Cari Request ID atau Ref ID Nasabah"*/
WebUI.verifyElementText(labelFilterReqIdElement, labelFilterReqIdText)

/* We want to check element and text "Filter Tanggal"*/
WebUI.verifyElementText(labelFilterDateElement, labelFilterDateText)

/* We want to check element and text "Button Tampilkan""*/
WebUI.verifyElementText(btnFilterShowElement, btnFilterShowText)

/* We want to check element and text "Filter by request card type"*/
WebUI.verifyElementText(labelFilterByRequestCardElement, labelFilterByRequestCardText)

/* We want to check element and text "Filter by Customer Origin"*/
WebUI.verifyElementText(labelFilterByCustomerElement, labelFilterByCustomerText)

/* We want capture expected result*/
WebUI.takeScreenshot()

/* We want to refresh for the next process*/
WebUI.refresh()