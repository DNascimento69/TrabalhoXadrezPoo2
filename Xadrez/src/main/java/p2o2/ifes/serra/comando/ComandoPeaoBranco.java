/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package p2o2.ifes.serra.comando;

import p2o2.ifes.serra.model.Enum.ELimiteCasas;
import p2o2.ifes.serra.strategy.StrategyMoveVerticalCima;

/**
 *
 * @author Vic
 */
public class ComandoPeaoBranco extends ComandoPeao{
    	
    public ComandoPeaoBranco() {
                this.setStrategyMoveInterface(new StrategyMoveVerticalCima());
		this.seLimitacao(ELimiteCasas.DOIS);
	}
}
