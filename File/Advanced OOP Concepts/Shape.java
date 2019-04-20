package mypackage;

public abstract class Shape {
	
	int x, y;
	
	void moveTo(int newX, int newY){
		this.x = newX;
		this.y = newY;
	}
	
	abstract void draw();
}
