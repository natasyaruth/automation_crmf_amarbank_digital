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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.verifyTextPresent(customerNotContinue, false, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/Linkreferral'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkPhonenumber'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkEmail'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkKtp'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkDeliveryAddress'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDatareferral'), FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/TxtReferral'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataPhonenumber'), FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/TxtPhonenumber'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataEmail'), FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/TxtEmail'), 5, FailureHandling.OPTIONAL)

String actualEmail = WebUI.executeJavaScript('return document.querySelector("#TxtEmail").value;', null)

WebUI.verifyMatch(actualEmail, email, false, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataKtp'), FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNumber'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditreferral'), FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtReferral'), referral, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSavereferral'), FailureHandling.OPTIONAL)

WebUI.verifyTextPresent(successSaveReferral, false, FailureHandling.OPTIONAL)

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSavereferral'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditKtp'), FailureHandling.OPTIONAL)

WebUI.waitForElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveKtp'), 5, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNumber'), KTPNumber, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNumber'), "value", KTPNumber, 
    5, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpName'), KTPName, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpName'), "value", KTPName, 5, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpBirthPlace'), KTPBirthPlace, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpBirthPlace'), "value", 
    KTPBirthPlace, 3, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpBloodType'), KTPBloodType, false, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpBloodType'), 5, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpAddress'), KTPAddress, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpAddress'), "value", KTPAddress, 10, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNeighbourhood'), KTPNeighbourhood, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpNeighbourhood'), "value", KTPNeighbourhood, 
    10, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpHamlet'), KTPHamlet, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpHamlet'), "value", KTPHamlet, 10, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpVillage'), KTPVillage, FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/ListVillageResult1'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/ListVillageResult1'), FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpVillage'), "value", KTPVillage, 3, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpReligion'), KTPReligion, false, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpReligion'), "value", (KTPReligion.toLowerCase()).capitalize(), 10, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpMaritalStatus'), KTPMaritalStatus, false, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpMaritalStatus'), "value", KTPMaritalStatus, 
    10, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpOccupation'), KTPOccupation, false, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpKtpOccupation'), "value", (KTPOccupation.toLowerCase()).capitalize(), 10, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpCitizenship'), KTPCitizenship, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtKtpCitizenship'), "value", KTPCitizenship, 
    3, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/RbLifetime'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveKtp'), FailureHandling.OPTIONAL)

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveKtp'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataDeliveryAddress'), FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/BtnEditDeliveryAddress'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditDeliveryAddress'), FailureHandling.OPTIONAL)

WebUI.waitForElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveDeliveryAddress'), 5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpAddressType'), addressType, false, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpAddressType'), "value", addressType.toLowerCase(), 10, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtFullAddress'), fullAddress, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtNeighbourhood'), neighbourhood, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtNeighbourhood'), "value", neighbourhood, 10, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtHamlet'), hamlet, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpProvince'), province, false, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpProvince'), "value", province, 10, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpDistrict'), district, false, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpDistrict'), "value", district, 10, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpSubdistrict'), subdistrict, false, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpSubdistrict'), "value", subdistrict, 10, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpVillage'), village, false, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpVillage'), "value", village, 10, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveDeliveryAddress'), FailureHandling.OPTIONAL)

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveDeliveryAddress'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataPersonalData'), FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/BtnEditPersonalData'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditPersonalData'), FailureHandling.OPTIONAL)

WebUI.waitForElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSavePersonalData'), 5, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpEducation'), education, false, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpEducation'), "value", education, 10, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtMotherName'), motherName, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtMotherName'), "value", motherName, 10, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtRefPhonenumber'), referencePhoneNumber, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtRefPhonenumber'), "value", referencePhoneNumber, 
    10, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpReligion'), religion, false, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpReligion'), "value", religion, 10, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtRefName'), referenceName, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtRefName'), "value", referenceName, 10, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpAccountPurpose'), accountPurpose, false, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpAccountPurpose'), "value", accountPurpose, 
    10, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSavePersonalData'), FailureHandling.OPTIONAL)

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSavePersonalData'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataEmploymentData'), FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/BtnEditEmploymentData'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditEmploymentData'), FailureHandling.OPTIONAL)

WebUI.waitForElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveEmploymentData'), 5, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpSourceIncome'), sourceIncome, false, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpSourceIncome'), "value", sourceIncome, 10, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpWorkType'), workType, false, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpWorkType'), "value", workType, 10, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpCompanyField'), companyField, false, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpCompanyField'), "value", companyField, 10, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpMonthlyIncome'), monthlyIncome, false, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpMonthlyIncome'), "value", monthlyIncome, 10, FailureHandling.OPTIONAL)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpPosition'), jobPosition, false, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/DrpPosition'), "value", jobPosition, 10, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtCompanyName'), companyName, FailureHandling.OPTIONAL)

WebUI.waitForElementAttributeValue(findTestObject('Website/CRM/CSR_Management/Details/TxtCompanyName'), "value", companyName, 10, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveEmploymentData'), FailureHandling.OPTIONAL)

WebUI.waitForElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSaveEmploymentData'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataSelfieAndKtpImages'), FailureHandling.OPTIONAL)

WebUI.waitForElementPresent(findTestObject('Website/CRM/CSR_Management/Details/BtnSendLinkUploadPhotos'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnSendLinkUploadPhotos'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnBack'), FailureHandling.OPTIONAL)

