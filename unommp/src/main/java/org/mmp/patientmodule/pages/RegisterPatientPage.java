package org.mmp.patientmodule.pages;

import java.util.HashMap;

import org.iitwforce.healthcare.lib.MMPLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class RegisterPatientPage {
	WebDriver driver;

	public RegisterPatientPage(WebDriver driver) {
		this.driver = driver;
	}

	public String enterPatientDetails(HashMap<String,String> expHMap)
	{
	driver.findElement(By.id("firstname")).sendKeys(expHMap.get("FName"));	
	driver.findElement(By.id("lastname")).sendKeys(expHMap.get("LName"));	
	driver.findElement(By.id("datepicker")).sendKeys(expHMap.get("DOB"));	
	driver.findElement(By.id("license")).sendKeys(expHMap.get("LicNo"));	
	driver.findElement(By.id("ssn")).sendKeys(expHMap.get("SsnNo"));	
	driver.findElement(By.id("state")).sendKeys(expHMap.get("State"));
	driver.findElement(By.id("city")).sendKeys(expHMap.get("City"));
	driver.findElement(By.id("address")).sendKeys(expHMap.get("Address"));
	driver.findElement(By.id("zipcode")).sendKeys(expHMap.get("ZipCode"));
	driver.findElement(By.id("age")).sendKeys(expHMap.get("Age"));
	driver.findElement(By.id("height")).sendKeys(expHMap.get("Height"));
	driver.findElement(By.id("weight")).sendKeys(expHMap.get("Weight"));
	driver.findElement(By.id("pharmacy")).sendKeys(expHMap.get("Pharmacy"));
	driver.findElement(By.id("pharma_adress")).sendKeys(expHMap.get("PharAddress"));
	driver.findElement(By.id("email")).sendKeys(expHMap.get("Email"));
	driver.findElement(By.id("username")).sendKeys(expHMap.get("Username"));
	driver.findElement(By.id("password")).sendKeys(expHMap.get("Password"));
	driver.findElement(By.id("confirmpassword")).sendKeys(expHMap.get("ConPWord"));
	Select select = new Select(driver.findElement(By.id("security")));	
	select.selectByVisibleText(expHMap.get("SecuQue"));
	driver.findElement(By.id("answer")).sendKeys(expHMap.get("SecuAns"));
	driver.findElement(By.name("register")).click();

//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//	wait.until(ExpectedConditions.alertIsPresent());
	MMPLibrary mmpl = new MMPLibrary(driver);
	String succmsg = mmpl.handleAlert();
	return succmsg;	
	}
	
}
