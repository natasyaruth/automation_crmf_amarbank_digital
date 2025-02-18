package com.tunaiku.keyword

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import java.util.Iterator
import java.util.Set
import org.openqa.selenium.By
//import org.openqa.selenium.WebDriver;
import internal.GlobalVariable

public class DeleteNumber {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = DriverFactory.getWebDriver()

		// Launching the site
		driver.get("")	;
		driver.manage().window().maximize()
		driver.findElement(By.xpath("//*[contains@href, '')]")).click()

		String MainWindow=driver.getWindowHandle();

		// To handled all new opened window
		Set<String> s1=driver.getWindowHandles()
		Iterator<String> i1=s1.iterator();

		while (i1.hasnet())
		{
			String ChildWindow=i1.next()

			if(!MainWindow.equalsIgnoreCase(ChildWindow))
			{
				//Switching to child window
				driver.switchTo().window(ChildWindow)
				driver.findElement(By.name("username")).sendKeys("")
				driver.findElement(By.name("password")).sendKeys("")
				driver.findElement(By.type("Submit")).click()
				//closing the child window.
				driver.close()
			}
		}
		//Switching to parent window
		driver.switchTo().window(MainWindow)
	}
}
