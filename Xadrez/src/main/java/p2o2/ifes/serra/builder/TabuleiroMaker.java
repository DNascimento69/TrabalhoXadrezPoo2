package p2o2.ifes.serra.builder;

<<<<<<< HEAD
import java.util.List;
import p2o2.ifes.serra.model.cdp.Peca;
=======
<<<<<<< HEAD
import java.util.List;
import p2o2.ifes.serra.model.cdp.Peca;
=======
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
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
=======
<<<<<<< HEAD
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
	  
	  public void remakeTabuleiro(List<Peca> listPeca){
		  this.tabuleiroBuilder.RemakePecas(listPeca);
	  }
<<<<<<< HEAD
=======
=======
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f

}
