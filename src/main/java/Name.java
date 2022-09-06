import exception.CarValidator;

public class Name {

	private String name;
	
	private CarValidator carValidator;
	
	public Name(String name) {
		// 유효성 검사. 1~5글자 사이. 
		carValidator.validateName(name);
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
