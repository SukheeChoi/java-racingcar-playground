package com;
import java.util.List;

import domain.RacingCarGame;
import exception.InputValidator;
import ui.InputView;
import ui.OutputView;
import utils.StringHandler;

public class App {

	public static void main(String[] args) {
		OutputView outputView = new OutputView();
		InputView inputView = new InputView();
		InputValidator inputValidator = new InputValidator();
		StringHandler stringHandler = new StringHandler();
		
		outputView.guideTypeCarNames();
		String carNames = inputView.getInput();

		// 이름 입력값 점검.
		inputValidator.checkInput(carNames);
		// 이름별로 분리해서 List화.
		List<String> nameList = stringHandler.splitStringToList(carNames, ",");
		
		// 횟수 입력값 받기.
		outputView.guideTypeRoundNum();
		String strScheduledRound = inputView.getInput();
		// 횟수 입력값 점검.
		inputValidator.castableToInt(strScheduledRound);
		// 아래 라인은 true일 때만 실행되므로 if문 사용X.
		
		// RacingCarGame객체 생성.
		RacingCarGame racingCarGame = new RacingCarGame(stringHandler.toInt(strScheduledRound));
		racingCarGame.registerParticipants(nameList);
		
		// 게임 시작.
		racingCarGame.start();
		
		
	}

}
