package com.sha.rest_security.util;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.Assert;

public class CryptographyUtil {

	public static String generateSecretKey() throws NoSuchAlgorithmException {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(256); // for example
		SecretKey secretKey = keyGen.generateKey();
		return Base64.getEncoder().encodeToString(secretKey.getEncoded());
	}
	
	public static SecretKey getSecretKey(String encodedSecretKey) {
		Assert.notNull(encodedSecretKey, "Null secret key string");
		byte[] decodedKey = Base64.getDecoder().decode(encodedSecretKey);
		// rebuild key using SecretKeySpec
		SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES"); 
		return originalKey;
	}

}
