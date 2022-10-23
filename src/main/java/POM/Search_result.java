package POM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Search_result {

	public static void find_available_seats() {

		BaseClass.get_driver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> buses;
		while (true) {
			buses = BaseClass.get_driver().findElements(By.xpath("/html/body/main/form/section/div/div[6]/div[3]/div"));
			if (buses.size() <= 1)
				BaseClass.get_driver()
						.findElement(By.xpath("/html/body/main/form/section/div/div[1]/div[1]/div[3]/div[2]/a[2]"))
						.click();         
			else
				break;
		}

		for (WebElement bus : buses) {
			String text = bus.getAttribute("stcount");
			if (text != null) {
				bus.findElement(By.cssSelector("input[value=\"Select Seats\"]")).click(); 
				break;
			}

		}

	}

	public static void select_available_seat() {
		List<WebElement> seats = BaseClass.get_driver().findElements(By.xpath(
				"/html/body/main/form/section/div/div[6]/div[3]/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[1]/div/div[1]/div/div/div/ul"));
		for (WebElement seat : seats) {
			try {
				seat.findElement(By.cssSelector("li[class=\"availSeatClassS\"]")).click();
				break;
			} catch (NoSuchElementException e) {
				continue;
			}
		}
	}

	public static void complete_passenger_details(String name, String gender, String age) {
		WebElement name_field = BaseClass.get_driver().findElement(By.id("passengerNameForward0"));
		name_field.sendKeys(name);
		Select gender_field = new Select(BaseClass.get_driver().findElement(By.id("genderCodeIdForward0")));
		gender_field.selectByVisibleText(gender);
		WebElement age_field = BaseClass.get_driver().findElement(By.id("passengerAgeForward0"));
		age_field.sendKeys(age);
		Select concession_field = new Select(BaseClass.get_driver().findElement(By.id("concessionIdsForward0")));
		concession_field.selectByIndex(1);

	}

	public static void dropping_point() {
		List<WebElement> details = BaseClass.get_driver().findElements(By.xpath(
				"/html/body/main/form/section/div/div[6]/div[3]/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[2]/div/div[2]/ul/li"));

		for (WebElement item : details) {
			if (item.getText().equals("Dropping Point")) {
				item.click();
				break;
			}
		}
		List<WebElement> points = BaseClass.get_driver().findElements(By.xpath(
				"/html/body/main/form/section/div/div[6]/div[3]/div[2]/div[4]/div/table/tbody/tr/td/div/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/ul/li"));
		points.get(0).click();
	}
	public static void customer_details(String mobile,String email)
	{
		WebElement mobile_field = BaseClass.get_driver().findElement(By.id("mobileNo"));
		mobile_field.sendKeys(mobile);
		
		WebElement email_field = BaseClass.get_driver().findElement(By.id("email"));
		email_field.sendKeys(email);
	}
}
