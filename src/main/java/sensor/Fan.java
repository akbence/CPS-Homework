package sensor;

import businessLogic.Main;
import dds.UvegHazPublisher;

public class Fan extends AbstractActuator{

	UvegHazPublisher publisher= null;
	
	public Fan() {
		publisher=new UvegHazPublisher("window");
	}
	
	@Override
	public void doSomething() {
		
		switch(local) {
		case COLD:
			publisher.main( 0,"setvent");
			break;
		case HOT:
			publisher.main(1,"setvent");
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
		return "Fan";
	}

}
