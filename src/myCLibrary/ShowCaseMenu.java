package myCLibrary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class ShowCaseMenu extends JFrame implements ActionListener{
	File file;
	
	JFrame frame;
	
	JTextArea textArea;
	
	JMenuBar menubar;
	JMenu options;
	JMenu status;
	JMenuItem editOn;
	JMenuItem editOff;
	JMenuItem SaveLeave;
	
	ShowCaseMenu(File f) throws FileNotFoundException{
		  		file = f;
			//------------------Menü Barı--------------------------
				menubar = new JMenuBar();
				
				options = new JMenu("OPTIONS");
				status = new JMenu();
				
				editOn = new JMenuItem("Edit ON");
				editOn.setForeground(Color.green);
				editOn.setOpaque(true);
				editOn.addActionListener(this);
				
				editOff = new JMenuItem("Edit OFF");
				editOff.setForeground(Color.red);
				editOff.setOpaque(true);
				editOff.addActionListener(this);
				
				SaveLeave = new JMenuItem("Save&Leave");
				SaveLeave.addActionListener(this);
				
				options.add(editOff);
				options.add(SaveLeave);
				
				status.setText("Edit OFF");
				status.setForeground(Color.red);
				status.setOpaque(true);
				
				menubar.add(options);
				menubar.add(status);
			//------------------------------------------------------
			//--------------------Yazı Bölümü-----------------------
				textArea = new JTextArea();
				textArea.setPreferredSize(new Dimension(800,700));
				textArea.setEditable(false);
				BufferedReader br = new BufferedReader(new FileReader(f.getAbsolutePath()));
				String line;
	            try {
					while ((line = br.readLine()) != null) {
						textArea.append(line + "\n");
					}
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			//-------------------------------------------------------
			//-----------------------Ana Ekran------------------------
				frame = new JFrame();
				this.setTitle("Show Case Menu");
				this.setSize(600,800);
				this.setLayout(new BorderLayout());
				this.add(textArea,BorderLayout.CENTER);
				this.setJMenuBar(menubar);
				
				
				this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				this.setResizable(false);
				this.setLocationRelativeTo(null);
				
				this.pack();
				this.setVisible(true);
			//-------------------------------------------------------
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == editOff) {
			options.remove(editOff);
			options.add(editOn);
			options.remove(SaveLeave);
			options.add(SaveLeave);
			textArea.setEditable(true);
			status.setText("Edit ON");
			status.setForeground(Color.green);
		}
		if(e.getSource() == editOn) {
			options.remove(editOn);
			options.add(editOff);
			options.remove(SaveLeave);
			options.add(SaveLeave);
			textArea.setEditable(false);
			status.setText("Edit OFF");
			status.setForeground(Color.red);
		}
		if(e.getSource() == SaveLeave) {
			File temp = new File(file.getAbsolutePath());
			try {
				BufferedWriter bfr = new BufferedWriter(new FileWriter(temp));
				bfr.write(textArea.getText());
				bfr.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,"Save Succesfull"," ",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
	}
}
