package domain;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dto.Round;
import ui.OutputView;

public class RacingCarGame {

	private List<Car> participantList; // 참가 자동차 목록.
	private Round ongoingRound; // 진행중인 라운드의 정보.
	private Round scheduledRoud; // 예정된 라운드의 횟수.
	
	private static OutputView outputView = new OutputView();
	
	public RacingCarGame(int scheduledRound) {
		this.ongoingRound = new Round();
		this.scheduledRoud = new Round(scheduledRound);
	}
	
	// 우승 자동차 목록 구하기.
	private List<Car> findChampions() {
		Optional<Car> champion = this.participantList.stream()
			.max(Comparator.comparing(Car::measureDistance));
		if(champion.isPresent()) {
			return this.participantList.stream()
				.filter(car -> car.measureDistance() == champion.get().measureDistance())
				.collect(Collectors.toList());
		}
		
		// 우승자가 없는 경우가 있을 수 없지만
		// 특정 조건에서만 반환값이 의미있다면
		// 예외 상황에서의 반환값은 뭘로 설정하는게 좋을지?
		return Arrays.asList();
	}
	
	// 게임 종료.
	private void end() {
		List<Car> championList = findChampions();
		if(!championList.isEmpty()) { // 우승자 있는 경우.
			outputView.noticeFinalResult( // List<String>
				championList.stream()
					.map(car -> car.findName())
					.collect(Collectors.toList())
			);
		}
		// 
	}
	
	// 경주 진행 가능상태 점검. 경주 종료여부 점검.
	public boolean isNotFinished() {
		if(this.ongoingRound.getRound() < this.scheduledRoud.getRound()) {
			return true;
		}
		return false;
	}
	
	// 자동차 경주 시작.
	public void start() {
		outputView.printResultTitle();
		while(isNotFinished()) {
			this.ongoingRound.play(this.participantList);
		}
		end(); // 경기가 종료됨.
	}

	// 참가 자동자 만큼 Car객체 생성하고 List화 해서 필드에 등록.
	public void registerParticipants(List<String> participantList) {
		// 참가 자동차의 수만큼 Car객체 생성.
		this.participantList = participantList.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}
}
