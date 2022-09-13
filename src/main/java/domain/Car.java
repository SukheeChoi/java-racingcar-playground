package domain;
import dto.Distance;
import dto.Name;
import utils.RandomNumGenerator;

public class Car {
	private final Name name;
	private Distance distance;
	
	private static final int THRESHOLD_RUNNABLE = 4;
	
	private static RandomNumGenerator randomNumberGenerator = new RandomNumGenerator();
	
	public Car(String name) {
		this.name = new Name(name);
		this.distance = new Distance();
	}
	
	// 자동차의 이름 찾기.
	public String findName() {
		return this.name.getName();
	}
	
	// 자동차의 이동거리 측정.
	public int measureDistance() {
		return this.distance.measureKilometer();
	}
	
	// 전진 가능여부 결정.
	public boolean isRunnable() {
		return THRESHOLD_RUNNABLE <= randomNumberGenerator.getSingleDigitNaturalNum();		
	}
	
	// 1distance 만큼 전진.
	public void goForward() {
		if(isRunnable()) {
			this.distance.plusOneKm(); // 한 칸 전진.
		}
	}
			
	
}
