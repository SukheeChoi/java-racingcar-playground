import java.util.Arrays;

import exception.InputValidator;
import ui.InputView;
import ui.OutputView;
import utils.StringHandler;

public class App {

	public static void main(String[] args) {
//		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
//		for(int i=1; i<50; i++) {
//			System.out.println(randomNumberGenerator.getSingleDigitNaturalNum());
//		}
//		Car car = new Car("T-Voli", 0);
//		car.goForward();
//		System.out.println(car.checkDistance());
		
		OutputView outputView = new OutputView();
		outputView.guideTypeCarName();
		
		InputView inputView = new InputView();
		String carNames = inputView.getInput();
		System.out.println(carNames);

		// 입력값 점검.
		InputValidator inputValidator = new InputValidator();
		inputValidator.checkInput(carNames);
		
		// 이름별로 나누기.
		StringHandler stringHandler = new StringHandler();
		String[] carNameArray = stringHandler.splitCarNames(carNames);
		
		// 자동차 객체 3개 생성.
//		Arrays.asList(new Car(), )
		
		
	}

}
