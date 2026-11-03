package 
main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclas implements KeyListener{
	
	public boolean cimaapertado, baixoapertado, esquerdaapertado, direitaapertado;

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			cimaapertado = true;
		}
		if(code == KeyEvent.VK_S) {
			baixoapertado = true;
		}
		if(code == KeyEvent.VK_A) {
			esquerdaapertado = true;
		}
		if(code == KeyEvent.VK_D) {
			direitaapertado = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			cimaapertado = false;
		}
		if(code == KeyEvent.VK_S) {
			baixoapertado = false;
		}
		if(code == KeyEvent.VK_A) {
			esquerdaapertado = false;
		}
		if(code == KeyEvent.VK_D) {
			direitaapertado = false;
		}
		
	}
	
	

}
