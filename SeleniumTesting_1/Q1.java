package SeleniumTesting_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Q1 {
	static WebDriver driver;

	public static void Initialize() {
		System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\WebDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

	}

	public static void OpenURL() {
		String Url = "https://www.google.com/";
		driver.get(Url);
	}

	public static void Close() {
		driver.close();
	}
	public static void main(String[] args) {
		Initialize();
		OpenURL();
		Close();
	}

}
