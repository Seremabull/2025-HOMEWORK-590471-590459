package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	
	@Override
	public void esegui(Partita partita) {
		
		partita.getIo().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		partita.getIo().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		partita.getIo().mostraMessaggio(partita.getGiocatore().toString());
		
		
	}

	@Override
	public void setParametro(String parametro) {
		
	}

	@Override
	public String getNome() {
		return "guarda";
	}

	@Override
	public String getParametro() {
		return null;
	}

}
