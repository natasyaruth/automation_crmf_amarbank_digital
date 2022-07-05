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

/* We want to check from menu card management*/
WebUI.waitForElementPresent(menuCardManagement, 10)

WebUI.verifyElementPresent(menuCardManagement, 5)

/* We want to click menu to expand the menu card management */
WebUI.click(menuCardManagement)

/* We want to identify the element menu delivery status*/
WebUI.verifyElementPresent(menuDeliveryStatus, 5)

/* We want to click menu delivery status page*/
WebUI.click(menuDeliveryStatus)

/* We will wait for filter request card type bucketlist page is exist*/
WebUI.waitForElementPresent(FilterRequestCardType, 10)

/* We want to verify text in Bucketlist*/
WebUI.verifyElementVisible(DeliveryStatusText, FailureHandling.STOP_ON_FAILURE)

/* We will verify that searchfield in bucketlist page is exist*/
WebUI.verifyElementPresent(TextfieldSearchRefID, 5)

/* We will verify that filter start date in bucketlist page is exist*/
WebUI.verifyElementPresent(FilterStartDate, 5)

/* We will verify that filter end date in bucketlist page is exist*/
WebUI.verifyElementPresent(FilterEndDate, 5)

/* We will verify that button Show in bucketlist page is exist*/
WebUI.verifyElementPresent(ButtonShow, 5)

/* We will verify that filter delivery status in bucketlist page is exist*/
WebUI.verifyElementPresent(FilterDeliveryStatus, 5)

/* We will verify that filter request card type in bucketlist page is exist*/
WebUI.verifyElementPresent(FilterRequestCardType, 5)

/* We will verify that table list of delivery status page is exist*/
WebUI.verifyElementPresent(TableBucketlist, 5)

/* We will verify column number*/
WebUI.verifyElementPresent(ColumnNumber, 5)

/* We will verify column requestid*/
WebUI.verifyElementPresent(ColumnRequestID, 5)

/* We will verify column refid*/
WebUI.verifyElementPresent(ColumnRefID, 5)

/* We will verify column name*/
WebUI.verifyElementPresent(ColumnName, 5)

/* We will verify column request card type*/
WebUI.verifyElementPresent(ColumnRequestCardType, 5)

/* We will verify column Request Date*/
WebUI.verifyElementPresent(ColumnRequestDate, 5)

/* We will verify column Courier Type*/
WebUI.verifyElementPresent(ColumnCourierType, 5)

/* We will verify column Delivery Status*/
WebUI.verifyElementPresent(ColumnDeliveryStatus, 5)

/* We will capture delivery status bucketlist page */
WebUI.takeScreenshot()

/* We want to click button Request ID*/
WebUI.click(RequestID)

/* We waiting for element data nasabah is present*/
WebUI.waitForElementPresent(findTestObject('Website/CRM/Card Management/Delivery Status/Details/DeliveryStatusDataNasabahElement'), 
    10)

/*We will verify detail Delivery Status is present*/
WebUI.verifyElementPresent(findTestObject('Website/CRM/Card Management/Delivery Status/Details/DeliveryStatusDataNasabahElement'), 
    0)

/* We will capture delivery status detail page */
WebUI.takeScreenshot()

