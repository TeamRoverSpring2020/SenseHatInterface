package ckb78.sensehat;

public class Main {


    public static void main(String[] args) {

        SenseObjekt sensObj = new SenseObjekt();
        // Skriver ut data fra SenseObjektet
        System.out.println("Nåværende temperatur        :  " + sensObj.getTemp() + "C.");;
        System.out.println("Nåværende luftfuktighet     :  " + sensObj.getFukt() + "%.");
        System.out.println("Nåværende atmosfærisk trykk : " + sensObj.getTrykk() + "mBar.");

        // Kaller returnSenseObjekt()-metoden i SenseHatMethods, og får et oppdatert SenseObjekt tilbake:
        System.out.print(SenseHatMethods.returnSenseObjekt());
    }

}
