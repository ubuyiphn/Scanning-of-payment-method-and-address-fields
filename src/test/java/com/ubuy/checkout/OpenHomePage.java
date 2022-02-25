package com.ubuy.checkout;

import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Get home page of different domain one by one from excel sheet
public class OpenHomePage 
{
	public String setDomain(int domainCount,HSSFWorkbook wb) throws IOException
	{
		HSSFSheet all_Domains_Sheet = wb.getSheet("All_Domain");
		String domainURL = all_Domains_Sheet.getRow(domainCount).getCell(0).toString();
		System.out.println(domainURL);
		return domainURL;
	}
	
	public void getDomain(WebDriver driver,String domainURL,WebDriverWait wait) throws InterruptedException
	{
		driver.get(domainURL);
		wait.until(ExpectedConditions.presenceOfElementLocated(Elements.searchInputFieldAtHomePage));
		Thread.sleep(2000);
	}
}
