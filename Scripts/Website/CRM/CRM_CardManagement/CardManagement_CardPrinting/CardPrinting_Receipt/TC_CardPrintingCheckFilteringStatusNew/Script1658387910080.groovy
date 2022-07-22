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
/* We want to wait for visible element filter receipt status*/
WebUI.waitForElementVisible(drpDwnFilterStatusElement, 5)
/* We want to select filter drp down "new Receipt"*/
WebUI.selectOptionByLabel(drpDwnFilterStatusElement, "Baru", false)
/* We want to verify element visible*/
WebUI.waitForElementVisible(firstRowNewCardElement, 5)
/* We want to check data available or no*/
KeywordUtil keyWordUtil = new KeywordUtil()
for (int i = 0; i < 5; i++) {
if (true) {
	WebUI.verifyElementText(verifyTextNewCardElement, "Kartu Baru", FailureHandling.OPTIONAL)
	break;
	/* We want capture it for the right process*/
	WebUI.takeScreenshot()
} else if (true) {
	/* We want to verify button next page*/
	WebUI.verifyElementPresent(btnNextPageElement, 5 ,FailureHandling.OPTIONAL)
	/* We want to click button next page*/
	WebUI.click(btnNextPageElement)
	keyWordUtil.logInfo("We still not found we check in other pages")
} else {
	keyWordUtil.logInfo("We stop in this step because we not found the button next pages", FailureHandling.STOP_ON_FAILURE)
}}
/* We want to capture*/
WebUI.takeScreenshot()
/* We want refresh page*/
WebUI.refresh()
