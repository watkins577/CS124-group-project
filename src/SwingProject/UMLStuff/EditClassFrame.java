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
import SwingProject.Backend.Class;

public class EditClassFrame extends JFrame implements ActionListener{
	
	UMLPanel umlPanel;
	UMLClass editClass;
	
	JLabel nameLabel = new JLabel("Name: ");
	JLabel extendsLabel = new JLabel("Extends: ");
	JLabel hasMainLabel = new JLabel("Has Main: ");
	JLabel fieldsLabel = new JLabel("Fields: ");
	JLabel methodsLabel = new JLabel("Methods: ");
	
	JTextField className = new JTextField();
	JTextField classExtends = new JTextField();
	
	JCheckBox classHasMain = new JCheckBox();
	
	JComboBox<String> classFields = new JComboBox<String>();
	JComboBox<String> classMethods = new JComboBox<String>();
	
	JButton addField = new JButton("+");
	JButton addMethod = new JButton("+");
	
	JButton removeField = new JButton("-");
	JButton removeMethod = new JButton("-");
	
	private JButton edit = new JButton("Edit");
	private JButton cancel	= new JButton("Cancel");
	
	ArrayList<Field> fields;
	ArrayList<Method> methods;

	public EditClassFrame(UMLPanel _umlPanel, UMLClass _class) {
		umlPanel = _umlPanel;
		editClass = _class;
		
		Container contentPane = getContentPane();
	    SpringLayout layout = new SpringLayout();
	    contentPane.setLayout(layout);
	    
	    contentPane.add(nameLabel);
	    contentPane.add(extendsLabel);
	    contentPane.add(hasMainLabel);
	    contentPane.add(fieldsLabel);
	    contentPane.add(methodsLabel);
	    
	    contentPane.add(className);
	    contentPane.add(classExtends);
	    
	    contentPane.add(classHasMain);
	    
	    contentPane.add(classFields);
	    contentPane.add(classMethods);
	    
	    contentPane.add(addField);
	    contentPane.add(addMethod);
	    contentPane.add(removeField);
	    contentPane.add(removeMethod);
	    
	    contentPane.add(edit);
	    contentPane.add(cancel);
	    
	    addField.addActionListener(this);
	    addMethod.addActionListener(this);
	    removeField.addActionListener(this);
	    removeMethod.addActionListener(this);
	    edit.addActionListener(this);
	    cancel.addActionListener(this);
	    
	    className.setText(editClass.get_class().getName());
	    classExtends.setText(editClass.get_class().getExtendsFrom());
	    classHasMain.setSelected(editClass.get_class().getHasMain());
	    
	    fields = (ArrayList<Field>) editClass.get_class().getFields().clone();
	    methods = (ArrayList<Method>) editClass.get_class().getMethods().clone();
	    
	    for (Field f : fields) {
	    	classFields.addItem(f.getName());
	    }
	    
	    for (Method m : methods) {
	    	classMethods.addItem(m.getName());
	    }
	    
	    contentPane.setPreferredSize(new Dimension(250, 185));
	    
	    layout.putConstraint(SpringLayout.WEST, nameLabel, 5, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, nameLabel, 5, SpringLayout.NORTH, contentPane);
	    layout.putConstraint(SpringLayout.WEST, className, 5, SpringLayout.EAST, nameLabel);
	    layout.putConstraint(SpringLayout.NORTH, className, 5, SpringLayout.NORTH, contentPane);
	    
	    layout.putConstraint(SpringLayout.WEST, extendsLabel, 5, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, extendsLabel, 5, SpringLayout.SOUTH, className);
	    layout.putConstraint(SpringLayout.WEST, classExtends, 5, SpringLayout.EAST, extendsLabel);
	    layout.putConstraint(SpringLayout.NORTH, classExtends, 5, SpringLayout.SOUTH, className);
	    
	    layout.putConstraint(SpringLayout.WEST, hasMainLabel, 5, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, hasMainLabel, 5, SpringLayout.SOUTH, classExtends);
	    layout.putConstraint(SpringLayout.WEST, classHasMain, 5, SpringLayout.EAST, hasMainLabel);
	    layout.putConstraint(SpringLayout.NORTH, classHasMain, 5, SpringLayout.SOUTH, classExtends);
	    
	    layout.putConstraint(SpringLayout.WEST, fieldsLabel, 5, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, fieldsLabel, 5, SpringLayout.SOUTH, classHasMain);
	    layout.putConstraint(SpringLayout.WEST, classFields, 5, SpringLayout.EAST, fieldsLabel);
	    layout.putConstraint(SpringLayout.NORTH, classFields, 5, SpringLayout.SOUTH, classHasMain);
	    
	    layout.putConstraint(SpringLayout.WEST, addField, 5, SpringLayout.EAST, classFields);
	    layout.putConstraint(SpringLayout.NORTH, addField, 5, SpringLayout.SOUTH, classHasMain);
	    layout.putConstraint(SpringLayout.WEST, removeField, 5, SpringLayout.EAST, addField);
	    layout.putConstraint(SpringLayout.NORTH, removeField, 5, SpringLayout.SOUTH, classHasMain);
	    
	    layout.putConstraint(SpringLayout.WEST, methodsLabel, 5, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, methodsLabel, 5, SpringLayout.SOUTH, classFields);
	    layout.putConstraint(SpringLayout.WEST, classMethods, 5, SpringLayout.EAST, methodsLabel);
	    layout.putConstraint(SpringLayout.NORTH, classMethods, 5, SpringLayout.SOUTH, classFields);
	    
	    layout.putConstraint(SpringLayout.WEST, addMethod, 5, SpringLayout.EAST, classMethods);
	    layout.putConstraint(SpringLayout.NORTH, addMethod, 5, SpringLayout.SOUTH, classFields);
	    layout.putConstraint(SpringLayout.WEST, removeMethod, 5, SpringLayout.EAST, addMethod);
	    layout.putConstraint(SpringLayout.NORTH, removeMethod, 5, SpringLayout.SOUTH, classFields);
	    
	    layout.putConstraint(SpringLayout.WEST, edit, 5, SpringLayout.WEST, contentPane);
	    layout.putConstraint(SpringLayout.NORTH, edit, 5, SpringLayout.SOUTH, classMethods);
	    layout.putConstraint(SpringLayout.WEST, cancel, 5, SpringLayout.EAST, edit);
	    layout.putConstraint(SpringLayout.NORTH, cancel, 5, SpringLayout.SOUTH, classMethods);
	    
	    layout.putConstraint(SpringLayout.EAST, contentPane, 5, SpringLayout.EAST, classExtends);
	    layout.putConstraint(SpringLayout.EAST, className, -5, SpringLayout.EAST, contentPane);
	    layout.putConstraint(SpringLayout.SOUTH, contentPane, 5, SpringLayout.SOUTH, cancel);
	    
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Edit a class");
		setLocation(400, 300);
		setVisible(true);
		
		pack();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addField) {
			new AddFieldFrame(this);
		} else if (e.getSource() == removeField) {
			if (classFields.getSelectedIndex() != -1) {
				fields.remove(classFields.getSelectedIndex());
				classFields.removeItemAt(classFields.getSelectedIndex());
			}
		} else if (e.getSource() == addMethod) {
			new AddMethodFrame(this);
		} else if (e.getSource() == removeMethod) {
			if (classMethods.getSelectedIndex() != -1) {
				methods.remove(classMethods.getSelectedIndex());
				classMethods.removeItemAt(classMethods.getSelectedIndex());
			}
		} else if (e.getSource() == edit) {
			Class c = new Class(className.getText(), classExtends.getText(), classHasMain.isSelected(), methods, fields);
			editClass.updateRect(c);
			umlPanel.repaint();
			this.dispose();
		} else if (e.getSource() == cancel) {
			this.dispose();
		}
	}
	
	public void addFieldToFields(Field f) {
		fields.add(f);
		classFields.addItem(f.getName());
	}
	
	public void addMethodToMethods(Method m) {
		methods.add(m);
		classMethods.addItem(m.getName());
	}

}
