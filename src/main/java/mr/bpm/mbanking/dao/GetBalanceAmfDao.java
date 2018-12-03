package mr.bpm.mbanking.dao;

import mr.bpm.mbanking.dot.PApiGetBalanceAmfIn;
import mr.bpm.mbanking.dot.PApiGetBalanceAmfOut;

public interface GetBalanceAmfDao {
	
	PApiGetBalanceAmfOut getBalanceAmf(PApiGetBalanceAmfIn in);

}
