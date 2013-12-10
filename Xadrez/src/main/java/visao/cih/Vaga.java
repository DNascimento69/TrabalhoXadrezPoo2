package visao.cih;

import javax.swing.JLabel;

public class Vaga extends JLabel {
	
	int x, y;
	Peca peca;
	PainelImagem painelImagem;

	public Vaga(int x, int y) {
		this.x = x;
		this.y = y;
		setSize(52, 52);
		setLocation(x, y);
		painelImagem = new PainelImagem(52, 52, 0, 0);
		add(painelImagem);
		setPeca(null);
	}

	public void setPeca(Peca peca) {
		Peca tmp = this.peca;
		this.peca = peca;

		if (this.peca != null) {
			painelImagem.setImagem(peca.getImagem());
			painelImagem.setVisible(true);
		}
		repaint();
	}

	public Peca getPeca() {
		return this.peca;
	}

	public Peca removerPeca() {
		Peca tmp = this.peca;
		this.peca = null;
		painelImagem.setVisible(false);
		repaint();
		return tmp;
	}
}
