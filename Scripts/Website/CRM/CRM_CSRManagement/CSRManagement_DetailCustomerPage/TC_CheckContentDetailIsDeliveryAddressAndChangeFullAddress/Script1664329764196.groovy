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


/*Declare keyword util*/
KeywordUtil keyLogger = new KeywordUtil()

WebUI.click(CSRManagementLink)

/*'We want to check blocked notification and check for text blocked
 * if alert confirmation pop up enable is true'*/
if (WebUI.waitForElementVisible(blockBylockedUserElement, 5, FailureHandling.OPTIONAL)) {
	boolean checkAlertProcess = WebUI.verifyElementVisible(alertConfirmationPopUpElement)

	if (checkAlertProcess == true) {
		WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)

		WebUI.click(btnCancelPopUpElement)

		WebUI.delay(2)

		WebUI.waitForElementVisible(headerCSRManagementElement, 5)

		WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
	} else {
		keyLogger.markFailed('We don\'t find alert confirmation')
	}
	
	WebUI.waitForElementVisible(headerCSRManagementElement, 5)

	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
} else {
	WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}


WebUI.setText(CSRManagementBucketListTxtRequestId, InputReqID)

WebUI.click(CSRManagementBucketListBtnSearch)

WebUI.click(CSRManagementBucketListBtnDetail)

WebUI.click(SectionTitleDeliveryAddress)

WebUI.click(BtnEditDeliveryAddress)

WebUI.takeScreenshot()

WebUI.setText(TxtFullAddress, '')

WebUI.setText(TxtFullAddress, 'A 1 !')

WebUI.click(BtnSaveDeliveryAddress)

WebUI.takeScreenshot()

WebUI.click(BtnBack)

