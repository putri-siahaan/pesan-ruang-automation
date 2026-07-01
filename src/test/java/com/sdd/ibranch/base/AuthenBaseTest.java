package com.sdd.ibranch.base;

import com.sdd.ibranch.pages.LoginPage;
import com.sdd.ibranch.utils.ConfigReader;
import org.testng.annotations.BeforeClass;

public class AuthenBaseTest extends BaseTest {
    @BeforeClass
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(
                ConfigReader.getProperty("valid.username"),
                ConfigReader.getProperty("valid.password")
        );
    }
}
