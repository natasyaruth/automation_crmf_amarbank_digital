import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.util.concurrent.locks.Condition as Condition
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.org.apache.bcel.internal.generic.RETURN as RETURN
import groovy.transform.ConditionalInterrupt as ConditionalInterrupt
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.remote.server.handler.RefreshPage as RefreshPage
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.github.javafaker.Faker as Faker

/* We want setup faker for name */
Faker faker = new Faker()
String fullName = faker.name().fullName()

/*Declaration keylog forloggin*/
KeywordUtil keyLogger = new KeywordUtil()

/*'We want to makesure we can access CSR Management'*/
boolean checkMenuCsr = WebUI.verifyElementVisible(menuCSRManagement, FailureHandling.OPTIONAL)

if (checkMenuCsr == true) {
    WebUI.click(menuCSRManagement)
} else {
    keyLogger.markFailed('Something happen with menu CSR Management')
}

WebUI.delay(5)
/*'We want to check blocked notification and check for text blocked
 * if alert confirmation pop up enable is true'*/
if (WebUI.waitForElementVisible(blockBylockedUserElement, 5, FailureHandling.OPTIONAL)) {
    boolean checkAlertProcess = WebUI.verifyElementVisible(alertConfirmationPopUpElement)

    if (checkAlertProcess == true) {
        WebUI.verifyElementText(alertConfirmationPopUpElement, alertConfirmationPopUpText)

        WebUI.click(btnCancelPopUpElement)

        if (WebUI.waitForElementVisible(headerCSRManagementElement, 5, FailureHandling.OPTIONAL)) {
            WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
        } else {
            (txtCsrManagement == false).call({ 
                    keyLogger.loginfo('We not find the element')
                })
        }
    } else {
        keyLogger.markFailed('We don\'t find alert confirmation')
    }
    
    WebUI.waitForElementVisible(headerCSRManagementElement, 5)

    WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
} else {
    WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
}

/* We want to check status is customer type is "Nasabah Senyumku"*/
for (int i = 0; i < customerType.size(); i++) {
    boolean filterChooseCard = WebUI.verifyElementVisible(drpDwnCardStatus)

    if (filterChooseCard == true) {
        WebUI.selectOptionByLabel(drpDwnCardStatus, 'Nasabah Senyumku', false)

        if (WebUI.verifyElementVisible(drpDwnCustType, FailureHandling.OPTIONAL)) {
            WebUI.selectOptionByLabel(drpDwnCustType, customerType.get(i), false)
        } else {
            keyLogger.markFailed('We not find the drop down by cust type')
        }
        
        WebUI.navigateToUrl(GlobalVariable.requestStatusFinishCondition.get(i))
    } else {
        keyLogger.markFailed('We don\'t find the drop down Card Status')
    }
	
	WebUI.delay(5)
    /*We want check filter "Semua" in change log*/
    if (WebUI.waitForElementVisible(SectionChangelog, 5)) {
        boolean changeLogActivity = WebUI.verifyElementText(SectionChangelog, 'Change Log')

        if (changeLogActivity == true) {
            WebUI.click(SectionChangelog)

            int optionListLength = 3

            Random rand = new Random()

            String index = rand.nextInt(optionListLength + 1)

            if (WebUI.waitForElementVisible(DrpFilterActions, 5, FailureHandling.OPTIONAL)) {
						WebUI.selectOptionByIndex(DrpFilterActions, 'Viewed')
						WebUI.verifyElementText(DrpFilterActions, 'Viewed')
					} else {keyLogger.logInfo("We Not find the filter 'Edited'")}


                        WebUI.delay(3)

				WebUI.waitForElementVisible(txtFirstRowChangelogDate, 5)
				WebUI.verifyElementVisible(txtFirstRowChangelogDate,FailureHandling.OPTIONAL)
   
                WebUI.waitForElementVisible(txtFirstRowChangelogField, 5)
				WebUI.verifyElementVisible(txtFirstRowChangelogField,FailureHandling.OPTIONAL)
                
				WebUI.waitForElementVisible(txtFirstRowChangelogOldData, 5)
				WebUI.verifyElementVisible(txtFirstRowChangelogOldData,FailureHandling.OPTIONAL)
				
                WebUI.waitForElementVisible(txtFirstRowChangelogNewData, 5)
				WebUI.verifyElementVisible(txtFirstRowChangelogOldData,FailureHandling.OPTIONAL)

				/*We want verify old action*/
				WebUI.waitForElementVisible(txtFirstRowChangelogActions, 5)
				WebUI.verifyElementVisible(txtFirstRowChangelogActions,FailureHandling.OPTIONAL)
				WebUI.verifyTextPresent(txtFirstRowChangelogActions, 5)

				WebUI.delay(5)

				WebUI.takeScreenshot()

				WebUI.waitForElementVisible(btnBackToBucketList, 5)

				WebUI.click(btnBackToBucketList)

				if (WebUI.waitForElementVisible(headerCSRManagementElement, 5, FailureHandling.OPTIONAL)) {
					WebUI.verifyElementText(headerCSRManagementElement, headerCSRManagementText)
					} else {
					keyLogger.loginfo('We not find the element')
					}
    
				WebUI.refresh()

				WebUI.waitForPageLoad(50)
                }
                }
            }