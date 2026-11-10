package com.sdd.pesanruang.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MLokasi {
    private WebDriver driver;
    private WebDriverWait wait;

    public MLokasi(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    private final By menuMasterData = By.cssSelector("navSidebarGroupHeader_CMS");
    private final By subMenuMasterLokasi = By.cssSelector("navSidebarMenu_5");
    private final By buttonCreate = By.cssSelector("btnTambahData");
    private final By fieldKodeLokasi = By.cssSelector("tbFormKodeLokasi");
    private final By fieldNamaLokasi = By.cssSelector("tbFormNamaLokasi");
    private final By fieldAlamat = By.cssSelector("tbFormAlamatLokasi");
    private final By buttonSubmit = By.cssSelector("btnFormSimpan");

    public void openPageCabang(){
        wait.until(ExpectedConditions.elementToBeClickable(menuMasterData)).click();
        wait.until(ExpectedConditions.elementToBeClickable(subMenuMasterLokasi)).click();
    }

    public void createParameterCabang(String kode, String nama, String alamat){
        wait.until(ExpectedConditions.elementToBeClickable(buttonCreate)).click();
        wait.until(ExpectedConditions.elementToBeClickable(fieldKodeLokasi)).sendKeys(kode);
        wait.until(ExpectedConditions.elementToBeClickable(fieldNamaLokasi)).sendKeys(nama);
        wait.until(ExpectedConditions.elementToBeClickable(fieldAlamat)).sendKeys(alamat);
        wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit)).click();
    }

    public String getMessage(By var) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement infoMessage = wait.until (ExpectedConditions.visibilityOfElementLocated(var));
        return infoMessage.getText().trim();
    }
}
