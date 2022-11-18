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

/* We will click tab 'Cetak ulang' */
WebUI.click(tabCardReprint)

/* We will wait until table 'Cetak ulang' is appear */
WebUI.waitForElementPresent(table, 10)

/* We will declarated variable 'driverReprint' and 'driverReceipt'
 * to store function of webdriver.
 * We used webdriver to counting rows of the table */
WebDriver driverReprint = DriverFactory.getWebDriver()
WebDriver driverReceipt = DriverFactory.getWebDriver()

/* We will declarated variable 'tableReprint' to store the location of the table*/
WebElement tableReprint = driverReprint.findElement(By.xpath('//tbody'))

/* We will declarated variable 'listRowsReprint' with type List to store
 all the element with tag 'tr' which means element that represent rows*/
List<WebElement> listRowsReprint = tableReprint.findElements(By.tagName('tr'))

/* We will declarated variable 'listColumnReprint' with type List to store
 all the element with tag 'td' which means element that represent column*/
List<WebElement> listColumnReprint

/* This loop represent the looping for table Reprint card to search the request id that might be
 * never been used to Pending Pickup by comparing to table Receipt*/

/* Initiate the loop process with name 'LoopReprint'.
 * This loop will run until flagNextPageReprint change into 'true'*/
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
		WebUI.click(tabReceipt)

		/* We will wait until table 'Resi' is appear */
		WebUI.waitForElementPresent(table, 10)

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
					WebUI.waitForElementPresent(table, 10)

					/* Break the loop 'LoopReprint' */
					break LoopReprint
				}
			}
			
			/* This conditional represent if the request id is not found in the Receipt bucketlist,
			 * system will direct to the next page to searching. But if the request id still not found,
			 * system will back to Tab Reprint card to search other request id */
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

					/* We will wait until table 'Cetak ulang' is appear */
					WebUI.waitForElementPresent(table, 10)

					/* Storing again tableReprint to prevent the stale element */
					tableReprint = driverReprint.findElement(By.xpath('//tbody'))

					/* Storing again listRowsReprint to prevent the stale element */
					listRowsReprint = tableReprint.findElements(By.tagName('tr'))

					/* Break the loop 'LoopReceipt' */
					break LoopReceipt
					
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
	 * system will print to console that all request id already process in Receipt bucketlist*/
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

			/* Assert flagNextPageReprint into true*/
			flagNextPageReprint = true
			
		} else {
			
			/* We will click the next page */
			WebUI.click(btnNextPageReprint)

			/* We will wait for 3 second till page finish load*/
			WebUI.waitForPageLoad(3)
		}
	}
}

/* Store value requestIdReprint into requestId */
requestId = requestIdReprint

/* We want to set API testing for enroute route ninja*/
String body = '{"shipper_id": 921,"status": "'+currentStatus+'","shipper_ref_no": "10001253","tracking_ref_no": "10001253","shipper_order_ref_no": "8374","timestamp": "2017-04-03T11:50:44+0800","id": "3b7327b9-54bf-417f-3104-f4e155a22308","previous_status": "'+previousStatus+'","tracking_id": "AMAR-'+requestId+'","comments": "SG-Singapore-Ninja Van Sorting Facility"}'

/* We want print the body*/
println body

/* We want to encrypt the body with SHA256*/
hashNinjaVanPickupFailed = SecureUtils.hmac_sha256("cf47ca4e44844cb987eb0577530a12a0",body.toString())

/* We want to store to global variable*/
GlobalVariable.hashNinjaVanPickupFailed = hashNinjaVanPickupFailed

/* We want to prepare the http request*/
def request = ((findTestObject('API/CRM/API_NinjaVanPickupFailed', [('base_url_crm_otoku') : GlobalVariable.baseUrlRegOtoku, ('username') : GlobalVariable.usernameWebApi, ('password') : GlobalVariable.passwordWebApi, ('X-NINJAVAN-HMAC-SHA256') : hashNinjaVanPickupFailed])) as RequestObject)
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

/* Storing again tableReceipt to prevent the stale element */
tableRePrint = driverReprint.findElement(By.xpath('//tbody'))

/* Storing again listRowsReceipt to prevent the stale element */
listRowsReprint = tableRePrint.findElements(By.tagName('tr'))

/* Set flagNextPageReprint into false*/
flagNextPageReprint = false

/* Initiate the loop process with name 'LoopReprint'.
 * This loop will run until flagNextPageReprint change into 'true'*/
