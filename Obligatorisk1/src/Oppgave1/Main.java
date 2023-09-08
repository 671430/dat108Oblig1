package Oppgave1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {

//Oppgave a med anonym indre tråd, tråd og lambda.
		
		List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");

		Thread t = new Thread ()	{
			
			@Override
			public void run() {
			Collections.sort(listen, (a, b) -> Integer.parseInt(a) - Integer.parseInt(b));
			System.out.println(listen);
		
		}
			
		};
		
		Thread t1 = new Thread (() ->  Collections.sort(listen, (a, b) -> Integer.parseInt(a) - Integer.parseInt(b)));
		
		t.start();
		t1.start();
		
		
//Oppgave b
		
	        // i. Summen av 12 og 13
	        int sumResultat = beregn(12, 13, "sum");
	        System.out.println("Summen av 12 og 13 er: " + sumResultat);

	        // ii. Den største av -5 og 3
	        int størsteResultat = beregn(-5, 3, "største");
	        System.out.println("Den største av -5 og 3 er: " + størsteResultat);

	        // iii. Avstanden (absoluttverdien av differansen) mellom 54 og 45
	        int avstandResultat = beregn(54, 45, "avstand");
	        System.out.println("Avstanden mellom 54 og 45 er: " + avstandResultat);
	    }

	private static int beregn(int a, int b, String operasjon) {
		  int resultat = 0;

	        switch (operasjon) {
	            case "sum":
	                resultat = a + b;
	                break;
	            case "største":
	                resultat = Math.max(a, b);
	                break;
	            case "avstand":
	                resultat = Math.abs(a - b);
	                break;
	            	        }

	        return resultat;
	    }

}


	