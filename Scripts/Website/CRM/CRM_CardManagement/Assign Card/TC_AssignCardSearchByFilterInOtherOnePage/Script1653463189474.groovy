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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
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
} else {
	WebUI.verifyElementText(headerAssignCardElement, headerAssignCardText)
}

/* We want to makesure we can click the button first page*/
if (WebUI.verifyElementPresent(btnFirstPageBucketList, 5, FailureHandling.OPTIONAL)) {
	/* We want to click button first page*/
	WebUI.click(btnFirstPageBucketList)
} else {
	/* We want capture the first page*/
	WebUI.takeScreenshot()
}

/* We want to move to page 5*/
for (int i = 0; i < 10; i++) {
	if (WebUI.verifyElementPresent(expectedPageElement, 5, FailureHandling.OPTIONAL)) {
/* We want to verify element and text for expected page*/
	WebUI.verifyElementText(expectedPageElement, expectedPageText)	
/* We want capture it for the right process*/
	WebUI.takeScreenshot()
	break;	
	}else {
/* We want to verify button next page*/
	WebUI.verifyElementPresent(btnNextPageElement, 5)
/* We want to click button next page*/
	WebUI.click(btnNextPageElement)		
	}
}

/* We want to verify field card type*/
WebUI.verifyElementPresent(fieldRequestTypeCard, 5)

/* We want to choose each one from field request type*/
WebUI.selectOptionByLabel(fieldRequestTypeCard, newCardText, false)

/* We want to verify data new card on bucket list data*/
WebUI.verifyElementText(newCardElement, newCardText)

/* We want verify element field start date*/
WebUI.verifyElementPresent(fieldDateFromElement, 5)

/* We want input start date example date "11/05/2022"*/
WebUI.setText(fieldDateFromElement, inputStartDateText)

/* We want verify element field end date*/
WebUI.verifyElementPresent(fieldDateEndElement, 5)

/* We want input end date example date "20/05/2022"*/
WebUI.setText(fieldDateEndElement, inputEndDateText)

/* We want verify button "Tampilkan" */
WebUI.verifyElementPresent(btnShowFilterElement, 5)

/* We want to click button "Tampilkan"*/
WebUI.click(btnShowFilterElement)

/* We want to verify date on bucket list*/
WebUI.verifyElementText(endDateElement, inputEndDateText)

/* We want to screen capture the page*/
WebUI.takeScreenshot()

/* We want to refresh for the next process*/
WebUI.refresh()