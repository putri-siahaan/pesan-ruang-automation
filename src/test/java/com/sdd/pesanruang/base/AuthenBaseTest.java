package com.sdd.pesanruang.base;

import com.sdd.pesanruang.pages.LoginPage;
import com.sdd.pesanruang.utils.ConfigReader;
import org.testng.annotations.BeforeMethod;

public class AuthenBaseTest extends BaseTest {
    @BeforeMethod
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(
                ConfigReader.getProperty("valid.npporemail"),
                ConfigReader.getProperty("valid.password")
        );
    }
}
