package exception;

import constant.ErrorMessage;

public class RoundValidator {
	
	// Round를 설정할 때는 자연수만 가능하도록 함.
	public void isNaturalNumber(int round) {
		if(round < 1) {
			throw new IllegalArgumentException(ErrorMessage.ROUND_MUST_BE_NATURAL_NUMBER.getMessage());
		}
	}

}
