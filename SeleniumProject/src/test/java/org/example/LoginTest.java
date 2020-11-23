package org.example;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static MainPage mainPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }
    @Test
    public void loginTest(){
        mainPage.clickLoginButton();
        profilePage.inputLogin(ConfProperties.getProperty("email"));
        profilePage.clickEmailButton();
        profilePage.inputPassword(ConfProperties.getProperty("password"));
        profilePage.clickPasswordButton();
    }
    @Test
    public void searchTest() throws InterruptedException {
        mainPage.inputSearchRequest(ConfProperties.getProperty("searchRequest"));
        mainPage.clickSearchButton();
        Thread.sleep(2000);
        mainPage.clickLinkVideo();
        Thread.sleep(50000);
        String video =mainPage.getVideoName();
        Assert.assertEquals(ConfProperties.getProperty("searchedVideo"), video);
    }
    @After
    public void quit(){
        driver.quit();
    }


}
