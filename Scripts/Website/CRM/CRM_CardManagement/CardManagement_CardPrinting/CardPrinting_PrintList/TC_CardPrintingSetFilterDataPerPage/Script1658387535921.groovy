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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

/* We will click tab 'Prinlist'*/
WebUI.click(tabPrintList)

/* We will declarated variable 'driver' to store function of webdriver. 
 * We used webdriver to counting rows of the table*/
WebDriver driver = DriverFactory.getWebDriver()

/* We will declarated variable 'table' to store the location of the table*/
WebElement table = driver.findElement(By.xpath('//*[@id="root"]//table/tbody'))

/* We will declarated variable 'listRows' with type List to store 
   all the element with tag 'tr' which means element that represent rows*/
List<WebElement> listRows = table.findElements(By.tagName('tr'))

/* This is a function to looping data number per page based on the value in the filter.
   Conditional 'if' represent number of rows in the bucketlist should be 
   same with selected value in the filter or it would be go to 'else'
   that represent number of rows in the bucketlist should be 
   less than selected value in the filter */
for(int i=0;i<listNumberOfData.size();i++) {
	WebUI.selectOptionByValue(drpDataPageInPrint, listNumberOfData.get(i), false)
	numberOfData = listRows.size()
	if(numberOfData.toString() ==  listNumberOfData.get(i)){
		WebUI.verifyEqual(numberOfData, listNumberOfData.get(i))
	} else {
		WebUI.verifyLessThan(numberOfData, listNumberOfData.get(i))
	}
}