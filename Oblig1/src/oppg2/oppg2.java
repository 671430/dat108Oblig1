package oppg2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class oppg2 {
    public static void main(String[] args) {
        //Vi tenker at vi har en liste av ansatte og skal lage en metode som utfører lønnsoppgjør
        //       (oppdaterer de ansattes lønn etter en viss algoritme)

        // OPPSETT
        List<Ansatt> liste = new ArrayList<>();
        Ansatt a1 = new Ansatt("Hans", "Johnsen", Ansatt.Kjonn.MANN, "Sjef", 840000);
        Ansatt a2 = new Ansatt("Janne", "Formoe", Ansatt.Kjonn.KVINNE, "Personellsjef", 650000);
        Ansatt a3 = new Ansatt("William", "Knudsen", Ansatt.Kjonn.MANN, "Avdelingssjef", 630000);
        Ansatt a4 = new Ansatt("Knut", "Flataker", Ansatt.Kjonn.MANN, "Produksjonsjef", 670000);
        Ansatt a5 = new Ansatt("Hans", "Johnsen", Ansatt.Kjonn.KVINNE, "Markedsføringssjef", 655000);
        liste.add(a1);
        liste.add(a2);
        liste.add(a3);
        liste.add(a4);
        liste.add(a5);


        Function<Ansatt, Integer> fastTillegg = ansatt -> ansatt.getAarslonn() + 50000;
        Function<Ansatt, Integer> prosentTillegg = ansatt -> (int)(ansatt.getAarslonn()*1.05);
        Function<Ansatt, Integer> tilleggHvisLav = ansatt -> {
            if(ansatt.getAarslonn() < 650000){
                return ansatt.getAarslonn() + 50000;
            }
            else return ansatt.getAarslonn();
        };
        Function<Ansatt, Integer> tilleggHvisMann = ansatt -> {
            if(ansatt.getKjonn() == Ansatt.Kjonn.MANN){
                return ansatt.getAarslonn() + 50000;
            }
            else return ansatt.getAarslonn();
        };

        // TEST TILLEGG HVIS LAV LØNN
        System.out.println("Før tillegg hvis lav lønn:");
        skrivUtAlle(liste);
        lonnsoppgjor(liste,tilleggHvisLav);
        System.out.println("Etter tillegg hvis lav lønn:");
        skrivUtAlle(liste);

    }

    private static void lonnsoppgjor(List<Ansatt> liste, Function<Ansatt, Integer> funk){
        for(Ansatt a : liste){
            a.setAarslonn(funk.apply(a));
        }
    }
    private static void skrivUtAlle(List<Ansatt> liste){
        for(Ansatt ans : liste){
            System.out.println(ans);
        }
    }
}
