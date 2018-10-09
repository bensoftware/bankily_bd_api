package mr.bpm.mbanking.dao;

import mr.bpm.mbanking.dot.PApiCreateCifIn;
import mr.bpm.mbanking.dot.PApiCreateCifOut;

public interface CreateCifDao {
	PApiCreateCifOut getCif(PApiCreateCifIn in);

}
