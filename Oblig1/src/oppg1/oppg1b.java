package oppg1;

import java.util.function.BiFunction;

public class oppg1b {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> addisjon = (x, y) -> x + y;
        BiFunction<Integer, Integer, Integer> storst = (x,y) -> Math.max(x,y);
        BiFunction<Integer, Integer, Integer> differanse = (x,y) -> Math.abs(x - y);

        // brukes for eksempel sånn:
        System.out.println("Addisjon");
        System.out.println(beregn(12,13,addisjon));
        System.out.println("Største:");
        System.out.println(beregn(-5, 3, storst));
        System.out.println("Differanse:");
        System.out.println(beregn(54, 45, differanse));

    }
    // BiFunction tar inn to argument og returnerer det siste
    public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> funk) {
       return funk.apply(a,b);
    };
}


