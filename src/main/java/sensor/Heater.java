package sensor;

import dds.UvegHazPublisher;

public class Heater extends AbstractActuator{

	UvegHazPublisher publisher= null;
	public Heater() {
		publisher=new UvegHazPublisher("heater");
	}
	@Override
	public void doSomething() {
		// TODO Auto-generated method stub
		switch(local) {
		case COLD:
			publisher.main( 1,"setheater");
			break;
		case HOT:
			publisher.main( 0,"setheater");
			break;
		case NORMAL:
			break;
		default:
			break;
		}
		
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Heater";
	}

}
