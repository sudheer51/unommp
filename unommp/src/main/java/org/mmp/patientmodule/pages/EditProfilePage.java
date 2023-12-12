package org.mmp.patientmodule.pages;

import java.util.HashMap;

import org.iitwforce.healthcare.lib.MMPLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProfilePage {
	WebDriver driver;
	MMPLibrary mmpLib ;
	public EditProfilePage(WebDriver driver)
	{
		this.driver= driver;
		mmpLib = new MMPLibrary(driver);
	}
	public String editFirstName(String expected)
	{
		clickEditButton();
		updateFirstName(expected);
		clickSaveButton();
		String successMsg=mmpLib.handleAlert();
		String actual = driver.findElement(By.id("fname")).getAttribute("value");
		return successMsg+","+actual;
	}
	public void editAllFields(HashMap<String,String> expectedHMap)
	{
		clickEditButton();
		updateFirstName(expectedHMap.get("FName"));
		updateLastName(expectedHMap.get("LName"));
		updateLicence(expectedHMap.get("LicNo"));
		updateSsn(expectedHMap.get("SsnNo"));
		updateAge(expectedHMap.get("Age"));
		updateHeight(expectedHMap.get("Height"));
		updateWeight(expectedHMap.get("Weight"));
		updateState(expectedHMap.get("State"));
		updateCity(expectedHMap.get("City"));
		updateAddress(expectedHMap.get("Address"));
		updateZip(expectedHMap.get("ZipCode"));
		
		clickSaveButton();
		mmpLib.handleAlert();
	}
	public void updateFirstName(String fName)
	{
		WebElement fNameWE = driver.findElement(By.id("fname"));
		fNameWE.clear();
		fNameWE.sendKeys(fName);
	}
	public void updateLastName(String lName)
	{
		WebElement lNameWE = driver.findElement(By.id("lname"));
		lNameWE.clear();
		lNameWE.sendKeys(lName);
	}
	public void updateLicence(String licNo) {
		WebElement licWE = driver.findElement(By.id("licn"));
		licWE.clear();
		licWE.sendKeys(licNo);
	}

	public void updateSsn(String ssnNo) {
		WebElement ssnNoWE = driver.findElement(By.id("ssn"));
		ssnNoWE.clear();
		ssnNoWE.sendKeys(ssnNo);
	}

	public void updateAge(String age) {
		WebElement ageWE = driver.findElement(By.id("age"));
		ageWE.clear();
		ageWE.sendKeys(age);
	}
	public void updateHeight(String height) {
		WebElement heightWE = driver.findElement(By.id("height"));
		heightWE.clear();
		heightWE.sendKeys(height);
	}
	public void updateWeight(String weight) {
		WebElement weightWE = driver.findElement(By.id("weight"));
		weightWE.clear();
		weightWE.sendKeys(weight);
	}
	public void updateState(String state) {
		WebElement stateWE = driver.findElement(By.id("state"));
		stateWE.clear();
		stateWE.sendKeys(state);
	}
	public void updateZip(String zip) {
		WebElement zipWE = driver.findElement(By.id("zip"));
		zipWE.clear();
		zipWE.sendKeys(zip);
	}
	public void updateCity(String city) {
		WebElement cityWE = driver.findElement(By.id("city"));
		cityWE.clear();
		cityWE.sendKeys(city);
	}
	public void updateAddress(String address) {
		WebElement addressWE = driver.findElement(By.id("addr"));
		addressWE.clear();
		addressWE.sendKeys(address);
	}


	public void clickSaveButton()
	{
		driver.findElement(By.id("Sbtn")).click();
		
	}
	public void clickEditButton()
	{
		driver.findElement(By.id("Ebtn")).click();
	}
	public HashMap<String, String> fetchUpdatedValues()
	{
		HashMap<String,String> actualEditInfo = new HashMap<String,String>();
		String fName = driver.findElement(By.id("fname")).getAttribute("value");
		actualEditInfo.put("FName",fName);
		String lName = driver.findElement(By.id("lname")).getAttribute("value");
		actualEditInfo.put("LName",lName);
		String licNo = driver.findElement(By.id("licn")).getAttribute("value");
		actualEditInfo.put("LicNo", licNo);
		String ssnNo = driver.findElement(By.id("ssn")).getAttribute("value");
		actualEditInfo.put("SsnNo", ssnNo);
		String age = driver.findElement(By.id("age")).getAttribute("value");
		actualEditInfo.put("Age", age);
		String height = driver.findElement(By.id("height")).getAttribute("value");
		actualEditInfo.put("Height", height);
		String weight = driver.findElement(By.id("weight")).getAttribute("value");
		actualEditInfo.put("Weight", weight);
		String state = driver.findElement(By.id("state")).getAttribute("value");
		actualEditInfo.put("State", state);
		String zip = driver.findElement(By.id("zip")).getAttribute("value");
		actualEditInfo.put("ZipCode", zip);
		String city = driver.findElement(By.id("city")).getAttribute("value");
		actualEditInfo.put("City", city);
		String address = driver.findElement(By.id("addr")).getAttribute("value");
		actualEditInfo.put("Address", address);
		return actualEditInfo;
	}
	public String fetchPatientFirstName()
	{
		String fName = driver.findElement(By.id("fname")).getAttribute("value");
		return fName;
	}
	

}
