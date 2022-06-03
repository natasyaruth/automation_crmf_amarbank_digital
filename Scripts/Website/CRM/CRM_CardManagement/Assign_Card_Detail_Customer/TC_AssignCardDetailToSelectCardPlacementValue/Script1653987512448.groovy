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

/* We want to verify menu card management element*/
WebUI.verifyElementPresent(menuCardManagementElement, 5)

/* We want to click menu card management to exand sub menu*/
WebUI.click(menuCardManagementElement)

/* We want to verify menu assign card element*/
WebUI.verifyElementPresent(menuAssignCardElement, 5)

/* We want to click menu assign card element*/
WebUI.click(menuAssignCardElement)

/* We want handling the execption in Assign Card if available when the process is locked*/
if (WebUI.verifyElementPresent(blockBylockedUserElement, 5, FailureHandling.OPTIONAL)) {
	WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)
	WebUI.verifyElementText(btnCancelPopUpElement, btnCancelPopUpText)
	WebUI.click(btnCancelPopUpElement)
}else {
	WebUI.verifyElementText(headerAssignCardElement, headerAssignCardText)
}

/* We want to choose type card is " kartu baru"*/
WebUI.selectOptionByLabel(fieldCardTypeElement, fieldCardTypeLabel, false)

/* We want to verify Request ID*/
WebUI.verifyElementPresent(requestIdElement, 5)

/* We want to click Request ID*/
WebUI.click(requestIdElement)

/* We want to verify element and text "Detail Nasabah"*/
WebUI.verifyElementText(headerCustomerDetailElement, headerCustomerDetailText)

/* We want to verify button "edit"*/
WebUI.verifyElementPresent(btnEditDeliveryCard, 5)

/* We want to click button "Edit"*/
WebUI.click(btnEditDeliveryCard)

/* We want to verify field "Tempat pengiriman kartu"*/
WebUI.verifyElementPresent(fieldDeliveryCardPlaceElement, 5)

/* We want verify data from drop down "Tempat pengiriman kartu"*/
WebUI.verifyOptionPresentByLabel(fieldDeliveryCardPlaceElement, labelApartement, false, 5)

/* We want verify data from drop down "Tempat pengiriman kartu"*/
WebUI.verifyOptionPresentByLabel(fieldDeliveryCardPlaceElement, labelHouse, false, 5)

/* We want verify data from drop down "Tempat pengiriman kartu"*/
WebUI.verifyOptionPresentByLabel(fieldDeliveryCardPlaceElement, labelOffice, false, 5)

/* We want verify data from drop down "Tempat pengiriman kartu"*/
WebUI.verifyOptionPresentByLabel(fieldDeliveryCardPlaceElement, labelRentHouse, false, 5)

/* We want to click field "Tempat pengiriman kartu"*/
WebUI.click(fieldDeliveryCardPlaceElement)

/* We want capture it*/
WebUI.takeScreenshot()

/* We want to verify button "Cancel"*/
WebUI.verifyElementPresent(btnCancelElement, 5)

/* We want to verify button "Simpan"*/
WebUI.verifyElementPresent(btnSaveAddressElement, 5)

/* We want to verify button cancel click able*/
WebUI.verifyElementClickable(btnCancelElement)

/* We want to verify button Simpan click able*/
WebUI.verifyElementClickable(btnSaveAddressElement)

/* We want capture it*/
WebUI.takeScreenshot()

/* We want to cancel edit delivery address*/
WebUI.click(btnCancelElement)

/* We want to click button "kembali" just for unblock the process*/
WebUI.click(btnBackToCardManagementElement)