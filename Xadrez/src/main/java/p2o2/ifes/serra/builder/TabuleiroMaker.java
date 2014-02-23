package p2o2.ifes.serra.builder;

<<<<<<< HEAD
import java.util.List;
import p2o2.ifes.serra.model.cdp.Peca;
=======
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
import p2o2.ifes.serra.model.cdp.Tabuleiro;

public class TabuleiroMaker {
	private TabuleiroBuilder tabuleiroBuilder;
	
	
	public TabuleiroMaker(int idGamer){
	    this.tabuleiroBuilder = new TabuleiroBuilder(idGamer);
	  }
	 
	  public Tabuleiro getTabuleiro() {
	    return this.tabuleiroBuilder.getTabuleiro();
	  }
	 
	  public void constructTabuleiro() {
	    this.tabuleiroBuilder.CriarPecas();
	  }
<<<<<<< HEAD
	  
	  public void remakeTabuleiro(List<Peca> listPeca){
		  this.tabuleiroBuilder.RemakePecas(listPeca);
	  }
=======
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d

}
