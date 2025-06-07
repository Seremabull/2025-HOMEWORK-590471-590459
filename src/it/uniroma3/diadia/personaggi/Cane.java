package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_CANE = "Bau Rrrr (-1 CFU)";
			
	public Cane() {
		super();
	}

	public Cane(String nome, String presentaz, Attrezzo attrezzo) {
		super(nome, presentaz);
		this.setAttrezzo(new Attrezzo("palla",1));
	}

	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return MESSAGGIO_CANE;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		
		if(attrezzo.getNome().equals("osso")) {
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			return " *scondinzola* ";
		}
		else {
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}
		return " *ti morde* ";
	}

}
