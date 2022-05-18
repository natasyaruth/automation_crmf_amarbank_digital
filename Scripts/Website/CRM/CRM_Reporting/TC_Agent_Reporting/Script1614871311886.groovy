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

WebUI.click(findTestObject('Website/CRM/Reporting/Reporting/ReportingLink'))

WebUI.click(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingLink'))

WebUI.waitForPageLoad(3)

WebUI.verifyTextPresent('Reporting Agent', false)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingLbHeaderTitle'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingLinkBreadcrumpItem'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingLBDateRangeFilter'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingDtpStartFilterDate'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingBtnShow'), 1)

WebUI.verifyTextPresent('Cari nama agent', false)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingLbSearchFilter'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingTxtEmployeeName'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingBtnSearch'), 1)

WebUI.verifyTextPresent('Pilih role', false)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingDrpRoleName'), 1)

WebUI.verifyTextPresent('Semua role', false)

WebUI.click(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingDrpRoleName'))

WebUI.selectOptionByValue(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingDrpRoleName'), DrpOptionKYCVerification, 
    false)

WebUI.verifyOptionPresentByValue(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingDrpRoleName'), DrpOptionKYCVerification, 
    false, 3)

WebUI.selectOptionByValue(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingDrpRoleName'), DrpOptionKYCVideo, false)

WebUI.selectOptionByValue(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingDrpRoleName'), DrpOptionKYCVideo, false)

WebUI.verifyOptionPresentByValue(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingDrpRoleName'), DrpOptionCSR, false, 
    3)

WebUI.verifyOptionPresentByValue(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingDrpRoleName'), DrpOptionCSR, false, 
    3)

WebUI.selectOptionByValue(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingDrpRoleName'), DrpOptionTelesales, false)

WebUI.verifyOptionPresentByValue(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingDrpRoleName'), DrpOptionTelesales, 
    false, 3)

WebUI.refresh()

WebUI.verifyTextPresent('No', false)

WebUI.verifyTextPresent('Nama Agent', false)

WebUI.verifyTextPresent('Tanggal', false)

WebUI.verifyTextPresent('Role Name', false)

WebUI.verifyTextPresent('Ditunda', false)

WebUI.verifyTextPresent('Ditolak', false)

WebUI.verifyTextPresent('Selesai', false)

WebUI.verifyTextPresent('Lihat Detail', false)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingLbPaginationInfo'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingBtnNextPage'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingBtnLastPage'), 1)

WebUI.click(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingBtnNextPage'))

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingLbPageInfo'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingBtnPreviousPage'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/AgentReportingBtnFirstPage'), 1)

