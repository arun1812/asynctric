package com.asynctric.qa.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.asynctric.qa.base.TestBase;

public class CategoriesMen extends TestBase{

	

	public CategoriesMen() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
		}	
// PageFactory  --- OR
		
@FindBy(xpath="//header/section[1]/p[2]")
WebElement CategoryMen;
@FindBy(xpath="//body/div[@id='root']/div[1]/div[3]/section[1]/div[1]/nav[1]/p[2]/span[1]")
WebElement Subcategoryshirt;   
@FindBy(xpath="//body/div[@id='root']/div[1]/div[3]/section[2]/a[1]/div[1]/img[1]")
WebElement Product1;
@FindBy(xpath="//body/div[@id='root']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/span[1]")
WebElement Product1Add;
@FindBy(xpath="//body/div[@id='root']/div[1]/div[3]/section[2]/a[2]/div[1]/img[1]")
WebElement Product2;
@FindBy(xpath="//body/div[@id='root']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/section[1]/div[4]")
WebElement Size;
@FindBy(xpath="//body/div[@id='root']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/section[1]/div[3]")
WebElement Color;
@FindBy(xpath="//button[@id='add_to_cart_btn']")
WebElement Product2add; //button[@id='add_to_cart_btn']
@FindBy(xpath="//span[@id='snackbar-message-id']")
WebElement coformationmessage;
		
	public void AddProductFirst() throws InterruptedException
	{
		CategoryMen.click();
		Subcategoryshirt.click();
		Thread.sleep(3000);
		Product1.click();
		Set<String>windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String 	Parentwindow=it.next();
		String	ChildWindow=it.next();
		driver.switchTo().window(ChildWindow);
		Thread.sleep(5000);
		Product1Add.click();
		 System.out.println(coformationmessage.getText());
		 
		 driver.switchTo().window(Parentwindow);
		// System.out.println(driver.getCurrentUrl());
	}
	public void AddProductSecond() throws InterruptedException
	{
		CategoryMen.click();
		Subcategoryshirt.click();
		Thread.sleep(3000);
		Product2.click();
		//Thread.sleep(3000);
		Set<String>windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		
		String	ChildWindow=it.next();
		driver.switchTo().window(ChildWindow);
		Size.click();
		
		Color.click();
		Thread.sleep(5000);
		Product2add.click();
		System.out.println(coformationmessage.getText());
	}

}
