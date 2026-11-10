package entidade;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.PainelJogo;
import main.Teclas;
import main.utilidadesferramentas;

public class Jogador extends Entidade{
	
	PainelJogo pj;
	Teclas tecla;
	public final int telax;
	public final int telay;
	int temchave = 0;
	
	public Jogador(PainelJogo pj, Teclas tecla) {
		
		this.pj = pj;
		this.tecla = tecla;
		
		telax = pj.telalargura/2 -(pj.telhatamanho/2);
		telay = pj.telaaltura/2 -(pj.telhatamanho/2);
		
		areasolida = new Rectangle();
		areasolida.x = 12;
		areasolida.y = 24;
		areasolidanormalX = areasolida.x;
		areasolidanormalY = areasolida.y;
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
		
		cima1 = setup("humano_cima_1");
		cima2 = setup("humano_cima_2");
		cima3 = setup("humano_cima_3");
		baixo1 = setup("humano_baixo_1");
		baixo2 = setup("humano_baixo_2");
		baixo3 = setup("humano_baixo_3");
		esquerda1 = setup("humano_esquerda_1");
		esquerda2 = setup("humano_esquerda_2");
		esquerda3 = setup("humano_esquerda_3");
		direita1 = setup("humano_direita_1");
		direita2 = setup("humano_direita_2");
		direita3 = setup("humano_direita_3");
		
	}
	
	public BufferedImage setup(String nomeImagem) {
		
		utilidadesferramentas uferra = new utilidadesferramentas();
		BufferedImage imagem = null;
		
		try {
			
			imagem = ImageIO.read(getClass().getResourceAsStream("/jogador/" + nomeImagem + ".png"));
			imagem = uferra.Escalarimagem(imagem, pj.telhatamanho, pj.telhatamanho);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return imagem;
		
		
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
			
			// verificar telha colisao
			Colisao = false;
			pj.vecoli.verificartelha(this);
			
			// verificar colisao do objeto
			int objIndex = pj.vecoli.verificarobjeto(this, true);
			pegarObjeto(objIndex);
			
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
			if(spritecontador > 9) {  //mudar velocidade sprite
				if(spritenumero == 1) {
					spritenumero = 3;
				}
				else if(spritenumero == 3) {
					spritenumero = 2;
				}
				else if (spritenumero == 2) {
					spritenumero = 1;
				}
				spritecontador = 0;
			}
			
		}
		
		else {
			spritenumero = 1;
		}
		

		
	}
	
	public void pegarObjeto(int i) {
		
		if(i != 999) {
			String nomeObjeto = pj.obj[i].nome;
			
			switch(nomeObjeto) {
			case "chave":
				temchave++;
				pj.obj[i] = null;
				System.out.println("Chave:"+temchave);
				break;
			case "porta":
				if(temchave > 0) {
					pj.obj[i] = null;
					temchave--;
				}
				System.out.println("Chave:"+temchave);
				break;
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
			if(spritenumero == 3) {
				imagem = cima3;
			}
			break;
		case "baixo":
			if(spritenumero == 1) {
				imagem = baixo1;
			}
			if(spritenumero == 2) {
				imagem = baixo2;
			}
			if(spritenumero == 3) {
				imagem = baixo3;
			}
			break;
		case "esquerda":
			if(spritenumero == 1) {
				imagem = esquerda1;
			}
			if(spritenumero == 2) {
				imagem = esquerda2;
			}
			if(spritenumero == 3) {
				imagem = esquerda3;
			}
			break;
		case "direita":
			if(spritenumero == 1) {
				imagem = direita1;
			}
			if(spritenumero == 2) {
				imagem = direita2;
			}
			if(spritenumero == 3) {
				imagem = direita3;
			}
			break;
		}
		g2.drawImage(imagem, telax, telay, null);
		
	}

}
