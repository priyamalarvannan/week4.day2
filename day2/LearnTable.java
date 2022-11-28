package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://testleaf.herokuapp.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//column size
		List<WebElement> column = driver.findElements(By.xpath("//table//th"));
		int size = column.size();
		System.out.println("the column size"+size);
		//row size
		 List<WebElement> row = driver.findElements(By.xpath("//table//tr"));
		 int rowsize = row.size();
		System.out.println("the row size"+rowsize);
		//get the progress value of learn to interact with elements
		WebElement percent = driver.findElement(By.xpath("//td[normalize-space()='Learn to interact with Elements']//following::td[1]"));
		String percentage = percent.getText();
		System.out.println(percentage);
		
		
		
	//vital task for least completed progress
		List<WebElement> progress = driver.findElements(By.xpath("//table//td[2]"));
		List<Integer> intlist=new ArrayList<Integer>();
		for(int i=0;i<progress.size();i++)
		{
			String text = progress.get(i).getText();
			String replaced = text.replaceAll("[^0-9]", "");
			//System.out.println(replaced);
			int parseInt = Integer.parseInt(replaced);
			intlist.add(parseInt);
		}
		System.out.println(intlist);
			Collections.sort(intlist);
			Integer integer = intlist.get(0);
			driver.findElement(By.xpath("//font[contains(text(),'"+integer+"%')]/following::input")).click();
		}
		
	}


