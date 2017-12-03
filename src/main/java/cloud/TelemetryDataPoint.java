package cloud;

import com.google.gson.Gson;

public class TelemetryDataPoint {
	//public String deviceId;
	public double temperature;
	//public double humidity;
	public String alert;

	public String serialize() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}