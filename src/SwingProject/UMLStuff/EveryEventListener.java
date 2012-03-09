package SwingProject.UMLStuff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

public class EveryEventListener implements MouseListener, MouseMotionListener, ActionListener{
	
	private UMLPanel umlPanel;
	
	private int mouseX;
	private int mouseY;
	

	public EveryEventListener(UMLPanel _umlPanel) {
		umlPanel = _umlPanel;
	}

	public void mouseDragged(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			if (/*e.getSource() == umlPanel  &&*/ umlPanel.findNearestClass(e.getX(), e.getY()) != null) {
				umlPanel.findNearestClass(e.getX(), e.getY()).updatePos(e.getX(), e.getY());
				umlPanel.repaint();
			}
		}
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			if (e.getSource() == umlPanel) {
				umlPanel.rcmenu.show(e.getComponent(), e.getX(), e.getY());
			}
		}
		if (SwingUtilities.isLeftMouseButton(e)) {
			if (e.getSource() == umlPanel && umlPanel.findNearestClass(e.getX(), e.getY()) != null) {
				new EditClassFrame(umlPanel, umlPanel.findNearestClass(e.getX(), e.getY()));
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == umlPanel.rcmenu.newClass) {
			new AddClassFrame(umlPanel, mouseX, mouseY);
		} else if (e.getSource() == umlPanel.rcmenu.generateJava) {
			umlPanel.generateJava();
		} else if (e.getSource() == umlPanel.rcmenu.clear) {
			umlPanel.reset();
		} else if (e.getSource() == umlPanel.rcmenu.save) {
			umlPanel.save();
		} else if (e.getSource() == umlPanel.rcmenu.load) {
			umlPanel.load();
		}
	}

}
