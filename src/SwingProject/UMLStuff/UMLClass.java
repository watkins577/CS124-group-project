package SwingProject.UMLStuff;

import java.awt.Graphics;
import java.io.Serializable;

import SwingProject.Backend.Class;

public class UMLClass implements Serializable{
	
	private Class _class; 
	private UMLRectangle drawing;
	private int x;
	private int y;
	
	UMLClass(Class c, int _x, int _y) {
		_class = c;
		x = _x;
		y = _y;
		drawing = new UMLRectangle(c, _x, _y);
	}
	
	public double distanceTo (int _x, int _y) {
		return drawing.distanceTo(_x, _y);
	}
	
	public void draw(Graphics g) {
		drawing.draw(g);
	}
	
	public void updateRect(Class c) {
		_class = c;
		drawing.update(c);
	}
	
	public void updatePos(int _x, int _y) {
		x = _x;
		y = _y;
		drawing.update(_x, _y);
	}

	public Class get_class() {
		return _class;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
