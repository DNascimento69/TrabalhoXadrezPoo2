package p2o2.ifes.serra.comando;

import java.util.LinkedList;
import java.util.List;

import p2o2.ifes.serra.model.Enum.ELimiteCasas;
import p2o2.ifes.serra.model.Enum.EPecaMoveu;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.model.cdp.Tabuleiro;
import p2o2.ifes.serra.strategy.StrategyMoveInterface;

public abstract class ComandoPeao implements ComandoMovimento {

	private LinkedList<StrategyMoveInterface> movimentos = new LinkedList<StrategyMoveInterface>();
	 
		public ComandoPeao() {
			//this.estrategiaMovimento.setLimitacao(ELimiteCasas.DOIS);
		}
	
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
		public List<String> listaMovimentosPossiveis(Tabuleiro t, Peca p){
			List<String> movimentosPossiveis = new LinkedList<String>();
		
			if(p.getPecaMoveu().equals(EPecaMoveu.sim)){
				this.modificaLimitaçãoEstrategia(ELimiteCasas.UM);
			}
			
			for(StrategyMoveInterface m: movimentos) {
				movimentosPossiveis.addAll( m.movePool(t, p));
			}
			return movimentosPossiveis;
		}
<<<<<<< HEAD
=======
	
		public void modificaLimitaçãoEstrategia(ELimiteCasas l) {
			this.movimentos.get(0).setLimitacao(l);
		}
        
        public void setStrategyMoveInterface(StrategyMoveInterface strategy){
            this.movimentos.add(strategy);
        }
        
        public void setLimitacao(ELimiteCasas limite,int index){
            this.movimentos.get(index).setLimitacao(limite);
=======
        
	public ComandoPeao() {
		//this.estrategiaMovimento.setLimitacao(ELimiteCasas.DOIS);
	}
	
	public List<String> listaMovimentosPossiveis(Tabuleiro t, Peca p) {
		return this.estrategiaMovimento.movePool(t, p);
	}
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
	
		public void modificaLimitaçãoEstrategia(ELimiteCasas l) {
			this.movimentos.get(0).setLimitacao(l);
		}
        
        public void setStrategyMoveInterface(StrategyMoveInterface strategy){
            this.movimentos.add(strategy);
        }
        
<<<<<<< HEAD
        public void setLimitacao(ELimiteCasas limite,int index){
            this.movimentos.get(index).setLimitacao(limite);
=======
        public void seLimitacao(ELimiteCasas limite){
            this.estrategiaMovimento.setLimitacao(limite);
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
        }
}

// PRECISA DECIDIR COMO FAZER PARA RETIRAR AS POSICOES QUE A COR DO PEAO NÃO PERMITE
