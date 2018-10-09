package mr.bpm.mbanking.dao;

import mr.bpm.mbanking.dot.FullStatementIn;
import mr.bpm.mbanking.dot.FullStatementOut;

public interface FullStatementDao {

	FullStatementOut getFullStatement(FullStatementIn in);
}
