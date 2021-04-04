package radixConverter;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class RadixConverter extends JFrame {

	private JPanel contentPane;
	private JTextField input;
	private JTextField output;

	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadixConverter frame = new RadixConverter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public RadixConverter() {
		setResizable(false);
		setTitle("Radix Converter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		input = new JTextField();
		input.setHorizontalAlignment(SwingConstants.RIGHT);
		input.setBounds(141, 48, 157, 20);
		contentPane.add(input);
		input.setColumns(10);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"Decimal", "Binary", "Octal", "Hexadecimal"}));
		comboBox1.setBounds(29, 108, 111, 22);
		contentPane.add(comboBox1);
		
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"Decimal", "Binary", "Octal", "Hexadecimal"}));
		comboBox2.setBounds(297, 108, 111, 22);
		contentPane.add(comboBox2);
		
		JButton Swap = new JButton("");
		Swap.setIcon(new ImageIcon(RadixConverter.class.getResource("/radixConverter/swap.png")));
		Swap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int temp=0;
				temp = comboBox1.getSelectedIndex();
				comboBox1.setSelectedIndex(comboBox2.getSelectedIndex());
				comboBox2.setSelectedIndex(temp);
			}
		});
		Swap.setBounds(199, 99, 38, 38);
		contentPane.add(Swap);
		
		JButton Convert = new JButton("Convert");
		Convert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox1.getSelectedItem()=="Decimal") {
					if(comboBox2.getSelectedItem()=="Binary")
						output.setText(String.valueOf(Code.decToBin(Integer.parseInt(input.getText()))));
					else if(comboBox2.getSelectedItem()=="Octal")
						output.setText(String.valueOf(Code.decToOct(Integer.parseInt(input.getText()))));
					else if(comboBox2.getSelectedItem()=="Hexadecimal")
						output.setText(String.valueOf(Code.decToHex(Integer.parseInt(input.getText()))));
					else
						JOptionPane.showMessageDialog(null, "Enter appropiate value"); 						
				}
				if(comboBox1.getSelectedItem()=="Binary") {
					if(comboBox2.getSelectedItem()=="Decimal")
						output.setText(String.valueOf(Code.binToDec(Integer.parseInt(input.getText()))));
					else if(comboBox2.getSelectedItem()=="Octal")
						output.setText(String.valueOf(Code.decToOct((Code.binToDec(Integer.parseInt(input.getText()))))));
					else if(comboBox2.getSelectedItem()=="Hexadecimal")
						output.setText(String.valueOf(Code.decToHex((Code.binToDec(Integer.parseInt(input.getText()))))));
					else
						JOptionPane.showMessageDialog(null, "Enter appropiate value"); 						
				}
				if(comboBox1.getSelectedItem()=="Octal") {
					if(comboBox2.getSelectedItem()=="Decimal")
						output.setText(String.valueOf(Code.octToDec(Integer.parseInt(input.getText()))));
					else if(comboBox2.getSelectedItem()=="Binary")
						output.setText(String.valueOf(Code.decToBin((Code.octToDec(Integer.parseInt(input.getText()))))));
					else if(comboBox2.getSelectedItem()=="Hexadecimal")
						output.setText(String.valueOf(Code.decToHex((Code.octToDec(Integer.parseInt(input.getText()))))));
					else
						JOptionPane.showMessageDialog(null, "Enter appropiate value"); 						
				}
				if(comboBox1.getSelectedItem()=="Hexadecimal") {
					if(comboBox2.getSelectedItem()=="Decimal")
						output.setText(String.valueOf(Code.hexToDec((input.getText()))));
					else if(comboBox2.getSelectedItem()=="Octal")
						output.setText(String.valueOf(Code.decToOct((Code.hexToDec((input.getText()))))));
					else if(comboBox2.getSelectedItem()=="Binary")
						output.setText(String.valueOf(Code.decToBin((Code.hexToDec((input.getText()))))));
					else
						JOptionPane.showMessageDialog(null, "Enter appropiate value"); 						
				}
				
				
			}
		});
		Convert.setBounds(177, 156, 89, 23);
		contentPane.add(Convert);
		
		output = new JTextField();
		output.setHorizontalAlignment(SwingConstants.CENTER);
		output.setEditable(false);
		output.setBounds(141, 202, 157, 20);
		contentPane.add(output);
		output.setColumns(10);
	}
}
