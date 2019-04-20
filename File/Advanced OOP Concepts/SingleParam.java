package mypackage;

public class SingleParam<T> {
	private T value;
	
	public SingleParam(T value){
		this.setValue(value);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
