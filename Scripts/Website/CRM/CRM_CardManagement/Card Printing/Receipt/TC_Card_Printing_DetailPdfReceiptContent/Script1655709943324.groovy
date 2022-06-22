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
String nameCustomer = WebUI.getText(firstRowNameElement)
/* We want to choose multiple checklist data*/
for(int i=0;i<3;i++) {
	WebUI.waitForElementVisible(listDataPrint.get(i), 5)
	WebUI.click(listDataPrint.get(i))
	WebUI.verifyElementChecked(listDataPrint.get(i), 10)
}
/* We want to wait element from button print receipt*/
WebUI.waitForElementVisible(btnPrintReceiptElement, 5)
/* We want to click element from button print receipt*/
WebUI.click(btnPrintReceiptElement)
/* We want to wait for element visible "Informasi Proses"*/
WebUI.waitForElementVisible(alertTextInformationElement, 5)
/* We want to verify data processing*/
WebUI.verifyElementPresent(totalDataElement, 5)
/* We want to verify success data processing*/
WebUI.verifyElementPresent(successDataElement, 5)
/* We want to verify failed data processing*/
WebUI.verifyElementPresent(failedDataElement, 5)
/* We want to check visible button close */
WebUI.waitForElementVisible(btnCloseAlert, 5)
/* We want to verify button closed*/
WebUI.verifyElementPresent(btnCloseAlert, 5)
/* We want to capture*/
WebUI.takeScreenshot()
/* We want to click button close notification*/
WebUI.click(btnCloseAlert)
/* We want to makesure we are back to receipt page*/
WebUI.waitForElementVisible(menuCardPrintingElement, 5)
/* We want verify we are on print list receipt page*/
WebUI.verifyElementPresent(menuCardPrintingElement, 5)
/* We want verify print list by header text*/
WebUI.verifyElementText(headerCardPrintingPage, "Card Printing")
/* We want to verify we are in tab receipt*/
WebUI.verifyElementPresent(tabResiElement, 5)
/* We want capture it*/
WebUI.takeScreenshot()
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
		keylogger.loginfo("Document cannot found")
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
