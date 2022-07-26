import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.concurrent.locks.Condition

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.org.apache.bcel.internal.generic.RETURN

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.remote.server.handler.RefreshPage
import org.apache.commons.lang.RandomStringUtils

/*'Declaration keylog forloggin'*/
KeywordUtil keyLogger = new KeywordUtil()
/*'We want to makesure we can access CSR Management'*/
boolean checkMenuCsr = WebUI.verifyElementVisible(menuCSRManagement, FailureHandling.OPTIONAL)
if (checkMenuCsr == true) {
	WebUI.click(menuCSRManagement)
} else {
	keyLogger.markFailed("Something happen with menu CSR Management")
}
/*'We want to check blocked notification and check for text blocked 
 * if alert confirmation pop up enable is true'*/
if (WebUI.waitForElementVisible(blockBylockedUserElement, 5, FailureHandling.OPTIONAL)) {
	boolean checkAlertProcess = WebUI.verifyElementVisible(alertConfirmationPopUpElement)
	if (checkAlertProcess == true) {
		WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)
		WebUI.click(btnCancelPopUpElement)
	} else {
		keyLogger.markFailed("We don't find alert confirmation")
	}
	WebUI.waitForElementVisible(headerCSRManagementElement, 5)
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}else {
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}
/*'We want to check element visible filter card status , select that and
 *  then we want to capture account number before and after'*/
if (WebUI.verifyElementVisible(drpDwnChooseStatusCard ,FailureHandling.OPTIONAL)) {
	/* We want to check all drop down menu Semua, Belum Aktivasi, Sudah Aktivasi, Block Kartu ATM, Permintaan Kartu Baru*/
	WebUI.verifyOptionsPresent(drpDwnChooseStatusCard, ["Semua","Belum Aktivasi","Sudah Aktivasi","Block Kartu ATM","Permintaan Kartu Baru"])
	/*'We want to choose text "Block Kartu ATM"'*/	
	WebUI.selectOptionByLabel(drpDwnChooseStatusCard, "Permintaan Kartu Baru", false)
	if (WebUI.verifyElementVisible(firstRowRequestIdElement , FailureHandling.OPTIONAL)) {
		/* 'We want to inspect Customer Name & No rekening' */		
		noRek = WebUI.getText(firstRowNoRek)
		custName = WebUI.getText(firstRowCustName)
		WebUI.click(firstRowRequestIdElement)
	} else {
		keyLogger.markFailed("We dont find request ID with these condition")
	}
} else {
	keyLogger.markFailed("We dont find the filter")
}
noRekText = noRek
custNameText = custName
/*'We want to check "Data Kartu ATM"'*/
if (WebUI.verifyElementVisible(headerCustDataElement,FailureHandling.OPTIONAL)) {
	/*	'We verify we can access Customer Detail'*/
	TestObject txtAccountNumb = new TestObject().addProperty('text', ConditionType.CONTAINS , headerCustDataText)
	WebUI.verifyElementPresent(txtAccountNumb, 5)
	boolean txtRekening = WebUI.verifyElementVisible(txtAccountNumb)
	if (txtRekening == true) {
		WebUI.click(btnDataCardATM)
	} else {
		keyLogger.markFailed("We cannot find the info about ")
	}
}
/*'We want matching No Rekeing'*/
String accountNumber = WebUI.getAttribute(dataAccountNumber, "value")
WebUI.verifyEqual(accountNumber, noRekText)
/*'We want to matching Name'*/
String dataCustName = WebUI.getAttribute(dataCustName, "value")
WebUI.verifyEqual(dataCustName, custNameText)
/*'We want to check notification "Belum Aktivasi & Permintaan Kartu Baru"'*/
String textNotActivation = WebUI.getText(txtNotActivation)
String textReqNewCard = WebUI.getText(txtReqNewCard)
List notificationList = new ArrayList()
notificationList.add(textNotActivation)
notificationList.add(textReqNewCard)
if (notificationList.contains("Belum Aktivasi")) {
	keyLogger.markPassed("We found ")
	WebUI.takeScreenshot()
} else {
	keyLogger.markFailed("We Not Found ")
}
if (notificationList.contains("Permintaan Kartu Baru")) {
	keyLogger.markPassed("We found ")
	WebUI.takeScreenshot()
} else {
	keyLogger.markFailed("We Not Found ")
}
/*'We want to click button back'*/
WebUI.verifyElementVisible(btnBackBucketList)
WebUI.click(btnBackBucketList)
/* We want to check to filter with status "Belum Aktivasi and check it"*/
boolean checkDropDownStatus = WebUI.waitForElementVisible(drpDwnChooseStatusCard, 5)
if (checkDropDownStatus == true) {
	for (int i=0;i<checkListByOrder.size();i++) {
		WebUI.selectOptionByLabel(drpDwnChooseStatusCard, "Belum Aktivasi", false)
		WebUI.click(checkListByOrder.get(i))
		if (WebUI.verifyElementVisible(headerCustDataElement,FailureHandling.OPTIONAL)) {
			WebUI.waitForPageLoad(5)
			/*	'We verify we can access Customer Detail'*/
			TestObject txtAccountNumb = new TestObject().addProperty('text', ConditionType.CONTAINS , headerCustDataText)
			WebUI.verifyElementPresent(txtAccountNumb, 5)
			boolean txtRekening = WebUI.verifyElementVisible(txtAccountNumb)
			if (txtRekening == true) {
				WebUI.waitForElementVisible(reqIdDetailNasabah, 5)
				requestIdText = WebUI.getText(reqIdDetailNasabah)
				WebUI.click(btnDataCardATM)
				WebUI.waitForPageLoad(2)
				/*'We want to check notification "Belum Aktivasi"'*/
				TestObject textNotYetActivation = new TestObject().addProperty('text', ConditionType.CONTAINS , "Belum Aktivasi" )
				if (WebUI.verifyElementPresent(textNotYetActivation, 5)) {
					keyLogger.markPassed("We found it")
					WebUI.takeScreenshot()
				} else {
					keyLogger.markFailed("We Not Found ")
					println(requestIdText)
				}
			} else {
				keyLogger.markFailed("We cannot find the info about ")
			}
			/*'We want to click button back'*/
			WebUI.verifyElementVisible(btnBackBucketList)
			WebUI.click(btnBackBucketList)
		}
	}
} else {
	keyLogger.markFailed("We not find the element")
}
WebUI.refresh()