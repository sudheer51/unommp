package org.mmp.patientmodule.pages;
import java.util.HashMap;
import org.iitwforce.healthcare.lib.AppLibrary;
import org.iitwforce.healthcare.lib.BaseClass;
//import org.iitwforce.healthcare.lib.MMPLibrary;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Registration extends BaseClass {
	WebDriver driver;
public Registration(WebDriver driver)
{
	this.driver=driver;
}
@Test
public HashMap<String,String> patientRegistration()
{
	HashMap<String,String> expectedHmap = new HashMap<String,String>();
	//MMPLibrary obj = new MMPLibrary(driver);
	//obj.launchApplication(prop.getProperty("URL"));
	driver.findElement(By.xpath("//input[@type='button']")).click();//Register
	String fname = "fname"+AppLibrary.randomString();
	driver.findElement(By.xpath("//input[@name='fname']")).sendKeys(fname);
	expectedHmap.put("FName", fname);
	String lname ="lname"+AppLibrary.randomString();
	driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys(lname);
	expectedHmap.put("LName", lname);
	int dob =AppLibrary.randomInteger(23456,79875);
	driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(String.valueOf(dob));
	expectedHmap.put("dob",String.valueOf(dob));
	int license = AppLibrary.randomInteger(12345654,56765478);
	driver.findElement(By.xpath("//input[@id='license']")).sendKeys(String.valueOf(license));
	expectedHmap.put("License", String.valueOf(license));
    int SSN = AppLibrary.randomInteger(154568876,567776576);
    driver.findElement(By.xpath("//input[@placeholder='SSN']")).sendKeys(String.valueOf(SSN));
	expectedHmap.put("SSN", String.valueOf(SSN));
	String state= "Washington"+AppLibrary.randomString();
	driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
	expectedHmap.put("State", state);
	String city= "Everett"+AppLibrary.randomString();
	driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
	expectedHmap.put("City", city);
	String address= "Edinboro"+AppLibrary.randomString();
	driver.findElement(By.xpath("//input[@name='address']")).sendKeys(address);
	expectedHmap.put("Address", address);
	int zipcode= AppLibrary.randomInteger(23456,79875);
	driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(String.valueOf(zipcode));
	expectedHmap.put("Zipcode", String.valueOf(zipcode));
	int age= AppLibrary.randomInteger(25,50);
	driver.findElement(By.xpath("//input[@id='age']")).sendKeys(String.valueOf(age));
	expectedHmap.put("Age", String.valueOf(age));
	int ht= AppLibrary.randomInteger(5,8);
	driver.findElement(By.xpath("//input[@name='height']")).sendKeys(String.valueOf(ht));
	expectedHmap.put("Height", String.valueOf(ht));
	int wt= AppLibrary.randomInteger(50,100);
	driver.findElement(By.xpath("//input[@name='weight']")).sendKeys(String.valueOf(wt));
	expectedHmap.put("Weight", String.valueOf(wt));
	String pharmacy= "RiteAid"+AppLibrary.randomString();
	driver.findElement(By.xpath("//input[@name='pharmacy']")).sendKeys(pharmacy);
	expectedHmap.put("Pharmacy", pharmacy);
	String pharmacy_add= "15 WalnutSt"+AppLibrary.randomString();
	driver.findElement(By.xpath("//input[@id='pharma_adress']")).sendKeys(pharmacy_add);
	expectedHmap.put("Pharmacy_Address", pharmacy_add);
	String email= "Nayan"+AppLibrary.randomEmail()+"@yahoo.com";
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
	expectedHmap.put("Email", email);
	String username= "Nayan"+AppLibrary.randomString();
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
	expectedHmap.put("UN", username);
	String pword= "Qtry12an";
	driver.findElement(By.xpath("//input[@name='pwd1']")).sendKeys(pword);
	expectedHmap.put("PWD", pword);
	String cpword= "Qtry12an";
	driver.findElement(By.xpath("//input[@id='confirmpassword']")).sendKeys(cpword);
	expectedHmap.put("CPWD", cpword);
	Select select= new Select(driver.findElement(By.xpath("//select[@class='input_name']")));
	select.selectByVisibleText("what is your best friend name");
	expectedHmap.put("QA","what is your best friend name");
	String ans= "John"+AppLibrary.randomString();
	driver.findElement(By.xpath("//input[@id='answer']")).sendKeys(ans);
	expectedHmap.put("ANS", ans);
	driver.findElement(By.xpath("//input[@value='Save']")).click();
	//obj.handleAlert();
	return expectedHmap;
  }

}
	


