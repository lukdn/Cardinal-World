package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class utilidadesferramentas {
	
	public BufferedImage Escalarimagem(BufferedImage original, int horizontal, int coluna) {
		
		BufferedImage imagemEscalada = new BufferedImage (horizontal, coluna, original.getType());
		Graphics2D g2 = imagemEscalada.createGraphics();
		g2.drawImage(original, 0, 0, horizontal, coluna, null);
		g2.dispose();
		
		return imagemEscalada;
		
	}

}
