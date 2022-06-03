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

/* We want to verify feature search request ID by identify label */
WebUI.verifyElementText(labelReqIdElement, labelReqIdText)

/* We want verify field from request ID */
WebUI.verifyElementPresent(fieldReqIdElement, 5)

/* We want insert request ID in field request ID*/
WebUI.setText(fieldReqIdElement, invalidReqIdText)

/* We want verify button search in request Id visible*/
WebUI.verifyElementVisible(btnSearchReqId)

/* We want click button search request Id*/
WebUI.click(btnSearchReqId)

/* We want to verify notification not find the request Id*/
WebUI.verifyElementPresent(overFlowNotificationNotFind, 5)

/* We want verify text "Oops, Hasil pencarian tidak ditemukan" */
WebUI.verifyElementText(oopsNotificationElement, oopsNotificationText)

/* We want capture the result*/
WebUI.takeScreenshot()

/* We want to click dashboard to process the assign card is clean because we have some issue in html element
 * when we try to clean text the ref or req id then we set for input ref ID then we gonna failed test*/
WebUI.verifyElementPresent(menuDashboard, 5)

/* We want to click menu dashboard*/
WebUI.click(menuDashboard)

/* We want to verify menu assign card element*/
WebUI.verifyElementPresent(menuAssignCardElement, 5)

/* We want to click menu assign card element*/
WebUI.click(menuAssignCardElement)

/* We want verify field from request ID */
WebUI.verifyElementPresent(fieldReqIdElement, 5)

/* We want insert ref ID in field request ID*/
WebUI.setText(fieldReqIdElement, invalidRefIdText)

/* We want verify button search in request Id visible*/
WebUI.verifyElementVisible(btnSearchReqId)

/* We want click button search request Id*/
WebUI.click(btnSearchReqId)

/* We want to verify notification not find the ref Id*/
WebUI.verifyElementPresent(overFlowNotificationNotFind, 5)

/* We want verify text "Oops, Hasil pencarian tidak ditemukan" */
WebUI.verifyElementText(oopsNotificationElement, oopsNotificationText)

/* We want capture the result*/
WebUI.takeScreenshot()