package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerAttrezzi;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Set<Attrezzo>attrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}


	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashSet<Attrezzo>(); // speriamo bastino...
	}


	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		return attrezzi.add(attrezzo);
	}


	public int getPesoMax() {
		return pesoMax;
	}


	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;

		Iterator<Attrezzo> it=attrezzi.iterator();
		if(nomeAttrezzo!=null)
			while(it.hasNext()) {
				attrezzoCercato=it.next();

				if(attrezzoCercato.getNome().equals(nomeAttrezzo)) {
					return attrezzoCercato;
				}else {
					attrezzoCercato=null;
				}
			}

		return attrezzoCercato;	
	}

	public int getPeso() {
		int peso = 0;
		Iterator<Attrezzo> it =this.attrezzi.iterator();
		while(it.hasNext()) {
			Attrezzo att =it.next();
			peso+=att.getPeso();
		}

		return peso;
	}


	public boolean isEmpty() {
		return attrezzi.isEmpty();
	}


	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}


	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a=null;
		if(nomeAttrezzo!=null) {
			if(this.hasAttrezzo(nomeAttrezzo)) {
				a= this.getAttrezzo(nomeAttrezzo);
				this.attrezzi.remove(a);
				return a;
			}
		}
		return a;
	}


	public String toString() {
		StringBuilder s = new StringBuilder();
		Iterator<Attrezzo> it =this.attrezzi.iterator();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");

			while(it.hasNext()) {
				s.append(it.next().toString()+" ");
			}
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

	
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		ArrayList<Attrezzo> ordinata = new ArrayList<Attrezzo>(attrezzi);

		ComparatorePerAttrezzi comp=new ComparatorePerAttrezzi();
		Collections.sort(ordinata,comp);
		return ordinata;
	}

	
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){

		SortedSet<Attrezzo> ordinata = new TreeSet<Attrezzo>(attrezzi);

		return ordinata;
	}
	
	
	
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		
		Map<Integer,Set<Attrezzo>> ordinata = new HashMap<Integer,Set<Attrezzo>>();
		Iterator<Attrezzo> it =this.attrezzi.iterator();
		Set<Attrezzo> tmp;
		Attrezzo att=null;
		
		while(it.hasNext()) {
			att=it.next();
			tmp=ordinata.get(att.getPeso());
			
			if(tmp==null) {
				tmp=new HashSet<Attrezzo>();
				ordinata.put(att.getPeso(), tmp);
			}
			tmp.add(att);
		}
		return ordinata;
	}
	

}
