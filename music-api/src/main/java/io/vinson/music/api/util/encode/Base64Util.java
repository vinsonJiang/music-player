package io.vinson.music.api.util.encode;

import org.apache.commons.codec.binary.Base64;


/**
 * @author: jiangweixin
 * @date: 2020/5/8
 */
public class Base64Util {

	public static final String encode(String data){
		byte[] bytes = data.getBytes();
		return Base64.encodeBase64String(bytes);
	}
	
	public static final String decode(String encodeData){
		byte[] bytes = Base64.decodeBase64(encodeData);
		return new String(bytes);
	}
}
