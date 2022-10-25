package SeleniumTesting_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Q4 {
	static WebDriver driver;

	public static void Initialize() {
		System.setProperty("webdriver.edge.driver", "D:\\Softwares\\WebDrivers\\chromedriver.exe");
		driver = new EdgeDriver();

	}

	public static void OpenURL() {
		String Url = "https://www.tothenew.com/";
		driver.get(Url);
	}

	public static void NavigateByXpath() {

		driver.findElement(By.xpath("//*[@id='h-contact-us']")).click();
		driver.navigate().back();
	}

	public static void NavigateById() {

		driver.findElement(By.id("h-contact-us")).click();
	
	}
	public static void Close() {
		driver.close();
	}

	public static void main(String[] args) {
		Initialize();
		OpenURL();
		NavigateByXpath();
		NavigateById();
		Close();
	}
}
