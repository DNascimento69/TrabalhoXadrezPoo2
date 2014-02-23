package p2o2.ifes.serra.comando;

import java.util.LinkedList;
import java.util.List;

import p2o2.ifes.serra.model.Enum.ELimiteCasas;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.cdp.Peca;
import p2o2.ifes.serra.model.cdp.Tabuleiro;
import p2o2.ifes.serra.strategy.StrategyMoveDiagonalBaixo;
import p2o2.ifes.serra.strategy.StrategyMoveDiagonalCima;
import p2o2.ifes.serra.strategy.StrategyMoveHorizontalDireita;
import p2o2.ifes.serra.strategy.StrategyMoveHorizontalEsquerda;
import p2o2.ifes.serra.strategy.StrategyMoveInterface;
import p2o2.ifes.serra.strategy.StrategyMoveVerticalBaixo;
import p2o2.ifes.serra.strategy.StrategyMoveVerticalCima;

public class ComandoRei implements ComandoMovimento {
	
	private LinkedList<StrategyMoveInterface> movimentos = new LinkedList<StrategyMoveInterface>();
	
	public ComandoRei() {
		this.movimentos.add(new StrategyMoveDiagonalCima());
		this.movimentos.add(new StrategyMoveDiagonalBaixo());
		this.movimentos.add(new StrategyMoveVerticalCima());
		this.movimentos.add(new StrategyMoveVerticalBaixo());
		this.movimentos.add(new StrategyMoveHorizontalDireita());
		this.movimentos.add(new StrategyMoveHorizontalEsquerda());
	}

	public List<String> listaMovimentosPossiveis(Tabuleiro tabuleiro, Peca peca) {
		List<String> movimentos = new LinkedList<String>();
		for(Object m: movimentos) {
			movimentos.addAll( ((StrategyMoveInterface)m).movePool(tabuleiro, peca) );
		}
		
		// Verificando se o Rei vai se aproximar do outro Rei
		boolean achou = false;
		String idRei;
		if(peca.getCor().equals(EPlayerColor.white)) {
			idRei = "KB";
		} else {
			idRei = "KP";
		}
		
		if(movimentos.size() > 0) {
			int reiPosX = Integer.parseInt(peca.getPosicao().substring(0, 1));
			int reiPosY = Integer.parseInt(peca.getPosicao().substring(0, 1));

			int x = 0;
			int y = 0;
			while (!achou) { // Só verifica se achou o outro rei por que nao é possivel um tabuleiro sem os dois reis
				while (!achou) {
					if (tabuleiro.getPecaPosicao(x, y).getPecaId().substring(0, 1).equalsIgnoreCase(idRei)) {
						int reiInimigoPosX = x;
						int reiInimigoPosY = y;

						Double distancia = Math.sqrt (Math.pow((reiInimigoPosX - reiPosX), 2) + Math.pow((reiInimigoPosY - reiPosY), 2));

						if (distancia < 3){ // se a distancia entre os reis, pertencer aos numeros reais e for menor que tres, é preciso verificar se o vetor de posiçoes esta "deixando" o Rei ir para um ponto "colado" ao Rei Inimigo
							for (int j = 0; j < movimentos.size(); j++) {

								int posX = Integer.parseInt(movimentos.get(j).substring(0, 1));
								int posY = Integer.parseInt(movimentos.get(j).substring(0, 1));

								distancia = Math.sqrt (Math.pow((reiInimigoPosX - posX), 2) + Math.pow((reiInimigoPosY - posY), 2));
								if (distancia < 2) { // se a distancia pertencer aos reais e for menor que dois entre as posiçoes testadas, o Rei se coloca em xeque nesta posição
									movimentos.remove(j); // esta posição deve ser removida da lista
									j--;

								}
							}
						}

						achou = true;
					}
					y++;
				}
				x++;
			}
		}
		
		// verificando todas as possibilidades de ataque do inimigo
		boolean retirou;
		
		if(movimentos.size() > 0) {
			int x = 0;
			int y = 0;
			
			List<Peca> listaPecas = null;
			if(peca.getCor().equals(EPlayerColor.white)) {
				listaPecas = tabuleiro.getPecasPretas();
			} else {
				listaPecas = tabuleiro.getPecasPretas();
			}
			
			List<String> listaPossibilidadesInimigo = new LinkedList<String>();
			for(Peca p: listaPecas) {
				listaPossibilidadesInimigo.addAll(p.listaMovimentosPossiveisPeca(tabuleiro));
			}
		
			while (x < movimentos.size()) {
				y = 0;
				retirou = false;
				
				while ((y < listaPossibilidadesInimigo.size()) && (!retirou)) {
					if (listaPossibilidadesInimigo.get(y).equalsIgnoreCase(movimentos.get(x))) { // verifica se nesta posição alguma peça poderia pegar o Rei
						movimentos.remove(x);
						retirou = true;
						x--; 
					}
					y++;
				}
				x++;
			}
		}
		
		return movimentos;
	}

	public void modificaLimitaçãoEstrategia(ELimiteCasas l) {
		for(Object m: movimentos) {
			((StrategyMoveInterface)m).setLimitacao(ELimiteCasas.UM);
		}
	}
}
