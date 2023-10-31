package org.mmp.patientmodule.tests;

import org.iitwforce.healthcare.lib.BaseClass;
import org.iitwforce.healthcare.lib.MMPLibrary;
import org.mmp.patientmodule.pages.InformationPage;
import org.mmp.patientmodule.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PAT_005_ViewInformationTests extends BaseClass {

	@Test
	public void validateInfoPage() {

		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchApplication(prop.getProperty("patientURL"));
		LoginPage lPage = new LoginPage(driver);
		lPage.login(prop.getProperty("patientUserName"), prop.getProperty("patientPassword"));
		mmpLib.navigation("Information");

		String expInfo = "Manage My Patient (MMP) is a medical practice management solution"
				+ " that boosts productivity by automating the day-to-day tasks that can slow an office manager down."
				+ " Central delivers much more than medical billing software. Sure, it has the tools to help generate "
				+ "cleaner claims and reduce denials, but our easy-to-use practice management"
				+ " software also streamlines your workflow to deliver seamless handoffs across departments.";

		InformationPage infoPage = new InformationPage(driver);
		String actInfo = infoPage.fetchInformation();
		System.out.println("Expected :" + expInfo);
		System.out.println("Actual :" + actInfo);
		Assert.assertEquals(expInfo, actInfo);

	}

}
