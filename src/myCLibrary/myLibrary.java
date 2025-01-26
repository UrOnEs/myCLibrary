package myCLibrary;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class myLibrary extends JFrame implements ActionListener{
	
	File codeDirectory = new File("CodesArchive");
	File[] codes = codeDirectory.listFiles();
	
	JFrame frame;
	
	JMenuBar menubar;
	JMenu Edit;
	JMenuItem Refreshitem;
	JMenuItem Saveitem;
	JMenuItem Exititem;
	
	myLibrary(){
	//-------------Menü barı------------------
		menubar = new JMenuBar();
		
		Edit = new JMenu("OPTIONS");
		
		Refreshitem = new JMenuItem("Refresh");
		Refreshitem.addActionListener(this);
		
		Saveitem = new JMenuItem("Save");
		Saveitem.addActionListener(this);
		
		Exititem = new JMenuItem("Exit");
		Exititem.addActionListener(this);
		
		Edit.add(Refreshitem);
		Edit.add(Saveitem);
		Edit.add(Exititem);
		
		menubar.add(Edit);
		
	//-----------------------------------------
		
	//--------------Kütüphane------------------
		JPanel panel = new JPanel();//Dosyaları ekleyeceğim gözüken panel bu
		panel.setPreferredSize(new Dimension(600,400));
		panel.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		panel.setBackground(Color.cyan);
		panel.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		
		if(codes != null) {
			for(File f : codes) {
				panel.add(new Codes(f));
			}
		}
		
		
		/*
		JPanel helper = new JPanel();//Bu panel bize ana paneli kutuya koymamıza yardım ediyor
		helper.setLayout(new GridBagLayout());
		helper.add(panel);
		*/
		
		
	//-----------------------------------------
	//----------------Ana Ekran--------------------
		frame = new JFrame();
		this.setJMenuBar(menubar);
		this.setTitle("CLibrary by UrOnEs");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(panel,BorderLayout.CENTER);
		
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
	//-----------------------------------------

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Saveitem) {
			new SaveMenu();
		}
		if(e.getSource() == Exititem) {
			System.exit(1);
		}
		if(e.getSource() == Refreshitem) {
			this.dispose();
			new myLibrary();
		}
	}


	

}
