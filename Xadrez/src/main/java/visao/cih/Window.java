package visao.cih;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Window extends JFrame {
	Dimension screenSize;
	Tabuleiro tabuleiro;
	Validador validador;

	public Window() {
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);

		validador = new Validador();
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		tabuleiro = new Tabuleiro(validador);

		setSize(1087, 700);
		setLocation((screenSize.width / 2) - (1087 / 2),
				(screenSize.height / 2) - (704 / 2));
		add(tabuleiro);
		setVisible(true);
	}
}
