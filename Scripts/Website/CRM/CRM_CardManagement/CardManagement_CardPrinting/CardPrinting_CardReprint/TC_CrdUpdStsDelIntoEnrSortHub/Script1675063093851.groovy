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
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad as WaitForPageToLoad
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.tunaiku.keyword.SecureUtils as SecureUtils
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonSlurper
import static org.assertj.core.api.Assertions.*
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.internal.impl.HttpBodyContentReader
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.ConditionType

/* Declare the key logger*/
KeywordUtil keyLogger = new KeywordUtil()
/* We want to check to access the card printing*/
boolean cardManagement = WebUI.verifyElementVisible(menuCardManagement)
if (cardManagement == true) {
	WebUI.click(menuCardManagement)
	boolean cardPrinting = WebUI.verifyElementVisible(menuCardPrinting)
	if (cardPrinting == true) {
		WebUI.click(menuCardPrinting)
		boolean cardPrintingPage = WebUI.verifyElementText(headerCardPrinting, textPageCardPrinting)
		if (cardPrintingPage) {
			keyLogger.markPassed("We can see the "+textPageCardPrinting+" at the screen")
		} else {keyLogger.markError("The text is "+textPageCardPrinting+" incorrect text")}
	} else {keyLogger.markError("We cannot doing "+menuCardManagement+" to access that")}
} else {keyLogger.markError("We cannot doing "+menuCardPrinting+" to access that")}

/* We want to check data on reprint tab*/
boolean reprintTab = WebUI.verifyElementVisible(reprintTabMenu)
if (reprintTab) {
	WebUI.click(reprintTabMenu)
	boolean dataReprint = WebUI.verifyElementVisible(reprintData)
	if (dataReprint) {
		keyLogger.markPassed("We can see the data "+reprintData+" its correct condition")
	} else {keyLogger.markError("We cannot see load "+reprintData+" on table list")}
} else {keyLogger.markError("We cannot doing with "+reprintTabMenu+" tab is not visible")}

/* Declare to driver reprint and driver receipt*/
WebDriver driverReprint = DriverFactory.getWebDriver()
WebDriver driverReceipt = DriverFactory.getWebDriver()
/* Declare table reprint to store in new variable*/
WebElement tableReprint = driverReprint.findElement(By.xpath('//tbody'))
/* Declare table receipt to store in new variable*/
List<WebElement> listRowsReprint = tableReprint.findElements(By.tagName('tr'))
/* Declare table column to store in variable*/
List<WebElement> listColumntReprint

/* This conditional represent if the request id is not found in the current page Reprint bucketlist,
 * system will direct to the next page to searching, but if it's still not found,
 * system will print to console that all request id already process to Pending Pickup*/
