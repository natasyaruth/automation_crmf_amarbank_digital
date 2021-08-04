import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.util.CryptoUtil as CryptoUtil

WebUI.waitForPageLoad(100)

WebUI.waitForElementVisible(findTestObject('Website/CRM/Login/BtnLogin'), 10)

WebUI.verifyTextPresent(btnLogin, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Website/CRM/Login/BtnLogin'))

WebUI.waitForPageLoad(100)

// Commented, because of localization in CircleCI
// WebUI.verifyTextPresent(verifyFieldEmail, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Website/CRM/Login/TxtGmailAccount'), 10)

WebUI.sendKeys(findTestObject('Website/CRM/Login/TxtGmailAccount'), CryptoUtil.decode(CryptoUtil.getDefault(gmailAccount)))

WebUI.click(findTestObject('Website/CRM/Login/BtnNext'))

WebUI.waitForPageLoad(10, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Website/CRM/Login/TxtGmailPassword'), 30)

// Commented, because of localization in CircleCI
// WebUI.verifyTextPresent(verifyFieldPassword, false, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.sendKeys(findTestObject('Website/CRM/Login/TxtGmailPassword'), CryptoUtil.decode(CryptoUtil.getDefault(gmailPassword)))

WebUI.click(findTestObject('Website/CRM/Login/BtnPasswordNext'))

WebUI.waitForElementPresent(findTestObject('Website/CRM/Login/GridInfoLogin'), 100)

WebUI.waitForPageLoad(10)

TestObject txtUsername = new TestObject().addProperty('text', ConditionType.CONTAINS, username)

WebUI.verifyElementPresent(txtUsername, 30, FailureHandling.CONTINUE_ON_FAILURE)

