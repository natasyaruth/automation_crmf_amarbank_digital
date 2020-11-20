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

WebUI.delay(3)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnNextPage'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnLastPage'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/BtnPreviousPage'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnFirstPage'))

WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), Cust_All, false)

WebUI.verifyTextPresent(Cust_All, false)

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), Cust_NasabahBaru, 
    false)

WebUI.verifyTextPresent(Cust_NasabahBaru, false)

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), Cust_NasabahSenyumku, 
    false)

WebUI.verifyTextPresent(Cust_NasabahSenyumku, false)

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), Cust_TunaikuLeadgen, 
    false)

WebUI.verifyTextPresent(Cust_TunaikuLeadgen, false)

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DrpCustomerType'), Cust_SenyumkuDeposito, 
    false)

WebUI.verifyTextPresent(Cust_SenyumkuDeposito, false)

WebUI.delay(2)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DtpStartFilterDate'), Filter_StartDate)

WebUI.delay(3)

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/DtpEndFilterDate'), Filter_EndDate)

WebUI.delay(3)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnShow'))

WebUI.setText(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/TxtSearchRequestID'), SearchKYCVideo)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/BtnSearch'))

