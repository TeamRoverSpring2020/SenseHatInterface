package ckb78.sensehat;

public interface SensorAdapter {
    double getPressure();
    double getHumidity();
    double getTemperatureFromPressure();
    double getTemperatureFromHumidity();


}
