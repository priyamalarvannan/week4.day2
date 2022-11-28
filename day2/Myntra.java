package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		/*12) Find the price of first displayed item
		Click on the first product
		13) Take a screen shot
		14) Click on WishList Now
		15) Close Browser*/


		WebDriverManager.chromedriver().setup();
		//disable notifications
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(ch);
		//1.Load the uRL 
		driver.get("https://www.myntra.com/");	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		//2) Mouse hover on MeN 
		Thread.sleep(3000);
		WebElement mousehov = driver.findElement(By.xpath("(//a[@class='desktop-main'])[1]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(mousehov).perform();
		//3) Click Jackets 
		driver.findElement(By.linkText("Jackets")).click();
		//	4) Find the total count of item 
		String totcount = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String count =totcount.replaceAll("[^0-9]", "");
		int counttot = Integer.parseInt(count);
		System.out.println(counttot);
		//5) Validate the sum of categories count matches
		String sum1 = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		String sum1count = sum1.replaceAll("[^0-9]", "");
		int totsum1 = Integer.parseInt(sum1count);
		System.out.println(totsum1);
		String sum2 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		String sum2count = sum2.replaceAll("[^0-9]", "");
		int totsum2 = Integer.parseInt(sum2count);
		
		System.out.println(totsum2);
		int total=totsum1+totsum2;
		System.out.println("the sum of categories"+total);
		if(counttot==total)
		{
			System.out.println("the total count is match");
		}
		else
		{
			System.out.println("does not match");
		}
		
		//6) Check jackets
		driver.findElement(By.xpath("//label[contains(@class,'common-customCheckbox')][1]")).click();
		//7) Click + More option under BRAND
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		//8) Type Duke and click checkbox
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
		driver.findElement(By.xpath("(//label[@class=' common-customCheckbox'])[1]")).click();
		//9) Close the pop-up x
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		//10) Confirm all the Coats are of brand Duke
	   // Hint : use List 
		Thread.sleep(2000);
		List<WebElement> brand = driver.findElements(By.className("product-brand"));
		String list="";
		System.out.println("size:"+brand.size());
		for(WebElement names:brand)
		{
			String namelist = names.getText();
			list=namelist;
		}
		if(list.contains("Duke"))
		{
			System.out.println("the brand name duke");
		}
		else
		{
			System.out.println("brand name is different");
		}
		//	11) Sort by Better Discount
		WebElement mouse1 = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		Actions builder1=new Actions(driver);
		builder1.moveToElement(mouse1).perform();
		driver.findElement(By.xpath("//input[@value='discount']//parent::label")).click();
		Thread.sleep(1000);
		//12) Find the price of first displayed item
		String price = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("the price of the first displayed item"+price);
		//13) Take a screen shot
		//Set<String> win = driver.getWindowHandles();
		//List<String>lstwin=new ArrayList<String>(win);
		//driver.switchTo().window(lstwin.get(1));
		driver.findElement(By.xpath("(//div[@class='product-productMetaInfo'])")).click();
		Set<String> wh = driver.getWindowHandles();
		List<String> win=new ArrayList<String>(wh);
		driver.switchTo().window(win.get(1));
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snap/myntra.png");
		FileUtils.copyFile(source, dest);
		//	14) Click on WishList Now
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		//15) Close Browser*/
		driver.close();
		
		}
	
	}
	


