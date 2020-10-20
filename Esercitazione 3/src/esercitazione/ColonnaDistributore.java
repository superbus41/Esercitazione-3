package esercitazione;

public class ColonnaDistributore {
	
	private Bevanda bevanda;
	private int numeroLattine;
	
	public ColonnaDistributore() {
		super();
	}

	public Bevanda getBevanda() {
		return bevanda;
	}

	public void setBevanda(Bevanda bevanda) {
		this.bevanda = bevanda;
	}

	public int getNumeroLattine() {
		return numeroLattine;
	}

	public void setNumeroLattine(int numeroLattine) {
		this.numeroLattine = numeroLattine;
	}
	
	public void reduceLattine() {
		numeroLattine--;
	}

}
