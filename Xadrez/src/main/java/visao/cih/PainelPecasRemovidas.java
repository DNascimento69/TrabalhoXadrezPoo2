/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visao.cih;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Almir
 */
public class PainelPecasRemovidas extends JLabel
{
    int nextVaga, xIndex, yIndex;
    //ArrayList<Vaga> vagas;
    Vaga matrizLayout[][];
    /*ArrayList<JLabel> vagas;
    ArrayList<Peca> pecas;
    ArrayList<PainelImagem> imagensPecas;*/
    
    public PainelPecasRemovidas(int xLocation, int yLocation)
    {
        super();
        xIndex = 0;
        yIndex = 0;
        nextVaga = 0;
        matrizLayout = new Vaga[4][4];
        //setLayout(null);
        setSize(208, 208);
        setLocation(xLocation, yLocation);
        //setBackground(Color.yellow);
        //inicializarArrays();
        inicializarMatrizLayout();
    }
    
    /*private void inicializarArrays()
    {
        int count = 0;
        
        vagas = new ArrayList<>();
        
        while(count < 16)
        {
            vagas.add(new Vaga());
            count++;
        }
    }*/
    
    
    private void inicializarMatrizLayout()
    {
        int x = 0, y = 0;
        
        while(x < 4)
        {
            while(y < 4)
            {
                matrizLayout[x][y] = new Vaga((y * 52), (x * 52));
                add(matrizLayout[x][y]);
                y++;
            }
            y = 0;
            x++;
        }
    }


    public void adicionarPeca(Peca peca)
    {
        matrizLayout[xIndex][yIndex].setPeca(peca);
        yIndex++;
        nextVaga++;
        
        if(yIndex > 3)
        {
            yIndex = 0;
            xIndex++;
        }
        repaint();
    }
    
    
    /*public Peca removerPeca(int index)
    {
        Peca tmp;
        
        if(nextVaga > vagas.size() - 1 || nextVaga < 0) return null;
        
        remove(vagas.get(index));
        tmp = vagas.get(index).removerPeca();
        vagas.add(vagas.remove(index));
        nextVaga--;
        repaint();
        return tmp;
    }*/
}


/*public void adicionarPeca(Peca peca)
    {
        if(nextVaga > 15) return;
        
        vagas.get(nextVaga).setPeca(peca);
        add(vagas.get(nextVaga));
        nextVaga++;
        repaint();
    }*/
