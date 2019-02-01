package PantrySystempackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PantryHomeTesting1 {

	public static void MorningBeverage(WebDriver driver,WebElement element,String mrngitem) throws InterruptedException
	{
		System.out.println("Testing mrng beverage");
		element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[1]/div[2]/span[1]"));
		Thread.sleep(1000);
		String presentlyselected=element.getAttribute("innerHTML");
		
		element.click();
		Thread.sleep(2000);
		element=driver.findElement(By.xpath("//h3[text()='Morning Beverage']"));
		String text=element.getAttribute("innerHTML");
		System.out.println("text is "+text);
		if(text.equals("Morning Beverage"))
		{
			System.out.println("test case passed morning beverage pop up is used");

			Thread.sleep(2000);
			if(mrngitem.equals(presentlyselected))
			{
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[7]/div[1]")).click();
				System.out.println("Morning beverage closed");
			}
			else {
				element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[7]/div[2]/div/select"));
				Thread.sleep(1000);
				Select select =new Select(element);
				select.selectByVisibleText(mrngitem);
				Thread.sleep(1000);

				String beverage = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[1]/div[2]/span[1]")).getAttribute("innerHTML");
				if(beverage.equals(mrngitem))
				{
					System.out.println("Test case passed correct item selected");
				}
				else
				{
					System.out.println("Test case failed correct item not selected");
				}
			}
		}
		else
		{
			System.out.println("Test case failed popup of morning beverage is not displayed");
		}


	}
	public static void LunchSlotTesting(WebDriver driver,WebElement element,String lunchtime) throws InterruptedException
	{
		System.out.println("Testing lunchslot");

		element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[1]/div[2]/span[2]"));
		String presentlyselected =element.getAttribute("innerHTML");
		element.click();

		element=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[3]/div[2]/div/h3"));
		String lunch=element.getAttribute("innerHTML");
		if(lunch.equals("Lunch Slot"))
		{
			System.out.println("test case passed lunch slot pop box is open");
			Thread.sleep(2000);

			if(presentlyselected.equals(lunchtime))
			{
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[3]/div[1]")).click();
				System.out.println("Lunc slot pop-up closed");
			}
			else {
				element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[3]/div[2]/div/select"));

				Select select = new Select(element);
				select.selectByVisibleText(lunchtime);
				Thread.sleep(2000);
			}
		}
		else {
			System.out.println("Test case failed");
		}

	}
	public static void EveningBeverage(WebDriver driver,WebElement element,String evengitm) throws InterruptedException
	{
		System.out.println("Testing EveningBeverage");

		element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[1]/div[2]/span[3]"));
		String presentlyselected =element.getAttribute("innerHTML");
		element.click();
		Thread.sleep(2000);
		element=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[5]/div[2]/div/h3"));
		String lunch=element.getAttribute("innerHTML");
		if(lunch.equals("Evening Beverage"))
		{
			System.out.println("test case passed Evening Beverage pop box is open");
			Thread.sleep(2000);
			
			if(presentlyselected.equals(evengitm))
			{
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[5]/div[1]")).click();
				
				System.out.println("Evening Beverage pop-up closed");	Thread.sleep(2000);
				
				
			}
			
			else {
				element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div[5]/div[2]/div/select"));
				
				Select select = new Select(element);
				Thread.sleep(2000);
				
				select.selectByVisibleText(evengitm);
				Thread.sleep(2000);
			}
		}
		else {
			System.out.println("Test case failed");
		}

	}
	
		
}
