package esercitazione;

import java.util.Vector;
import java.util.ArrayList;

public class Distributore {
	
	Vector<Bevanda> storage = new Vector<Bevanda>();
	Vector<TesseraDiCredito> tessere = new Vector<TesseraDiCredito>();
	ArrayList<ColonnaDistributore> colonne = new ArrayList<ColonnaDistributore>(4);
	
	public Distributore() {
		
		Bevanda acqua, coca, birra;
		
		for (int i = 0; i < 4; i++) {
			colonne.add(new ColonnaDistributore()); 
		}
		
		acqua = aggiungiBevanda("Acqua", 0.20f);
		coca = aggiungiBevanda("Coca", 0.30f);
		birra = aggiungiBevanda("Birra", 1.00f);
		caricaTessera(12, 5.5f);
		caricaTessera(21, 10.0f);
		caricaTessera(99, 0.75f);
		aggiornaColonna(0, acqua , 40);
		aggiornaColonna(1, coca, 1);
		aggiornaColonna(2, birra, 50);
		aggiornaColonna(3, acqua, 50);
	}
	
	Bevanda aggiungiBevanda(String nome, float prezzo) {
		Bevanda bevanda;
		char codice;
		if (storage.isEmpty())
			codice = 'A';
		else
			codice = (char)((int)storage.lastElement().getCodice() + 1);
		bevanda = new Bevanda(codice, nome, prezzo);
		storage.add(bevanda);
		return bevanda;
	}
	
	public String getName(char codice) {
		try{
			String nome = getBevanda(codice).getNome();
			return nome;
		}catch(BevandaNonValida e){
			System.out.println("codice non valido");
			return null;
		}
	}
	
	float getPrice(char codice){
		try{
			float prezzo = getBevanda(codice).getPrezzo();
			return prezzo;
		}catch(BevandaNonValida exc){
			System.out.println("Codice bevanda non valido");
			return -1;
		}
	}
	
	private Bevanda getBevanda(char codice) throws BevandaNonValida {
		for (Bevanda b : storage) {
			if (codice == b.getCodice())
				return b;
			
		}
		throw new BevandaNonValida();
		
	}
	
	public void caricaTessera (int codice, float credito) {
		tessere.add(new TesseraDiCredito (codice, credito));
	}
	
	float leggiCredito(int codice) {
		
		try{
			float credito = getTessera(codice).getCredito();
			return credito;
		}catch(TesseraNonValida exc){
			System.out.println("Codice tessera non valido");
			return -1;
		}
	}
	
	private TesseraDiCredito getTessera(int codice) throws TesseraNonValida {
		for (TesseraDiCredito t : tessere) {
			if (codice == t.getCodice())
				return t;
			
		}
		throw new TesseraNonValida();
		
	}
	
	void aggiornaColonna(int n, Bevanda bevanda, int lattine) {
		colonne.get(n).setBevanda(bevanda);
		colonne.get(n).setNumeroLattine(lattine);
	}
	
	int lattineDisponibili(char codice) {
		int count = 0;
		for (ColonnaDistributore colonna : colonne) {
			if (colonna.getBevanda().getCodice() == codice) {
				count += colonna.getNumeroLattine();
			}
		}
		return count;
	}


	public int eroga(char b, int t) throws CreditoInsufficente, BevandaEsaurita, BevandaNonValida, TesseraNonValida {
		Bevanda bevanda;
		TesseraDiCredito tessera;
		bevanda = getBevanda(b);
		tessera = getTessera(t);
		if (tessera.getCredito() < bevanda.getPrezzo())
			throw new CreditoInsufficente();
		if (lattineDisponibili(b) <= 0)
			throw new BevandaEsaurita();
		tessera.reduceCredito(bevanda.getPrezzo());
		for (int i = 0; i < colonne.size(); i++) {
			if (colonne.get(i).getBevanda().getCodice() == b) {
				colonne.get(i).reduceLattine();
				return i + 1; 
			}
		}	
		return -1;
	}
}
