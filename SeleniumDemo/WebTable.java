package SeleniumDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTable {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "D:\\Softwares\\WebDrivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		driver.get("https://demo.guru99.com/test/web-table-element.php");

		List<WebElement> rows = driver.findElements(By.xpath("(//table[@class='dataTable'])//tr"));
		wait.until(ExpectedConditions.visibilityOfAllElements(rows));
		List<WebElement> columns = driver.findElements(By.xpath("(//table[@class='dataTable'])//th"));
		wait.until(ExpectedConditions.visibilityOfAllElements(columns));
		System.out.println(rows.size());
		System.out.println(columns.size());

	}

}
