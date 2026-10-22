package main;

import entidade.Entidade;

public class VerificacaodeColisao {
	
	
	PainelJogo pj;
	
	public VerificacaodeColisao(PainelJogo pj) {
		this.pj = pj;
	}
	
	public void verificartelha (Entidade entidade) {
		
		int entidadeesquerdaMundoX = entidade.mundox + entidade.areasolida.x;
		int entidadedireitaMundoX = entidade.mundox + entidade.areasolida.x + entidade.areasolida.width;
		int entidadecimaMundoY = entidade.mundoy + entidade.areasolida.y;
		int entidadebaixoMundoY = entidade.mundoy + entidade.areasolida.y + entidade.areasolida.height;
		
		int entidadeesquerdacol = entidadeesquerdaMundoX/pj.telhatamanho;
		int entidadedireitacol = entidadedireitaMundoX/pj.telhatamanho;
		int entidadecimahori = entidadecimaMundoY/pj.telhatamanho;
		int entidadebaixohori = entidadebaixoMundoY/pj.telhatamanho;
		
		int tilenum1, tilenum2;
		
		switch(entidade.direcao) {
		case "cima":
			entidadecimahori = (entidadecimaMundoY  - entidade.velocidade)/pj.telhatamanho;
			tilenum1 = pj.GT.mapatelha[entidadeesquerdacol][entidadecimahori];
			tilenum2 = pj.GT.mapatelha[entidadedireitacol][entidadecimahori];
			if(pj.GT.telha[tilenum1].colisao == true || pj.GT.telha[tilenum2].colisao == true) {
				entidade.Colisao = true;
			}
			break;
		case "baixo":
			entidadebaixohori = (entidadebaixoMundoY  + entidade.velocidade)/pj.telhatamanho;
			tilenum1 = pj.GT.mapatelha[entidadeesquerdacol][entidadebaixohori];
			tilenum2 = pj.GT.mapatelha[entidadedireitacol][entidadebaixohori];
			if(pj.GT.telha[tilenum1].colisao == true || pj.GT.telha[tilenum2].colisao == true) {
				entidade.Colisao = true;
			}
			break;
		case "esquerda":
			entidadeesquerdacol = (entidadeesquerdaMundoX  - entidade.velocidade)/pj.telhatamanho;
			tilenum1 = pj.GT.mapatelha[entidadeesquerdacol][entidadecimahori];
			tilenum2 = pj.GT.mapatelha[entidadeesquerdacol][entidadebaixohori];
			if(pj.GT.telha[tilenum1].colisao == true || pj.GT.telha[tilenum2].colisao == true) {
				entidade.Colisao = true;
			}
			break;
		case "direita":
			entidadedireitacol = (entidadedireitaMundoX  + entidade.velocidade)/pj.telhatamanho;
			tilenum1 = pj.GT.mapatelha[entidadedireitacol][entidadecimahori];
			tilenum2 = pj.GT.mapatelha[entidadedireitacol][entidadebaixohori];
			if(pj.GT.telha[tilenum1].colisao == true || pj.GT.telha[tilenum2].colisao == true) {
				entidade.Colisao = true;
			}
			break;
		}
		
		
	}

}
