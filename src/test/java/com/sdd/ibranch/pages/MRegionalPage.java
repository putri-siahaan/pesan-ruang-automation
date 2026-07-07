package com.sdd.ibranch.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MRegionalPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MRegionalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    private final By parameterMenu = By.xpath("//span[normalize-space()='Parameter']");
    private final By parameterRegionalSub = By.xpath("//span[normalize-space()='Parameter Regional']");
    private final By buttonCreate = By.cssSelector("[data-testid='btnadd']");
    private final By kodeRegional = By.cssSelector("[data-testid='tbregionalcode']");
    private final By namaRegional = By.cssSelector("[data-testid='cbregionname']");
    private final By deskripsiRegional = By.cssSelector("[data-testid='tbregiondesc']");
    private final By buttonSimpan = By.cssSelector("[data-testid='btnsave']");
    private final By buttonOK = By.xpath("//button[normalize-space()='OK']");

    public void openPageRegional(){
        wait.until(ExpectedConditions.elementToBeClickable(parameterMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(parameterRegionalSub)).click();
    }

    public void clickAddParameterRegional(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonCreate)).click();
    }

    public void createFormRegional(String kode, String nama, String deskripsi){
        wait.until(ExpectedConditions.elementToBeClickable(kodeRegional)).sendKeys(kode);
        wait.until(ExpectedConditions.elementToBeClickable(namaRegional)).sendKeys(nama);
        wait.until(ExpectedConditions.elementToBeClickable(deskripsiRegional)).sendKeys(deskripsi);
        wait.until(ExpectedConditions.elementToBeClickable(buttonSimpan)).click();
    }

    public void closeSuccessPopup(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonOK)).click();
    }

    public String getMessage(By var) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement infoMessage = wait.until (ExpectedConditions.visibilityOfElementLocated(var));
        return infoMessage.getText().trim();
    }
}
