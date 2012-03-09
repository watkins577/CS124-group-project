package SwingProject.UMLStuff;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import SwingProject.Backend.Field;
import SwingProject.Backend.Method;

public class AddMethodFrame extends JFrame implements ActionListener{
	
	EditClassFrame editClass;
	
	JLabel nameLabel = new JLabel("Name: ");
	JLabel returnsLabel = new JLabel("Returns: ");
	JLabel privateLabel = new JLabel("Private: ");
	JLabel paramsLabel = new JLabel("Parameters: ");
	
	JTextField methodName = new JTextField();
	JTextField methodReturns = new JTextField();
	
	JCheckBox methodPrivate = new JCheckBox();
	
	JButton addParam = new JButton("+");
	JButton removeParam = new JButton("-");
	
	JComboBox<String> methodParams = new JComboBox<String>();
	
	ArrayList<Field> params = new ArrayList<Field>();
	
	private JButton addmethod = new JButton("Add");
	private JButton cancel	= new JButton("Cancel");

	public AddMethodFrame(EditClassFrame editClassFrame) {
		editClass = editClassFrame;
		
		Container contentPane = getContentPane();
	    SpringLayout layout = new SpringLayout();
	    contentPane.setLayout(layout);
	    
	    contentPane.add(nameLabel);
	    contentPane.add(returnsLabel);
	    contentPane.add(privateLabel);
	    contentPane.add(paramsLabel);
	    
	    contentPane.add(methodName);
	    contentPane.add(methodReturns);
	    contentPane.add(methodPrivate);
	    contentPane.add(methodParams);
	    
	    contentPane.add(addParam);
	    contentPane.add(removeParam);
	    
	    contentPane.add(addmethod);
	    contentPane.add(cancel);
	    
	    addmethod.addActionListener(this);
	    cancel.addActionListener(this);
	    
	    addParam.addActionListener(this);
	    removeParam.addActionListener(this);
	    
	    contentPane.setPreferredSize(new Dimension(250, 155));
	    
	    layout.putConstraint(SpringLayout.WEST, nameLabel, 5, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, nameLabel, 5, SpringLayout.NORTH, contentPane);
	    layout.putConstraint(SpringLayout.WEST, methodName, 5, SpringLayout.EAST, nameLabel);
	    layout.putConstraint(SpringLayout.NORTH, methodName, 5, SpringLayout.NORTH, contentPane);
	    
	    layout.putConstraint(SpringLayout.WEST, returnsLabel, 5, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, returnsLabel, 5, SpringLayout.SOUTH, methodName);
	    layout.putConstraint(SpringLayout.WEST, methodReturns, 5, SpringLayout.EAST, returnsLabel);
	    layout.putConstraint(SpringLayout.NORTH, methodReturns, 5, SpringLayout.SOUTH, methodName);
	    
	    layout.putConstraint(SpringLayout.WEST, privateLabel, 5, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, privateLabel, 5, SpringLayout.SOUTH, methodReturns);
	    layout.putConstraint(SpringLayout.WEST, methodPrivate, 5, SpringLayout.EAST, privateLabel);
	    layout.putConstraint(SpringLayout.NORTH, methodPrivate, 5, SpringLayout.SOUTH, methodReturns);
	    
	    layout.putConstraint(SpringLayout.WEST, paramsLabel, 5, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, paramsLabel, 5, SpringLayout.SOUTH, methodPrivate);
	    layout.putConstraint(SpringLayout.WEST, methodParams, 5, SpringLayout.EAST, paramsLabel);
	    layout.putConstraint(SpringLayout.NORTH, methodParams, 5, SpringLayout.SOUTH, methodPrivate);
	    
	    layout.putConstraint(SpringLayout.WEST, addmethod, 5, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, addmethod, 5, SpringLayout.SOUTH, methodParams);
	    layout.putConstraint(SpringLayout.WEST, cancel, 5, SpringLayout.EAST, addmethod);
	    layout.putConstraint(SpringLayout.NORTH, cancel, 5, SpringLayout.SOUTH, methodParams);
	    
	    layout.putConstraint(SpringLayout.WEST, addParam, 5, SpringLayout.EAST, methodParams);
	    layout.putConstraint(SpringLayout.NORTH, addParam, 5, SpringLayout.SOUTH, methodPrivate);
	    layout.putConstraint(SpringLayout.WEST, removeParam, 5, SpringLayout.EAST, addParam);
	    layout.putConstraint(SpringLayout.NORTH, removeParam, 5, SpringLayout.SOUTH, methodPrivate);
	    
	    layout.putConstraint(SpringLayout.EAST, contentPane, 5, SpringLayout.EAST, methodReturns);
	    layout.putConstraint(SpringLayout.EAST, methodName, -5, SpringLayout.EAST, contentPane);
	    layout.putConstraint(SpringLayout.SOUTH, contentPane, 5, SpringLayout.SOUTH, cancel);
	    
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Edit a class");
		setLocation(400, 300);
		setVisible(true);
		
		pack();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addParam) {
			new AddParamFrame(this);
		} else if (e.getSource() == removeParam) {
			if (methodParams.getSelectedIndex()!= -1) {
				params.remove(methodParams.getSelectedIndex());
				methodParams.removeItemAt(methodParams.getSelectedIndex());
			}
		} else if (e.getSource() == addmethod) {
			editClass.addMethodToMethods(new Method(methodName.getText(), methodPrivate.isSelected(), methodReturns.getText(), params));
			this.dispose();
		} else if (e.getSource() == cancel) {
			this.dispose();
		}
	}
	
	public void addParamToParams(Field f) {
		params.add(f);
		methodParams.addItem(f.getName());
	}

}
