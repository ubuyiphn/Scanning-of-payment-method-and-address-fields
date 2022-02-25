package com.ubuy.checkout;

import org.openqa.selenium.By;

public class Elements 
{
	//Home Page Elements
	public static By searchInputFieldAtHomePage = By.xpath("//input[@title='Search']");
	public static By countryNameElement = By.xpath("//span[@class='value gray-text ms-2 header-country-desktop']");
	public static By storeNameElement = By.xpath("//div[@class='owl-stage']/div/li/a/h6");
	
	//List Page Elements
	public static By productAtListPage = By.xpath("//div[@id='usstore-products']/div/div/a");
	
	//Detail Page Elements
	public static By productTitleAtDetailPage = By.xpath("//h1[@class='title h1 mb-2']");
	public static By addToCartButtonAtDetailPage = By.id("add-to-cart-btn");
	public static By viewCartAndCheckoutButton = By.id("add-to-cart-view-cart");
	
	//Cart Page Elements
	public static By proceedToCheckoutButton = By.xpath("//li/button[@title='Proceed to Checkout']");
	
	//Checkout Page Common Elements
	public static By proceedToPayButton = By.xpath("//li/button");
	
	//Checkout Page Address Field Elements
	public static String commonChildHead = "//div[@id='billing-new-address-form']/div";
	public static By allAdressFields = By.xpath(commonChildHead);
	public static String displayNoneAddressFields = "mb-3 floating-labels d-none";
	public static String garbageFields = "row";
	public static String childHeadElement = "//div[@id='billing-new-address-form']/div[";
	public static String childTailElement = "]/child::*[1]";
	
	//Checkout Page Payment Method Elements
	public static By allPaymentMethods = By.xpath("//div[@id='checkout-payment-method-load']/ul/li/input");
}
