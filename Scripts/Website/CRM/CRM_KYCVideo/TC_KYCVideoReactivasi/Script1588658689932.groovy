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

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkVideoRequest'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/TxtSearchRequestID'), SearchRequestID)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnSearch'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkRequestID'))

WebUI.verifyTextPresent(ChangePhoneReason, false)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpName'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkKtpNumber'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkBirthDate'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkMotherName'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkBlockedReason'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkNewPhoneNumber'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkEmail'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkCardDeliveryAddress'))

WebUI.delay(2)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/CheckBoxConfirmation/ChkPhotoCapture'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnKYCFinished'))

WebUI.delay(2)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/ImgSelfieKYC'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtAdditionalNote'), AdditionalNote)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnSend'))

WebUI.delay(2)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkNotPassVerification'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkDeviceNotCompatible'))

WebUI.delay(2)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/HistoryCall/ChkErrorWavecell'))

WebUI.delay(2)

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

WebUI.delay(7)

