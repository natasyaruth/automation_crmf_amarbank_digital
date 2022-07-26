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

import groovy.transform.ConditionalInterrupt
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
		WebUI.waitForElementVisible(headerCSRManagementElement, 5)
		WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
	} else {
		keyLogger.markFailed("We don't find alert confirmation")
	}
	WebUI.waitForElementVisible(headerCSRManagementElement, 5)
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}else {
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}
/*'We want to check the request ID and KTP Customer with success condition'*/
boolean checkHeaderCsrManagement = WebUI.waitForElementVisible(headerCSRManagementElement, 5)
if (checkHeaderCsrManagement == true) {
	for (int i=0;i<listRequestId.size();i++) {
		/* We want to check all drop down menu Semua, Belum Aktivasi, Sudah Aktivasi, Block Kartu ATM, Permintaan Kartu Baru*/
		WebUI.verifyOptionsPresent(drpDwnChooseStatusCard, ["Semua","Belum Aktivasi","Sudah Aktivasi","Block Kartu ATM","Permintaan Kartu Baru"])
				boolean inBucketListPage = WebUI.waitForElementVisible(headerCSRManagementElement, 5)
				if (inBucketListPage == true) {
					WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
					boolean existFieldReqId = WebUI.verifyElementVisible(fieldReqId)
					if (existFieldReqId == true) {
						WebUI.setText(fieldReqId, listRequestId.get(i))
						WebUI.setText(fieldIdNumber, listKtpInvalid.get(i))
						WebUI.click(btnSearch)
						TestObject txtReqIdNotExist = new TestObject().addProperty('text', ConditionType.CONTAINS , "Oops, Hasil pencarian tidak ditemukan")
						boolean textInputTheRightReqId = WebUI.verifyElementPresent(txtReqIdNotExist, 5)
						if (textInputTheRightReqId == true) {
								TestObject txtRightReqId = new TestObject().addProperty('text' , ConditionType.CONTAINS, "Pastikan Anda telah memasukkan data yang dicari dengan benar.")
							} else {
								keyLogger.markFailed("We not found the text")
							}
						WebUI.takeScreenshot()
						WebUI.refresh()
					} else {
						keyLogger.markFailed("We not found field request ID")
					}
				} else {
					keyLogger.markFailed("We not back at bucket list page")
				}
	}
} else {
	keyLogger.markFailed("We not find the element")
}
WebUI.refresh()