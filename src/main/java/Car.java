import utils.RandomNumberGenerator;

public class Car {
	private final Name name;
	private Distance distance;
	
	public Car(String name) {
		this.name = new Name(name);
	}
	
	// 자동차의 이름 찾기.
	public String findName() {
		return this.name.getName();
	}
	
	// 자동차의 이동거리 측정.
	public int measureDistance() {
		return this.distance.getDistance();
	}
	
	public void goForward() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		if(4 <= randomNumberGenerator.getSingleDigitNaturalNum()) {
			distance.plusOne(); // 한 칸 전진.
		}
	}
			
	
}
