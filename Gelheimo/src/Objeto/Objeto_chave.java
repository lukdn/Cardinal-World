package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.PainelJogo;

public class Objeto_chave extends SuperObjeto{
	
	PainelJogo pj;
	
	public Objeto_chave(PainelJogo pj) {
		
		nome = "chave";
		try {
			
			imagem = ImageIO.read(getClass().getResourceAsStream("/objetos/chave-1.png.png"));
			uferra.Escalarimagem(imagem, pj.telhatamanho, pj.telhatamanho);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
