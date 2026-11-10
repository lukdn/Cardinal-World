package main;

import Objeto.Objeto_chave;
import Objeto.objeto_portas;

public class Colocador_de_objetos {
	
	PainelJogo pj;
	
	public Colocador_de_objetos(PainelJogo pj) {
		this.pj = pj;
	}
	
	public void defineObjeto() {
		
		pj.obj[0] = new Objeto_chave(pj);
		pj.obj[0].mundoX = 23 * pj.telhatamanho;
		pj.obj[0].mundoY = 7 * pj.telhatamanho;		
		
		pj.obj[1] = new objeto_portas(pj);
		pj.obj[1].mundoX = 37 *	pj.telhatamanho;
		pj.obj[1].mundoY = 7 * pj.telhatamanho;
		
	}

}
