/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p2o2.ifes.serra.state;

import p2o2.ifes.serra.model.Enum.EJogadaMenu;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.util.LeitorUtil;
import p2o2.ifes.serra.view.cih.JogadaView;

/**
 *
 * @author Vic
 */
public class JogadorBrancoState implements StateInterface {
     private JogadaView jogadaView = new JogadaView();
     EJogadaMenu jogadaMenu;
     
     
     public JogadorBrancoState(Game game){
         jogadaDaVez(game);
     }
    
     public void jogadaDaVez(Game game){
         System.out.println(" ");
         System.out.println("Jogador branco é o seu turno!");
         
         jogadaView.show();	
         int opcaoMenu = LeitorUtil.lervalorInteiro();
	 verificaOpcaoJogada(opcaoMenu);
         
         
         if (jogadaMenu.equals(EJogadaMenu.Jogar)) {
             this.jogar();
             game.setJogadorDaVez(EPlayerColor.black);
             game.setState(new JogadorPretoState(game));
             
         }
         if (jogadaMenu.equals(EJogadaMenu.Empate)){
              game.setJogadorDaVez(EPlayerColor.black);
              game.setState(new EmpateState(game));
         }
         if(jogadaMenu.equals(EJogadaMenu.Desistir)){
              game.setState(new DesistirState(game));
         }
         if(jogadaMenu.equals(EJogadaMenu.Salvar)){
             
         }
     }
     protected void jogar(){
         String jogada;
         
         System.out.println("Jogador branco, faça sua jogada!");
         jogada = LeitorUtil.lervalorString();
         System.out.println("Sua Jogada FOi: "+ jogada);
     }
     
     protected void verificaOpcaoJogada(int opcaoMainMenu){
            switch(opcaoMainMenu){
                    case 1: 
                            jogadaMenu = EJogadaMenu.Jogar;
                            break;
                    case 2:
                            jogadaMenu = EJogadaMenu.Empate;
                            break;
                    case 3: 
                            jogadaMenu = EJogadaMenu.Desistir;
                            break;
                    case 4:
                            jogadaMenu = EJogadaMenu.Salvar;
                            break;
                    default: 
                            jogadaView.mensagemOpcaoInvalida();
                            jogadaView.mensagemFim();
                            break;
            }
         
     }
    
}
