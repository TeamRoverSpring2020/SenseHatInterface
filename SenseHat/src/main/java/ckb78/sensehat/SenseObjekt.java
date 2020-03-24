package ckb78.sensehat;

class SenseObjekt {

    private static String temp;
    private static String fukt;
    private static String trykk;

    public SenseObjekt(){
        updateData();
        this.temp = temp;
        this.fukt = fukt;
        this.trykk = trykk;
    }

    public static void updateData(){
        SenseHatMethods senseHatMethods = new SenseHatMethods();
        temp = String.format("%.01f", senseHatMethods.getTemperature());
        fukt = String.format("%.01f", senseHatMethods.getHumidity());
        trykk = String.format("%.01f", senseHatMethods.getPressure());
    }

    public static String getTemp() {
        return temp;
    }

    public static String getFukt() {
        return fukt;
    }

    public static String getTrykk() {
        return trykk;
    }


}
