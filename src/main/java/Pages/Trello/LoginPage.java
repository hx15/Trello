package Pages.Trello;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
	WebDriver drvr;
	public LoginPage (WebDriver drvr){
		this.drvr = drvr;
	}
	
public void Login() {
		WebElement userField = drvr.findElement(By.name("user"));
		WebElement continueButton = drvr.findElement(By.id("login"));
		drvr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		userField.sendKeys("hdaana@outlook.com");
		continueButton.click();
	}
}
