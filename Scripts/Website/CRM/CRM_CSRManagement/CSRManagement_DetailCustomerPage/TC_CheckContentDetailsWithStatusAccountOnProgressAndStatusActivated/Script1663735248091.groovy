import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.sql.Driver

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil

import org.openqa.selenium.mobile.NetworkConnection
import org.openqa.selenium.mobile.NetworkConnection.ConnectionType
import org.openqa.selenium.edge.EdgeDriver as edge

/*We Declare Keyword Util*/
KeywordUtil keylogger = new KeywordUtil()
/* We want handling block condition*/
if (WebUI.waitForElementVisible(menuCsrManagement, 5)) {
	WebUI.click(menuCsrManagement)
	if (WebUI.waitForElementVisible(notifBlockCsr, 5)) {
		WebUI.click(btnCancelBlock)
		keylogger.logInfo("We cancel the block")
		WebUI.waitForElementVisible(txtHeaderCsrManagement, 5)
	} else {
		keylogger.logInfo("We cannot get block")
		WebUI.waitForElementVisible(txtHeaderCsrManagement, 5)
	}
} else {keylogger.markError("We don't see Csr Management Menu")}

/* We want Verify design modal block card with condition already have card number
 * Precondition:
 * 	1. Already Login
	2. Customer already have card number
	3. Already choose one customer in CSR Management with customer is already have card number and already activated
	4. Customer with status is 'Dalam Proses'
 * 
 * And have steps:
 * 	1. Check section 'Data Kartu ATM'
	
	And we have the expected result is :
	Display modal Block Kartu ATM as detail as below:

	1. Button 'Block Kartu' and 'Re-Assign card' is disabled and status card still 'Sudah Aktivasi'

/* We want choose request ID with condition is Nasabah Senyumku*/
if (WebUI.waitForElementVisible(drpCustType, 5)) {
	WebUI.verifyOptionsPresent(drpCustType, listDrpCustType)
	WebUI.selectOptionByLabel(drpCustType, "Nasabah Senyumku", false)
	if (WebUI.waitForElementVisible(drpCardStatus, 5)) {
		WebUI.verifyOptionsPresent(drpCardStatus, listDrpCardStatus)
		WebUI.selectOptionByLabel(drpCardStatus, "Sudah Aktivasi", false)
		keylogger.logInfo('status is di blokir')
	} else {keylogger.logInfo("Element Not Found")}
		WebUI.navigateToUrl(requestIdInProgress)
		TestObject statusReqId = new TestObject().addProperty('text',ConditionType.CONTAINS,'Dalam Proses')
		if (WebUI.verifyElementPresent(statusReqId, 5)) {
			keylogger.markPassed('Customer with status is Dalam Proses')
		} else {keylogger.logInfo("Element Not Found")}
	TestObject csrDetaiPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
	if (WebUI.verifyElementPresent(csrDetaiPage, 5)) {
		WebUI.click(linkDataAccountInfo)
		keylogger.markPassed('Check section Data Kartu ATM')
		TestObject pageBlockCardInfo = new TestObject().addProperty('text',ConditionType.CONTAINS,'Sudah Aktivasi')
		if (WebUI.verifyElementPresent(pageBlockCardInfo, 5, FailureHandling.OPTIONAL)) {
			WebUI.verifyElementNotClickable(btnBlockCard)
			keylogger.markPassed('button is disable for button Block Kartu')
			WebUI.verifyElementNotClickable(btnReassignNewCard)
			WebUI.takeScreenshot()
		} else {keylogger.logInfo("Element Not Found")}	
		keylogger.markPassed('Button Block Kartu and Re-Assign card is disabled and status card still Sudah Aktivasi')
		WebUI.click(btnBack)
	} else {keylogger.logInfo("Element Not Found")}
} else {keylogger.logInfo("Element Not Found")}