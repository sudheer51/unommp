package org.mmp.adminmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MessagesPage {

	WebDriver driver;
	public MessagesPage(WebDriver driver)
	{
		this.driver= driver;
	}
	public HashMap<String,String> fetchMessageDetails()
	{
		HashMap<String,String> actualHMap = new HashMap<String,String>();
		JavascriptExecutor jse = (JavascriptExecutor)driver;         //Zoom in to fetch the date
		jse.executeScript("document.body.style.zoom = '75%';");
		String reason= driver.findElement(By.xpath("//table[@class='table']//tr[2]/td[2]")).getText();
		String subject=driver.findElement(By.xpath("//table[@class='table']//tr[3]/td[2]")).getText();//table[@class='table']//tr[3]/td[2]
		String patientFirstName=driver.findElement(By.xpath("//table[@class='table']//tr[2]/td[1]")).getText();//table[@class='table']//tr[2]/td[1]
		String date=driver.findElement(By.xpath("//table[@class='table']//tr[2]/td[3]")).getText();//table[@class='table']//tr[2]/td[3]
		actualHMap.put("Reason", reason);
		actualHMap.put("Subject",subject );
		actualHMap.put("PtName", patientFirstName);
		actualHMap.put("Date",date );
		jse.executeScript("document.body.style.zoom = '100%';");
		return actualHMap;
	}
}
 