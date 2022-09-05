package exception;

public class InputValidator {

	// 입력값이 null, 공백인 경우 체크.
	public void checkInput(String input) {
		if(input == null ||
//				input == "" ||
				input.replace(" ", "") == "") {
			throw new RuntimeException("값이 유효하지 않습니다.");
		}
	}
}
