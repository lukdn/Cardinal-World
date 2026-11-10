package entidade;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entidade {
	
	public int mundox,mundoy;
	public int velocidade;
	public BufferedImage cima1, cima2, cima3, baixo1, baixo2, baixo3, esquerda1, esquerda2, esquerda3, direita1, direita2, direita3;
	public String direcao;
	public int spritecontador = 0;
	public int spritenumero = 1;
	public Rectangle areasolida;
	public int areasolidanormalX,areasolidanormalY;
	public boolean Colisao = false;

}
