package PantrySystempackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PantryLoginTesting {

	public static void LoginInvalidUsername(WebDriver driver,WebElement element) throws InterruptedException
	{

		//username incorrect and password correct
		System.out.println("Test case 2");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div[1]/input")).sendKeys("ssbabbar97gmail.com");
		System.out.println("Able to type username");
		Thread.sleep(5000);
	
		element = driver.findElement(By.xpath("//p[text()='Enter valid Email']"));
		Thread.sleep(2000);
		
		String s=element.getAttribute("innerHTML");
		String errormsg="Enter valid Email";
		if(s.equals(errormsg))
		{
			System.out.println("Test case passed error msg is shown for invalid id");
		}
		else
		{
			System.out.println("Test case failed");
		}
		Thread.sleep(5000);
		element = driver.findElement(By.xpath("//button[@class=\"btn btn-success\" and text()='Login']"));
		Thread.sleep(2000);
		//boolean isDisplayed = element.isDisplayed();
		boolean isEnabled =element.isSelected();
		
		System.out.println(isEnabled);
		//System.out.println(isDisplayed);
		if(!isEnabled)
		{
			System.out.println("Test case passed for invalid id login button is disabled");
		}
		else
		{
			System.out.println("Testcase failed for invalid id login button is not disabled");
		}
					
	}
	
	public static void logininvalidCredentials(WebDriver driver,WebElement element) throws InterruptedException
	{
		System.out.println("Test case 3");
		element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div[1]/input"));
		element.clear();
		element.sendKeys("mansi7@gmail.com");
		Thread.sleep(2000);
		System.out.println("Able to type username");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div[2]/input")).sendKeys("Babbar_97");
		System.out.println("Able to type password");
		Thread.sleep(2000);
		
		element = driver.findElement(By.xpath("//button[@class=\"btn btn-success\" and text()='Login']"));
		element.click();
		
		Thread.sleep(5000);
		element = driver.findElement(By.xpath("//div[@class=\"alert alert-danger\" and text()='Invalid Credentials']"));
		Thread.sleep(2000);
		String error=element.getText();
		String msg="Invalid Credentials";
		if(error.equals(msg))
		{
			System.out.println("Test case passed for invalid credentials");
		}
		else
		{
			System.out.println("Test case failed for invalid credentials");
		}

	}
	public static void loginvalidCredentials(WebDriver driver,WebElement element,Boolean logoutState) throws InterruptedException
	{
		System.out.println("TestCase 1");
		element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div[1]/input"));
		element.clear();
		element.sendKeys("paaap@gmail.com");
		System.out.println("Able to type username");
		element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div[2]/input"));
		element.clear();
		element.sendKeys("12345678");
		System.out.println("Able to type password");
		element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/form/div[3]"));
		boolean Enabled =element.isEnabled();
		if(Enabled)
		{
			System.out.println("Correct credentials syntactically Login button enabled");
		}
		element.click();
		System.out.println("Able to login with correct credentials");
		
		if(logoutState)
		{
		LogoutTesting.LogoutTest(driver, element);
		}
		
		}

}
