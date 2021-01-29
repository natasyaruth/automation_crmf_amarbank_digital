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

WebUI.verifyTextPresent('Nasabah Tidak Melanjutkan', false)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/Linkreferral'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkPhonenumber'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkEmail'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkKtp'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkDeliveryAddress'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDatareferral'))

WebUI.waitForElementVisible(findTestObject('Website/CRM/CSR_Management/Details/TxtReferral'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataPhonenumber'))

WebUI.waitForElementVisible(findTestObject('Website/CRM/CSR_Management/Details/TxtPhonenumber'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataEmail'))

WebUI.waitForElementVisible(findTestObject('Website/CRM/CSR_Management/Details/TxtEmail'), 5)

WebUI.verifyMatch(Email, Email, false)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataKtp'))

WebUI.waitForElementVisible(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNumber'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditreferral'))

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtReferral'), Referral)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSavereferral'))

WebUI.verifyTextPresent(SuccessSaveReferral, false)

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSavereferral'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditKtp'))

WebUI.waitForElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveKtp'), 5)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNumber'), KTPNumber)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNumber'), PhoneNumber, PhoneNumber, 
    5)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpName'), KTPName)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpName'), KTPName, KTPName, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpBirthPlace'), KTPBirthPlace)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpBirthPlace'), '', KTPBirthPlace, 
    3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpBloodType'), KTPBloodType, false)

WebUI.waitForElementVisible(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpBloodType'), 5)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpAddress'), KTPAddress)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpAddress'), KTPAddress, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNeighbourhood'), KTPNeighbourhood)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNeighbourhood'), Neighbourhood, 
    3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpHamlet'), KTPHamlet)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpHamlet'), KTPHamlet, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpVillage'), KTPVillage)

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/ListVillageResult1'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/ListVillageResult1'))

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpVillage'), KTPVillage, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpReligion'), KTPReligion, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpReligion'), KTPReligion, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpMaritalStatus'), KTPMaritalStatus, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpMaritalStatus'), KTPMaritalStatus, 
    3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpOccupation'), KTPOccupation, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpOccupation'), KTPOccupation, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpCitizenship'), KTPCitizenship)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpCitizenship'), KTPCitizenship, 
    3, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/RbLifetime'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveKtp'))

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveKtp'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataDeliveryAddress'))

WebUI.waitForElementVisible(findTestObject('Website/CRM/CSR_Management/Details/BtnEditDeliveryAddress'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditDeliveryAddress'))

WebUI.waitForElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveDeliveryAddress'), 5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpAddressType'), AddressType, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpAddressType'), AddressType, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtFullAddress'), FullAddress, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtNeighbourhood'), Neighbourhood, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtNeighbourhood'), Neighbourhood, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtHamlet'), Hamlet, FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpProvince'), Province, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpProvince'), Province, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpDistrict'), District, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpDistrict'), District, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpSubdistrict'), Subdistrict, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpSubdistrict'), Subdistrict, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpVillage'), Village, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpVillage'), Village, 3)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveDeliveryAddress'))

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveDeliveryAddress'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataPersonalData'))

WebUI.waitForElementVisible(findTestObject('Website/CRM/CSR_Management/Details/BtnEditPersonalData'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditPersonalData'))

WebUI.waitForElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSavePersonalData'), 5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpEducation'), Education, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpEducation'), Education, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtMotherName'), MotherName)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtMotherName'), MotherName, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtRefPhonenumber'), ReferencePhoneNumber)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtRefPhonenumber'), ReferencePhoneNumber, 
    5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpReligion'), Religion, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpReligion'), Religion, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtRefName'), ReferenceName)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtRefName'), ReferenceName, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpAccountPurpose'), AccountPurpose, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpAccountPurpose'), AccountPurpose, 
    3)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSavePersonalData'))

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSavePersonalData'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataEmploymentData'))

WebUI.waitForElementVisible(findTestObject('Website/CRM/CSR_Management/Details/BtnEditEmploymentData'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditEmploymentData'))

WebUI.waitForElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveEmploymentData'), 5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpSourceIncome'), SourceIncome, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpSourceIncome'), SourceIncome, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpWorkType'), WorkType, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpWorkType'), WorkType, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpCompanyField'), CompanyField, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpCompanyField'), CompanyField, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpMonthlyIncome'), MonthlyIncome, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpMonthlyIncome'), MonthlyIncome, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpPosition'), JobPosition, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpPosition'), JobPosition, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtCompanyName'), CompanyName)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtCompanyName'), CompanyName, 3)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveEmploymentData'))

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveEmploymentData'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataSelfieAndKtpImages'))

WebUI.waitForElementVisible(findTestObject('Website/CRM/CSR_Management/Details/BtnSendLinkUploadPhotos'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSendLinkUploadPhotos'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnBack'))

