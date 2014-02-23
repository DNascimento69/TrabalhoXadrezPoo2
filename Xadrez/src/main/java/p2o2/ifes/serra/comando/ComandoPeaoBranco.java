/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p2o2.ifes.serra.comando;

import p2o2.ifes.serra.model.Enum.ELimiteCasas;
<<<<<<< HEAD
import p2o2.ifes.serra.strategy.StrategyMoveVerticalBaixo;
import p2o2.ifes.serra.strategy.StrategyMoveDiagonalBaixo;
=======
<<<<<<< HEAD
import p2o2.ifes.serra.strategy.StrategyMoveVerticalBaixo;
import p2o2.ifes.serra.strategy.StrategyMoveDiagonalBaixo;
=======
import p2o2.ifes.serra.strategy.StrategyMoveVerticalCima;
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f

/**
 *
 * @author Vic
 */
public class ComandoPeaoBranco extends ComandoPeao{
    	
    public ComandoPeaoBranco() {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
		this.setStrategyMoveInterface(new StrategyMoveVerticalBaixo());
		this.setStrategyMoveInterface(new StrategyMoveDiagonalBaixo());	
		this.setLimitacao(ELimiteCasas.DOIS,0);
		this.setLimitacao(ELimiteCasas.UM,1);
<<<<<<< HEAD
=======
=======
                this.setStrategyMoveInterface(new StrategyMoveVerticalCima());
		this.seLimitacao(ELimiteCasas.DOIS);
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
	}
}
