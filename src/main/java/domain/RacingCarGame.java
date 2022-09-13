package domain;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import exception.InputValidator;
import ui.InputView;
import ui.OutputView;
import utils.StringHandler;

public class RacingCarGame {

	private List<Car> participantList; // 참가 자동차 목록.
	private Round ongoingRound; // 진행중인 라운드의 정보.
	private Round scheduledRoud; // 예정된 라운드의 횟수.
	
	private static OutputView outputView = new OutputView();
	private static InputView inputView = new InputView();
	private static InputValidator inputValidator = new InputValidator();
	private static StringHandler stringHandler = new StringHandler();
	
	public RacingCarGame() {
		this.ongoingRound = new Round();
	}

	// max 안 쓰기(maxdistance 찾아주는 메소드 정의), stream() 한 번만 쓰기.
	private List<Car> findChampions() {
		Optional<Car> champion = this.participantList.stream()
			.max(Comparator.comparing(Car::measureDistance));
		if(champion.isPresent()) { // max distance 값 찾아서 다시 참가자 목록에서 필터링하는게 맞나..?
			return this.participantList.stream()
				.filter(car -> car.measureDistance() == champion.get().measureDistance())
//				.collect(Collectors.toList()); // mutable
				.toList(); // returns an unmodifiable list.
		}
		
		// 우승자가 없는 경우가 있을 수 없지만
		// 특정 조건에서만 반환값이 의미있다면
		// 예외 상황에서의 반환값은 뭘로 설정하는게 좋을지?
		return Arrays.asList();
	}
	
	private void end() {
		outputView.noticeFinalResult( // List<String>
			findChampions().stream() // findChampions returns List<Car>
				.map(Car::findName)
				.toList() // returns an unmodifiable list.
		);
	}
	
	// TODO isNotFinished() -> Round 객체 내부 메소드로.
	public boolean isNotFinished() {
		return this.ongoingRound.getRound() < this.scheduledRoud.getRound();
	}
	

	public void registerParticipantList(List<String> participantList) {
		this.participantList = participantList.stream()
			.map(Car::new)
			.toList();
	}
	
	private void start() {
		outputView.printResultTitle();
		while(isNotFinished()) {
			this.ongoingRound.play(this.participantList);
		}
	}
	
	private void validateInning(String strScheduledRound) {
		inputValidator.castableToInt(strScheduledRound);
	}

	private void scheduleIniing() {
		outputView.guideTypeInningTotal();
		String strScheduledRound = inputView.getOneLine();
		validateInning(strScheduledRound);
		this.scheduledRoud = new Round(stringHandler.toInt(strScheduledRound));
	}
	
	private void validateCarName(String oneLineNames) {
		inputValidator.checkExistCharacter(oneLineNames);
	}
	
	private List<String> getParticipant() {
		outputView.guideTypeCarNames();
		String oneLineNames = inputView.getOneLine();
		validateCarName(oneLineNames);
		return stringHandler.splitStringToList(oneLineNames, ",");
	}
	
	public void process() {
		// validate(get())
		// register(split())
		registerParticipantList(getParticipant());
		scheduleIniing();
		start();
		end();
	}


}
