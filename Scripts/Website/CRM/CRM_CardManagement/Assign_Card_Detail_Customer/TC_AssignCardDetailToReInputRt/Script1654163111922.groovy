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
import org.apache.commons.lang.RandomStringUtils

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

/* We want to edit data "Tempat pengiriman kartu"*/
WebUI.selectOptionByLabel(fieldDeliveryCardPlaceElement, fieldDeliveryCardPlaceText, false)

/* We want to verify field "Alamat Lengkap"*/
WebUI.verifyElementPresent(fieldDeliveryFullAddressElement, 5)

/* We want to edit data "Alamat Lengkap"*/
WebUI.setText(fieldDeliveryFullAddressElement, fieldDeliveryFullAddressText)

/* We want to get text old Rt*/
OldRt = WebUI.getAttribute(fieldDeliveryRtElement, "value")

/* We want to verify field "Rt"*/
WebUI.verifyElementPresent(fieldDeliveryRtElement, 5)

/* We want to edit data "Rt"*/
newRt = WebUI.setText(fieldDeliveryRtElement, fieldDeliveryRtText + RandomStringUtils.randomNumeric(2))

/* We want capture the update address*/
WebUI.takeScreenshot()

/* We want to verify field "Rw"*/
WebUI.verifyElementPresent(fieldDeliveryRwElement, 5)

/* We want to edit data "RW"*/
WebUI.setText(fieldDeliveryRwElement, fieldDeliveryRwText)

/* We want to verify field "Provinsi"*/
WebUI.verifyElementPresent(fieldDeliveryProvinceElement, 5)

/* We want to wait until element visible*/
WebUI.waitForElementVisible(fieldDeliveryProvinceElement, 5)

/* We want to edit data "Provinsi"*/
WebUI.selectOptionByLabel(fieldDeliveryProvinceElement, fieldDeliveryProvinceText, false)

/* We want to verify field "Kabupaten / kota"*/
WebUI.verifyElementPresent(fieldDeliveryCityElement, 5)

/* We want to wait until element visible*/
WebUI.waitForElementVisible(fieldDeliveryCityElement, 5)

/* We want to edit data "Kabupaten / kota"*/
WebUI.selectOptionByLabel(fieldDeliveryCityElement, fieldDeliveryCityText, false)

/* We want to verify field "Kecamatan"*/
WebUI.verifyElementPresent(fieldDeliverySuburbElement, 5)

/* We want to wait until element visible*/
WebUI.waitForElementVisible(fieldDeliverySuburbElement, 5)

/* We want to edit data "Kecamatan"*/
WebUI.selectOptionByLabel(fieldDeliverySuburbElement, fieldDeliverySuburbText, false)

/* We want to verify field "Kelurahan / Desa"*/
WebUI.verifyElementPresent(fieldDeliveryVillageElement, 5)

/* We want to wait until element visible*/
WebUI.waitForElementVisible(fieldDeliveryVillageElement, 5)

/* We want to edit data "Kelurahan / Desa"*/
WebUI.selectOptionByLabel(fieldDeliveryVillageElement, fieldDeliveryVillageText, false)

/* We want to verify field "Kode Pos"*/
WebUI.verifyElementPresent(fieldPostalCodeElement, 5)

/* We want to verify field "Kode Pos" not click able*/
WebUI.verifyElementNotClickable(fieldPostalCodeElement)

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
WebUI.click(btnSaveAddressElement)

/* We want makesure Rt has been change*/
WebUI.verifyNotMatch(newRt, OldRt, false)

/* We want to click button "kembali" just for unblock the process*/
WebUI.click(btnBackToCardManagementElement)