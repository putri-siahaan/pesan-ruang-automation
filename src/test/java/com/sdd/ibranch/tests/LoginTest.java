package com.sdd.ibranch.tests;

import com.sdd.ibranch.base.BaseTest;
import com.sdd.ibranch.pages.LoginPage;
import com.sdd.ibranch.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private final By successMessage = By.xpath("//h2[normalize-space()='Dashboard Monitoring']");
    private final By invalidUserIDOrPasswordMessage = By.xpath("//span[normalize-space()='Invalid credential']");
    private final By emptyUserIdAndPasswordMessage = By.xpath("//span[normalize-space()='Mohon Masukkan Userid dan Password']");


    @Test(description = "TC-01-0001 | Login dengan UserID dan Password Valid", priority = 1)
    public void loginWithUserIDAndPasswordValid() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("valid.username"),
                ConfigReader.getProperty("valid.password")
        );

        Assert.assertTrue(
                loginPage.getMessage(successMessage).contains("Dashboard Monitoring"), "Gagal login"
        );
    }

    @Test(description = "TC-01-0002 | Login dengan invalid userID", priority = 2)
    public void loginWithInvalidUserID() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "Yamal",
                ConfigReader.getProperty("valid.password")
        );

        Assert.assertTrue(
                loginPage.getMessage(invalidUserIDOrPasswordMessage).contains("Invalid credential"), "Pesan error login tidak sesuai"
        );
    }

    @Test(description = "TC-01-0003 | Login dengan invalid Password", priority = 3)
    public void loginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("valid.username"),
                "Salah Password"
        );

        Assert.assertTrue(
                loginPage.getMessage(invalidUserIDOrPasswordMessage).contains("Invalid credential"), "Pesan error login tidak sesuai"
        );
    }

    @Test(description = "TC-01-0004 | Login dengan empty user id ", priority = 4)
    public void loginWithEmptyUserId() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "",
                ConfigReader.getProperty("valid.password")
        );

        Assert.assertTrue(
                loginPage.getMessage(emptyUserIdAndPasswordMessage).contains("Mohon Masukkan Userid dan Password"), "Pesan error login tidak sesuai"
        );
    }


    @Test(description = "TC-01-0005 | Login dengan empty password", priority = 5)
    public void loginWithEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("valid.username"),
                ""
        );

        Assert.assertTrue(
                loginPage.getMessage(emptyUserIdAndPasswordMessage).contains("Mohon Masukkan Userid dan Password"), "Pesan error login tidak sesuai"
        );
    }


    @Test(description = "TC-01-0006 | Login dengan empty user id and password", priority = 5)
    public void loginWithEmptyUserIdAndPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "",
                ""
        );

        Assert.assertTrue(
                loginPage.getMessage(emptyUserIdAndPasswordMessage).contains("Mohon Masukkan Userid dan Password"), "Pesan error login tidak sesuai"
        );
    }


}
