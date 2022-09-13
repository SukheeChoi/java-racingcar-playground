package dto;
import exception.DistanceValidator;

public class Distance {

	private Integer kilometer;
	
	private static DistanceValidator distanceValidator = new DistanceValidator();
	
	public Distance() {
		this.kilometer = 0;
	}
	
	public Distance(int distance) {
		// 유효성 검사.
		distanceValidator.isNotNegative(distance);
		this.kilometer = distance;
	}

	public void plusOneKm() {
		this.kilometer += 1;
	}
	
	public int measureKilometer() {
		return this.kilometer;
	}
}
