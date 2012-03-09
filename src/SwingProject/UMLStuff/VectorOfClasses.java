package SwingProject.UMLStuff;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Vector;

import SwingProject.Backend.JavaGenerator;
import SwingProject.UMLStuff.UMLClass;

public class VectorOfClasses implements Serializable{
	
	private Vector<UMLClass> classes;
	
	VectorOfClasses() {
		classes = new Vector<UMLClass>();
	}
	
	public void addClass(UMLClass c) {
		classes.add(c);
	}
	
	public void drawAll(Graphics g) {
		UMLClass currentClass;

		for(int i=0; i < classes.size(); i++) {
			currentClass = (UMLClass)(classes.get(i));
			currentClass.draw(g);
		}
	}
	
	public void generateAll() {
		UMLClass currentClass;

		for(int i=0; i < classes.size(); i++) {
			currentClass = (UMLClass)(classes.get(i));
			JavaGenerator.createJavaCode(currentClass.get_class());
		}
	}
	
	public int getNoOfClasses() {
		return (classes.size());
	}
	
	public UMLClass findNearestClass(int x, int y) {
		UMLClass c;
		double minDist = Double.MAX_VALUE;
		int minDistIndex = -1;

		for(int i=0; i < classes.size(); i++) {
			c = (UMLClass)(classes.get(i));
			if(c.distanceTo(x,y) < minDist) {
				minDist = c.distanceTo(x,y);
				minDistIndex = i;
			}
		}
		if((minDistIndex >= 0) && (minDist < 30)) {
			return classes.get(minDistIndex);
		}
		return null;
	}
	
	public void removeNearestClass(int x, int y) {
		UMLClass c;
		double minDist = Double.MAX_VALUE;
		int minDistIndex = -1;

		for(int i=0; i < classes.size(); i++) {
			c = (UMLClass)(classes.get(i));
			if(c.distanceTo(x,y) < minDist) {
				minDist = c.distanceTo(x,y);
				minDistIndex = i;
			}
		}
		if((minDistIndex >= 0) && (minDist < 30)) {
			classes.remove(minDistIndex);
		}
	}
}
