package p2o2.ifes.serra.model.cdp;

import java.util.List;
import p2o2.ifes.serra.comando.ComandoMovimento;
<<<<<<< HEAD
import p2o2.ifes.serra.model.Enum.EPecaMoveu;
=======
<<<<<<< HEAD
import p2o2.ifes.serra.model.Enum.EPecaMoveu;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.Enum.EStatusPeca;
import p2o2.ifes.serra.model.cdp.reuse.Model;

public class Peca extends Model{
	
	// <editor-fold defaultstate="collapsed" desc="Atributos">
	private int valor;
	public String posicao;
	public EPlayerColor cor;
    private EStatusPeca statusPeca;
	protected String pecaId;
    private ComandoMovimento comando;
    private int idGame;
	private EPecaMoveu moveu;
	// </editor-fold>
	
	// <editor-fold defaultstate="collapsed" desc="GetSeters">
=======
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.Enum.EStatusPeca;
import p2o2.ifes.serra.model.cdp.reuse.Model;

public class Peca extends Model{
	
	// <editor-fold defaultstate="collapsed" desc="Atributos">
	private int valor;
	public String posicao;
	public EPlayerColor cor;
    private EStatusPeca statusPeca;
	protected String pecaId;
    private ComandoMovimento comando;
    private int idGame;
	private EPecaMoveu moveu;
	// </editor-fold>
	
<<<<<<< HEAD
	// <editor-fold defaultstate="collapsed" desc="GetSeters">
=======
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
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
        
<<<<<<< HEAD
    public EStatusPeca getStatusPeca() {
=======
<<<<<<< HEAD
    public EStatusPeca getStatusPeca() {
=======
	public EStatusPeca getStatusPeca() {
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
		return this.statusPeca;
	}

	public void setStatusPeca(EStatusPeca status) {
		this.statusPeca = status;
	}
<<<<<<< HEAD
	
	public EPecaMoveu getPecaMoveu() {
		return this.moveu;
	}

	public void setPecaMoveu(EPecaMoveu semoveu) {
		this.moveu = semoveu;
	}
=======
<<<<<<< HEAD
	
	public EPecaMoveu getPecaMoveu() {
		return this.moveu;
=======
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f

	@Override
	public String toString() {
		return  this.pecaId;
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
	}

	public void setPecaMoveu(EPecaMoveu semoveu) {
		this.moveu = semoveu;
	}
<<<<<<< HEAD
=======

	@Override
	public String toString() {
		return  this.pecaId;
	}
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
// </editor-fold>
	
	
	
	public List<String> listaMovimentosPossiveisPeca(Tabuleiro tabuleiro) {
		return comando.listaMovimentosPossiveis(tabuleiro, this);
	}
}
