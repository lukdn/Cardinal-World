package telha;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.PainelJogo;
import main.utilidadesferramentas;

public class GestorTelhas {
	
	PainelJogo pj;
	public Telha[] telha;
	public int mapatelha[][];
	
	public GestorTelhas(PainelJogo pj) {
		
		this.pj = pj;
		
		telha = new Telha[10];
		mapatelha = new int [pj.maxmundocoluna][pj.maxmundohorizontal];
		
		getTileimage();
		CarregarMapa("/mapas/MapaMundo.txt");

		
	}
	
	public void getTileimage() {
			
			setup(0, "relva", false);
			setup(1, "tijolo", true);
			setup(2, "agua", true);
			setup(3, "terra2", false);
			setup(4, "Arvore", true);
			setup(5, "areia", false);
	}
	
	
	public void setup(int index, String caminhodaImagem, boolean colisao) {
		
		utilidadesferramentas uferra = new utilidadesferramentas();
		
		try{
			telha[index] = new Telha();
			telha[index].imagem = ImageIO.read(getClass().getResourceAsStream("/telhas/" + caminhodaImagem +".png"));
			telha[index].imagem = uferra.Escalarimagem(telha[index].imagem, pj.telhatamanho, pj.telhatamanho);
			telha[index].colisao = colisao;
			
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
			
			while(col  < pj.maxmundocoluna && ver < pj.maxmundohorizontal) {
				
				String line = br.readLine();
				
				while(col < pj.maxmundocoluna) {
					
					String numeros[] = line.split(" ");
					
					int num = Integer.parseInt(numeros[col]);
					
					mapatelha[col][ver] = num;
					col++;
					
				}
				if(col == pj.maxmundocoluna) {
					col = 0;
					ver++;
				}
				
			}
			br.close();
			
		}catch(Exception e) {
			
		}
		
	}
	
	public void draw(Graphics2D g2) {
		
		int mundocoluna = 0;
		int mundohorizontal = 0;
		
		while (mundocoluna < pj.maxmundocoluna && mundohorizontal < pj.maxmundohorizontal) {
			
			int telhanumero = mapatelha[mundocoluna][mundohorizontal];
			
			int mundoX = mundocoluna * pj.telhatamanho;
			int mundoy = mundohorizontal * pj.telhatamanho;
			int telax = mundoX - pj.jogador.mundox + pj.jogador.telax;
			int telay = mundoy - pj.jogador.mundoy + pj.jogador.telay;
			
			
			if(mundoX + pj.telhatamanho > pj.jogador.mundox - pj.jogador.telax &&
			   mundoX - pj.telhatamanho < pj.jogador.mundox + pj.jogador.telax &&
			   mundoy + pj.telhatamanho > pj.jogador.mundoy - pj.jogador.telay &&
			   mundoy - pj.telhatamanho < pj.jogador.mundoy + pj.jogador.telay) {
				
				g2.drawImage(telha[telhanumero].imagem, telax, telay, null);
				
			}
			mundocoluna++;
			
			if(mundocoluna == pj.maxmundocoluna) {
				mundocoluna = 0;
				mundohorizontal++;
			}
		}
		
	}

}
