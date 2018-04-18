package edu.ap.spring.view;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.*;
import java.awt.*;

@Component
public class UI implements InitializingBean {

	@Autowired
	EventHandler eventHandler;

	private JFrame jFrame;
	private JLabel vraaglbl, antwoord;
	private JTextField vraag;
	private JPanel controlPanel;
	private JButton btnAddVraag;

	public UI(){}

	public void setupUI(){
		jFrame = new JFrame("magic 8-ball");
		jFrame.setLayout(new FlowLayout());

		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3, 2));

		vraaglbl = new JLabel("Stel je vraag: ");
		vraag = new JTextField(15);
		vraag.setDragEnabled(true);

		btnAddVraag = new JButton();
		btnAddVraag.setText("Add user");
		btnAddVraag.setTransferHandler(new TransferHandler("text"));
		btnAddVraag.addActionListener(eventHandler::whenButtonClicked);

		controlPanel.add(vraaglbl);
		controlPanel.add(vraag);
		controlPanel.add(antwoord);
		controlPanel.add(btnAddVraag);

		jFrame.add(controlPanel);

		jFrame.setSize(400, 400);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
	}

	public JFrame getjFrame() {
		return this.jFrame;
	}

	public JTextField getQuestion() {
		return this.vraag;
	}

	public JLabel getAnswer() {
		return this.antwoord;
	}

	public JButton getButton() {
		return btnAddVraag;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}
}
