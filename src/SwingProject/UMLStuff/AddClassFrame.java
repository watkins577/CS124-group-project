package SwingProject.UMLStuff;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import SwingProject.Backend.Class;

public class AddClassFrame extends JFrame implements ActionListener{
	
	UMLPanel umlPanel;
	
	JTextField className = new JTextField();
	JLabel nameLabel = new JLabel("Name:");
	
	private JButton create = new JButton("Create Class");
	private JButton cancel	= new JButton("Cancel");
	
	int x;
	int y;
	
	EveryEventListener l;
	
	public AddClassFrame(UMLPanel _umlPanel, int _x, int _y) {
		umlPanel = _umlPanel;
		x = _x;
		y = _y;
		
		Container contentPane = getContentPane();
	    SpringLayout layout = new SpringLayout();
	    contentPane.setLayout(layout);
	    
	    contentPane.add(nameLabel);
	    contentPane.add(className);
	    contentPane.add(create);
	    contentPane.add(cancel);
	    contentPane.setPreferredSize(new Dimension(195, 70));
	    
	    create.addActionListener(this);
	    cancel.addActionListener(this);
	    
	    layout.putConstraint(SpringLayout.WEST, nameLabel, 5, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, nameLabel, 5, SpringLayout.NORTH, contentPane);
	    layout.putConstraint(SpringLayout.WEST, className, 5, SpringLayout.EAST, nameLabel);
	    layout.putConstraint(SpringLayout.NORTH, className, 5, SpringLayout.NORTH, contentPane);
	    
	    layout.putConstraint(SpringLayout.WEST, create, 5, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, create, 5, SpringLayout.SOUTH, className);
	    
	    layout.putConstraint(SpringLayout.WEST, cancel, 5, SpringLayout.EAST, create);
	    layout.putConstraint(SpringLayout.NORTH, cancel, 5, SpringLayout.SOUTH, className);
	    
	    layout.putConstraint(SpringLayout.EAST, contentPane, 5, SpringLayout.EAST, className);
	    layout.putConstraint(SpringLayout.SOUTH, contentPane, 5, SpringLayout.SOUTH, cancel);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add a Class");
		setLocation(400, 300);
		setVisible(true);
		
		pack();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == create) {
			umlPanel.addClass(new Class(className.getText()), x, y);
			dispose();
		} else if (e.getSource() == cancel) {
			dispose();
		}
	}
}
