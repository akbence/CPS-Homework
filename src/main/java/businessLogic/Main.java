package businessLogic;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.ActionMapUIResource;

import org.apache.qpid.proton.amqp.Decimal128;

import com.microsoft.azure.sdk.iot.device.DeviceTwin.DeviceOperations;

import cloud.App;
import dds.Domain;
import dds.UvegHazPublisher;
import dds.UvegHazSubscriber;
import sensor.AbstractActuator;
import sensor.Fan;
import sensor.Heater;
import sensor.States;
import sensor.TempSensor;
import sensor.WindowHandler;

public class Main {
	
	public static double temperature=20;
	public static String alert="";
	public static double profilDiff=4;
	private static TempSensor tempSensor;
	private static States systemState;
	private static cloud.App cloudService;
	

	public static void main(String args[]) {
		
		Domain domain= new Domain();
		List<AbstractActuator> actuators=new ArrayList<AbstractActuator>();
		actuators.add(new Fan());
		actuators.add(new Heater());
		actuators.add(new WindowHandler());
		tempSensor= new TempSensor();
		systemState=States.NORMAL;
		cloudService=new App();
		int cloudCntr=0;
		
		
		while(true) {
		cloudCntr++;
		
		systemState=decision();

		for (AbstractActuator abstractActuator : actuators) {
			abstractActuator.setState(systemState);
//			abstractActuator.log();
			abstractActuator.doSomething();
			if(!abstractActuator.isCorrect()) {
				alert=abstractActuator.getName()+" malfunctioned!";
				cloudService.publishMsg();
			};
			
		}
			
		if(cloudCntr%300==0) {
		cloudService.publishMsg();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	};
	
	
	public static States decision() {
		
		Profile profile=new Profile();
		
		alert="";
		double oldtemperature=temperature;
		temperature=tempSensor.getTemp();
		if(anomalyCheck(oldtemperature,temperature)) {
			temperature=oldtemperature;
			return States.NORMAL;
		}
		
		double profileTemp=profile.getProfile();
		if(temperature<=profileTemp-profilDiff) {
			alert="too cold temperature";
			System.out.println(alert);
			return States.COLD;
		}
		
		if(temperature>=profileTemp +profilDiff ) {
			alert="too hot temperature";
			System.out.println(alert);
			return States.HOT;
		}
		
		return States.NORMAL;
	}


	private static boolean anomalyCheck(double oldtemperature, double temperature2) {
		// TODO Auto-generated method stub
		if (Math.abs(oldtemperature-temperature2)>=10)
			return true;
		else 
			return false;
		
	}
	

};
