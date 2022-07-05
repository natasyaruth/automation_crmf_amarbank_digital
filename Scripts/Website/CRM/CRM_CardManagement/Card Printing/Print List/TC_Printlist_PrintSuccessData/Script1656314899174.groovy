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

/* We will click button 'Cetak Kartu' */
WebUI.click(btnCardPrint)

/* We will declarated variable */
newWindowTitle = WebUI.getWindowTitle()

if(newWindowTitle != windowCRMTitle) {
	WebUI.switchToWindowTitle(windowCRMTitle)
}

/* We will wait modal status of process data print appear */
WebUI.waitForElementPresent(mdlPrintList, 10)

/* We will wait status of data procced in the modal */
WebUI.waitForElementPresent(txtTotalProcessedDataPrintlist, 10)

/* We will declarated variable dataProcessed 
 * to save value total processed data on printlist */
dataProcessed = WebUI.getText(txtTotalProcessedDataPrintlist)

/* We will declarated variable dataSuccess
 * to save value total succeded data on printlist */
dataSuccess = WebUI.getText(txtTotalSuccessDataPrintlist)

/* Verify data success should be same with data proceed */
WebUI.verifyEqual(dataSuccess, dataProcessed)

/* We will click button 'Tutup' on modal status of process data print */
WebUI.click(btnCloseInformation)