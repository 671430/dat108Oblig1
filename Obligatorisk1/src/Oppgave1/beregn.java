package Oppgave1;

import java.util.List;

public class beregn {

	

	    public int beregn(int a, int b, String operasjon) {
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

	   

		
		
	

