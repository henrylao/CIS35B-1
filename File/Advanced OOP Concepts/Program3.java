/* Scope management */

package mypackage;

public class Program3 {
	/* variable scope */
	
	public String variable1;    /* public scope */
	protected String variable2; /* protected scope */
	String variable3;           /* default or package-private scope */
	private String variable4;   /* private scope */
	
	public final String variable5 = "unmodifiable string"; /* final variable, value cannot be changed */
	public static String variable6 = "STATIC VALUE";       /* static variable, global to objects of the same type */
	
	/* method scope */
	
	public void method1(){ 
		
	} /* method with public scope */
	
	protected void method2(){
		
	} /* method with protected scope */
	
	void method3(){
		
	} /* method with default or package private scope */
	
	private void method4(){
		
	} /* method with private scope */
	
	public final void method5(){
		
	} /* final method, cannot be overridden by child class */
}
