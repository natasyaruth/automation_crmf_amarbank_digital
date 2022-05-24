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

/* We want to verify the menu card management*/
WebUI.verifyElementPresent(menuCardManagement, 5)

/* We want to click the menu card management*/
WebUI.click(menuCardManagement)

/* We want to verify the menu assign card*/
WebUI.verifyElementPresent(menuAssignCard, 5)

/* We want to click menu assign card*/
WebUI.click(menuAssignCard)

/* We want verify label element "Filter by customer origin"*/
WebUI.verifyElementPresent(labelFilterByCustomerOriginElement, 5)

/* We want to verify element & text filter by customer origin*/
WebUI.verifyElementText(labelFilterByCustomerOriginElement, labelFilterByCustomerOriginText)

/* We want to verify the field drop down filter by customer origin text*/
WebUI.verifyElementPresent(fieldFilterByCustomerElement, 5)

/* We want choose senyumku on drop down data*/
WebUI.selectOptionByLabel(fieldFilterByCustomerElement, allCustomerOriginText, false)

/* We want to capture the page senyumku data in bucket list*/
WebUI.takeScreenshot()

/* We want to search list data based on senyumku*/
for (int i = 0; i < 10; i++) {
	if (WebUI.verifyElementText(senyumkuDataOnBucketList, senyumkuDataOnBucketListText, FailureHandling.OPTIONAL)) {
	/* We want verify text senyumku if founded*/
	WebUI.verifyTextPresent(senyumkuDataOnBucketListText, false)
	/* We want capture the data*/
	WebUI.takeScreenshot()
	break;
} else {
	/* We want to verify the next page on bucket list*/
	WebUI.verifyElementPresent(btnNextPageBucketList, 5)
	/* We want to click button next page in bucket list*/
	WebUI.click(btnNextPageBucketList)
}}
/* We want to makesure we can click the button first page*/
if (WebUI.verifyElementPresent(btnFirstPageBucketList, 5, FailureHandling.OPTIONAL)) {
	/* We want to click button first page*/
	WebUI.click(btnFirstPageBucketList)
} else {
	/* Just info in system we are in first page */	
	KeywordUtil.logInfo("We are on the first page")
	/* We want capture the first page*/
	WebUI.takeScreenshot()
}
/* We want to search list data based on request tunaiku disbursement*/
for (int i = 0; i < 10; i++) {
	if (WebUI.verifyElementText(tunaikuDisbursementDataBucketList, tunaikuDisbursementDataBucketListText, FailureHandling.OPTIONAL)) {
	/* We want verify text new card if founded*/
	WebUI.verifyTextPresent(tunaikuDisbursementDataBucketListText, false)
	/* We want capture the data*/
	WebUI.takeScreenshot()
	break;
} else {
	/* We want to verify the next page on bucket list*/
	WebUI.verifyElementPresent(btnNextPageBucketList, 5)
	/* We want to click button next page in bucket list*/
	WebUI.click(btnNextPageBucketList)
}}
