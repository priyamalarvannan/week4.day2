package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibraryTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	Assignment3:
			============
			1. Launch the URL https://html.com/tags/table/
			2. You have to print the respective values based on given Library
			(hint: if the library was absolute usage, then print all its value)*/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://html.com/tags/table");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> column = driver.findElements(By.xpath("(//table)[1]//th"));
		int colsize = column.size();
		System.out.println("the column size"+colsize);
		// to print column value
		for(int i=0;i<colsize;i++)
		{
			System.out.println(column.get(i).getText());
		}
	  
		List<WebElement> row = driver.findElements(By.xpath("(//table)[1]//tr[2]"));
		int rowsize = row.size();
		System.out.println(rowsize);
		for(int i=0;i<rowsize;i++)
		{
			System.out.println(row.get(i).getText());
		}
		
	}

}
