package sensor;

import dds.UvegHazPublisher;

public class WindowHandler extends AbstractActuator {

	UvegHazPublisher publisher= null;
	public WindowHandler() {
		publisher=new UvegHazPublisher("window");
	}
	@Override
	public void doSomething() {
		switch(local) {
		case COLD:
			publisher.main( 0,"setwindow1");
			break;
		case HOT:
			publisher.main( 1,"setwindow1");
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
		return "WindowHandler";
	}

}
