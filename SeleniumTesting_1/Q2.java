package SeleniumTesting_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Q2 {
	static WebDriver driver;

	public static void Initialize() {
		System.setProperty("webdriver.edge.driver", "D:\\Softwares\\WebDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();

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
