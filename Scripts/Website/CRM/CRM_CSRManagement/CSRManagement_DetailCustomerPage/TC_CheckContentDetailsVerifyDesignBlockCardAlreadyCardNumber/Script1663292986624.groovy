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
import com.kms.katalon.core.testobject.TestObject

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

/*We want to check design block in customer detail with step
  	Click CSR Management
	Click detail of customer
	
	With expectation:
	In section Data Kartu ATM, show detail as below:

	Green button 'Block Kartu' (default enable)
	Card status (icon green check if 'Sudah Aktivasi' and icon red alert if 'Belum Aktivasi')*/

/* We want choose request ID with condition is Nasabah Senyumku*/
if (WebUI.verifyElementVisible(drpCustType,FailureHandling.OPTIONAL)) {
	WebUI.verifyOptionsPresent(drpCustType, listDrpCustType)
	WebUI.selectOptionByLabel(drpCustType, "Nasabah Senyumku", false)
	if (WebUI.verifyElementVisible(drpCardStatus,FailureHandling.OPTIONAL)) {
		WebUI.verifyOptionsPresent(drpCardStatus, listDrpCardStatus)
		WebUI.selectOptionByLabel(drpCardStatus, "Block Kartu ATM", false)
	} else {keylogger.logInfo("Element Not Found")}
	if (WebUI.verifyElementVisible(btnDetail,FailureHandling.OPTIONAL)) {
		WebUI.click(btnDetail)
	} else {keylogger.logInfo("Element Not Found")}
	TestObject csrDetaiPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
	if (WebUI.verifyElementPresent(csrDetaiPage, 5,FailureHandling.OPTIONAL)) {
		WebUI.click(linkDataAccountInfo)
		TestObject alreadyActivation = new TestObject().addProperty('text',ConditionType.CONTAINS,'Sudah Aktivasi')
		if (WebUI.verifyElementPresent(alreadyActivation, 5,FailureHandling.OPTIONAL)) {
			WebUI.verifyElementVisible(btnReqNewCard)
			btnReqColor = WebUI.getCSSValue(btnReqNewCard, 'color')
			println(btnReqColor)
			WebUI.verifyEqual(btnReqColor, 'rgba(240, 242, 242, 1)')
			WebUI.takeScreenshot()
			keylogger.markPassed("Green button 'Block Kartu' (default enable)")
		} else {keylogger.logInfo("Element Not Found")}
		TestObject blockAtmCard = new TestObject().addProperty('text',ConditionType.CONTAINS,'Block Kartu ATM')
		if (WebUI.verifyElementPresent(blockAtmCard, 5,FailureHandling.OPTIONAL)) {
			WebUI.verifyElementVisible(btnUnblockCard)
			btnCardUnblock = WebUI.getCSSValue(btnUnblockCard, 'color')
			println(btnCardUnblock)
			WebUI.verifyEqual(btnCardUnblock, 'rgba(240, 242, 242, 1)')
			WebUI.takeScreenshot()
			keylogger.markPassed("Card status (icon green check if 'Sudah Aktivasi' and icon red alert if 'Belum Aktivasi')")
		} else {keylogger.logInfo("Element Not Found")}
	} else {keylogger.logInfo("Element Not Found")}
} else {keylogger.logInfo("Element Not Found")}