package Trello;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.TreeBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.print.PageSize;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import Core.OpenBrowsers;
import Pages.Trello.AtlassianLogin;
import Pages.Trello.BoardPage;
import Pages.Trello.CardPage;
import Pages.Trello.HomePage;
import Pages.Trello.LoginPage;
import Pages.Trello.MainPage;
import io.opentelemetry.api.internal.Utils;
import testutils.testutils;
import Pages.Trello.CardPage;

import org.testng.TestNGUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class FileTest  {
	private String browserName;
	private WebDriver drvr;
	
	File uploadedFile;
	File downLoadedFile;
	
	
	@Parameters({"browser"})
	@BeforeTest
 public void getBrowserNameFromTestNG(String browserName){   
     this.browserName = browserName;
 }


 @BeforeClass
 public void setUp(){
     String browser = browserName;
     drvr = OpenBrowsers.openBrowser(browser);
     drvr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 drvr.get("https://trello.com");
	 HomePage homePage = new Pages.Trello.HomePage(drvr);
	 homePage.ClickLogin();
	 LoginPage loginPage = new LoginPage(drvr);
	 loginPage.Login();
	 AtlassianLogin attlassianLogin = new AtlassianLogin(drvr);
	 attlassianLogin.Login();
 }

 @AfterClass
 public void tearDown(){
	drvr.close();
 }

 
 
 @Test
 public void CreateCard () throws Exception {
	 MainPage mainPage = new MainPage(drvr);
	 mainPage.goToBoardsPage("testworkspace");
	 BoardPage boardPage = new BoardPage(drvr);
	 Thread.sleep(3000);
	 boardPage.createBoard("testingboard");
	 boardPage.createCard("testingcard");
	 boardPage.getIntoCard("testingcard");
	 CardPage cardPage = new CardPage(drvr);
	 
 }
 
 @Test (dependsOnMethods = "CreateCard")
 public void UploadFile () throws InterruptedException {
	 CardPage cardPage = new CardPage(drvr);
	 String currentWorkingDirectoryString = System.getProperty("user.dir");
	 String filePathString = "./input.csv";
	 cardPage.uploadFile(currentWorkingDirectoryString + "//" + filePathString);
 }
 
@Test(dependsOnMethods = "UploadFile")
public void DownloadFile () {
	 CardPage cardPage = new CardPage(drvr);
	 String currentWorkingDirectoryString = System.getProperty("user.dir");
	 cardPage.downloadFile(currentWorkingDirectoryString);
 }

@Test(dependsOnMethods = "DownloadFile")
public void CompareFiles () throws NoSuchAlgorithmException, IOException {
	// check check sum of downloaded and uploaded file
	 MessageDigest mdigest = MessageDigest.getInstance("MD5");
	 String currentWorkingDirectoryString = System.getProperty("user.dir");
	 uploadedFile = new File(currentWorkingDirectoryString + "\\input.csv");
	 downLoadedFile = new File(System.getProperty("user.home") + "\\Downloads\\input.csv");
	 String uploadedFileChecksum = testutils.checksum(mdigest, uploadedFile);
	 String downloadedFileChecksum = testutils.checksum(mdigest, downLoadedFile);
	 System.out.println("Uploaded file checksum: " + uploadedFileChecksum);
	 System.out.println("Downloaded file checksum: " + downloadedFileChecksum);
	 assertTrue(uploadedFileChecksum.compareTo(downloadedFileChecksum) == 0);
 }
}