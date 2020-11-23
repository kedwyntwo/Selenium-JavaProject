package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(how= How.CSS,using = "#identifierId")
    private WebElement emailField;
    @FindBy(how= How.CSS,using ="#identifierNext > div > button")
    private WebElement nextButtonEmail;
    @FindBy(how= How.CSS,using ="#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")
    private WebElement passwordField;
    @FindBy(how= How.CSS,using ="#passwordNext > div > button")
    private WebElement nextButtonPassword;

    public void inputLogin(String email) {
        emailField.sendKeys(email);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickEmailButton() {
        nextButtonEmail.click();
    }

    public void clickPasswordButton() {
        nextButtonPassword.click();
    }
}