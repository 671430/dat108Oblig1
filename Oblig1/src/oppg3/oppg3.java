package oppg3;

import oppg2.Ansatt;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class oppg3 {
    public static void main(String[] args) {
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

        List<String> etternavn = liste.stream().map(Ansatt::getEtternavn).toList();
        int antallKvinner = (int) liste.stream().filter(ansatt -> ansatt.getKjonn() == Ansatt.Kjonn.KVINNE).count();
        int totalLonnKvinner = liste.stream().filter(ansatt -> ansatt.getKjonn() == Ansatt.Kjonn.KVINNE).mapToInt(Ansatt::getAarslonn).sum();
        int gjnLonnKvinner = totalLonnKvinner/antallKvinner;
        skrivUtAlle(liste);
        liste.stream().filter(ansatt -> ansatt.getStilling().toLowerCase().contains("sjef")).forEach(ansatt -> ansatt.setAarslonn((int)(ansatt.getAarslonn() * 1.07)));
        skrivUtAlle(liste);



    }
    private static void skrivUtAlle(List<Ansatt> liste){
        for(Ansatt ans : liste){
            System.out.println(ans);
        }
    }

}
