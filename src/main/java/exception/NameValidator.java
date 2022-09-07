package exception;

import constant.ErrorMessage;

public class NameValidator {

	// Car의 name은 1~5자의 길이를 같도록 함.
	public void validateLength(String name) {
		if(name.length() < 1 && 5 < name.length()) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.getMessage());
		}
	}
}
