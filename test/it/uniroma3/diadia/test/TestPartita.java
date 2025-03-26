package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class TestPartita {

	private Partita partita;
	private Stanza stanza;
	
	
	@Before
	public void setUp() {
		partita=new Partita();
		stanza=new Stanza("n11");
	}
	
	@Test
	public void testStanzaVincente() {
		assertEquals("Biblioteca",partita.getLabirinto().getStanzaVincente().getNome());
	}
	
	
	@Test
	public void testStanzaCorrenteDefault(){
		assertEquals("Atrio",partita.getLabirinto().getStanzaCorrente().getNome());
	}
	
	@Test
	public void testStanzaCorrenteCambiata(){
		partita.getLabirinto().setStanzaCorrente(stanza);
		assertEquals(stanza,partita.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testPartitaNonVinta() {
		partita.getLabirinto().setStanzaCorrente(stanza);
		assertFalse(partita.vinta());
	}

}
