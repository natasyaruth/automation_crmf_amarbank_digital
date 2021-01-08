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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

WebUI.verifyTextPresent(headerDashboard, false)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYCManagement/LinkKYCManagement'))

WebUI.waitForElementVisible(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkVideoRequest'), 2)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Bucketlist/LinkVideoRequest'))

WebUI.verifyTextPresent(headerKYCVideoRequest, false)

WebDriver driver = DriverFactory.getWebDriver()

WebElement table = driver.findElement(By.xpath('//*[@id="root"]//tbody'))

List<WebElement> listRows = table.findElements(By.tagName('tr'))

List<WebElement> listColumn = listRows.get(0).findElements(By.tagName('td'))

listColumn.get(1).findElement(By.tagName('a')).click()

WebUI.waitForPageLoad(5)

WebUI.verifyTextPresent(headerKYCCustomerDetail, false)

WebUI.click(findTestObject('Website/CRM/Dashboard/CntrPendingRequestNotification'))

<<<<<<< HEAD
WebUI.verifyTextPresent(KYCVideo_Detail, false)
=======
WebUI.waitForElementPresent(findTestObject('Website/CRM/Dashboard/CntrPendingRequestNotification'), 5)
>>>>>>> 1b9eec7791de5d020e96a84c3dda72e2b2d0e4f8

WebUI.waitForPageLoad(10)

WebUI.waitForPageLoad(5)

WebUI.verifyTextPresent(headerKYCCustomerDetail, false)

WebUI.click(findTestObject('Website/CRM/KYC_Management/KYC_Video/Details/BtnBack'))

<<<<<<< HEAD
WebUI.waitForPageLoad(10)

WebUI.verifyTextPresent(KYCVideo_Bucketlist, false)
=======
WebUI.waitForPageLoad(5)

WebUI.verifyTextPresent(headerKYCVideoRequest, false)

>>>>>>> 1b9eec7791de5d020e96a84c3dda72e2b2d0e4f8

