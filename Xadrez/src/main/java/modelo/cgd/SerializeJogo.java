package modelo.cgd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import modelo.cdp.Jogo;

public class SerializeJogo {

	public static void incluirJogo(Jogo jogo) {
		LinkedList<Jogo> jogos = getJogos();
		jogos.add(jogo);
		
		try {
			FileOutputStream fo = new FileOutputStream("Jogos.ser");
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			oo.writeObject(jogos);
			oo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static LinkedList<Jogo> getJogos() {
		LinkedList<Jogo> jogos = null;
		
		try {
			FileInputStream fi = new FileInputStream("Jogos.ser");
			ObjectInputStream oi = new ObjectInputStream(fi);
			jogos = (LinkedList<Jogo>) oi.readObject();
			oi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jogos;
	}
}
