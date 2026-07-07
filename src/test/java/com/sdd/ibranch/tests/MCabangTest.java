package com.sdd.ibranch.tests;

import com.sdd.ibranch.base.AuthenBaseTest;
import com.sdd.ibranch.pages.MCabangPage;
import com.sdd.ibranch.pages.MRegionalPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MCabangTest extends AuthenBaseTest {

    private final By parameterMessage = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/h3/span/span");
    private final By formCabang = By.xpath("/html/body/div[4]/div/div/div/div/div[1]/div/div/h3/span");

    @Test(description = "TC-03-0001 | Open Menu Parameter Cabang", priority = 1)
    public void openMenuCabang() {
        MCabangPage mCabangPage = new MCabangPage(driver);

        mCabangPage.openPageCabang();

        Assert.assertTrue(
                mCabangPage.getMessage(parameterMessage).contains("Parameter Cabang"), "Gagal menampilkan Menu Parameter Cabang"
        );
    }

    @Test(description = "TC-03-0002 | Create Parameter Cabang", priority = 2)
    public void createParameterCabang() {
        MCabangPage mCabangPage = new MCabangPage(driver);

        mCabangPage.openPageCabang();
        mCabangPage.createParameterCabang();

        Assert.assertTrue(
                mCabangPage.getMessage(formCabang).contains("Form Cabang"), "Gagal menampilkan Form Cabang"
        );
    }

}
