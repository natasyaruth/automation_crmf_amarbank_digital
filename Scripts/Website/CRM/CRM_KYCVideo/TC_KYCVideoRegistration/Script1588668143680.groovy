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

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkVideoRequest'))

WebUI.delay(3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), CustomerType, 
    false)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DtpStartFilterDate'), StartFilterdate, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DtpEndFilterDate'), EndFilterDate)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnShow'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/TxtSearchRequestID'), SearchKYC)

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnSearch'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkRequestID'))

WebUI.verifyTextPresent(verify_checkbox, false)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/DrpAddressType'), AddressType, false)

WebUI.delay(1)

WebUI.clearText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtFullAdress'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtFullAdress'), FullAddress)

WebUI.delay(1)

WebUI.clearText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtNeighbourhood'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtNeighbourhood'), Neighbourhood)

WebUI.delay(1)

WebUI.clearText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtHamlet'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtHamlet'), Hamlet)

WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/DrpProvince'), Province, false)

WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/DrpDistrict'), District, false)

WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/DrpSubdistrict'), Subdistrict, false)

WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/DrpVillage'), Village, false)

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpName'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpNumber'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkBirthDate'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkMotherName'))

WebUI.delay(1)

//WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkEmail'))
WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkCardDeliveryAddress'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpImage'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpFace'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkPhotoCapture'))

//WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkEmailConfirmation'))
WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnKYCFinished'))

WebUI.delay(2)

CustomKeywords.'com.tunaiku.keyword.ClickUsing_JS.clickUsingJS'(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/ImgKTPKYC'), 
    0)

WebUI.delay(2)

CustomKeywords.'com.tunaiku.keyword.ClickUsing_JS.clickUsingJS'(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/ImgSelfieKYC'), 
    0)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtAdditionalNote'), AdditionalNote)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnSend'))

WebUI.delay(2)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkNotPassVerification'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkDeviceNotCompatible'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkErrorWavecell'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkNetworkIssues'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkRecordingIsNotClear'))

WebUI.delay(2)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkPhotosIsNotSame'))

WebUI.delay(2)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkOther'))

WebUI.delay(2)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/TxtOther'), Other)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/BtnSend'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/BtnCloseModal'))

WebUI.delay(5)

