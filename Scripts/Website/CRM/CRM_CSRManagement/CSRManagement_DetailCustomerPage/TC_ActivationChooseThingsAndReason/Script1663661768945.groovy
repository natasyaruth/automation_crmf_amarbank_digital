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
if (WebUI.verifyElementVisible(menuCsrManagement,FailureHandling.OPTIONAL)) {
	WebUI.click(menuCsrManagement)
	if (WebUI.verifyElementVisible(notifBlockCsr,FailureHandling.OPTIONAL)) {
		WebUI.click(btnCancelBlock)
		keylogger.logInfo("We cancel the block")
		WebUI.verifyElementVisible(txtHeaderCsrManagement)
	} else {
		keylogger.logInfo("We cannot get block")
		WebUI.verifyElementVisible(txtHeaderCsrManagement)
	}
} else {keylogger.markError("We don't see Csr Management Menu")}

/* We want Verify design modal block card with condition already have card number
 * Precondition:
 * 	1. Already Login
	2. Customer already have card number
	3. Already choose one customer in CSR Management with customer is already have card number and already activated
	4. Customer with status is 'Selesai'
 * 
 * And have steps:
 * 	1. Click button 'Block Kartu'
	2. Checklist things to confirm
	3. Choose reason block
	4. Uncheck things to confirm
	
	And we have the expected result is :
	Display modal Block Kartu ATM as detail as below:

	1. Show modal Block Kartu
	2. Checkbox things to confirm will checked
	3. Radio button of reason block will choosed and Button 'Block Kartu ATM' and 'Batal' will enabled
	4. Button 'Block Kartu ATM' will disabled and 'Batal' still enabled

/* We want choose request ID with condition is Nasabah Senyumku*/
if (WebUI.verifyElementVisible(drpCustType,FailureHandling.OPTIONAL)) {
	WebUI.verifyOptionsPresent(drpCustType, listDrpCustType)
	WebUI.selectOptionByLabel(drpCustType, "Nasabah Senyumku", false)
	if (WebUI.verifyElementVisible(drpCardStatus,FailureHandling.OPTIONAL)) {
		WebUI.verifyOptionsPresent(drpCardStatus, listDrpCardStatus)
		WebUI.selectOptionByLabel(drpCardStatus, "Sudah Aktivasi", false)
	} else {keylogger.logInfo("Element Not Found")}
		WebUI.navigateToUrl(requestIdBlockCard)
	TestObject csrDetaiPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
	if (WebUI.verifyElementPresent(csrDetaiPage, 5,FailureHandling.OPTIONAL)) {
		WebUI.click(linkDataAccountInfo)
		if (WebUI.verifyElementClickable(btnBlockCard,FailureHandling.OPTIONAL)) {
			keylogger.markPassed('Click button Block Kartu')
			WebUI.click(btnBlockCard)
		} else {keylogger.logInfo("Element Not Click Able")}
		TestObject pageBlockCardInfo = new TestObject().addProperty('text',ConditionType.CONTAINS,'Block Kartu ATM')
		if (WebUI.verifyElementPresent(pageBlockCardInfo, 5, FailureHandling.OPTIONAL)) {
			wrdAskMotherName = WebUI.getText(txtMotherName)
			wrdAskAccNumber = WebUI.getText(txtAccountNumber)
			wrdAskPhoneNumber = WebUI.getText(txtPhoneNumber)
			wrdTempBlock = WebUI.getText(txtTempBlock)
			wrdStolenCard = WebUI.getText(txtStolenCard)
			wrdLostCard = WebUI.getText(txtLostCard)
			wrdCloseCard = WebUI.getText(txtCloseCard)
			/* This part I will verify design by asking the question*/
			keylogger.markPassed('Show modal Block Kartu')
			if (wrdAskMotherName.equalsIgnoreCase("Menanyakan nama ibu kandung")) {
				keylogger.markPassed("Correct the wording is : " +wrdAskMotherName)
				keylogger.markPassed('Checkbox things to confirm will checked')
				WebUI.click(chkMotherName)
			} else {keylogger.markError("wording is : " +wrdAskMotherName)}
			if (wrdAskAccNumber.equalsIgnoreCase("Menanyakan No. Rekening")) {
				keylogger.markPassed("Correct the wording is : " +wrdAskAccNumber)
				keylogger.markPassed('Checkbox things to confirm will checked')
				WebUI.click(chkAccNumber)
			} else {keylogger.markError("wording is : " +wrdAskAccNumber)}
			if (wrdAskPhoneNumber.equalsIgnoreCase("Menanyakan No. Handphone yang terdaftar")) {
				keylogger.markPassed("Correct the wording is : " +wrdAskPhoneNumber)
				keylogger.markPassed('Checkbox things to confirm will checked')
				WebUI.click(chkAskPhoneNumber)
			} else {keylogger.markError("wording is : " +wrdAskPhoneNumber)}
			WebUI.takeScreenshot()
			/* This part we will verify design by Reason Block Card*/	
			if (wrdTempBlock.equalsIgnoreCase("Blokir sementara")) {
				keylogger.markPassed("Correct the wording is : " +wrdTempBlock)
				keylogger.markPassed('Choose one of reason block')
				WebUI.click(rbTempBlock)
			} else {keylogger.markError("wording is : " +wrdTempBlock)}
			if (wrdStolenCard.equalsIgnoreCase("Kartu dicuri")) {
				keylogger.markPassed("Correct the wording is : " +wrdStolenCard)
				WebUI.click(rbTempBlock)
			} else {keylogger.markError("wording is : " +wrdStolenCard)}
			if (wrdLostCard.equalsIgnoreCase("Kartu hilang")) {
				keylogger.markPassed("Correct the wording is : " +wrdLostCard)
			} else {keylogger.markError("wording is : " +wrdLostCard)}
			if (wrdCloseCard.equalsIgnoreCase("Tutup kartu")) {
				keylogger.markPassed("Correct the wording is : " +wrdCloseCard)
			} else {keylogger.markError("wording is : " +wrdCloseCard)}
			keylogger.markPassed('Radio button of reason block will choosed and Button Block Kartu ATM and Batal will enabled')
			WebUI.verifyElementClickable(btnSubmitBlockCard)
			WebUI.takeScreenshot()
			WebUI.click(chkAccNumber)
			if (WebUI.verifyElementNotClickable(btnSubmitBlockCard,FailureHandling.OPTIONAL)) {
				keylogger.markPassed('Button Block Kartu ATM will disabled and Batal still enabled')
			} else {keylogger.markError('Button Block Kartu ATM enable and Batal still enabled')}
		} else {keylogger.logInfo("Element Not Found")}
		if (WebUI.verifyElementClickable(btnBatalBlockCard,FailureHandling.OPTIONAL)) {
			WebUI.takeScreenshot()
			keylogger.markPassed('Button Block Kartu ATM disabled and Button Batal enabled')
			WebUI.click(btnBatalBlockCard)
		} else {keylogger.logInfo("Element Not Found")}	
		keylogger.markPassed('Show modal Block Kartu in default')
		WebUI.click(btnBack)
	} else {keylogger.logInfo("Element Not Found")}
} else {keylogger.logInfo("Element Not Found")}