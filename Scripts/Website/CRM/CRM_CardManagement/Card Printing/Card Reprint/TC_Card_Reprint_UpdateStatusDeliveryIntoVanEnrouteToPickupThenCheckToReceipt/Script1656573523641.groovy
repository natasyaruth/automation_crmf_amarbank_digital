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
import com.tunaiku.keyword.HashingNinjaVanStatus as HashingNinjaVanStatus
import com.tunaiku.keyword.SecureUtils as SecureUtils
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonSlurper
import static org.assertj.core.api.Assertions.*
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.testobject.internal.impl.HttpBodyContentReader

/* We will click tab 'Cetak ulang' */
WebUI.click(tabCardReprint)

WebUI.waitForElementPresent(table, 10)

/* We will declarated variable 'driver' to store function of webdriver.
 * We used webdriver to counting rows of the table */
WebDriver driverReprint = DriverFactory.getWebDriver()

WebDriver driverReceipt = DriverFactory.getWebDriver()

/* We will declarated variable 'tableReprint' and 'tableReceipt' to store the location of the table*/
/* We will declarated variable 'listRowsReprint' and 'listRowsReceipt' with type List to store
   all the element with tag 'tr' which means element that represent rows*/
/* We will declarated variable 'listColumn' with type List to store
 all the element with tag 'td' which means element that represent column*/
WebElement tableReprint = driverReprint.findElement(By.xpath('//tbody'))

List<WebElement> listRowsReprint = tableReprint.findElements(By.tagName('tr'))

List<WebElement> listColumnReprint

LoopReprint: 
while (flagNextPageReprint == false) {
    for (int i = 0; i < listRowsReprint.size(); i++) {
        listColumnReprint = listRowsReprint.get(i).findElements(By.tagName('td'))

        requestIdReprint = listColumnReprint.get(2).getText()

        WebUI.click(tabReceipt)

        WebUI.waitForElementPresent(table, 10)

        LoopReceipt: 
		while (flagNextPageReceipt == false) {
            WebElement tableReceipt = driverReceipt.findElement(By.xpath('//tbody'))

            List<WebElement> listRowsReceipt = tableReceipt.findElements(By.tagName('tr'))

            for (int j = 0; j < listRowsReceipt.size(); j++) {
                List<WebElement> listColumnReceipt = listRowsReceipt.get(j).findElements(By.tagName('td'))

                requestIdReceipt = listColumnReceipt.get(2).getText()

                if (requestIdReceipt == requestIdReprint) {
                    println(requestIdReceipt)

                    println(requestIdReprint)

                    WebUI.click(tabCardReprint)

                    WebUI.waitForElementPresent(table, 10)

                    break LoopReprint
                }
            }
            
            if (flagNextPageReceipt == false) {
                def expectedFirstReceipt = WebUI.getText(txtFirstPage)

                def expectedLastReceipt = WebUI.getText(txtLastPage)

                if (expectedFirstReceipt.equals(expectedLastReceipt)) {
                    WebUI.click(tabCardReprint)

                    WebUI.waitForElementPresent(table, 10)

                    tableReprint = driverReprint.findElement(By.xpath('//tbody'))

                    listRowsReprint = tableReprint.findElements(By.tagName('tr'))

                    break LoopReceipt
                } else {
                    WebUI.click(btnNextPageReceipt)

                    WebUI.waitForPageLoad(3)
                }
            }
        }
    }
    
    if (flagNextPageReprint == false) {
        def expectedFirstReprint = WebUI.getText(txtFirstPage)

        def expectedLastReprint = WebUI.getText(txtLastPage)

        if (expectedFirstReprint.equals(expectedLastReprint)) {
            println('All the request id in Reprint card bucketlist already process in Receipt bucketlist')

            flagNextPageReprint = true
        } else {
            WebUI.click(btnNextPageReprint)

            WebUI.waitForPageLoad(3)
        }
    }
}

println requestIdReprint

requestId = requestIdReprint

/* We want to set API testing for enroute route ninja*/
String body = '{"shipper_id": 921,"status": "'+currentStatus+'","shipper_ref_no": "10001253","tracking_ref_no": "10001253","shipper_order_ref_no": "8374","timestamp": "2017-04-03T11:50:44+0800","id": "3b7327b9-54bf-417f-3104-f4e155a22308","previous_status": "'+previousStatus+'","tracking_id": "AMAR-'+requestId+'","comments": "SG-Singapore-Ninja Van Sorting Facility"}'
/* We want to encrypt the body with SHA256*/
println body
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

WebUI.click(tabReceipt)

tableReceipt = driverReceipt.findElement(By.xpath('//tbody'))

listRowsReceipt = tableReceipt.findElements(By.tagName('tr'))

flagNextPageReceipt = false
flagNextPageReprint = false

Loop: 
while (flagNextPageReceipt == false) {
	
	for (int a = 0; a < listRowsReceipt.size(); a++) {
		listColumnReceipt = listRowsReceipt.get(a).findElements(By.tagName('td'))

		requestIdReceipt = listColumnReceipt.get(2).getText()

		if (requestIdReceipt == requestId) {
			println 'request id: '+requestId+' still in the tab receipt'
			
			WebUI.click(tabCardReprint)
			
			WebUI.waitForElementPresent(table, 10)
			
			tableReprint = driverReprint.findElement(By.xpath('//tbody'))
			
			listRowsReprint = tableReprint.findElements(By.tagName('tr'))
			
			for (int b = 0; b < listRowsReprint.size(); b++) {
				listColumnReprint = listRowsReprint.get(b).findElements(By.tagName('td'))
		
				requestIdReprint = listColumnReprint.get(2).getText()
				
				if (requestIdReprint == requestId) {
					println 'request id: '+requestIdReceipt+' still in the tab reprint'
					break Loop
				} 
			}
			if (flagNextPageReprint == false) {
				def expectedFirstReceipt = WebUI.getText(txtFirstPage)
		
				def expectedLastReceipt = WebUI.getText(txtLastPage)
		
				if (expectedFirstReceipt.equals(expectedLastReceipt)) {
					flagNextPageReceipt = true
					println 'request id: '+requestId+' is move from Receipt'
				} else {
					WebUI.click(btnNextPageReceipt)
		
					WebUI.waitForPageLoad(3)
				}
			}
			
		}
	}
	if (flagNextPageReceipt == false) {
		def expectedFirstReceipt = WebUI.getText(txtFirstPage)

		def expectedLastReceipt = WebUI.getText(txtLastPage)

		if (expectedFirstReceipt.equals(expectedLastReceipt)) {
			flagNextPageReceipt = true
			println 'request id: '+requestId+' is move from Receipt'
		} else {
			WebUI.click(btnNextPageReceipt)

			WebUI.waitForPageLoad(3)
		}
	}
}