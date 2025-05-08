package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{

	
	private String attrezzoBuio="candela";
	
	
	public StanzaBuia(String nome, String attrezzoBuio) {
		super(nome);
		this.attrezzoBuio=attrezzoBuio;
	}

	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoBuio))
			return super.getDescrizione();
		else
			return "qui c'è un buio pesto";
	}
}
