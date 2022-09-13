package exception;

import constants.ErrorMessage;

public class NameValidator {

	// Car의 name은 1~5자의 길이를 같도록 함.
	public void validateLength(String name) {
		if(5 < name.length()) { // name.length() < 1 경우는 공백체크에 해당됨.
			throw new IllegalArgumentException(ErrorMessage.EXCEED_CAR_NAME_LENGTH.getMessage());
		}
	}
}
