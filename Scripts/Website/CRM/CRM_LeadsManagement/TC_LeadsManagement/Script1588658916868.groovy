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

WebUI.click(findTestObject('Website/CRM/Leads_Management/LinkLeadsManagement'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Bucketlist/BtnNextPage'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Bucketlist/BtnPreviousPage'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Bucketlist/BtnLastPage'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Bucketlist/BtnFirstPage'))

WebUI.verifyTextPresent('Leads Management', false)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Bucketlist/BtnDetail'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnBack'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Bucketlist/BtnDetail'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnDataPhonenumber'))

WebUI.verifyTextPresent(PhoneNumber, false)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnDataEmail'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnDataKtp'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnEditKtp'))

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtKtpNumber'), KTPNumber)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtKtpName'), KTPName)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnCheckKtp'))

WebUI.delay(20)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnSaveKtp'))

WebUI.delay(20)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnDataDeliveryAddress'))

WebUI.delay(3)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnEditDeliveryAddress'))

WebUI.delay(3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/Leads_Management/Detail/DrpAddressType'), AddressType, false)

WebUI.delay(3)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtFullAddress'), FullAddress)

WebUI.delay(1)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtNeighbourhood'), Neighbourhood)

WebUI.delay(1)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtHamlet'), Hamlet)

WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/Leads_Management/Detail/DrpProvince'), Province, false)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/Leads_Management/Detail/DrpDistrict'), District, false)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/Leads_Management/Detail/DrpSubdistrict'), Subdistrict, false)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/Leads_Management/Detail/DrpVillage'), Village, false)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnSaveDeliveryAddress'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnDataPersonalData'))

WebUI.selectOptionByLabel(findTestObject('Website/CRM/Leads_Management/Detail/DrpEducation'), Education, false)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtMotherName'), MotherName)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtRefPhonenumber'), ReferencePhoneNumber)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/Leads_Management/Detail/DrpReligion'), Religion, false)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtRefName'), ReferenceName)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/Leads_Management/Detail/DrpAccountPurpose'), AccountPurpose, false)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnDataEmploymentData'))

WebUI.selectOptionByLabel(findTestObject('Website/CRM/Leads_Management/Detail/DrpSourceIncome'), SourceIncome, false)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/Leads_Management/Detail/DrpWorkType'), WorkType, false)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/Leads_Management/Detail/DrpCompanyField'), CompanyField, false)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/Leads_Management/Detail/DrpMonthlyIncome'), MonthlyIncome, false)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/Leads_Management/Detail/DrpPosition'), JobPosition, false)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtCompanyName'), CompanyName)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnDataSefieAndKtpImages'))

