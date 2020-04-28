package cn.wandingkeji.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

public class PasswordEncoder {


    private static final Logger log = LoggerFactory.getLogger(PasswordEncoder.class);
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private Object salt;
    private String algorithm;

    public PasswordEncoder(Object salt, String algorithm) {
        this.salt = salt;
        this.algorithm = algorithm;
    }

    /**
     * 获取盐值
     *
     * @param length
     * @return
     */
    public static String getSalt() {
        return RandomStringGenerator.getRandomStringByLength(10);
    }

    /**
     * 将rawPass字符串hash后转成16进制字符串
     *
     * @param rawPass
     * @return
     */
    public String encode(String rawPass) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            //加密后的字符串
            result = byteArrayToHexString(md.digest(mergePasswordAndSalt(rawPass).getBytes("utf-8")));
        } catch (Exception ex) {
            log.error(ex.toString());
            return null;
        }
        return result;
    }

    /**
     * 验证密码
     *
     * @param encPass
     * @param rawPass
     * @return
     */
    public boolean isPasswordValid(String encPass, String rawPass) {
        String pass1 = "" + encPass;
        String pass2 = encode(rawPass);

        return pass1.equals(pass2);
    }

    /**
     * 将密码和盐值连一起
     *
     * @param password
     * @return
     */
    private String mergePasswordAndSalt(String password) {
        if (password == null) {
            password = "";
        }

        if ((salt == null) || "".equals(salt)) {
            return password;
        } else {
            return password + "{" + salt.toString() + "}";
        }
    }

    /**
     * 转换字节数组为16进制字串
     *
     * @param b 字节数组
     * @return 16进制字串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static void main(String[] args) {
        String salt = "k3mbxcvdz8";//getSalt();
        System.out.println("salt=" + salt);
/*	     PasswordEncoder encoderMd5 = new PasswordEncoder(salt, "MD5");
	     String encode = encoderMd5.encode("test");
	     System.out.println(encode);
	     boolean passwordValid = encoderMd5.isPasswordValid("083a8db3ff5b9b4ece3ef2bde03226c8", "test");
	     System.out.println(passwordValid);*/

        PasswordEncoder encoderSha = new PasswordEncoder(salt, "SHA");
        String pass2 = encoderSha.encode("b9d11b3be25f5a1a7dc8ca04cd310b28");
        System.out.println(pass2);
        boolean passwordValid2 = encoderSha.isPasswordValid("89ed3b1277d4730fa14c0dac0daed90fdfa4a97f", "b9d11b3be25f5a1a7dc8ca04cd310b28");
        System.out.println(passwordValid2);
    }

}
