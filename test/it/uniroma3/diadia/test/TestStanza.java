package it.uniroma3.diadia.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanza {

	private Stanza stanza1;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	
	@Before
	public void setUp() {
		stanza1=new Stanza("n11");
		attrezzo1= new Attrezzo("ascia", 4);
		attrezzo2= new Attrezzo("corda", 1);
	}
	
	
	@Test
	public void testUnaStanzaAdiacente() {
		Stanza stanza2=new Stanza("n10");
		stanza2.impostaStanzaAdiacente("nord", stanza1);
		
		assertEquals(stanza1,stanza2.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testAggiuntaUnAttrezzo() {
		stanza1.addAttrezzo(attrezzo1);
		assertTrue(stanza1.hasAttrezzo("ascia"));
	}
	
	@Test
	public void testNonAggiuntaAttrezzoStanzaPiena() {
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo1);
		
		assertFalse(stanza1.addAttrezzo(attrezzo2));
	}
	
	@Test
	public void testRicercaAttrezzoEsistente() {
		stanza1.addAttrezzo(attrezzo1);
		
		assertEquals(attrezzo1,stanza1.getAttrezzo("ascia"));
	}
	
	@Test
	public void testRicercaAttrezzoNonEsistente() {
		stanza1.addAttrezzo(attrezzo1);
		
		assertEquals(null,stanza1.getAttrezzo("corda"));
	}
	
	@Test
	public void tesGetAttrezzi() {
		stanza1.addAttrezzo(attrezzo1);
		stanza1.addAttrezzo(attrezzo2);
		
		assertEquals("ascia",stanza1.getAttrezzi()[0].getNome());
		assertEquals("corda",stanza1.getAttrezzi()[1].getNome());
	}
	

}
