package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.graphbuilder.struc.LinkedList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Stock {

	
	/*Assignment1:
		============
		
		2. Click on stock market
		3. Click on NSE bulk Deals
		    hint-(Table-2)
		4. Get all the Security names
		5. Ensure whether there are duplicate Security names*/
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.chittorgarh.com/");        
    //2. Click on stock market
    driver.findElement(By.xpath("//a[text()='STOCK MARKET ']")).click();
    //3. Click on NSE bulk Deals
    driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();        
    //4. Get all the Security names
    List<WebElement> securityWeb = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//td[3]"));        
    ArrayList<String> securityNames=new ArrayList<String>();
       
    for (int i = 0; i < securityWeb.size(); i++) {            
        String text = securityWeb.get(i).getText();            
        securityNames.add(text);            
    }
     System.out.println(securityNames);
   
    //5. Ensure whether there are duplicate Security names        
    Set<String> secSet = new HashSet<String>(securityNames);
   if (securityNames.size()!=secSet.size()) {
    System.out.println("Ensured it has duplicate");
   }
   else
   {
	   System.out.println("it does not have duplicate");
   }
	 
}
}
