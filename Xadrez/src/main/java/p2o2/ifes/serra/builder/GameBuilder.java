package p2o2.ifes.serra.builder;

<<<<<<< HEAD
import java.util.List;
=======
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
import p2o2.ifes.serra.factory.JogadorFactory;
import p2o2.ifes.serra.model.Enum.EGameModeMenu;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Jogador;
import p2o2.ifes.serra.model.cdp.Peca;

public class GameBuilder implements GameBuilderInterface {

	private Game game;
	private String jogador1;
	private String jogador2;
<<<<<<< HEAD
	private EGameModeMenu gameMode;
=======
<<<<<<< HEAD
	private EGameModeMenu gameMode;

	public GameBuilder(EGameModeMenu gameMode,List<String> lstNomePlayers) {
		this.game = new Game();
		this.gameMode = gameMode;
		
		game.setGameMode(gameMode);
		if(gameMode.equals(EGameModeMenu.TwoPlayerGame)){
			this.jogador1 = lstNomePlayers.get(0);
			this.jogador2 = lstNomePlayers.get(1);
		}
		else{
			this.jogador1 = lstNomePlayers.get(0);
		}
	}

	public void setPlayers() {
		if(gameMode.equals(EGameModeMenu.TwoPlayerGame)){
			JogadorFactory jogadorFactory = new JogadorFactory();
			Jogador player1 = jogadorFactory.getJogador(jogador1,
					EPlayerColor.white);
			Jogador player2 = jogadorFactory.getJogador(jogador2,
					EPlayerColor.black);

				game.setJogador1(player1);
				game.setJogador2(player2);
                game.setJogadorDaVez(EPlayerColor.white);
		}
		else{
			JogadorFactory jogadorFactory = new JogadorFactory();
			Jogador player1 = jogadorFactory.getJogador(jogador1,
					EPlayerColor.white);
			Jogador player2 = null;
			
				game.setJogador1(player1);
				game.setJogador2(player2);
                game.setJogadorDaVez(EPlayerColor.white);
		}
=======
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f

	public GameBuilder(EGameModeMenu gameMode,List<String> lstNomePlayers) {
		this.game = new Game();
		this.gameMode = gameMode;
		
		game.setGameMode(gameMode);
		if(gameMode.equals(EGameModeMenu.TwoPlayerGame)){
			this.jogador1 = lstNomePlayers.get(0);
			this.jogador2 = lstNomePlayers.get(1);
		}
		else{
			this.jogador1 = lstNomePlayers.get(0);
		}
	}

	public void setPlayers() {
		if(gameMode.equals(EGameModeMenu.TwoPlayerGame)){
			JogadorFactory jogadorFactory = new JogadorFactory();
			Jogador player1 = jogadorFactory.getJogador(jogador1,
					EPlayerColor.white);
			Jogador player2 = jogadorFactory.getJogador(jogador2,
					EPlayerColor.black);

				game.setJogador1(player1);
				game.setJogador2(player2);
                game.setJogadorDaVez(EPlayerColor.white);
		}
		else{
			JogadorFactory jogadorFactory = new JogadorFactory();
			Jogador player1 = jogadorFactory.getJogador(jogador1,
					EPlayerColor.white);
			Jogador player2 = null;
			
				game.setJogador1(player1);
				game.setJogador2(player2);
                game.setJogadorDaVez(EPlayerColor.white);
<<<<<<< HEAD
		}
=======
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
	}

	public void setTabuleiro() {
		TabuleiroMaker tabuleiroMaiker = new TabuleiroMaker(game.getID());
		tabuleiroMaiker.constructTabuleiro();
		game.setTabuleiro(tabuleiroMaiker.getTabuleiro());
	}
	
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
	public void remakeTabuleiro(List<Peca> listPeca){
		TabuleiroMaker tabuleiroMaiker = new TabuleiroMaker(game.getID());
		tabuleiroMaiker.remakeTabuleiro(listPeca);
		game.setTabuleiro(tabuleiroMaiker.getTabuleiro());
		
	}
	
<<<<<<< HEAD
=======
=======
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
	public Game getGame(){
		return game;
	}

}
