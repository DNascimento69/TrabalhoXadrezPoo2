/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visao.cih;

import visao.util.ImageLoader;
import java.awt.Image;

/*
 Tipo das peças:
 Peão ------ 1
 Torre ----- 2
 Cavalo ---- 3
 Bispo ----- 4
 Rei ------- 5
 Rainha ---- 6
 */

//OBS.: Quando o X e o Y de uma peça são iguais a -1, significa que essa peça não está posicionada no tabuleiro. 

public class Peca {
	int xTabuleiro, yTabuleiro;
	int tipo;
	boolean cor;
	Image imagem;

	public Peca(int tipo, boolean cor) {
		this.xTabuleiro = -1;
		this.yTabuleiro = -1;
		this.tipo = tipo;
		this.cor = cor;
		setImagem(tipo);
	}

	public void setPosition(int xTabuleiro, int yTabuleiro) {
		this.xTabuleiro = xTabuleiro;
		this.yTabuleiro = yTabuleiro;
	}

	public void setImagem(int tipo) {
		this.imagem = ImageLoader.LoadImage("Pecas/" + tipo + ".png");
	}

	public Image getImagem() {
		return this.imagem;
	}
}
