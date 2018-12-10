package mr.bpm.mbanking.helper;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import mr.bpm.mbanking.dot.Historique;
import mr.bpm.mbanking.dot.MonetiqueClass;

public class MonetiqueCarteHelper {

	static public List<MonetiqueClass> toAuthtOut( List<Map<String, Object>> params) {
	
		List<MonetiqueClass> out =new ArrayList<>();
		
		int cpt=-1;
		
		for(Map<String, Object> p :params) {
			
		
		MonetiqueClass m=new MonetiqueClass();		
		   try {
				 m.setRefTrans(Double.parseDouble(""+(String) p.get("AUT_RETR_REF_NUMB_F037")));
	        }catch (Exception e) {
	        	m.setRefTrans(cpt);
	        	m.setRefErone(""+(String) p.get("AUT_RETR_REF_NUMB_F037"));
	        	m.setMontantOrigine(Double.parseDouble(""+(BigDecimal) p.get("AUT_TRAN_AMOU_F004")));
	   		    m.setDeviseOrigine(Integer.parseInt(""+(String) p.get("AUT_TRAN_CURR_F049")));
	        	cpt--;
	        	
			}
		 m.setMontantTrans(Double.parseDouble(""+(BigDecimal) p.get("AUT_BILL_AMOU_F006")));
		 try {
			 m.setCommission(Double.parseDouble(""+(BigDecimal) p.get("AUT_COMM_AMOU")));
			} catch (Exception e) {
		        m.setCommission(0);
			}
			try {
				 m.setTaux(Double.parseDouble(""+(BigDecimal) p.get("AUT_BILL_CONV_RATE_F010")));

			} catch (Exception e) {
		        m.setTaux(0);
			}
			
			try {
				 m.setCodeAuth(Double.parseDouble(""+(String) p.get("AUT_AUTH_ID_RESP_F038")));

			} catch (Exception e) {
		        m.setCodeAuth(0);
			}
			
			try {
				 m.setCode(Integer.parseInt(""+(String) p.get("AUT_TRAN_CODE")));
				 String stat= (String) p.get("AUT_REVE_STAT");
				  
					if(stat.equals("F")) {
						m.setEtat(20);
					}
				} catch (Exception e) {
			}
			
			m.setDate((Timestamp) p.get("AUT_REQU_SYST_TIME"));
			m.setDeviseSS(Integer.parseInt(""+(String) p.get("AUT_BILL_CURR_F051")));
			m.setType(1);
			
			out.add(m);
			
		}
		
		

		return out;
	}



	static public List<MonetiqueClass> toClOut(List<Map<String, Object>> params) {
		
		List<MonetiqueClass> out =new ArrayList<>();
		
	    
		
		for(Map<String, Object> p :params) {
		
		MonetiqueClass m=new MonetiqueClass();		
		
		Date procDate=(Timestamp) p.get("VTR_PROC_DATE");
		Date purcDate=(Timestamp) p.get("VTR_PURC_DATE");
		
		int code =Integer.parseInt(""+(String) p.get("VTR_TC_CODE"));
		
		int devise;
		
		if(code==19001) {
			
		    m.setRechargeCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU"))*10 );

			
			m.setDate(purcDate);
			
			int annee= procDate.getYear()+1900;
			devise = Integer.parseInt(""+(String) p.get("VTR_BILL_CURR"));
			if(devise==929 || annee>=2018) {
				m.setRechargeCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU")));
			}
			m.setType(2);
			
		}
		else if(code==6000) {
			
			m.setDate(procDate);
			
			m.setMontantCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU"))*10);
			
			 m.setMontantOrigine(Double.parseDouble(""+(BigDecimal) p.get("VTR_TRAN_AMOU")));
			 m.setDeviseOrigine(Integer.parseInt(""+(String) p.get("VTR_TRAN_CURR")));
			
			devise = Integer.parseInt(""+(String) p.get("VTR_BILL_CURR"));
			if(devise==929) {
				m.setMontantCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU")));
			}
			 m.setTaux(Double.parseDouble(""+(BigDecimal) p.get("VTR_CHLD_ACC_CURR_RATE")));			
    		m.setType(4);
		}
		// a rectifier apres
		else {
			m.setDate(procDate);
			
			try {
				m.setRefCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_AUT_RETR_REF_NUMB")));

			}catch (Exception e) {
    			m.setRefCl(0);
			}
			
			try {
				 m.setCodeAuth(Double.parseDouble(""+(String) p.get("VTR_AUTH_CODE")));

			} catch (Exception e) {
		        m.setCodeAuth(0);
			}

			try {
				 m.setMontantOrigine(Double.parseDouble(""+(BigDecimal) p.get("VTR_TRAN_AMOU")));
				 m.setDeviseOrigine(Integer.parseInt(""+(String) p.get("VTR_TRAN_CURR")));


			} catch (Exception e) {
			}
		
			
			try {
				m.setMontantCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU"))*10);

			} catch (Exception e) {
		        m.setMontantCl(0);
			}
			
			
			devise = Integer.parseInt(""+(String) p.get("VTR_BILL_CURR"));
			if(devise==929) {
				m.setMontantCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU")));
			}
			m.setTaux(Double.parseDouble(""+(BigDecimal) p.get("VTR_CHLD_ACC_CURR_RATE")));			
			m.setType(3);
		}
		
		m.setCode(code);
	    m.setDeviseCl(Integer.parseInt(""+(String) p.get("VTR_BILL_CURR")));

			out.add(m);
			
		}
		
		

		return out;
	}
	
	
	static public List<Historique> toHistOut( List<Map<String, Object>> params) {
		
		List<Historique> out =new ArrayList<>();
				
		for(Map<String, Object> p :params) {
		
		Historique m=new Historique();		
		
		m.setDate((Timestamp) p.get("ACH_DATE"));
		
		m.setRecharge(Double.parseDouble(""+(BigDecimal) p.get("ACH_NEW_AVAI_AMOU")));
		m.setAuth_cumu(Double.parseDouble(""+(BigDecimal) p.get("ACH_NEW_AUTH_CUMU")));
		m.setUtilise_cumu(Double.parseDouble(""+(BigDecimal) p.get("ACH_NEW_USED_CUMU")));
		
		m.setGenClearing(""+(String) p.get("ACH_USER"));
		m.setHost(""+(String) p.get("HOST"));
		
			out.add(m);
			
		}
		
		

		return out;
	}

	
	
}
