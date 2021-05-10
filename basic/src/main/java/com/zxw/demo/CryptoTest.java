package com.zxw.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.omg.CORBA.PRIVATE_MEMBER;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;

/**
 * @Author: Ryan
 * @Date: 2020/11/13 10:15
 * @Version: 1.0
 * @Description: crypto 加密解密测试
 */
@Slf4j
public class CryptoTest {

    private static String key = "d3pyBTmN5fcmBMxcmLTsz3MdoUeBy2/IViwBojQ1L7kIi6PhQcYi2cV7zl+7cRygQcJXMYHB1QlkdX7+Y0C7A1Iz93RGB9NYDUo9kZYz75sSx2J+ofGuEcGrL6aI/FwTnRVLB5mVUCdLVCV0sf6zMYjJQywTuDEA2W1EyrxmiIs=";
    private static String data = "8/uIbvCgcVNqFDr9X5pWX3b49s1kppxblQGlxKly8Qxk1f5w15dVrviCxNmnLe1L";
    private static String iv = "1234567887654321";
    private static String type = "AES/CBC/PKCS5Padding";
    public static String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJ0qlp8nciDzOwfuzgwIAT2RlF3vQ5EdxRuyfVzkGRKoQdsOSayz/kCGhZjaFeSFWEclC/4hz\n" +
            "nr4pc0xI8TtYmGD7xuNaQliSbavOlfrRqLyxFVsrb7d3InATxSheWu9p4ZgEYS3JjIUri3UjoJcqKpnxoYo09bCF963r1U11ga/AgMBAAECgYBdQFiwQ/JWlJ\n" +
            "rQ4SNGRjWeN1OFzKIVZ0l9XpE9XWV3CXhRpg\n" +
            "+WthFEbcy03akhtvCi/ds4xQxDMGcH8YEcphC5gnXe7cfFY9mDKoHmFs9FS9kA9IV03huvcJOLyFAZSLOouJw7jMSMCUKgZuLfce61OViMTnnsJrVvX9NxK4C\n" +
            "5YQJBAPVMUym4PeodQAUpHLcLg2c2F71mzyTwr2AKQ5IqC6JkS4/A1xW2Ea/OxYDK7/uYae9ieW6MqJzN8Q/Y4UYVt5ECQQCkBfDtKbg90WuEr4jYaIW/MdsU\n" +
            "dNjoIMfoVkYVLT/Gsp6633lAjeliKZlxhQa2Dj/Z39riOa4PKGDRv\n" +
            "+QlddFPAkBJtIFYi8+uxNMzucKzDXaSUKKZeobLZraLeQoMpS2RwekibKM0Ft0BonOd21x4kLdkAobSPNl9JDRGurgVwvjBAkAmyQTcf9YCQCgFeyCH08d0m4\n" +
            "xrfOnhkgbTaLsvvMBs8sXX+IoKesQqIx4Wmtcoa5wrn+R5RBxlly21y4NeXEq/AkBJAZWsY\n" +
            "+yOwp5kWy9KFZ2LmWDBwfJWEbK01Jk6t58dOQw61jGnAW3YaaqsRXoCYFL11cF2R3PGkjxfRPDDcHp/";

    public static void main(String[] args) throws Exception {
        byte[] decode = java.util.Base64.getDecoder().decode(data);
        Cipher cipher = Cipher.getInstance(type);
        String deKey = rsaDecrypt(key, privateKey, StandardCharsets.UTF_8.toString());
        log.info("deKey={}", deKey);
        IvParameterSpec ivp = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(deKey.getBytes(StandardCharsets.UTF_8), "AES"), ivp);
        byte[] doFinal = cipher.doFinal(decode);
        log.info("deString={}", new String(doFinal));
    }

    public static String rsaDecrypt(String content, String privateKey, String charset) throws Exception {
        try {
            PrivateKey priKey = getPrivateKeyFromPKCS8(new ByteArrayInputStream(privateKey.getBytes()));
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            byte[] encryptedData = (charset == null || charset.isEmpty()) ? Base64.decodeBase64(content.getBytes())
                    : Base64.decodeBase64(content.getBytes(charset));
            int inputLen = encryptedData.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > 128) {
                    cache = cipher.doFinal(encryptedData, offSet, 128);
                } else {
                    cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * 128;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            return (charset == null || charset.isEmpty()) ? new String(decryptedData) : new String(decryptedData, charset);
        } catch (Exception e) {
            throw new Exception("EncodeContent = " + content + ",charset = " + charset, e);
        }
    }

    public static PrivateKey getPrivateKeyFromPKCS8(InputStream is) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        StringWriter writer = new StringWriter();
        Reader in = new InputStreamReader(is);
        char[] buffer = new char[4096];
        int amount;
        while ((amount = in.read(buffer)) >= 0) {
            writer.write(buffer, 0, amount);
        }
        byte[] encodedKey = writer.toString().getBytes();
        encodedKey = Base64.decodeBase64(encodedKey);
        return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedKey));
    }
}
