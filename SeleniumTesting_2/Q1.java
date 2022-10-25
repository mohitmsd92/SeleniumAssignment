package SeleniumTesting_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

//Q1- Launch Firefox browser & navigate to https://rahulshettyacademy.com/AutomationPractice/
//Try to Fetch the alert popup text.
//Try to Dismiss the popup.
//Try to enter some data on an alert popup.
//Try to accept the popup.
@Test
public class Q1 {
	static WebDriver driver;

	@BeforeClass
	public void Initialize() {
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void PopUp_Operations() {
		WebElement AlertBtn = driver.findElement(By.xpath("//input[@id='alertbtn']"));
		AlertBtn.click();
		Alert alert = driver.switchTo().alert();
		String AlertBeforeClick = alert.getText();
		alert.accept();
		String ExpectedAlertText1 = "Hello , share this practice page and share your knowledge";
		Assert.assertEquals(AlertBeforeClick, ExpectedAlertText1);
		System.out.println("Alert Without Text is " + AlertBeforeClick);

		WebElement AlertTextBox = driver.findElement(By.xpath("//input[@id='name']"));
		AlertTextBox.sendKeys("Mohit");
		AlertBtn.click();
		String AlertAfterClick = alert.getText();
		alert.accept();
		String ExpectedAlertText2 = "Hello Mohit, share this practice page and share your knowledge";
		Assert.assertEquals(AlertAfterClick, ExpectedAlertText2);
		System.out.println("Alert With Text is " + AlertAfterClick);

	}

	@AfterClass
	public void close() {
		driver.close();
	}

}
