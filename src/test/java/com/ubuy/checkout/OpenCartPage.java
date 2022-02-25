package com.ubuy.checkout;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//After adding the product cart moved to cart page
public class OpenCartPage 
{
	public void getCartPage(WebDriver driver,JavascriptExecutor js,WebDriverWait wait) throws InterruptedException
	{
		WebElement addToCart = driver.findElement(Elements.addToCartButtonAtDetailPage);
		js.executeScript("arguments[0].scrollIntoView()",addToCart);
		addToCart.click();
		wait.until(ExpectedConditions.elementToBeClickable(Elements.viewCartAndCheckoutButton));
		Thread.sleep(2000);
		driver.findElement(Elements.viewCartAndCheckoutButton).click();
		wait.until(ExpectedConditions.elementToBeClickable(Elements.proceedToCheckoutButton));
		Thread.sleep(2000);
		System.out.println("Cart page has been opened.");
	}
}
