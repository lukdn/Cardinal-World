package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entidade.Jogador;
import telha.GestorTelhas;

public class PainelJogo extends JPanel implements Runnable{
	
	//Configurações da tela
	final int tamanhoOriginaltelha = 16; //16x16 telha
	final int escala = 3;
	
	public final int telhatamanho = tamanhoOriginaltelha * escala; //48x48
	public final int colunatelamax = 16;
	public final int horizontaltelamax = 12;
	public final int telalargura = telhatamanho * colunatelamax; // 768 pixels
	public final int telaaltura = telhatamanho * horizontaltelamax;//576 pixels
	
	//Configurações do mundo 
	public final int maxmundocoluna = 50;
	public final int maxmundohorizontal = 50;
	public final int mundolargura = telhatamanho * maxmundocoluna;
	public final int mundoaltura = telhatamanho * maxmundohorizontal;
	
	int FPS = 60;
	
	GestorTelhas GT = new GestorTelhas(this);
	Teclas tecla = new Teclas();
	Thread jogoThread;
	public VerificacaodeColisao vecoli = new VerificacaodeColisao(this);
	public Jogador jogador = new Jogador(this,tecla);
	
	
	public PainelJogo () {
		
		this.setPreferredSize(new Dimension(telalargura,telaaltura));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(tecla);
		this.setFocusable(true);
	}
	
	public void comecarJogoThread() {
		
		jogoThread = new Thread(this);
		jogoThread.start();
		
	}

	@Override
	public void run() {
		
		double intervalodesenho = 1000000000/FPS;
		double delta = 0;
		long ultimavez = System.nanoTime();
		long tempoatual;
		long temporizador = 0;
		int contador = 0;
		
		while(jogoThread != null) {
			
			tempoatual = System.nanoTime();
			
			delta += (tempoatual - ultimavez) / intervalodesenho;
			temporizador += (tempoatual - ultimavez);
			
			ultimavez = tempoatual;
			
			if(delta>= 1) {
			update();
			repaint();
			delta--;
			contador++;
			}
			

			
		}
		
		
	}
	
	public void update() {
		
		jogador.update();
		
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2  = (Graphics2D)g;
		
		GT.draw(g2);
		jogador.draw(g2);
		
		g2.dispose();
		
	}
	

}
