package esercitazione;

import java.util.Scanner;

public class Main {

	static Distributore d;
	
	public static void main(String[] args) {
		
		char bevanda;
		int tessera;
		Scanner input = new Scanner(System.in);
		
		d = new Distributore();
		
		System.out.println("Digitare la lettera corrispondente alla bevanda scelta: ");
		for (Bevanda b : d.storage)
			System.out.println(b.getCodice() + ". " + b.getNome());
		bevanda = input.next().charAt(0);

		System.out.println("Digitare il numero della tessera");
		tessera = input.nextInt();
		
		System.out.println("Credito prima dell'acquisto" + d.leggiCredito(tessera));
		buyCan(bevanda, tessera);
		System.out.println("Credito dopo l'acquisto" + d.leggiCredito(tessera));
		
	}
	
	public static void buyCan(char b, int t) {
		try {
			d.eroga(b, t);
		} catch (CreditoInsufficente e) {
			e.printStackTrace();
		} catch (BevandaEsaurita e) {
			e.printStackTrace();
		} catch (BevandaNonValida e) {
			e.printStackTrace();
		} catch (TesseraNonValida e) {
			e.printStackTrace();
		}
	}
	
	

}
