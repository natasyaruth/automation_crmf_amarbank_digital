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

/* We will click tab 'Resi'*/
WebUI.click(tabAirwayBill, FailureHandling.OPTIONAL)

/* We will check availability of element dropdown 'Status Resi'*/
WebUI.verifyElementPresent(drpAirwayBillList, 10, FailureHandling.OPTIONAL)

/* We will check availability of element dropdown 'Data per Halaman'*/
WebUI.verifyElementPresent(drpDataInPageAirwayBill, 10, FailureHandling.OPTIONAL)

/* We will click checkbox from top row of the bucketlist receipt*/
WebUI.click(chkDataAirwayBill, FailureHandling.OPTIONAL)

/* We will check availability of element button 'Cetak Resi'*/
WebUI.verifyElementPresent(btnAirwayBillPrint, 10, FailureHandling.OPTIONAL)

/* We will unclick checkbox from top row of the bucketlist receipt*/
WebUI.click(chkDataAirwayBill, FailureHandling.OPTIONAL)