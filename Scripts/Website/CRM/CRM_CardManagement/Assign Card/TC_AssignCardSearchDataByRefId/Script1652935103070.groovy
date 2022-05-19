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
import org.openqa.selenium.Keys as Keys

/* We want to verify menu card management element*/
WebUI.verifyElementPresent(menuCardManagementElement, 5)

/* We want to click menu card management to exand sub menu*/
WebUI.click(menuCardManagementElement)

/* We want to verify menu assign card element*/
WebUI.verifyElementPresent(menuAssignCardElement, 5)

/* We want to click menu assign card element*/
WebUI.click(menuAssignCardElement)

/* We want to verify feature search ref ID by identify label */
WebUI.verifyElementText(labelRefIdElement, labelRefIdText)

/* We want verify field from ref ID */
WebUI.verifyElementPresent(fieldRefIdElement, 5)

/* We want to verify first ref ID*/
WebUI.verifyElementPresent(firstRefIdElement, 5)

/* We want to verify first name ID*/
WebUI.verifyElementPresent(firstNameIdElement, 5)

/* We want grab first attribute name from name ID*/
firstNameId = WebUI.getText(firstNameIdElement)

/* We want grab first attribute from ref ID*/
firstRefId = WebUI.getText(firstRefIdElement)

/* We want insert request ID in field ref ID*/
WebUI.setText(fieldRefIdElement, firstRefId)

/* We want verify button search in ref Id visible*/
WebUI.verifyElementVisible(btnSearchRefId)

/* We want click button search ref Id*/
WebUI.click(btnSearchRefId)

/* We want to verify the ref Id*/
WebUI.verifyElementText(firstRefIdElement, firstRefId)

/* We want to verify the name Id*/
WebUI.verifyElementText(firstNameIdElement, firstNameId)

/* We want capture the result*/
WebUI.takeScreenshot()