package dto;
import exception.DistanceValidator;

public class Distance {

	private Integer distance;
	
	private DistanceValidator distanceValidator = new DistanceValidator();
	
	public Distance() {
		this.distance = (Integer) 0;
	}
	
	public Distance(int distance) {
		// 유효성 검사.
		distanceValidator.isNotNegative(distance);
		this.distance = (Integer) distance;
	}

	public void plusOne() {
		this.distance += 1;
	}
	
	public int getDistance() {
		return this.distance;
	}
}
