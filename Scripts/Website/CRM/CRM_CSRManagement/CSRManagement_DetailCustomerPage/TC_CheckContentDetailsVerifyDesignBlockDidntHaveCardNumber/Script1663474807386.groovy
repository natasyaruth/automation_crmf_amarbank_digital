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

/* Declare Keyword Util*/
KeywordUtil keyLogger = new KeywordUtil()

/* We want handle block Request Id if any process*/
linkCsrManagement = WebUI.getText(menuCsrManagement)
if (linkCsrManagement.equalsIgnoreCase('CSR Management')) {
	WebUI.click(menuCsrManagement)
	if (WebUI.verifyElementVisible(popUpBlockNotif,FailureHandling.OPTIONAL)) {
		WebUI.verifyElementText(wrdBlockNotif, "Konfirmasi")
		WebUI.click(btnCancelBlockNotif)
		WebUI.verifyElementVisible(txtheaderCsrManagement)
	} else {keyLogger.logInfo('We can continue the process')
		WebUI.verifyElementVisible(txtheaderCsrManagement)
	}
} else {keyLogger.markError("We not find text CSR Management")}

/* We want to verify design block with condition didn't have card number
 * 	With Steps : 
 * 1. Click CSR Management
 * 2. Click detail of customer*/

/* We have expected result is
 * 	1. There is no Green button 'Block Kartu' and 'Re-Assign Kartu'
	2. Field No. Kartu is disabled and the value is blank*/

if (WebUI.verifyElementVisible(fieldReqId,FailureHandling.OPTIONAL)) {
	WebUI.setText(fieldReqId, requestId)
	WebUI.click(btnSearch)
} else {keyLogger.markError('We Don Find the Field Request Id')}
if (WebUI.verifyElementVisible(btnDetailFirstRow,FailureHandling.OPTIONAL)) {
	WebUI.click(btnDetailFirstRow)
	TestObject custDetailPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'Detil Nasabah')
	if (WebUI.verifyElementPresent(custDetailPage, 5)) {
		keyLogger.markPassed('We are passed')
	} else {keyLogger.markError('We are not in customer page')}
} else {keyLogger.markError('We dont see the Result')}
if (WebUI.verifyElementVisible(btnDataAccountInfo,FailureHandling.OPTIONAL)) {
	WebUI.click(btnDataAccountInfo)
	WebUI.verifyTextNotPresent('Block Kartu', false)
	WebUI.verifyTextNotPresent('Re-Assign Kartu', false)
	keyLogger.markPassed('There is no Green button Block Kartu and Re-Assign Kartu')
	if (WebUI.verifyElementNotClickable(fieldCardNumber,FailureHandling.OPTIONAL)) {
		valueCardNumber = WebUI.getText(fieldCardNumber)
		WebUI.verifyEqual(valueCardNumber, '')
	} else {keyLogger.markError('Field Card it must not click able')}
} else {keyLogger.markError('Button data it should available')}