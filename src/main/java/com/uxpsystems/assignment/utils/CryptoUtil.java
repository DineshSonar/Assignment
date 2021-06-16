package com.uxpsystems.assignment.utils;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class CryptoUtil {

	public String getShaEncryptedValue(CharSequence passwordToHash){
		 String generatedPassword = null;
		
	    try {
	        MessageDigest md = MessageDigest.getInstance(ApplicationConstants.Sha512);
	        md.update(ApplicationConstants.Salt.getBytes(StandardCharsets.UTF_8));
	        byte[] bytes = md.digest(passwordToHash.toString().getBytes(StandardCharsets.UTF_8));
	        StringBuilder stringBuilder = new StringBuilder();
	        for(int i=0; i< bytes.length ;i++){
	        	stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        generatedPassword = stringBuilder.toString();
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return generatedPassword;
	}
}
