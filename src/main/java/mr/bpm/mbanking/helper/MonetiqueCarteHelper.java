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
			 m.setDate((Timestamp) p.get("AUT_REQU_SYST_TIME"));
			m.setDeviseSS(Integer.parseInt(""+(String) p.get("AUT_BILL_CURR_F051")));
			} catch (Exception e) {
			}
		

		 m.setMontantTrans(Double.parseDouble(""+(BigDecimal) p.get("AUT_BILL_AMOU_F006")));
		 try {
			 m.setCommission(Double.parseDouble(""+(BigDecimal) p.get("AUT_COMM_AMOU")));
			} catch (Exception e) {
		        m.setCommission(0);
			}

		   try {
				 m.setRefTrans(Double.parseDouble(""+(String) p.get("AUT_RETR_REF_NUMB_F037")));
	        }catch (Exception e) {
	        	m.setRefTrans(cpt);
	        	m.setRefErone(""+(String) p.get("AUT_RETR_REF_NUMB_F037"));
	        	m.setMontantOrigine(Double.parseDouble(""+(BigDecimal) p.get("AUT_TRAN_AMOU_F004")));
	   		    m.setDeviseOrigine(Integer.parseInt(""+(String) p.get("AUT_TRAN_CURR_F049")));
	        	cpt--;
	        	
			}
		   
			Date date = m.getDate();
			int annee= date.getYear()+1900;
			int mois= date.getMonth()+1;
			int jour=date.getDate();
			
			int deviseM=978;
			int deviseSS=m.getDeviseSS();
			
			if(annee==2017) {
				if( (mois==11 && jour>=13) || (mois==12) ) {
					deviseM=478;
				}
			}else if(annee>2017) {
				deviseM=929;
			}
			if(deviseSS!=deviseM) {
			
					if(deviseM==978) {
						if(deviseSS==478) {
							m.setMontantTrans(m.getMontantTrans()/414);
							m.setCommission(m.getCommission()/414);
						}else if(deviseSS==929) {
							m.setMontantTrans(m.getMontantTrans()/41.4);
							m.setCommission(m.getCommission()/41.4);
						}
					}else if(deviseM==478) {
                        if(deviseSS==978) {
                        	m.setMontantTrans(m.getMontantTrans()*414);
							m.setCommission(m.getCommission()*414);
						}else if(deviseSS==929) {
							m.setMontantTrans(m.getMontantTrans()*10);
							m.setCommission(m.getCommission()*10);
						}
					}else if(deviseM==929) {
                        if(deviseSS==978) {
                        	m.setMontantTrans(m.getMontantTrans()*41.4);
							m.setCommission(m.getCommission()*41.4);
						}else if(deviseSS==478) {
							m.setMontantTrans(m.getMontantTrans()/10);
							m.setCommission(m.getCommission()/10);
						}
					}
			//	m.setEpoque(false);
			}
			
			m.setDeviseSS(deviseM);
			

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
			
			m.setType(1);
			
			out.add(m);
			
		}
		
		

		return out;
	}

	private static int getDeviseByDate(Date d) {
		Date date = d;
		int annee= date.getYear()+1900;
		int mois= date.getMonth()+1;
		int jour=date.getDate();
		
		int deviseM=978;
		
		if(annee==2017) {
			if( (mois==11 && jour>=13) || (mois==12) ) {
				deviseM=478;
			}
		}else if(annee>2017) {
			deviseM=929;
		}
		
		return deviseM;
	}


	static public List<MonetiqueClass> toClOut(List<Map<String, Object>> params) {
		
		List<MonetiqueClass> out =new ArrayList<>();
		
	    
		
		for(Map<String, Object> p :params) {
		
		MonetiqueClass m=new MonetiqueClass();		
		
		Date procDate=(Timestamp) p.get("VTR_PROC_DATE");
		Date purcDate=(Timestamp) p.get("VTR_PURC_DATE");
		
		int code =Integer.parseInt(""+(String) p.get("VTR_TC_CODE"));
		
		
		int devise=0;
		
		 try {
			 devise = Integer.parseInt(""+(String) p.get("VTR_BILL_CURR"));
			}catch (Exception e) {
				// TODO: handle exception
				devise=getDeviseByDate(procDate);
			}
		// recharge Agence
		if(code==19001) {
			
		    try {
		    	 m.setRechargeCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU"))*10 );
		    	 int annee= procDate.getYear()+1900;
					if(devise==929 && annee>=2018) {
						m.setRechargeCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU")));
					}
				}catch (Exception e) {
					
				}
			
			m.setDate(purcDate);
			
	
			m.setType(2);
			
		}
		// recharge GAB
		else if(code==21031) {
			
		    try {
		    	 m.setRechargeCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU"))*10 );
		    	 int annee= procDate.getYear()+1900;
					if(devise==929 && annee>=2018) {
						m.setRechargeCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU")));
					}
				}catch (Exception e) {
					
				}
			
			m.setDate(purcDate);
			
		
			m.setType(2);
			
		}
		// rembourssement
		else if(code==6000) {
			
			m.setDate(procDate);
			
			 m.setMontantOrigine(Double.parseDouble(""+(BigDecimal) p.get("VTR_TRAN_AMOU")));
			 m.setDeviseOrigine(Integer.parseInt(""+(String) p.get("VTR_TRAN_CURR")));
			 
			 
			 Double taux=0.0;
			 
			 try {
				 taux=Double.parseDouble(""+(BigDecimal) p.get("VTR_CHLD_ACC_CURR_RATE"));
				}catch (Exception e) {
					// TODO: handle exception
				}
			 
			 m.setTaux(taux);			

			
			Double montantCl= 0.0;
			try {
				montantCl=Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU"))*10;
				
				int annee= procDate.getYear()+1900;
				
				System.out.println("devise "+devise+" annee "+annee);
				if(devise==929 && annee>=2018) {
					System.out.println("remourssement");
					m.setMontantCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU")));
				}
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			//m.setMontantCl(montantCl);

			
			
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
				
				int annee= procDate.getYear()+1900;
				
				if(devise==929 && annee>=2018) {
					m.setMontantCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU")));
				}

			} catch (Exception e) {
		        m.setMontantCl(0);
			}
			
			
			
			try {
				m.setTaux(Double.parseDouble(""+(BigDecimal) p.get("VTR_CHLD_ACC_CURR_RATE")));		

			} catch (Exception e) {
				m.setTaux(0);		
			}
			
			
			if(code==10128) {
				
				int deviseDate =getDeviseByDate(m.getDate());
				int deviseO=m.getDeviseOrigine();

				

				if(deviseDate !=m.getDeviseOrigine()) {
					double montantCl=0;
					
					if(deviseDate==978) {
						if(deviseO==478) {
							montantCl=m.getMontantOrigine()/414;
						}else if(deviseO==929) {
							montantCl=m.getMontantOrigine()/41.4;
						}
					}else if(deviseDate==478) {
                        if(deviseO==978) {
                        	montantCl=m.getMontantOrigine()*414;
						}else if(deviseO==929) {
							montantCl=m.getMontantOrigine()*10;
						}
					}else if(deviseDate==929) {
                        if(deviseO==978) {
                        	montantCl=m.getMontantOrigine()*41.4;
						}else if(deviseO==478) {
							montantCl=m.getMontantOrigine()/10;
						}
					}
					
					m.setMontantCl(montantCl);
					m.setDeviseCl(deviseDate);
					
					
				}else {
					m.setMontantCl(m.getMontantOrigine());
					m.setDeviseCl(m.getDeviseOrigine());
				}
			
			}
			
			m.setType(3);
		}
		
		m.setCode(code);
	    m.setDeviseCl(devise);

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
	
	
static public List<Double> toCarteOut( List<Map<String, Object>> params) {
		
		List<Double> out =new ArrayList<>();
				
		for(Map<String, Object> p :params) {
		
		Double m=0.0;
		
        m=Double.parseDouble(""+(String) p.get("AUT_PRIM_ACCT_NUMB_F002"));		
	
        out.add(m);
			
		}
		
		

		return out;
	}

	
	
}
