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
import org.apache.commons.lang.RandomStringUtils

KeywordUtil keyLogger = new KeywordUtil()
/* We want to makesure we can identify element assign card*/
if (WebUI.waitForElementVisible(menuAssignCardElement, 5)) {
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
if (WebUI.verifyElementPresent(blockBylockedUserElement, 5)) {
	WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)
	WebUI.verifyElementText(btnCancelPopUpElement, btnCancelPopUpText)
	WebUI.click(btnCancelPopUpElement)
	WebUI.verifyElementText(headerAssignCardElement, headerAssignCardText)
}else {
	WebUI.verifyElementText(headerAssignCardElement, headerAssignCardText)
}

/* We want added filter for new card only*/
if (WebUI.waitForElementVisible(filterCustOrigin, 5)) {
	WebUI.selectOptionByLabel(filterCustOrigin, custOrigin, false)
} else {keyLogger.markFailed("We cannot select Senyumku")}

/* We want to verify Request ID*/
WebUI.verifyElementPresent(requestIdElement, 5)

/* We want to click Request ID*/
WebUI.click(requestIdElement)

/* We want to verify element and text "Detail Nasabah"*/
boolean onDetailAssignCard = WebUI.verifyElementText(headerCustomerDetailElement, headerCustomerDetailText)

/* We want verify data card number before edit pengiriman*/
if (onDetailAssignCard == true) {
	requestId = WebUI.getText(txtRequestId)
	if (WebUI.waitForElementVisible(btnEditDeliveryCard, 5)) {
		WebUI.click(btnEditDeliveryCard)
		if (WebUI.verifyElementVisible(drpDownPlacementSentCard)) {
			int optionListLength = 3
			Random rand = new Random()
			String index = rand.nextInt(optionListLength + 1)
			boolean drpPlacementCard = WebUI.verifyOptionsPresent(drpDownPlacementSentCard, ["Apartemen","Rumah","Kantor","Kos"])
			if (drpPlacementCard == true) {
				WebUI.waitForElementVisible(drpDownPlacementSentCard, 5)
				WebUI.selectOptionByIndex(drpDownPlacementSentCard, index)
			} else { keyLogger.logInfo("We don't find the element Address Delivery") }
			boolean fullAddress = WebUI.verifyElementPresent(fieldFullAddress, 5)
			if (fullAddress == true) {
				WebUI.waitForElementVisible(fieldFullAddress, 5)
				WebUI.setText(fieldFullAddress, "Text" +RandomStringUtils.randomAlphanumeric(200))
			} else { keyLogger.logInfo("We don't find the element Address Delivery") }
			boolean provinceData = WebUI.verifyElementPresent(drpProvince, 5)
			if (provinceData == true) {
				WebUI.verifyElementVisible(drpProvince)
				WebUI.selectOptionByIndex(drpProvince, index)
				boolean drpDistrictPresent = WebUI.verifyElementPresent(drpDistrict, 5)
				if (drpDistrictPresent == true) {
					WebUI.verifyElementVisible(drpDistrict)
					WebUI.selectOptionByIndex(drpDistrict, index)
					boolean drpSubDistrictPresent = WebUI.verifyElementPresent(drpSubDistrict, 5)
					if (drpSubDistrictPresent == true) {
						WebUI.verifyElementVisible(drpSubDistrict)
						WebUI.selectOptionByIndex(drpSubDistrict, index)
						boolean drpVillagePresent = WebUI.verifyElementPresent(drpVillage, 5)
						if (drpVillagePresent == true) {
							WebUI.verifyElementVisible(drpVillage)
							WebUI.selectOptionByIndex(drpVillage, index)
						} else {keyLogger.markError("Not present "+drpVillagePresent+" element")}
					} else {keyLogger.markError("Not present "+drpSubDistrictPresent+" element")}
				} else {keyLogger.markError ("Not present "+drpDistrictPresent+" element")}
			} else { keyLogger.logInfo("We don't find the element Address Delivery") }
		} else {keyLogger.logInfo("We don't get button edit drop down placement sent card")}
		if (WebUI.waitForElementVisible(btnSaveDeliveryAddress, 5)) {
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
boolean checkMenuCsr = WebUI.verifyElementVisible(menuCSRManagement)
if (checkMenuCsr == true) {
	SourceData = WebUI.getText(menuCSRManagement)
	WebUI.click(menuCSRManagement)
} else {
	keyLogger.markFailed("Something happen with menu CSR Management")
}
SourceMenuData = SourceData
println(SourceMenuData)
/*'We want to check blocked notification and check for text blocked 
 * if alert confirmation pop up enable is true'*/
if (WebUI.waitForElementVisible(blockBylockedUserElement, 5)) {
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
if (WebUI.waitForElementVisible(fieldSearchReqId, 5)) {
	WebUI.setText(fieldSearchReqId, assignCardRequestId)
	if (WebUI.waitForElementVisible(btnSearchCsrManagement, 5)) {
		WebUI.click(btnSearchCsrManagement)
		if (WebUI.waitForElementVisible(btnDetailCsrManagement,5)) {
			WebUI.click(btnDetailCsrManagement)
			if (WebUI.waitForElementVisible(headerTxtCustDetail,5)) {
				WebUI.click(changeLogMenu)
				String firstRow = WebUI.getText(txtFirstRowSource)
				println(firstRow)
				WebUI.verifyMatch(SourceMenuData, firstRow, false)
				if (WebUI.waitForElementVisible(filterBySource,5)) {
					WebUI.selectOptionByLabel(filterBySource, assignCard, false)
					if (WebUI.waitForElementVisible(firstRowActions,5)) {
						WebUI.verifyElementText(firstRowActions, "-")
						String newData = WebUI.getText(newDataOnLog)
						String oldData = WebUI.getText(oldDataOnLog)
						if (WebUI.verifyNotMatch(newData, oldData, false)) {
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