package com.ubuy.checkout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckoutIndex 
{
   public static void main(String[] args) throws IOException, InterruptedException
   {
	   
	   int domainCount=144;
	   //Launch chrome
	   WebDriverManager.chromedriver().setup();
	   final WebDriver driver = new ChromeDriver();
	   
	   //Explicit Wait
	   final WebDriverWait wait = new WebDriverWait(driver,20);
	  
	   //Maximize Window
	   driver.manage().window().maximize();
	   
	   //driver type casting to javascriptexecutor
	   final JavascriptExecutor js = (JavascriptExecutor) driver;
	   
	   //Access Excel
	   final File domainSheetPath = new File(System.getProperty("user.dir")+"/Domain.xls");
	   final FileInputStream fis = new FileInputStream(domainSheetPath);
	   final HSSFWorkbook wb = new  HSSFWorkbook(fis);

	   while(domainCount<211)
	   {
		   try
		   {
		   //Get domain one by one and hit domain home page url
		   OpenHomePage hmpg = new OpenHomePage();
		   String domainURL = hmpg.setDomain(domainCount,wb);
		   hmpg.getDomain(driver, domainURL,wait);
		   
		   //Get Store data
		   GetStoreData strdata = new GetStoreData();
		   strdata.getStoreName(driver);
		   strdata.feedStoreDataToExcel(wb, domainSheetPath, domainCount);
		   
//		   //Get Country Name
//		   GetCountryName cntrynm = new GetCountryName();
//		   cntrynm.feedCountryNameToExcel(driver, wb, domainCount, domainSheetPath);
//		   
//		   //Open list page
//		   OpenListPage lstpg = new OpenListPage();
//		   lstpg.getListPage(driver,wait);
//		   
//		   //Open Detail Page
//		   OpenDetailPage dtlpg = new OpenDetailPage();
//		   dtlpg.getDetailPage(driver,wait);
//		   
//		   //Open Cart Page
//		   OpenCartPage crtpg = new OpenCartPage();
//		   crtpg.getCartPage(driver, js,wait);
//		   
//		   //Open Checkout Page
//		   OpenCheckoutPage chkoutpg = new OpenCheckoutPage();
//		   chkoutpg.getCheckoutPage(driver, wait);
//		   
//		  // Scan Address Fields
//		   ScanAddressFields adrsfld = new ScanAddressFields();
//		   adrsfld.scanAddressField(driver,js);
//		   adrsfld.feedAddressFieldToExcel(wb, domainCount, domainSheetPath);
//		   
		   //Scan Payment Methods
//		   ScanPaymentMethods pmntmthd = new ScanPaymentMethods();
//		   pmntmthd.scanPaymentMethods(driver);
//		   pmntmthd.feedPaymentMethodToExcel(wb, domainCount,domainSheetPath);
		   
		   domainCount++;
		   System.out.println(domainCount+" round has been completed.");
		   }
		   catch(Exception e)
		   {
			   System.out.println(e);
			   System.out.println(domainCount+" round is going to repeat.");
		   }
	   }
	  
   }
}
