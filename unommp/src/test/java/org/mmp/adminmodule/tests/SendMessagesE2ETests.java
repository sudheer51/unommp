package org.mmp.adminmodule.tests;

import java.util.HashMap;

import org.iitwforce.healthcare.lib.AppLibrary;
import org.iitwforce.healthcare.lib.BaseClass;
import org.iitwforce.healthcare.lib.MMPLibrary;
import org.mmp.patientmodule.pages.EditProfilePage;
import org.mmp.patientmodule.pages.LoginPage;
import org.mmp.patientmodule.pages.MessagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SendMessagesE2ETests extends BaseClass {
	 	 @Test
		public void validateSendMessages()
		{
			MMPLibrary mmpLib = new MMPLibrary(driver);
			mmpLib.launchApplication(prop.getProperty("patientURL"));
			LoginPage patientLogin = new LoginPage(driver);
			patientLogin.login(prop.getProperty("patientUserName"),prop.getProperty("patientPassword"));
			mmpLib.navigation("Messages");
			MessagesPage patientMessages = new MessagesPage(driver);
			String reason="Fever and cold";//parameter 1
			String subject="To meet doctor Charlie";//parameter 2 
			String actual = patientMessages.sendMessages(reason,subject);
			String expected ="Messages Successfully sent.";
		 	mmpLib.navigation("Profile");
			EditProfilePage editProfilePage = new EditProfilePage(driver);
			//Fetch the patient name-3
			String patientFirstName= editProfilePage.fetchPatientFirstName();
			//Date - 4
			String date = AppLibrary.getfutureDate(0,"dd-MM-yyyy");
			HashMap<String,String> expectedHMap =  new HashMap<String,String>();//2 values
			expectedHMap.put("Reason", reason);
			expectedHMap.put("Subject",subject );
			expectedHMap.put("PtName", patientFirstName);
			expectedHMap.put("Date",date );
			SoftAssert sa =new SoftAssert();
			sa.assertEquals(actual,expected);
			
			//Login to Admin Module
			mmpLib.launchApplication(prop.getProperty("adminURL"));
			org.mmp.adminmodule.pages.LoginPage adminLogin = new org.mmp.adminmodule.pages.LoginPage(driver);
			adminLogin.login(prop.getProperty("adminUserName"),prop.getProperty("adminPassword"));
			mmpLib.navigation("Messages");
			org.mmp.adminmodule.pages.MessagesPage adminMessages = new org.mmp.adminmodule.pages.MessagesPage(driver);
			HashMap<String,String> actualHMap = adminMessages.fetchMessageDetails();//4 values
			sa.assertEquals(expectedHMap,actualHMap);
			System.out.println(expectedHMap);
			System.out.println(actualHMap);
			sa.assertAll();
			}
}
