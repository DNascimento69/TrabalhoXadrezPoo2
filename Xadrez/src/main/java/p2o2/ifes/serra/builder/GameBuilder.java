package p2o2.ifes.serra.builder;

import java.util.List;

import p2o2.ifes.serra.factory.JogadorFactory;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Jogador;

public class GameBuilder implements GameBuilderInterface {

	private Game game;

	public GameBuilder() {
		game = new Game();
	}

	public void setPlayers(List<String> jogadoreLst) {
		JogadorFactory jogadorFactory = new JogadorFactory();
		Jogador player1 = jogadorFactory.getJogador(jogadoreLst.get(0),
				EPlayerColor.white);
		Jogador player2 = jogadorFactory.getJogador(jogadoreLst.get(1),
				EPlayerColor.black);

		game.setJogador1(player1);
		game.setJogador2(player2);
	}

	public void setTabuleiro() {

	}

}
