package p2o2.ifes.serra.model.cdp;

import java.util.List;
import p2o2.ifes.serra.comando.ComandoMovimento;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.Enum.EStatusPeca;

public class Peca {

	private int valor;
	public String posicao;
	public EPlayerColor cor;
	private EStatusPeca statusPeca;
	protected String pecaId;
	private ComandoMovimento comando;
	private int idGame;
		
	public List<String> listaMovimentosPossiveisPeca(Tabuleiro tabuleiro) {
		return comando.listaMovimentosPossiveis(tabuleiro, this);
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
        
        public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int valor) {
		this.idGame = valor;
	}
        
        public ComandoMovimento getComando() {
		return comando;
	}

	public void setComando(ComandoMovimento comandoNovo) {
		this.comando = comandoNovo;
	}
        
	public String getPecaId() {
		return pecaId;
	}

	public void setPecaId(String pecaId) {
		this.pecaId = pecaId;
	}

	public int getPontuacao() {
		return this.valor;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public EPlayerColor getCor() {
		return cor;
	}

	public void setCor(EPlayerColor cor) {
		this.cor = cor;
	}
        
	public EStatusPeca getStatusPeca() {
		return this.statusPeca;
	}

	public void setStatusPeca(EStatusPeca status) {
		this.statusPeca = status;
	}

	@Override
	public String toString() {
		return  this.pecaId;
	}

}
