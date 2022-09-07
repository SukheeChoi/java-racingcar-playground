package ui;

import java.util.Scanner;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);
	
	public String getInput() {
		String input = scanner.nextLine();
		return input;
	}
	
	
};
