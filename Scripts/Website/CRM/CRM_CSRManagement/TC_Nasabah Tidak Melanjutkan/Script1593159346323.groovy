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

WebUI.verifyTextPresent(customerNotContinue, false)

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

WebUI.verifyMatch(email, email, false)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataKtp'))

WebUI.waitForElementVisible(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNumber'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditreferral'))

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtReferral'), referral)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSavereferral'))

WebUI.verifyTextPresent(successSaveReferral, false)

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSavereferral'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditKtp'))

WebUI.waitForElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveKtp'), 5)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNumber'), KTPNumber)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNumber'), phoneNumber, phoneNumber, 
    5)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpName'), KTPName)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpName'), KTPName, KTPName, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpBirthPlace'), KTPBirthPlace)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpBirthPlace'), KTPBirthPlace, 
    KTPBirthPlace, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpBloodType'), KTPBloodType, false)

WebUI.waitForElementVisible(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpBloodType'), 5)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpAddress'), KTPAddress)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpAddress'), KTPAddress, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNeighbourhood'), KTPNeighbourhood)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNeighbourhood'), KTPNeighbourhood, 
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

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpAddressType'), addressType, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpAddressType'), addressType, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtFullAddress'), fullAddress, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtNeighbourhood'), neighbourhood, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtNeighbourhood'), neighbourhood, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtHamlet'), hamlet, FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpProvince'), province, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpProvince'), province, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpDistrict'), district, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpDistrict'), district, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpSubdistrict'), subdistrict, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpSubdistrict'), subdistrict, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpVillage'), village, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpVillage'), village, 3)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveDeliveryAddress'))

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveDeliveryAddress'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataPersonalData'))

WebUI.waitForElementVisible(findTestObject('Website/CRM/CSR_Management/Details/BtnEditPersonalData'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditPersonalData'))

WebUI.waitForElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSavePersonalData'), 5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpEducation'), education, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpEducation'), education, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtMotherName'), motherName)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtMotherName'), motherName, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtRefPhonenumber'), referencePhoneNumber)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtRefPhonenumber'), referencePhoneNumber, 
    5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpReligion'), religion, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpReligion'), religion, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtRefName'), referenceName)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtRefName'), referenceName, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpAccountPurpose'), accountPurpose, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpAccountPurpose'), accountPurpose, 
    3)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSavePersonalData'))

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSavePersonalData'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataEmploymentData'))

WebUI.waitForElementVisible(findTestObject('Website/CRM/CSR_Management/Details/BtnEditEmploymentData'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditEmploymentData'))

WebUI.waitForElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveEmploymentData'), 5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpSourceIncome'), sourceIncome, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpSourceIncome'), sourceIncome, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpWorkType'), workType, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpWorkType'), workType, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpCompanyField'), companyField, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpCompanyField'), companyField, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpMonthlyIncome'), monthlyIncome, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpMonthlyIncome'), monthlyIncome, 3)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpPosition'), jobPosition, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpPosition'), jobPosition, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtCompanyName'), companyName)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtCompanyName'), companyName, 3)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveEmploymentData'))

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveEmploymentData'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataSelfieAndKtpImages'))

WebUI.waitForElementVisible(findTestObject('Website/CRM/CSR_Management/Details/BtnSendLinkUploadPhotos'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSendLinkUploadPhotos'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnBack'))

