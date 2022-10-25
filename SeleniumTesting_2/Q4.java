package SeleniumTesting_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//Q4-Open this URL(https://demoqa.com/) and 
//perofrm drag and drop,right-click using Action class 
public class Q4 {
	static WebDriver driver;
	static Actions act;

	@BeforeClass
	public void Initialize() {
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.get("https://demoqa.com/droppable/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void DragNDrop() {
		WebElement DragElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement DropElement = driver.findElement(By.xpath("//div[@id='droppable']"));
		act = new Actions(driver);
		act.dragAndDrop(DragElement, DropElement).perform();
		String ExpectedTextAfterDrop = "Dropped!";
		String TextAfterDrop = driver.findElement(By.xpath("(//div[@id='droppable']/p)[1]")).getText();
		Assert.assertEquals(ExpectedTextAfterDrop, TextAfterDrop);
	}

	@AfterClass
	public void close() {
		driver.close();
	}
}
