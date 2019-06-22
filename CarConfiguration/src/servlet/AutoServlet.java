package servlet;

import java.io.ObjectInputStream;

import model.Automobile;

public interface AutoServlet {
	public String getCarList(ObjectInputStream i);
	public Automobile getCarObject(ObjectInputStream i);
}
