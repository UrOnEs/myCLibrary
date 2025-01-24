package myCLibrary;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class myLibrary extends JFrame implements ActionListener{
	
	MyCode[] codes;
	JFrame frame;
	JPanel panel;
	JMenuBar menubar;
	JMenu Edit;
	JMenuItem Saveitem;
	JMenuItem Exititem;
	
	myLibrary(){
		//-------------Menü barı------------------
		menubar = new JMenuBar();
		
		Edit = new JMenu("EDIT");
		
		Saveitem = new JMenuItem("Save");
		Saveitem.addActionListener(this);
		Exititem = new JMenuItem("Exit");

		Edit.add(Saveitem);
		Edit.add(Exititem);
		menubar.add(Edit);
		
		//-----------------------------------------
		
		//--------------Kütüphane------------------
		panel = new JPanel();
		
		
		//-----------------------------------------
		frame = new JFrame();
		this.setJMenuBar(menubar);
		this.setTitle("CLibrary by UrOnEs");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Saveitem) {
			this.dispose();
			new MyCode();
			
		}
	}

}
