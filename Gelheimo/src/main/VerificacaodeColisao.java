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
	public int verificarobjeto(Entidade entidade, boolean jogador) {
		
		int index = 999;
		
		for(int i = 0;i < pj.obj.length; i++) {
			
			if(pj.obj[i] !=null) {
				
				// ter a posição da entidade solida
				entidade.areasolida.x = entidade.mundox + entidade.areasolida.x;
				entidade.areasolida.y = entidade.mundoy + entidade.areasolida.y;
				//ter a posição do objeto solido
				pj.obj[i].areasolida.x = pj.obj[i].mundoX + pj.obj[i].areasolida.x;
				pj.obj[i].areasolida.y = pj.obj[i].mundoY + pj.obj[i].areasolida.y;
				
				switch(entidade.direcao) {
				case "cima":
					entidade.areasolida.y -= entidade.velocidade;
					if(entidade.areasolida.intersects(pj.obj[i].areasolida)) {
						if(pj.obj[i].colisao == true) {
							entidade.Colisao = true;
						}
						if(jogador == true) {
							index = i;
						}
					}
					break;
				case "baixo":
					entidade.areasolida.y += entidade.velocidade;
					if(entidade.areasolida.intersects(pj.obj[i].areasolida)) {
						if(pj.obj[i].colisao == true) {
							entidade.Colisao = true;
						}
						if(jogador == true) {
							index = i;
						}
					}
					break;
				case "esquerda":
					entidade.areasolida.x -= entidade.velocidade;
					if(entidade.areasolida.intersects(pj.obj[i].areasolida)) {
						if(pj.obj[i].colisao == true) {
							entidade.Colisao = true;
						}
						if(jogador == true) {
							index = i;
						}
					}
					break;
				case "direita":
					entidade.areasolida.x += entidade.velocidade;
					if(entidade.areasolida.intersects(pj.obj[i].areasolida)) {
						if(pj.obj[i].colisao == true) {
							entidade.Colisao = true;
						}
						if(jogador == true) {
							index = i;
						}
					}
					break;
				}
			
			entidade.areasolida.x = entidade.areasolidanormalX;
			entidade.areasolida.y = entidade.areasolidanormalY;
			pj.obj[i].areasolida.x = pj.obj[i].areasolidanormalX;
			pj.obj[i].areasolida.y = pj.obj[i].areasolidanormalY;
			}
			
		}
		
		return index;
		
	}

}
