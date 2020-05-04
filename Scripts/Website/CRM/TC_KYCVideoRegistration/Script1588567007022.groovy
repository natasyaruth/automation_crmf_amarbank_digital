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

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnNextPage'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnLastPage'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnPreviousPage'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnFirstPage'))

WebUI.delay(1)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/TxtSearchRequestID'), SearchRequestID)

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnSearch'))

WebUI.delay(1)

CustomKeywords.'com.tunaiku.keyword.ClickUsing_JS.clickUsingJS'(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkRequestID'), 
    0)

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

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnKYCFinished'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/ImgSelfieKYC'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtAdditionalNote'), AdditionalNote)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnSend'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnBacktoKYC'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnSend'))

WebUI.delay(1)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/TxtHistoryCall'), HistoryCall)

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnSendKYC'))

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnBackToBucketList'))

