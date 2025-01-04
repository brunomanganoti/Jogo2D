
package Main;

import javax.swing.JFrame;

public class main {
    
    public static void main (String args[]) {
        
        JFrame janela = new JFrame();
        TelaJogo telaJogo = new TelaJogo();
        
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.setTitle("Jogo 2D");
        
        janela.add(telaJogo);
        janela.pack();
        
        // configuração de posição e tamanho
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        
        telaJogo.iniciaThreadJogo();
        
    }
}
