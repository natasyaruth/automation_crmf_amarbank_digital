import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

def data = findTestData('Data Files/Website/DataFiles_CRM/Data_CRM_Login/Data_Login_NegativeTest')

for (def rows : (1..data.getRowNumbers() - 7)) {
	println('Data - ' + rows)

	println('Isi Datanya = ' + data.getObjectValue('Username', rows))
	
	if (data.getObjectValue('Username', rows) == null) {
		WebUI.setText(findTestObject('Object Repository/Website/CRM/Login/Txt_Username'), 'TEST BLANK FIELD', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.sendKeys(findTestObject('Object Repository/Website/CRM/Login/Txt_Username'), Keys.chord(Keys.CONTROL, 'a', Keys.DELETE))

		WebUI.delay(2)
	} else {
		WebUI.setText(findTestObject('Object Repository/Website/CRM/Login/Txt_Username'), data.getObjectValue('Username', rows),
			FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	WebUI.sendKeys(findTestObject('Object Repository/Website/CRM/Login/Txt_Username'), Keys.chord(Keys.TAB))

	String actual = WebUI.getText(findTestObject('Object Repository/Website/CRM/Login/ErrorMessageUsername'), FailureHandling.CONTINUE_ON_FAILURE)

	String expected_value = data.getObjectValue('Error_Message', rows)

	println('Actual Value : ' + actual)

	println('Expected Value :' + expected_value)

	WebUI.verifyMatch(actual, expected_value, false, FailureHandling.CONTINUE_ON_FAILURE)
}

for (def rows : (5..data.getRowNumbers() - 2)) {
	println('Data - ' + rows)

	println('Isi Datanya = ' + data.getObjectValue('Password', rows))

	WebUI.sendKeys(findTestObject('Object Repository/Website/CRM/Login/Txt_Password'), Keys.chord(Keys.CONTROL, 'a', Keys.DELETE), )
	
	if (data.getObjectValue('Password', rows) == null) {
		WebUI.setText(findTestObject('Object Repository/Website/CRM/Login/Txt_Password'), 'TEST BLANK FIELD', FailureHandling.CONTINUE_ON_FAILURE)

		WebUI.sendKeys(findTestObject('Object Repository/Website/CRM/Login/Txt_Password'), Keys.chord(Keys.CONTROL, 'a', Keys.DELETE))

		WebUI.delay(2)
	} else {
		WebUI.setText(findTestObject('Object Repository/Website/CRM/Login/Txt_Password'), data.getObjectValue('Password', rows),
			FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	WebUI.sendKeys(findTestObject('Object Repository/Website/CRM/Login/Txt_Password'), Keys.chord(Keys.TAB))

	String actual = WebUI.getText(findTestObject('Object Repository/Website/CRM/Login/ErrorMessagePassword'), FailureHandling.CONTINUE_ON_FAILURE)

	String expected_value = data.getObjectValue('Error_Message', rows)

	println('Actual Value : ' + actual)

	println('Expected Value :' + expected_value)

	WebUI.verifyMatch(actual, expected_value, false, FailureHandling.CONTINUE_ON_FAILURE)
}

for (def rows : (10..data.getRowNumbers() - 1)) {
	println('Data - ' + rows)

	println('Isi Data 1 = ' + data.getObjectValue('Username', rows))
	println('Isi Data 2 = ' + data.getObjectValue('Password', rows))

	WebUI.setText(findTestObject('Object Repository/Website/CRM/Login/Txt_Username'), data.getObjectValue('Username', rows),
		FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.setText(findTestObject('Object Repository/Website/CRM/Login/Txt_Password'), data.getObjectValue('Password', rows),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('Object Repository/Website/CRM/Login/BtnLogin'))
	
	String actual = WebUI.getText(findTestObject('Object Repository/Website/CRM/Login/ErrorMismatched'), FailureHandling.CONTINUE_ON_FAILURE)

	String expected_value = data.getObjectValue('Error_Message', rows)

	println('Actual Value : ' + actual)

	println('Expected Value :' + expected_value)

	WebUI.verifyMatch(actual, expected_value, false, FailureHandling.CONTINUE_ON_FAILURE)
}

for (def rows : (11..data.getRowNumbers())) {
	println('Data - ' + rows)

	println('Isi Data 1 = ' + data.getObjectValue('Username', rows))
	println('Isi Data 2 = ' + data.getObjectValue('Password', rows))

	WebUI.setText(findTestObject('Object Repository/Website/CRM/Login/Txt_Username'), data.getObjectValue('Username', rows),
		FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.setText(findTestObject('Object Repository/Website/CRM/Login/Txt_Password'), data.getObjectValue('Password', rows),
			FailureHandling.CONTINUE_ON_FAILURE)

	WebUI.click(findTestObject('Object Repository/Website/CRM/Login/BtnLogin'))

	WebUI.verifyTextPresent('Welcome to Senyumku CRM, ' + data.getObjectValue('Username', rows), false)
}
