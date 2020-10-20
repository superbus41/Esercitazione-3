package esercitazione;

public class TesseraNonValida extends Exception {
	
	public TesseraNonValida() {
		super();
	}
	
	public TesseraNonValida(String reason)
	{
		super(reason);
	}
	
}
