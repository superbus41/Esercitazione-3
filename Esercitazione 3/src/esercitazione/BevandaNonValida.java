package esercitazione;

public class BevandaNonValida extends Exception {

	public BevandaNonValida() {
		super();
	}
	
	public BevandaNonValida(String reason) {
		super(reason);
	}

}
