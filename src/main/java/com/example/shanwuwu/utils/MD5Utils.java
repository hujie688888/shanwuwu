package com.example.shanwuwu.utils;

/**
 * @projectName: shanwuwu
 * @package: com.example.shanwuwu.utils
 * @className: MD5Utils
 * @author: hujie
 * @description: TODO
 * @date: 2023/2/26 10:48
 * @version: 1.0
 */
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;

public class MD5Utils {
    public static String md5(String src) {
        return DigestUtils.md5Hex(src.getBytes(StandardCharsets.UTF_8));
    }

    private static final String salt = "@#$%66&";

    public static String inputPassToFormPass(String inputPass) {
        String str = ""+salt.charAt(0)+salt.charAt(2) + inputPass +salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String formPassToDBPass(String formPass, String salt) {
        String str = ""+salt.charAt(0)+salt.charAt(2) + formPass +salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDbPass(String inputPass, String saltDB) {
        String formPass = inputPassToFormPass(inputPass);
        String dbPass = formPassToDBPass(formPass, saltDB);
        return dbPass;
    }
}

