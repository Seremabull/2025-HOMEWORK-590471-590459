package it.uniroma3.diadia.personaggi;

import java.util.Map;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoVai;

public class Strega extends AbstractPersonaggio {

	private static final String MESSAGGIO_SALUTO = "Ciao! Ti portero in una stanza piena di attrezzi";
	private static final String MESSAGGIO_NONSALUTO = "Finirai in una stanza vuota!!";


	private boolean salutata;

	public Strega(){
		super();
	}

	public Strega(String nome, String presentaz) {
		super(nome, presentaz);

	}

	@Override
	public String agisci(Partita partita) {


		Map<String,Stanza>s =partita.getStanzaCorrente().getMapStanzeAdiacenti();
		String stanza=s.keySet().iterator().next();



		if(salutata) {


			if( s.get("nord")!=null && s.get("nord").getAttrezzi().size() > s.get(stanza).getAttrezzi().size() ) {
				stanza="nord";
			}

			if( s.get("sud")!=null  && s.get("sud").getAttrezzi().size() > s.get(stanza).getAttrezzi().size()) {
				stanza="sud";
			}
			if( s.get("est")!=null   && s.get("est").getAttrezzi().size() > s.get(stanza).getAttrezzi().size()){
				stanza="est";
			}
			if( s.get("ovest")!=null  && s.get("ovest").getAttrezzi().size() > s.get(stanza).getAttrezzi().size()) {
				stanza="ovest";
			}


			ComandoVai c=new ComandoVai();
			c.setParametro(stanza);
			c.esegui(partita);

			return MESSAGGIO_SALUTO;



		}else {


			if( s.get("nord")!=null ) {
				stanza="nord";
			}

			if( s.get("sud")!=null && s.get("sud").getAttrezzi().size() < s.get(stanza).getAttrezzi().size()) {
				stanza="sud";
			}
			if( s.get("est")!=null && s.get("est").getAttrezzi().size() < s.get(stanza).getAttrezzi().size()){
				stanza="est";
			}
			if( s.get("ovest")!=null && s.get("ovest").getAttrezzi().size() < s.get(stanza).getAttrezzi().size()) {
				stanza="ovest";
			}


			ComandoVai c=new ComandoVai();
			c.setParametro(stanza);
			c.esegui(partita);

			return MESSAGGIO_NONSALUTO;
		}
	}

	public void setSalutata(boolean salutata) {
		this.salutata = salutata;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {

		this.setAttrezzo(attrezzo);
		return "HAHAHAHAH";
	}

}
