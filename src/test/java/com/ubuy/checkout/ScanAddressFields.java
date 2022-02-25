package com.ubuy.checkout;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScanAddressFields 
{
	//All Address Fields have one unique id
	List<String> idAddressFields = new ArrayList<>();
	
	//All input type address fields have unique placeholder value
	List<String> placeholderAddressFields = new ArrayList<>();
	
	public void scanAddressField(WebDriver driver,JavascriptExecutor js)
	{
		//All address field element will be stored either it is visible or invisible in the list
		List<WebElement> addressFieldElement = driver.findElements(Elements.allAdressFields);
		//This sequence is used here for order of elements
		int index=1;
		for(WebElement temp : addressFieldElement)
		{
			//These elements are not visible to front end user
			boolean displayNoneElements = temp.getAttribute("class").toString().equalsIgnoreCase(Elements.displayNoneAddressFields);
			//These are not part of address element
			boolean garbageElements = temp.getAttribute("class").toString().equalsIgnoreCase(Elements.garbageFields);
			//System.out.println(displayNoneElements +"   "+garbageElements);
			if(!displayNoneElements && !garbageElements)
			{
				String childElement = (Elements.childHeadElement+index).concat(Elements.childTailElement);
//				System.out.println(childElement);
				String tagname = driver.findElement(By.xpath(childElement)).getTagName();
//				System.out.println(tagname);
				switch(tagname)
				{
					case "input" :
						String finalAddressFieldElement1 = Elements.commonChildHead.concat("["+index+"]/"+tagname);
//						System.out.println(finalAddressFieldElement1);
						String idOfAddressField1 = driver.findElement(By.xpath(finalAddressFieldElement1)).getAttribute("id");
						idAddressFields.add(idOfAddressField1);
						String placeholderOfAddressField1 = driver.findElement(By.xpath(finalAddressFieldElement1)).getAttribute("placeholder");
						placeholderAddressFields.add(placeholderOfAddressField1);
						System.out.println("Input field placeholder(id) is : "+placeholderOfAddressField1+"("+idOfAddressField1+")");
						break;
						
					case "div" :
						String finalAddressFieldElement2 = Elements.commonChildHead.concat("/"+tagname+"/child::*[2]");
//						System.out.println(finalAddressFieldElement2);
						String idOfAddressField2 = driver.findElement(By.xpath(finalAddressFieldElement2)).getAttribute("id");
						idAddressFields.add(idOfAddressField2);
						String placeholderOfAddressField2 = driver.findElement(By.xpath(finalAddressFieldElement2)).getAttribute("placeholder");
						placeholderAddressFields.add(placeholderOfAddressField2);
						System.out.println("Input field placeholder(id) is : "+placeholderOfAddressField2+"("+idOfAddressField2+")");
						break;
						
					case "select" :
						String finalAddressFieldElement3 = Elements.commonChildHead.concat("["+index+"]/"+tagname);	
//						System.out.println(finalAddressFieldElement3);
						String idOfAddressField3 = driver.findElement(By.xpath(finalAddressFieldElement3)).getAttribute("id");
						System.out.println("Input field id is : "+idOfAddressField3);
						idAddressFields.add(idOfAddressField3);
						break;
						
					default :
						System.out.println("Moved into default"+tagname);
						break;
				}
			}
			index++;
			System.out.println();
		}
	}
	
	public void feedAddressFieldToExcel(HSSFWorkbook wb, int domainCount,File domainSheetPath) throws IOException
	{
		HSSFSheet addressSheet  = wb.getSheet("Address Fields");
		HSSFRow row = addressSheet.createRow(domainCount);
		int cell = 0;
//		System.out.println("Total Address Fields count : "+idAddressFields.size());
		for(String temp : idAddressFields)
		{
//			System.out.println((cell+1)+". "+temp);
			row.createCell(cell).setCellValue(temp);
			cell++;
		}
		wb.write(domainSheetPath);
	}
}
