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
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

WebUI.verifyTextPresent(headerDashboard, false, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Management/KYCManagementLink'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Video/KYC_Video/KYCVideoLinkVideoRequest'), 30, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/KYC_Video/KYCVideoLinkVideoRequest'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/KYCVerificationLinkRequestID'), 30, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyTextPresent(headerKYCVideoRequest, false, FailureHandling.CONTINUE_ON_FAILURE)

List listRequestId = WebUI.findWebElements(findTestObject('Website/CRM/KYC_Management/KYC_Verification/Bucketlist/KYCVerificationLinkRequestID'), 10)

listRequestId.get(indexNumber).click()

WebUI.refresh()

WebUI.waitForPageLoad(5)

TestObject verifyTextKYCPage = new TestObject().addProperty('text', ConditionType.CONTAINS, headerKYCCustomerDetail)

WebUI.waitForElementVisible(verifyTextKYCPage, 10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/Dashboard/DashboardLink'))

if(WebUI.verifyElementVisible(findTestObject('Website/CRM/Dashboard/DashboardCntrPendingRequestNotification'), FailureHandling.OPTIONAL) == false) {
    WebUI.refresh()
}

WebUI.click(findTestObject('Website/CRM/Dashboard/DashboardCntrPendingRequestNotification'))

WebUI.verifyTextPresent(headerKYCCustomerDetail, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForPageLoad(5)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/KYCVideoDetailsBtnBack'))

WebUI.waitForPageLoad(10)

WebUI.verifyTextPresent(headerKYCVideoRequest, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.refresh()

