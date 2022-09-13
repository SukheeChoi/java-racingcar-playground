package domain;
import java.util.List;
import java.util.stream.Collectors;

import exception.RoundValidator;
import ui.OutputView;
import utils.RandomNumGenerator;

public class Round {
	// TODO 필드 이원화 (ongoingInning, finalInning).
	private Integer inning;
	
	private static RoundValidator roundValidator = new RoundValidator();
	private static RandomNumGenerator randomNumberGenerator = new RandomNumGenerator();
	private static OutputView outputView = new OutputView();
	
	public Round() {
		this.inning = 0;
	}
	
	public Round(int round) {
		roundValidator.isNaturalNum(round); // 유효성 검사.
		this.inning = round;
	}
	
	// 해당 라운드 진행 결과 출력.
	public void printResult(List<Car> participantList) {
		outputView.noticeRoundResult(
				participantList.stream()
					.collect(Collectors.toMap(Car::findName, Car::measureDistance))
			);
	}
	
	public void upNext() {
		this.inning += 1;
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
		return this.inning;
	}
	
}
