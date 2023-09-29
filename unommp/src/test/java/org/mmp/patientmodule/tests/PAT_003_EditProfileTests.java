package org.mmp.patientmodule.tests;

import java.io.IOException;
import java.util.HashMap;

import org.iitwforce.healthcare.lib.AppLibrary;
import org.iitwforce.healthcare.lib.BaseClass;
import org.iitwforce.healthcare.lib.MMPLibrary;
import org.mmp.patientmodule.pages.EditProfilePage;
import org.mmp.patientmodule.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PAT_003_EditProfileTests extends BaseClass {
 
	@Test
	public void validateEditFName()
	{

		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchApplication(prop.getProperty("patientURL"));
		LoginPage lPage = new LoginPage(driver);
		lPage.login(prop.getProperty("patientUserName"),prop.getProperty("patientPassword"));
		mmpLib.navigation("Profile");
		String expected="FName"+AppLibrary.randomString();
		EditProfilePage editProfilePage = new EditProfilePage(driver);
		String actual = editProfilePage.editFirstName(expected);
		String[] actualArry = actual.split("\\,");
		System.out.println(actualArry[0]);
		String expectedSuccessMsg ="Your Profile has been updated.";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(expectedSuccessMsg,actualArry[0]);
		sa.assertEquals(expected,actualArry[1]);
		sa.assertAll();

	}
	@Parameters({"username","password"})
	@Test
	public void validateAllFields(String username,String password)
	{
		HashMap<String,String> expectedHMap = new HashMap<String,String>();
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchApplication(prop.getProperty("patientURL"));
		LoginPage lPage = new LoginPage(driver);
		lPage.login(prop.getProperty("patientUserName"),prop.getProperty("patientPassword"));
		mmpLib.navigation("Profile");
		String fName="FName"+AppLibrary.randomString();
		expectedHMap.put("FName",fName);
		String lName="LName"+AppLibrary.randomString();
		expectedHMap.put("LName",lName);
		EditProfilePage editProfilePage = new EditProfilePage(driver);
		
		editProfilePage.editAllFields(expectedHMap);
		HashMap<String,String> actualHMap = editProfilePage.fetchUpdatedValues();
		Assert.assertEquals(actualHMap, expectedHMap);
	}
	
	@DataProvider(name = "mmpDP")
	public String[][] feedDP() throws IOException
	{
		 String data[][] = AppLibrary.readXLSX("config//data.xlsx");
		 return data;
	}
	
	@Test(dataProvider="mmpDP")
	public void editProfile(String param1,String param2,String param3)
	{
		
		System.out.println(param1 + "--" +param2+"--"+param3);
		
	}

}
