package p2o2.ifes.serra.util;

import java.util.Scanner;

// Classe retirada do exemplo CalculadoraMVC do professor Paulo Sergio Santos Junior
public class LeitorUtil {
	
	private static Scanner leitorOpcao = new Scanner(System.in);
	
	public static Integer lervalorInteiro() {
		 
		return  leitorOpcao.nextInt();
	}

	public static Double lervalorDouble() {
		 
		return leitorOpcao.nextDouble();
	}
	
	// Função adicionada ao original
	public static String lervalorString() {
		return leitorOpcao.next();
	}
	
}
