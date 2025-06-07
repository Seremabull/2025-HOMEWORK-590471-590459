package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando{

	String nomeAttrezzo;

	
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo=partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);

		if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {

			partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			partita.getIo().mostraMessaggio("Attrezzo "+nomeAttrezzo+" posato nella stanza");

		}else {
			partita.getIo().mostraMessaggio("Attrezzo non presente nella borsa");
		}
		
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
		
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "posa";
	}

	
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
