package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Cardinal World");
		
		PainelJogo painelJogo = new PainelJogo();
		window.add(painelJogo);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		painelJogo.comecarJogoThread();

	}

}
