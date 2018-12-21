package mr.bpm.mbanking.dao;

import java.util.List;

import mr.bpm.mbanking.dot.Historique;
import mr.bpm.mbanking.dot.MonetiqueClass;
import mr.bpm.mbanking.dot.SoldeCarte;
import mr.bpm.mbanking.dot.TraitementDto1;

public interface MonetiqueServiceDao {

	
	public List<MonetiqueClass> getAuthByPan(double pan);
	public List<MonetiqueClass> getClByPan(double pan);
	public List<Historique> getHistByPan(double pan);
	public List<Double> getAllCarte();
	public SoldeCarte getSoldeCarte(double pan);
	
	
	public List<TraitementDto1> traitement1();
}
