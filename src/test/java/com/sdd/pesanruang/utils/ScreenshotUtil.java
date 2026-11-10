package com.sdd.pesanruang.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String fileName) {

        String folder = "reports/evidence";
        new File(folder).mkdirs();

        // Nama file
        String imageName = fileName + ".png";

        // Path untuk menyimpan file
        String savePath = folder + "/" + imageName;

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(savePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Path RELATIF terhadap TestReport.html
        return "evidence/" + imageName;
    }
}