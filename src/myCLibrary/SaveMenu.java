package myCLibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class SaveMenu extends JFrame implements ActionListener{
	
	JFrame frame;
	JTextArea textArea;
	JMenuBar menubar;
	JMenu options;
	JMenuItem save;
	JMenuItem cancel;

	SaveMenu(){
	//------------------Menü Barı--------------------------
		menubar = new JMenuBar();
		
		options = new JMenu("OPTIONS");
		
		save = new JMenuItem("Save");
		save.addActionListener(this);
		
		cancel = new JMenuItem("Cancel");
		cancel.addActionListener(this);
		
		options.add(save);
		options.add(cancel);
		
		menubar.add(options);
	//------------------------------------------------------
	//--------------------Yazı Bölümü-----------------------
		textArea = new JTextArea(24,57);
		textArea.setBackground(Color.black);
		textArea.setForeground(Color.orange);
		textArea.setOpaque(true);
		textArea.setFont(new Font("MV Boli",Font.PLAIN,25));
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
	//-------------------------------------------------------
	//-----------------------Ana Ekran------------------------
		frame = new JFrame();
		this.setTitle("Save Menu");
		this.setSize(600,800);
		this.setLayout(new BorderLayout());
		this.add(scrollPane,BorderLayout.CENTER);
		this.setJMenuBar(menubar);
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.pack();
		this.setVisible(true);
	//-------------------------------------------------------

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancel) {
			this.dispose();
		}
		if(e.getSource() == save) {
			String response = JOptionPane.showInputDialog(null,"What is the name of Project?","Name Please!",JOptionPane.OK_CANCEL_OPTION);
			if(!response.equalsIgnoreCase(null)) {
				File temp = new File("CodesArchive//" + response + ".txt");
			try {
				if(temp.createNewFile()) {
					BufferedWriter bfr = new BufferedWriter(new FileWriter(temp));
					bfr.write(textArea.getText());
					bfr.close();
				}else {
					JOptionPane.showMessageDialog(null,"This name is already exist!","Error!",JOptionPane.WARNING_MESSAGE);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,"Save Succesfull"," ",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			}else {
				this.dispose();
			}
			
		}
		
	}
}
