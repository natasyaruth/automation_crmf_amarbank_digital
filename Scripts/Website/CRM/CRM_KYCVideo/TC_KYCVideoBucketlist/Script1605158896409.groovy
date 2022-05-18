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

if (WebUI.verifyElementVisible(findTestObject('Website/CRM/KYC_Management/KYC_Video/KYC_Video/KYCVideoLinkVideoRequest'), FailureHandling.OPTIONAL)) {   
	WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/KYC_Video/KYCVideoLinkVideoRequest'))
} else {
	WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Management/KYCManagementLink'))
	WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/KYC_Video/KYCVideoLinkVideoRequest'), 5)
	WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/KYC_Video/KYCVideoLinkVideoRequest'))
}

Mobile.callTestCase(findTestCase('Website/CRM/TC_AbortIncompleteProcess'), [('msgIncompleteProcess') : msgIncompleteProcess])

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkRequestID'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnNextPage'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnFirstPage'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnLastPage'))

WebUI.waitForElementNotPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnLastPage'), 5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnPreviousPage'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnLastPage'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnFirstPage'))

WebUI.waitForElementNotPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnFirstPage'), 5)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/TxtSearchRequestID'), searchKYC)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnSearch'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkRequestID'), 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), customerAll, 
    false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent(customerAll, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), customerNasabahSenyumku, 
    false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent(customerNasabahSenyumku, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), customerTunaikuLeadgen, 
    false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent(customerTunaikuLeadgen, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), customerSenyumkuDeposito, 
    false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent(customerSenyumkuDeposito, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), customerNasabahBaru, 
    false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent(customerNasabahBaru, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DtpStartFilterDate'), filterStartDate)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DtpStartFilterDate'), 
    'value', filterStartDate, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DtpEndFilterDate'), filterEndDate)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DtpEndFilterDate'), 'value', 
    filterEndDate, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnShow'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkRequestID'), 10, FailureHandling.CONTINUE_ON_FAILURE)

