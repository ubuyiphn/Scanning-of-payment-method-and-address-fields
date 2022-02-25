package com.ubuy.checkout;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GetStoreData 
{
	List<String> storeName = new ArrayList<>();
	public void getStoreName(WebDriver driver) 
	{
		List<WebElement> storeNameElements = driver.findElements(Elements.storeNameElement);
		System.out.println("Store element count is : "+storeNameElements.size());
		Actions ac = new Actions(driver);
		for(WebElement temp : storeNameElements)
		{
			ac.moveToElement(temp).perform();
			System.out.println(temp.getText());
			storeName.add(temp.getText());
		}
	}
	
	public void feedStoreDataToExcel(HSSFWorkbook wb,File domainSheetPath,int domainCount) throws IOException
	{
		HSSFSheet sheet = wb.getSheet("All_Domain");
		int cell=3;
		for(String temp : storeName)
		{
			sheet.getRow(domainCount).createCell(cell).setCellValue(temp);
//			System.out.println(temp);
			cell++;
		}
		wb.write(domainSheetPath);
	}
}
