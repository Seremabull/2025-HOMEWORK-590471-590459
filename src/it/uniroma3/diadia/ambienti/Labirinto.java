package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {
	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	public void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo spada = new Attrezzo("spada", 2);
		Attrezzo candela = new Attrezzo("candela", 1);
		Attrezzo chiave = new Attrezzo("chiave", 1);
		Attrezzo scala = new Attrezzo("scala", 1);
		Attrezzo palla = new Attrezzo("palla", 1);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		StanzaMagica aulaN9 = new StanzaMagica("Aula N9");
		StanzaBuia aulaStudio = new StanzaBuia("Aula Studio", "candela");
		StanzaBloccata aulaN12= new StanzaBloccata("AulaN12", "nord", "chiave");
		
		AbstractPersonaggio cane = new Cane("Vittorio", "Ciao sono Vittorio hai un osso per me?", palla);
		AbstractPersonaggio Strega = new Strega("Giovanna", "Ciao!!");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		aulaN9.impostaStanzaAdiacente("nord",aulaN11);
		aulaN11.impostaStanzaAdiacente("sud", aulaN9);
		aulaStudio.impostaStanzaAdiacente("sud", aulaN11);
		aulaN11.impostaStanzaAdiacente("nord", aulaStudio);
		aulaN12.impostaStanzaAdiacente("nord", laboratorio);
		laboratorio.impostaStanzaAdiacente("sud", aulaN12);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(scala);
		aulaN9.addAttrezzo(spada);
		aulaStudio.addAttrezzo(candela);
		atrio.addAttrezzo(chiave);
		atrio.addAttrezzo(osso);
		// il gioco comincia nell'atrio
        stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
		
		aulaN11.setPersonaggio(cane);
		aulaN12.setPersonaggio(Strega);
    }

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
	    this.stanzaVincente = stanzaVincente;
	}
}
