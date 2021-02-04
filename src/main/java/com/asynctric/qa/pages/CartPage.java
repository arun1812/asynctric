package com.asynctric.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.asynctric.qa.base.TestBase;

public class CartPage extends TestBase{

	public CartPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Page Factory
	
@FindBy(xpath="//p[contains(text(),'Men Shirt')]")
WebElement product1;


}
