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

WebUI.verifyTextPresent(headerBucketlistCSR, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.refresh()

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Bucketlist/DrpFilter'), filterAll, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Bucketlist/DrpFilter'), filterNewCustomer, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Bucketlist/DrpFilter'), filterCustomerSenyumku, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Bucketlist/BtnLastPage'), FailureHandling.OPTIONAL)

WebUI.waitForElementNotPresent(findTestObject('Website/CRM/CSR_Management/Bucketlist/BtnLastPage'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Bucketlist/BtnPreviousPage'), FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Bucketlist/BtnLastPage'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Bucketlist/BtnNextPage'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Bucketlist/BtnFirstPage'), FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/DtpStartFilterDate'), startFilterDate)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/DtpEndFilterDate'), endFilterDate)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Bucketlist/DrpFilter'), filterNotContinue, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Bucketlist/TxtSearchPhoneNumber'), searchPhoneNumber)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Bucketlist/TxtSearchPhoneNumber'), 'value',
    searchPhoneNumber, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Bucketlist/BtnSearch'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Bucketlist/BtnDetail'))

