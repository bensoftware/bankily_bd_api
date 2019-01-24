package mr.bpm.mbanking.helper;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mr.bpm.mbanking.dot.Historique;
import mr.bpm.mbanking.dot.MonetiqueClass;
import mr.bpm.mbanking.dot.SoldeCarte;
import mr.bpm.mbanking.dot.TraitementDto1;

public class MonetiqueCarteHelper {

	static public List<MonetiqueClass> toAuthtOut( List<Map<String, Object>> params) {
	
		List<MonetiqueClass> out =new ArrayList<>();
		
		int cpt=-1;
		
		for(Map<String, Object> p :params) {
			
		
		MonetiqueClass m=new MonetiqueClass();		
		
		
		 try {
			m.setLieu((String) p.get("AUT_CARD_ACCP_NAME_LOC_F043"));
			} catch (Exception e) {
				m.setLieu(null);
				System.out.println(e);
			}
		
		
		 try {
			 m.setDate((Timestamp) p.get("AUT_REQU_SYST_TIME"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
				m.setDeviseSS(Integer.parseInt(""+(String) p.get("AUT_BILL_CURR_F051")));
		} catch (Exception e) {
			m.setDeviseSS(929);
			// TODO: handle exception
		}
		

		 try {
			 m.setMontantTrans(Double.parseDouble(""+(BigDecimal) p.get("AUT_BILL_AMOU_F006")));

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		 
		 try {
			 m.setCommission(Double.parseDouble(""+(BigDecimal) p.get("AUT_COMM_AMOU")));
			} catch (Exception e) {
		        m.setCommission(0);
		    	System.out.println(e);
			}

		   try {
				 m.setRefTrans(Double.parseDouble(""+(String) p.get("AUT_RETR_REF_NUMB_F037")));
	        }catch (Exception e) {
	        	m.setRefTrans(cpt);
	        	m.setRefErone(""+(String) p.get("AUT_RETR_REF_NUMB_F037"));
	        	
	        	cpt--;
	        	System.out.println(e);
	        	
			}
		   
			Date date = m.getDate();
			int annee= date.getYear()+1900;
			int mois= date.getMonth()+1;
			int jour=date.getDate();
			
			int deviseM=978;
			int deviseSS=m.getDeviseSS();
			
			boolean isLimite=false;
			
			if(annee==2017) {
				if( (mois==11 && jour>=13) || (mois==12) ) {
					deviseM=478;
				}
			}else if(annee>2017) {
				deviseM=929;
			}
			
			if( (mois==11 && jour==13 && annee==2017) || (mois==1 && jour==1 && annee==2018) )
				isLimite=true;
			
			
			
			if(deviseSS!=deviseM) {
			
					if(deviseM==978) {
						if(deviseSS==478) {
							m.setMontantTrans(m.getMontantTrans()/414);
							if(isLimite)
							m.setCommission(m.getCommission()/414);
						}else if(deviseSS==929) {
							m.setMontantTrans(m.getMontantTrans()/41.4);
							if(isLimite)
							m.setCommission(m.getCommission()/41.4);
						}
					}else if(deviseM==478) {
                        if(deviseSS==978) {
                        	m.setMontantTrans(m.getMontantTrans()*414);
                        	if(isLimite)
							m.setCommission(m.getCommission()*414);
						}else if(deviseSS==929) {
							m.setMontantTrans(m.getMontantTrans()*10);
							if(isLimite)
							m.setCommission(m.getCommission()*10);
						}
					}else if(deviseM==929) {
                        if(deviseSS==978) {
                        	m.setMontantTrans(m.getMontantTrans()*41.4);
                        	if(isLimite)
							m.setCommission(m.getCommission()*41.4);
						}else if(deviseSS==478) {
							m.setMontantTrans(m.getMontantTrans()/10);
							if(isLimite)
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
		    	System.out.println(e);
			}
			
			try {
				 m.setCodeAuth(Double.parseDouble(""+(String) p.get("AUT_AUTH_ID_RESP_F038")));

			} catch (Exception e) {
		        m.setCodeAuth(0);
		    	System.out.println(e);
			}
			
			try {
				 m.setCode(Integer.parseInt(""+(String) p.get("AUT_TRAN_CODE")));
				 String stat= (String) p.get("AUT_REVE_STAT");
				  
					if(stat.equals("F")) {
						m.setEtat(20);
					}
				} catch (Exception e) {
					System.out.println(e);
			}
			
			try {
				 m.setMontantOrigine(Double.parseDouble(""+(BigDecimal) p.get("AUT_TRAN_AMOU_F004")));
				 m.setDeviseOrigine(Integer.parseInt(""+(String) p.get("AUT_TRAN_CURR_F049")));


			} catch (Exception e) {
				System.out.println(e);
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
		
		boolean excep=false;
		int devise=0;
		
		 try {
			 devise = Integer.parseInt(""+(String) p.get("VTR_BILL_CURR"));
			}catch (Exception e) {
				// TODO: handle exception
				devise=getDeviseByDate(procDate);
				System.out.println(e);
			}
		// recharge Agence
		if(code==19001) {
			
		    try {
		    	 m.setRechargeCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU"))*10 );
		    	 int annee= procDate.getYear()+1900;
					if( (devise==929 || devise==478) && annee>=2018) {
						m.setRechargeCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU")));
					}
				}catch (Exception e) {
					System.out.println(e);
				}
			
			m.setDate(purcDate);
			
			
			//
			int deviseDate =getDeviseByDate(m.getDate());

			if(deviseDate !=devise) {
				double montantCl=0;
				
				if(deviseDate==978) {
					if(devise==478) {
						montantCl=m.getRechargeCl()/414;
					}else if(devise==929) {
						montantCl=m.getRechargeCl()/41.4;
					}
				}else if(deviseDate==478) {
                    if(devise==978) {
                    	montantCl=m.getRechargeCl()*414;
					}else if(devise==929) {
						montantCl=m.getRechargeCl()*10;
					}
				}else if(deviseDate==929) {
                    if(devise==978) {
                    	montantCl=m.getRechargeCl()*41.4;
					}else if(devise==478) {
						montantCl=m.getRechargeCl()/10;
					}
				}
				
				m.setRechargeCl(montantCl);
				m.setDeviseCl(deviseDate);
				
				excep=true;
			}
			
			//
			
	
			m.setType(2);
			
		}
		// recharge GAB
		else if(code==21031) {
			
		    try {
		    	 m.setRechargeCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU"))*10 );
		    	 int annee= procDate.getYear()+1900;
					if((devise==929 || devise==478) && annee>=2018) {
						m.setRechargeCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU")));
					}
				}catch (Exception e) {
					System.out.println(e);
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
					System.out.println(e);
				}
			 
			 m.setTaux(taux);			

			
			Double montantCl= 0.0;
			try {
				montantCl=Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU"))*10;
				
				int annee= procDate.getYear()+1900;
				
				//System.out.println("devise "+devise+" annee "+annee);
				if(devise==929 && annee>=2018) {
					//System.out.println("remourssement");
					m.setMontantCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU")));
				}
				
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
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
    			System.out.println(e);
			}
			
			try {
				 m.setCodeAuth(Double.parseDouble(""+(String) p.get("VTR_AUTH_CODE")));

			} catch (Exception e) {
		        m.setCodeAuth(0);
		    	System.out.println(e);
			}

			try {
				 m.setMontantOrigine(Double.parseDouble(""+(BigDecimal) p.get("VTR_TRAN_AMOU")));
				 m.setDeviseOrigine(Integer.parseInt(""+(String) p.get("VTR_TRAN_CURR")));


			} catch (Exception e) {
				System.out.println(e);
			}
		
			
			try {
				m.setMontantCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU"))*10);
				
				int annee= procDate.getYear()+1900;
				
				if(devise==929 && annee>=2018) {
					m.setMontantCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU")));
				}

			} catch (Exception e) {
		        m.setMontantCl(0);
		    	System.out.println(e);
			}
			
			if(m.getMontantCl()==0 && m.getMontantOrigine()!=0) {
				
				devise=m.getDeviseOrigine();
				m.setMontantCl(m.getMontantOrigine());
				
			}
			
			//
			int deviseDate =getDeviseByDate(m.getDate());

			if(deviseDate !=devise) {
				double montantCl=0;
				
				if(deviseDate==978) {
					if(devise==478) {
						montantCl=m.getMontantCl()/414;
					}else if(devise==929) {
						montantCl=m.getMontantCl()/41.4;
					}
				}else if(deviseDate==478) {
                    if(devise==978) {
                    	montantCl=m.getMontantCl()*414;
					}else if(devise==929) {
						montantCl=m.getMontantCl()*10;
					}
				}else if(deviseDate==929) {
                    if(devise==978) {
                    	montantCl=m.getMontantCl()*41.4;
					}else if(devise==478) {
						montantCl=m.getMontantCl()/10;
					}
				}
				
				m.setMontantCl(montantCl);
				m.setDeviseCl(deviseDate);
				
				excep=true;
			}
			
			//
			
			
			
			try {
				m.setTaux(Double.parseDouble(""+(BigDecimal) p.get("VTR_CHLD_ACC_CURR_RATE")));		

			} catch (Exception e) {
				m.setTaux(0);		
				System.out.println(e);
			}
			
			
			if(code==10128) {
				
				deviseDate =getDeviseByDate(m.getDate());
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
		if(!excep)
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
	
	
	
 public static void toTrait1Out( List<Map<String, Object>> params) {
		
	

		List<TraitementDto1> amp =new ArrayList<>();
		
		// 10 minutes
		long marge = 10 * 60*1000 ;
		
           
		for(Map<String, Object> p :params) {
			
		Date date= (Timestamp) p.get("VTR_PURC_DATE");
		Double montant=Double.parseDouble(""+(BigDecimal) p.get("VTR_TRAN_AMOU"));		
		String pan=(String) p.get("VTR_CARD_NUMB");
		
		//
		
		TraitementDto1 item= new TraitementDto1(date, montant, pan);
		
		amp.add(item);
		
	
		
	

			
		}
		
	// trait
		
		traitementAmp2(amp,marge);
		// 
				
		/*for(Map<String, Object> p :params) {
			
			int size=amp.size();
			
		
		
		Date date= (Timestamp) p.get("VTR_PURC_DATE");
		Double montant=Double.parseDouble(""+(BigDecimal) p.get("VTR_TRAN_AMOU"));		
		String pan=(String) p.get("VTR_CARD_NUMB");
		
		//
		
		TraitementDto1 item= new TraitementDto1(date, montant, pan);
		
		if(size==0) {
			
			amp.add(item);
			
		}else {
			
			double diff =item.getDate().getTime()-amp.get(0).getDate().getTime();
			
			if(diff <= marge) {
				amp.add(item);
			}else {
				if(size>=2) {
					// traitement sur amp
					traitementAmp(amp);
				}
				
				// suppression recurssive
				amp=suppRecurssive(amp,item,marge);
				amp.add(item);
			}
			
		}

	//	list.add(new TraitementDto1(date, montant, pan));
			
		}
		
		
		// 
*/		
		
		
		

	}
 
 
 
 
 private static void traitementAmp2(List<TraitementDto1> amp,long marge) {
	 
	 int size= amp.size();
	
	 Set<TraitementDto1> res= new HashSet<>();
	 
	 for(int i=0;i<size;i++) {
		 TraitementDto1 item1=amp.get(i);
		 for(int j=i+1;j<size;j++) {
			 if(i!=j) {
				 TraitementDto1 item2=amp.get(j);
				 long diff=item2.getDate().getTime() - item1.getDate().getTime();
				// System.out.println(diff);
				 if(diff>=marge)
					 break;
				 
				 if(item1.getMontant().equals(item2.getMontant())   && item1.getPan().equals(item2.getPan())) {
					 res.add(item1);
					 break;
				 }
			 }
		 }
	 }
	 

	 
 }
 
 
 
 
 private static List<TraitementDto1> suppRecurssive(List<TraitementDto1> amp , TraitementDto1 item,double marge) {
	 
	 for(int i=0; i<amp.size();i++) {
		TraitementDto1 x=amp.get(i);
		
		double diff =item.getDate().getTime()-x.getDate().getTime();
		
		if(diff > marge) {
			amp.remove(i);
		}
	 }
	 
	 return amp;

 }

 private static void traitementAmp(List<TraitementDto1> amp) {
	 
	 int size= amp.size();
	
	 Set<TraitementDto1> res= new HashSet<>();
	 
	 for(int i=0;i<size;i++) {
		 TraitementDto1 item1=amp.get(i);
		 for(int j=0;j<size;j++) {
			 if(i!=j) {
				 TraitementDto1 item2=amp.get(j);
				 
				 if(item1.getMontant()==item2.getMontant() && item1.getPan().equals(item2.getPan())) {
					 res.add(item1);
					 break;
				 }
			 }
		 }
	 }
	 
/*	 for(TraitementDto1 x : res) {
		 System.out.println("PAN = "+x.getPan()+ " Montant = "+x.getMontant()+" Date = "+x.getDate().toGMTString());
	 }*/
	 
 }

	
	 public static SoldeCarte toSoldetOut( List<Map<String, Object>> params,double pan) {

		SoldeCarte m= new SoldeCarte();		

		
		for(Map<String, Object> p :params) {
		
	
m.setRechargeCum(0);
try {
	m.setRechargeCum(Double.parseDouble(""+(BigDecimal) p.get("ACC_AVAI_AMOU")));

} catch (Exception e) {
	// TODO: handle exception
	System.out.println("montant NULL rech cum "+pan);

}	

m.setAuthCum(0);
try {
	m.setAuthCum(Double.parseDouble(""+(BigDecimal) p.get("ACC_AUTH_CUMU")));

} catch (Exception e) {
	// TODO: handle exception
	System.out.println("montant NULL Auth cum "+pan);

}

m.setUsedCum(0);
try {
	m.setUsedCum(Double.parseDouble(""+(BigDecimal) p.get("ACC_USED_CUMU")));

} catch (Exception e) {
	// TODO: handle exception
	System.out.println("montant NULL used cum "+pan);

}

			
		}
		return m;
	}
	
	
 public static List<Double> toCarteOut( List<Map<String, Object>> params) {
		
		List<Double> out =new ArrayList<>();
				
		for(Map<String, Object> p :params) {
		
		Double m=0.0;
		
        m=Double.parseDouble(""+(String) p.get("CAR_NUMB"));		
	
        out.add(m);
			
		}
		
		

		return out;
	}

 
 
 static public List<MonetiqueClass> toClSSOut(List<Map<String, Object>> params) {
		
		List<MonetiqueClass> out =new ArrayList<>();
		
	    
		
		for(Map<String, Object> p :params) {
		
		MonetiqueClass m=new MonetiqueClass();		
		
		Date procDate=(Timestamp) p.get("VTR_PROC_DATE");
		Date purcDate=(Timestamp) p.get("VTR_PURC_DATE");
		
		String pan=null;
		
		try {
			 pan= (String) p.get("VTR_CARD_NUMB") ;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// Pan
		m.setLieu(pan);
		
		int code =Integer.parseInt(""+(String) p.get("VTR_TC_CODE"));
		
		boolean excep=false;
		int devise=0;
		
		 try {
			 devise = Integer.parseInt(""+(String) p.get("VTR_BILL_CURR"));
			}catch (Exception e) {
				// TODO: handle exception
				devise=getDeviseByDate(procDate);
				System.out.println(e);
			}
		// recharge Agence
		if(code==19001) {
			
		    try {
		    	 m.setRechargeCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU"))*10 );
		    	 int annee= procDate.getYear()+1900;
					if( (devise==929 || devise==478) && annee>=2018) {
						m.setRechargeCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU")));
					}
				}catch (Exception e) {
					System.out.println(e);
				}
			
			m.setDate(purcDate);
			
			
			//
			int deviseDate =getDeviseByDate(m.getDate());

			if(deviseDate !=devise) {
				double montantCl=0;
				
				if(deviseDate==978) {
					if(devise==478) {
						montantCl=m.getRechargeCl()/414;
					}else if(devise==929) {
						montantCl=m.getRechargeCl()/41.4;
					}
				}else if(deviseDate==478) {
                 if(devise==978) {
                 	montantCl=m.getRechargeCl()*414;
					}else if(devise==929) {
						montantCl=m.getRechargeCl()*10;
					}
				}else if(deviseDate==929) {
                 if(devise==978) {
                 	montantCl=m.getRechargeCl()*41.4;
					}else if(devise==478) {
						montantCl=m.getRechargeCl()/10;
					}
				}
				
				m.setRechargeCl(montantCl);
				m.setDeviseCl(deviseDate);
				
				excep=true;
			}
			
			//
			
	
			m.setType(2);
			
		}
		// recharge GAB
		else if(code==21031) {
			
		    try {
		    	 m.setRechargeCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU"))*10 );
		    	 int annee= procDate.getYear()+1900;
					if((devise==929 || devise==478) && annee>=2018) {
						m.setRechargeCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU")));
					}
				}catch (Exception e) {
					System.out.println(e);
				}
			
			m.setDate(purcDate);
			
		
			m.setType(2);
			
		}
		// rembourssement
		else if(code==6000) {
			
			m.setDate(procDate);
			
			 m.setMontantOrigine(Double.parseDouble(""+(BigDecimal) p.get("VTR_TRAN_AMOU")));
			 m.setDeviseOrigine(Integer.parseInt(""+(String) p.get("VTR_TRAN_CURR")));
			 
			
			
			Double montantCl= 0.0;
			try {
				montantCl=Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU"))*10;
				
				int annee= procDate.getYear()+1900;
				
				//System.out.println("devise "+devise+" annee "+annee);
				if(devise==929 && annee>=2018) {
					//System.out.println("remourssement");
					m.setMontantCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU")));
				}
				
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			//m.setMontantCl(montantCl);

			
			
 		m.setType(4);
		}
		// a rectifier apres
		else {
			m.setDate(procDate);
			
			if(code==7000 || code==7001) {
				int banqueAq=8401;
				int banqueEmet=8401;
				
				
				try {
					banqueEmet=Integer.parseInt(""+(BigDecimal) p.get("vtr_issu_ban_code"));
					
				} catch (Exception e) {
					// TODO: handle exception
					banqueEmet=0;
				}
				try {
					banqueAq=Integer.parseInt(""+(BigDecimal) p.get("vtr_acqu_ban_code"));
					
				} catch (Exception e) {
					// TODO: handle exception
					 banqueAq=0;
				}
				
				if(banqueAq==8401 && banqueEmet==8401) {
					continue;
				}
			}
		
			
			
			try {
				m.setRefCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_AUT_RETR_REF_NUMB")));

			}catch (Exception e) {
 			m.setRefCl(0);
 			System.out.println(e);
			}
			
			try {
				 m.setCodeAuth(Double.parseDouble(""+(String) p.get("VTR_AUTH_CODE")));

			} catch (Exception e) {
		        m.setCodeAuth(0);
		    	System.out.println(e);
			}

			try {
				 m.setMontantOrigine(Double.parseDouble(""+(BigDecimal) p.get("VTR_TRAN_AMOU")));
				 m.setDeviseOrigine(Integer.parseInt(""+(String) p.get("VTR_TRAN_CURR")));


			} catch (Exception e) {
				System.out.println(e);
			}
		
			
			try {
				m.setMontantCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU"))*10);
				
				int annee= procDate.getYear()+1900;
				
				if(devise==929 && annee>=2018) {
					m.setMontantCl(Double.parseDouble(""+(BigDecimal) p.get("VTR_BILL_AMOU")));
				}

			} catch (Exception e) {
		        m.setMontantCl(0);
		    	System.out.println(e);
			}
			
			if(m.getMontantCl()==0 && m.getMontantOrigine()!=0) {
				
				devise=m.getDeviseOrigine();
				m.setMontantCl(m.getMontantOrigine());
				
			}
			
			//
			int deviseDate =getDeviseByDate(m.getDate());

			if(deviseDate !=devise) {
				double montantCl=0;
				
				if(deviseDate==978) {
					if(devise==478) {
						montantCl=m.getMontantCl()/414;
					}else if(devise==929) {
						montantCl=m.getMontantCl()/41.4;
					}
				}else if(deviseDate==478) {
                 if(devise==978) {
                 	montantCl=m.getMontantCl()*414;
					}else if(devise==929) {
						montantCl=m.getMontantCl()*10;
					}
				}else if(deviseDate==929) {
                 if(devise==978) {
                 	montantCl=m.getMontantCl()*41.4;
					}else if(devise==478) {
						montantCl=m.getMontantCl()/10;
					}
				}
				
				m.setMontantCl(montantCl);
				m.setDeviseCl(deviseDate);
				
				excep=true;
			}
			
			//
			
			
		
			
			if(code==10128) {
				
				deviseDate =getDeviseByDate(m.getDate());
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
		if(!excep)
	    m.setDeviseCl(devise);

			out.add(m);
			
		}
		
		

		return out;
	}
	
	
	
}
