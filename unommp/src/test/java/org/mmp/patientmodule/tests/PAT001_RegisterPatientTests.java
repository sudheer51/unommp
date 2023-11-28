package org.mmp.patientmodule.tests;

import java.util.HashMap;

import org.iitwforce.healthcare.lib.AppLibrary;
import org.iitwforce.healthcare.lib.BaseClass;
import org.iitwforce.healthcare.lib.MMPLibrary;
import org.mmp.adminmodule.pages.ProfilePage;
import org.mmp.adminmodule.pages.UsersPage;
import org.mmp.patientmodule.pages.EditProfilePage;
import org.mmp.patientmodule.pages.LoginPage;
import org.mmp.patientmodule.pages.RegisterPatientPage;
import org.mmp.patientmodule.pages.RegisterPatientPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PAT001_RegisterPatientTests extends BaseClass {
  @Test
  public void validateRegisterPatient() throws Exception  {
	  
	    MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchApplication(prop.getProperty("patientURL"));
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		HashMap<String,String> expHashMap= new HashMap<String, String>();
		String firstName="Fname"+ AppLibrary.randomString();
		expHashMap.put("FName", firstName);
		String lastName="Lname"+ AppLibrary.randomString();
		expHashMap.put("LName", lastName);
		expHashMap.put("DOB", "1-15-1985");	
		String licNo= AppLibrary.randomLicNumber();
		expHashMap.put("LicNo", licNo);
		String ssnNo= AppLibrary.randomSsnNumber();
		expHashMap.put("SsnNo", ssnNo);
		String state= AppLibrary.randomString();
		expHashMap.put("State", state);
		String city="city"+ AppLibrary.randomString();
		expHashMap.put("City", city);
		String address="2434 Addre"+ AppLibrary.randomString();
		expHashMap.put("Address", address);
		String zCode="245"+ AppLibrary.randomTwoDigitNumber();
		expHashMap.put("ZipCode", zCode);
		String age= AppLibrary.randomTwoDigitNumber();
		expHashMap.put("Age", age);
		String height="1"+ AppLibrary.randomTwoDigitNumber();
		expHashMap.put("Height", height);
		String weight=AppLibrary.randomTwoDigitNumber();
		expHashMap.put("Weight", weight);
		String Pharmacy="pharm"+ AppLibrary.randomString();
		expHashMap.put("Pharmacy", Pharmacy);
		String phAddress="2434 pharm"+ AppLibrary.randomString();
		expHashMap.put("PharAddress", phAddress);
		String email="email"+ AppLibrary.randomString()+"@gmail.com";
		expHashMap.put("Email", email);
		String uName=AppLibrary.randomString()+AppLibrary.randomString()+AppLibrary.randomTwoDigitNumber();
		expHashMap.put("Username", uName);
		String pwd="pswd"+AppLibrary.randomString()+AppLibrary.randomTwoDigitNumber();
		expHashMap.put("Password", pwd);
		expHashMap.put("ConPWord", pwd);
		String ques= "what is your pet name";
		expHashMap.put("SecuQue", ques);
		expHashMap.put("SecuAns",lastName);
		String expSucMsg="Thank you for registering with MMP. ";
		System.out.println(expHashMap);
		RegisterPatientPage regPatient= new RegisterPatientPage(driver);
		String actSucMsg = regPatient.enterPatientDetails(expHashMap);
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(expSucMsg, actSucMsg);
		
		//login to admin
		mmpLib.launchApplication(prop.getProperty("adminURL"));
		org.mmp.adminmodule.pages.LoginPage adminLogin = new org.mmp.adminmodule.pages.LoginPage(driver);
		adminLogin.login(prop.getProperty("adminUserName"), prop.getProperty("adminPassword"));
		mmpLib.navigation("Users");
		
		UsersPage user=new  UsersPage(driver);
		user.selectingNewUser(ssnNo);
		//System.out.println("selected new user");
		
		ProfilePage prof=new ProfilePage(driver);
		prof.acceptingNewUser();
		String actUserMsg=mmpLib.handleAlert();
		String expUserMsg=" USER has been updated.";
		sa.assertEquals(expUserMsg, actUserMsg);
		
		//login to patient portal with new username and password
		mmpLib.launchApplication(prop.getProperty("patientURL"));
		LoginPage lPage = new LoginPage(driver);
		lPage.login(uName,pwd);
		mmpLib.navigation("Profile");
		EditProfilePage editProfilePage = new EditProfilePage(driver);
		HashMap<String, String> actualHMap = editProfilePage.fetchUpdatedValues();
		System.out.println(actualHMap);
		
		expHashMap.remove("DOB", "1-15-1985");	
		expHashMap.remove("Pharmacy",Pharmacy);
		expHashMap.remove("PharAddress", phAddress);
		expHashMap.remove("Email", email);
		expHashMap.remove("Username", uName);
		expHashMap.remove("Password", pwd);
		expHashMap.remove("ConPWord", pwd);
		expHashMap.remove("SecuQue", ques);
		expHashMap.remove("SecuAns",lastName);
		Assert.assertEquals(expHashMap, actualHMap);
  }
}

