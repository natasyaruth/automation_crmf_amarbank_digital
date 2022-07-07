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
import internal.GlobalVariable
import javassist.compiler.ast.Keyword

import org.openqa.selenium.Keys as Keys

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
}else {
	WebUI.verifyElementText(headerAssignCardElement, headerAssignCardText)
}

/* Set keyword utils*/
KeywordUtil keylogger = new KeywordUtil()

if (WebUI.verifyElementText(headerAssignCardElement, headerAssignCardText , FailureHandling.OPTIONAL)) {
	if (WebUI.verifyElementPresent(fieldRequestCardTypeElement, 5 , FailureHandling.OPTIONAL)) {
		WebUI.selectOptionByLabel(fieldRequestCardTypeElement, requestNewCardText, false)
		if (WebUI.verifyElementPresent(fieldCsutomerOriginElement, 5 , FailureHandling.OPTIONAL)) {
			WebUI.selectOptionByLabel(fieldCsutomerOriginElement, tunaikuDisbursementCustomerOriginText, false)
			/* We want click button "Tampilkan"*/
			WebUI.click(btnShowFilterElement)
			def newestDate = WebUI.getText(firstRowDateElement)
			keylogger.logInfo(" This one newest Date we got " + newestDate)
				if (WebUI.verifyElementVisible(btnLastPage , FailureHandling.OPTIONAL)) {
					WebUI.click(btnLastPage)
					def oldDate = WebUI.getText(firstRowDateElement)
					keylogger.logInfo(" This one old Date we got " + oldDate)
					WebUI.verifyNotMatch(newestDate, oldDate, false)
					WebUI.refresh()
				} else {
					keylogger.logInfo("We don't see the button last page")
					def oldDate = WebUI.getText(firstRowDateElement)
					keylogger.logInfo(" This one old Date we got " + oldDate)
					WebUI.refresh()
				}
		} else {
			keylogger.logInfo("We not find the field customer origin element", FailureHandling.STOP_ON_FAILURE)
		}
	} else {
		keylogger.logInfo("We not find the Request card type" , FailureHandling.STOP_ON_FAILURE)
	}
} else {
	keylogger.logInfo("We are not in assign card" , FailureHandling.STOP_ON_FAILURE)
}
println(oldDate)
println(newestDate)

/* We want verify element field start date*/
WebUI.verifyElementPresent(fieldDateFromElement, 5)

/* We want input start date example date "11/05/2022"*/
WebUI.setText(fieldDateFromElement, oldDate)

/* We want verify element field end date*/
WebUI.verifyElementPresent(fieldDateEndElement, 5)

/* We want input end date example date "19/05/2022"*/
WebUI.setText(fieldDateEndElement, newestDate)

/* We want verify button "Tampilkan" */
WebUI.verifyElementPresent(btnShowFilterElement, 5)

/* We want to screen capture the page*/
WebUI.takeScreenshot()

/* We want to verify element field request card type*/
WebUI.verifyElementPresent(fieldRequestCardTypeElement, 5)

/* We want to choose value "Permintaan kartu baru" on field request card type*/
WebUI.selectOptionByLabel(fieldRequestCardTypeElement, requestNewCardText, false)

/* We want to screen capture the page*/
WebUI.takeScreenshot()

/* We want to verify element field customer origin*/
WebUI.verifyElementPresent(fieldCsutomerOriginElement, 5)

/* We want to choose value "Semua " on field customer origin*/
WebUI.selectOptionByLabel(fieldCsutomerOriginElement, tunaikuDisbursementCustomerOriginText, false)

/* We want click button "Tampilkan"*/
WebUI.click(btnShowFilterElement)

/* We want verify first row date visible*/
WebUI.verifyElementPresent(firstRowDateElement, 5)

/* We want to get date text from first line / row*/
currentDateExisting = WebUI.getText(firstRowDateElement)

/* We want verify element and text for first element*/
WebUI.verifyElementText(firstRowDateElement, currentDateExisting)

/* We want to verify check the request new card*/
for (int i = 0; i < 10; i++) {
	if (WebUI.verifyElementPresent(requestNewCardElement, 5,FailureHandling.OPTIONAL)) {
	/* We want to verify element and text for "permintaan kartu baru"*/
	WebUI.verifyElementText(requestNewCardElement, requestNewCardText)
	/* We want capture it*/
	WebUI.takeScreenshot()
	break;
	}else {
	/* We want to verify next page button*/
	WebUI.verifyElementPresent(btnNextPage, 5)
	/* We want to click button next page*/
	WebUI.click(btnNextPage)
	}
}

/* We want to makesure we can click the button first page*/
if (WebUI.verifyElementPresent(btnFirstPageBucketList, 5, FailureHandling.OPTIONAL)) {
	/* We want to click button first page*/
	WebUI.click(btnFirstPageBucketList)
} else {
	/* We want capture the first page*/
	WebUI.takeScreenshot()
}

/* We want to verify check the tunaiku disbursement customer origin*/
for (int i = 0; i < 10; i++) {
	if (WebUI.verifyElementPresent(tunaikuDisbursementCustomerOriginElement, 5,FailureHandling.OPTIONAL)) {
	/* We want to verify element and text for "tunaiku disbursement"*/
	WebUI.verifyElementText(tunaikuDisbursementCustomerOriginElement, tunaikuDisbursementCustomerOriginText)
	/* We want capture it*/
	WebUI.takeScreenshot()
	break;
	}else {
	/* We want to verify next page button*/
	WebUI.verifyElementPresent(btnNextPage, 5)
	/* We want to click button next page*/
	WebUI.click(btnNextPage)
	}
}

/* We want to refresh for the next process*/
WebUI.refresh()