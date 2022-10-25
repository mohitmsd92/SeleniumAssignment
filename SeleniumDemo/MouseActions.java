package SeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\WebDrivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/buttons");
		Actions act = new Actions(driver);
		WebElement DoubleClickButton = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		//act.doubleClick(DoubleClickButton).perform();
		System.out.println("Double Click done");
		
		WebElement RightClick = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
		//act.contextClick().perform();
		System.out.println("Right Click done");
		
		WebElement Click = driver.findElement(By.xpath("//button[text()='Click Me']"));
		//act.click(Click).perform();
		System.out.println("Click done");
		
		act.doubleClick(DoubleClickButton).contextClick(RightClick).click(Click).build().perform();
		
	}

}
