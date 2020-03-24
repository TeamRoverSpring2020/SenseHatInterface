package ckb78.sensehat;

import okio.Okio;
import java.io.IOException;

public class PythonInterface implements SensorInterface {
    @Override
    public double getPressure() {
        String rawPressure = callSenseHatGetter("get_pressure");

        return Double.parseDouble(rawPressure);
    }

    @Override
    public double getTemperatureFromPressure() {
        String rawTemp = callSenseHatGetter("get_temperature_from_pressure");

        return Double.parseDouble(rawTemp);
    }

    @Override
    public double getHumidity() {
        return Double.parseDouble(callSenseHatGetter("get_humidity"));
    }

    @Override
    public double getTemperatureFromHumidity() {
        return Double.parseDouble(callSenseHatGetter("get_temperature_from_humidity"));
    }

    private String callSenseHatGetter(String getterName) {
        return execPythonCode(String.format("print sense.%s()", getterName));
    }

    private String execPythonCode(String command) {
        //String pythonCode = "from sense_hat import SenseHat\n" +
        String pythonCode = "from sense_emu import SenseHat\n" +
                "sense = SenseHat()\n" +
                "\n" +
                command;

        try {
            Process process = Runtime.getRuntime().exec(new String[]{
                    "python", "-c", pythonCode
            });

            int exitCode = process.waitFor();

            if (exitCode == 0) {
                return Okio.buffer(Okio.source(process.getInputStream())).readUtf8();
            } else {
                System.out.println(exitCode);
                String error = Okio.buffer(Okio.source(process.getErrorStream())).readUtf8();
                System.out.println(error);
                throw new RuntimeException(error);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
