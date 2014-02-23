/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p2o2.ifes.serra.state;

import p2o2.ifes.serra.model.Enum.EGameStatus;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Jogador;

/**
 *
 * @author Vic
 */
public class FinalizaState implements StateInterface {
<<<<<<< HEAD
	  private Game jogo;
    
      public FinalizaState(Game game){
          this.jogo = game;
      }
      
      public void jogadaDaVez(){
         Jogador jogadorGanhador = new Jogador();//Pegar ganhador..
         this.jogo.setGameStatus(EGameStatus.Terminado);
=======
    
      public FinalizaState(){
          
      }
      
      public void jogadaDaVez(Game game){
         Jogador jogadorGanhador = new Jogador();//Pegar ganhador..
         game.setGameStatus(EGameStatus.Terminado);
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
         //game.setJogadorVencendorId(ganhador.getID());
         //SALVAR GAME
         System.out.println(" ");
         System.out.println("O Jogador: " + jogadorGanhador.toString()+ " Ganhou o jogo!");
         System.out.println("Parabéns!");
         System.out.println("Jogo Finalizado!");
      }
    
}
