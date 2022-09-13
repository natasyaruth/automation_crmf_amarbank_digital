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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import com.tunaiku.keyword.SecureUtils
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.util.KeywordUtil
import groovy.json.JsonSlurper
import static org.assertj.core.api.Assertions.*

import java.util.concurrent.ConcurrentHashMap.KeySetView

import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.internal.impl.HttpBodyContentReader
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObject

/* We want declare the keywordutil*/
KeywordUtil keyLogger = new KeywordUtil()
WebDriver driverAssignCard = DriverFactory.getWebDriver()
WebElement tblAssignCard
List<WebElement> RowsTable

/* We want to direct to menu card management */
if (WebUI.verifyElementVisible(menuCardManagement,FailureHandling.OPTIONAL)) {
	WebUI.click(menuCardManagement)
	if (WebUI.verifyElementVisible(linkAssignCard,FailureHandling.OPTIONAL)) {
		WebUI.click(linkAssignCard)
	}
} else {keyLogger.markError("Menu card management not shown")}

/*We want handling the blocking Assign Card*/
if (WebUI.verifyElementVisible(popUpBlock, FailureHandling.OPTIONAL)) {
	keyLogger.logInfo("We process the block in assign Card")
	WebUI.verifyElementVisible(txtBlock)
	WebUI.click(btnBatalBlock)
	WebUI.verifyElementVisible(txtHeaderAssignCard)
} else {
	WebUI.verifyElementVisible(txtHeaderAssignCard)
	keyLogger.logInfo("We pass the process block")
}

/* We want this process to click request Id and go to detail
 * then we keep the Request Id for using hit delivery card by ninja enroute & success Delivery*/
LoopCondition:
while (flagCondition == false) {
	if (WebUI.verifyElementVisible(drpDwnCardType,FailureHandling.OPTIONAL)) {
		tblAssignCard = driverAssignCard.findElement(By.xpath('//table/tbody'))
		RowsTable = tblAssignCard.findElements(By.tagName('tr'))
		WebUI.verifyOptionsPresent(drpDwnCardType, listCardType)
		WebUI.selectOptionByLabel(drpDwnCardType, "Permintaan Kartu Baru", false)
		for (int i = 0;i < RowsTable.size(); i++) {
			println('No. of rows: ' + RowsTable.size() + 'and check list rows: ' +i)
			List<WebElement> ColsTable = RowsTable.get(i).findElements(By.tagName('td'))
			if (ColsTable.get(4).getText().equalsIgnoreCase("Permintaan Kartu Baru")) {
				ColsTable.get(1).findElement(By.tagName('a')).click()
				headerDetailAssignCard = WebUI.getText(txtHeaderAddCardNumber)
				if (headerDetailAssignCard.equalsIgnoreCase("Detil Nasabah")) {
					RequestId = WebUI.getText(txtReqIdAssignCard)
				} else {keyLogger.markError("We are not in Detail Card Number")}
			} else {keyLogger.markError("We are wrong text")}
			if (WebUI.verifyElementVisible(btnKirim)) {
				WebUI.click(btnKirim)
				WebUI.click(btnBackToCardManagementList)
				keyLogger.logInfo("We already sent the request Id")
				break LoopCondition
			} else {
				keyLogger.logInfo("We must check another Request Id")
				WebUI.click(btnBackAssignCard)
				tblAssignCard = driverAssignCard.findElement(By.xpath('//table/tbody'))
				RowsTable = tblAssignCard.findElements(By.tagName('tr'))
			}
		}
	} else {keyLogger.markError("Drop didn't apprear")}
}

/* We want to set variable request Id from assign card*/
requestIdAssignCard = RequestId
println(requestIdAssignCard)

/* We want direct to menu card printing*/
if (WebUI.verifyElementVisible(linkCardPrinting,FailureHandling.OPTIONAL)) {
	WebUI.click(linkCardPrinting)
	keyLogger.logInfo("We are in menu card printing")
} else {
	WebUI.verifyElementVisible(menuCardManagement)
	WebUI.click(linkCardPrinting)
	keyLogger.logInfo("We are in menu card printing")
}

