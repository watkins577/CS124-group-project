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

import SwingProject.Backend.Field;

public class AddParamFrame extends JFrame implements ActionListener {
	
	AddMethodFrame addMethod;
	
	JLabel nameLabel = new JLabel("Name: ");
	JLabel typeLabel = new JLabel("Type: ");
	
	JTextField fieldName = new JTextField();
	JTextField fieldType = new JTextField();
	
	private JButton addField = new JButton("Add");
	private JButton cancel	= new JButton("Cancel");

	public AddParamFrame(AddMethodFrame addMethodFrame) {
		addMethod = addMethodFrame;
		
		Container contentPane = getContentPane();
	    SpringLayout layout = new SpringLayout();
	    contentPane.setLayout(layout);
	    
	    contentPane.add(nameLabel);
	    contentPane.add(typeLabel);
	    
	    contentPane.add(fieldName);
	    contentPane.add(fieldType);
	    
	    contentPane.add(addField);
	    contentPane.add(cancel);
	    
	    addField.addActionListener(this);
	    cancel.addActionListener(this);
	    
	    contentPane.setPreferredSize(new Dimension(195, 95));
	    
	    layout.putConstraint(SpringLayout.WEST, nameLabel, 5, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, nameLabel, 5, SpringLayout.NORTH, contentPane);
	    layout.putConstraint(SpringLayout.WEST, fieldName, 5, SpringLayout.EAST, nameLabel);
	    layout.putConstraint(SpringLayout.NORTH, fieldName, 5, SpringLayout.NORTH, contentPane);
	    
	    layout.putConstraint(SpringLayout.WEST, typeLabel, 5, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, typeLabel, 5, SpringLayout.SOUTH, fieldName);
	    layout.putConstraint(SpringLayout.WEST, fieldType, 5, SpringLayout.EAST, typeLabel);
	    layout.putConstraint(SpringLayout.NORTH, fieldType, 5, SpringLayout.SOUTH, fieldName);
	    
	    layout.putConstraint(SpringLayout.WEST, addField, 5, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, addField, 5, SpringLayout.SOUTH, fieldType);
	    layout.putConstraint(SpringLayout.WEST, cancel, 5, SpringLayout.EAST, addField);
	    layout.putConstraint(SpringLayout.NORTH, cancel, 5, SpringLayout.SOUTH, fieldType);
	    
	    layout.putConstraint(SpringLayout.EAST, contentPane, 5, SpringLayout.EAST, fieldType);
	    layout.putConstraint(SpringLayout.EAST, fieldName, -5, SpringLayout.EAST, contentPane);
	    layout.putConstraint(SpringLayout.SOUTH, contentPane, 5, SpringLayout.SOUTH, cancel);
	    
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Edit a class");
		setLocation(400, 300);
		setVisible(true);
		
		pack();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addField) {
			addMethod.addParamToParams(new Field(fieldName.getText(), fieldType.getText()));
			dispose();
		} else if (e.getSource() == cancel) {
			dispose();
		}
	}

}
