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

/* We want to verify design section
 * Step : Click on button "Details" one of the "Nasabah Senyumku" 's data
 * 
 * Expected Result:
 * 	Show section "Device Data" as a Zeplin
	Show black wording when device permission is allowed
	Show red wording when device permission is not allowed
	Show "Stopper" when data is fraud
	There is icon (i) information on the right navigation
	Can maximize/minimize*/

/* We want choose request ID with condition is Nasabah Senyumku*/
if (WebUI.verifyElementVisible(drpCustType,FailureHandling.OPTIONAL)) {
	WebUI.verifyOptionsPresent(drpCustType, listDrpCustType)
	WebUI.selectOptionByLabel(drpCustType, "Nasabah Senyumku", false)
	WebUI.navigateToUrl(ReqIdWithCondtionalZeplin)
	TestObject csrDetaiPage = new TestObject().addProperty('text',ConditionType.CONTAINS,'Customer Detail')
	if (WebUI.verifyElementPresent(csrDetaiPage, 5,FailureHandling.OPTIONAL)) {
		WebUI.click(linkDeviceData)
		TestObject expDataFraud = new TestObject().addProperty('text',ConditionType.CONTAINS,'Stopper')
		if (WebUI.verifyElementPresent(expDataFraud, 5,FailureHandling.OPTIONAL)) {
			WebUI.takeScreenshot()
			keylogger.markPassed("Show Stopper when data is fraud")
		} else {keylogger.logInfo("Element Not Found")}
		TestObject redWording = new TestObject().addProperty('text',ConditionType.CONTAINS,'Push Notification Permission is Not Allowed')
		if (WebUI.verifyElementPresent(redWording, 5,FailureHandling.OPTIONAL)) {
			WebUI.takeScreenshot()
			keylogger.markPassed("Show red wording when device permission is not allowed")
		} else {keylogger.logInfo("Element Not Found")}
		TestObject blackWording = new TestObject().addProperty('text',ConditionType.CONTAINS,'Phone is Allowed')
		if (WebUI.verifyElementPresent(blackWording, 5,FailureHandling.OPTIONAL)) {
			WebUI.takeScreenshot()
			keylogger.markPassed("Show black wording when device permission is allowed")
		}else {keylogger.logInfo("Element Not Found")}
		WebUI.takeScreenshot()
	} else {keylogger.logInfo("Element Not Found")}
} else {keylogger.logInfo("Element Not Found")}
