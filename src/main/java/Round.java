import java.util.List;

import utils.RandomNumberGenerator;

public class Round {

	private int round;
	
	private static RandomNumberGenerator randomNumberGenerator;
	
	public Round(int round) {
		this.round = round;
	}
	
	public int getRound() {
		return this.round;
	}

	// round 실행.
	public void play(List<Car> participantList) {
		participantList.stream()
			.filter(car -> randomNumberGenerator.getSingleDigitNaturalNum() >= 4)
			.forEach(Car::goForward);
	}

	// round +1.
	public void goNext() {
		this.round += 1;
	}
}
