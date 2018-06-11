package com.weboder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {
	
public static void main(String args[]) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","/Users/lesia/Documents/selenium dependencies/drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		
		driver.findElement(By.cssSelector("a[href='Process.aspx']")).click();
		Thread.sleep(2000);
		
		Random rand = new Random();
		Thread.sleep(2000);
		
		int i = rand.nextInt(100);
		String str = "" + i;
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(str);
		Thread.sleep(2000);
		
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 5;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int j = 0; j < targetStringLength; j++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	 
	    System.out.println(generatedString);
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John " + generatedString + " Smith");
		Thread.sleep(2000);
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
		Thread.sleep(2000);
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Any city");
		Thread.sleep(2000);
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
		Thread.sleep(2000);
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("10000");

		Thread.sleep(2000);
		
		Thread.sleep(1000);

		Random r = new Random();
		
		String[] arr = { "ctl00_MainContent_fmwOrder_cardList_0", "ctl00_MainContent_fmwOrder_cardList_1",
				"ctl00_MainContent_fmwOrder_cardList_2" };
		
		String name = arr[r.nextInt(arr.length)];
		
		driver.findElement(By.cssSelector("input[id=" + name + "]")).click();

		if (name.equals("ctl00_MainContent_fmwOrder_cardList_0")) {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("444565489");

		} else if (name.equals("ctl00_MainContent_fmwOrder_cardList_1")) {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("553565979");

		} else {
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("346378965");
		}

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("06/19");
		Thread.sleep(2500);
		driver.findElement(By.cssSelector("a[id='ctl00_MainContent_fmwOrder_InsertButton']")).click();

		
		String expected = "New order has been successfully added";
		String actual = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong"))
                .getText();
		if (actual.equalsIgnoreCase(expected)) {
			System.out.println("pass " + actual);
		}
		else {
			System.out.println("fail " + actual);
		}
//		String pageSource = driver.getPageSource();
//       
//		if(pageSource.contains("New order has been successfully added")){
//            System.out.println("2) Expected text '"+expected+"' present in the web page.");
//        }else{
//            System.out.println("2) Expected text '"+expected+"' is not present in the web page.");
//        }
		
		
		}
}


