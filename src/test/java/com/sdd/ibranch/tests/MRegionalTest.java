package com.sdd.ibranch.tests;

import com.sdd.ibranch.base.AuthenBaseTest;
import com.sdd.ibranch.pages.MRegionalPage;
import com.sdd.ibranch.utils.RandomDataUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MRegionalTest extends AuthenBaseTest {

    private final By parameterMessage = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[2]/h3/span/span");
    private final By formRegional = By.cssSelector("[data-testid='judulheader']");
    private final By successCreateRegional = By.xpath("//span[normalize-space()='Data Berhasil Disimpan']");
    private final By duplicateMessage  = By.xpath("//span[normalize-space()='Kode yang diinput sudah terdaftar']");
    private String regionalCode;

    @Test(description = "TC-02-0001 | Open Menu Parameter Regional", priority = 1)
    public void openMenuRegional() {
        MRegionalPage mRegionalPage = new MRegionalPage(driver);

        mRegionalPage.openPageRegional();

        Assert.assertTrue(
                mRegionalPage.getMessage(parameterMessage).contains("Parameter Regional"), "Gagal menampilkan Menu Parameter Regional"
        );
    }

    @Test(description = "TC-02-0002 | Click Add Button in Parameter Regional", priority = 2)
    public void createAddButton() {
        MRegionalPage mRegionalPage = new MRegionalPage(driver);

        mRegionalPage.openPageRegional();
        mRegionalPage.clickAddParameterRegional();

        Assert.assertTrue(
                mRegionalPage.getMessage(formRegional).contains("Form Regional"), "Gagal menampilkan Form Regional"
        );
    }

    @Test(description = "TC-02-0003 | Create Form Regional Data", priority = 3)
    public void createDataRegional() {
        MRegionalPage mRegionalPage = new MRegionalPage(driver);

        regionalCode = RandomDataUtil.generateRegionalCode();
        String regionalName = RandomDataUtil.generateRegionalName();
        String regionalDesc = RandomDataUtil.generateDescription();

        mRegionalPage.openPageRegional();
        mRegionalPage.clickAddParameterRegional();

        mRegionalPage.createFormRegional(
                regionalCode,
                regionalName,
                regionalDesc
        );

        Assert.assertTrue(
                mRegionalPage.getMessage(successCreateRegional).contains("Data Berhasil Disimpan"), "Gagal create Form Regional"
        );
    }


    @Test(description = "TC-02-0004 | Duplikat Data Regional ", priority = 4)
    public void duplicateDataRegional() {
        MRegionalPage mRegionalPage = new MRegionalPage(driver);

        if (regionalCode == null || regionalCode.length() < 1) {
            regionalCode = RandomDataUtil.generateRegionalCode();

            // create data dulu agar kode tersebut menjadi duplicate
            mRegionalPage.openPageRegional();
            mRegionalPage.clickAddParameterRegional();

            mRegionalPage.createFormRegional(
                    regionalCode,
                    RandomDataUtil.generateRegionalName(),
                    RandomDataUtil.generateDescription()
            );
            mRegionalPage.closeSuccessPopup();
        }
        
        mRegionalPage.openPageRegional();
        mRegionalPage.clickAddParameterRegional();

        mRegionalPage.createFormRegional(
                regionalCode,                          // kode yang sama (duplicate)
                RandomDataUtil.generateRegionalName(), // nama baru
                RandomDataUtil.generateDescription()   // deskripsi baru
        );

        Assert.assertTrue(
                mRegionalPage.getMessage(duplicateMessage)
                        .contains("Kode yang diinput sudah terdaftar"),
                "Pesan duplicate tidak muncul"
        );
    }
}
