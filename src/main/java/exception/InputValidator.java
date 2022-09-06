package exception;

public class InputValidator {
	// 횟수 입력값을 String으로 받아서 int로 변환할 수 있는지 점검.
	public boolean castableToInt(String strInt) {
		try {
			Integer.parseInt(strInt);
			return true;
		} catch(Exception exception) {
			throw new NumberFormatException("값이 유효하지 않습니다.");
		}
	}

	// 입력값이 null, 공백인 경우 체크.
	public void checkInput(String input) {
		if(input == null ||
//				input == "" ||
				input.replace(" ", "") == "") {
			throw new RuntimeException("값이 유효하지 않습니다.");
		}
	}
}
