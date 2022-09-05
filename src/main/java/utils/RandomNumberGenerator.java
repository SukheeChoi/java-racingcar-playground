package utils;

public class RandomNumberGenerator {
	// 0 ~ 9 범위의 자연수 생성.
	public int getSingleDigitNaturalNum() {
		return (int) (Math.random() * 10);
	}
}
