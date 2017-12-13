package dds;

import com.rti.dds.domain.DomainParticipant;
import com.rti.dds.domain.DomainParticipantFactory;
import com.rti.dds.infrastructure.StatusKind;

public class Domain {
	static DomainParticipant participant=null;
	

	public Domain() {

		 // --- Create participant --- //

        /* To customize participant QoS, use
        the configuration file
        USER_QOS_PROFILES.xml */

        participant = DomainParticipantFactory.TheParticipantFactory.
        create_participant(
            0, DomainParticipantFactory.PARTICIPANT_QOS_DEFAULT,
            null /* listener */, StatusKind.STATUS_MASK_NONE);
        if (participant == null) {
            System.err.println("create_participant error\n");
            return;
        }        
	}
	
}
