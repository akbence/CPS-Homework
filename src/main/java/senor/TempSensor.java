package senor;

import java.util.Random;

public class TempSensor implements TempProvider {

	int  n;
	public double getTemp() {
		Random rand = new Random();
		n = rand.nextInt(10) + 20;
		System.out.println("Dummy Temp Sensor DATA: "+ n+ " Celsius");
		return n;
	}

}
