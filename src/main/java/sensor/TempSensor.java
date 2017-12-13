package sensor;

import java.util.Random;

public class TempSensor implements TempProvider {

	int  temperature;
	public double getTemp() {
		Random rand = new Random();
		temperature = rand.nextInt(10) + 20;
		System.out.println("Dummy Temp Sensor DATA: "+ temperature+ " Celsius");
		return temperature;
	}

}
