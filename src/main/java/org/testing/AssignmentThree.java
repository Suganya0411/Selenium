package org.testing;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AssignmentThree {


	RemoteWebDriver driver =null;
	String [] array =null;
	String curPrice = null;

	@Test (description = "TableInteractions")
	public void testcaseOne() {	

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MICROSECONDS);
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		WebElement stockTable = driver.findElementByXPath("//table[@class='dataTable']");

		//total number of row in stock table
		List<WebElement> numOfRows = stockTable.findElements(By.cssSelector("tbody tr"));	
		int rowCount = numOfRows.size();
		System.out.println("Blog archive-->"+rowCount);

		//total number of columns in stock table
		List<WebElement> numOfColumn = stockTable.findElements(By.cssSelector("th"));
		int columnCount = numOfColumn.size();
		System.out.println("numOfColumn-->"+columnCount);

		//maximum Current Price
		List<WebElement> p = driver.findElementsByXPath("//table[@class='dataTable']/tbody[1]/tr/td[4]");
		String [] beforeSort = new String[p.size()];
		for (int i = 0; i < p.size(); i++) {
			beforeSort[i]= p.get(i).getText();
		}
		System.out.println("********************************Before Sorting****************************************");
		Print(beforeSort);

		Arrays.sort(beforeSort,Collections.reverseOrder());

		System.out.println("********************************After Sorting****************************************");
		Print(beforeSort);

		driver.close();



	}

	public static void Print(String[] ar) {
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
	}

}

