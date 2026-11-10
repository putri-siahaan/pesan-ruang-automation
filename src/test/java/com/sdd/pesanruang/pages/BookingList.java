package com.sdd.pesanruang.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BookingList {
    private WebDriver driver;
    private WebDriverWait wait;

    public BookingList(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    private final By menuBooking = By.cssSelector("[data-test-id='navSidebarGroupHeader_Booking']");
    private final By subMenuBookingList = By.cssSelector("[data-test-id='navSidebarMenu_2']");
    private final By buttonCreateBooking = By.cssSelector("[data-test-id='btnBookingListTambah']");
    private final By fieldKeperluan = By.cssSelector("[data-test-id='tbBookingListFormSubject']");
    private final By fieldLokasi = By.xpath("/html/body/div[1]/div[3]/main/div[2]/div/div[2]/div[6]/div/div[2]/div[1]/div[2]/div[1]/span/input");
    private final By fieldRuang = By.xpath("/html/body/div[1]/div[3]/main/div[2]/div/div[2]/div[6]/div/div[2]/div[1]/div[2]/div[2]/span/input");
    private final By listdropDownRuang = By.cssSelector("[data-test-id='ciBookingListFormRuang_32']");
    private final By tipePerJam = By.cssSelector("[data-test-id='rbBookingListFormTypeHour']");
    private final By tipeHarian = By.cssSelector("[data-test-id='rbBookingListFormTypeDay']");
    private final By tanggalTipeJam = By.xpath("/html/body/div[1]/div[3]/main/div[2]/div/div[2]/div[6]/div/div[2]/div[1]/div[5]/div[1]/input[2]");
    private final By jamMulai = By.cssSelector("[data-test-id='tmBookingListFormJamMulai']");
    private final By jamSelesai = By.cssSelector("[data-test-id='tmBookingListFormJamAkhir']");
    private final By fieldDeskripsi = By.cssSelector("[data-test-id='tbBookingListFormDescription']");
    private final By tanggalMulai = By.xpath("/html/body/div[1]/div[3]/main/div[2]/div/div[2]/div[6]/div/div[2]/div[1]/div[6]/div/div[1]/input[2]");
    private final By tanggalSelesai = By.xpath("/html/body/div[1]/div[3]/main/div[2]/div/div[2]/div[6]/div/div[2]/div[1]/div[6]/div/div[2]/input[2]");
    private final By buttonSimpan = By.cssSelector("[data-test-id='btnBookingListFormSimpan']");

    public void openPageMenuBookingList(){
        wait.until(ExpectedConditions.elementToBeClickable(menuBooking)).click();
        wait.until(ExpectedConditions.elementToBeClickable(subMenuBookingList)).click();
    }

    private void selectRandomRuang(By locator) {
        List<WebElement> options = driver.findElements(locator);
        options.get(new Random().nextInt(options.size())).click();
    }

    public void addBookingDataTypePerJam(String keperluan, String lokasi, String deskripsi){
        wait.until(ExpectedConditions.elementToBeClickable(buttonCreateBooking)).click();
        wait.until(ExpectedConditions.elementToBeClickable(fieldKeperluan)).sendKeys(keperluan);
        wait.until(ExpectedConditions.elementToBeClickable(fieldLokasi)).sendKeys(lokasi, Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(fieldRuang)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(listdropDownRuang));
        selectRandomRuang(listdropDownRuang);
        wait.until(ExpectedConditions.elementToBeClickable(tipePerJam)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tanggalTipeJam)).click();
        driver.findElement(tanggalTipeJam).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_RIGHT, Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(jamMulai)).click();
        driver.findElement(jamMulai).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(jamSelesai)).click();
        driver.findElement(jamSelesai).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(fieldDeskripsi)).sendKeys(deskripsi);
        wait.until(ExpectedConditions.elementToBeClickable(buttonSimpan)).click();
    }

    public void addBookingDataTypePerDay(String keperluan, String lokasi, String deskripsi){
        wait.until(ExpectedConditions.elementToBeClickable(buttonCreateBooking)).click();
        wait.until(ExpectedConditions.elementToBeClickable(fieldKeperluan)).sendKeys(keperluan);
        wait.until(ExpectedConditions.elementToBeClickable(fieldLokasi)).sendKeys(lokasi, Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(fieldRuang)).click();
        selectRandomRuang(listdropDownRuang);
        wait.until(ExpectedConditions.elementToBeClickable(tipeHarian)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tanggalMulai)).click();
        driver.findElement(tanggalMulai).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_RIGHT, Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(tanggalSelesai)).click();
        driver.findElement(tanggalSelesai).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_RIGHT, Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(fieldDeskripsi)).sendKeys(deskripsi);
        wait.until(ExpectedConditions.elementToBeClickable(buttonSimpan)).click();
    }

    public String getMessage(By var) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement infoMessage = wait.until (ExpectedConditions.visibilityOfElementLocated(var));
        return infoMessage.getText().trim();
    }
}
