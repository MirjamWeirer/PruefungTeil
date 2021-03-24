package at.campus02.iwi.pr1.bsp1;

import java.util.Arrays;

public class Zoo {
    static final int LIMIT_KLEINTIER = 5;
    static final int LIMIT_GROSZTIER = 500;

    static final double KOSTEN_KLEINTIER = 3.2;
    static final double KOSTEN_GROSZTIER = 8.5;
    static final double KOSTEN_ELEFANT = 23.9;

    static final int LIMIT_CONTAINER = 500;

    public static void main(String[] args) {
        final double[] GEWICHTE = ZooData.ANIMAL_WEIGHTS;
        System.out.println(tierAnzahl(GEWICHTE));
        System.out.println(elefanten(GEWICHTE));
        System.out.println(mittleresGewicht(GEWICHTE));
        System.out.println(futterKosten(GEWICHTE));
        System.out.println(problemFallVorhanden(GEWICHTE));
        System.out.println(problemFallIndex(GEWICHTE,0));
        System.out.println(tiereImContainer(GEWICHTE,0));

    }

    // 16 %
    public static int tierAnzahl(double[] gewichte) {
        int anzahl = gewichte.length;
        return anzahl; // Platzhalter
    }

    // 16 %
    public static int elefanten(double[] gewichte) {
        int anzahl = 0;
        for(int i = 0; i <= gewichte.length-1; i++){
            if (gewichte[i]>=LIMIT_GROSZTIER){
                anzahl++;
            }
        }
        return anzahl; // Platzhalter
    }

    // 16 %
    public static double mittleresGewicht(double[] gewichte) {
        double average = 0.0;
        for (int i = 0; i < gewichte.length; i++) {
            average += gewichte[i];
        }
        average /= gewichte.length;
        return average; // Platzhalter
    }

    // 16 %
    public static double futterKosten(double[] gewichte) {
        int anzahlKlein=0;
        int anzMittlere = 0;
        int elephant = elefanten(gewichte);
        double sum=0;
        for (int i = 0; i < gewichte.length; i++) {
            if (gewichte[i]<LIMIT_KLEINTIER){
                anzahlKlein++;
            }else if (anzMittlere < LIMIT_GROSZTIER){
                anzMittlere++;
            }
        }
        anzMittlere-=elephant;
        System.out.println(anzahlKlein);
        System.out.println(anzMittlere);
        sum = (anzahlKlein * KOSTEN_KLEINTIER) + (anzMittlere * KOSTEN_GROSZTIER) + (elephant * KOSTEN_ELEFANT);
        return sum; // Platzhalter
    }

    // 16 %
    public static boolean problemFallVorhanden(double[] gewichte) {
        for (int i = 0; i < gewichte.length; i++) {
            if(gewichte[i]<1){
                return true;
            }
        }
        return false; // Platzhalter
    }

    // 10%
    public static int problemFallIndex(double[] gewichte, int startIndex) {
        int index = 0;

        for (int start = startIndex; start < gewichte.length; start++) {
            if (problemFallVorhanden(gewichte) == true){
                index = (int)gewichte[start];
                index++;
            }
            else {
                index = -1;
                index++;
            }
        }
        return index; // Platzhalter
    }

    // 10 %
    public static int tiereImContainer(double[] gewichte, int index) {
        int elephant =elefanten(gewichte);
        int anzahl = 0;
        int sum = 0;
        for (int i = index; i <gewichte.length - elephant ; i++) {
            sum += gewichte[i];
            anzahl += i;
            if (gewichte[i] == LIMIT_CONTAINER){
                anzahl = 0;
                return sum;
            }
            else if (anzahl == 5){
                sum = 0;
                return anzahl;
            }
        }

        return anzahl;
    }

}
