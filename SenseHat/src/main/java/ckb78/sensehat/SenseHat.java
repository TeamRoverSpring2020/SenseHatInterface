package ckb78.sensehat;

public class SenseHat {

    private final SensorAdapter sensorAdapter;

    public SenseHat(){
        sensorAdapter = new PythonInterface();
    }

    public double getPressure() {
        return sensorAdapter.getPressure();
    }

    public double getTemperatureFromPressure() {
        return sensorAdapter.getTemperatureFromPressure();
    }

    public double getHumidity() {
        return sensorAdapter.getHumidity();
    }

    public double getTemperatureFromHumidity() {
        return sensorAdapter.getTemperatureFromHumidity();
    }

    public double getTemperature() {
        return (getTemperatureFromHumidity() + getTemperatureFromHumidity()) / 2;
    }
}
