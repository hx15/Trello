package Pages.Trello;

import java.sql.Driver;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {
	WebDriver drvr;
	public MainPage (WebDriver drvr){
		this.drvr = drvr;
	}
	
public void Login() {
		drvr.get("https://trello.com");
		WebElement loginButton = drvr.findElement(By.xpath("/html/body/div[1]/header[1]/div/div[1]/div[2]/a[1]"));
		loginButton.click();
		drvr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

public void goToBoardsPage(String workSpaceNameString) {

	WebElement workSpacElement = drvr.findElement(By.xpath("//a[contains(@href,'" + workSpaceNameString.toLowerCase() + "')]"));
	workSpacElement.click();
	WebElement boardsElement = drvr.findElement(By.xpath("//a[@data-test-id ='home-team-boards-tab']"));
	boardsElement.click();
	System.out.println("Clicked");
}
}
