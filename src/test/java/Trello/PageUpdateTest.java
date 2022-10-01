package Trello;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Driver;

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
import Pages.Trello.CardPage;
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

public class PageUpdateTest  {
	private String browserName;
	private WebDriver drvr;
	
	File uploadedFile;
	File downLoadedFile;
	
	
	@Parameters({"browser"})
	@BeforeTest
 public void getBrowserNameFromTestNG(String browserName){   
     this.browserName = browserName;
 }

}