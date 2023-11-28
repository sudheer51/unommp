package org.mmp.adminmodule.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsersPage {
	
	WebDriver driver;

	public UsersPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectingNewUser(String ssn)
	{
		
		driver.findElement(By.xpath("//td[contains(text(),'"+ ssn +"')]/preceding-sibling::td//a")).click();
	
	}
	
	
}
