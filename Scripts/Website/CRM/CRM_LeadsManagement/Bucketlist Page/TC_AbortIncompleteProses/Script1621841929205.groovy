import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


TestObject obj = new TestObject().addProperty("text", ConditionType.CONTAINS, msgIncompleteProcess)

if (WebUI.verifyElementNotPresent(obj, 5, FailureHandling.OPTIONAL)){
	
	KeywordUtil.logInfo("No incomplete process")
	
    }
else
{
'Abort incomplete process if any'
KeywordUtil.logInfo("Abort the incomplete process!")

WebUI.click(findTestObject('Website/CRM/Leads_Management/Bucketlist/BtnAbort'))

}

