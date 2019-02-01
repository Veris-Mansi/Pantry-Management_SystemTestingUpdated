package PantrySystempackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutTesting {

	public static void LogoutTest(WebDriver driver,WebElement element) throws InterruptedException
	{
		Thread.sleep(10000);
		element=driver.findElement((By.xpath("//*[@id=\"root\"]/div/div[1]/ul[2]/li/a")));
		element.click();
		System.out.println("Able to press logout button");
		driver.navigate().refresh();

	}
}
