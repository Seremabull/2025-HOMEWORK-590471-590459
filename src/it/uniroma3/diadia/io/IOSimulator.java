package it.uniroma3.diadia.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.uniroma3.diadia.IO;

public class IOSimulator implements IO {
    private List<String> comandi;
    private List<String> messaggi;
    private Map<String, List<String>> traccia;
    private int indiceComando;

    public IOSimulator(List<String> comandi) {
        this.comandi = comandi;
        this.messaggi = new ArrayList<>();
        this.traccia = new HashMap<>();
        this.indiceComando = 0;
    }

    @Override
    public void mostraMessaggio(String messaggio) {
        messaggi.add(messaggio);
        if (indiceComando > 0 && indiceComando <= comandi.size()) {
            String comandoCorrente = comandi.get(indiceComando - 1);
            if (!traccia.containsKey(comandoCorrente)) {
                traccia.put(comandoCorrente, new ArrayList<String>());
            }
            traccia.get(comandoCorrente).add(messaggio);
        }
    }

    @Override
    public String leggiRiga() {
        if (indiceComando < comandi.size()) {
            String comando = comandi.get(indiceComando);
            indiceComando++;
            return comando;
        }
        return null;
    }

    public List<String> getMessaggi() {
        return this.messaggi;
    }

    public Map<String, List<String>> getTraccia() {
        return this.traccia;
    }
}
