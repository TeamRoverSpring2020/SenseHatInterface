package ckb78.sensehat;

public class Main {

    public static void main(String[] args) {

        SenseHat senseHat = new SenseHat();
        System.out.println("Temperature is " + senseHat.getTemperature());;
        System.out.println("Humidity is " + senseHat.getHumidity());
        System.out.println("Pressure is " + senseHat.getPressure());

    }
}
