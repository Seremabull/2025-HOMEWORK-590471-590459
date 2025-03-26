package it.uniroma3.diadia.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

public class TestGiocatore {
	
	private Giocatore giocatore;
	private Borsa borsa;
	
	@Before
	public void setUp() {
		giocatore=new Giocatore();
		borsa=new Borsa();
	}

	@Test
	public void testCfuIniziali() {
		assertEquals(20,giocatore.getCfu());
	}
	
	@Test
	public void testGetSetCfu() {
		giocatore.setCfu(10);
		assertEquals(10,giocatore.getCfu());
	}
	
	@Test
	public void testGetSetBorsa() {
		giocatore.setBorsa(borsa);
		assertEquals(borsa,giocatore.getBorsa());
	}

}
