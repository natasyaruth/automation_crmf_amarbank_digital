import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.github.kklisura.cdt.protocol.types.debugger.SearchMatch
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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

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
if (WebUI.verifyElementPresent(blockBylockedUserElement, 5,FailureHandling.OPTIONAL)) {
	WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)
	WebUI.verifyElementText(btnCancelPopUpElement, btnCancelPopUpText)
	WebUI.click(btnCancelPopUpElement)
}else {
	WebUI.verifyElementText(headerAssignCardElement, headerAssignCardText)
}

/* We want to verify the label "Filter by request new card"*/
WebUI.verifyElementPresent(labelFilterByRequestCard, 5)

/* We want to check element visibility dropdown */
WebUI.verifyElementPresent(cardTypeDropDown, 5)

/* We want to select and choose card type dropdown for "kartu baru"*/
WebUI.selectOptionByLabel(cardTypeDropDown, chooseAllTypeCard, false)

/* We want capture new card*/
WebUI.takeScreenshot()

/* We want to search list data based on new card*/
for (int i = 0; i < 10; i++) {
	TestObject newCardText = new TestObject().addProperty('text',ConditionType.CONTAINS,'Kartu Baru')
	if (WebUI.verifyElementPresent(newCardText, 5,FailureHandling.OPTIONAL)) {
/* We just give info the log*/	
	KeywordUtil.logInfo("Done Process")
/* We want verify text new card if founded*/
	WebUI.verifyTextPresent(newCard, false)
/* We want capture the data*/	
	WebUI.takeScreenshot()
	break;
} else {
/* We just give info the log*/
	KeywordUtil.logInfo("Failed Process")
/* We want to verify the next page on bucket list*/	
	WebUI.verifyElementPresent(btnNextPageBucketList, 2)
/* We want to click button next page in bucket list*/	
	WebUI.click(btnNextPageBucketList)
}}

/* We want to makesure we can click the button first page*/
if (WebUI.verifyElementPresent(btnFirstPageBucketList, 3,FailureHandling.OPTIONAL)) {
	/* We want to click button first page*/
	WebUI.click(btnFirstPageBucketList)
} else {
	/* We just give info the log*/
	KeywordUtil.logInfo("We are on the first page")
	/* We want capture the first page*/
	WebUI.takeScreenshot()	
}

/* We want to search list data based on request new card*/
for (int i = 0; i < 10; i++) {
	if (WebUI.verifyElementText(bucketListRequestNewCard, requestNewCard,FailureHandling.OPTIONAL)) {
	/* We just give info the log*/
	KeywordUtil.logInfo("Done Process")
	/* We want verify text new card if founded*/
	WebUI.verifyTextPresent(requestNewCard, false)
	/* We want capture the data*/
	WebUI.takeScreenshot()
	break;
} else {
	/* We just give info the log*/
	KeywordUtil.logInfo("Failed Process")
	/* We want to verify the next page on bucket list*/
	WebUI.verifyElementPresent(btnNextPageBucketList, 2)
	/* We want to click button next page in bucket list*/
	WebUI.click(btnNextPageBucketList)
}}

/* We want to refresh for the next process*/
WebUI.refresh()