LoopReprint:
while (flagNextPageReprint == false) {
	
	/* Looping through number of rows of bucketlist Reprint card*/
	for (int i = 0; i < listRowsReprint.size(); i++) {
		
		/* Storing column from listRowsReprint*/
		listColumnReprint = listRowsReprint.get(i).findElements(By.tagName('td'))
		
		/* Insert value requestIdReprint by get the text request id from bucketlist Reprint card.
		 * As we see that column Request id is on index 2 in the table*/
		requestIdReprint = listColumnReprint.get(2).getText()

		/* We will click tab 'Resi' */
		WebUI.click(tabReceiptMenu)

		/* We will wait until table 'Resi' is appear */
		WebUI.waitForElementPresent(reprintData, 10)

		/* Initiate the loop process with name 'LoopReceipt'.
		 * This loop will run until flagNextPageReceipt change into 'true'*/
		LoopReceipt:
		while (flagNextPageReceipt == false) {
			
			/* We will declarated variable 'tableReceipt' to store the location of the table*/
			WebElement tableReceipt = driverReceipt.findElement(By.xpath('//tbody'))

			/* We will declarated variable 'listRowsReceipt' with type List to store
			 all the element with tag 'tr' which means element that represent rows*/
			List<WebElement> listRowsReceipt = tableReceipt.findElements(By.tagName('tr'))

			/* Looping through number of rows of bucketlist Receipt card*/
			for (int j = 0; j < listRowsReceipt.size(); j++) {
				
				/* Declarate and store column from listRowsReceipt*/
				List<WebElement> listColumnReceipt = listRowsReceipt.get(j).findElements(By.tagName('td'))

				/* Insert value requestIdReceipt by get the text request id from bucketlist Receipt.
				 * As we see that column Request id is on index 2 in the table*/
				requestIdReceipt = listColumnReceipt.get(2).getText()

				/* Assert if the request id from Reprint card is same with the request id from Receipt*/
				if (requestIdReceipt == requestIdReprint) {
					
					/* Print the requestIdReceipt into console*/
					println(requestIdReceipt)

					/* Print the requestIdReprint into console*/
					println(requestIdReprint)

					/* We will click tab 'Cetak ulang' */
					WebUI.click(tabCardReprint)

					/* We will wait until table 'Cetak ulang' is appear */
					WebUI.waitForElementPresent(reprintData, 10)

					/* Storing again tableReprint to prevent the stale element */
					tableReprint = driverReprint.findElement(By.xpath('//tbody'))

					/* Storing again listRowsReprint to prevent the stale element */
					listRowsReprint = tableReprint.findElements(By.tagName('tr'))

					/* Break the loop 'LoopReceipt' */
					break LoopReceipt
				}
			}
			
			/* This conditional represent if the request id is not found in the current page Receipt bucketlist,
			 * system will direct to the next page to searching, but if it's still not found,
			 * system will back to Tab Reprint card to use the request id */
			if (flagNextPageReceipt == false) {
				
				/* Define variable 'expectedFirstReceipt' and store the current page */
				def expectedFirstReceipt = WebUI.getText(txtFirstPage)

				/* Define variable 'expectedLastReceipt' and store the last page */
				def expectedLastReceipt = WebUI.getText(txtLastPage)

				/* This conditional represent if it's on the last page,
				 * system will back to Tab Reprint to get another request id.
				 * But if it still not in the last page, it will go to the next page */
				if (expectedFirstReceipt.equals(expectedLastReceipt)) {
					
					/* We will click tab 'Cetak ulang' */
					WebUI.click(tabCardReprint)

					/* Break the loop 'LoopReprint' */
					break LoopReprint
					
				} else {
					
					
						/* We will click the next page */
						WebUI.click(btnNextPageReceipt)
	
						/* We will wait for 3 second till page finish load*/
						WebUI.waitForPageLoad(3)
				
				}
			}
		}
	}
	
	/* This conditional represent if the request id is not found in the current page Reprint bucketlist,
	 * system will direct to the next page to searching, but if it's still not found,
	 * system will print to console that all request id already process to Pending Pickup*/
	if (flagNextPageReprint == false) {
		
		/* Define variable 'expectedFirstReceipt' and store the current page */
		def expectedFirstReprint = WebUI.getText(txtFirstPage)

		/* Define variable 'expectedLastReprint' and store the last page */
		def expectedLastReprint = WebUI.getText(txtLastPage)

		/* This conditional represent if it's on the last page,
		 * system will stop the looping by change the flag loop 'flagNextPageReprint' into true.
		 * But if it still not in the last page, it will go to the next page */
		if (expectedFirstReprint.equals(expectedLastReprint)) {
			
			/* Print the info into console*/
			println('All the request id in Reprint card bucketlist already process in Receipt bucketlist')

			/* Set flagNextPageReprint into true*/
			flagNextPageReprint = true
						
		} else {
			
			/* We will click the next page */
			WebUI.click(btnNextPageReprint)
			
			/* We will wait for 3 second till page finish load*/
			WebUI.waitForPageLoad(3)
		}
	}
}
requestId = requestIdReceipt
println(requestId)
/*--------------------------------------------------------------------------------------*/
/* We want to process from Page cetak ulang to delivery status*/
for (int i=0;i<2;i++) {
/* We want to set API testing for enroute route ninja*/
String body = '{"shipper_id": 921,"status": "'+listStatus.get(i)+'","shipper_ref_no": "10001253","tracking_ref_no": "10001253","shipper_order_ref_no": "8374","timestamp": "2017-04-03T11:50:44+0800","id": "3b7327b9-54bf-417f-3104-f4e155a22308","previous_status": "Pending Pickup","tracking_id": "AMAR-'+requestId+'","comments": "SG-Singapore-Ninja Van Sorting Facility"}'
/* We want to encrypt the body with SHA256*/
hashNinjaVanEnRouteToSortingHub = SecureUtils.hmac_sha256("cf47ca4e44844cb987eb0577530a12a0",body.toString())
/* We want to store to global variable*/
GlobalVariable.hashNinjaVanEnRouteToSortingHub = hashNinjaVanEnRouteToSortingHub
/* We want to prepare the http request*/
def request = ((findTestObject('API/CRM/API_NinjaVanEnRouteToSortingHub', [('base_url_crm_otoku') : GlobalVariable.baseUrlRegOtoku, ('username') : GlobalVariable.usernameWebApi, ('password') : GlobalVariable.passwordWebApi, ('X-NINJAVAN-HMAC-SHA256') : hashNinjaVanEnRouteToSortingHub])) as RequestObject)
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
}
/*--------------------------------------------------------------------------------------*/

