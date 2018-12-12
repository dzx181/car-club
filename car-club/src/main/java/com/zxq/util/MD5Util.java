package com.zxq.util;

import org.apache.commons.codec.digest.DigestUtils;
/**
 * Description:
 * <p>
 *     md5加密工具类
 * </p>
 * @author Zeng XiaoQi
 * @Date 2018/12/8 22:00
 */
public class MD5Util {
    private final static String salt = ConstUtil.MD5_SALT;

    //md5加密方法
    public static String md5(String str) {
        //调用commons-codec依赖包中的DigestUtils.md5Hex方法，直接传入要加密的字符串即可，Digest数字，Hex16进制、魔法
        return DigestUtils.md5Hex(str);
    }

    //第一次加密
    public static String inputPassword(String passStr) {
        //ab+用户输入的密码+cd
        String pass = salt.charAt(0) + salt.charAt(2) + passStr + salt.charAt(4) + salt.charAt(6);
        return md5(pass);
    }

    //第二次加密
    public static String formPassToDBpass(String formPass, String salt) {
        //ab+用户输入的密码+cd
        String pass = salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(4) + salt.charAt(6);
        return md5(pass);
    }

    //存入数据库，调用前两次加密
    public static String inputPassToDBpass(String inputPassword, String saltDB) {
        String pass = inputPassword(inputPassword);
        String dBpass = formPassToDBpass(pass, saltDB);
        return dBpass;
    }

    //测试方法：
    public static void main(String[] args) {
        //测试第一次md5加密，实际上依旧是不安全的，因为js往往是暴露在客户端，若有人读懂js源码，或者截获了该密码，在通过反查彩虹表的形式，是可以推出你的密码的
        System.out.println(inputPassToDBpass("123456", salt));//5ace97a53eda6839b1d2fa8acd8fc375，客户端中传输了该字符串
        System.out.println(inputPassword("123456"));
    }
}
