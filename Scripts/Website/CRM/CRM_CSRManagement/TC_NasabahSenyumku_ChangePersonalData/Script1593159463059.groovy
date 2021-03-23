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

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/LinkPersonalData'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnDataPersonalData'))

WebUI.click(findTestObject('Website/CRM/CSR_Management/Details/BtnEditPersonalData'))

WebUI.waitForElementClickable(findTestObject('Website/CRM/CSR_Management/Details/BtnSavePersonalData'), 5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpEducation'), education, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpEducation'), education, 3)

WebUI.verifyTextNotPresent(motherName, false)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtRefPhonenumber'), referencePhoneNumber)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtRefPhonenumber'), referencePhoneNumber, 
    5)

WebUI.selectOptionByLabel(findTestObject('Website/CRM/CSR_Management/Details/DrpReligion'), religion, false)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/DrpReligion'), religion, 3)

WebUI.setText(findTestObject('Website/CRM/CSR_Management/Details/TxtRefName'), referenceName)

WebUI.waitForElementHasAttribute(findTestObject('Website/CRM/CSR_Management/Details/TxtRefName'), referenceName, 3)

WebUI.verifyElementNotClickable(findTestObject('Website/CRM/CSR_Management/Details/DrpAccountPurpose'))

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

