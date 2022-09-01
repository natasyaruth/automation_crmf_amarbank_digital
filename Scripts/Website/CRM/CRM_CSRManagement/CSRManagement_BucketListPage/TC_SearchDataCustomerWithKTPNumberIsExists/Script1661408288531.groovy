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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil
import org.bouncycastle.crypto.ec.CustomNamedCurves
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

/*'Declaration keylog forloggin'*/
KeywordUtil keyLogger = new KeywordUtil()

WebUI.waitForElementPresent(table, 10)

WebUI.setText(fieldKTP, ktpNumber)

WebUI.sendKeys(fieldKTP, Keys.chord(Keys.ENTER))

boolean isObjectNotFound = WebUI.waitForElementPresent(objectNotFound, 3)
	
if(isObjectNotFound) {
	
	WebUI.takeScreenshot()
	keyLogger.markFailed("Customer with KTP Number "+ktpNumber+" is not found")
	
} else {
	
	WebDriver driver = DriverFactory.getWebDriver()
	
	/* We will declarated variable 'tableCSR' to store the location of the table*/
    WebElement tableCSR = driver.findElement(By.xpath('//tbody'))

    /* We will declarated variable 'listRows' with type List to store
    all the element with tag 'tr' which means element that represent rows*/
    List<WebElement> listRows = tableCSR.findElements(By.tagName('tr'))

    List<WebElement> listColumn = listRows.get(0).findElements(By.tagName('td'))
	
	actCustName = listColumn.get(1).getText()
	
	if(actCustName.equals(custName)) {
		
		keyLogger.markPassed("Customer with KTP Number "+ktpNumber+" is found")
		
	} else {
		
		WebUI.takeScreenshot()
		keyLogger.markFailed("Name customer with KTP Number "+ktpNumber+" is not same")
		
		println "Actual customer name: "+actCustName+"\n"
                "Expected customer name: "+custName
	}
}

