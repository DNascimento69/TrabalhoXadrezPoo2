/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p2o2.ifes.serra.state;

import p2o2.ifes.serra.model.Enum.EGameStatus;
import p2o2.ifes.serra.model.Enum.EJogadaMenu;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Jogador;
import p2o2.ifes.serra.util.LeitorUtil;
import p2o2.ifes.serra.view.cih.JogadaView;

/**
 *
 * @author Vic
 */
public class EmpateState implements StateInterface{
     private JogadaView jogadaView = new JogadaView();
     EJogadaMenu jogadaMenu;
<<<<<<< HEAD
	 private Game jogo;
=======
<<<<<<< HEAD
	 private Game jogo;
    
     public EmpateState(Game game){
		 this.jogo = game;
         jogadaDaVez();
     }
    
     public void jogadaDaVez(){
          String cor;

         if(this.jogo.getJogadorDaVez() == 1){
=======
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
    
     public EmpateState(Game game){
		 this.jogo = game;
         jogadaDaVez();
     }
    
     public void jogadaDaVez(){
          String cor;

<<<<<<< HEAD
         if(this.jogo.getJogadorDaVez() == 1){
=======
         if(game.getJogadorDaVez() == 1){
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
             cor = "branco";
         }
          else{
             cor = "preto";
         }
         
         System.out.println(" ");
         System.out.println("Jogador "+cor+" é o seu turno!");
         
         jogadaView.show();	
         int opcaoMenu = LeitorUtil.lervalorInteiro();
	 verificaOpcaoJogada(opcaoMenu);
         
         
         if (jogadaMenu.equals(EJogadaMenu.Jogar)) {
              this.jogar();
<<<<<<< HEAD
              if(this.jogo.getJogadorDaVez() == 1){
                   this.jogo.setJogadorDaVez(EPlayerColor.black);
                    this.jogo.setState(new JogadorPretoState(this.jogo));
=======
<<<<<<< HEAD
              if(this.jogo.getJogadorDaVez() == 1){
                   this.jogo.setJogadorDaVez(EPlayerColor.black);
                    this.jogo.setState(new JogadorPretoState(this.jogo));
               }
                else{
                   this.jogo.setJogadorDaVez(EPlayerColor.white);
                    this.jogo.setState(new JogadorBrancoState(this.jogo));
               }             
         }
         if (jogadaMenu.equals(EJogadaMenu.Empate)){
                this.empatar(this.jogo);
                 
         }
         if(jogadaMenu.equals(EJogadaMenu.Desistir)){
              this.jogo.setState(new DesistirState(this.jogo));
=======
              if(game.getJogadorDaVez() == 1){
                   game.setJogadorDaVez(EPlayerColor.black);
                    game.setState(new JogadorPretoState(game));
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
               }
                else{
                   this.jogo.setJogadorDaVez(EPlayerColor.white);
                    this.jogo.setState(new JogadorBrancoState(this.jogo));
               }             
         }
         if (jogadaMenu.equals(EJogadaMenu.Empate)){
                this.empatar(this.jogo);
                 
         }
         if(jogadaMenu.equals(EJogadaMenu.Desistir)){
<<<<<<< HEAD
              this.jogo.setState(new DesistirState(this.jogo));
=======
              game.setState(new DesistirState(game));
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
         }
         if(jogadaMenu.equals(EJogadaMenu.Salvar)){
             
         }
     }

     protected void empatar(Game game){
         
         game.setGameStatus(EGameStatus.Terminado);
         game.setJogadorVencendorId(-1);
         //SALVAR GAME
         System.out.println(" ");
         System.out.println("Os jogadores concordaram em um Empate!");
         System.out.println("Jogo Finalizado!");

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
