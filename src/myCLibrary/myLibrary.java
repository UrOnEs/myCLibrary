package myCLibrary;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class myLibrary extends JFrame implements ActionListener{
	
	
	JFrame frame;
	
	JMenuBar menubar;
	JMenu Edit;
	JMenuItem Saveitem;
	JMenuItem Exititem;
	
	myLibrary(){
	//-------------Menü barı------------------
		menubar = new JMenuBar();
		
		Edit = new JMenu("OPTIONS");
		
		Saveitem = new JMenuItem("Save");
		Saveitem.addActionListener(this);
		
		Exititem = new JMenuItem("Exit");
		Exititem.addActionListener(this);

		Edit.add(Saveitem);
		Edit.add(Exititem);
		menubar.add(Edit);
		
	//-----------------------------------------
		
	//--------------Kütüphane------------------
		JPanel panel = new JPanel();//Dosyaları ekleyeceğim gözüken panel bu
		panel.setPreferredSize(new Dimension(600,400));
		panel.setBackground(Color.cyan);
		
		
		JPanel helper = new JPanel();//Bu panel bize ana paneli kutuya koymamıza yardım ediyor
		helper.setLayout(new GridBagLayout());
		helper.add(panel);
		
		
	//-----------------------------------------
	//----------------Ana Ekran--------------------
		frame = new JFrame();
		this.setJMenuBar(menubar);
		this.setTitle("CLibrary by UrOnEs");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(helper,BorderLayout.CENTER);
		
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	//-----------------------------------------

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Saveitem) {
			this.dispose();
			new SaveMenu(1);
		}
		if(e.getSource() == Exititem) {
			System.exit(1);
		}
	}


	

}
