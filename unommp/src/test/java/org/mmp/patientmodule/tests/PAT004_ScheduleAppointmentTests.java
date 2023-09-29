package org.mmp.patientmodule.tests;

import java.util.HashMap;

import org.iitwforce.healthcare.lib.BaseClass;
import org.iitwforce.healthcare.lib.MMPLibrary;
import org.mmp.patientmodule.pages.HomePage;
import org.mmp.patientmodule.pages.LoginPage;
import org.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PAT004_ScheduleAppointmentTests extends BaseClass{

	@Test
	public void validateBookAppointment()
	{
	 	MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchApplication(prop.getProperty("patientURL"));
		LoginPage lPage = new LoginPage(driver);
		lPage.login(prop.getProperty("patientUserName"),prop.getProperty("patientPassword"));
		mmpLib.navigation("Schedule Appointment");
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		HashMap<String,String> expectedHMap = sPage.bookAppointment();
		HomePage hPage = new HomePage(driver);
		HashMap<String,String> actualHMap = hPage.fetchPortalData();
		Assert.assertEquals(actualHMap,expectedHMap);

	}

}
