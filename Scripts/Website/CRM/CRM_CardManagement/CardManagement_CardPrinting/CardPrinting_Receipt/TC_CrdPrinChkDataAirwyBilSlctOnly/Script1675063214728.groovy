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
import com.kms.katalon.core.webservice.keyword.builtin.ContainsStringKeyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
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
/* We want to set assertion based on Name of customer*/
String nameCustomer = WebUI.getText(firstNameElement)
/* We want record text first request Id*/
def firstReqIdReceipt = WebUI.getText(firstReqIdElement)
/* We want to wait for visible element first "name"*/
WebUI.waitForElementVisible(firstNameElement, 5)
/* We want to record text first name*/
def firstNameReceipt = WebUI.getText(firstNameElement)
/* We want to wait element first data from list data "Resi"*/
WebUI.waitForElementVisible(chkFirstDataResiElement, 5)
/* We want to click first data from list data "Resi"*/
WebUI.click(chkFirstDataResiElement)
/* We want to wait element from button print receipt*/
WebUI.waitForElementVisible(btnPrintReceiptElement, 5)
/* We want to click element from button print receipt*/
WebUI.click(btnPrintReceiptElement)
/* This is was hint of part we focus to download the object and then we try to check the document in PDF. so what we do:
 * 1. first we download fontbox.jar
 * 2. then we download pdfbox.jar
 * 3. after download put to this path : ...\Katalon_Studio_Engine_Windows_64-8.2.5\configuration\resources\lib
 * 4. and dont forget to input from menu project -> settings -> Library Management -> add the fontbox.jar & pdfbox.jar
 * 5. We can refer from this reference : https://forum.katalon.com/t/is-this-possible-to-use-katalon-to-download-a-file/46318/4
 * 6. We can refer from this link : https://www.youtube.com/watch?v=65qhuUWpUpM to load file from PDF and makesure the file data
   7. we try to load the file
   8. we take the text from pdf
   9. we identified indexof ("expect string in PDF")
   10. we set keylog for check if found and not found Download Path/airwaybill-1655625188878.pdf
   11. currently we cannot select by file name or extention because the file is dynamic
 * */
/* We want to wait for element visible "Informasi Proses"*/
WebUI.waitForElementVisible(alertTextInformationElement, 5)
/* We want to verify data processing*/
WebUI.verifyElementPresent(totalDataElement, 5)
/* We want to get text total data*/
def totalData = WebUI.getText(totalDataElement)
/* We want to verify success data processing*/
WebUI.verifyElementPresent(successDataElement, 5)
/* We want to get text success data*/
def successData = WebUI.getText(successDataElement)
/* We want to check match data*/
WebUI.verifyEqual(successData, totalData)
/* We want to check visible button close */
WebUI.waitForElementVisible(btnCloseAlert, 5)
/* We want to click button close notification*/
WebUI.click(btnCloseAlert)
/* We want to wait again first request Id Receipt*/
WebUI.waitForElementVisible(firstReqIdElement, 5)
/* We want to get first data after click button print*/
def firstReqIdAfterProcess = WebUI.getText(firstReqIdElement)
/* We want check data still in print receipt page*/
WebUI.verifyEqual(firstReqIdAfterProcess, firstReqIdReceipt)
/* We want to read from pdf airwaybill*/
KeywordUtil keylogger = new KeywordUtil()
File file = new File("Download Path/")
File[] listFile = file.listFiles()
for (File awb :listFile) {
	keylogger.logInfo(awb.getName())
	if (awb.getName().contains("airwaybill")) {
		PDDocument document = PDDocument.load(awb)
		PDFTextStripper pdfStripper = new PDFTextStripper()
		String text = pdfStripper.getText(document)
		int index = text.indexOf(nameCustomer)
		document.close()
		keylogger.logInfo("Text from pdf =" +text)
	} else {
		keylogger.logInfo("Document cannot found")
	}
}
File deleteFile = new File("Download Path/")
File[] deleteListFile = deleteFile.listFiles()
for (File delAwb :deleteListFile) {
	keylogger.logInfo(delAwb.getName())
	if (delAwb.getName().contains("airwaybill")) {
		delAwb.delete()
	}
}
/* We want refresh page*/
WebUI.refresh()
