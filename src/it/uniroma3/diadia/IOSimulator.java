package it.uniroma3.diadia;

public class IOSimulator implements IO{

	private String[] righeDaLeggere;
    private String[] righeLette;
    private String[] messaggiMostrati;
    private int indice;
    private int countRigheLette;
    private int countMessaggiMostrati;

   
    public IOSimulator(String[] righe) {
        this.righeDaLeggere = righe;
        this.righeLette = new String[righe.length];
        this.messaggiMostrati = new String[righe.length +10];
        this.indice = 0;
        this.countRigheLette = 0;
        this.countMessaggiMostrati = 0;
    }
	
	
	@Override
	public void mostraMessaggio(String messaggio) {
		
		messaggiMostrati[countMessaggiMostrati]=messaggio;
		countMessaggiMostrati++;
		
	}

	@Override
	public String leggiRiga() {
		String riga;
		if(indice<righeDaLeggere.length) {
			
			riga=righeDaLeggere[indice];
			
		}else {
			riga=null;
		}
		
		righeLette[countRigheLette]=riga;
		countRigheLette++;
		indice++;
		
		return riga;
		
	}
	
	
	public String[] getRigheLette() {
		String[] totLette= new String[countRigheLette];
		for(int i=0;i<countRigheLette;i++) {
			totLette[i]=righeLette[i];
		}
		
		return totLette;
	}
	
	
	
	
	public String[] getmessaggiMostrati() {
        String[] totMostrati = new String[countMessaggiMostrati];
        for (int i = 0; i < countMessaggiMostrati; i++) {
            totMostrati[i] = messaggiMostrati[i];
        }
        return totMostrati;
    }

}
