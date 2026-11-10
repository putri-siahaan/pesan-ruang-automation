package com.sdd.pesanruang.tests;

import com.sdd.pesanruang.base.BaseTest;
import com.sdd.pesanruang.pages.LoginPage;
import com.sdd.pesanruang.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private final By successMessage = By.cssSelector("[data-test-id='lblTopbarPageTitle']");
    private final By invalidNppOrEmailMessage = By.cssSelector("[id='swal2-html-container']");
    private final By emptyNppEmailAndPasswordMessage = By.cssSelector("[id='swal2-html-container']");


    @Test(description = "TC-01-0001 | Login dengan UserID dan Password Valid", priority = 1)
    public void loginWithUserIDAndPasswordValid() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("valid.npporemail"),
                ConfigReader.getProperty("valid.password")
        );

        Assert.assertTrue(
                loginPage.getMessage(successMessage).contains("Dashboard"), "Gagal login"
        );
    }

    @Test(description = "TC-01-0002 | Login dengan invalid NPP / Email", priority = 2)
    public void loginWithInvalidUserID() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "SDD2703",
                ConfigReader.getProperty("valid.password")
        );

        Assert.assertTrue(
                loginPage.getMessage(invalidNppOrEmailMessage).contains("Username/password salah."), "Pesan error login tidak sesuai"
        );
    }

    @Test(description = "TC-01-0003 | Login dengan invalid Password", priority = 3)
    public void loginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("valid.npporemail"),
                "WRONGPASSWORDDD"
        );

        Assert.assertTrue(
                loginPage.getMessage(invalidNppOrEmailMessage).contains("Username/password salah."), "Pesan error login tidak sesuai"
        );
    }

    @Test(description = "TC-01-0004 | Login dengan empty Npp or Email ", priority = 4)
    public void loginWithEmptyUserId() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                "",
                ConfigReader.getProperty("valid.password")
        );

        Assert.assertTrue(
                loginPage.getMessage(emptyNppEmailAndPasswordMessage).contains("Harap isi NPP/email dan password."), "Pesan error login tidak sesuai"
        );
    }


    @Test(description = "TC-01-0005 | Login dengan empty password", priority = 5)
    public void loginWithEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.getProperty("valid.npporemail"),
                ""
        );

        Assert.assertTrue(
                loginPage.getMessage(emptyNppEmailAndPasswordMessage).contains("Harap isi NPP/email dan password."), "Pesan error login tidak sesuai"
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
                loginPage.getMessage(emptyNppEmailAndPasswordMessage).contains("Harap isi NPP/email dan password."), "Pesan error login tidak sesuai"
        );
    }


}
