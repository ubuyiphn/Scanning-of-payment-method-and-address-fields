package com.ubuy.checkout;

import java.io.File;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class GetCountryName
{
	public void feedCountryNameToExcel(WebDriver driver,HSSFWorkbook wb,int domainCount,File domainSheetPath) throws IOException
	{
		String countryName = driver.findElement(Elements.countryNameElement).getText();
		System.out.println(countryName);
		HSSFSheet sheet = wb.getSheet("All_Domain");
		sheet.getRow(domainCount).createCell(2).setCellValue(countryName);
		wb.write(domainSheetPath);
	}
}