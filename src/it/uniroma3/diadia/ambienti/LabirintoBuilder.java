package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {

	private Labirinto labirinto = new Labirinto();
	private HashMap<String, Stanza> listaStanze = new HashMap<>();
	private Stanza ultimaStanza;

	private Stanza getOrCreateStanza(String nome) {
		if (!listaStanze.containsKey(nome))
			listaStanze.put(nome, new Stanza(nome));
		return listaStanze.get(nome);
	}

	public LabirintoBuilder addStanzaIniziale(String nome) {
		this.ultimaStanza = getOrCreateStanza(nome);
		this.labirinto.setStanzaCorrente(this.ultimaStanza);
		return this;
	}

	public LabirintoBuilder addStanzaVincente(String nome) {
		this.ultimaStanza = getOrCreateStanza(nome);
		this.labirinto.setStanzaVincente(this.ultimaStanza);
		return this;
	}

	public LabirintoBuilder addStanza(String nome) {
		this.ultimaStanza = getOrCreateStanza(nome);
		return this;
	}

	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
		if (this.ultimaStanza != null)
			this.ultimaStanza.addAttrezzo(new Attrezzo(nomeAttrezzo, peso));
		return this;
	}

	public LabirintoBuilder addAdiacenza(String da, String a, String direzione) {
		Stanza stanzaDa = getOrCreateStanza(da);
		Stanza stanzaA = getOrCreateStanza(a);
		stanzaDa.impostaStanzaAdiacente(direzione, stanzaA);
		return this;
	}

	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	public HashMap<String, Stanza> getListaStanze() {
		return this.listaStanze;
	}
}
