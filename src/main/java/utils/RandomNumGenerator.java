package utils;

import java.util.Random;

public class RandomNumGenerator {
	
	private static Random random = new Random();
	
	// 0 ~ 9 범위의 자연수 생성.
	public int getSingleDigitNaturalNum() {
		return random.nextInt(10); // 0~9.
	}
}
