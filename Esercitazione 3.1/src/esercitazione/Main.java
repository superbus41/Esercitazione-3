package esercitazione;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		provaEx1();
		provaEx2();
		provaEx3();
		provaEx4();
	}
	
	static LinkedList<Integer> creaRandom(int n, int max){
		
		Random rand = new Random();
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for (int i = 0; i < n; i++)
			list.add(rand.nextInt(max - 1));
		
		return list;		
				
	}
	
	static ArrayList<Integer> creaRandomArray(int n, int max){
		
		Random rand = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++)
			list.add(rand.nextInt(max - 1));
		
		return list;		
				
	}
	
	static void stampa(Iterator<Integer> i) {
		
		while(i.hasNext()) {
			System.out.print(i.next() + " ");
		}
		System.out.println();
	}
	
	static void provaEx1() {
		
	    List<Integer> values = creaRandom(20, 100);
	    Iterator<Integer> it = values.iterator();
	    stampa(it);
	   	values = creaRandomArray(20, 100);
	   	it = values.iterator();
	   	stampa(it);
	    System.out.println();
	}

	static LinkedList<Integer> creaRandomCrescente(int n, int max){
		
		Random rand = new Random();
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for (int i = 0; i < n; i++) 
			list.add(rand.nextInt(max - 1) + list.get(i - 1));
		return list;	 
	}
	
	static LinkedList<Integer> parseString(LinkedList<String> a){
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (String str : a)
			list.add(Integer.parseInt(str));
		return list;
	}
	
	static void provaEx2() {
		
		LinkedList<String> stringList = new LinkedList<String>(
				Arrays.asList("175", "49678", "4574", "485478", "6597", "8142", "589", "0", "35", "12894")); //massimo valori = massimo integer
		 LinkedList<Integer> intList = parseString(stringList);
		 Iterator<Integer> it = intList.iterator();
		 stampa(it);	
		 System.out.println();
	}
	
	//input solo liste già ordinate
	static LinkedList<Integer> mergeOrdinato(Iterator<Integer> a, Iterator<Integer> b){
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		int bufferA = a.next(), bufferB = b.next();
		while (a.hasNext() && b.hasNext()){
			if (bufferA <= bufferB){
	        	list.add(bufferA);
	        	bufferA = a.next();
	        } else {
	        	list.add(bufferB);
	        	bufferB = b.next();
	        }		
		}
		if (bufferA <= bufferB) {
        	list.add(bufferA);
        	list.add(bufferB);
		}
        else {
        	list.add(bufferB);
        	list.add(bufferA);
        }
		while (a.hasNext()) 
			list.add(a.next());

		while (b.hasNext())
			list.add(b.next());
		
		return list;
	}
	
	static void provaEx3() {
		Iterator<Integer> it;
		List<Integer> list1 = creaRandom(20, 100);
		Collections.sort(list1);
		List<Integer> list2 = creaRandom(20, 100);
		Collections.sort(list2);
		List<Integer> list3;
	    it = list1.iterator();
	    stampa(it);
	    it = list2.iterator();
	    stampa(it);    
	    list3 = mergeOrdinato(list1.iterator(), list2.iterator());
	    it = list3.iterator();
	    stampa(it);
	    System.out.println();
	    		
	}
	
	static LinkedList<LinkedList<Integer>> insiemeDiInsiemi(int n){
		LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();
		LinkedList<Integer> buffer = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i+1; j++) {
				buffer.add(j);
			}
			list.add(buffer);
			buffer = new LinkedList<Integer>();
		}
		return list;
	}
	
	static void stampa(LinkedList<LinkedList<Integer>> a) {
		Iterator<Integer> it;
		for (LinkedList<Integer> list : a) {
		   	it = list.iterator();
		   	stampa(it);
		}
			
	}
	
	static void provaEx4() {
		LinkedList<LinkedList<Integer>> list = insiemeDiInsiemi(20);
		stampa(list);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
