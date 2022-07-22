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

/* We will click button next page*/
WebUI.click(btnNextPage)

/* We will wait next page*/
WebUI.waitForElementPresent(txtNextPage, 10)

/* We will verify actual next page with expected next page*/
WebUI.verifyElementText(txtNextPage, expectedNextPage)

/* We will click button previous page*/
WebUI.click(btnPreviousPage)

/* We will wait previous page*/
WebUI.waitForElementPresent(txtPreviousPage, 10)

/* We will verify actual previous page with expected previous page*/
WebUI.verifyElementText(txtPreviousPage, expectedPreviousPage)

/* We will click button last page*/
WebUI.click(btnLastPage)

/* We will wait last page*/
WebUI.waitForElementPresent(txtLastPage, 10)

/* Store number of actual last page */
actualLastPage = WebUI.getText(txtLastPage)

/* Store number of expected last page */
expectedLastPage = WebUI.getText(txtNextPage)

/* Verify if the actual last page is same with expected last page */
WebUI.verifyEqual(actualLastPage, expectedLastPage)

/* We will click button first page*/
WebUI.click(btnFirstPage)

/* Store number of actual first page */
WebUI.waitForElementPresent(txtPreviousPage, 10)

/* Verify if the actual first page is same with expected first page */
WebUI.verifyElementText(txtPreviousPage, expectedPreviousPage)