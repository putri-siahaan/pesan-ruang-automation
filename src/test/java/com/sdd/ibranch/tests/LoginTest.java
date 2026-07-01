package com.sdd.ibranch.tests;

import com.sdd.ibranch.base.BaseTest;
import com.sdd.ibranch.listeners.TestListener;
import com.sdd.ibranch.pages.LoginPage;
import com.sdd.ibranch.utils.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    private final By successMessage = By.xpath("//h2[normalize-space()='Dashboard Monitoring']");

    @Test(description = "TC-01-0001 | Login dengan UserID dan Password Valid", priority = 1)
    public void loginWithUserIDAndPasswordValid() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.login(
                ConfigReader.getProperty("valid.username"),
                ConfigReader.getProperty("valid.password")
        );

        Assert.assertTrue(
                loginPage.getMessage(successMessage).contains("Dashboard Monitoring"), "Gagal login"
        );
    }
}
