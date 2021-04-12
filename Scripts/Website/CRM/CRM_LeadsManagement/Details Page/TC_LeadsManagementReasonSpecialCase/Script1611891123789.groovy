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
import org.openqa.selenium.Keys as Keys

WebUI.verifyTextPresent(GlobalVariable.titleCustomerDetails, false)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnOpenPendingModal'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/Leads_Management/Detail/HeaderChangeSchedule'), 5)

def inputDate = new Date()

def calendar = Calendar.getInstance()

calendar.setTime(inputDate)

calendar.add(Calendar.DATE, 1)

inputDate = calendar.getTime().format('dd/MM/yyyy')+' 0:00'

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/DrpPendingSchedule'), inputDate)

WebUI.sendKeys(findTestObject('Website/CRM/Leads_Management/Detail/DrpPendingSchedule'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/ChkOther'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/Leads_Management/Detail/TxtPendingReason'), 5)

WebUI.verifyElementNotClickable(findTestObject('Website/CRM/Leads_Management/Detail/BtnSubmitPendingConfirmation'))

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtPendingReason'), inputText)

WebUI.verifyElementClickable(findTestObject('Website/CRM/Leads_Management/Detail/BtnSubmitPendingConfirmation'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnSubmitPendingConfirmation'))

WebUI.verifyElementText(findTestObject('Website/CRM/Leads_Management/Detail/MsgErrorReason'), msgErrorEmptyPendingReason)

WebUI.verifyElementNotClickable(findTestObject('Website/CRM/Leads_Management/Detail/BtnSubmitPendingConfirmation'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/ChkOther'))

WebUI.verifyElementNotClickable(findTestObject('Website/CRM/Leads_Management/Detail/BtnSubmitPendingConfirmation'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/ChkOther'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/Leads_Management/Detail/TxtPendingReason'), 0)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtPendingReason'), inputText2)

String actualText

actualText = WebUI.getText(findTestObject('Website/CRM/Leads_Management/Detail/TxtPendingReason'))

WebUI.verifyEqual(actualText.length(), length)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnCancelPendingConfirmation'))

WebUI.waitForElementNotPresent(findTestObject('Website/CRM/Leads_Management/Detail/HeaderChangeSchedule'), 5)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnOpenRejectModal'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/Leads_Management/Detail/TxtReject'), 10)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/ChkOther'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/Leads_Management/Detail/TxtRejectReasonModal'), 5)

WebUI.verifyElementNotClickable(findTestObject('Website/CRM/Leads_Management/Detail/BtnSubmitRejectConfirmation'))

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtRejectReasonModal'), inputText)

WebUI.verifyElementClickable(findTestObject('Website/CRM/Leads_Management/Detail/BtnSubmitRejectConfirmation'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnSubmitRejectConfirmation'))

WebUI.verifyElementText(findTestObject('Website/CRM/Leads_Management/Detail/MsgErrorReason'), msgErrorEmptyRejectReason)

WebUI.verifyElementNotClickable(findTestObject('Website/CRM/Leads_Management/Detail/BtnSubmitRejectConfirmation'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/ChkOther'))

WebUI.verifyElementNotClickable(findTestObject('Website/CRM/Leads_Management/Detail/BtnSubmitRejectConfirmation'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/ChkOther'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/Leads_Management/Detail/TxtRejectReasonModal'), 0)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtRejectReasonModal'), inputText2)

String actualLength = WebUI.getText(findTestObject('Website/CRM/Leads_Management/Detail/TxtRejectReasonModal')).length()

WebUI.verifyEqual(actualLength, length)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnCancelRejectConfirmation'))

WebUI.waitForElementNotPresent(findTestObject('Website/CRM/Leads_Management/Detail/TxtReject'), 5)

