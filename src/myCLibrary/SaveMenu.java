package myCLibrary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SaveMenu extends JFrame implements ActionListener{
	
	JFrame frame;
	JTextArea textArea;
	JMenuBar menubar;
	JMenu options;
	JMenuItem save;
	JMenuItem edit;
	JMenuItem cancel;

	SaveMenu(int number){
	//------------------Menü Barı--------------------------
		menubar = new JMenuBar();
		
		options = new JMenu("OPTIONS");
		
		save = new JMenuItem("Save");
		save.addActionListener(this);
		
		edit = new JMenuItem("Edit");
		edit.addActionListener(this);
		
		cancel = new JMenuItem("Cancel");
		cancel.addActionListener(this);
		
		if(number == 1) {
			options.add(save);
		}else {
			options.add(edit);
		}
		options.add(cancel);
		
		menubar.add(options);
	//------------------------------------------------------
	//--------------------Yazı Bölümü-----------------------
		textArea = new JTextArea();
		textArea.setPreferredSize(new Dimension(800,700));
		
	//-------------------------------------------------------
	//-----------------------Ana Ekran------------------------
		frame = new JFrame();
		this.setSize(600,800);
		this.setLayout(new BorderLayout());
		this.add(textArea,BorderLayout.CENTER);
		this.setJMenuBar(menubar);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.pack();
		this.setVisible(true);
	//-------------------------------------------------------

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancel) {
			this.dispose();
			new myLibrary();
		}
		
	}
}