/*We want to check on cetak ulang and resi request Id is disappear*/
WebUI.delay(5) /*this part i put for give waiting API process*/
/*We want to check on delivery status detail for the available request Id after set to enroute to sorting hub*/
	if (WebUI.verifyElementVisible(deliveryStatusMenu,FailureHandling.OPTIONAL)) {
		WebUI.click(deliveryStatusMenu)
		/* We want to check on delivery status page by header and then check request Id proceed before
		 * then I click the request Id to check the detail based on history delivery*/		
		if (WebUI.verifyElementText(headerDeliveryStatus, "Delivery Status")) {
			WebUI.setText(fieldReqId, requestId)
			WebUI.sendKeys(fieldReqId, Keys.chord(Keys.ENTER))
			WebDriver driver = DriverFactory.getWebDriver()
			WebElement tableDeliveryStatus = driver.findElement(By.xpath('//table/tbody'))
			List<WebElement> Rows = tableDeliveryStatus.findElements(By.tagName('tr'))
			println('No. of rows: ' + Rows.size())
			/* We want to check on table data shown then choose the data if enable*/			
			table: for (int k = 0;k<Rows.size();k++) {
				List<WebElement> Cols = Rows.get(k).findElements(By.tagName('td'))
				for (int l = 0; l < Cols.size();l++) {
					if (Cols.get(l).getText().equalsIgnoreCase(requestId)) {
						Cols.get(1).findElement(By.tagName('a')).click()
						break table }}}
			def headerTextDeliveryDetail = WebUI.getText(headerDeliveryDetail)
			/*We want to check on delivery detail based on text delivery detail and then I will check the message
			 * Dalam perjalanan ke gudang Penyortiran*/			
			if (headerTextDeliveryDetail.contains("Delivery Detail")) {
				TestObject requestIdText = new TestObject().addProperty('text',ConditionType.CONTAINS,requestId)
				validateReqId = WebUI.verifyElementPresent(requestIdText, 5)
				if (WebUI.verifyElementVisible(txtRiwayatKiriman,FailureHandling.OPTIONAL)) {
					TestObject validateEnrouteSortHub = new TestObject().addProperty('text',ConditionType.CONTAINS,statusEnRouteSortHub)
					WebUI.verifyElementPresent(validateEnrouteSortHub, 5)
					WebUI.takeScreenshot()
				} else {keyLogger.markError("We cannot validate request Id")}
			} else {keyLogger.markError("We cannot find text delivery detail")} 
		} else {keyLogger.markError("We cannot find text Delivery Status")}
	} else {
		/*We just handle if we dont see the menu delivery status*/		
		if (WebUI.waitForElementVisible(menuCardManagement, 5)) {
			WebUI.click(menuCardManagement)
			WebUI.click(deliveryStatusMenu)
			if (WebUI.verifyElementText(headerDeliveryStatus, "Delivery Status")) {
				WebUI.setText(fieldReqId, requestId)
				WebUI.sendKeys(fieldReqId, Keys.chord(Keys.ENTER))
				def headerTextDeliveryDetail = WebUI.getText(headerDeliveryDetail)
				if (headerTextDeliveryDetail.contains("Delivery Detail")) {
					TestObject requestIdText = new TestObject().addProperty('text',ConditionType.CONTAINS,requestId)
					boolean validateReqId = WebUI.verifyElementPresent(requestIdText, 5)
					if (validateReqId == true) {
						TestObject validateEnrouteSortHub = new TestObject().addProperty('text',ConditionType.CONTAINS,statusEnRouteSortHub)
						WebUI.verifyElementPresent(validateEnrouteSortHub, 5)
						WebUI.takeScreenshot()
					} else {keyLogger.markError("We cannot validate request Id")}
				} else {keyLogger.markError("We cannot find text delivery detail")}
			} else {keyLogger.markError("We cannot find text Delivery Status")}
		} else {keyLogger.markError("We cannot find the card management menu")}}