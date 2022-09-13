package exception;

import constants.ErrorMessage;

public class DistanceValidator {
	
	// Distance를 설정할 때는 음수가 불가능하도록 함.
	public void isNotNegative(int distance) {
		if(distance < 0) {
			throw new IllegalArgumentException(ErrorMessage.DISTANCE_CANNOT_BE_NEGATIVE.getMessage());
		}
	}
}
