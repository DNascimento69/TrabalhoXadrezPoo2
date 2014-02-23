package p2o2.ifes.serra.model.cdp;

import p2o2.ifes.serra.model.Enum.EGameModeMenu;
import p2o2.ifes.serra.model.Enum.EGameStatus;
import p2o2.ifes.serra.model.Enum.EPlayerColor;
<<<<<<< HEAD
import p2o2.ifes.serra.model.cdp.reuse.Model;
import p2o2.ifes.serra.state.StateInterface;

public class Game extends Model {

	// <editor-fold defaultstate="collapsed" desc="Atributos">
	private int gameId;
=======
<<<<<<< HEAD
import p2o2.ifes.serra.model.cdp.reuse.Model;
=======
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
import p2o2.ifes.serra.state.StateInterface;

public class Game extends Model{
	
<<<<<<< HEAD
	// <editor-fold defaultstate="collapsed" desc="Atributos">
    private int gameId;
	private Jogador jogador1;
	private Jogador jogador2;
	private Tabuleiro tabuleiro;
    private EGameStatus statusGame;
	private EGameModeMenu gameMode;
    private int jogadorVencendorId = 0;
    private EPlayerColor jogadorDaVez;
    private StateInterface myState;
	// </editor-fold>
    	
	// <editor-fold defaultstate="collapsed" desc="GetSeters">
    public int getID() {
		return this.gameId;
	}

=======
        private int gameId;
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
	private Jogador jogador1;
	private Jogador jogador2;
	private Tabuleiro tabuleiro;
	private EGameStatus statusGame;
	private EGameModeMenu gameMode;
	private int jogadorVencendorId = 0;
	private EPlayerColor jogadorDaVez;
	private StateInterface myState;
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="GetSeters">
	public int getID() {
		return this.gameId;
	}

<<<<<<< HEAD
	public void setID(int ID) {
		this.gameId = ID;
	}

	public void setState(StateInterface newState) {
		myState = newState;
	}

	public int getJogadorDaVez() {
=======

>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
	public void setID(int ID) {
		this.gameId = ID;
	}
	
<<<<<<< HEAD
    public void setState(StateInterface newState) {
            myState = newState;
        }
        
    public int getJogadorDaVez() {
=======
        public void setState(StateInterface newState) {
            myState = newState;
        }
        
        public int getJogadorDaVez() {
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
		return jogadorDaVez.getValue();
	}

	public void setJogadorDaVez(EPlayerColor jogadorCor) {
		this.jogadorDaVez = jogadorCor;
	}
<<<<<<< HEAD

	public int getGameStatus() {
=======
        
<<<<<<< HEAD
    public int getGameStatus() {
=======
        public int getGameStatus() {
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
		return statusGame.getValue();
	}

	public void setGameStatus(EGameStatus gameStatus) {
		this.statusGame = gameStatus;
	}
<<<<<<< HEAD

	public int getJogadorVencendorId() {
=======
        
<<<<<<< HEAD
    public int getJogadorVencendorId() {
=======
        public int getJogadorVencendorId() {
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
		return jogadorVencendorId;
	}

	public void setJogadorVencendorId(int idVencendor) {
		this.jogadorVencendorId = idVencendor;
	}

	public Jogador getJogador1() {
		return jogador1;
	}

	public void setJogador1(Jogador jogador1) {
		this.jogador1 = jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	public void setJogador2(Jogador jogador2) {
		this.jogador2 = jogador2;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
<<<<<<< HEAD

=======
	
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
<<<<<<< HEAD
	
		public EGameStatus getStatusGame() {
		return statusGame;
	}

	public void setStatusGame(EGameStatus statusGame) {
		this.statusGame = statusGame;
	}

	public EGameModeMenu getGameMode() {
		return gameMode;
	}

	public void setGameMode(EGameModeMenu gameMode) {
		this.gameMode = gameMode;
	}
=======

<<<<<<< HEAD
	public EGameStatus getStatusGame() {
		return statusGame;
	}

	public void setStatusGame(EGameStatus statusGame) {
		this.statusGame = statusGame;
	}

	public EGameModeMenu getGameMode() {
		return gameMode;
	}

	public void setGameMode(EGameModeMenu gameMode) {
		this.gameMode = gameMode;
	}

=======
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
	
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
	@Override
	public String toString() {
		return "Game [jogador1=" + jogador1 + ", jogador2=" + jogador2
				+ ", tabuleiro=" + tabuleiro
				+ "]";
	}
// </editor-fold>
<<<<<<< HEAD

	// <editor-fold defaultstate="collapsed" desc="Processamento">
	public boolean jogada(String posicao, EPlayerColor cor) {
		return this.tabuleiro.jogada(posicao, cor);
	}

	public boolean jogada(Game game, String posicao) {
		return this.tabuleiro.jogada(game, posicao);
	}

//	public void imprimeTabuleiro() {
//		Peca[][] matriz = this.getTabuleiro().getMatrixTabuleiro();
//		Peca peca;
//		System.out.println("Legenda:");
//		System.out.println("E - Pião, K - Rei, Q - Rainha, C - Cavalo, I - Bispo, T - Torre");
//		System.out.println("P - Preto, B - Branco");
//		System.out.println(" ");
//
//		for (int row = 0; row < matriz.length; row++) {
//			for (int column = 0; column < matriz.length; column++) {
//				if (matriz[row][column] != null) {
//					peca = matriz[row][column];
//					System.out.print(peca.toString() + " ");
//				} else {
//					System.out.print(" - ");
//				}
//			}
//			System.out.println();
//		}
//	}
=======
	
	// <editor-fold defaultstate="collapsed" desc="Processamento">
	
	public boolean jogada(String posicao, EPlayerColor cor){
		return this.tabuleiro.jogada(posicao, cor);
	}
	
	public void imprimeTabuleiro()
	{
		 Peca[][] matriz = this.getTabuleiro().getMatrixTabuleiro();
                 Peca peca;
                  System.out.println("Legenda:");
                  System.out.println("E - Pião, K - Rei, Q - Rainha, C - Cavalo, I - Bispo, T - Torre");
                  System.out.println("P - Preto, B - Branco");
                  System.out.println(" ");
		 
		for (int row = 0; row < matriz.length; row++) {
		        for (int column = 0; column < matriz.length; column++) {
		        	if(matriz[row][column] != null){
                                    peca = matriz[row][column];
                                    System.out.print(peca.toString() + " ");
                                }
                                else{
                                    System.out.print(" - ");
                                }                              
		    }
		    System.out.println();
		}
	}
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
	// </editor-fold>
}
