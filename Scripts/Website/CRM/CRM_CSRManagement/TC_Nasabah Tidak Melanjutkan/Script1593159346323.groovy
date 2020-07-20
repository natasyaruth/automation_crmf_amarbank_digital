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

WebUI.verifyTextPresent('Customer Detail', false)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkPhonenumber'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkEmail'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkKtp'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkDeliveryAddress'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataPhonenumber'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataEmail'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataKtp'))

WebUI.delay(2)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditKtp'))

WebUI.delay(2)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNumber'), KTPNumber)

WebUI.delay(1)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpName'), KTPName)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnCheckKtp'))

WebUI.delay(20)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveKtp'))

WebUI.delay(20)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataDeliveryAddress'))

WebUI.delay(5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditDeliveryAddress'))

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpAddressType'), AddressType, false)

WebUI.delay(2)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtFullAddress'), FullAddress, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtNeighbourhood'), Neighbourhood, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtHamlet'), Hamlet, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpProvince'), Province, false)

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpDistrict'), District, false)

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpSubdistrict'), Subdistrict, false)

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpVillage'), Village, false)

WebUI.delay(2)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveDeliveryAddress'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataPersonalData'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditPersonalData'))

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpEducation'), Education, false)

WebUI.delay(2)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtMotherName'), MotherName)

WebUI.delay(1)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtRefPhonenumber'), ReferencePhoneNumber)

WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpReligion'), Religion, false)

WebUI.delay(1)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtRefName'), ReferenceName)

WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpAccountPurpose'), AccountPurpose, false)

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSavePersonalData'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataEmploymentData'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditEmploymentData'))

WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpSourceIncome'), SourceIncome, false)

WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpWorkType'), WorkType, false)

WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpCompanyField'), CompanyField, false)

WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpMonthlyIncome'), MonthlyIncome, false)

WebUI.delay(1)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpPosition'), JobPosition, false)

WebUI.delay(1)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtCompanyName'), CompanyName)

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveEmploymentData'))

WebUI.delay(2)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataSelfieAndKtpImages'))

WebUI.delay(1)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSendLinkUploadPhotos'))

