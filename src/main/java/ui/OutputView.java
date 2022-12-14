package ui;

import java.util.List;
import java.util.Map;

public class OutputView {

	// 경기 결과 출력.
	public void noticeFinalResult(List<String> championList) {
		System.out.print(championList.get(0));
		if(championList.size() > 1) {
			for(int loop=1; loop<championList.size(); loop++) {
				System.out.print(", ");
				System.out.print(championList.get(loop));
			}
		}
		System.out.print("가 최종 우승했습니다.");
	}
	
	// 라운드 별 실행 결과 출력.
	public void noticeRoundResult(Map<String, Integer> participantList) {
		for(Map.Entry<String, Integer> participant : participantList.entrySet()) {
			System.out.println(participant.getKey() + " : " + "-".repeat(participant.getValue()));
		}
		System.out.println();
	}
	
	public void printResultTitle() {
		System.out.println();
		System.out.println("실행 결과");
	}
	
	public void guideTypeCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
	}
	
	public void guideTypeInningTotal() {
		System.out.println("시도할 회수는 몇회인가요?");
	}

}
