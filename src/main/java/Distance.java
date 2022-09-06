
public class Distance {

	private int distance;
	
	public Distance(int distance) {
		// 유효성 검사.
		this.distance = distance;
	}

	public void plusOne() {
		this.distance += 1;
	}
	
	public int getDistance() {
		return this.distance;
	}
}
