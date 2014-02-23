package p2o2.ifes.serra.builder;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
import java.util.List;
import p2o2.ifes.serra.model.Enum.EGameModeMenu;
import p2o2.ifes.serra.model.cdp.Game;
import p2o2.ifes.serra.model.cdp.Peca;
<<<<<<< HEAD
=======
=======
import p2o2.ifes.serra.model.cdp.Game;
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f

public class GameMaker {
	
	private GameBuilder gameBuilder;
	
	
<<<<<<< HEAD
	public GameMaker(EGameModeMenu gameMode,List<String> lstNomePlayers){
	    this.gameBuilder = new GameBuilder(gameMode,lstNomePlayers);
=======
<<<<<<< HEAD
	public GameMaker(EGameModeMenu gameMode,List<String> lstNomePlayers){
	    this.gameBuilder = new GameBuilder(gameMode,lstNomePlayers);
=======
	public GameMaker(String nomePlayer1, String nomePLayer2){
	    this.gameBuilder = new GameBuilder(nomePlayer1,nomePLayer2);
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
	  }
	 
	  public Game getGame() {
	    return this.gameBuilder.getGame();
	  }
	 
	  public void constructGame() {
	    this.gameBuilder.setPlayers();
	    this.gameBuilder.setTabuleiro();
	  }
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
	  
	  public void rebuildGame(List<Peca> listPeca){
		   this.gameBuilder.remakeTabuleiro(listPeca);
	  }
<<<<<<< HEAD
=======
=======
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f

}
