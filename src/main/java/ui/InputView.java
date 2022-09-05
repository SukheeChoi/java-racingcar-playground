package ui;

import java.util.Scanner;

public class InputView {
	
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		return input;
	}
	
	
	
}
