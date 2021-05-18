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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkRequestID'))

WebUI.verifyTextPresent(verifyCheckbox, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/DrpAddressType'), addressType, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/DrpAddressType'), "value", addressType, 
    10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.clearText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtFullAdress'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtFullAdress'), fullAddress)

WebUI.clearText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtNeighbourhood'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtNeighbourhood'), neighbourhood)

WebUI.clearText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtHamlet'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtHamlet'), hamlet)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/DrpProvince'), province, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/DrpProvince'), "value", province, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/DrpDistrict'), district, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/DrpDistrict'), "value", district, 10, 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/DrpSubdistrict'), subDistrict, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/DrpSubdistrict'), "value", subDistrict, 
    10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/DrpVillage'), village, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/DrpVillage'), "value", village, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpName'))

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpName'), 10)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpNumber'))

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpNumber'), 10)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkBirthDate'))

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkBirthDate'), 10)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkMotherName'))

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkMotherName'), 10)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkCardDeliveryAddress'))

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkCardDeliveryAddress'), 
    10)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpImage'))

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpImage'), 10)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpFace'))

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpFace'), 10)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkPhotoCapture'))

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkPhotoCapture'), 
    10)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnKYCFinished'))

WebUI.waitForElementNotPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnKYCFinished'), 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/ImgKTPKYC'), 10, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'com.tunaiku.keyword.ClickUsing_JS.clickUsingJS'(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/ImgKTPKYC'), 
    5)

WebUI.verifyElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/ImgSelfieKYC'), 10, FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'com.tunaiku.keyword.ClickUsing_JS.clickUsingJS'(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/ImgSelfieKYC'), 
    5)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtAdditionalNote'), additionalNote)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnSend'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkNotPassVerification'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkNotPassVerification'))

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkNotPassVerification'), 10)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkDeviceNotCompatible'))

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkDeviceNotCompatible'), 10)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkErrorWavecell'))

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkErrorWavecell'), 10)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkNetworkIssues'))

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkNetworkIssues'), 10)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkRecordingIsNotClear'))

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkRecordingIsNotClear'), 10)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkPhotosIsNotSame'))

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkPhotosIsNotSame'), 10)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkOther'))

WebUI.verifyElementChecked(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkOther'), 10)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/TxtOther'), other)

WebUI.verifyElementText(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/TxtOther'), other)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/BtnSend'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/BtnCloseModal'))

WebUI.waitForPageLoad(30)

