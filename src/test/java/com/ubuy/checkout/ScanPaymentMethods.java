package com.ubuy.checkout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScanPaymentMethods 
{
	List<String> allPaymentMethodsId = new ArrayList<>();
	List<String> allPaymentMethodsTitle = new ArrayList<>();
	public void scanPaymentMethods(WebDriver driver)
	{
		List<WebElement> allPaymentMethodElements = driver.findElements(Elements.allPaymentMethods);
		for(WebElement temp : allPaymentMethodElements)
		{
			allPaymentMethodsId.add(temp.getAttribute("id"));
			allPaymentMethodsTitle.add(temp.getAttribute("title"));
			System.out.println("id : "+temp.getAttribute("id")+" (title : "+temp.getAttribute("title")+")");
		}
	}
	
	public void feedPaymentMethodToExcel(HSSFWorkbook wb,int domainCount,File domainSheetPath) throws IOException
	{
		HSSFSheet paymentSheet = wb.getSheet("Payment Methods");
		HSSFRow row = paymentSheet.createRow(domainCount);
		for(int cell=0;cell<allPaymentMethodsId.size();cell++)
		{
			System.out.println(allPaymentMethodsTitle.get(cell)+" title & id "+allPaymentMethodsId.get(cell));
			row.createCell(cell).setCellValue(allPaymentMethodsId.get(cell)+"("+allPaymentMethodsTitle.get(cell)+")");
			wb.write(domainSheetPath);
		}
//		System.out.println("First payment method : "+paymentSheet.getRow(0).getCell(0));
	}
}
