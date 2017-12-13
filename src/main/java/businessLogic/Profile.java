package businessLogic;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Profile {
	
	/**
	 * Really Simple Profile
	 * 00-08: 15 C
	 * 08-20: 20 C
	 * 20-24: 18 C
	 * If something goes wrong with the request of the current time (in hours), than the profile is 20 C.
	 * @return the current temperature value of the profile
	 */
	public double getProfile() {
		int act_hour=LocalDateTime.now().getHour();
		if(act_hour<8) {
			return 15;
		}
		if(act_hour>=8 && act_hour < 20) {
			return 15;
		}
		if(act_hour<=20) {
			return 15;
		}
		else {
			return 20;
		}
	}
}
