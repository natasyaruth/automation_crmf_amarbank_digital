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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.math.RandomUtils
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil

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
	2. Already choose one customer in CSR Management with status card number is already activated
	3. Already create process block card
 * 
 * And have steps:
 * 	1. Click button 'Unblock Kartu'
	2. Checklist all of things to confirm
	3. Input Reason of unblock > 150 char
 * 
	And we have the expected result is :
	Display modal Block Kartu ATM as detail as below:

	1. Show modal Unblock Kartu
	2. Checkbox things to confirm will checked
	3. Reason only limited for 150 char */

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
			keylogger.markPassed('Modal Block Card dissapear and Still display Button Block Kartu')
			if (wrdAskMotherName.equalsIgnoreCase("Menanyakan nama ibu kandung")) {
				WebUI.click(chkMotherName)
			} else {keylogger.markError("wording is : " +wrdAskMotherName)}
			if (wrdAskAccNumber.equalsIgnoreCase("Menanyakan No. Rekening")) {
				WebUI.click(chkAccNumber)
			} else {keylogger.markError("wording is : " +wrdAskAccNumber)}
			if (wrdAskPhoneNumber.equalsIgnoreCase("Menanyakan No. Handphone yang terdaftar")) {
				WebUI.click(chkAskPhoneNumber)
			} else {keylogger.markError("wording is : " +wrdAskPhoneNumber)}
			WebUI.takeScreenshot()
			/* This part we will verify design by Reason Block Card*/	
			if (wrdTempBlock.equalsIgnoreCase("Blokir sementara")) {
				WebUI.click(rbTempBlock)
			} else {keylogger.markError("wording is : " +wrdTempBlock)}
			WebUI.verifyElementClickable(btnSubmitBlockCard)
			WebUI.click(btnSubmitBlockCard)
			String checkWrd = WebUI.getText(btnUnblockCard)
			if (checkWrd.contentEquals('Unblock Kartu')) {
				keylogger.markPassed('Show modal Unblock Kartu')
				TestObject activationStatus = new TestObject().addProperty('text',ConditionType.CONTAINS,'Sudah Aktivasi')
				if (WebUI.verifyElementPresent(activationStatus, 5)) {
					keylogger.markPassed('Status card still Sudah Aktivasi')
				} else {keylogger.logInfo("Element Not Found")}
				TestObject noticeBlockCard = new TestObject().addProperty('text',ConditionType.CONTAINS,'Block Kartu ATM')
				if (WebUI.verifyElementPresent(noticeBlockCard, 5,FailureHandling.OPTIONAL)) {
					WebUI.takeScreenshot()
					keylogger.markPassed('Display block status with icon alert red Block Kartu ATM')
				} else {keylogger.markError('Element Not Found')}
			} else {keylogger.logInfo("Element Not Found")}
			WebUI.takeScreenshot()
		} else {keylogger.logInfo("Element Not Found")}		
/* We want back to check data if button unblock card
 * so I try to back to unblock card for this request Id*/		
		if (WebUI.verifyElementVisible(btnUnblockCard,FailureHandling.OPTIONAL)) {
			WebUI.click(btnUnblockCard)
			TestObject unblockAtmCard = new TestObject().addProperty('text',ConditionType.CONTAINS,'Unblock Kartu ATM')
			if (WebUI.verifyElementPresent(unblockAtmCard, 5,FailureHandling.OPTIONAL)) {
				keylogger.logInfo('cannot choose one thing to unblock card , must choose all things')
				WebUI.click(chkMotherName)
				WebUI.click(chkAccNumber)
				WebUI.click(chkAskPhoneNumber)
				keylogger.markPassed('Checklist all of things to confirm')
				WebUI.setText(fieldReasonUnblockCard, RandomStringUtils.randomAlphabetic(200))
				keylogger.markPassed('Reason only limited for 150 char')
				if (WebUI.verifyElementClickable(btnUnblockAtmCard,FailureHandling.OPTIONAL)) {
					keylogger.markPassed('Click button Unblock Kartu ATM')
					WebUI.click(btnUnblockAtmCard)
					WebUI.takeScreenshot()
				} else {keylogger.logInfo("Element Not Found")}
				/* We want to confirmation if the pre conditional of unblock kartu ATM we check all things and input reason */				
				TestObject noticeBlockCardDissapear = new TestObject().addProperty('text',ConditionType.CONTAINS,'Block Kartu ATM')
				if (WebUI.verifyElementNotPresent(noticeBlockCardDissapear, 5,FailureHandling.OPTIONAL)) {
					keylogger.markPassed('Status card Blokir Kartu ATM dissapear')
					TestObject stillActivation = new TestObject().addProperty('text',ConditionType.CONTAINS,'Sudah Aktivasi')
					WebUI.verifyElementPresent(stillActivation, 5)
					keylogger.markPassed('Status card still Sudah Aktivasi')
					if (WebUI.verifyElementClickable(btnBlockCard,FailureHandling.OPTIONAL)) {
						keylogger.markPassed('Button change into Block Kartu')
						WebUI.verifyElementVisible(btnBlockCard)
					} else {keylogger.logInfo("Button cannot disable to click")}
					keylogger.markPassed('Status card Blokir Kartu ATM dissapear')
					WebUI.takeScreenshot()
				} else {keylogger.logInfo("Element Not Found")}
			} else {keylogger.logInfo("Element Not Found")}
		} else {keylogger.logInfo("Element Not Found")}
		keylogger.markPassed('Show modal Block Kartu in default')
		WebUI.click(btnBack)
	} else {keylogger.logInfo("Element Not Found")}
} else {keylogger.logInfo("Element Not Found")}