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
import com.kms.katalon.core.util.internal.KeywordLoader
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.keyword.builtin.ContainsStringKeyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.thoughtworks.selenium.webdriven.commands.GetText

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import com.kms.katalon.core.logging.KeywordLogger;
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select
import com.kms.katalon.core.webui.driver.DriverFactory

/* We want to makesure we can identify element assign card*/
if (WebUI.verifyElementVisible(menuCardPrintingElement, FailureHandling.OPTIONAL)) {
	/* We want to wait the element visible*/
	WebUI.waitForElementVisible(menuCardPrintingElement, 5)	
	/* We want to click menu assign card element*/
	WebUI.click(menuCardPrintingElement)
	/* We want to wait until text is present*/
	WebUI.waitForElementVisible(headerCardPrintingPage, 5)
	/* We want verify header page of card printing*/
	WebUI.verifyElementText(headerCardPrintingPage, "Card Printing")
} else {
	/* We want to wait for element is visible*/
	WebUI.waitForElementVisible(menuCardManagementElement, 5)	
	/* We want to verify menu card management element*/
	WebUI.verifyElementPresent(menuCardManagementElement, 5)
	/* We want to click menu card management to exand sub menu*/
	WebUI.click(menuCardManagementElement)
	/* We want to wait the element is visible*/
	WebUI.waitForElementVisible(menuCardPrintingElement, 5)	
	/* We want to verify menu assign card element*/
	WebUI.verifyElementPresent(menuCardPrintingElement, 5)
	/* We want to click menu assign card element*/
	WebUI.click(menuCardPrintingElement)
	/* We want to wait until text is present*/
	WebUI.waitForElementVisible(headerCardPrintingPage, 5)
	/* We want verify header page of card printing*/
	WebUI.verifyElementText(headerCardPrintingPage, "Card Printing")
}
/* We want to wait until tab "Resi" visible*/
WebUI.waitForElementVisible(tabResiElement, 5)
/* We want to verify element "Resi"*/
WebUI.waitForElementPresent(tabResiElement, 5)
/* We want to click the element "Resi"*/
WebUI.click(tabResiElement)
/* We want to wait for visible element first "request id"*/
WebUI.waitForElementVisible(firstReqIdElement, 5)
/* We want to wait for visible check box selected all */
WebUI.waitForElementVisible(chkBoxSelectAllPrintReceiptElement, 5)
/* We want to click the check box selected all*/
WebUI.click(chkBoxSelectAllPrintReceiptElement)
/* We want to wait button print list*/
WebUI.waitForElementVisible(btnPrintListReceiptElement, 5)
/* We want to click button print list*/
WebUI.click(btnPrintListReceiptElement)
/* We want to wait for visible total data element*/
WebUI.waitForElementVisible(totalDataElement, 10)
/* We want to verify data processing*/
WebUI.verifyElementPresent(totalDataElement, 5)
/* Setup keylogger*/
KeywordUtil keyLogger = new KeywordUtil()
/* We want to get total by result*/
def getTotalDataByResult = WebUI.getText(totalDataElement)
/* We want to check for total data was same with selected data*/
def listTotalData = WebUI.getText(listInfoOfTotalData)
/* We want to verify success data processing*/
WebUI.verifyElementPresent(successDataElement, 5)
/* We want to check success data must same with total data*/
def getTotalSuccessData = WebUI.getText(successDataElement)
/* We want to check the total data with success data*/
if (WebUI.verifyEqual(getTotalDataByResult, getTotalSuccessData, FailureHandling.OPTIONAL)) {
	keyLogger.logInfo("Total data Equal Success Data list of data =" +listTotalData)
} else {
	keyLogger.logInfo("Total data not Equal Success Data because the less data =" +listTotalData)
}
/* We want to verify failed data processing*/
WebUI.verifyElementPresent(failedDataElement, 5)
/* We want to check visible button close */
WebUI.waitForElementVisible(btnCloseAlert, 5)
/* We want to capture*/
WebUI.takeScreenshot()
/* We want to click button close notification*/
WebUI.click(btnCloseAlert)
/* We want refresh page*/
WebUI.refresh()
