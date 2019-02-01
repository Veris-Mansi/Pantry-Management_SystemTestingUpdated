package PantrySystempackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CompleteTesting {

	public static void main(String a[]) throws InterruptedException
	{
System.setProperty("webdriver.chrome.driver","D:\\Selenium_Projects\\chromedriver.exe");
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		
		options.addArguments("–disable-web-security");
		options.addArguments("–allow-running-insecure-content");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		@SuppressWarnings("deprecation")
		WebDriver driver= new ChromeDriver(capabilities);
		
		driver.get("http://localhost:3000/");
		//driver.manage().window().maximize();
		WebElement element = null;
		//int j=6;
		
		PantryLoginTesting.loginvalidCredentials(driver, element, true);
		Thread.sleep(2000);
		
		PantryLoginTesting.LoginInvalidUsername(driver, element);
		Thread.sleep(2000);
		
		PantryLoginTesting.logininvalidCredentials(driver, element);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		PantryRegisterTesting.CorrectRegisterCredentials(driver, element, "qokkowii@gmail.com", "Prrrachi Singh");
		Thread.sleep(2000);
		
		PantryRegisterTesting.AlreadyRegistered(driver, element, "maa@gmail.com", "Mansi Sahu");
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		PantryRegisterTesting.IncorrectEmail(driver, element);
		Thread.sleep(2000);
		
		PantryRegisterTesting.InvalidPasswordCredentials(driver, element);
		Thread.sleep(2000);
//		
		PantryLoginTesting.loginvalidCredentials(driver, element,false);
		Thread.sleep(10000);
		//driver.navigate().refresh();
		PantryHomeTesting1.MorningBeverage(driver, element,"Coffee");
		Thread.sleep(3000);
//		PantryHomeTesting.LunchSlotTesting(driver, element, "2:00 - 2:30");
//		Thread.sleep(3000);
		PantryHomeTesting1.EveningBeverage(driver, element, "Tea");
		Thread.sleep(2000);
		//j++;
		Thread.sleep(2000);
		PantryOrderTesting.EmptyOrdersTesting(driver, element);
		Thread.sleep(2000);
		PantryOrderTesting.testingSingleOrderSummary(driver, element, "2");
		Thread.sleep(2000);
		PantryOrderTesting.DifferentOrderstesting(driver, element);
	}
}
