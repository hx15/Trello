package Pages.Trello;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AtlassianLogin {
	WebDriver drvr;
	public AtlassianLogin (WebDriver drvr){
		this.drvr = drvr;
	}
	
public void Login() {
		WebElement loginButton = drvr.findElement(By.id("login-submit"));
		WebElement loginPassword = drvr.findElement(By.name("password"));
		loginPassword.sendKeys(System.getenv("trello_password"));
		loginButton.click();
		drvr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
