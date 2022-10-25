package SeleniumTesting_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Write a script to get the title of the “Contact Us” page.
public class Q5 {
	static WebDriver driver;

	public static void Initialize() {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	public static void OpenURL() {
		String Url = "https://www.tothenew.com/";
		driver.get(Url);
	}

	public static void NavigateToContactUs() {

		driver.findElement(By.xpath("//*[@id='h-contact-us']")).click();

	}

	public static void GetTitle() {
		System.out.println(driver.getTitle());
	}

	public static void Close() {
		driver.close();
	}

	public static void main(String[] args) {
		Initialize();
		OpenURL();
		NavigateToContactUs();
		GetTitle();
		Close();
	}
}
