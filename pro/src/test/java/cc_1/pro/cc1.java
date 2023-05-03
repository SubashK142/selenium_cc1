package cc_1.pro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cc1 {
@Test
	public void TC_001() {
		WebDriverManager.edgedriver().setup();
		WebDriver driver= new EdgeDriver();
		driver.navigate().to("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        String ItemCount = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a/span")).getText();
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
        String Product = "Sauce Labs Backpack";

		driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
//		Boolean Display1 = driver.findElement(By.xpath("//*[@id=\"checkout\"]")).isDisplayed();
		driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("new");
		driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("k");
		driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("345678");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		System.out.println("Name of the product: " + driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div")).getText());
	    System.out.println("Price of the product: " + driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/div[2]/div")).getText());
		String actualTitle = driver.getTitle();
		String expectedTitle = "Swag Labs";
		Assert.assertEquals(expectedTitle,actualTitle);
		String actualurl=driver.getCurrentUrl();
		String expectedurl="https://www.saucedemo.com/checkout-step-two.html";
		Assert.assertEquals(expectedurl,actualurl);
//		
//		//*[@id="item_4_title_link"]/div
//		//*[@id="checkout_summary_container"]/div/div[1]/div[3]/div[2]/div[2]/div
//		System.out.print(Display);
//		System.out.print(Display1);

	}
}

