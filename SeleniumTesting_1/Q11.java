package SeleniumTesting_1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q11 {

	static WebDriver driver;

	public static void Initialize() {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	public static void OpenURL() {
		String Url = "http://demo.automationtesting.in/Register.html";
		driver.get(Url);
		driver.manage().window().maximize();
		
	}

	public static void HandleDropDowns() {

		driver.findElement(By.id("msdd")).click();
		List<WebElement> Language = driver.findElements(By
				.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li"));
		Language.get(7).click();

		List<WebElement> Skills = driver.findElements(By.xpath("//select[@id='Skills']/option"));
		Skills.get(25).click();

		driver.findElement(By.xpath("//span[@role='combobox']")).click();
		List<WebElement> Country = driver.findElements(By.xpath("//ul[@role='tree']/li"));
		Country.get(5).click();

		List<WebElement> Year = driver.findElements(By.xpath("//select[@id='yearbox']/option"));
		Year.get(79).click();

		List<WebElement> Month = driver.findElements(By.xpath("//select[@placeholder='Month']/option"));
		Month.get(5).click();

		List<WebElement> Day = driver.findElements(By.xpath("//select[@id='daybox']/option"));
		Day.get(20).click();
	}

	public static void HandleRadioButtons() {

		List<WebElement> Gender = driver.findElements(By.xpath("//input[@type='radio']"));
		Gender.get(0).click();
	}

	public static void HandleCheckBox() {
		List<WebElement> Hobbies = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int i = 0; i < Hobbies.size(); i++) {
			Hobbies.get(i).click();
		}
	}

	public static void FillTextBox() {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Mohit");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Dhande");
		driver.findElement(By.xpath("//textarea[@rows='3']")).sendKeys("Sec 18 Noida");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("mohit.dhande@tothenew.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("7020397527");
		driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys("msd123");
		driver.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys("msd123");
	}

	public static void Validations() {
		boolean btnPresence = driver.findElement(By.xpath("//button[@id='Button1']")).isEnabled();
		System.out.println("Referesh Button Enabled = " + btnPresence);

		boolean GenderSelect = driver.findElement(By.xpath("//input[@value='Male']")).isSelected();
		System.out.println("Male Gender selected = " + GenderSelect);

		String Header = "Automation Demo Site";
		WebElement PageHeader = driver.findElement(By.xpath("//*[text()='Automation Demo Site ']"));
		String CurrentPageHeader = PageHeader.getText();
		System.out.println(
				"Header of Registration Page is Automation Demo Site = " + Header.equalsIgnoreCase(CurrentPageHeader));

		String Title = "Register";
		String CurrentPageTitle = driver.getTitle();
		System.out.println("Title of Page is Register = " + Title.equalsIgnoreCase(CurrentPageTitle));
	}

	public static void main(String[] args) throws Exception {
		Initialize();
		OpenURL();
		FillTextBox();
		HandleRadioButtons();
		HandleCheckBox();
		HandleDropDowns();
		Validations();

		Thread.sleep(10000);
		driver.close();
	}

}
