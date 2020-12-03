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

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkVideoRequest'))

WebUI.delay(1)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/TxtSearchRequestID'), SearchRequestID)

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnSearch'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkRequestID'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnCancel'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/TxtSearchRequestID'), SearchRequestID)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnSearch'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkRequestID'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpName'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpNumber'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkBirthDate'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkMotherName'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkCardDeliveryAddress'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpImage'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpFace'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkPhotoCapture'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnKYCFinished'))

WebUI.delay(1)

CustomKeywords.'com.tunaiku.keyword.ClickUsing_JS.clickUsingJS'(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/ImgKTPKYC'), 
    0)

WebUI.delay(1)

CustomKeywords.'com.tunaiku.keyword.ClickUsing_JS.clickUsingJS'(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/ImgSelfieKYC'), 
    0)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtAdditionalNote'), AdditionalNote)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnReject2'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/BtnClose'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnReject2'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkNotPassVerification'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkDeviceNotCompatible'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkErrorWavecell'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkNetworkIssues'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkRecordingIsNotClear'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkPhotosIsNotSame'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkOther'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/TxtOther'), Other)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/BtnSend'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/BtnCloseModal'))

