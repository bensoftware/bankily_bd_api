package mr.bpm.mbanking.dao;

import mr.bpm.mbanking.dot.PApiRetchqbookReqIn;
import mr.bpm.mbanking.dot.PApiRetchqbookReqOut;

public interface RetCheckBookReqDao {

	PApiRetchqbookReqIn getRetCheckBookReq(PApiRetchqbookReqOut in);
}
