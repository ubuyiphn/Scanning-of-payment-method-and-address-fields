package com.ubuy.checkout;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//shoes keyword is searched to get list page
public class OpenListPage 
{
	public void getListPage(WebDriver driver,WebDriverWait wait) throws InterruptedException
	{
		WebElement inputField = driver.findElement(Elements.searchInputFieldAtHomePage);
		inputField.clear();
		inputField.sendKeys("shoes");
		inputField.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.presenceOfElementLocated(Elements.productAtListPage));
		Thread.sleep(2000);
		System.out.println("shoes keyword has been searched.");
	}
}
