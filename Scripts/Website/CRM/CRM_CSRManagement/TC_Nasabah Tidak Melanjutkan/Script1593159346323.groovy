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

WebUI.verifyTextPresent(customerNotContinue, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/Linkreferral'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkPhonenumber'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkEmail'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkKtp'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkDeliveryAddress'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDatareferral'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/TxtReferral'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataPhonenumber'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/TxtPhonenumber'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataEmail'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/TxtEmail'), 5, FailureHandling.CONTINUE_ON_FAILURE)

String actualEmail = WebUI.executeJavaScript('return document.querySelector("#TxtEmail").value;', null)

WebUI.verifyMatch(actualEmail, email, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataKtp'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNumber'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditreferral'))

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtReferral'), referral)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSavereferral'))

WebUI.verifyTextPresent(successSaveReferral, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSavereferral'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditKtp'))

WebUI.waitForElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveKtp'), 5)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNumber'), KTPNumber)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNumber'), "value", KTPNumber, 
    5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpName'), KTPName)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpName'), "value", KTPName, 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpBirthPlace'), KTPBirthPlace)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpBirthPlace'), "value", 
    KTPBirthPlace, 3, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpBloodType'), KTPBloodType, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpBloodType'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpAddress'), KTPAddress)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpAddress'), "value", KTPAddress, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNeighbourhood'), KTPNeighbourhood)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNeighbourhood'), "value", KTPNeighbourhood, 
    10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpHamlet'), KTPHamlet)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpHamlet'), "value", KTPHamlet, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpVillage'), KTPVillage)

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/ListVillageResult1'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/ListVillageResult1'))

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpVillage'), "value", KTPVillage, 3, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpReligion'), KTPReligion, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpReligion'), "value", (KTPReligion.toLowerCase()).capitalize(), 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpMaritalStatus'), KTPMaritalStatus, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpMaritalStatus'), "value", KTPMaritalStatus, 
    10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpOccupation'), KTPOccupation, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpOccupation'), "value", (KTPOccupation.toLowerCase()).capitalize(), 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpCitizenship'), KTPCitizenship)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpCitizenship'), "value", KTPCitizenship, 
    3, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/RbLifetime'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveKtp'))

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveKtp'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataDeliveryAddress'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/BtnEditDeliveryAddress'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditDeliveryAddress'))

WebUI.waitForElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveDeliveryAddress'), 5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpAddressType'), addressType, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpAddressType'), "value", addressType.toLowerCase(), 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtFullAddress'), fullAddress, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtNeighbourhood'), neighbourhood, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtNeighbourhood'), "value", neighbourhood, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtHamlet'), hamlet, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpProvince'), province, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpProvince'), "value", province, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpDistrict'), district, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpDistrict'), "value", district, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpSubdistrict'), subdistrict, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpSubdistrict'), "value", subdistrict, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpVillage'), village, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpVillage'), "value", village, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveDeliveryAddress'))

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveDeliveryAddress'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataPersonalData'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/BtnEditPersonalData'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditPersonalData'))

WebUI.waitForElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSavePersonalData'), 5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpEducation'), education, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpEducation'), "value", education, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtMotherName'), motherName)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtMotherName'), "value", motherName, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtRefPhonenumber'), referencePhoneNumber)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtRefPhonenumber'), "value", referencePhoneNumber, 
    10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpReligion'), religion, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpReligion'), "value", religion, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtRefName'), referenceName)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtRefName'), "value", referenceName, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpAccountPurpose'), accountPurpose, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpAccountPurpose'), "value", accountPurpose, 
    10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSavePersonalData'))

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSavePersonalData'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataEmploymentData'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/BtnEditEmploymentData'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditEmploymentData'))

WebUI.waitForElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveEmploymentData'), 5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpSourceIncome'), sourceIncome, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpSourceIncome'), "value", sourceIncome, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpWorkType'), workType, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpWorkType'), "value", workType, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpCompanyField'), companyField, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpCompanyField'), "value", companyField, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpMonthlyIncome'), monthlyIncome, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpMonthlyIncome'), "value", monthlyIncome, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpPosition'), jobPosition, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpPosition'), "value", jobPosition, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtCompanyName'), companyName)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtCompanyName'), "value", companyName, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveEmploymentData'))

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveEmploymentData'), 5)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataSelfieAndKtpImages'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/BtnSendLinkUploadPhotos'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSendLinkUploadPhotos'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnBack'))

