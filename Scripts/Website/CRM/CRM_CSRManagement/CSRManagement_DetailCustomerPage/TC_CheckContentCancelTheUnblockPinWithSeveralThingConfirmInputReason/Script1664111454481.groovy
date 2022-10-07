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

/* We want Verify design modal PIN Block with condition PIN already Blocked
 * 
 * Precondition
 * 	1. Already Login
	2. The PIN transaction of customer is blocked
 * 
 * And have steps:
 * 	1. Click button 'Unblock PIN Transaksi'
	2. Checklist several things to confirm
	3. Input reason of block
	4. Click Batal
	5. Click button 'Unblock PIN Transaksi'
	
	And we have the expected result is :
	1. Show modal Unblock PIN Transaksi
	2. Modal Unblock PIN Transaksi dissapear and Still display Button 'Unblock PIN Transaksi'
	3. Show modal Unblock PIN Transaksi with default design
 * */

/* We want choose request ID with condition is Nasabah Senyumku*/
if (WebUI.verifyElementVisible(drpCustType,FailureHandling.OPTIONAL)) {
	WebUI.verifyOptionsPresent(drpCustType, listDrpCustType)
	WebUI.selectOptionByLabel(drpCustType, "Nasabah Senyumku", false)
	if (WebUI.verifyElementVisible(fieldTextName , FailureHandling.OPTIONAL)) {
		WebUI.setText(fieldTextName, wrdName)
		WebUI.click(searchButton)
	} else {keylogger.logInfo("Element Not Visible")}
	if (WebUI.verifyElementVisible(firstData,FailureHandling.OPTIONAL)) {
		WebUI.click(firstData)
	} else {keylogger.logInfo("Element Not Visible")}
	TestObject csrDetaiPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
	if (WebUI.verifyElementPresent(csrDetaiPage, 5,FailureHandling.OPTIONAL)) {
		WebUI.click(linkDataTransactionPin)
		if (WebUI.verifyElementClickable(btnUnblockPin,FailureHandling.OPTIONAL)) {
			WebUI.verifyElementVisible(btnUnblockPin)
			WebUI.click(btnUnblockPin)
			keylogger.logInfo('Click button "Unblock PIN Transaksi"')
			TestObject modalUnblockPin = new TestObject().addProperty('text',ConditionType.CONTAINS,'Unblock PIN transaksi')
			if (WebUI.verifyElementPresent(modalUnblockPin, 5,FailureHandling.OPTIONAL)) {
				keylogger.markPassed('Show modal Unblock PIN Transaksi')
				wrdMotherName = WebUI.getText(txtMotherName)
				WebUI.click(chkMotherName)
				WebUI.verifyMatch(wrdMotherName, 'Menanyakan nama ibu kandung', false)
				wrdAccountNumber = WebUI.getText(txtAccountNumber)
				WebUI.click(chkAccountNumber)
				WebUI.verifyMatch(wrdAccountNumber, 'Menanyakan No. Rekening', false)
				wrdPhoneNumber = WebUI.getText(txtPhoneNumber)
				WebUI.verifyMatch(wrdPhoneNumber, 'Menanyakan No. Handphone yang terdaftar', false)
				keylogger.markPassed('Checklist several things to confirm')
				WebUI.setText(fieldInputReasonUnblockPin, RandomStringUtils.randomAlphabetic(50))
				TestObject textReasonPinBlock = new TestObject().addProperty('text',ConditionType.CONTAINS,'Alasan PIN terblokir')
				WebUI.verifyElementPresent(textReasonPinBlock, 5)
				WebUI.verifyElementNotClickable(btnUnblockPinTransaction)
				keylogger.markPassed('Button Blue Unblock PIN Transaksi with default is disabled')
				if (WebUI.verifyElementClickable(btnCancelUnblockPin,FailureHandling.OPTIONAL)) {
					WebUI.click(btnCancelUnblockPin)
					keylogger.markPassed('Button Batal with default is enabled')
					if (WebUI.verifyElementClickable(btnUnblockPin,FailureHandling.OPTIONAL)) {
						WebUI.click(btnUnblockPin)
						WebUI.verifyElementNotChecked(chkMotherName, 5)
						WebUI.verifyElementNotChecked(chkAccountNumber, 5)
						WebUI.click(btnCancelUnblockPin)
					} else {keylogger.logInfo("Element Not Click Able")}
					keylogger.markPassed('Modal Unblock PIN Transaksi dissapear and Still display Button Unblock PIN Transaksi')
				} else {keylogger.logInfo("Element Not Click Able")}
			} else {keylogger.markError('text Unblock PIN transaction not visible')}
		} else {keylogger.logInfo("Element Not Click Able")}
		TestObject wrdPinBlock = new TestObject().addProperty('text',ConditionType.CONTAINS,'PIN Transaksi Terblokir')
		if (WebUI.verifyElementPresent(wrdPinBlock, 5,FailureHandling.OPTIONAL)) {
			keylogger.markPassed('Text PIN Transaksi Terblokir is present')
			WebUI.takeScreenshot()
		} else {keylogger.markError('Text PIN Transaksi Terblokir not present')}
		WebUI.click(btnBack)
	} else {keylogger.logInfo("Element Not Found")}
} else {keylogger.logInfo("Element Not Found")}