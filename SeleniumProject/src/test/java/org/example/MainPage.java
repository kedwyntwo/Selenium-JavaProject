package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(css = "#button.style-scope.ytd-button-renderer.style-suggestive.size-small")
    private WebElement loginButton;
    @FindBy(css = "#search-icon-legacy")
    private WebElement searchButton;
    @FindBy(how= How.ID_OR_NAME, using = "search_query")
    private WebElement searchField;
    @FindBy(xpath = "/html/body/ytd-app/div/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[2]/div[1]/ytd-thumbnail/a")
    private WebElement linkVideo;
    @FindBy(css = "#container > h1 > yt-formatted-string")
    private WebElement videoName;

    public void inputSearchRequest(String searchRequest){
        searchField.sendKeys(searchRequest);
    }
    public void clickSearchButton(){
        searchButton.click();
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public void clickLinkVideo(){
        linkVideo.click();
    }
    public String getVideoName(){
        String nameVideo = videoName.getText();
        return nameVideo;
    }

}
