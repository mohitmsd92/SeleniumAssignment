package SeleniumTesting_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q12 {
	static WebDriver driver;

	@BeforeClass
	public void Initialize() {
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void FillTextBox() {
		WebElement FirstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		FirstName.sendKeys("Mohit");
		WebElement LastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		LastName.sendKeys("Dhande");
		WebElement Address = driver.findElement(By.xpath("//textarea[@rows='3']"));
		Address.sendKeys("Sec 18 Noida");
		WebElement Email = driver.findElement(By.xpath("//input[@type='email']"));
		Email.sendKeys("mohit.dhande@tothenew.com");
		WebElement PhoneNo = driver.findElement(By.xpath("//input[@type='tel']"));
		PhoneNo.sendKeys("7020397527");
		WebElement Pass1 = driver.findElement(By.xpath("//input[@id='firstpassword']"));
		Pass1.sendKeys("msd123");
		WebElement Pass2 = driver.findElement(By.xpath("//input[@id='secondpassword']"));
		Pass2.sendKeys("msd123");
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
}
