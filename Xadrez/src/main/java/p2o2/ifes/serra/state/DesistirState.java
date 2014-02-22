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
public class DesistirState implements StateInterface{
    
     public DesistirState(Game game){
         jogadaDaVez(game);
     }
    
     public void jogadaDaVez(Game game){
          Jogador jogadorDesistente;
          Jogador ganhador;
         if(game.getJogadorDaVez() == 1){
             jogadorDesistente = game.getJogador1();
             ganhador = game.getJogador2();
         }
         else{
             jogadorDesistente = game.getJogador2();
             ganhador = game.getJogador1();
         }
         
         
         game.setGameStatus(EGameStatus.Terminado);
         game.setJogadorVencendorId(ganhador.getID());
         //SALVAR GAME
         System.out.println(" ");
         System.out.println("O Jogador: " + jogadorDesistente.toString()+ " Desistiu, logo, o Jogador : " + ganhador.toString() + " é o vencedor!");
         System.out.println("Parabéns!");
         System.out.println("Jogo Finalizado!");
         
     }
    
}
