package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando{

	String nomeAttrezzo;


	@Override
	public void esegui(Partita partita) {

		if(this.nomeAttrezzo == null) {
			partita.getIo().mostraMessaggio("Cosa vuoi prendere? Specifica un attrezzo");
			return;
		}

		Attrezzo attrezzo=partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);

		if(attrezzo == null) {
			partita.getIo().mostraMessaggio("Attrezzo " + nomeAttrezzo + " inesistente nella stanza");
			return;
		}

		int pesoBorsa=partita.getGiocatore().getBorsa().getPeso();
		int pesoMax=partita.getGiocatore().getBorsa().getPesoMax();
		int pesoAttrezzo=attrezzo.getPeso();


		if(pesoBorsa+pesoAttrezzo<= pesoMax) {
			if(partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo)) {
				if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {

					partita.getIo().mostraMessaggio("Attrezzo "+nomeAttrezzo+ " aggiunto nella borsa");
					//partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzo);

				}else {
					partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
					partita.getIo().mostraMessaggio("Spazio nella borsa insufficente");
				}

			}
		}else {
			partita.getIo().mostraMessaggio("Spazio nella borsa insufficente");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "prendi";
	}

	
	public String getParametro() {
		// TODO Auto-generated method stub
		return this.nomeAttrezzo;
	}

}
