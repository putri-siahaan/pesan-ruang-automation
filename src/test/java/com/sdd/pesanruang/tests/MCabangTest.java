//package com.sdd.pesanruang.tests;
//
//import com.sdd.pesanruang.base.AuthenBaseTest;
//import com.sdd.pesanruang.pages.MLokasi;
//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class MCabangTest extends AuthenBaseTest {
//
//    private final By successCreateMaster = By.xpath("//*[@id=\"swal2-html-container\"]");
//    //private final By formCabang = By.xpath("//*[@id=\"swal2-html-container\"]");
//
//    @Test(description = "TC-02-0001 | Create Master Lokasi", priority = 1)
//    public void openMenuCabang() {
//        MLokasi mLokasiPage = new MLokasi(driver);
//
//        mLokasiPage.openPageCabang();
//
//        Assert.assertTrue(
//                mLokasiPage.getMessage(successCreateMaster).contains("Data lokasi berhasil disimpan."), "Gagal create master lokasi"
//        );
//    }
//
//    @Test(description = "TC-03-0002 | Create Parameter Cabang", priority = 2)
//    public void createParameterCabang() {
//        MLokasi mCabangPage = new MLokasi(driver);
//
//        mCabangPage.openPageCabang();
//        mCabangPage.createParameterCabang();
//
//        Assert.assertTrue(
//                mCabangPage.getMessage(formCabang).contains("Form Cabang"), "Gagal menampilkan Form Cabang"
//        );
//    }
//
//}
