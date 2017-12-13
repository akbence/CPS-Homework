package sensor;

import java.util.Random;

import dds.UvegHazSubscriber;

public class TempSensor implements TempProvider {

	
	public static double temperature;
	public TempSensor() {
		new Thread(new UvegHazSubscriber(this)).start();
	}
	public double getTemp() {
//		Random rand = new Random();
//		temperature = rand.nextInt(10) + 20;
//		System.out.println("Dummy Temp Sensor DATA: "+ temperature+ " Celsius");
		return (int)temperature;
	}

}
