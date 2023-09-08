package Oppgave3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import Oppgave2.Kjonn;


public class Main {

	
	public static List<String> tilListeAvString(List<Ansatt> liste, 
			Function<Ansatt, String> funksjon) {
		
		List<String> resultat = new ArrayList<>();
		for (Ansatt p : liste) {
			resultat.add(funksjon.apply(p));
		}
		return resultat;
	}
	
	public static void main(String[] args) {
	
	List<Ansatt> Ansatte = Arrays.asList(
			new Ansatt("Lukas", "Lukasen", Kjonn.Mann, "Sjef", 600000),
			new Ansatt("Kevin", "Kevinsen", Kjonn.Mann, "Selger", 350000),
			new Ansatt("Heidi", "Heidisen", Kjonn.Kvinne, "Selger", 400000),
			new Ansatt("Randi", "Randisen", Kjonn.Kvinne, "Selger", 500000),
			new Ansatt("Mann", "Mannesen", Kjonn.Mann, "Selger", 400000)

			);
		
	//a)
		//En liste av personer skal gjøres om til en liste av etternavn (Stringer)
		List<String> etternavn = tilListeAvString(Ansatte, 
				a -> a.getEtternavn());
		System.out.println("Med bare lambda: " + etternavn);	
		
		//Oppgave a med bruk av funksjon
		List<String> etternavnene = Ansatte.stream()
		//.filter(p -> p.getEtternavn()
		.map(Ansatt::getEtternavn)
		.toList();
		//.collect(Collectors.toList());
		
		System.out.println("Med streams: " + etternavnene);
		
	//b)
		int kjonn = (int) Ansatte.stream()
		.filter(p -> p.getKjonn() == Kjonn.Kvinne).count();
		
		System.out.println(kjonn);
		
	//c)
		Double gjennomsnittslonn = Ansatte.stream()
		.filter(p -> p.getKjonn() == Kjonn.Kvinne)
		.map(g -> g.getAarslonn())
		.mapToDouble(Double::doubleValue)
		.average()
		.getAsDouble();
		
		System.out.println(gjennomsnittslonn);
	
	//d)
		List<Ansatt>lonnsokning = Ansatte.stream()
		.filter(a -> a.getStilling().contains("Sjef"))
		.toList();
		
		lonnsokning.forEach(a -> a.setAarslonn((a.getAarslonn()*1.07)));
		System.out.println(Ansatte);
		
	//e)
		boolean noenOver = Ansatte.stream()
				//.filter(l -> l.getAarslonn()>800000)
		.anyMatch(l -> l.getAarslonn() > 800000);
		System.out.println(noenOver);

	//f)
				Ansatte.stream()
				.forEach(a -> System.out.println(a.getFornavn() + ", "
						+a.getEtternavn() + ": "
						+a.getStilling() + ", "
						+a.getKjonn()+ ", "
						+a.getAarslonn()+ ", "));
				
	//g)
		Ansatt lavestLonn = Ansatte.stream()
			.collect(Collectors.minBy(Comparator.comparingDouble(a -> a.getAarslonn())))
			.get();
	
		System.out.println(lavestLonn);
		
	//h)
	int s1 =IntStream.rangeClosed(1, 999)
				.filter(x -> x % 3 == 0 || x % 5 == 0)
				.sum();
				//.forEach(x -> System.out.println(" " + x));
				System.out.println(s1);
				
		
	}
	

}



	
	
	


