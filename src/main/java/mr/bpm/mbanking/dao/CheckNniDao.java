package mr.bpm.mbanking.dao;

import mr.bpm.mbanking.dot.PApiCheckNniIn;
import mr.bpm.mbanking.dot.PApiCheckNniOut;

public interface CheckNniDao {

	PApiCheckNniOut getCheckNni(PApiCheckNniIn in);
}
