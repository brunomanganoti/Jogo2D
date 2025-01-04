
package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GerenciadorTeclado implements KeyListener {
    
    public boolean cimaPressionado, baixoPressionado, esquerdaPressionado, direitaPressionado;
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        
        int codigoTecla = e.getKeyCode();
        
        if(codigoTecla == KeyEvent.VK_W) {cimaPressionado = true;}
        if(codigoTecla == KeyEvent.VK_A) {esquerdaPressionado = true;}
        if(codigoTecla == KeyEvent.VK_S) {baixoPressionado = true;}
        if(codigoTecla == KeyEvent.VK_D) {direitaPressionado = true;}  
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int codigoTecla = e.getKeyCode();
        
        if(codigoTecla == KeyEvent.VK_W) {cimaPressionado = false;}
        if(codigoTecla == KeyEvent.VK_A) {esquerdaPressionado = false;}
        if(codigoTecla == KeyEvent.VK_S) {baixoPressionado = false;}
        if(codigoTecla == KeyEvent.VK_D) {direitaPressionado = false;}
    }
}
