package PantrySystempackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PantryOrderTesting {

	public static void Selecting(WebDriver driver,WebElement element) throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul[1]/li/i")).click();
		Thread.sleep(2000);
		System.out.println("Able to click the navigation btn");
		element =driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/ul/a[2]/li"));
		String s=element.getText();
		
		if(s.equals("Order"))
		{
			System.out.println("test case passed able to see the order link");
		}
		else
		{
			System.out.println("Order link is not visisble");
		}
		element.click();
		System.out.println("Able to click orders button");
		
	}
	public static void EmptyOrdersTesting(WebDriver driver,WebElement element) throws InterruptedException
	{
		Selecting(driver, element);
		Thread.sleep(2000);
		
		boolean isEnabled = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[2]/div[3]/button")).isEnabled();
		
		System.out.println(isEnabled);
		if(!isEnabled)
		{
			System.out.println("Testcase passed button is disabled if no item from inventory is selected");
		}
		else
		{
			System.out.println("Testcase failed button is enabled if no item from inventory is selected");
		}
	}
	
	public static void testingSingleOrderSummary(WebDriver driver,WebElement element,String number) throws InterruptedException
	{
		Thread.sleep(2000);
		List<WebElement> items =driver.findElements(By.xpath("//div[starts-with(@class,'Item_Item')]"));
		
		element =items.get(0);
		String txt =element.findElement(By.xpath("//div[text()='Sandwich']")).getText();
		System.out.println(txt);
		
		for(int i=0;i<Integer.parseInt(number);i++)
		{
			element.findElement(By.xpath("//button[@class='btn btn-success']")).click();
			System.out.println("Element clicked");
			Thread.sleep(2000);
		}
		Thread.sleep(3000);
		String x =driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[2]/div[2]/div/p[1]")).getText();
		System.out.println(x);
				Thread.sleep(2000);
		if(x.equals(number+" "+txt))
		{
			
			System.out.println("Test case passed same element is displayed");
		}
		else
		{
			System.out.println("failed");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[2]/div[3]/button")).click();
		
		System.out.println("Able to click placeorder button ");
		
		Thread.sleep(3000);
		String summarytext =driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[1]/p")).getAttribute("innerHTML");
		////*[@id="root"]/div/div[4]/div/div/p
		System.out.println(summarytext);
		if(summarytext.equals(number+" "+txt))
		{
			System.out.println("test case passed same order history is displayed");
		}
		else
		{
			System.out.println("test case failed same order history is not displayed");
		}
		Thread.sleep(1000);
		driver.navigate().back();
		
	}
	public static void DifferentOrderstesting(WebDriver driver, WebElement element) throws InterruptedException {
		// TODO Auto-generated method stub
		Selecting(driver, element);
		Thread.sleep(2000);
		WebElement element2;
		List<WebElement> items =driver.findElements(By.xpath("//div[starts-with(@class,'Item_Item')]"));
		
		element =items.get(0);
		String txt =element.findElement(By.xpath("//div[text()='Sandwich']")).getText();
		System.out.println(txt);
		
		element.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		System.out.println("Element clicked");
		Thread.sleep(2000);
		
		element =items.get(1);
		element2 =element.findElement(By.xpath("//div[text()='Peanuts']"));
		String txt2 = element2.getText();
		System.out.println(txt2);
		
		element2.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[1]/div[1]/div/div[2]/div[2]/button")).click();
		System.out.println("Element clicked");
		Thread.sleep(2000);
		
		String text = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[2]/div[2]/div[1]/p[1]")).getText();
		System.out.println(text);
		if(text.equals("1 Sandwich"))
		{
			System.out.println("Test case passed for sandwich");
		}
		else
		{
			System.out.println("Test case failed for sandwich");
		}
		String text2 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[2]/div[2]/div[2]/p[1]")).getText();
		System.out.println(text2);
		if(text2.equals("1 Peanuts"))
		{
			System.out.println("Test case passed for peanuts");
		}
		else
		{
			System.out.println("Test case failed for peanuts");
		
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[2]/div[3]/button")).click();
		System.out.println("placeorder clicked");
		
		Thread.sleep(4000);
		String summarytext =driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[2]/p[1]")).getAttribute("innerHTML");
		System.out.println(summarytext);
		if(summarytext.equals("1 Sandwich"))
		{
			System.out.println("test case passed same order history for Sandwich is displayed");
		}
		else
		{
			System.out.println("test case failed same order history is not displayed");
		}
		Thread.sleep(1000);
		String summarytext2 =driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div[2]/p[2]")).getAttribute("innerHTML");
		
		if(summarytext2.equals("1 Peanuts"))
		{
			System.out.println("test case passed same order history for Peanuts is displayed");
		}
		else
		{
			System.out.println("test case failed same order history is not displayed");
		}
		driver.navigate().back();
	}
	
	
}
