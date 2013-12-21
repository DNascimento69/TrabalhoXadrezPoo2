/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import Until.ImageLoader;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JPanel;





public class Tabuleiro extends JPanel
{
    int casasStartX, casasStartY, arestaCasa;
    Image imagemTabuleiro, pica;
    ArrayList<Peca> pecasBrancas;
    ArrayList<Peca> pecasPretas;
    Casa matrizTabuleiro[][], casaSelecionada;
    Validacao validador;
    PainelPecasRemovidas brancasRemovidas, pretasRemovidas;
    
    public Tabuleiro()//Validacao validador)
    {
        super();
        setLayout(null);
        
        arestaCasa = 69;
        casasStartX = 267;
        casasStartY = 75;
        
        pecasBrancas = new ArrayList<>();
        pecasPretas = new ArrayList<>();
        
        brancasRemovidas = new PainelPecasRemovidas(36, 53);
        pretasRemovidas = new PainelPecasRemovidas(36, 438);
        add(brancasRemovidas);
        add(pretasRemovidas);
        
//        this.validador = validador;
        
        casaSelecionada = null;
        matrizTabuleiro = new Casa[8][8];
        imagemTabuleiro = ImageLoader.LoadImage("Xadrez.png");
        //pica = ImageLoader.LoadImage("pice.png");
        inicializarPecas();
        inicializarCasas();
        adicionarPecas();
        inicializarListeners();
        repaint();
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(imagemTabuleiro, 0, 0,  null); 
    }
    
    
    private void inicializarListeners()
    {
        int x = 0, y = 0;
        
        while(x < 8)
        {
            while(y < 8)
            {
                addMouseMotionListener(matrizTabuleiro[x][y]);
                addMouseListener(matrizTabuleiro[x][y]);
                y++;
            }
            y = 0;
            x++;
        }
    }
    
    
    private void adicionarPecas()
    {
        int x = 0, y = 0, count = 0, count2 = 0;
        
        //matrizTabuleiro[0][0].setPeca(pecasBrancas.get(0));
        
        while(count < 8)
        {
            matrizTabuleiro[1][count].setPeca(pecasBrancas.get(0));
            matrizTabuleiro[6][count].setPeca(pecasPretas.get(0));
            count++;
        }
        
        matrizTabuleiro[0][0].setPeca(pecasBrancas.get(9));
        matrizTabuleiro[0][1].setPeca(pecasBrancas.get(11));
        matrizTabuleiro[0][2].setPeca(pecasBrancas.get(13));
        matrizTabuleiro[0][3].setPeca(pecasBrancas.get(14));
        matrizTabuleiro[0][4].setPeca(pecasBrancas.get(15));
        matrizTabuleiro[0][5].setPeca(pecasBrancas.get(13));
        matrizTabuleiro[0][6].setPeca(pecasBrancas.get(11));
        matrizTabuleiro[0][7].setPeca(pecasBrancas.get(9));
        
        matrizTabuleiro[7][0].setPeca(pecasPretas.get(9));
        matrizTabuleiro[7][1].setPeca(pecasPretas.get(11));
        matrizTabuleiro[7][2].setPeca(pecasPretas.get(13));
        matrizTabuleiro[7][3].setPeca(pecasPretas.get(15));
        matrizTabuleiro[7][4].setPeca(pecasPretas.get(14));
        matrizTabuleiro[7][5].setPeca(pecasPretas.get(13));
        matrizTabuleiro[7][6].setPeca(pecasPretas.get(11));
        matrizTabuleiro[7][7].setPeca(pecasPretas.get(9));
    }
    
    
    private void inicializarPecas()
    {
        int count = 0;
        
        while(count < 8)
        {
            pecasBrancas.add(new Peca(1, true));
            pecasPretas.add(new Peca(7, false));
            count++;
        }
        
        pecasBrancas.add(new Peca(2, true)); // 8
        pecasBrancas.add(new Peca(2, true)); // 9
        pecasBrancas.add(new Peca(3, true)); // 10
        pecasBrancas.add(new Peca(3, true)); // 11
        pecasBrancas.add(new Peca(4, true)); // 12
        pecasBrancas.add(new Peca(4, true)); // 13
        pecasBrancas.add(new Peca(5, true)); // 14
        pecasBrancas.add(new Peca(6, true)); // 15
        
        pecasPretas.add(new Peca(8, false));
        pecasPretas.add(new Peca(8, false));
        pecasPretas.add(new Peca(9, false));
        pecasPretas.add(new Peca(9, false));
        pecasPretas.add(new Peca(10, false));
        pecasPretas.add(new Peca(10, false));
        pecasPretas.add(new Peca(11, false));
        pecasPretas.add(new Peca(12, false));
    }
    
    
    private void inicializarCasas()
    {
        int x = 0, y = 0;
        
        while(x < 8)
        {
            while(y < 8)
            {
                matrizTabuleiro[x][y] = new Casa(casasStartX + (y * arestaCasa), casasStartY + (x * arestaCasa), x, y, this);
                add(matrizTabuleiro[x][y]);
                y++;
            }
            y = 0;
            x++;
        }       
    }
    //Mandar a casa
    public boolean moverPeca(Casa casa1, Casa casa2)
    {
        Peca tmp;
        
        if(!validador.validaMovimento(casa1, casa2)) return false;
        
        tmp = matrizTabuleiro[casa2.xTabuleiro][casa2.yTabuleiro].setPeca(matrizTabuleiro[casa1.xTabuleiro][casa1.yTabuleiro].removerPeca());
        
        if(tmp != null)
        {
            if(tmp.cor == true)
                brancasRemovidas.adicionarPeca(tmp);
            else
                pretasRemovidas.adicionarPeca(tmp);
        }
        
        return true;
    }
    
    
    public boolean adiconarPeca(Peca peca, int x, int y)
    {
        if(x < 0 || x > 7 || y < 0 || y > 7) return false;
        
        return true;
    }
    
    
    public Peca removerPeca(int x, int y)
    {
        if(x < 0 || x > 7 || y < 0 || y > 7) return null;
        
        return matrizTabuleiro[x][y].removerPeca();
    }
    
    
    public void destruirPeca()
    {
        
    }
    
    
    public Casa getCasaSelecionada()
    {
        return this.casaSelecionada;
    }   
    
    
    public void setCasaSelecionada(Casa casa)
    {
        this.casaSelecionada = casa;
    }
    
    
    public Validacao getValidador()
    {
        return validador;
    }
    
    
    public void setValidador(Validacao validador)
    {
        this.validador = validador;
    }
}






        
        
        
        /*while(x < 2)
        {
            while(y < 8)
            {
                matrizTabuleiro[x][y].setPeca(pecasBrancas.get(count1));
                y++;
                count1++;
            }
            
            y = 0;
            
            while(y < 8)
            {
                matrizTabuleiro[x + 6][y].setPeca(pecasPretas.get(count2));
                y++;
                count2++;
            }
            
            y = 0;
            x++;
        }    */

/*public boolean moverPeca(int x, int y, int x2, int y2)
    {
        if(x < 0 || x > 7 || y < 0 || y > 7 || x2 < 0 || x2 > 7 || y2 < 0 || y2 > 7) return false;
        
        
        matrizTabuleiro[x][y].getPeca();
        
        return true;
    }*/