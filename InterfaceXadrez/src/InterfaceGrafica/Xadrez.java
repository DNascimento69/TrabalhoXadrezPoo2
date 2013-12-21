/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;




public class Xadrez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Window window = new Window();
		window.tabuleiro.setValidador(new Validador());
    }
}
