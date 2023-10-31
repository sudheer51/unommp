package org.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InformationPage {

	WebDriver driver;

	public InformationPage(WebDriver driver) {
		this.driver = driver;
	}

	public String fetchInformation() {
		String actualInfo = driver.findElement(By.xpath("//div[@class='panel-title']")).getText();
		String[] actual = actualInfo.split("\n");
		return actual[0].trim();
	}

}
