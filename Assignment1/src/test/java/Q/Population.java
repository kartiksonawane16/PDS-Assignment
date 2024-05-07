package Q;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Population {
	@Test
	public void main() {
		System.out.println("l");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); // window max
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.worldometers.info/world-population/"); // URL
		
		// Get current world population
				WebElement currentPopulationElement = driver.findElement(By.xpath("//div[@class='maincounter-number']"));
				String currentPopulation = currentPopulationElement.getText();
				System.out.println("Current World Population: " + currentPopulation);
				// //div[@class='maincounter-number']

				
				// Get today's statistics
				WebElement todayBirthsElement = driver.findElement(By.xpath("//span[@rel='births_today']"));
				String todayBirths = todayBirthsElement.getText();
				System.out.println("Today's Births: " + todayBirths);
				// //span[@rel='births_today']

				WebElement todayDeathsElement = driver.findElement(By.xpath("//span[@rel='dth1s_today']"));
				String todayDeaths = todayDeathsElement.getText();
				System.out.println("Today's Deaths: " + todayDeaths);
				// (//span[@class='rts-counter'])[3] //span[@rel='dth1s_today']

				WebElement todayPopulationElement = driver.findElement(By.xpath("//span[@rel='absolute_growth']"));
				String todayPopulation = todayPopulationElement.getText();
				System.out.println("Today's Population Change: " + todayPopulation);
				// //span[@rel='absolute_growth']

				
				// Get this year's statistics
				WebElement thisYearBirthsElement = driver.findElement(By.xpath("//span[@rel='births_this_year']"));
				String thisYearBirths = thisYearBirthsElement.getText();
				System.out.println("This Year's Births: " + thisYearBirths);
				//

				WebElement thisYearDeathsElement = driver.findElement(By.xpath("//span[@rel='dth1s_this_year']"));
				String thisYearDeaths = thisYearDeathsElement.getText();
				System.out.println("This Year's Deaths: " + thisYearDeaths);

				WebElement thisYearPopulationElement = driver
						.findElement(By.xpath("//span[@rel='absolute_growth_year']"));
				String thisYearPopulation = thisYearPopulationElement.getText();
				System.out.println("This Year's Population Change: " + thisYearPopulation);
	}

}
