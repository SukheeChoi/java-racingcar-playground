package exception;

import constants.ErrorMessage;

public class InputValidator {
	// 횟수 입력값을 String으로 받아서 int로 변환할 수 있는지 점검.
	public boolean castableToInt(String strInt) {
		try {
			Integer.parseInt(strInt);
			return true;
		} catch(Exception exception) {
			throw new NumberFormatException(ErrorMessage.CANNOT_CAST_TO_INT.getMessage());
		}
	}

	// 입력값이 null, 공백인 경우 체크.
	public void checkExistCharacter(String input) {
		if((input == null) ||
			(input.replace(" ", "").equals(""))) {
			throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_ARGUMENT.getMessage());
		}
	}
}
