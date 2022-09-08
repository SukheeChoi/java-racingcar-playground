package constant;

public enum ErrorMessage {

	CANNOT_CAST_TO_INT("CANNOT.CAST.TO.INT"),
	NOT_FOUND_ARGUMENT("NOT.FOUND.ARGUMENT"),
	INVALID_CAR_NAME("INVALID.CAR.NAME"),
	DISTANCE_CANNOT_BE_NEGATIVE("DISTANCE.CANNOT.BE.NAGATIVE"),
	ROUND_MUST_BE_NATURAL_NUMBER("ROUND.MUST.BE.NATURAL.NUMBER")
	;
	
	private String message;

	ErrorMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
