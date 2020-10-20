package esercitazione;

public class TesseraDiCredito {
	
	private int codice;
	private float credito;
	

	public TesseraDiCredito(int codice, float credito) {
		super();
		this.codice = codice;
		this.credito = credito;
	}

	public float getCredito() {
		return credito;
	}

	public int getCodice() {
		return codice;
	}

	public void reduceCredito(float credito) {
		this.credito -= credito;
	}
	

}

