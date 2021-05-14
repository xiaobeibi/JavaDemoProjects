package com.bjpowernode.pan.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 */
public class EncryptUtil {

    private static Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

    // 向量
    private final byte[] DESIV = new byte[] {0x12, 0x34, 0x56, 120, (byte) 0x90, (byte) 0xab, (byte) 0xcd, (byte) 0xef};


    // 加密算法的参数接口
    private AlgorithmParameterSpec iv;

    private Key key;

    /**
     * 初始化
     *
     * @param deSkey 密钥
     * @throws Exception
     */
    public EncryptUtil(String deSkey, String charset) throws Exception {
        String charset1 = "utf-8";
        if (StringUtils.isNotBlank(charset)) {
            charset1 = charset;
        }
        DESKeySpec keySpec = new DESKeySpec(deSkey.getBytes(charset1));// 设置密钥参数
        iv = new IvParameterSpec(DESIV);// 设置向量
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 获得密钥工厂
        key = keyFactory.generateSecret(keySpec);// 得到密钥对象
    }

    /**
     * 加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public String encode(String data) throws Exception {
        // 得到加密对象Cipher
        Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        // 设置工作模式为加密模式，给出密钥和向量
        enCipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] pasByte = enCipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        String encodePlus = Base64.getEncoder().encodeToString(pasByte);
        String encodePure = encodePlus.replace("+", "_");
        encodePure = encodePure.replace("/", "-");
        if (SystemUtil.isWindows()) {
            encodePure = encodePure.replace("\r\n", "~");
        } else {
            encodePure = encodePure.replace("\n", "~");
        }

        return encodePure;
    }

    /**
     * 解密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public String decode(String data) throws Exception {
        data = data.replace("_", "+");
        data = data.replace("-", "/");
        if (SystemUtil.isWindows()) {
            data = data.replace("~", "\r\n");
        } else {
            data = data.replace("~", "\n");
        }
        data = data.replace("~", "\r\n");
        Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        deCipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] pasByte = deCipher.doFinal(Base64.getDecoder().decode(data));
        return new String(pasByte, StandardCharsets.UTF_8);
    }
}
