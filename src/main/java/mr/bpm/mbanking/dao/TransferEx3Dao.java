package mr.bpm.mbanking.dao;

import mr.bpm.mbanking.dot.PApiTransferEx3In;
import mr.bpm.mbanking.dot.PApiTransferEx3Out;

public interface TransferEx3Dao {

	PApiTransferEx3Out getTransferEx3(PApiTransferEx3In in);
}
