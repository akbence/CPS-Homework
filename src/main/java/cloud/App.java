package cloud;

import com.microsoft.azure.sdk.iot.device.*;

import java.io.*;
import java.net.URISyntaxException;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * Hello world!
 *
 */
public class App{
	private static String connString = "HostName=cpstemp.azure-devices.net;DeviceId=myFirstJavaDevice;SharedAccessKey=gPWHUuuBMuzbMzpJ6zGW0Q==";
	private static IotHubClientProtocol protocol = IotHubClientProtocol.MQTT;
	static String deviceId = "myFirstJavaDevice";
	static DeviceClient client;

	private MessageSender sender;
	
	
	public App() {
		try {
			client = new DeviceClient(connString, protocol);
			client.open();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sender = new MessageSender();
	}
	public void cloudService() throws IOException, URISyntaxException {


//		ExecutorService executor = Executors.newFixedThreadPool(1);
//		executor.execute(sender);
//		System.out.println("Press ENTER to exit.");
//		System.in.read();
//		executor.shutdownNow();
//		client.closeNow();
	}

	public void closeClient() {
		try {
			client.closeNow();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void publishMsg() {
		sender.run();
	}
	

}
