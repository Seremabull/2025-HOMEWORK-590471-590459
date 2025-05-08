package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 20;
	
	private Labirinto labirinto=new Labirinto();
	private Giocatore giocatore=new Giocatore();
	private boolean finita;
	private int cfu;
	private IO io;
	
	public Partita(IO io){
		labirinto.creaStanze();
		this.finita = false;
		this.cfu = CFU_INIZIALI;
		this.io=io;
	}

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
    
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (cfu == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	public Labirinto getLabirinto() {
		return labirinto;
	}


	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	
	public Giocatore getGiocatore() {
		return giocatore;
	}


	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public boolean giocatoreIsVivo() {
		if(giocatore.getCfu()>0)
			return true;
		return false;
	}
	
	public Stanza getStanzaCorrente() {
		return this.getLabirinto().getStanzaCorrente();
	}
	
	public void setStanzaCorrente(Stanza stanza) {
		this.labirinto.setStanzaCorrente(stanza);
	}
	
	public IO getIo() {
		return io;
	}
}
