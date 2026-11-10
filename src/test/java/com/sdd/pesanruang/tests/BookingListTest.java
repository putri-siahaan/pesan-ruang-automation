package com.sdd.pesanruang.tests;

import com.sdd.pesanruang.base.AuthenBaseTest;
import com.sdd.pesanruang.pages.BookingList;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingListTest extends AuthenBaseTest {

    private final By successMessageBookingData = By.xpath("/html/body/div[6]/div/div[2]");
//    private final By invalidNppOrEmailMessage = By.cssSelector("[id='swal2-html-container']");
//    private final By emptyNppEmailAndPasswordMessage = By.cssSelector("[id='swal2-html-container']");


    @Test(description = "TC-02-0001 | Tambah Data Booking Tipe Per Jam dengan valid data", priority = 1)
    public void addBookingRoomPerHourWithValidData() {
        BookingList bookingList = new BookingList(driver);

        bookingList.openPageMenuBookingList();
        bookingList.addBookingDataTypePerJam("Pesan Ruang Meeting Project DIGIMS","Kantor Cabang Cawang", "Meeting akan dihadiri PM, dev, dan QA");

        Assert.assertTrue(
                bookingList.getMessage(successMessageBookingData).contains("Booking berhasil disimpan."), "Gagal Booking Ruangan"
        );
    }

    @Test(description = "TC-02-0002 | Tambah Data Booking Tipe Harian dengan valid data", priority = 2)
    public void addBookingRoomPerDayWithValidData() {
        BookingList bookingList = new BookingList(driver);

        bookingList.openPageMenuBookingList();
        bookingList.addBookingDataTypePerDay("Booking Room untuk Meeting Pesan Ruang","Kantor Cabang Cawang", "Progress QA Testing Pesan Ruang");

        Assert.assertTrue(
                bookingList.getMessage(successMessageBookingData).contains("Booking berhasil disimpan."), "Gagal Booking Ruangan"
        );
    }


}
