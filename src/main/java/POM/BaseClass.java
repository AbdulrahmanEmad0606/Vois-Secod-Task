package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public static WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
		driver.manage().window().maximize();
	}
	
	public static WebDriver get_driver()
	{
		return driver;
	}
}
