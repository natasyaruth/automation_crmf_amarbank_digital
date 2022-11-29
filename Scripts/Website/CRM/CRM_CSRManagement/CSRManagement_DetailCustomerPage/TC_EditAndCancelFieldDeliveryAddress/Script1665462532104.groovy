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
String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
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
        WebUI.selectOptionByLabel(drpDwnCardStatus, 'Semua', false)

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
    /*We want to edit phone number and then click cancel*/
    if (WebUI.waitForElementVisible(elementAddressSentCard, 5)) {
        boolean DeliveryAddress = WebUI.verifyElementText(elementAddressSentCard, 'Alamat Pengiriman Kartu')

        if (DeliveryAddress == true) {
            WebUI.click(elementAddressSentCard)

            int optionListLength = 3

            Random rand = new Random()

            String index = rand.nextInt(optionListLength + 1)

            if (WebUI.waitForElementVisible(txtFullAddress, 5, FailureHandling.OPTIONAL)) {
				
                if (WebUI.verifyElementClickable(btnEditAddressDelivery, FailureHandling.OPTIONAL)) {
                    WebUI.click(btnEditAddressDelivery)
					def Address=WebUI.getText(LabelFullAddress)
					oldData = WebUI.getAttribute(txtFullAddress, 'value')
						if (WebUI.verifyElementVisible(txtFullAddress,FailureHandling.OPTIONAL)) {
						WebUI.setText(txtFullAddress, streetAddress)
						newData = WebUI.getAttribute(txtFullAddress, 'value')
					} else {keyLogger.logInfo("We Not update reference name")

                    if (WebUI.verifyElementVisible(btnCancelAddressDelivery, FailureHandling.OPTIONAL)) {
                        WebUI.takeScreenshot()

                        WebUI.click(btnCancelAddressDelivery)

                        WebUI.delay(3)

					/*Check the changelog after update reference Name*/
				WebUI.click(SectionChangelog)
				/*We want verify date*/
				WebUI.waitForElementVisible(txtFirstRowChangelogDate, 5)
				def currentDate = new Date().format('dd/MM/yyyy')
				println(currentDate)
				dateInChangeLog = WebUI.getText(txtFirstRowChangelogDate)
				println(dateInChangeLog)
					if (dateInChangeLog.contains(currentDate)) {
						keyLogger.markPassed('Tanggal --> date with time when the changes was created')
						WebUI.verifyElementVisible(txtFirstRowChangelogDate, FailureHandling.OPTIONAL)
					}
				/*We want verify user name  */
				def userInChangeLog = WebUI.getText(txtFirstRowChangelogUser)
				println(userInChangeLog)
				WebUI.waitForElementVisible(txtFirstRowChangelogUser, 5)
				WebUI.verifyMatch(userInChangeLog, userName, false)

				/*We want verify sources*/
                SourcesLabel = WebUI.getText(LabelSources)
                ChangelogSources = WebUI.getText(txtFirstRowChangelogSources)
                WebUI.verifyMatch(SourcesLabel, ChangelogSources, false)
					
				/*We want verify field*/
				WebUI.delay(5)
                WebUI.waitForElementVisible(txtFirstRowChangelogField, 5)
                String ChangelogField = WebUI.getText(txtFirstRowChangelogField)
                WebUI.verifyNotMatch(ChangelogField, Address, false)
							
				String oldDataLog = oldData
				println(oldDataLog)
				String newDataLog = newData
				println(newDataLog)
	
				/*We want verify old Data reference number*/
				WebUI.waitForElementVisible(txtFirstRowChangelogOldData, 5)
				def  ChangelogoldData = WebUI.getText(txtFirstRowChangelogOldData)
				WebUI.verifyNotMatch(ChangelogoldData, oldDataLog, false)
				
				/*We want verify new Data reference number*/
				WebUI.waitForElementVisible(txtFirstRowChangelogNewData, 5)
				def ChangelognewData = WebUI.getText(txtFirstRowChangelogNewData)
				WebUI.verifyNotMatch(ChangelognewData, newDataLog, false)

				/*We want verify old action*/
				WebUI.waitForElementVisible(txtFirstRowChangelogActions, 5)
				def ChangelogAction=WebUI.getText(txtFirstRowChangelogActions)
				WebUI.verifyMatch(ChangelogAction, txtAction, false)

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
        }
    }
}