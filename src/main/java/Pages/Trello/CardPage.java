package Pages.Trello;

import java.sql.Driver;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;


public class CardPage {
	WebDriver drvr;
	public CardPage (WebDriver drvr){
		this.drvr = drvr;
	}
	

public void uploadFile(String filePath) throws InterruptedException {
	try {
		WebElement attachmentElement = drvr.findElement(By.xpath("//a[contains(@title, 'Attachment')]"));
		attachmentElement.click();
	} catch (Exception e){
		System.out.println("exception happened....");
		System.out.println(e);
	}
	WebElement attachPCElement = drvr.findElement(By.xpath("//input[@class = 'js-attach-file']"));
	attachPCElement.sendKeys(filePath);
}

public void downloadFile(String path) {
	WebElement attachmentElement = drvr.findElement(By.xpath("//a[contains(@class, 'js-direct-link')]"));
	attachmentElement.click();
	String downloadedFilePathString = System.getProperty("user.home") + "\\Downloads\\input.csv";
	System.out.println(downloadedFilePathString);
	}
}