LoopReprint:
while (flagNextPageReprint == false) {
	
	/* Looping through number of rows of bucketlist Reprint card*/
	for (int a = 0; a < listRowsReprint.size(); a++) {
		
		/* Declarate and store column from listRowsReprint*/
		listColumnReprint = listRowsReprint.get(a).findElements(By.tagName('td'))

		/* Insert value requestIdReprint by get the text request id from bucketlist Reprint.
		 * As we see that column Request id is on index 2 in the table*/
		requestIdReprint = listColumnReprint.get(2).getText()

		/* Assert if the request id from the Looping before is same with the request id in Reprint card*/
		if (requestIdReprint == requestId) {
			
			/* Print info into console*/
			println 'request id: '+requestId+' still in the tab Reprint card'
			
			/* Break the loop 'Loop' */
			break LoopReprint
		}
	}
	
	/* This conditional represent if the request id is not found in the current page Reprint card bucketlist,
	 * system will direct to the next page to searching, but if it's still not found,
	 * system will assert that the request id is move from Reprint card table */
	if (flagNextPageReprint == false) {
		
		/* Define variable 'expectedFirstReprint' and store the current page */
		def expectedFirstReprint = WebUI.getText(txtFirstPage)

		/* Define variable 'expectedFirstReprint' and store the last page */
		def expectedLastReprint = WebUI.getText(txtLastPage)

		/* This conditional represent if it's on the last page,
		 * system will stop the looping by change the flag loop 'flagNextPageReprint' into true.
		 * But if it still not in the last page, it will go to the next page */
		if (expectedFirstReprint.equals(expectedLastReprint)) {
			
			/* Assert flagNextPageReprint into true*/
			flagNextPageReprint = true
			
			/* Print info into console*/
			println 'request id: '+requestId+' is move from Reprint card'
		} else {
			
			/* We will click the next page */
			WebUI.click(btnNextPageReprint)

			/* We will wait for 3 second till page finish load*/
			WebUI.waitForPageLoad(3)
		}
	}
}

/* We will click tab 'Resi' */
WebUI.click(tabReceipt)

/* We will wait until table 'Resi' is appear */
WebUI.waitForElementPresent(table, 10)

/* Storing again tableReceipt to prevent the stale element */
tableReceipt = driverReceipt.findElement(By.xpath('//tbody'))

/* Storing again listRowsReceipt to prevent the stale element */
listRowsReceipt = tableReceipt.findElements(By.tagName('tr'))

/* Set flagNextPageReceipt into false*/
flagNextPageReceipt == false

/* Initiate the loop process with name 'LoopReceipt'.
 * This loop will run until flagNextPageReceipt change into 'true'*/
LoopReceipt:
while (flagNextPageReceipt == false) {
	
	/* Looping through number of rows of bucketlist Receipt*/
	for (int a = 0; a < listRowsReceipt.size(); a++) {
		
		/* Declarate and store column from listRowsReceipt*/
		listColumnReceipt = listRowsReceipt.get(a).findElements(By.tagName('td'))

		/* Insert value requestIdReceipt by get the text request id from bucketlist Receipt.
		 * As we see that column Request id is on index 2 in the table*/
		requestIdReceipt = listColumnReceipt.get(2).getText()

		/* Assert if the request id from the Looping before is same with the request id in Receipt*/
		if (requestIdReceipt == requestId) {
			
			/* Print info into console*/
			println 'request id: '+requestId+' still in the tab Receipt'
			
			/* Break the loop 'LoopReceipt' */
			break LoopReceipt
		}
	}
	
	/* This conditional represent if the request id is not found in the current page Receipt bucketlist,
	 * system will direct to the next page to searching, but if it's still not found,
	 * system will assert that the request id is move from Receipt table */
	if (flagNextPageReceipt == false) {
		
		/* Define variable 'expectedFirstReceipt' and store the current page */
		def expectedFirstReceipt = WebUI.getText(txtFirstPage)

		/* Define variable 'expectedLastReceipt' and store the last page */
		def expectedLastReceipt = WebUI.getText(txtLastPage)

		/* This conditional represent if it's on the last page,
		 * system will stop the looping by change the flag loop 'flagNextPageReceipt' into true.
		 * But if it still not in the last page, it will go to the next page */
		if (expectedFirstReceipt.equals(expectedLastReceipt)) {
			
			/* Assert flagNextPageReceipt into true*/
			flagNextPageReceipt = true
			
			/* Print info into console*/
			println 'request id: '+requestId+' is move from Receipt'
			
		} else {
			
			/* We will click the next page */
			WebUI.click(btnNextPageReceipt)

			/* We will wait for 3 second till page finish load*/
			WebUI.waitForPageLoad(3)
		}
	}
}