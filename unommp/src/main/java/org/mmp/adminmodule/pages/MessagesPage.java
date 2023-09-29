package org.mmp.adminmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
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
		String reason= driver.findElement(By.xpath("//table[@class='table']//tr[2]/td[2]")).getText();
		String subject=driver.findElement(By.xpath("//table[@class='table']//tr[3]/td[2]")).getText();//table[@class='table']//tr[3]/td[2]
		String patientFirstName=driver.findElement(By.xpath("//table[@class='table']//tr[2]/td[1]")).getText();//table[@class='table']//tr[2]/td[1]
		String date=driver.findElement(By.xpath("//table[@class='table']//tr[2]/td[3]")).getText();//table[@class='table']//tr[2]/td[3]
		actualHMap.put("reason", reason);
		actualHMap.put("subject",subject );
		actualHMap.put("fName", patientFirstName);
		actualHMap.put("date",date );
		return actualHMap;
	}
}
 