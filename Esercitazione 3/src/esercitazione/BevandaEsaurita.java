package esercitazione;

public class BevandaEsaurita extends Exception {
	
	public BevandaEsaurita() {
		super();
	}
	
	public BevandaEsaurita(String reason) {
		super(reason);
	}

}
