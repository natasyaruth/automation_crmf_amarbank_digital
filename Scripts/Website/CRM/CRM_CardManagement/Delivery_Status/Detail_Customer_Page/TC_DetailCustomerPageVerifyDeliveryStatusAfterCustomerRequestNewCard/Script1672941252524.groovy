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
import com.kms.katalon.core.webservice.keyword.builtin.ContainsStringKeyword as ContainsStringKeyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.io.FileInputStream as FileInputStream
import java.io.FileNotFoundException as FileNotFoundException
import java.io.FileOutputStream as FileOutputStream
import java.io.IOException as IOException
import org.apache.pdfbox.pdmodel.PDDocument as PDDocument
import org.apache.pdfbox.text.PDFTextStripper as PDFTextStripper
import java.io.File as File
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent as HttpTextBodyContent
import com.kms.katalon.core.testobject.internal.impl.HttpBodyContentReader as HttpBodyContentReader
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.RestRequestObjectBuilder as RestRequestObjectBuilder
import com.kms.katalon.core.testobject.UrlEncodedBodyParameter as UrlEncodedBodyParameter
import static org.assertj.core.api.Assertions.*
import com.tunaiku.keyword.SecureUtils as SecureUtils
import com.google.gson.JsonObject as JsonObject

/* We want to open menu Delivery Status*/
WebUI.waitForElementVisible(menuCardManagementElement, 5)

WebUI.verifyElementPresent(menuCardManagementElement, 5)

WebUI.click(menuCardManagementElement)

WebUI.verifyElementVisible(menuDeliveryStatus)

WebUI.click(menuDeliveryStatus)

WebUI.verifyElementText(headerDeliveryStatus, 'Delivery Status')

/* We want to filter request type "Request new card"*/
WebUI.selectOptionByLabel(DrpSortByRequestType, RequestNewCard, false)

/* We want to wait for element visible for the first row*/
WebUI.waitForElementVisible(firstRowReqId,5)

/* We want capture*/
WebUI.takeScreenshot()

/* We want to get text from first request card type*/
String firstrowcardtype = WebUI.getText(FirstRowRequestType)
/* We want makesure reference ID still same*/
WebUI.verifyMatch(firstrowcardtype, RequestNewCard, false)

/* We want to capture*/
WebUI.takeScreenshot()

/* We want refresh page*/
WebUI.refresh()

