package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.PainelJogo;

public class objeto_bau extends SuperObjeto{
	
	PainelJogo pj;
	
	public objeto_bau(PainelJogo pj) {
		nome = "bau";
		try {
			
			imagem = ImageIO.read(getClass().getResourceAsStream("/objetos/bau.png"));
			uferra.Escalarimagem(imagem, pj.telhatamanho, pj.telhatamanho);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		colisao = true;
	}

}
