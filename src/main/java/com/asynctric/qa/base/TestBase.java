package com.asynctric.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.asynctric.qa.util.TestUtil;
import com.asynctric.qa.util.WebEventListener;

public class TestBase {
	
	//public static Logger log=LogManager.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver edriver;
	public static WebEventListener eventListener;
	
	
	public TestBase() throws IOException
	{
	 try{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("D:\\Projects\\Asyncentric\\src\\main\\java\\com\\asynctric\\qa\\config\\"
				+ "config.properties");
		prop.load(ip);
	 	}	
	 		catch(FileNotFoundException e)
	 			{
	 				e.printStackTrace();
	 			}
	 		catch(IOException e)
	 			{
	 				e.printStackTrace();
	 			}
	}

	public static void Initialization() throws IOException
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Selenium Setup\\chrome88\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.silentOutput", "true");
			driver=new ChromeDriver();
		//	log.info("Chrome Driver Initialized");
		}
		
		else if(browsername.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\Selenium Setup\\Mozila\\geckodriver.exe" );
			  driver=new FirefoxDriver();
			//  log.info(" FireFox Driver Initialized");
		}
		
		System.out.println("Driver "+ driver);
		edriver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		edriver.register(eventListener);
		driver = edriver; 
		System.out.println("Driver "+ driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}


}
