package org.iitwforce.healthcare.lib;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class MMPLibrary {

	WebDriver driver;

	public MMPLibrary(WebDriver driver)
	{
		this.driver= driver;
	}

	public void navigation(String tabName)
	{
		driver.findElement(By.xpath("//a[contains(.,'"+tabName+"')]")).click();
	}

	public void launchApplication(String url )
	{
		driver.get(url);
	}
	public String handleAlert()
	{
		Alert alrt = driver.switchTo().alert();
		String successMsg = alrt.getText();
		alrt.accept();
		return successMsg;
	}
	public void captureScreenshot(String fileName) throws IOException
	{

		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(System.getProperty("user.dir")+"\\screenshots\\"+fileName);
		FileUtils.copyFile(SrcFile, DestFile);

	}
	public void captureFullScreenshot(String fileName) throws IOException, AWTException
	{

		// Instantiate the Robot Class
		Robot robotObject = new Robot();
		
		// Fetch the Details of the Screen Size
		Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		
		// Take the Snapshot of the Screen
        BufferedImage tmp = robotObject.createScreenCapture(screenSize); 
        
        // Provide the destination details to copy the screenshot
        String path=System.getProperty("user.dir")+"\\screenshots\\"+fileName+System.currentTimeMillis()+".jpg";
        
        // To copy source image in to destination path
        ImageIO.write(tmp, "jpg",new File(path)); 

	}
	

}
