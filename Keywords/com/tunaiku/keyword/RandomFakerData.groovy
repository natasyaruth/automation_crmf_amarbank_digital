package com.tunaiku.keyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.apache.commons.lang.RandomStringUtils

import com.github.javafaker.Faker
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class RandomFakerData {
	
	public static String fakerFullName
	public static String fakerEmail
	public static String fakerFirstName
	public static String fakerLastName
	public static String fakerPhoneNumber
	
	Faker faker = new Faker()
	
	@Keyword
	def set_faker_full_name(String fullName) {
		this.set_faker_full_name(faker.name().fullName())
		return fakerFullName
	}
	
	@Keyword
	def set_faker_email(String email) {
		this.set_faker_email(faker.name().fullName() +"@gmail.com")
		return fakerEmail
	}
	
	@Keyword
	def set_faker_first_name(String firstName) {
		this.set_faker_first_name(faker.name().firstName())
		return fakerFirstName
	}
	
	@Keyword
	def set_faker_last_name(String lastName) {
		this.set_faker_last_name(faker.name().lastName())
		return fakerLastName
	}
	
	@Keyword
	def set_faker_phone_number(String phoneNumber) {
		this.set_faker_phone_number("0812" +RandomStringUtils.randomNumeric(8))
		return fakerPhoneNumber
	}
}
