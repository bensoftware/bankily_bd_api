package mr.bpm.mbanking.dao;

import java.util.List;

import mr.bpm.mbanking.dot.Historique;
import mr.bpm.mbanking.dot.MonetiqueClass;

public interface MonetiqueServiceDao {

	
	public List<MonetiqueClass> getAuthByPan(double pan);
	public List<MonetiqueClass> getClByPan(double pan);
	public List<Historique> getHistByPan(double pan);
	public List<Double> getAllCarte();
}
