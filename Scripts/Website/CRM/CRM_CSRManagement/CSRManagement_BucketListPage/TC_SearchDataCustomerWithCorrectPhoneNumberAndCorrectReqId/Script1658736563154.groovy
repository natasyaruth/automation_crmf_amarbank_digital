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
boolean checkMenuCsr = WebUI.waitForElementVisible(menuCSRManagement, 5)
if (checkMenuCsr == true) {
	WebUI.click(menuCSRManagement)
} else {
	keyLogger.markFailed("Something happen with menu CSR Management")
}

/*'We want to check blocked notification and check for text blocked 
 * if alert confirmation pop up enable is true'*/
if (WebUI.waitForElementVisible(blockBylockedUserElement, 5, )) {
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
/*'We want to check the request ID and Phone Number with success condition'*/
boolean checkHeaderCsrManagement = WebUI.waitForElementVisible(headerCSRManagementElement, 5)
if (checkHeaderCsrManagement == true) {
	for (int i=0;i<checkListByOrder.size();i++) {
		/* We want to check all drop down menu Semua, Belum Aktivasi, Sudah Aktivasi, Block Kartu ATM, Permintaan Kartu Baru*/
		WebUI.verifyOptionsPresent(drpDwnChooseStatusCard, ["Semua","Belum Aktivasi","Sudah Aktivasi","Block Kartu ATM","Permintaan Kartu Baru"])
		WebUI.selectOptionByLabel(drpDwnChooseStatusCard, "Semua", false)
		WebUI.click(checkListByOrder.get(i))
		if (WebUI.waitForElementVisible(headerCustDataElement, 5)) {
			WebUI.waitForPageLoad(5)
			/*	'We verify we can access Customer Detail'*/
			TestObject txtAccountNumb = new TestObject().addProperty('text', ConditionType.CONTAINS , headerCustDataText)
			WebUI.verifyElementPresent(txtAccountNumb, 5)
			boolean txtRekening = WebUI.waitForElementVisible(txtAccountNumb, 5)
			if (txtRekening == true) {
				WebUI.delay(2)
				WebUI.waitForElementVisible(reqIdDetailNasabah, 5)
				requestIdText = WebUI.getText(reqIdDetailNasabah)
				firstRowCustNameText = WebUI.getText(custNameDetailNasabah)			
				/* We want go to phone number information in data CSR*/				
				boolean hoverPhoneNumber = WebUI.waitForElementVisible(btnDataPhoneNumber, 5)
				if (hoverPhoneNumber == true) {
					WebUI.click(btnDataPhoneNumber)
					phoneNumber = WebUI.getAttribute(fieldPhoneNumber, "value")
				} else {
					keyLogger.markFailed("We dont find Hover Data KTP")
				}
				phoneNumberText = phoneNumber
				WebUI.click(btnBackBucketList)
				boolean inBucketListPage = WebUI.waitForElementVisible(headerCSRManagementElement, 5)
				if (inBucketListPage == true) {
					WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
					boolean existFieldReqId = WebUI.waitForElementVisible(fieldReqId, 5)
					if (existFieldReqId == true) {
						WebUI.setText(fieldReqId, requestIdText)
						WebUI.setText(searchPhoneNumberText, phoneNumberText)
						WebUI.click(btnSearch)
						WebUI.verifyTextPresent(firstRowCustNameText, false)
						TestObject firstRowPhoneNumberText = new TestObject().addProperty('text' , ConditionType.CONTAINS , phoneNumberText )
						WebUI.verifyElementPresent(firstRowPhoneNumberText, 5)
						WebUI.takeScreenshot()
						WebUI.refresh()
					} else {
						keyLogger.markFailed("We not found field request ID")
					}
				} else {
					keyLogger.markFailed("We not back at bucket list page")
				}
								
			} else {
				keyLogger.markFailed("We cannot find the info about ")
			}
		} else {
			keyLogger.markFailed("We not find header customer detail")
		}
	}
} else {
	keyLogger.markFailed("We not find the element")
}
WebUI.refresh()