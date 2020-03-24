package ckb78.sensehat;

public interface SensorInterface {
    double getPressure();
    double getHumidity();
    double getTemperatureFromPressure();
    double getTemperatureFromHumidity();


}
