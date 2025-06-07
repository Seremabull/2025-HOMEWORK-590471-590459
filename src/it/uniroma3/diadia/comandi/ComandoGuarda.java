package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {

	
	@Override
	public void esegui(Partita partita) {
		
		partita.getIo().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		partita.getIo().mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		partita.getIo().mostraMessaggio(partita.getGiocatore().toString());
		partita.getIo().mostraMessaggio(partita.getGiocatore().getBorsa().getContenutoOrdinatoPerPeso().toString());
		partita.getIo().mostraMessaggio(partita.getGiocatore().getBorsa().getContenutoOrdinatoPerNome().toString());
		
	}

	@Override
	public void setParametro(String parametro) {
		
	}

	@Override
	public String getNome() {
		return "guarda";
	}


}
