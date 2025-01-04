
package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class TelaJogo extends JPanel implements Runnable {
    
    final int tamanhoBlocoOriginal = 16;
    final int escalaBloco = 3;
    
    final int tamanhoBloco = tamanhoBlocoOriginal * escalaBloco;
    final int maxColTela = 16;
    final int maxLinTela = 12;
    final int larguraTela = tamanhoBloco * maxColTela;
    final int alturaTela = tamanhoBloco * maxLinTela;
    int FPS = 60;
    
    GerenciadorTeclado gerTeclado = new GerenciadorTeclado();
    Thread threadJogo;
    
    // Posicao padrao do jogador
    int jogadorX = 100;
    int jogadorY = 100;
    int velocidadeJogador = 4;
    
    
    public TelaJogo() {
        
        this.setPreferredSize(new Dimension(larguraTela, alturaTela));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(gerTeclado);
        this.setFocusable(true); // Garante que a tela do jogo receba os inputs do teclado
    }
    
    public void iniciaThreadJogo() {
        
        threadJogo = new Thread(this);
        threadJogo.start(); // chama o método 'run'
    }

    @Override
    public void run() {
        
        double intervaloDesenho = 1000000000/FPS; 
        double proxTempoTela = System.nanoTime() + intervaloDesenho;
        
        while (threadJogo != null) {
            
            // 1. Atualiza a tela com as informações de posição dos personagens
            atualiza();
            
            // 2. Mostra a tela com as informações atualizadas  
            repaint();
                       
            try {
                double tempoRestante = proxTempoTela - System.nanoTime();
                tempoRestante /= 1000000;
                
                if (tempoRestante < 0) {
                    tempoRestante = 0;
                }
                
                Thread.sleep((long)tempoRestante);
                
                proxTempoTela += intervaloDesenho;
            
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
    public void atualiza() {
        
        if (gerTeclado.cimaPressionado == true) {
            jogadorY -= velocidadeJogador;
        }
        if (gerTeclado.baixoPressionado == true) {
            jogadorY += velocidadeJogador;
        }
        if (gerTeclado.direitaPressionado == true) {
            jogadorX += velocidadeJogador;
        }
        if (gerTeclado.esquerdaPressionado == true) {
            jogadorX -= velocidadeJogador;
        }
                
    }
    
    public void paintComponent(Graphics g) { // Graphics: classe que contém funções para desenhar elementos na tela.
        
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.white);
        
        g2.fillRect(jogadorX, jogadorY, tamanhoBloco, tamanhoBloco);
        
        g2.dispose();
    }
}
