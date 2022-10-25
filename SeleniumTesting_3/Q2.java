package SeleniumTesting_3;

import java.util.List;
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

//2. Go to TTN website https://www.tothenew.com/ and
//verify the options under Services dropdown
public class Q2 {
	static WebDriver driver;
	Actions act;

	@BeforeClass
	public void Initialize() {
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.tothenew.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Verify_Options_in_Service_DropDown() {
		act = new Actions(driver);
		WebElement Service = driver.findElement(By.xpath("(//a[@id='h-Services'])[2]"));
		act.moveToElement(Service).perform();
		List<WebElement> ServiceDropDown = driver
				.findElements(By.xpath("(//li[@class='menu-item menu-expanded'])[4]//ul/li"));
		for (int i = 0; i < ServiceDropDown.size(); i++) {
			System.out.println(ServiceDropDown.get(i).getText());
			System.out.println("*********************************");
		}
		String S1 = ServiceDropDown.get(0).getText();
		String S2 = ServiceDropDown.get(1).getText();
		String S3 = ServiceDropDown.get(2).getText();
		String S4 = ServiceDropDown.get(3).getText();
		String S5 = ServiceDropDown.get(4).getText();
		String S6 = ServiceDropDown.get(5).getText();

		Assert.assertEquals(S1, "Digital Engineering");
		Assert.assertEquals(S2, "Cloud & DevOps");
		Assert.assertEquals(S3, "OTT Solutions & Services");
		Assert.assertEquals(S4, "Data & Analytics");
		Assert.assertEquals(S5, "CX, Content & Commerce");
		Assert.assertEquals(S6, "Digital Marketing");

	}

	@AfterClass
	public void close() {
		// driver.close();
	}
}
