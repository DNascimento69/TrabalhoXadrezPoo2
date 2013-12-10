package visao.cih;

import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Casa extends JLabel implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	int x, y, xTabuleiro, yTabuleiro;
	Boolean selecionada;
	Peca peca;
	PainelImagem painelImagem;
	Tabuleiro tabuleiro;
	private static final Border bordaMouseEmCima = BorderFactory.createLineBorder(Color.yellow, 2);
	private static final Border bordaSelecinada = BorderFactory.createLineBorder(Color.RED, 2);
	private static final Border bordaNada = null;

	// BorderFactory borderFactory;

	public Casa(int x, int y, int xTabuleriro, int yTabuleiro,
			Tabuleiro tabuleiro) {
		super();
		inicializar(x, y, xTabuleriro, yTabuleiro, tabuleiro);
		setPeca(null);
	}

	public Casa(int x, int y, int xTabuleriro, int yTabuleiro, Peca peca) {
		super();
		inicializar(x, y, xTabuleriro, yTabuleiro, tabuleiro);
		setPeca(peca);
	}

	private void inicializar(int x, int y, int xTabuleiro, int yTabuleiro,
			Tabuleiro tabuleiro) {
		this.x = x;
		this.y = y;
		this.xTabuleiro = xTabuleiro;
		this.yTabuleiro = yTabuleiro;
		this.tabuleiro = tabuleiro;
		selecionada = false;
		setSize(69, 69);
		setLocation(x, y);
		painelImagem = new PainelImagem(68, 68, 1, 1);
		add(painelImagem);
	}

	public Peca setPeca(Peca peca) {
		Peca tmp = this.peca;
		this.peca = peca;

		if (this.peca != null) {
			this.peca.setPosition(xTabuleiro, yTabuleiro);
			painelImagem.setImagem(peca.getImagem());
			painelImagem.setVisible(true);
		}
		repaint();
		return tmp;
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

	public boolean getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(boolean value) {
		selecionada = value;

		if (value)
			setBorder(bordaSelecinada);
		else
			setBorder(bordaNada);
	}

	public void mouseDragged(MouseEvent me) {
	}

	public void mouseMoved(MouseEvent me) {
		// Se não estiver selecionado
		if (!getSelecionada())
			// Se o mouse estiver em cima da casa
			if (estaEmMim(me)) {
				setBorder(bordaMouseEmCima);
			} else {
				setBorder(bordaNada);
			}
	}

	public void mouseClicked(MouseEvent me) {
	}

	public void mousePressed(MouseEvent me) {
		// Se não existir nenhuma casa selecionada e a casa onde o click
		// ocorreu não tiver peça. O método encerra.
		// if(estaEmMim(me))
		// if(getPeca() == null & tabuleiro.getCasaSelecionada() == null)
		// return;

		// Se não existir uma casa selecionada e o click tiver sido feito com o
		// botão esquerdo do mouse, está casa
		// será selecionada.
		if (tabuleiro.getCasaSelecionada() == null) {
			if ((me.getModifiers() & InputEvent.BUTTON3_MASK) == 0) {
				if (estaEmMim(me)) {
					if (tabuleiro.getValidador().validaSelecao(this)) {
						setSelecionada(true);
						tabuleiro.setCasaSelecionada(this);
					}
				}
			}
			// Se existir uma casa selecionada e o click tiver sido feito com o
			// botão esquerdo do mouse, o método mover peça da
			// classe tabuleiro será chamado, para mover a peça da casa
			// selecionada para esta casa.
		} else {
			if (tabuleiro.getCasaSelecionada() != this)
				if ((me.getModifiers() & InputEvent.BUTTON3_MASK) == 0) {
					if (estaEmMim(me)) {
						tabuleiro.getCasaSelecionada().setSelecionada(false);
						tabuleiro.moverPeca(tabuleiro.getCasaSelecionada(),
								this);
						tabuleiro.setCasaSelecionada(null);
					}
				}
		}

		if (tabuleiro.getCasaSelecionada() != null) {
			if ((me.getModifiers() & InputEvent.BUTTON1_MASK) == 0) {
				tabuleiro.getCasaSelecionada().setSelecionada(false);
				tabuleiro.setCasaSelecionada(null);
			}
		}
	}

	public void mouseReleased(MouseEvent me) {
	}

	public void mouseEntered(MouseEvent me) {
	}

	public void mouseExited(MouseEvent me) {
	}

	public boolean estaEmMim(MouseEvent me) {
		if (me.getX() > getX() & me.getX() < getX() + getWidth()
				& me.getY() > getY() & me.getY() < getY() + getHeight())
			return true;

		return false;
	}
}
