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

WebUI.click(findTestObject('Website/CRM/Reporting/LinkReporting'))

WebUI.click(findTestObject('Website/CRM/Reporting/AgentReporting/LinkAgentReporting'))

WebUI.waitForPageLoad(3)

WebUI.verifyTextPresent('Reporting Agent', false)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/LbHeaderTitle'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/LinkBreadcrumpItem'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/LBDateRangeFilter'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/DtpStartFilterDate'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/BtnShow'), 1)

WebUI.verifyTextPresent('Cari nama agent', false)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/LbSearchFilter'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/TxtEmployeeName'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/BtnSearch'), 1)

WebUI.verifyTextPresent('Pilih role', false)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/DrpRoleName'), 1)

WebUI.verifyTextPresent('Semua role', false)

WebUI.click(findTestObject('Website/CRM/Reporting/AgentReporting/DrpRoleName'))

WebUI.selectOptionByValue(findTestObject('Website/CRM/Reporting/AgentReporting/DrpRoleName'), DrpOptionKYCVerification, 
    false)

WebUI.verifyOptionPresentByValue(findTestObject('Website/CRM/Reporting/AgentReporting/DrpRoleName'), DrpOptionKYCVerification, 
    false, 3)

WebUI.selectOptionByValue(findTestObject('Website/CRM/Reporting/AgentReporting/DrpRoleName'), DrpOptionKYCVideo, false)

WebUI.selectOptionByValue(findTestObject('Website/CRM/Reporting/AgentReporting/DrpRoleName'), DrpOptionKYCVideo, false)

WebUI.verifyOptionPresentByValue(findTestObject('Website/CRM/Reporting/AgentReporting/DrpRoleName'), DrpOptionCSR, false, 
    3)

WebUI.verifyOptionPresentByValue(findTestObject('Website/CRM/Reporting/AgentReporting/DrpRoleName'), DrpOptionCSR, false, 
    3)

WebUI.selectOptionByValue(findTestObject('Website/CRM/Reporting/AgentReporting/DrpRoleName'), DrpOptionTelesales, false)

WebUI.verifyOptionPresentByValue(findTestObject('Website/CRM/Reporting/AgentReporting/DrpRoleName'), DrpOptionTelesales, 
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

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/LbPaginationInfo'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/BtnNextPage'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/BtnLastPage'), 1)

WebUI.click(findTestObject('Website/CRM/Reporting/AgentReporting/BtnNextPage'))

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/LbPageInfo'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/BtnPreviousPage'), 1)

WebUI.verifyElementPresent(findTestObject('Website/CRM/Reporting/AgentReporting/BtnFirstPage'), 1)

