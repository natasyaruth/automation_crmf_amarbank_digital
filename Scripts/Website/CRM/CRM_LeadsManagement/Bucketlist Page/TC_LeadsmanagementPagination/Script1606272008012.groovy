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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

WebUI.click(findTestObject('Website/CRM/Leads_Management/Bucketlist/LeadsManagementBucketListBtnNextPage'))

WebUI.waitForPageLoad(2)

WebUI.verifyElementText(findTestObject('Website/CRM/Leads_Management/Bucketlist/LeadsManagementBucketListPaginationSpan'), secondPage)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Bucketlist/LeadsManagementBucketListBtnPreviousPage'))

WebUI.waitForPageLoad(2)

WebUI.verifyElementText(findTestObject('Website/CRM/Leads_Management/Bucketlist/LeadsManagementBucketListPaginationSpan'), firstPage)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Bucketlist/LeadsManagementBucketListBtnLastPage'))

WebUI.waitForPageLoad(2)

WebUI.delay(1)

def expectedFirst = WebUI.getText(findTestObject('Website/CRM/Leads_Management/Bucketlist/LeadsManagementBucketListPaginationSpan'))

def expectedLast = WebUI.getText(findTestObject('Website/CRM/Leads_Management/Bucketlist/LeadsManagementBucketListTxtLastPage'))

WebUI.verifyEqual(expectedFirst, expectedLast)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Bucketlist/LeadsManagementBucketListBtnFirstPage'))

WebUI.waitForPageLoad(2)

WebUI.verifyElementText(findTestObject('Website/CRM/Leads_Management/Bucketlist/LeadsManagementBucketListPaginationSpan'), firstPage)

