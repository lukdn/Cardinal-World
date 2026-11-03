package entidade;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.PainelJogo;
import main.Teclas;

public class Jogador extends Entidade{
	
	PainelJogo pj;
	Teclas tecla;
	
	public final int telax;
	public final int telay;
	
	public Jogador(PainelJogo pj, Teclas tecla) {
		
		this.pj = pj;
		this.tecla = tecla;
		
		telax = pj.telalargura/2 -(pj.telhatamanho/2);
		telay = pj.telaaltura/2 -(pj.telhatamanho/2);
		
		areasolida = new Rectangle();
		areasolida.x = 12;
		areasolida.y = 24; 
		areasolida.width = 22;
		areasolida.height = 22;
		
		setDefaultValues();
		getPlayerImage(); 
		
	}
	
	public void setDefaultValues() {
		
		mundox = pj.telhatamanho * 23;
		mundoy = pj.telhatamanho * 21;
		velocidade = 4;
		direcao = "baixo";
		
	}
	
	public void getPlayerImage() {
		
		try {
			
			cima1 = ImageIO.read(getClass().getResourceAsStream("/jogador/Para_cima_1.png"));
			cima2 = ImageIO.read(getClass().getResourceAsStream("/jogador/Para_cima_2.png"));
			
			baixo1 = ImageIO.read(getClass().getResourceAsStream("/jogador/Para_Baixo_1.png"));
			baixo2 = ImageIO.read(getClass().getResourceAsStream("/jogador/Para_Baixo_2.png"));
			
			esquerda1 = ImageIO.read(getClass().getResourceAsStream("/jogador/Para_esquerda_1.png"));
			esquerda2 = ImageIO.read(getClass().getResourceAsStream("/jogador/Para_esquerda_2.png"));
			
			direita1 = ImageIO.read(getClass().getResourceAsStream("/jogador/Para_direita_1.png"));
			direita2 = ImageIO.read(getClass().getResourceAsStream("/jogador/Para_direita_2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void update() {
		
		if(tecla.cimaapertado == true || tecla.baixoapertado == true || 
				tecla.esquerdaapertado == true || tecla.direitaapertado == true) {
			
			if(tecla.cimaapertado == true) {
				direcao = "cima";
			}
			else if(tecla.baixoapertado == true) {
				direcao = "baixo";
			}
			else if(tecla.esquerdaapertado == true) {
				direcao = "esquerda";
			}
			else if(tecla.direitaapertado == true) {
				direcao = "direita";
			}
			
			Colisao = false;
			pj.vecoli.verificartelha(this);
			
			if(Colisao == false) {
				switch(direcao) {
				case "cima":
					mundoy -= velocidade;
					break;
				case "baixo":
					mundoy += velocidade;
					break;
				case "esquerda":
					mundox -= velocidade;
					break;
				case "direita":
					mundox += velocidade; 
					break;
				}
			}
			
			spritecontador++;
			if(spritecontador > 10) {
				if(spritenumero == 1) {
					spritenumero = 2;
				}
				else if (spritenumero == 2) {
					spritenumero = 1;
				}
				spritecontador = 0;
			}
			
		}
		

		
	}
	public void draw(Graphics2D g2) {
		
		//g2.setColor(Color.white);		
		//g2.fillRect(x, y, pj.telhatamanho, pj.telhatamanho);
		BufferedImage imagem = null;
		
		switch(direcao) {
		case "cima":
			if(spritenumero == 1) {
				imagem = cima1;
			}
			if(spritenumero == 2) {
				imagem = cima2;
			}
			break;
		case "baixo":
			if(spritenumero == 1) {
				imagem = baixo1;
			}
			if(spritenumero == 2) {
				imagem = baixo2;
			}
			break;
		case "esquerda":
			if(spritenumero == 1) {
				imagem = esquerda1;
			}
			if(spritenumero == 2) {
				imagem = esquerda2;
			}
			break;
		case "direita":
			if(spritenumero == 1) {
				imagem = direita1;
			}
			if(spritenumero == 2) {
				imagem = direita2;
			}
			break;
		}
		g2.drawImage(imagem, telax, telay, pj.telhatamanho, pj.telhatamanho, null);
		
	}

}
