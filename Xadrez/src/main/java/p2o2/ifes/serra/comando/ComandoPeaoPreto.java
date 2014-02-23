/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p2o2.ifes.serra.comando;

import p2o2.ifes.serra.model.Enum.ELimiteCasas;
<<<<<<< HEAD
import p2o2.ifes.serra.strategy.StrategyMoveDiagonalCima;
import p2o2.ifes.serra.strategy.StrategyMoveVerticalCima;

=======
<<<<<<< HEAD
import p2o2.ifes.serra.strategy.StrategyMoveDiagonalCima;
import p2o2.ifes.serra.strategy.StrategyMoveVerticalCima;

=======
import p2o2.ifes.serra.strategy.StrategyMoveVerticalBaixo;
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f

/**
 *
 * @author Vic
 */
public class ComandoPeaoPreto extends ComandoPeao {
    
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
    public ComandoPeaoPreto() {
		this.setStrategyMoveInterface(new StrategyMoveVerticalCima());
		this.setStrategyMoveInterface(new StrategyMoveDiagonalCima());	
		this.setLimitacao(ELimiteCasas.DOIS,0);
		this.setLimitacao(ELimiteCasas.UM,1);
<<<<<<< HEAD
=======
=======
        public ComandoPeaoPreto() {
                this.setStrategyMoveInterface(new StrategyMoveVerticalBaixo());
		this.seLimitacao(ELimiteCasas.DOIS);
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
	}
    
}
