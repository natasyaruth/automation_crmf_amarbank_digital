package com.tunaiku.keyword

import java.security.GeneralSecurityException as GeneralSecurityException

import java.security.KeyFactory as KeyFactory
import java.security.SecureRandom as SecureRandom
import java.security.Security as Security
import java.security.spec.PKCS8EncodedKeySpec as PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec as X509EncodedKeySpec
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.InvalidKeyException;

import javax.crypto.Mac;
import javax.crypto.Cipher as Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

import org.apache.commons.codec.binary.Base64
import org.bouncycastle.jce.provider.BouncyCastleProvider

import com.kms.katalon.core.annotation.Keyword

import internal.GlobalVariable

public class SecureUtils {

	public static hmac_sha256(String secretKey, String data) {
		try {
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256")
			Mac mac = Mac.getInstance("HmacSHA256")
			mac.init(secretKeySpec)
			byte[] digest = mac.doFinal(data.getBytes("UTF-8"))
			String encodedString = Base64.encodeBase64String(digest);
			return encodedString
		}
		catch (InvalidKeyException e) {
			throw new RuntimeException("Invalid key exception while converting to HMac SHA256")
		}
	}

	public static byteArrayToString(byte[] data) {
		BigInteger bigInteger = new BigInteger(1, data)
		String hash = bigInteger.toString(16)
		//Zero pad it
		while (hash.length() < 64) {
			hash = "0" + hash
		}
		return hash
	}
}