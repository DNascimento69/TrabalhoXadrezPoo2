package p2o2.ifes.serra.factory;

import p2o2.ifes.serra.comando.*;
<<<<<<< HEAD
import p2o2.ifes.serra.model.Enum.EPecaMoveu;
=======
<<<<<<< HEAD
import p2o2.ifes.serra.model.Enum.EPecaMoveu;
=======
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
import p2o2.ifes.serra.model.Enum.EPlayerColor;
import p2o2.ifes.serra.model.Enum.ETipoPeca;
import p2o2.ifes.serra.model.cdp.Peca;

public class PecaFactory {

	public Peca getPiece(ETipoPeca tipo,EPlayerColor cor,int idGame) {
		Peca peca = new Peca();
		peca.setCor(cor);
		peca.setIdGame(idGame);
<<<<<<< HEAD
		peca.setPecaMoveu(EPecaMoveu.nao);
=======
<<<<<<< HEAD
		peca.setPecaMoveu(EPecaMoveu.nao);
=======
>>>>>>> 98b622ac6a937b99e3abb6f27c714209a591704d
>>>>>>> b47a549e1b4abe0cdef5726e9654d54b6c3bb35f
                
		switch(tipo){
			case Torre:
				peca.setPecaId(this.getPecaId(tipo, cor));
                                peca.setComando(new ComandoTorre());
				return peca;
			case Bispo:
				peca.setPecaId(this.getPecaId(tipo, cor));
                                peca.setComando(new ComandoBispo());
				return peca;
			case Cavalo:
				peca.setPecaId(this.getPecaId(tipo, cor));
                                peca.setComando(new ComandoCavalo());
				return peca;
			case Rainha:
				peca.setPecaId(this.getPecaId(tipo, cor));
                                peca.setComando(new ComandoRainha());
				return peca;
			case Rei:
				peca.setPecaId(this.getPecaId(tipo, cor));
                                peca.setComando(new ComandoRei());
				return peca;
			default:
				peca.setPecaId(this.getPecaId(tipo, cor));
                                if(cor.equals(EPlayerColor.black)){
                                    peca.setComando(new ComandoPeaoPreto());
                                }
                                else{
                                     peca.setComando(new ComandoPeaoBranco());
                                }
				return peca;
		}
	}
	
	protected String getPecaId(ETipoPeca tipo,EPlayerColor cor){
		String corPeca = cor == EPlayerColor.black? "P": "B";
		
		switch(tipo){
			case Torre:
				return "T"+corPeca;
			case Bispo:
				return "I"+corPeca;
			case Cavalo:
				return "C"+corPeca;
			case Rainha:
				return "Q"+corPeca;
			case Rei:
				return "k"+corPeca;
			default:
				return "E"+corPeca;
		}
		
	}
}
