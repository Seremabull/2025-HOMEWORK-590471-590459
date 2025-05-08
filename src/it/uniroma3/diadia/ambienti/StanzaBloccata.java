package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{

	
private String attrezzoSblocca="chiave";
private String direzioneBloccata="nord";
	
	
	
	public StanzaBloccata(String nome,String direzione, String attrezzo) {
		super(nome);
		this.attrezzoSblocca=attrezzoSblocca;
		this.direzioneBloccata=direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		
		if(direzioneBloccata.equals(direzione)) {
			if(this.hasAttrezzo(attrezzoSblocca)) {
				return super.getStanzaAdiacente(direzione);
			}else {
				return this;
			}
		}else {
			return super.getStanzaAdiacente(direzione);
		}
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoSblocca))
			return super.getDescrizione();
		else
			return "Per andare nella direzione " +direzioneBloccata+ ",devi posare l'attrezzo " +attrezzoSblocca;
	}

}
