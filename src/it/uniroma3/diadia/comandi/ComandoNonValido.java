package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando {


	
	@Override
	public void esegui(Partita partita) {
		partita.getIo().mostraMessaggio("comando sconosciuto");

	}

	@Override
	public void setParametro(String parametro) {

	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "sconosciuto";
	}


}
