package it.uniroma3.diadia.test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class TestBorsa {
	
	private Attrezzo attrezzo;
	private Borsa borsa;
	private Attrezzo attrezzo2;
	
	@Before
	public void setUp() {
		borsa= new Borsa();
		attrezzo= new Attrezzo("sasso",3);
		}

	@Test
	public void testAaggiuntaAttrezzo() {
		borsa.addAttrezzo(attrezzo);
		assertEquals(attrezzo,borsa.getAttrezzo(attrezzo.getNome()));
		}
	@Test
	public void testBorsaPiena() {
		attrezzo=new Attrezzo("spada",10);
		attrezzo2=new Attrezzo("cipolla",1);
		borsa.addAttrezzo(attrezzo);
		assertFalse(borsa.addAttrezzo(attrezzo2));
		
	}
	@Test
	public void testBorsaVuota(){
		borsa.addAttrezzo(attrezzo);
		borsa.removeAttrezzo(attrezzo.getNome());
		assertTrue(borsa.isEmpty());
		
	}
	@Test
	public void testRimuoviAttrezzo() {
		attrezzo2=new Attrezzo("cipolla",1);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo2);
		borsa.removeAttrezzo(attrezzo2.getNome());
		assertTrue(borsa.hasAttrezzo(attrezzo.getNome()));
		assertFalse(borsa.hasAttrezzo(attrezzo2.getNome()));
	}

}
