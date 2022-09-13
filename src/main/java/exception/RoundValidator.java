package exception;

import constants.ErrorMessage;

public class RoundValidator {
	
	// Round를 설정할 때는 자연수만 가능하도록 함.
	public void isNaturalNum(int round) {
		if(round < 1) {
			throw new IllegalArgumentException(ErrorMessage.ROUND_MUST_BE_NATURAL_NUMBER.getMessage());
		}
	}

}
