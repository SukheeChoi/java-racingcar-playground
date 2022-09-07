import exception.NameValidator;

public class Name {

	private String name;
	
	private NameValidator nameValidator = new NameValidator();
	
	public Name(String name) {
		// 유효성 검사. 1~5글자 사이.
		nameValidator.validateLength(name);
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
