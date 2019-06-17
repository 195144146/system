package com.yz.crm.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import org.junit.Test;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.security.internal.spec.TlsPrfParameterSpec;
import java.security.Provider;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;
import com.sun.crypto.provider.SunJCE;
public class ServiceApplicationTests {

	@Test
	public void contextLoads() {

		String keytarget = "yekdojlk8520ohjkpw;ehj7isbsdg7rh";
		String bikeRandNum = "detrtyk5u76543wfdfjk8r489okjmngb";
		String tspRandNum = "nmnbrtyujh2435689uyssaqw45h4edfv";
		String iccid = "89860416121890141131";
		try {
			System.out.println(bytes2HexString(prf(keytarget,bikeRandNum.getBytes(),tspRandNum.getBytes(),iccid)));
		}catch (Exception e) {
			e.getStackTrace();
		}

	}

	public static byte[] byteMerger(byte[] byte_1, byte[] byte_2){
		byte[] byte_3 = new byte[byte_1.length+byte_2.length];
		System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
		System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
		return byte_3;
	}

	public static String bytes2HexString(byte[] b) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}

		return sb.toString().trim();
	}



	public static byte[] prf(String keyTarget, byte[] randBikeNum, byte[] randTspNum, String iccid) throws Exception{
		byte[] param = byteMerger(randBikeNum, randTspNum);
		Map<String, byte[]> map = new HashMap<String, byte[]>();
		//密钥生成
		Provider provider = new SunJCE();
		KeyGenerator keyGenerator = KeyGenerator.getInstance("SunTls12Prf", provider);

		byte[] keytarget = keyTarget.getBytes(CharsetUtil.UTF_8);
		ByteBuf buf = Unpooled.buffer(keyTarget.length() + 2);
		buf.writeShort(keyTarget.length());
		buf.writeBytes(keytarget);

		//生成MasterSecret
		TlsPrfParameterSpec tlsPrfParameterSpec = new TlsPrfParameterSpec(new SecretKeySpec(buf.array(), "HmacSHA256"), iccid, param, 48, "SHA-256", 32, 64);

		keyGenerator.init(tlsPrfParameterSpec);
		SecretKey sk = keyGenerator.generateKey();
		byte[] b = sk.getEncoded();

		byte[] param1 = byteMerger(randTspNum, randBikeNum);
		TlsPrfParameterSpec realKey = new TlsPrfParameterSpec(new SecretKeySpec(b, "HmacSHA256"), "adb key expansion", param1, 128, "SHA-256", 32, 64);
		keyGenerator.init(realKey);
		SecretKey nk = keyGenerator.generateKey();
		byte[] key = nk.getEncoded();

//		map.put(Constant.WRITE_KEY_BIKE, ArrayUtils.subarray(key, 0, 16));
//		map.put(Constant.WRITE_KEY_TSP, ArrayUtils.subarray(key, 16, 32));
//		map.put(Constant.HMAC_KEY_BIKE, ArrayUtils.subarray(key, 32, 48));
//		map.put(Constant.HMAC_KEY_TSP, ArrayUtils.subarray(key, 48, 64));
//		map.put(Constant.IV_BIKE, ArrayUtils.subarray(key, 64, 80));
//		map.put(Constant.IV_TSP, ArrayUtils.subarray(key, 80, 96));

		buf.release();
		return key;
	}
}
