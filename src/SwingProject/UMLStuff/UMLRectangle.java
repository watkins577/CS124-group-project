package SwingProject.UMLStuff;

import java.awt.Color;
import SwingProject.Backend.*;
import SwingProject.Backend.Class;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

public class UMLRectangle implements Serializable{

	private int x;
	private int y;
	private int width;
	private int height;
	private Class parentClass;
	private ArrayList<Method> methods;
	private ArrayList<Field> fields;
	private int textXPos = 10;
	private int textYPos = 20;

	UMLRectangle(Class c, int _x, int _y) {
		x = _x;
		y = _y;
		width = 160;
		parentClass = c;
		update(parentClass);
	}
	
	public void update(Class c) {
		methods = c.getMethods();
		fields = c.getFields();
	}

	public void draw(Graphics g) {
		resetSize();
		if (g.getFontMetrics().stringWidth(parentClass.getName()) > width+20) {
			width = g.getFontMetrics().stringWidth(parentClass.getName())+20;
		}
		for (int i = 0; i < fields.size(); i++) {
			if (g.getFontMetrics().stringWidth(getUMLFieldFromField(fields.get(i))) > width+20) {
				width = g.getFontMetrics().stringWidth(getUMLFieldFromField(fields.get(i)))+20;
			}
		}
		for (int i = 0; i < methods.size(); i++) {
			if (g.getFontMetrics().stringWidth(getUMLMethodFromMethod(methods.get(i))) > width+20) {
				width = g.getFontMetrics().stringWidth(getUMLMethodFromMethod(methods.get(i)))+20;
			}
		}
		g.setColor(Color.WHITE);
		g.fillRect(x-width/2, y-height/2, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x-width/2, y-height/2, width, height);
		g.drawRect(x-width/2, y-height/2, width, 30);
		g.drawRect(x-width/2, y-height/2, width, (fields.size() * 15) + 60);
		g.drawString(parentClass.getName(), x + textXPos-width/2, y + textYPos-height/2);
		for (int i = 0; i < fields.size(); i++) {
			g.drawString(getUMLFieldFromField(fields.get(i)), x+textXPos-width/2, (15*i)+y+textYPos+30-height/2);
		}
		for (int i = 0; i < methods.size(); i++) {
			g.drawString(getUMLMethodFromMethod(methods.get(i)), x+textXPos-width/2, (15*i)+y+textYPos+60+(15*fields.size())-height/2);
		}
	}
	
	private String getUMLFieldFromField(Field f) {
		StringBuilder uml = new StringBuilder();
		if (f.isPrivacy()) {
			uml.append("- ");
		} else {
			uml.append("+ ");
		}
		uml.append(f.getName()).append(" : ").append(f.getType());
		return uml.toString();
	}
	
	private String getUMLMethodFromMethod(Method m) {
		StringBuilder uml = new StringBuilder();
		if (m.isPrivacy()) {
			uml.append("- ");
		} else {
			uml.append("+ ");
		}
		uml.append(m.getName()).append("(");
		int i = 0;
		for (Field f : m.getParameters()) {
			if (i++ != 0) {
				uml.append(", ");
			}
			uml.append(getUMLParamFromField(f));
		}
		uml.append(") : ").append(m.getReturns());
		return uml.toString();
	}
	
	private String getUMLParamFromField(Field f) {
		StringBuilder uml = new StringBuilder();
		uml.append(f.getType()).append(" ").append(f.getName());
		return uml.toString();
	}

	private void resetSize() {
		height = 90 + (methods.size() * 15) + (fields.size() * 15);
		width = 160;
	}

	public double distanceTo(int _x, int _y) {
		return (Math.sqrt(Math.pow(Math.abs(_x - x), 2)
				+ Math.pow(Math.abs(_y - y), 2)));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void update(int _x, int _y) {
		x = _x;
		y = _y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ArrayList<Method> getMethods() {
		return methods;
	}

	public void setMethods(ArrayList<Method> methods) {
		this.methods = methods;
	}

	public ArrayList<Field> getFields() {
		return fields;
	}

	public void setFields(ArrayList<Field> fields) {
		this.fields = fields;
	}
}