WebDriver driverPrintCard = DriverFactory.getWebDriver()
WebElement tblPrintCard
List<WebElement> RowsPrintCard
/* We want to print card from request Id*/
LoopConditionPrintCard:
while (flagConditionPrintCard == false) {
	tblPrintCard = driverPrintCard.findElement(By.xpath('//table/tbody'))
	 RowsPrintCard = tblPrintCard.findElements(By.tagName('tr'))
	for (int j = 0;j < RowsPrintCard.size() ; j++) {
	println('No. of rows: ' + RowsPrintCard.size() + 'and check list rows: ' +j)
	List<WebElement> ColsPrintCard = RowsPrintCard.get(j).findElements(By.tagName('td'))
	println('Value of Column is : ' +ColsPrintCard.get(2).getText())
		if (ColsPrintCard.get(2).getText().equalsIgnoreCase(requestIdAssignCard)) {
		 	ColsPrintCard.get(1).findElement(By.tagName('input')).click()
			if (WebUI.verifyElementVisible(btnPrintCard,FailureHandling.OPTIONAL)) {
				WebUI.click(btnPrintCard)
				WebUI.verifyElementPresent(popUpSucccessPrint, 5)
				WebUI.click(btnClosePopUpSuccessPrint)
				break LoopConditionPrintCard
			} else {keyLogger.logInfo("button print card disable")}
		} else {keyLogger.logInfo("we not found RequestId =" +requestIdAssignCard)
			tblPrintCard = driverPrintCard.findElement(By.xpath('//table/tbody'))
			RowsPrintCard = tblPrintCard.findElements(By.tagName('tr'))
		}
	}
}

/* We want to set API testing for enroute route ninja*/
String body = '{"shipper_id": 921,"status": "'+enrouteCurrentStatus+'","shipper_ref_no": "10001253","tracking_ref_no": "10001253","shipper_order_ref_no": "8374","timestamp": "2017-04-03T11:50:44+0800","id": "3b7327b9-54bf-417f-3104-f4e155a22308","previous_status": "'+enroutePrevStatus+'","tracking_id": "AMAR-'+requestIdAssignCard+'","comments": "SG-Singapore-Ninja Van Sorting Facility"}'

/* We want print the body */
println body

/* We want to encrypt the body with SHA256*/
hashNinjaVanVanEnrouteToPickup = SecureUtils.hmac_sha256("cf47ca4e44844cb987eb0577530a12a0",body.toString())

/* We want to store to global variable*/
GlobalVariable.hashNinjaVanVanEnrouteToPickup = hashNinjaVanVanEnrouteToPickup

/* We want to prepare the http request*/
def request = ((findTestObject('API/CRM/API_NinjaVanVanEnrouteToPickup', [('base_url_crm_otoku') : GlobalVariable.baseUrlRegOtoku, ('username') : GlobalVariable.usernameWebApi, ('password') : GlobalVariable.passwordWebApi, ('X-NINJAVAN-HMAC-SHA256') : hashNinjaVanVanEnrouteToPickup])) as RequestObject)
request.setBodyContent(new HttpTextBodyContent(body, 'UTF-8', 'application/json'))

/* We want to send the API process*/
def response = WS.sendRequest(request)

/* We want to get the response*/
def body_content = response.responseBodyContent
def status_code = response.statusCode

/* We want parse response from API process*/
def respDataMap = new JsonSlurper().parseText(body_content)

/* We just check by log*/
println(body_content)

/* We just check by log*/
println(status_code)

/* We want to assert the status code is 200*/
assertThat(response.getStatusCode()).isEqualTo(200)

/* We will refresh the page and wait with timeout is 5 sec */
WebUI.refresh()
WebUI.waitForPageLoad(5)

/* We want to direct to CSR Management to check the Riwayat Pengiriman */
if (WebUI.verifyElementVisible(menuCSRManagement,FailureHandling.OPTIONAL)) {
	WebUI.click(menuCSRManagement)
	if (WebUI.verifyElementVisible(popUpBlock,FailureHandling.OPTIONAL)) {
		WebUI.click(btnBatalBlock)
		WebUI.verifyElementText(wrdHeaderCsrMgt, "CSR Management")
	} else {WebUI.verifyElementText(wrdHeaderCsrMgt, "CSR Management")}
} else {keyLogger.markError("Menu CSR Management didn't show")}

