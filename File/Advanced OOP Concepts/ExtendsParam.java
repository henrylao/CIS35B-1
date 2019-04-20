package mypackage;

public class ExtendsParam<T extends Number> {
	private T value;
	
	public ExtendsParam(T value){
		this.setValue(value);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
