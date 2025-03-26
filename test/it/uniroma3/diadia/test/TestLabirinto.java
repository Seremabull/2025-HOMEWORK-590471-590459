package it.uniroma3.diadia.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class TestLabirinto {
	
	
	private Labirinto labirinto;
	private Stanza stanza;

	@Before
	public void setUp() {
		labirinto= new Labirinto();
	}
	
	@Test
	public void testStanzaVincente() {
		labirinto.creaStanze();
		assertEquals("Biblioteca",labirinto.getStanzaVincente().getNome());
	}
	@Test
	public void testStanzaCorrente() {
		labirinto.creaStanze();
		assertEquals("Atrio",labirinto.getStanzaCorrente().getNome());
	}
	@Test
	public void testSetStanzaCorrente () {
		stanza= new Stanza("n11");
		labirinto.setStanzaCorrente(stanza);
		assertEquals(stanza,labirinto.getStanzaCorrente());
	}

}
