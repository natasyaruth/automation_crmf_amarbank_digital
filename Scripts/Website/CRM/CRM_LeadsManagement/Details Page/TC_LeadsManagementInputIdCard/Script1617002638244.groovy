import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.util.concurrent.ThreadLocalRandom
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
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnDataKtp'))

WebUI.verifyElementClickable(findTestObject('Website/CRM/Leads_Management/Detail/BtnEditKtp'))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnEditKtp'))

long minNumber = 1000_0000_0000_0000L;
long maxNumber =  9999_9999_9999_9999L;

long inputNumber = ThreadLocalRandom.current().nextLong(minNumber, maxNumber+1);

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtKtpNumber'), inputNumber.toString())

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtKtpName'), name)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtKtpBirthPlace'), birthPlace)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/DtpKTPBirthDate'), birthDate)

WebUI.sendKeys(findTestObject('Website/CRM/Leads_Management/Detail/DtpKTPBirthDate'), Keys.chord(Keys.ENTER))

WebUI.selectOptionByValue(findTestObject('Website/CRM/Leads_Management/Detail/DrpKtpGender'), gender, false)

WebUI.sendKeys(findTestObject('Website/CRM/Leads_Management/Detail/DrpKtpGender'), Keys.chord(Keys.ENTER))

WebUI.selectOptionByValue(findTestObject('Website/CRM/Leads_Management/Detail/DrpKtpBloodType'), bloodType, false)

WebUI.sendKeys(findTestObject('Website/CRM/Leads_Management/Detail/DrpKtpBloodType'), Keys.chord(Keys.ENTER))

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtKtpAddress'), address)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtKtpNeighbourhood'), ktpNeighbourhood)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtKtpHamlet'), ktpHamlet)

WebUI.setText(findTestObject('Website/CRM/Leads_Management/Detail/TxtKtpVillage'), village)

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/ListVillageResult', ['index' : GlobalVariable.indexVillage]))

WebUI.selectOptionByValue(findTestObject('Website/CRM/Leads_Management/Detail/DrpKtpReligion'), religion, false)

WebUI.sendKeys(findTestObject('Website/CRM/Leads_Management/Detail/DrpKtpReligion'), Keys.chord(Keys.ENTER))

WebUI.selectOptionByValue(findTestObject('Website/CRM/Leads_Management/Detail/DrpKtpMaritalStatus'), maritalStatus, false)

WebUI.sendKeys(findTestObject('Website/CRM/Leads_Management/Detail/DrpKtpMaritalStatus'), Keys.chord(Keys.ENTER))

WebUI.selectOptionByValue(findTestObject('Website/CRM/Leads_Management/Detail/DrpKtpOccupation'), occupation, false)

WebUI.sendKeys(findTestObject('Website/CRM/Leads_Management/Detail/DrpKtpOccupation'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnSaveKtp'))

WebUI.verifyTextPresent(msgSuccess, false)