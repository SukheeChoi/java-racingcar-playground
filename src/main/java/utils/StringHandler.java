package utils;

import java.util.Arrays;
import java.util.List;

public class StringHandler {
	
	// int로 변환 가능한지 여부 저검을 마친 문자열을 int로 변환.
	public int toInt(String strInt) {
		return Integer.parseInt(strInt);
	}

	// 입력값을 구분자로 나눠서 List화.
	public List<String> splitStringToList(String inputString, String delimeter) {
		return Arrays.asList(inputString.split(delimeter));
	}
}
