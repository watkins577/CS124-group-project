package SwingProject.UMLStuff;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import SwingProject.Backend.Class;

public class UMLPanel extends JPanel{
	
	private VectorOfClasses voc;
	RightClickPopupMenu rcmenu;
	
	
	public UMLPanel () {
		voc = new VectorOfClasses();
		setBackground(new Color(0xFFCC77));
		this.setPreferredSize(new Dimension(800, 600));
		EveryEventListener l = new EveryEventListener(this);
		addMouseMotionListener(l);
		addMouseListener(l);
		rcmenu = new RightClickPopupMenu(l);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		voc.drawAll(g);
	}
	
	public void addClass(Class c, int _x, int _y) {
		voc.addClass(new UMLClass(c, _x, _y));
		repaint();
	}
	
	public UMLClass findNearestClass(int _x, int _y) {
		return voc.findNearestClass(_x, _y);
	}
	
	public void generateJava() {
		voc.generateAll();
	}
	
	public void reset() {
		voc = new VectorOfClasses();
		repaint();
	}
	
	public void save() {
		JFileChooser fc = new JFileChooser();
		if (fc.showDialog(this, "Save") == JFileChooser.APPROVE_OPTION) {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fc.getSelectedFile()));
				oos.writeObject(voc);
				oos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		repaint();
	}
	
	public void load() {
		JFileChooser fc = new JFileChooser();
		if (fc.showDialog(this, "Load") == JFileChooser.APPROVE_OPTION) {
			try {
				if (fc.getSelectedFile().exists()) {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fc.getSelectedFile()));
					voc = (VectorOfClasses) ois.readObject();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		repaint();
	}
}
