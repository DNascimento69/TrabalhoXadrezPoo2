/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2o2.ifes.serra.state;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import p2o2.ifes.serra.controller.cci.TabuleiroControllerView;
=======
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
import p2o2.ifes.serra.dao.DAOGame;
import p2o2.ifes.serra.dao.DAOJogador;
import p2o2.ifes.serra.dao.DAOPeca;
import p2o2.ifes.serra.model.Enum.EGameModeMenu;
<<<<<<< HEAD
import p2o2.ifes.serra.model.Enum.EGameStatus;
=======
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
public class JogadorBrancoState implements StateInterface {
<<<<<<< HEAD

	private JogadaView jogadaView = new JogadaView();
	private Game jogo;
	EJogadaMenu jogadaMenu;
	TabuleiroControllerView tabView = new TabuleiroControllerView();

	public JogadorBrancoState(Game game) {
		this.jogo = game;
		jogadaDaVez();
	}

	public void jogadaDaVez() {
		System.out.println(" ");
		System.out.println("Jogador branco é o seu turno!");
		System.out.println(" ");
		this.tabView.imprimirTabuleiro(jogo);
		System.out.println(" ");
		jogadaView.show();
		int opcaoMenu = LeitorUtil.lervalorInteiro();
		verificaOpcaoJogada(opcaoMenu);

		if (opcaoMenu < 5) {
			if (jogadaMenu.equals(EJogadaMenu.Jogar)) {
				EXeque e = this.jogar(this.jogo);
				if (e.equals(EXeque.XequeMate)) {
					this.finalizarJogo();
					System.out.println("Jogo Salvo!");
					System.out.println("Fim de jogo!");
				}
				if (this.jogo.getGameMode().equals(EGameModeMenu.TwoPlayerGame)) {
					this.jogo.setJogadorDaVez(EPlayerColor.black);
					this.jogo.setState(new JogadorPretoState(this.jogo));
				} else {
					this.jogo.setJogadorDaVez(EPlayerColor.zeus);
					this.jogo.setState(new JogadorZeusState(this.jogo));
				}
			}
			if (jogadaMenu.equals(EJogadaMenu.Empate)) {
				this.jogo.setJogadorDaVez(EPlayerColor.black);
				this.jogo.setState(new EmpateState(this.jogo));
			}
			if (jogadaMenu.equals(EJogadaMenu.Desistir)) {
				this.jogo.setState(new DesistirState(this.jogo));
			}
			if (jogadaMenu.equals(EJogadaMenu.Salvar)) {
=======
     private JogadaView jogadaView = new JogadaView();
<<<<<<< HEAD
	 private Game jogo;
	 
=======
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
     EJogadaMenu jogadaMenu;
     
     
     public JogadorBrancoState(Game game){
<<<<<<< HEAD
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
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
				this.salvar();
				System.out.println("Jogo Salvo!");
				System.out.println("Fim de jogo!");
			}
<<<<<<< HEAD

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
		EXeque verificaXeque = jogo.getTabuleiro().verificaXeque(EPlayerColor.white);

		while (!jogadaValida || verificaXeque.equals(EXeque.Xeque)) {
			System.out.println("Jogador branco, faça sua jogada!");
			jogada = LeitorUtil.lervalorString();
			System.out.println("Sua jogada foi: " + jogada);
			if (jogada.equals("O-O") || jogada.equals("O-O-O")) {
				jogadaValida = game.jogada(game, jogada);
			} else {
				jogadaValida = game.jogada(jogada, EPlayerColor.white);
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
=======
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
