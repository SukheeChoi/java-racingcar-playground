import utils.RandomNumberGenerator;

public class Car {
	private final String name;
	private int distance;
	
	public Car(String name, int distance) {
		this.name = name;
		this.distance = distance;
	}
	
	public void goForward() {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		if(4 <= randomNumberGenerator.getSingleDigitNaturalNum()) {
			this.distance += 1;
		}
	}
	
	public int checkDistance() {
		return this.distance;
	}
			
	
}
