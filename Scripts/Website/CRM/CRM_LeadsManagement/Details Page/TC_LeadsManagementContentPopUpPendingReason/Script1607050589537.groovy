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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

WebUI.verifyTextPresent(headerCustomerDetail, false)

WebDriver driver = DriverFactory.getWebDriver()

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnOpenPendingModal'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/Leads_Management/Detail/HeaderChangeSchedule'), 5)

WebElement testLblValue
int tempArray = 1
for(int i=0;i<listElement.size();i++){
	String testObject = 'Website/CRM/Leads_Management/Detail/'+listElement.get(i)
	testLblValue = driver.findElement(By.xpath('//*[@id="outer-root"]//div['+tempArray+']/label'))
		
	WebUI.verifyElementVisible(findTestObject(testObject))
	WebUI.verifyEqual(testLblValue.getText(),listValue.get(i))
	tempArray++
}

WebUI.verifyElementNotClickable(findTestObject('Website/CRM/Leads_Management/Detail/BtnSubmitPendingConfirmation'))

WebUI.verifyElementClickable(findTestObject('Website/CRM/Leads_Management/Detail/BtnCancelPendingConfirmation'))

def inputDate = new Date()

def calendar = Calendar.getInstance()

calendar.setTime(inputDate)

calendar.add(Calendar.DATE, 1)

inputDate = calendar.getTime().format('dd/MM/yyyy')+' 0:00'

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/DrpPendingSchedule'), inputDate)

WebUI.sendKeys(findTestObject('Website/CRM/Leads_Management/Detail/DrpPendingSchedule'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/ChkOther'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/Leads_Management/Detail/TxtPendingReason'), 5)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtPendingReason'), inputText)

WebUI.verifyElementClickable(findTestObject('Website/CRM/Leads_Management/Detail/BtnSubmitPendingConfirmation'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnCancelPendingConfirmation'))

WebUI.waitForElementNotVisible(findTestObject('Website/CRM/Leads_Management/Detail/HeaderChangeSchedule'), 5)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnOpenPendingModal'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/Leads_Management/Detail/TxtPendingReason'), 5)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnCancelPendingConfirmation'))

WebUI.waitForElementNotVisible(findTestObject('Website/CRM/Leads_Management/Detail/TxtPendingReason'), 5)
