package com.esintibilisim;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtReferans;
	private JTextArea txtSonuc;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain frame = new frmMain();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmMain() {
		setTitle("TcKimlikNo Doğrulama Algoritması");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReferans = new JLabel("Referans :");
		lblReferans.setBounds(10, 10, 84, 23);
		contentPane.add(lblReferans);
		
		txtReferans = new JTextField();
		txtReferans.setText("123456789");
		txtReferans.setBounds(91, 12, 114, 19);
		contentPane.add(txtReferans);
		txtReferans.setColumns(10);
		
		JButton btnDogrula = new JButton("Doğrula");
		btnDogrula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tckimlik = txtReferans.getText();
				txtSonuc.setText( String.format("%s => %s",
						tckimlik,
						TcKimlikNo.Dogrula(tckimlik)));
			}
		});
		btnDogrula.setBounds(211, 9, 96, 25);
		contentPane.add(btnDogrula);
		
		JButton btnYukari = new JButton("+");
		btnYukari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tckimlik = txtReferans.getText();
				txtSonuc.setText( String.format("Referans:%s\tYön:%s\n", tckimlik, "Yukarı"));				
				for (int i = 0; i < 10; i++) {
					tckimlik = TcKimlikNo.AkrabaBul(tckimlik, "+");
					txtSonuc.setText( String.format("%s%d.\t%s\t=> %s\n",
							txtSonuc.getText(),
							(i+1),
							tckimlik,
							TcKimlikNo.Dogrula(tckimlik)));
				}
			}
		});
		btnYukari.setBounds(314, 9, 44, 25);
		contentPane.add(btnYukari);
		
		JButton btnAsagi = new JButton("-");
		btnAsagi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tckimlik = txtReferans.getText();
				txtSonuc.setText( String.format("Referans:%s\tYön:%s\n", tckimlik, "Aşağı"));				
				for (int i = 0; i < 10; i++) {
					tckimlik = TcKimlikNo.AkrabaBul(tckimlik, "-");
					txtSonuc.setText( String.format("%s%d.\t%s\t=> %s\n",
							txtSonuc.getText(),
							(i+1),
							tckimlik,
							TcKimlikNo.Dogrula(tckimlik)));
				}
			}
		});
		btnAsagi.setBounds(365, 9, 44, 25);
		contentPane.add(btnAsagi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 45, 416, 216);
		contentPane.add(scrollPane);
		
		txtSonuc = new JTextArea();
		scrollPane.setViewportView(txtSonuc);
	}
}
