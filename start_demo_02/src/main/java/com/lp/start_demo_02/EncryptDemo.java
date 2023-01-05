package com.lp.start_demo_02;

import org.apache.tomcat.util.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.Security;

/**
 * 加密/解密
 */
public class EncryptDemo {

    private static final String src = "待加密的数据";

    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private static final String salt = "10";

    public static void main(String[] args) throws Exception {

        // DES加密--对称加密算法
        // 说明：近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，24小时内即可被破解。
        /**
         * 原理：是一种比较传统的加密方式，其加密运算、解密运算使用的是同样的密钥，
         * 信息的发送者和信息的接收者在进行信息的传输与处理时，必须共同持有该密码 ，
         * 是一种对称加密算法。
         */
        /*System.out.println("des jdk加密模式");
        jdkDES();
        System.out.println("-------------------------");
        System.out.println("des bc加密模式");
        bcDES();*/

        // MD5加密--信息摘要加密算法
        // 原理
        String simpleStr = "123456";
        System.out.println("原始数："+simpleStr);
        String md5code = md5(simpleStr);
        System.out.println("md5码是："+md5code);
        System.out.println(simpleStr+"加密后的数据是："+md5Opera(md5code));
        String oldStr = md5Opera(md5Opera(md5code));
        System.out.println(simpleStr+"解密后的数据是："+oldStr);

        // BCrypt强哈希加密
        // 说明：用于密码加密，加密后的密码不可被解密。
        // 原理：每次加密的时候为数据加盐，这里封装后的bcrypt是每次添加随机盐。
        // 对比：与加密相比，spring security中的BCryptPasswordEncoder方法采用SHA-256 +随机盐+密钥对密码进行加密。
        // 加密后的数据不可被破解，所以更适合用于加密密码。
        /*String pwd = "123456";
        System.out.println("哈希强加密后的数据是："+bCryptEncode(pwd));
        System.out.println("对比输入密码之后一定是："+checkPwd(pwd));*/
    }

    /**
     * 生成md5码
     * @param inStr
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String md5(String inStr) throws UnsupportedEncodingException {
        String param = inStr+"/"+salt;
        String resStr = DigestUtils.md5DigestAsHex(param.getBytes("utf-8"));
        return resStr;
    }

    /**
     * 加密/解密md5码
     * @param md5Code
     * @return
     */
    public static String md5Opera(String md5Code){
        char[] a = md5Code.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

    /**
     * BCrypt加密
     * @param psw 密码
     * @return
     */
    public static String bCryptEncode(String psw){
        return encoder.encode(psw);
    }

    /**
     * BCrypt比较
     * @param inPsw 输入的密码
     * @return
     */
    public static Boolean checkPwd(String inPsw){
        return encoder.matches(inPsw, bCryptEncode(inPsw));
    }

    /**
     * jdk加密模式（des）
     */
    public static void jdkDES() {
        try {
            //生成KEY
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.getProvider();
            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] bytesKey = secretKey.getEncoded();

            //key转换
            DESKeySpec desKeySpec = new DESKeySpec(bytesKey);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            Key convertSecretKey = factory.generateSecret(desKeySpec);

            //加密 加密方式/工作模式/填充方式
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            //方式/秘钥
            cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk des加密后的数据："+ Base64.encodeBase64String(result));

            //解密 方式/秘钥
            cipher.init(Cipher.DECRYPT_MODE,convertSecretKey);
            result = cipher.doFinal(result);
            System.out.println("jdk des解密后的数据：" + new String(result));
        } catch (Exception e) {
            System.out.println("error:"+e.getMessage());
        }
    }

    /**
     * bc加密模式（des）
     *
     */
    public static void bcDES() {
        try {
            Security.addProvider(new BouncyCastleProvider());

            //生成KEY
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES","BC");
            keyGenerator.getProvider();
            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] bytesKey = secretKey.getEncoded();

            //key转换
            DESKeySpec desKeySpec = new DESKeySpec(bytesKey);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            Key convertSecretKey = factory.generateSecret(desKeySpec);

            //加密 加密方式/工作模式/填充方式
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            //方式/秘钥
            cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("bc des加密后的数据："+ Base64.encodeBase64String(result));


            //解密 方式/秘钥
            cipher.init(Cipher.DECRYPT_MODE,convertSecretKey);
            result = cipher.doFinal(result);
            System.out.println("bc des解密后的数据：" + new String(result));
        } catch (Exception e) {
            System.out.println("error:"+e.getMessage());
        }
    }


    /**
     * 将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}
