package myCLibrary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;

public class Codes extends JLabel implements MouseListener{

	JLabel label;
	File file;
	Codes(File f){
		file = f;
		label = new JLabel();
		this.setPreferredSize(new Dimension(120,80));
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		this.setText(f.getName());
		this.addMouseListener(this);
		
	}
	public File getFile() {
		return file;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object[] answers = {"Edit","Delete","Cancel"};
		int answer = JOptionPane.showOptionDialog(
				null,
				"What do you want to do?",
				file.getName(),
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				answers,
				answers[2]
				);
		switch(answer) {
		case 0:
			try {
			new ShowCaseMenu(new File(file.getAbsolutePath()));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			break;
		case 1:
			file.delete();
			break;
		case 2:
			break;
		}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
