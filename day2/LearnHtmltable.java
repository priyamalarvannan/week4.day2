package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnHtmltable {

	public static void main(String[] args) {
		/*Assignment2:
			============
			1. Launch the URL https://html.com/tags/table/
			2. Get the count of number of rows
			3. Get the count of number of columns*/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> column = driver.findElements(By.xpath("//table//th"));
		int size = column.size();
		System.out.println("the column size"+size);
		List<WebElement> row = driver.findElements(By.xpath("//table//tr"));
		int size2 = row.size();
		System.out.println("the  row size"+size2);
		
		
	}
}
