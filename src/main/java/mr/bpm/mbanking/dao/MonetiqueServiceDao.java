package mr.bpm.mbanking.dao;

import java.util.List;

import mr.bpm.mbanking.dot.Historique;
import mr.bpm.mbanking.dot.MonetiqueClass;

public interface MonetiqueServiceDao {

	
	public List<MonetiqueClass> getAuthByPan(String pan);
	public List<MonetiqueClass> getClByPan(String pan);
	public List<Historique> getHistByPan(String pan);
	public List<Double> getAllCarte();
}
