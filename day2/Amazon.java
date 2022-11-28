package week4.day2;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
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

public class Amazon {

	/*
Amazon:
1.Load the uRL https://www.amazon.in/
2.search as oneplus 9 pro 
3.Get the price of the first product
4. Print the number of customer ratings for the first displayed product
5. Mouse Hover on the stars
6. Get the percentage of ratings for the 5 star.
7. Click the first text link of the first image
8. Take a screen shot of the product displayed
9. Click 'Add to Cart' button 
10. Get the cart subtotal and verify if it is correct.*/

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		//disable notifications
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(ch);
		//1.Load the uRL https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
		//2.search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus 9 pro",Keys.ENTER);
		//3.Get the price of the first product
		String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Price of the phone"+text);
		//4. Print the number of customer ratings for the first displayed product
		Thread.sleep(3000);
		String text2 = driver.findElement(By.xpath("(//a[contains(@class,'a-link-normal s-underline-text')]//span)[2]")).getText();
		System.out.println("The number of customer ratings"+text2);
		//5. Mouse Hover on the stars
		//WebElement mousehover = driver.findElement(By.xpath("(//i[contains(@class,'a-icon a-icon-star-small a-star')])[1]"));
		//Actions builder=new Actions(driver);
		//builder.moveToElement(mousehover).perform();
		driver.findElement(By.xpath("(//i[contains(@class,'a-icon a-icon-star-small a-star')])[1]")).click();
		//6. Get the percentage of ratings for the 5 star.
		String percent = driver.findElement(By.xpath("//table[@id='histogramTable']")).getText();
		System.out.println("the percentage"+percent);
		//7. Click the first text link of the first image
		driver.findElement(By.xpath("(//span[contains(@class,'a-size-medium a-color-base')])[2]")).click();
		//8. Take a screen shot of the product displayed
				File source = driver.getScreenshotAs(OutputType.FILE);
				File dest=new File("./snap/amazon.png");
				FileUtils.copyFile(source, dest);
		//9. Click 'Add to Cart' button 
				Set<String> window = driver.getWindowHandles();
				ArrayList<String>lstwin=new ArrayList<String>(window);
				driver.switchTo().window(lstwin.get(1));
				System.out.println(driver.getTitle());
				driver.findElement(By.id("add-to-cart-button")).click();
				
		//10. Get the cart subtotal and verify if it is correct.
				//String text3 = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
				String text3 = driver.findElement(By.xpath("(//span[text()='₹47,599.00'])[8]")).getText();
				System.out.println(text3);
				if(text.contains("47,599"))
				{
					System.out.println("equal");
				}
				else
				{
					System.out.println("different");
				}
}
}