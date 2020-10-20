package esercitazione;

public class CreditoInsufficente extends Exception {
	
	public CreditoInsufficente() {
		super();
	}
	
	public CreditoInsufficente(String reason) {
		super(reason);
	}

}
