package PantrySystempackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PantryRegisterTesting {


	public static void AlreadyRegistered(WebDriver driver,WebElement element,String email,String name) throws InterruptedException
	{

		element= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/p[2]/span"));
		element.click();

		System.out.println("Able to open register page");
		Thread.sleep(1000);
		System.out.println("Register Test case 2:");
		element=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/form/div[1]/input"));
		element.sendKeys(email);
		Thread.sleep(1000);
		System.out.println("Able to write email id");
		element=driver.findElement(By.xpath("//input[@type='text'][@placeholder='Enter Name']"));
		element.sendKeys(name);
		Thread.sleep(1000);
		System.out.println("Able to write name");
	
		element=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/form/div[3]/input"));
		element.sendKeys("123456789");
		Thread.sleep(1000);
		System.out.println("Able to write password");
	
		element=driver.findElement(By.xpath("//*[@id=\"root\"]/di"
				+ "v/div[3]/div[2]/div/form/div[4]/input"));
		element.sendKeys("123456789");
		Thread.sleep(1000);
		System.out.println("Able to confirm password");
		
		element = driver.findElement(By.xpath("//button[@class=\"btn btn-dark\"]"));
		element.click();
		Thread.sleep(1000);
		System.out.println("Able to click submit btn");
		Thread.sleep(1000);
		element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/div"));
		String s= element.getText();
		if(s.equals("User already exists"))
		{
			System.out.println("testcase passed");
		}
		else
		{
			System.out.println("Test case failed");
		}
		Thread.sleep(1000);

//		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/form/div[1]/input")).clear();
//		driver.findElement(By.xpath("//input[@type='text'][@placeholder='Enter Name']")).clear();
//		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/form/div[3]/input")).clear();
//		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/form/div[4]/input")).clear();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]")).click();
		System.out.println("registerd page closed");
		
	}
	public static void CorrectRegisterCredentials(WebDriver driver,WebElement element,String email,String name) throws InterruptedException
	{

		element= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/p[2]/span"));
		element.click();

		System.out.println("Able to open register page");
		Thread.sleep(1000);
		System.out.println("Register Test case 1:");
		element=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/form/div[1]/input"));
		element.sendKeys(email);
		Thread.sleep(5000);
		System.out.println("Able to write email id");
		element=driver.findElement(By.xpath("//input[@type='text'][@placeholder='Enter Name']"));
		element.sendKeys(name);
		Thread.sleep(3000);
		System.out.println("Able to write name");
	
		element=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/form/div[3]/input"));
		element.sendKeys("123456789");
		Thread.sleep(3000);
		System.out.println("Able to write password");
	
		element=driver.findElement(By.xpath("//*[@id=\"root\"]/di"
				+ "v/div[3]/div[2]/div/form/div[4]/input"));
		element.sendKeys("123456789");
		Thread.sleep(3000);
		System.out.println("Able to confirm password");
		
		element = driver.findElement(By.xpath("//button[@class=\"btn btn-dark\"]"));
		element.click();
		Thread.sleep(3000);
		System.out.println("Able to click submit btn");
	}

	
	public static void InvalidPasswordCredentials(WebDriver driver,WebElement element) throws InterruptedException
	{
		
		element= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/p[2]/span"));
		element.click();

		System.out.println("Able to open register page");
		Thread.sleep(1000);
		System.out.println("Testcase 4");
		element=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/form/div[3]/input"));
		element.sendKeys("123456");
		Thread.sleep(3000);
		System.out.println("Able to write password");
		
		element = driver.findElement(By.xpath("//p[text()='Password length should be greater than 7']"));
		String actual=element.getText();
		
		String expected="Password length should be greater than 7";
		if(actual.equals(expected))
		{
			System.out.println("Testcase passed error is shown for invalid password");
		}
		else 
		{
			System.out.println("Testcase failed");
		}
//		
		element=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/form/div[3]/input"));
		element.clear();
		element.sendKeys("123456789");
		Thread.sleep(2000);
		element=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/form/div[4]/input"));
		element.sendKeys("12345678");
		Thread.sleep(2000);
		
		element=driver.findElement(By.xpath("//p[text() = \"Password don't match\"]"));
		String text = element.getText();
		String expectedtxt="Password don't match";
		if(text.equals(expectedtxt))
		{
			System.out.println("Testcase passed error is shown for confirm password");
		}
		else
		{
			System.out.println("Testcase failed error is not shown for confirm password");
		}
		Thread.sleep(1000);
		element = driver.findElement(By.xpath("//button[@class=\"btn btn-dark\"]"));
		Boolean isenabled=element.isEnabled();
		System.out.println(isenabled);
		if(!isenabled)
		{
			System.out.println("Testcase passed button is disabled for invalid password");
		}
		else
		{
			System.out.println("testcase failed");
		}

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]")).click();
		System.out.println("registerd page closed");
	}
	public static void IncorrectEmail(WebDriver driver,WebElement element) throws InterruptedException
	{
		element= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/p[2]/span"));
		element.click();

		System.out.println("Able to open register page");
		Thread.sleep(1000);
		
		System.out.println("Register Test case 3:");
		element=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/form/div[1]/input"));
		element.sendKeys("mansisahugmail.com");
		Thread.sleep(5000);
		
		element=driver.findElement(By.xpath("//p[text()='Enter valid Email']"));
		String actual=element.getText();
		//System.out.println(error);
		String expected="Enter valid Email";
		if(actual.equals(expected))
		{
			System.out.println("Testcase passed error is shown for invalid email");
		}
		else 
		{
			System.out.println("Testcase failed");
		}
		Thread.sleep(5000);
		element = driver.findElement(By.xpath("//button[@class=\"btn btn-dark\"]"));
		Boolean isenabled=element.isEnabled();
		System.out.println(isenabled);
		if(!isenabled)
		{
			System.out.println("Testcase passed button is disabled for invalid password");
		}
		else
		{
			System.out.println("testcase failed");
		}
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[2]/div/form/div[1]/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]")).click();
		System.out.println("registerd page closed");
		
	}
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","D:\\Selenium_Projects\\chromedriver.exe");
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		
		options.addArguments("–disable-web-security");
		options.addArguments("–allow-running-insecure-content");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		@SuppressWarnings("deprecation")
		WebDriver driver= new ChromeDriver(capabilities);
		
		//WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();
		WebElement element = null;
		
		PantryRegisterTesting.CorrectRegisterCredentials(driver, element, "iiaap@gmail.com", "Mansi Sahu");
		Thread.sleep(2000);

		PantryRegisterTesting.AlreadyRegistered(driver, element, "kaap@gmail.com", "Mansi Sahu");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		PantryRegisterTesting.IncorrectEmail(driver, element);
		Thread.sleep(3000);
		PantryRegisterTesting.InvalidPasswordCredentials(driver, element);
	}
}
