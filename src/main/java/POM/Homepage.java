package POM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Homepage {

	public static void get_popular_routs(String rout) throws InterruptedException {

		BaseClass.get_driver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		boolean found = false;
		while (true) {
			List<WebElement> items = BaseClass.get_driver()
					.findElements(By.xpath("// *[@id=\"routeSlider\"]/div/div[2]/div/div/ul/li"));
			
			WebElement next_btn = BaseClass.get_driver()
					.findElement(By.xpath("/html/body/main/section/div/div/div[1]/div/div/div/a[2]"));
					next_btn.click();
			
			String text = items.get(0).getText();
			for (WebElement item : items)
				if (item.getText().equals(rout)) {
					item.click();
					found = true;
					break;

				}
			if (found)
				break;
		}
	}

	public static void select_departue_date() {

		boolean found = false;
		for (int i = 1; i <= 6; i++) {
			List<WebElement> days = BaseClass.get_driver()
					.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[" + i + "]/td"));
			for (WebElement day : days) {
				try {
					if (day.getAttribute("data-handler").equals("selectDay")) {
						day.click();
						found = true;
						break;
					}
				} catch (NullPointerException e) {
					continue;
				}

			}
			if (found)
				break;
		}

	}

	public static void Click_on_search_btn() {
		WebElement Search_btn = BaseClass.get_driver()
				.findElement(By.xpath("//*[@id=\"bookingsForm\"]/div[1]/div/div[2]/div[3]/button"));
		Search_btn.click();
	}
}
