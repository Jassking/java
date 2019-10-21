package com.ty.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterFrm frame = new MainInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainInterFrm() {
		getContentPane().setBackground(new Color(255, 69, 0));
		setIconifiable(true);
		setClosable(true);
		setResizable(true);
		setTitle("\u5173\u4E8E\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setBounds(100, 100, 450, 300);
		
		JLabel lbljava = new JLabel("\u5B66\u4E60java");
		lbljava.setBackground(Color.WHITE);
		lbljava.setIcon(new ImageIcon(MainInterFrm.class.getResource("/images/study_54.692307692308px_1158236_easyicon.net.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(157)
					.addComponent(lbljava)
					.addContainerGap(171, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(95)
					.addComponent(lbljava)
					.addContainerGap(128, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
