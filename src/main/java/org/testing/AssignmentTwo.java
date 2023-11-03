package org.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssignmentTwo {


	RemoteWebDriver driver =null;

	@Test (description = "JS.Alerts")
	public void testcaseOne() {	

		System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//driver = new ChromeDriver();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MICROSECONDS);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElementByXPath("//button[@onclick='jsAlert()']").click();
		Alert jsAlert = driver.switchTo().alert();
		jsAlert.accept();
		String jsAlertText = driver.findElementByXPath("//p[@id='result']").getText();
		Assert.assertEquals(jsAlertText, "You successfully clicked an alert");
		
				
		driver.findElementByXPath("//button[@onclick='jsConfirm()']").click();
		Alert jsConfirm = driver.switchTo().alert();
		jsConfirm.accept();
		String jsConfirmText = driver.findElementByXPath("//p[@id='result']").getText();
		Assert.assertEquals(jsConfirmText, "You clicked: Ok");
				
		
		driver.findElementByXPath("//button[@onclick='jsConfirm()']").click();
		Alert jsConfirmDismiss = driver.switchTo().alert();
		jsConfirmDismiss.dismiss();
		String jsConfirmDismissText = driver.findElementByXPath("//p[@id='result']").getText();
		Assert.assertEquals(jsConfirmDismissText, "You clicked: Cancel");
		
		
		driver.findElementByXPath("//button[@onclick='jsPrompt()']").click();
		Alert jsPrompt = driver.switchTo().alert();
		String sendText = "Hi Prompt";
		jsPrompt.sendKeys(sendText);
		jsPrompt.accept();
		
		String jsPromptText = driver.findElementByXPath("//p[@id='result']").getText();
		Assert.assertEquals(jsPromptText, "You entered: Hi Prompt");
		
		driver.close();
	}

	}
