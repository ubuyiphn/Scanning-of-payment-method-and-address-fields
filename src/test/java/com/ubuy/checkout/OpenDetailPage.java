package com.ubuy.checkout;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//All detail page urls will be stored to list and open detail page loop will be continue till the add to cart button availability
public class OpenDetailPage 
{
	public void getDetailPage(WebDriver driver,WebDriverWait wait) throws InterruptedException
	{
		List<WebElement> detailURLs = new ArrayList<>();
		detailURLs = driver.findElements(Elements.productAtListPage);
		String detailURL;
		for(WebElement temp : detailURLs)
		{
			try
			{
			detailURL = temp.getAttribute("href");
			System.out.println(detailURL);
			driver.get(detailURL);
			wait.until(ExpectedConditions.presenceOfElementLocated(Elements.productTitleAtDetailPage));
			break;
			}
			catch(Exception e)
			{
				System.out.println(e);
				System.out.println("Add to cart button not found.");
			}
		}
		
		Thread.sleep(2000);
	}
}
