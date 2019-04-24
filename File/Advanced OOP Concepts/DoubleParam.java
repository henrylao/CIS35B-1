package mypackage;

public class DoubleParam<T, V> {
	private T first;
	private V second;
	
	public DoubleParam(T first, V second){
		this.setFirst(first);
		this.setSecond(second);
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public V getSecond() {
		return second;
	}

	public void setSecond(V second) {
		this.second = second;
	}

}
