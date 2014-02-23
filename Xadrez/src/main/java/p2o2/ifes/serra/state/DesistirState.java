/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p2o2.ifes.serra.state;

<<<<<<< HEAD
import p2o2.ifes.serra.model.Enum.EGameModeMenu;
=======
<<<<<<< HEAD
import p2o2.ifes.serra.model.Enum.EGameModeMenu;
=======
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
import p2o2.ifes.serra.model.Enum.EGameStatus;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Jogador;


/**
 *
 * @author Vic
 */
public class DesistirState implements StateInterface{
<<<<<<< HEAD
	 private Game jogo;
=======
<<<<<<< HEAD
	 private Game jogo;
    
     public DesistirState(Game game){
		 this.jogo = game;
         jogadaDaVez();
     }
    
     public void jogadaDaVez(){
          Jogador jogadorDesistente;
          Jogador ganhador;
		  this.jogo.setGameStatus(EGameStatus.Terminado);
		  
		  if(this.jogo.getGameMode().equals(EGameModeMenu.TwoPlayerGame)){
				if(this.jogo.getJogadorDaVez() == 1){
					jogadorDesistente = this.jogo.getJogador1();
					ganhador = this.jogo.getJogador2();
				}
				else{
					jogadorDesistente = this.jogo.getJogador2();
					ganhador = this.jogo.getJogador1();
				}
						 
				this.jogo.setJogadorVencendorId( ganhador.getId());
				//SALVAR GAME
				System.out.println(" ");
				System.out.println("O Jogador: " + jogadorDesistente.toString()+ " Desistiu, logo, o Jogador : " + ganhador.toString() + " é o vencedor!");
				System.out.println("Parabéns!");
				System.out.println("Jogo Finalizado!");
				
		  }
		  else{
			  if(this.jogo.getJogadorDaVez() == 1){
					this.jogo.setJogadorVencendorId( -1);
					//SALVAR GAME
					System.out.println(" ");
					System.out.println("O Jogador: " + jogo.getJogador1().toString()+ " Desistiu, logo, Zeus é o vencedor!");
					System.out.println("Parabéns!");
					System.out.println("Jogo Finalizado!");
				}
				else{
					this.jogo.setJogadorVencendorId( jogo.getJogador1().getId());
					//SALVAR GAME
					System.out.println(" ");
					System.out.println("O Zeus: Desistiu, logo, "+jogo.getJogador1().toString()+" é o vencedor!");
					System.out.println("Parabéns!");
					System.out.println("Jogo Finalizado!");
				}
		  }
=======
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
    
     public DesistirState(Game game){
		 this.jogo = game;
         jogadaDaVez();
     }
    
     public void jogadaDaVez(){
          Jogador jogadorDesistente;
          Jogador ganhador;
<<<<<<< HEAD
		  this.jogo.setGameStatus(EGameStatus.Terminado);
		  
		  if(this.jogo.getGameMode().equals(EGameModeMenu.TwoPlayerGame)){
				if(this.jogo.getJogadorDaVez() == 1){
					jogadorDesistente = this.jogo.getJogador1();
					ganhador = this.jogo.getJogador2();
				}
				else{
					jogadorDesistente = this.jogo.getJogador2();
					ganhador = this.jogo.getJogador1();
				}
						 
				this.jogo.setJogadorVencendorId( ganhador.getId());
				//SALVAR GAME
				System.out.println(" ");
				System.out.println("O Jogador: " + jogadorDesistente.toString()+ " Desistiu, logo, o Jogador : " + ganhador.toString() + " é o vencedor!");
				System.out.println("Parabéns!");
				System.out.println("Jogo Finalizado!");
				
		  }
		  else{
			  if(this.jogo.getJogadorDaVez() == 1){
					this.jogo.setJogadorVencendorId( -1);
					//SALVAR GAME
					System.out.println(" ");
					System.out.println("O Jogador: " + jogo.getJogador1().toString()+ " Desistiu, logo, Zeus é o vencedor!");
					System.out.println("Parabéns!");
					System.out.println("Jogo Finalizado!");
				}
				else{
					this.jogo.setJogadorVencendorId( jogo.getJogador1().getId());
					//SALVAR GAME
					System.out.println(" ");
					System.out.println("O Zeus: Desistiu, logo, "+jogo.getJogador1().toString()+" é o vencedor!");
					System.out.println("Parabéns!");
					System.out.println("Jogo Finalizado!");
				}
		  }
=======
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
         
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
     }
    
}
