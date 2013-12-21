/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InterfaceGrafica;

/**
 *
 * @author Almir
 */
public class Validador implements Validacao
{
    @Override
    public boolean validaMovimento(Casa casa1, Casa casa2) 
    {
        if(casa1.getPeca() != null & casa2.getPeca() != null) 
            if(casa1.getPeca().cor == casa2.getPeca().cor)
                return false;
        return true;
    }

    @Override
    public boolean validaSelecao(Casa casa) 
    {
        if(casa.getPeca() == null & casa.tabuleiro.getCasaSelecionada() == null) return false;
        return true;
    }
}
