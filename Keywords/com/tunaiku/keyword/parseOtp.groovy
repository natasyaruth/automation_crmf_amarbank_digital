package com.tunaiku.keyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import org.openqa.selenium.WebDriver;
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class parseOtp {

	public static String SMS_Code1
	public static String SMS_Code2
	public static String SMS_Code3
	public static String SMS_Code4


	@Keyword
	def Parts_OTP(String OTP1, String OTP2, String OTP3, String OTP4) {
		String otpSource = GlobalVariable.otpOldPhoneNumber
		OTP1 = otpSource[0]
		OTP2 = otpSource[1]
		OTP3 = otpSource[2]
		OTP4 = otpSource[3]
		
		this.SMS_Code1=OTP1
		this.SMS_Code2=OTP2
		this.SMS_Code3=OTP3
		this.SMS_Code4=OTP4
		return Arrays.toString(SMS_Code1,SMS_Code2,SMS_Code3,SMS_Code4)
	}
}
