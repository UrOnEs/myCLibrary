package myCLibrary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyCode extends JFrame implements ActionListener{
	
	JFrame frame;
	JTextArea textArea;
	JButton SaveButton;
	
	MyCode(){
		SaveButton = new JButton("Save");
		SaveButton.setPreferredSize(new Dimension(100,50));
		SaveButton.setFont(new Font("MV Boli",Font.ITALIC,25));
		
		textArea = new JTextArea();
		textArea.setPreferredSize(new Dimension(800,700));
		
		
		frame = new JFrame();
		this.setSize(600,800);
		this.setLayout(new BorderLayout());
		this.add(textArea,BorderLayout.CENTER);
		this.add(SaveButton,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.pack();
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
