package SeleniumTesting_1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q3 {
	static WebDriver driver;

	public static void Initialize() {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	public static void GoogleSearch() {
		driver.get("https://www.google.com/");
		String Search = "To The New";
		driver.findElement(By.name("q")).sendKeys(Search + Keys.ENTER);
	}

	public static void main(String[] args) {
		Initialize();
		GoogleSearch();
		driver.close();
	}

}
