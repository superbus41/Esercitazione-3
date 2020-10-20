package esercitazione;

public class Bevanda {
	
	private char codice;
	private String nome;
	private float prezzo;
	
	public Bevanda(char codice, String nome, float prezzo) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.prezzo = prezzo;
	}

	public char getCodice() {
		return codice;
	}

	public String getNome() {
		return nome;
	}

	public float getPrezzo() {
		return prezzo;
	}
	
	
}	
