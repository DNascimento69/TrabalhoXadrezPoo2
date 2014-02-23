/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p2o2.ifes.serra.state;

import java.util.ArrayList;
import java.util.List;
import p2o2.ifes.serra.dao.DAOGame;
import p2o2.ifes.serra.dao.DAOJogador;
import p2o2.ifes.serra.dao.DAOPeca;
import p2o2.ifes.serra.model.Enum.EGameModeMenu;
import p2o2.ifes.serra.model.Enum.EJogadaMenu;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.util.LeitorUtil;
import p2o2.ifes.serra.view.cih.JogadaView;

/**
 *
 * @author Vic
 */
public class JogadorBrancoState implements StateInterface {
     private JogadaView jogadaView = new JogadaView();
	 private Game jogo;
	 
     EJogadaMenu jogadaMenu;
     
     
     public JogadorBrancoState(Game game){
		 this.jogo = game;
         jogadaDaVez();
     }
    
     public void jogadaDaVez(){
         System.out.println(" ");
         System.out.println("Jogador branco é o seu turno!");
		 System.out.println(" ");
		 this.jogo.imprimeTabuleiro();
		 System.out.println(" ");
         jogadaView.show();	
         int opcaoMenu = LeitorUtil.lervalorInteiro();
		 verificaOpcaoJogada(opcaoMenu);
         
         if(opcaoMenu < 5){
			if (jogadaMenu.equals(EJogadaMenu.Jogar)) {
				this.jogar( this.jogo);
				
				if(this.jogo.getGameMode().equals(EGameModeMenu.TwoPlayerGame)){
					this.jogo.setJogadorDaVez(EPlayerColor.black);
					this.jogo.setState(new JogadorPretoState( this.jogo));
				}
				else{
					this.jogo.setJogadorDaVez(EPlayerColor.zeus);
					this.jogo.setState(new JogadorZeusState( this.jogo));
				}
			}
			if (jogadaMenu.equals(EJogadaMenu.Empate)){
				 this.jogo.setJogadorDaVez(EPlayerColor.black);
				 this.jogo.setState(new EmpateState(this.jogo));
			}
			if(jogadaMenu.equals(EJogadaMenu.Desistir)){
				 this.jogo.setState(new DesistirState(this.jogo));
			}
			if(jogadaMenu.equals(EJogadaMenu.Salvar)){
				this.salvar();
				System.out.println("Jogo Salvo!");
				System.out.println("Fim de jogo!");
			}
		 }
     }
	 
	  protected void salvar(){
		 try{
				List<Peca> lstPecas = new ArrayList<Peca>();
				DAOGame daoGame = new DAOGame();
				DAOJogador daoJogador  = new DAOJogador();
				DAOPeca daoPeca = new DAOPeca();

				lstPecas.addAll(this.jogo.getTabuleiro().listarPecasJogo());
				daoJogador.insert(this.jogo.getJogador1());
				daoJogador.insert(this.jogo.getJogador2());
				daoGame.insert(this.jogo);

				for(Peca peca:lstPecas){
					daoPeca.insert(peca);
				}
				
				
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
	 }
	 
     protected void jogar(Game game){
		 boolean jogadaValida = false;
         String jogada;
         
		 while(!jogadaValida){
			System.out.println("Jogador branco, faça sua jogada!");
			jogada = LeitorUtil.lervalorString();
			System.out.println("Sua jogada foi: "+ jogada);
			jogadaValida = game.jogada(jogada, EPlayerColor.white);
		 }
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
