package org.mmp.patientmodule.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerExample {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.abhibus.com/");   
		driver.findElement(By.id("source")).sendKeys("Bang");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		List<WebElement> sourceList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='ui-id-1']/li")));
		System.out.println(sourceList.size());
		for(int i=0;i<sourceList.size();i++)
		{
			System.out.println(sourceList.get(i).getText());
			if(sourceList.get(i).getText().equals("Bangalore"))
			{
				sourceList.get(i).click();
				break;
			}
			
		}
		
		driver.findElement(By.id("destination")).sendKeys("Mum");
		 
		List<WebElement> destionationList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='ui-id-2']/li")));
		System.out.println(destionationList.size());
		for(int i=0;i<destionationList.size();i++)
		{
			System.out.println(destionationList.get(i).getText());
			if(destionationList.get(i).getText().equals("Mumbai"))
			{
				destionationList.get(i).click();
				break;
			}
			
		}
		
		 
		wait.until(ExpectedConditions.elementToBeClickable(By.id("datepicker1"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ui-datepicker-div']/div[2]//a[text()='30' and not(contains(@class,'disabled'))]"))).click();	
		driver.findElement(By.linkText("Search")).click();
	}

}
