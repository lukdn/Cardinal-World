package Objeto;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.PainelJogo;

public class objeto_portas extends SuperObjeto {
	
	PainelJogo pj;
	
	public objeto_portas(PainelJogo pj) {
		
		nome = "porta";
		try {
			
			imagem = ImageIO.read(getClass().getResourceAsStream("/objetos/porta.png"));
			uferra.Escalarimagem(imagem, pj.telhatamanho, pj.telhatamanho);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		colisao = true;
	}

}
