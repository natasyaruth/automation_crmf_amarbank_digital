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

WebUI.verifyTextPresent('Cari berdasarkan Nama, No. KTP, No. Handphone atau No. Rekening. Tidak harus semua field search diisi', 
    false)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Bucketlist/DrpFilter'), Filter_All, false)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Bucketlist/DrpFilter'), Filter_NewCustomer, false)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Bucketlist/DrpFilter'), Filter_CustomerSenyumku, false)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Bucketlist/BtnLastPage'))

WebUI.waitForElementNotPresent(findTestObject('Website/CRM/CSR_Management/Bucketlist/BtnLastPage'), 10)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Bucketlist/BtnPreviousPage'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Bucketlist/BtnLastPage'), 10)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Bucketlist/BtnNextPage'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Bucketlist/BtnFirstPage'))

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Bucketlist/TxtSearchPhoneNumber'), SearchPhoneNumber)

WebUI.delay(3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Bucketlist/DrpFilter'), Filter_NotContinue, false)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Bucketlist/BtnSearch'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Bucketlist/BtnDetail'))

