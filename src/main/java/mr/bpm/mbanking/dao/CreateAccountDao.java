package mr.bpm.mbanking.dao;

import mr.bpm.mbanking.dot.PApiCreateAccountIn;
import mr.bpm.mbanking.dot.PApiCreateAccountOut;

public interface CreateAccountDao {

	PApiCreateAccountOut getCreateAccount(PApiCreateAccountIn in);

}
