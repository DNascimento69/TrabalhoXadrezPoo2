/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2o2.ifes.serra.state;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
<<<<<<< HEAD
import p2o2.ifes.serra.controller.cci.TabuleiroControllerView;
import p2o2.ifes.serra.dao.DAOGame;
import p2o2.ifes.serra.dao.DAOJogador;
import p2o2.ifes.serra.dao.DAOPeca;
import p2o2.ifes.serra.model.Enum.EGameStatus;
=======
import p2o2.ifes.serra.dao.DAOGame;
import p2o2.ifes.serra.dao.DAOJogador;
import p2o2.ifes.serra.dao.DAOPeca;
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
import p2o2.ifes.serra.model.Enum.EJogadaMenu;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.Enum.EXeque;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Peca;
<<<<<<< HEAD
=======
=======
import p2o2.ifes.serra.model.Enum.EJogadaMenu;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.cdp.Game;
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
import p2o2.ifes.serra.util.LeitorUtil;
import p2o2.ifes.serra.view.cih.JogadaView;

/**
 *
 * @author Vic
 */
<<<<<<< HEAD
public class JogadorPretoState implements StateInterface {

	private JogadaView jogadaView = new JogadaView();
	private Game jogo;
	EJogadaMenu jogadaMenu;
	TabuleiroControllerView tabView = new TabuleiroControllerView();

	public JogadorPretoState(Game game) {
		this.jogo = game;
		jogadaDaVez();
	}

	public void jogadaDaVez() {

		System.out.println(" ");
		System.out.println("Jogador preto é o seu turno!");
		System.out.println(" ");
		this.tabView.imprimirTabuleiro(jogo);
		System.out.println(" ");

		jogadaView.show();
		int opcaoMenu = LeitorUtil.lervalorInteiro();
		verificaOpcaoJogada(opcaoMenu);

		if (opcaoMenu < 5) {

			if (jogadaMenu.equals(EJogadaMenu.Jogar)) {
				EXeque e = this.jogar(this.jogo);
				this.jogo.setJogadorDaVez(EPlayerColor.white);
				if (e.equals(EXeque.XequeMate)) {
					this.finalizarJogo();
					System.out.println("Jogo Salvo!");
					System.out.println("Fim de jogo!");
				}
				this.jogo.setState(new JogadorBrancoState(this.jogo));
			}
			if (jogadaMenu.equals(EJogadaMenu.Empate)) {
				this.jogo.setJogadorDaVez(EPlayerColor.white);
				this.jogo.setState(new EmpateState(this.jogo));
			}
			if (jogadaMenu.equals(EJogadaMenu.Desistir)) {
				this.jogo.setState(new DesistirState(this.jogo));
			}
			if (jogadaMenu.equals(EJogadaMenu.Salvar)) {
=======
public class JogadorPretoState implements StateInterface{
     private JogadaView jogadaView = new JogadaView();
<<<<<<< HEAD
	 private Game jogo;
     EJogadaMenu jogadaMenu;
     
     public JogadorPretoState(Game game){
		 this.jogo = game;
         jogadaDaVez();
     }
    
     public void jogadaDaVez(){
		 System.out.println(" ");
         System.out.println("Jogador preto é o seu turno!");
		 System.out.println(" ");
		 this.jogo.imprimeTabuleiro();
		 System.out.println(" ");
         
         jogadaView.show();	
         int opcaoMenu = LeitorUtil.lervalorInteiro();
		 verificaOpcaoJogada(opcaoMenu);
         
			if(opcaoMenu < 5){

			if (jogadaMenu.equals(EJogadaMenu.Jogar)) {
				this.jogar(this.jogo);
				this.jogo.setJogadorDaVez(EPlayerColor.white);
				this.jogo.setState(new JogadorBrancoState(this.jogo));
			}
			if (jogadaMenu.equals(EJogadaMenu.Empate)){
				this.jogo.setJogadorDaVez(EPlayerColor.white);
				this.jogo.setState(new EmpateState(this.jogo));
			}
			if(jogadaMenu.equals(EJogadaMenu.Desistir)){
				this.jogo.setState(new DesistirState(this.jogo));
			}
			if(jogadaMenu.equals(EJogadaMenu.Salvar)){
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
				this.salvar();
				System.out.println("Jogo Salvo!");
				System.out.println("Fim de jogo!");

<<<<<<< HEAD
			}
		}
	}

	protected void finalizarJogo() {


		try {
			jogo.setGameStatus(EGameStatus.Terminado);
			jogo.setJogadorVencendorId(1);
			DAOGame daoGame = new DAOGame();
			daoGame.insert(this.jogo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void salvar() {
		try {
			List<Peca> lstPecas = new ArrayList<Peca>();
			DAOGame daoGame = new DAOGame();
			DAOJogador daoJogador = new DAOJogador();
			DAOPeca daoPeca = new DAOPeca();

			lstPecas.addAll(this.jogo.getTabuleiro().listarPecasJogo());
			daoJogador.insert(this.jogo.getJogador1());
			daoJogador.insert(this.jogo.getJogador2());
			daoGame.insert(this.jogo);

			for (Peca peca : lstPecas) {
				daoPeca.insert(peca);
			}


		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected EXeque jogar(Game game) {
		boolean jogadaValida = false;
		String jogada;
		EXeque verificaXeque = jogo.getTabuleiro().verificaXeque(EPlayerColor.black);
		while (!jogadaValida || verificaXeque.equals(EXeque.Xeque)) {
			System.out.println("Jogador Preto, faça sua jogada!");
			jogada = LeitorUtil.lervalorString();
			System.out.println("Sua Jogada foi: " + jogada);
			if (jogada.equals("O-O") || jogada.equals("O-O-O")) {
				jogadaValida = game.jogada(game, jogada);
			} else {
				jogadaValida = game.jogada(jogada, EPlayerColor.black);
			}
		}
		return verificaXeque;
	}

	protected void verificaOpcaoJogada(int opcaoMainMenu) {
		switch (opcaoMainMenu) {
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
=======
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
         System.out.println("Jogador Preto, faça sua jogada!");
         jogada = LeitorUtil.lervalorString();
         System.out.println("Sua Jogada foi: "+ jogada);
		 jogadaValida = game.jogada(jogada, EPlayerColor.black);
		 }
=======
     EJogadaMenu jogadaMenu;
     
     public JogadorPretoState(Game game){
         jogadaDaVez(game);
     }
    
     public void jogadaDaVez(Game game){
         
         jogadaView.show();	
         int opcaoMenu = LeitorUtil.lervalorInteiro();
	 verificaOpcaoJogada(opcaoMenu);
         
         
         if (jogadaMenu.equals(EJogadaMenu.Jogar)) {
             this.jogar();
             game.setJogadorDaVez(EPlayerColor.white);
             game.setState(new JogadorBrancoState(game));
         }
         if (jogadaMenu.equals(EJogadaMenu.Empate)){
             game.setJogadorDaVez(EPlayerColor.white);
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
         
         System.out.println("Jogador Preto, faça sua jogada!");
         jogada = LeitorUtil.lervalorString();
         System.out.println("Sua Jogada FOi"+ jogada);
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
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
    
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
}
