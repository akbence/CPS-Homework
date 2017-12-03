package cloud;

import java.util.Random;

import com.microsoft.azure.sdk.iot.device.Message;

public class MessageSender  {
	public void run() {
		try {
//			double minTemperature = 2;
//			double minHumidity = 60;
//			Random rand = new Random();

//			while (true) {
//				double currentTemperature = minTemperature + rand.nextDouble() * 15;
//				double currentHumidity = minHumidity + rand.nextDouble() * 20;
				TelemetryDataPoint telemetryDataPoint = new TelemetryDataPoint();
				//telemetryDataPoint.deviceId = App.deviceId;
				telemetryDataPoint.temperature = businessLogic.Main.temperature;
				telemetryDataPoint.alert = businessLogic.Main.alert;
//				telemetryDataPoint.humidity = currentHumidity;

				String msgStr = telemetryDataPoint.serialize();
				Message msg = new Message(msgStr);
//				msg.setProperty("temperatureAlert", (currentTemperature > 30) ? "true" : "false");
				msg.setMessageId(java.util.UUID.randomUUID().toString());
				System.out.println("Sending: " + msgStr);

				Object lockobj = new Object();
				EventCallback callback = new EventCallback();
				App.client.sendEventAsync(msg, callback, lockobj);
				synchronized (lockobj) {
					lockobj.wait();
				}
//				Thread.sleep(1000);
//			}
		} catch (InterruptedException e) {
			System.out.println("Finished.");
		}
	}
}