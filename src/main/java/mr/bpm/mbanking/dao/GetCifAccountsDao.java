package mr.bpm.mbanking.dao;

import mr.bpm.mbanking.dot.PApiGetCifAccountsIn;
import mr.bpm.mbanking.dot.PApiGetCifAccountsOut;

public interface GetCifAccountsDao {

	PApiGetCifAccountsOut getCifAccounts(PApiGetCifAccountsIn in);
}
