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

/* We will verify if checkbox 'Pilih Semua' was checked
 * and save the value boolean into variable 'check'*/
boolean check = WebUI.verifyElementChecked(chkAllReprint, 10)

/* The purpose of this conditional is to check if
 * the checkbox 'Pilih Semua' in condition checked, 
 * then it will continue to uncheck all the checkbox.
 * If not, it will not uncheck the checkbox */
if(check == true) {
	/* We will click checkbox 'Pilih Semua' to uncheck*/
	WebUI.click(chkAllReprint)
	
	/* We will verify if all the checkbox is unchecked */
	for(int i=0;i<listCheckBoxReprint.size();i++) {
		WebUI.verifyElementNotChecked(listCheckBoxReprint.get(i), 10)
	}
}

/* We will verify if button 'Cetak ulang'is disabled */
WebUI.verifyElementNotClickable(btnReprintCard)