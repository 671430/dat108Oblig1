package Oppgave2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {

	private static void lonnsoppgjor(List<Ansatte> ansatte, lonnsberegning lonnsberegning) {
		for (Ansatte ansatt : ansatte) {
			int lonnsendring = lonnsberegning.beregnLonnsendring(ansatt);
			ansatt.setAarslonn(ansatt.getAarslonn() + lonnsendring);
		}
	
		
		// Implementasjon for fast kronetillegg
		lonnsberegning fastKronetillegg = ansatt -> 10000;

		// Implementasjon for fast prosenttillegg
		lonnsberegning fastProsenttillegg = ansatt -> (int) (ansatt.getAarslonn() * 0.05);

		// Implementasjon for fast kronetillegg hvis lav lønn
		lonnsberegning lavLonnKronetillegg = ansatt -> (ansatt.getAarslonn() < 50000) ? 5000 : 0;

		// Implementasjon for fast prosenttillegg hvis mann
		lonnsberegning mannProsenttillegg = ansatt -> (ansatt.getKjonn() == Kjonn.Mann) ? (int) (ansatt.getAarslonn() * 0.03) : 0;

	}
	
	private static void skrivUtAlle(List<Ansatte> ansatte) {
        for (Ansatte ansatt : ansatte) {
            System.out.println(ansatt);
        }
        System.out.println("-----------------------------");
}

	
	public static void main(String[] args) {
		
	     // Opprett en liste av ansatte
        List<Ansatte> ansatte = new ArrayList<>();
        ansatte.add(new Ansatte("Marius", "Olsen", Kjonn.Mann, "Sjef", 60000));
        ansatte.add(new Ansatte("Anna", "Hansen", Kjonn.Kvinne, "Designer", 45000));
        ansatte.add(new Ansatte("Per", "Jensen", Kjonn.Mann, "Utvikler", 55000));
        ansatte.add(new Ansatte("Eva", "Bakke", Kjonn.Kvinne, "Markedsfører", 50000));
        ansatte.add(new Ansatte("Ole", "Pedersen", Kjonn.Mann, "Prosjektleder", 65000));
        
        skrivUtAlle(ansatte);
        
        lonnsberegning fastKronetillegg = ansatt -> 10000;
        lonnsberegning fastProsenttillegg = ansatt -> (int) (ansatt.getAarslonn() * 0.05);
        lonnsberegning lavLonnKronetillegg = ansatt -> (ansatt.getAarslonn() < 50000) ? 5000 : 0;
        lonnsberegning mannProsenttillegg = ansatt -> (ansatt.getKjonn() == Kjonn.Mann) ? (int) (ansatt.getAarslonn() * 0.03) : 0;
	
        
        lonnsoppgjor(ansatte, fastKronetillegg);
        skrivUtAlle(ansatte);

        lonnsoppgjor(ansatte, fastProsenttillegg);
        skrivUtAlle(ansatte);

        lonnsoppgjor(ansatte, lavLonnKronetillegg);
        skrivUtAlle(ansatte);

        lonnsoppgjor(ansatte, mannProsenttillegg);
        skrivUtAlle(ansatte);
    
	}
}