/* We want to check the "Riwayat Pengiriman" with Request ID*/
if (WebUI.verifyElementVisible(fieldReqId,FailureHandling.OPTIONAL)) {
	WebUI.setText(fieldReqId, requestIdAssignCard)
	WebUI.sendKeys(fieldReqId,Keys.chord(Keys.ENTER))
	if (WebUI.verifyElementVisible(btnDetail,FailureHandling.OPTIONAL)) {
		WebUI.click(btnDetail)
		wrdHeaderCsrDetail = WebUI.getText(headerCsrDetail)
		if (wrdHeaderCsrDetail.equalsIgnoreCase("Detil Nasabah")) {
			WebUI.click(linkHistoryDelivery)
			TestObject wrdEnroute = new TestObject().addProperty('text',ConditionType.CONTAINS, wrdInSortHub)
			if (WebUI.verifyElementPresent(wrdEnroute, 5)) {
				WebUI.takeScreenshot()
				WebUI.click(btnBack)
			}
		}
	}
}

/* We want to set API testing for success delivery ninja*/
String bodySuccess = '{"shipper_id":921,"status":"'+successDelStatus+'","previous_status": "'+successPrevStatus+'","shipper_order_ref_no": "8374","timestamp": "2017-04-03T11:50:44+0800","order_id":"3b7327b9-54bf-417f-3104-f4e134ed22308","tracking_id": "AMAR-'+requestIdAssignCard+'","pod":{"type": "SUBSTITUTE","name": "BOCAH BAR BAR","identity_number": "XX","contact": "080989999","uri": "https://tinyurl.com/34cpme86","left_in_safe_place": false}}'
/* We want print the body */
println bodySuccess

/* We want to encrypt the body with SHA256*/
hashNinjaVanSuccessfulDelivery = SecureUtils.hmac_sha256("cf47ca4e44844cb987eb0577530a12a0",bodySuccess.toString())

/* We want to store to global variable*/
GlobalVariable.hashNinjaVanSuccessfulDelivery = hashNinjaVanSuccessfulDelivery

/* We want to prepare the http request*/
def requestSuccess = ((findTestObject('API/CRM/API_ninjaVanSuccessfulDelivery', [('base_url_crm_otoku') : GlobalVariable.baseUrlRegOtoku, ('username') : GlobalVariable.usernameWebApi, ('password') : GlobalVariable.passwordWebApi, ('X-NINJAVAN-HMAC-SHA256') : hashNinjaVanSuccessfulDelivery])) as RequestObject)
requestSuccess.setBodyContent(new HttpTextBodyContent(bodySuccess, 'UTF-8', 'application/json'))

/* We want to send the API process*/
def responseSuccess = WS.sendRequest(requestSuccess)

/* We want to get the response*/
def body_content_success = responseSuccess.responseBodyContent
def status_code_success = responseSuccess.statusCode

/* We want parse response from API process*/
def respDataMapSuccess = new JsonSlurper().parseText(body_content_success)

/* We just check by log*/
println(body_content_success)

/* We just check by log*/
println(status_code_success)

/* We want to assert the status code is 200*/
assertThat(responseSuccess.getStatusCode()).isEqualTo(200)

/* We will refresh the page and wait with timeout is 5 sec */
WebUI.refresh()
WebUI.waitForPageLoad(5)

/* We want to direct to CSR Management to check the Riwayat Pengiriman */
if (WebUI.verifyElementVisible(menuCSRManagement,FailureHandling.OPTIONAL)) {
	WebUI.click(menuCSRManagement)
	if (WebUI.verifyElementVisible(popUpBlock,FailureHandling.OPTIONAL)) {
		WebUI.click(btnBatalBlock)
		WebUI.verifyElementText(wrdHeaderCsrMgt, "CSR Management")
	} else {WebUI.verifyElementText(wrdHeaderCsrMgt, "CSR Management")}
} else {keyLogger.markError("Menu CSR Management didn't show")}

/* We want to check the "Riwayat Pengiriman" with Request ID*/
if (WebUI.verifyElementVisible(fieldReqId,FailureHandling.OPTIONAL)) {
	WebUI.setText(fieldReqId, requestIdAssignCard)
	WebUI.sendKeys(fieldReqId,Keys.chord(Keys.ENTER))
	if (WebUI.verifyElementVisible(btnDetail,FailureHandling.OPTIONAL)) {
		WebUI.click(btnDetail)
		wrdHeaderCsrDetail = WebUI.getText(headerCsrDetail)
		if (wrdHeaderCsrDetail.equalsIgnoreCase("Detil Nasabah")) {
			WebUI.click(linkHistoryDelivery)
			TestObject wrdEnroute = new TestObject().addProperty('text',ConditionType.CONTAINS, wrdInSuccessDelivery)
			if (WebUI.verifyElementPresent(wrdEnroute, 5)) {
				WebUI.takeScreenshot()
				WebUI.click(btnBack)
			}
		}
	}
}