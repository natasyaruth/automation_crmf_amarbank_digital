import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
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
import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

GlobalVariable.sessionCRM = sessionCRM
GlobalVariable.customerId = customerId

//prepare the http request
def request = (RequestObject) findTestObject('API/CRM/API_getDetailLeads')
//request.setBodyContent(new HttpTextBodyContent(body, "UTF-8", "application/json"))
println (request.getRestUrl())

System.out.println("session = " + sessionCRM)
ArrayList listHeader = new ArrayList()
listHeader.add(new TestObjectProperty("session", ConditionType.EQUALS, sessionCRM))
request.setHttpHeaderProperties(listHeader)
def response = WS.sendRequest(request)

//get response
def body_content = response.responseBodyContent
def status_code = response.statusCode

println (body_content)
println (status_code)

def respDataMap = new JsonSlurper().parseText(body_content)

//compare the result
result = WS.verifyEqual(response.statusCode, expected_status_code)

if (result == false) {
	System.out.println(response.getStatusCode())
} else {
	
}