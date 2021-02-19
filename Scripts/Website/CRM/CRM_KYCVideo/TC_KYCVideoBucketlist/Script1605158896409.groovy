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

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkRequestID'), 5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnNextPage'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnFirstPage'), 5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnLastPage'))

WebUI.waitForElementNotPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnLastPage'), 5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnPreviousPage'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnLastPage'), 5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnFirstPage'))

WebUI.waitForElementNotPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnFirstPage'), 5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), customerAll, 
    false)

WebUI.verifyTextPresent(customerAll, false)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), customerNasabahBaru, 
    false)

WebUI.verifyTextPresent(customerNasabahBaru, false)

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), customerNasabahSenyumku, 
    false)

WebUI.verifyTextPresent(customerNasabahSenyumku, false)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), customerTunaikuLeadgen, 
    false)

WebUI.verifyTextPresent(customerTunaikuLeadgen, false)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), customerSenyumkuDeposito, 
    false)

WebUI.verifyTextPresent(customerSenyumkuDeposito, false)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DtpStartFilterDate'), filterStartDate)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DtpStartFilterDate'), filterStartDate, 
    5)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DtpEndFilterDate'), filterEndDate)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DtpEndFilterDate'), filterEndDate, 
    5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnShow'))

WebUI.waitForElementVisible(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkRequestID'), 10)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/TxtSearchRequestID'), searchKYC)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnSearch'))

WebUI.waitForElementVisible(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkRequestID'), 10)

