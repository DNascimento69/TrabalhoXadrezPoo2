package p2o2.ifes.serra.model.cdp;

import p2o2.ifes.serra.model.Enum.EPlayerColor;

public class Peca {
	private int valor;
	public String posicao;
	public EPlayerColor cor;
	
	
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

	//Metodo para clonar
	public Object clone() {
		Object clone = null;
	      try {
	         clone = super.clone();
	      } catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	      }
	      return clone;
	 }

}
