package com.sdd.ibranch.pages;

import com.sdd.ibranch.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    private final By userid = By.cssSelector("[data-testid='userid']");
    private final By password = By.cssSelector("[data-testid='password']");
    private final By login = By.cssSelector("[data-testid='btnlogin']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(
                ConfigReader.getProperty("base.url")
        );
    }

    public void login(String user, String pass) {
        driver.findElement(userid).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(login).click();
    }

    public String getMessage(By var) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement infoMessage = wait.until (ExpectedConditions.visibilityOfElementLocated(var));
        return infoMessage.getText().trim();
    }

}
