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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

KeywordUtil keyLogger = new KeywordUtil()
/* We want to makesure we can identify element assign card*/
if (WebUI.verifyElementVisible(menuAssignCardElement, FailureHandling.OPTIONAL)) {
	/* We want to click menu assign card element*/
	WebUI.click(menuAssignCardElement)
} else {
	/* We want to verify menu card management element*/
	WebUI.verifyElementPresent(menuCardManagementElement, 5)
	/* We want to click menu card management to exand sub menu*/
	WebUI.click(menuCardManagementElement)
	/* We want to verify menu assign card element*/
	WebUI.verifyElementPresent(menuAssignCardElement, 5)
	/* We want to click menu assign card element*/
	WebUI.click(menuAssignCardElement)
}

/* We want handling the execption in Assign Card if available when the process is locked*/
if (WebUI.verifyElementPresent(blockBylockedUserElement, 5, FailureHandling.OPTIONAL)) {
	WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)
	WebUI.verifyElementText(btnCancelPopUpElement, btnCancelPopUpText)
	WebUI.click(btnCancelPopUpElement)
	WebUI.verifyElementText(headerAssignCardElement, headerAssignCardText)
}else {
	WebUI.verifyElementText(headerAssignCardElement, headerAssignCardText)
}

/* We want added filter for new card only*/
if (WebUI.verifyElementVisible(filterCustOrigin,FailureHandling.OPTIONAL)) {
	WebUI.selectOptionByLabel(filterCustOrigin, custOrigin, false)
} else {keyLogger.markFailed("We cannot select Senyumku")}

/* We want to verify Request ID*/
WebUI.verifyElementPresent(requestIdElement, 5)

/* We want to click Request ID*/
WebUI.click(requestIdElement)

/* We want to verify element and text "Detail Nasabah"*/
boolean onDetailAssignCard = WebUI.verifyElementText(headerCustomerDetailElement, headerCustomerDetailText)

/* We want edit Village and check on CSR Management change logs*/
if (onDetailAssignCard == true) {
	requestId = WebUI.getText(txtRequestId)
	if (WebUI.verifyElementVisible(btnEditDeliveryCard, FailureHandling.OPTIONAL)) {
		WebUI.click(btnEditDeliveryCard)
		oldPostal = WebUI.getAttribute(oldPostalCode, "value")
		if (WebUI.verifyElementVisible(drpVillage,FailureHandling.OPTIONAL)) {
			int optionListLength = 3
			Random rand = new Random()
			String index = rand.nextInt(optionListLength + 1)
			boolean drpVillagePresent = WebUI.verifyElementPresent(drpVillage, 5)
			if (drpVillagePresent == true) {
				WebUI.verifyElementVisible(drpVillage)
				WebUI.selectOptionByIndex(drpVillage, index)
			} else {keyLogger.markError("Not present "+drpVillagePresent+" element")}
			newPostal = WebUI.getAttribute(newPostalCode, "value")
			if (WebUI.verifyNotMatch(newPostal, oldPostal, false, FailureHandling.OPTIONAL)) {
				keyLogger.logInfo("We are correct action")
				WebUI.takeScreenshot()
			} else {
				keyLogger.logInfo("We are incorrect action")
				WebUI.takeScreenshot()
			}
		} else {keyLogger.logInfo("We don't get button edit drop down placement sent card")}
		if (WebUI.verifyElementVisible(btnSaveDeliveryAddress,FailureHandling.OPTIONAL)) {
			WebUI.takeScreenshot()
			WebUI.click(btnSaveDeliveryAddress)
		} else {keyLogger.logInfo("We don't see the button save")}
	} else {keyLogger.markFailed("We don't get button edit delivery")}
} else {keyLogger.markFailed("We don't see the card number")}
assignCardRequestId = requestId

/* We want to verify button "kembali" to unblock the request*/
WebUI.verifyElementPresent(btnBackElement, 5)

/* We want to click button "kembali" to unblock the request*/
WebUI.click(btnBackElement)

/* We want capture new card*/
WebUI.takeScreenshot()

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

/* We want input request ID from assign card to process to customer page*/
if (WebUI.verifyElementVisible(fieldSearchReqId,FailureHandling.OPTIONAL)) {
	WebUI.setText(fieldSearchReqId, assignCardRequestId)
	if (WebUI.verifyElementVisible(btnSearchCsrManagement,FailureHandling.OPTIONAL)) {
		WebUI.click(btnSearchCsrManagement)
		if (WebUI.verifyElementVisible(btnDetailCsrManagement,FailureHandling.OPTIONAL)) {
			WebUI.click(btnDetailCsrManagement)
			if (WebUI.verifyElementVisible(headerTxtCustDetail,FailureHandling.OPTIONAL)) {
				WebUI.click(changeLogMenu)
				if (WebUI.verifyElementVisible(filterBySource,FailureHandling.OPTIONAL)) {
					WebUI.selectOptionByLabel(filterBySource, assignCard, false)
					if (WebUI.verifyElementVisible(firstRowActions,FailureHandling.OPTIONAL)) {
						WebUI.verifyElementText(firstRowActions, "-")
						String newData = WebUI.getText(newDataOnLog)
						String oldData = WebUI.getText(oldDataOnLog)
						if (WebUI.verifyNotMatch(newData, oldData, false, FailureHandling.OPTIONAL)) {
							keyLogger.logInfo("We are correct action")
							WebUI.takeScreenshot()
						} else {
							keyLogger.logInfo("We are incorrect action")
							WebUI.takeScreenshot()
						}
					}else {keyLogger.logInfo("We not found the element")}
				} else {keyLogger.logInfo("We not found the element")}
			} else {keyLogger.logInfo("We not found the element")}
		} else {keyLogger.logInfo("We not found the element")}
	} else {keyLogger.logInfo("We not found the element")}
} else {keyLogger.logInfo("We not found the element")}

/* We want to refresh for the next process*/
WebUI.refresh()