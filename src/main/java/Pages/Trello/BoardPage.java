package Pages.Trello;
import java.sql.Driver;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.TestNGUtils;


public class BoardPage {
	WebDriver drvr;
	public BoardPage (WebDriver drvr){
		this.drvr = drvr;
	}
	

public void getIntoCard (String cardName) {
	WebElement cardElement = drvr.findElement(By.xpath("//a[contains(@href, '" + cardName.toLowerCase() + "') and contains(@class, 'list-card')]"));
	cardElement.click();
}

public void createCard(String cardName) throws Exception {
	//take snapshot
	pagesUtils.takeSnapShot(drvr, System.getProperty("user.dir") + "\\ScreenShots\\board-before.png");
	System.out.println(System.getProperty("user.dir") + "\\board-before.png");
	WebElement cardFieldElement = drvr.findElement(By.name("name"));
	cardFieldElement.sendKeys(cardName);
	WebElement addElement = drvr.findElement(By.xpath(".//input[@value=\"Add list\"]"));	
	addElement.click();
	drvr.findElement(By.xpath("//a[contains(@class,'open-card-composer')]")).click();
	WebElement cardField = drvr.findElement(By.xpath("//textarea[contains(@class, 'list-card')]"));
	cardField.sendKeys(cardName);
	cardField.sendKeys(Keys.RETURN);
	//now click on the card
	pagesUtils.takeSnapShot(drvr, System.getProperty("user.dir") + "\\ScreenShots\\board-after.png");
}


public void createBoard(String boardName) throws Exception {
	
	
		// FILL THE FORM:
	try {
		WebElement createNewBoardElement = drvr.findElement(By.xpath("//span[text() = 'Create new board']"));
		createNewBoardElement.click();
		WebElement boardNameFieldElement = drvr.findElement(By.xpath("/html/body/div[3]/div/section/div/form/div[1]/label/input"));
		boardNameFieldElement.sendKeys(boardName);
		WebElement createButtonElement = drvr.findElement(By.xpath("/html/body/div[3]/div/section/div/form/button"));
		createButtonElement.click();
	}
	catch (Exception e) {
		System.out.println(e);
		System.out.println("couldn't create new board!");
	}
}


}
