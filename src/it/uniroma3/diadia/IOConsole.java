package it.uniroma3.diadia;

import java.util.Scanner;

public class IOConsole implements IO {

	private Scanner scannerDiLinee;
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
	
	public IOConsole(Scanner scannerDiLinee) {
		this.scannerDiLinee=scannerDiLinee;
	}
}
