package main;
import files.A;
import files.A.B;
import files.A.C;

public class InnerClass {
	public static void main(String [] args) {
		A obj = new A();
		A.i = 5;
		// we have A.class
		// we have X.class 
		// but since is inside A, we have 
		// A$B.class
		A.B obj1 = obj.new B();
		A.C obj2 = new A.C();
	}
}
