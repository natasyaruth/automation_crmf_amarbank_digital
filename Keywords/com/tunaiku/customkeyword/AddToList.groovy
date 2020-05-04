
package com.tunaiku.customkeyword

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

public class AddToList {
	@Keyword
	def parameterizedObject(def value){
		List<TestObjectProperty> properties = new ArrayList<TestObjectProperty>()
		properties.add(new TestObjectProperty("id", ConditionType.EQUALS, value))
		return properties
	}
}
