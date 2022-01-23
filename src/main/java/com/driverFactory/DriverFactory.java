package com.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	/**
	 * this method will intialize the thread local driver on the basis of browser
	 * @param browser
	 * @return this will return tl driver
	 */
	public WebDriver setup(String browser) {
		
		System.out.println(browser);
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			tldriver.set(new EdgeDriver());
		}else {
			System.out.println("This is not correct value for browser"+ browser);
			System.exit(0);
		}
	getdriver().manage().deleteAllCookies();
	getdriver().manage().window().maximize();
	return driver;
		
		}
	/**
	 * this is tl method which is synchronised and returning browser
	 * @return
	 */
	public static synchronized WebDriver getdriver() {
		return tldriver.get();
	}
		
	
}
