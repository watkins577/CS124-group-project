package SwingProject.UMLStuff;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class RightClickPopupMenu extends JPopupMenu {
	
	public JMenuItem newClass;
	public JMenuItem generateJava;
	public JMenuItem clear;
	public JMenuItem save;
	public JMenuItem load;
	
	public RightClickPopupMenu(EveryEventListener l) {
		newClass = new JMenuItem("Create Class");
		newClass.addActionListener(l);
		add(newClass);
		generateJava = new JMenuItem("Generate Java");
		generateJava.addActionListener(l);
		add(generateJava);
		clear = new JMenuItem("Clear Panel");
		clear.addActionListener(l);
		add(clear);
		save = new JMenuItem("Save Panel");
		save.addActionListener(l);
		add(save);
		load = new JMenuItem("Load Panel");
		load.addActionListener(l);
		add(load);
	}
}
