import java.util.List;
import java.util.stream.Collectors;

import exception.RoundValidator;
import ui.OutputView;
import utils.RandomNumberGenerator;

public class Round {

	private Integer round;
	
	private static RoundValidator roundValidator = new RoundValidator();
	private static RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
	private static OutputView outputView = new OutputView();
	
	public Round() {
		this.round = (Integer) 0;
	}
	
	public Round(int round) {
		roundValidator.isNaturalNumber(round); // 유효성 검사.
		this.round = (Integer) round;
	}
	
	// 해당 라운드 진행 결과 출력.
	public void printResult(List<Car> participantList) {
		outputView.noticeRoundResult(
				participantList.stream()
					.collect(Collectors.toMap(car -> car.findName(), car -> car.measureDistance()))
			);
	}
	
	public void upNext() {
		this.round += 1;
	}
	
	public void play(List<Car> participantList) {
		// 조건에 따라서 전진하기.
		participantList.stream()
			.filter(car -> randomNumberGenerator.getSingleDigitNaturalNum() >= 4)
			.forEach(Car::goForward);
		upNext();// 라운드 올리기.
		printResult(participantList); // 라운드 결과 출력.
	}
	
	public int getRound() {
		return this.round;
	}

}
