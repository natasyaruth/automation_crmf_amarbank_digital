package com.tunaiku.keyword

public class RandomData {
	public static String randomDoubleFunc(int length){
		
				/**
				 * Using Math Function
				 * import java.lang.Math
				 * length => 14 ktp, length => 12 phone number
				 */
				double rand = Math.random();
				String randomStr = String.valueOf(rand).replace("0.", "");
				return randomStr.substring(0, length);
			}
}
