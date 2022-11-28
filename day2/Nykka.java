package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykka {

	public static void main(String[] args) throws InterruptedException {
		/*Assignment 5:Nykaa
=============


1) Go to https://www.nykaa.com/
2) Mouseover on Brands and Search L'Oreal Paris
3) Click L'Oreal Paris
4) Check the title contains L'Oreal Paris(Hint-GetTitle)
5) Click sort By and select customer top rated
6) Click Category and click Hair->Click haircare->Shampoo
7) Click->Concern->Color Protection
8)check whether the Filter is applied with Shampoo
9) Click on L'Oreal Paris Colour Protect Shampoo
10) GO to the new window and select size as 175ml
11) Print the MRP of the product
12) Click on ADD to BAG
13) Go to Shopping Bag 
14) Print the Grand Total amount
15) Click Proceed
16) Click on Continue as Guest
17) Check if this grand total is the same in step 14
18) Close all windows*/
		WebDriverManager.chromedriver().setup();
		//disable notifications
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(ch);
		driver.get("https://www.nykaa.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//2) Mouseover on Brands and Search L'Oreal Paris
		WebElement mouse = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder=new Actions(driver);
		builder.moveToElement(mouse).perform();
		//driver.findElement(By.xpath("(//img[@alt='banner'])[1]")).click();
		//3) Click L'Oreal Paris
		driver.findElement(By.xpath("//*[@id=\"brandCont_Popular\"]/ul/li[5]/a/img")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='control-indicator checkbox ']")).click();
		//driver.findElement(By.xpath("(//span[text()='Shampoo'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		//verify filter is applied
		 String filter = driver.findElement(By.xpath("//span[text()='Filters Applied']")).getText();
		 //System.out.println(filter);
		if(filter.contains("Filters Applied"))
		{
			System.out.println("fillter applied");
					}
		else
		{
	
			System.out.println("not applied");

	}
	//GO to the new window and select size as 175ml
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='css-qlopj4']")).click();
		Thread.sleep(3000);
		Set<String> newwin = driver.getWindowHandles();
		System.out.println(newwin.size());
		List<String> lstwindow=new ArrayList<String>(newwin);
		driver.switchTo().window(lstwindow.get(1));
		WebElement bottlesize = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select bot =new Select(bottlesize);
		bot.selectByIndex(1);
	// Print the MRP of the product
		String mrp = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[2]")).getText();
		System.out.println("the MRP of the product"+mrp);
		Thread.sleep(3000);
		//Click on ADD to BAG
		driver.findElement(By.xpath("(//button[@class=' css-12z4fj0']/span)[2]")).click();
		Set<String> newwin1 = driver.getWindowHandles();
		System.out.println(newwin1.size());
		List<String> lstwindow1=new ArrayList<String>(newwin1);
		driver.switchTo().window(lstwindow1.get(1));
		//Go to Shopping Bag 
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();
		//Print the Grand Total amount
		//Thread.sleep(3000);
		//String gratot = driver.findElement(By.xpath("//span[@class='css-1u842i8 e171rb9k3']")).getText();
		//System.out.println(gratot);
		//Click Proceed
		driver.switchTo().frame(0);
		Thread.sleep(1000);
		//String GrandTot = driver.findElement(By.xpath("(//span[text()='Grand Total']/preceding::span)[1]")).getText().substring(1);
		String GrandTot =driver.findElement(By.xpath("//div[contains(@class,'footer-layout')]//div//div//div[1]//span")).getText();
		System.out.println(GrandTot);
		//15) Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		//16) Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		//17) Check if this grand total is the same in step 14
				String tot = driver.findElement(By.xpath("//p[text()='₹240']")).getText();
				System.out.println(tot);
				if(GrandTot.contains(tot))
				{
					System.out.println("same");
				}
				else
				{
					System.out.println("different");
				}
		
		
		
	}
	}

	
	


