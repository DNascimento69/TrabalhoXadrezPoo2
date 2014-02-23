package p2o2.ifes.serra.builder;

<<<<<<< HEAD
import java.util.List;
import p2o2.ifes.serra.model.Enum.EGameModeMenu;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Peca;
=======
import p2o2.ifes.serra.model.cdp.Game;
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d

public class GameMaker {
	
	private GameBuilder gameBuilder;
	
	
<<<<<<< HEAD
	public GameMaker(EGameModeMenu gameMode,List<String> lstNomePlayers){
	    this.gameBuilder = new GameBuilder(gameMode,lstNomePlayers);
=======
	public GameMaker(String nomePlayer1, String nomePLayer2){
	    this.gameBuilder = new GameBuilder(nomePlayer1,nomePLayer2);
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
	  }
	 
	  public Game getGame() {
	    return this.gameBuilder.getGame();
	  }
	 
	  public void constructGame() {
	    this.gameBuilder.setPlayers();
	    this.gameBuilder.setTabuleiro();
	  }
<<<<<<< HEAD
	  
	  public void rebuildGame(List<Peca> listPeca){
		   this.gameBuilder.remakeTabuleiro(listPeca);
	  }
=======
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d

}
