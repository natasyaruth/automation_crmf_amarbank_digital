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
import internal.GlobalVariable as GlobalVariable
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
 * And have steps:
 * 	1. Click CSR Management
	2. Click detail of customer
	3. Go To Section Data Kartu ATM
	4. Click button "Block Kartu"
	
	And we have the expected result is :
	Display modal Block Kartu ATM as detail as below:

	Three checkbox of things to confirm that is: 'Menanyakan Nama Ibu Kandung', 'Menanyakan No. Rekening', and 'Menanyakan No. Handphone yang terdaftar'
	Label info of Ibu Kandung, No Rekening and No Handphone
	Four radio button of reason block card that is: 'Pembatalan Kartu', 'Kartu Hilang', 'Kartu Dicuri', 'Tutup Kartu'
	Button Blue 'Block Kartu ATM' with default is disabled
	Button 'Batal' with default is enabled
 * */

/* We want choose request ID with condition is Nasabah Senyumku*/
if (WebUI.verifyElementVisible(drpCustType,FailureHandling.OPTIONAL)) {
	WebUI.verifyOptionsPresent(drpCustType, listDrpCustType)
	WebUI.selectOptionByLabel(drpCustType, "Nasabah Senyumku", false)
	if (WebUI.verifyElementVisible(drpCardStatus,FailureHandling.OPTIONAL)) {
		WebUI.verifyOptionsPresent(drpCardStatus, listDrpCardStatus)
		WebUI.selectOptionByLabel(drpCardStatus, "Block Kartu ATM", false)
	} else {keylogger.logInfo("Element Not Found")}
		WebUI.navigateToUrl(requestIdBlockCard)
	TestObject csrDetaiPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
	if (WebUI.verifyElementPresent(csrDetaiPage, 5,FailureHandling.OPTIONAL)) {
		WebUI.click(linkDataAccountInfo)
		if (WebUI.verifyElementClickable(btnBlockCard,FailureHandling.OPTIONAL)) {
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
			if (wrdAskMotherName.equalsIgnoreCase("Menanyakan nama ibu kandung")) {
				keylogger.markPassed("Correct the wording is : " +wrdAskMotherName)
			} else {keylogger.markError("wording is : " +wrdAskMotherName)}
			if (wrdAskAccNumber.equalsIgnoreCase("Menanyakan No. Rekening")) {
				keylogger.markPassed("Correct the wording is : " +wrdAskAccNumber)
			} else {keylogger.markError("wording is : " +wrdAskAccNumber)}
			if (wrdAskPhoneNumber.equalsIgnoreCase("Menanyakan No. Handphone yang terdaftar")) {
				keylogger.markPassed("Correct the wording is : " +wrdAskPhoneNumber)
			} else {keylogger.markError("wording is : " +wrdAskPhoneNumber)}
			WebUI.takeScreenshot()
			/* This part we will verify design by Reason Block Card*/	
			if (wrdTempBlock.equalsIgnoreCase("Blokir sementara")) {
				keylogger.markPassed("Correct the wording is : " +wrdTempBlock)
			} else {keylogger.markError("wording is : " +wrdTempBlock)}
			if (wrdStolenCard.equalsIgnoreCase("Kartu dicuri")) {
				keylogger.markPassed("Correct the wording is : " +wrdStolenCard)
			} else {keylogger.markError("wording is : " +wrdStolenCard)}
			if (wrdLostCard.equalsIgnoreCase("Kartu hilang")) {
				keylogger.markPassed("Correct the wording is : " +wrdLostCard)
			} else {keylogger.markError("wording is : " +wrdLostCard)}
			if (wrdCloseCard.equalsIgnoreCase("Tutup kartu")) {
				keylogger.markPassed("Correct the wording is : " +wrdCloseCard)
			} else {keylogger.markError("wording is : " +wrdCloseCard)}
			WebUI.verifyElementNotClickable(btnSubmitBlockCard)
			WebUI.takeScreenshot()
			if (WebUI.verifyElementClickable(btnBatalBlockCard,FailureHandling.OPTIONAL)) {
				WebUI.click(btnBatalBlockCard)
				WebUI.click(btnBack)
			} else {keylogger.logInfo("Element Not Found")}
			
		} else {keylogger.logInfo("Element Not Found")}
		
	} else {keylogger.logInfo("Element Not Found")}
} else {keylogger.logInfo("Element Not Found")}