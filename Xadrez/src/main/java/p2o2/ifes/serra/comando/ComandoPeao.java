package p2o2.ifes.serra.comando;

import java.util.List;

import p2o2.ifes.serra.model.Enum.ELimiteCasas;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.model.cdp.Tabuleiro;
import p2o2.ifes.serra.strategy.StrategyMoveInterface;

public abstract class ComandoPeao implements ComandoMovimento {

	private StrategyMoveInterface estrategiaMovimento = null;
	
        
	public ComandoPeao() {
		//this.estrategiaMovimento.setLimitacao(ELimiteCasas.DOIS);
	}
	
	public List<String> listaMovimentosPossiveis(Tabuleiro t, Peca p) {
		return this.estrategiaMovimento.movePool(t, p);
	}
	
	public void modificaLimitaçãoEstrategia(ELimiteCasas l) {
		this.estrategiaMovimento.setLimitacao(l);
	}
        
        public void setStrategyMoveInterface(StrategyMoveInterface strategy){
            this.estrategiaMovimento = strategy;
        }
        
        public void seLimitacao(ELimiteCasas limite){
            this.estrategiaMovimento.setLimitacao(limite);
        }
}

// PRECISA DECIDIR COMO FAZER PARA RETIRAR AS POSICOES QUE A COR DO PEAO NÃO PERMITE
