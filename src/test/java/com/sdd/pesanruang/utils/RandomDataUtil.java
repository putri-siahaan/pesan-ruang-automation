package com.sdd.pesanruang.utils;

import java.util.Random;

public class RandomDataUtil {
    private static final Random random = new Random();
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789";

    // Kode 2 karakter (huruf + angka)
    public static String generateRegionalCode() {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            code.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return code.toString();
    }

    // Nama Regional
    public static String generateRegionalName() {
        return "REGIONAL_" + System.currentTimeMillis();
    }

    // Deskripsi
    public static String generateAlamat() {
        return "DESC_" + System.currentTimeMillis();
    }
}
