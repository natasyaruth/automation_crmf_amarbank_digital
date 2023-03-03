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

/* this is testcase we put from TC_Login_Non_Roles */
WebUI.callTestCase(findTestCase('URL/URL_Staging_CRM'), [('listValue') : ['--enable-automation', '--no-sandbox', '--disable-infobars', '--disable-extensions', '--enable-async-dns', '--managed-user-id', '--sync-url', '--use-fake-device-for-media-stream', '--dom-automation', '--file-system-sync-access-handle-async-interface-enabled', '--oobe-trigger-sync-timeout-for-tests', 'disable-dev-shm-usage', '--disable-gpu']
        , ('listOfPrefs') : [('profile.default_content_setting_values.geolocation') : 1, ('profile.default_content_setting_values.media_stream_mic') : 1, ('profile.default_content_setting_values.media_stream_camera') : 1, ('profile.default_content_setting_values.notifications') : 1, ('download.default_directory') : '\\Download Path', ('download.directory_upgrade') : true, ('download.prompt_for_download') : false, ('plugins.always_open_pdf_externally') : true, ('profile.default_content_settings.popups') : '0', ('profile.content_settings.exceptions.automatic_downloads.*.setting') : '1']
        , ('FieldUsernameKeyclock') : findTestObject('Website/Keyclock/LoginPage/txtUsernameKeyClock'), ('FieldPasswordKeyclock') : findTestObject('Website/Keyclock/LoginPage/txtPasswordKeyclock')
        , ('btnLoginKeyclock') : findTestObject('Website/Keyclock/LoginPage/btnLoginKeyclock'), ('usernameKeyclock') : GlobalVariable.usernameKeyclockSec
        , ('passwordKeyclock') : GlobalVariable.passwordKeyclockSec], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Website/CRM/CRM_Login/TC_Login'), [('btnLoginText') : 'Login by Email Amarbank', ('verifyFieldEmail') : 'Masukkan email Anda'
        , ('gmailAccount') : findTestData('Website/Dataset_CRMLogin/Dataset_Login').getValue(1, 5), ('gmailPassword') : findTestData(
            'Website/Dataset_CRMLogin/Dataset_Login').getValue(2, 5), ('verifyFieldPassword') : 'Masukkan sandi Anda', ('verifyDasboardPage') : 'Welcome to Senyumku CRM'
        , ('username') : findTestData('Website/Dataset_CRMLogin/Dataset_Login').getValue(3, 5), ('logoLoginPage') : findTestObject(
            'Website/CRM/Login/LoginImageSenyumku'), ('btnLogin') : findTestObject('Website/CRM/Login/LoginBtn'), ('fieldEmailLogin') : findTestObject(
            'Website/CRM/Login/LoginTxtGmailAccount'), ('btnNext') : findTestObject('Website/CRM/Login/LoginBtnNext'), ('fieldPasswordLogin') : findTestObject(
            'Website/CRM/Login/LoginTxtGmailPassword'), ('btnPasswordNext') : findTestObject('Website/CRM/Login/LoginBtnPasswordNext')
        , ('gridInfoLogin') : findTestObject('Website/CRM/Login/LoginGridInfoLogin'), ('menuDashboard') : findTestObject(
            'Website/CRM/Dashboard/DashboardLink'), ('menuReporting') : findTestObject('Website/CRM/Reporting/Reporting/ReportingLink')
        , ('menuLiveReport') : findTestObject('Website/CRM/Reporting/LiveReporting/LiveReportingLink'), ('menuAgentReporting') : findTestObject(
            'Website/CRM/Reporting/AgentReporting/AgentReportingLink'), ('menuKycManagement') : findTestObject('Website/CRM/KYC_Management/KYC_Management/KYCManagementLink')
        , ('menuKYCVideo') : findTestObject('Website/CRM/KYC_Management/KYC_Video/KYC_Video/KYCVideoLinkVideoRequest'), ('menuKYCVerif') : findTestObject(
            'Website/CRM/KYC_Management/KYC_Verification/KYC_Verification/KYCVerificationLink'), ('menuKYCAutomate') : findTestObject(
            'Website/CRM/KYC_Management/KYC_AutomateProcess/linkKycAutomate'), ('menuCardManagement') : findTestObject('Website/CRM/Card Management/Card_Management/CardManagementLink')
        , ('menuAssignCard') : findTestObject('Website/CRM/Card Management/Assign_Card/AssignCardLink'), ('menuCardPrinting') : findTestObject(
            'Website/CRM/Card Management/Card Printing/LinkCardPrinting'), ('menuDeliveryStatus') : findTestObject('Website/CRM/Card Management/Delivery Status/DeliveryStatusLink')
        , ('menuCSRManagement') : findTestObject('Website/CRM/CSR_Management/CSRManagement/CSRManagementLink'), ('menuLeadsManagement') : findTestObject(
            'Website/CRM/Leads_Management/LeadsManagement/LeadsManagementLink'), ('menuLogout') : findTestObject('Website/CRM/Logout/LogoutLink')
        , ('menuUploadPhoto') : findTestObject('Website/CRM/UploadPhoto/LinkUploadPhoto')], FailureHandling.STOP_ON_FAILURE)

/* We will direct to video verification*/
WebUI.navigateToUrl(siteURL_CSR_Management + '/csr-management')

/* We will capture the page*/
WebUI.takeScreenshot(FailureHandling.OPTIONAL)

