package Pages.Trello;

import java.sql.Driver;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
	WebDriver drvr;
	public HomePage (WebDriver drvr){
		this.drvr = drvr;
	}
	
public void ClickLogin() {
		drvr.get("https://trello.com");
		WebElement loginButton = drvr.findElement(By.xpath("/html/body/div[1]/header[1]/div/div[1]/div[2]/a[1]"));
		loginButton.click();
	}

}
