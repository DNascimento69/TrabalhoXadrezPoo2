package visao.cih;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class PainelImagem extends JPanel {
	Image imagem;

	public PainelImagem(int xSize, int ySize, int xLocation, int yLocation) {
		setLayout(null);
		setSize(xSize, ySize);
		setLocation(xLocation, yLocation);
		this.imagem = null;
		setVisible(false);
	}

    /*public PainelImagem(Image imagem)
    {
        setLayout(null);
        setSize(68, 68);
        setLocation(1, 1);        
        this.imagem = imagem;
        setVisible(true);
    }*/

	public void setImagem(Image imagem) {
		this.imagem = imagem;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(imagem, 0, 0, getWidth(), getHeight(), null);
	}
}

// public PainelImagem(int xSize, int ySize, int xLocation, int yLocation, int imageWidth, int imageHeight)
