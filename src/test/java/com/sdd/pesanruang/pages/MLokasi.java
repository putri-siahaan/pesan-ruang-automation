package com.sdd.pesanruang.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MCabangPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MCabangPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    private final By menuCMS = By.cssSelector("navSidebarGroupHeader_CMS");
    private final By parameterCabangSub = By.xpath("//span[normalize-space()='Parameter Cabang']");
    private final By buttonCreate = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/button[1]");

    public void openPageCabang(){
        wait.until(ExpectedConditions.elementToBeClickable(parameterMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(parameterCabangSub)).click();
    }

    public void createParameterCabang(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonCreate)).click();
    }

    public String getMessage(By var) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement infoMessage = wait.until (ExpectedConditions.visibilityOfElementLocated(var));
        return infoMessage.getText().trim();
    }
}
