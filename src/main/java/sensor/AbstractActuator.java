package sensor;

import java.util.Random;

import dds.UvegHazPublisher;

public abstract class AbstractActuator {


	Random rand= new Random();
	States local=States.NORMAL;
	public void setState(States p) {local=p;};
	public void log() {
		System.out.println(local);
	}
	public boolean isCorrect() {
		
		if(rand.nextInt(1000)<=10) {
			System.out.println(getName()+" malfunctioned!");
			return false;
		}
		else return true;
	};
	public abstract void doSomething();
	public abstract String getName();
}
