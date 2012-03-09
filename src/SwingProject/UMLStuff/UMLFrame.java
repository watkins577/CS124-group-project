package SwingProject.UMLStuff;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class UMLFrame extends JFrame{

	/**
	 * @param args
	 */
	
	UMLPanel umlPanel = new UMLPanel();
	
	public UMLFrame() {
		setTitle("CS124 Group Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocation(320, 180);
		add(umlPanel, BorderLayout.CENTER);
		pack();
		umlPanel.repaint();
	}

}
