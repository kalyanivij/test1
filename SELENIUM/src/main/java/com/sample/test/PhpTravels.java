package com.sample.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhpTravels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i < 5; i++) {
			System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://phptravels.com");
			driver.findElement(By.cssSelector("a[href='https://phptravels.com/demo/'][class*='btn-light-blue']"))
					.click();
			WebDriverWait wait=new WebDriverWait(driver,15) ;
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("a[href$='.net']"))));
			driver.findElement(By.cssSelector("a[href$='.net']")).click();
			
			driver.quit();

		}

	}

}
