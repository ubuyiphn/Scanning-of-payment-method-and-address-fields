package com.ubuy.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Moved to checkout page
public class OpenCheckoutPage 
{
	public void getCheckoutPage(WebDriver driver,WebDriverWait wait) throws InterruptedException
	{
		driver.findElement(Elements.proceedToCheckoutButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(Elements.proceedToPayButton));
		Thread.sleep(2000);
		System.out.println("Checkout page has been opened.");
	}
}
