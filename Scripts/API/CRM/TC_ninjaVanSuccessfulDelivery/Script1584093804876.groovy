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
import com.google.gson.JsonObject as JsonObject
import groovy.json.JsonSlurper
import com.tunaiku.keyword.SecureUtils as SecureUtils
import internal.GlobalVariable as GlobalVariable

//body

String dataApi =
'{"shipper_id": '+ shipper_id +
',"status": "'+ status_success +
'","previous_status": "'+ previous_status_success +
'","shipper_order_ref_no": "'+ shipper_order_ref_no +
'","timestamp": "'+ timestamp_success +
'","order_id": "'+ id +
'","tracking_id": "AMARTUNAIKU-'+ tracking_id +
'","pod": {"type":"'+ type +
'","name": "'+ name +
'","identity_number": "'+ identity_number +
'","contact": "'+ contact +
'","uri": "'+ uri +
'","left_in_safe_place": '+ left_in_safe_place +
'}}'

System.out.println(dataApi)

hashNinjaVanSuccessfulDelivery = SecureUtils.hmac_sha256("cf47ca4e44844cb987eb0577530a12a0",dataApi.toString())


//save the hash as global variable
GlobalVariable.hashNinjaVanSuccessfulDelivery = hashNinjaVanSuccessfulDelivery
println (GlobalVariable.hashNinjaVanSuccessfulDelivery)

//prepare the http request
def request = (RequestObject) findTestObject('API/CRM/API_ninjaVanSuccessfulDelivery')
request.setBodyContent(new HttpTextBodyContent(dataApi, "UTF-8", "application/json"))

String dataHash = SecureUtils.hmac_sha256("cf47ca4e44844cb987eb0577530a12a0",dataApi.toString())

ArrayList listQuery = new ArrayList()
listQuery.add(new TestObjectProperty("hashNinjaVanSuccessfulDelivery", ConditionType.EQUALS, dataHash))
request.setRestParameters(listQuery)

def response = WS.sendRequest(request)

//get response
def body_content = response.responseBodyContent
def status_code = response.statusCode

println (body_content)
println (status_code)

def respDataMap = new JsonSlurper().parseText(body_content)