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

/* We want to verify the menu card management*/
WebUI.verifyElementPresent(menuCardManagement, 5)

/* We want to click the menu card management*/
WebUI.click(menuCardManagement)

/* We want to verify the menu assign card*/
WebUI.verifyElementPresent(menuAssignCard, 5)

/* We want to click menu assign card*/
WebUI.click(menuAssignCard)

/* We want verify label element "Filter by customer origin"*/
WebUI.verifyElementPresent(labelFilterByCustomerOriginElement, 5)

/* We want to verify element & text filter by customer origin*/
WebUI.verifyElementText(labelFilterByCustomerOriginElement, labelFilterByCustomerOriginText)

/* We want to verify the field drop down filter by customer origin text*/
WebUI.verifyElementPresent(fieldFilterByCustomerElement, 5)

/* We want choose senyumku on drop down data*/
WebUI.selectOptionByLabel(fieldFilterByCustomerElement, senyumkuLabelText, false)

/* We want to check on bucket list filter has been success to choosen*/
WebUI.verifyElementPresent(senyumkuDataOnBucketList, 5)

/* We want to verify the element and text*/
WebUI.verifyElementText(senyumkuDataOnBucketList, senyumkuLabelText)

/* We want to capture the page senyumku data in bucket list*/
WebUI.takeScreenshot()

/* We want verify label element "Filter by customer origin"*/
WebUI.verifyElementPresent(labelFilterByCustomerOriginElement, 5)
//
/* We want to verify element & text filter by customer origin*/
WebUI.verifyElementText(labelFilterByCustomerOriginElement, labelFilterByCustomerOriginText)

/* We want to verify the field drop down filter by customer origin text*/
WebUI.verifyElementPresent(fieldFilterByCustomerElement, 5)

/* We want choose Tunaiku Disbursement on drop down data*/
WebUI.selectOptionByLabel(fieldFilterByCustomerElement, tunaikuDisbursementText, false)

/* We want to check on bucketlist filter already*/
WebUI.verifyElementPresent(tunaikuDisbursementDataBucketList, 5)

/* We want to verify the element and text*/
WebUI.verifyElementText(tunaikuDisbursementDataBucketList, tunaikuDisbursementText)

/* We want to capture the page tunaiku disbursement data in bucket list*/
WebUI.takeScreenshot()