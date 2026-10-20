package telha;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.PainelJogo;

public class GestorTelhas {
	
	PainelJogo pj;
	Telha[] telha;
	int mapatelha[][];
	
	public GestorTelhas(PainelJogo pj) {
		
		this.pj = pj;
		
		telha = new Telha[10];
		mapatelha = new int [pj.colunatelamax][pj.horizontaltelamax];
		
		getTileimage();
		CarregarMapa("/mapas/mapa1.txt");

		
	}
	
	public void getTileimage() {
		
		try {
			
			telha[0] = new Telha();
			telha[0].imagem = ImageIO.read(getClass().getResourceAsStream("/telhas/relva.png"));
			
			telha[1] = new Telha();
			telha[1].imagem = ImageIO.read(getClass().getResourceAsStream("/telhas/tijolo.png"));
			
			telha[2] = new Telha();
			telha[2].imagem = ImageIO.read(getClass().getResourceAsStream("/telhas/agua.png"));
			
			telha[3] = new Telha();
			telha[3].imagem = ImageIO.read(getClass().getResourceAsStream("/telhas/terra2.png"));
			
			telha[4] = new Telha();
			telha[4].imagem = ImageIO.read(getClass().getResourceAsStream("/telhas/Arvore.png"));
			
			telha[5] = new Telha();
			telha[5].imagem = ImageIO.read(getClass().getResourceAsStream("/telhas/areia.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void CarregarMapa(String ficheiro){
		
		try {
			InputStream is = getClass().getResourceAsStream(ficheiro);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int ver = 0;
			
			while(col  < pj.colunatelamax && ver < pj.horizontaltelamax) {
				
				String line = br.readLine();
				
				while(col < pj.colunatelamax) {
					
					String numeros[] = line.split(" ");
					
					int num = Integer.parseInt(numeros[col]);
					
					mapatelha[col][ver] = num;
					col++;
					
				}
				if(col == pj.colunatelamax) {
					col = 0;
					ver++;
				}
				
			}
			br.close();
			
		}catch(Exception e) {
			
		}
		
	}
	
	public void draw(Graphics2D g2) {
		
		int col = 0;
		int ver = 0;
		int x = 0;
		int y = 0;
		
		while (col < pj.colunatelamax && ver < pj.horizontaltelamax) {
			
			int telhanumero = mapatelha[col][ver];
			
			g2.drawImage(telha[telhanumero].imagem, x, y, pj.telhatamanho, pj.telhatamanho, null);
			col++;
			x += pj.telhatamanho;
			
			if(col == pj.colunatelamax) {
				col = 0;
				x = 0;
				ver++;
				y += pj.telhatamanho;
			}
		}
		
	}

}
