package Objeto;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.PainelJogo;
import main.utilidadesferramentas;

public class SuperObjeto {

	public BufferedImage imagem;
	public String nome;
	public boolean colisao = false;
	public int mundoX,mundoY;
	public Rectangle areasolida = new Rectangle(0, 0, 48, 48);
	public int areasolidanormalX = 0;
	public int areasolidanormalY = 0;
	utilidadesferramentas uferra = new  utilidadesferramentas();
	
	public void draw(Graphics2D g2, PainelJogo pj) {
		
		int telax = mundoX - pj.jogador.mundox + pj.jogador.telax;
		int telay = mundoY - pj.jogador.mundoy + pj.jogador.telay;
		
		
		if(mundoX + pj.telhatamanho > pj.jogador.mundox - pj.jogador.telax &&
		   mundoX - pj.telhatamanho < pj.jogador.mundox + pj.jogador.telax &&
		   mundoY + pj.telhatamanho > pj.jogador.mundoy - pj.jogador.telay &&
		   mundoY - pj.telhatamanho < pj.jogador.mundoy + pj.jogador.telay) {
			
			g2.drawImage(imagem, telax, telay, pj.telhatamanho, pj.telhatamanho, null);
			
		}
		
	}
	
}
