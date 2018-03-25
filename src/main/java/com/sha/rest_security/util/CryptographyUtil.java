package com.sha.rest_security.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
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
	
	public static KeyPair getRSAKey(String keyAliasName) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException {
		KeyStore keyStore=loadKeyStore();
	    Key key = keyStore.getKey(keyAliasName, "India@123".toCharArray());
	    if (key instanceof PrivateKey) {
	      // Get certificate of public key
	      Certificate cert = keyStore.getCertificate(keyAliasName);

	      // Get public key
	      PublicKey publicKey = cert.getPublicKey();

	      // Return a key pair
	      return new KeyPair(publicKey, (PrivateKey) key);
	    }
	    return null;
	}
	
	public static PublicKey getPublicKey(KeyPair keyPair) {
		return keyPair.getPublic();
	}
	public static PrivateKey getPrivateKey(KeyPair keyPair) {
		return keyPair.getPrivate();
	}

	private static KeyStore loadKeyStore() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
		ClassLoader classLoader = CryptographyUtil.class.getClassLoader();
		File file = new File(classLoader.getResource("private/sec_keystore.jks").getFile());

	    FileInputStream is = new FileInputStream(file);
	    KeyStore keyStore=KeyStore.getInstance(KeyStore.getDefaultType());
	    keyStore.load(is, "sec_password".toCharArray());
	    return keyStore;
	}

}
