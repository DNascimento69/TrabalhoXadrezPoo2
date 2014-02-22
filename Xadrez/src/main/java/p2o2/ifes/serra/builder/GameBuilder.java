package p2o2.ifes.serra.builder;

import p2o2.ifes.serra.factory.JogadorFactory;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Jogador;

public class GameBuilder implements GameBuilderInterface {

	private Game game;
	private String jogador1;
	private String jogador2;

	public GameBuilder(String nomePlayer1, String nomePLayer2) {
		game = new Game();
		this.jogador1 = nomePlayer1;
		this.jogador2 = nomePLayer2;
	}

	public void setPlayers() {
		JogadorFactory jogadorFactory = new JogadorFactory();
		Jogador player1 = jogadorFactory.getJogador(jogador1,
				EPlayerColor.white);
		Jogador player2 = jogadorFactory.getJogador(jogador2,
				EPlayerColor.black);

		game.setJogador1(player1);
		game.setJogador2(player2);
                game.setJogadorDaVez(EPlayerColor.white);
	}

	public void setTabuleiro() {
		TabuleiroMaker tabuleiroMaiker = new TabuleiroMaker(game.getID());
		tabuleiroMaiker.constructTabuleiro();
		game.setTabuleiro(tabuleiroMaiker.getTabuleiro());
	}
	
	public Game getGame(){
		return game;
	}

}
