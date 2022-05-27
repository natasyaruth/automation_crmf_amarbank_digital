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

/* We want verify element field start date*/
WebUI.verifyElementPresent(fieldDateFromElement, 5)

/* We want input start date example date "11/05/2022"*/
WebUI.setText(fieldDateFromElement, inputStartEndNotFindDateText)

/* We want verify element field end date*/
WebUI.verifyElementPresent(fieldDateEndElement, 5)

/* We want input end date example date "19/05/2022"*/
WebUI.setText(fieldDateEndElement, inputStartEndNotFindDateText)

/* We want verify button "Tampilkan" */
WebUI.verifyElementPresent(btnShowFilterElement, 5)

/* We want to screen capture the page*/
WebUI.takeScreenshot()

/* We want click button "Tampilkan"*/
WebUI.click(btnShowFilterElement)

/* We want to verify the notification dont have the data*/
WebUI.verifyElementPresent(overFlowNotificationElement, 5)

/* We want to check element and text oops */
WebUI.verifyElementText(oopsNotificationElement, oopsNotificationText)

/* We want capture the result*/
WebUI.takeScreenshot()