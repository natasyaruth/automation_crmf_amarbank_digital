import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.navigateToUrl(diffModule)

WebUI.waitForPageLoad(3)

if (WebUI.getUrl() == GlobalVariable.siteUrl + "/forbidden"){

	WebUI.verifyTextPresent(msgForbiddenPage, false)

	WebUI.click(findTestObject('Website/CRM/Leads_Management/Detail/BtnBack'))
}

else {
	KeywordUtil.logInfo("Users have access to different modules.")

	WebUI.back()
}

WebUI.waitForPageLoad(2)

WebUI.verifyTextPresent(GlobalVariable.titleLeadsManagement, false)