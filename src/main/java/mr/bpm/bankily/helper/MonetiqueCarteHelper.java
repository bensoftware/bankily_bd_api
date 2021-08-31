package mr.bpm.bankily.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import mr.bpm.bankily.dot.BankilyResponse;
import mr.bpm.bankily.dot.Client;
import mr.bpm.bankily.dot.ClientConsultation;
import mr.bpm.bankily.dot.ClientStatistique;
import mr.bpm.bankily.dot.Merchant;
import mr.bpm.bankily.dot.PaiementMerchant;
import mr.bpm.bankily.dot.ResponseDto;
import mr.bpm.bankily.dot.TransImal;
import mr.bpm.bankily.dot.TrsMobile;
import mr.bpm.bankily.dot.TrsMobileBus;


public class MonetiqueCarteHelper {


		
	
static public String getKycId( List<Map<String, Object>> params) {
		
		String out =null;
		
		if(params==null)
			return null;
		
		for(Map<String, Object> p :params) {
			
			 try {
				 
				 String res=""+p.get("kyc_id");
				 
				 out= res; 
				 break;
				} catch (Exception e) {
					System.out.println(e);
				}
	
			
		}
		
		

		return out;
	}

static public String toPartyId( List<Map<String, Object>> params) {
	
	String out =null;
	
	
	for(Map<String, Object> p :params) {
		
		 try {
			 
			 String res=""+p.get("party_id");
			 
			 out= res; 
			 break;
			} catch (Exception e) {
				System.out.println(e);
			}

		
	}
	
	

	return out;
}
	
static public String toCif( List<Map<String, Object>> params) {
		
		String out =null;
		
		
		for(Map<String, Object> p :params) {
			
			 try {
				 
				 String res=""+p.get("CIF");
				 
				 out= res; 
				 break;
				} catch (Exception e) {
					System.out.println(e);
				}
	
			
		}
		
		

		return out;
	}

	
	static public Client getClient( List<Map<String, Object>> params) {
		
		Client out =new Client();
		
		
		for(Map<String, Object> p :params) {
			
			 try {
				 
				 String log=""+p.get("LOGIN_ID");
				 
				 out.setLogin(log);
				} catch (Exception e) {
					System.out.println(e);
				}
			 
	 try {
				 
				 String tel=""+p.get("MSISDN");
				 
				 out.setTelephone(tel);
				} catch (Exception e) {
					System.out.println(e);
				}

	 break;

		}
		
		

		return out;
	}

	


static public BankilyResponse getPartyId( List<Map<String, Object>> params) {
	
	BankilyResponse out =new  BankilyResponse();
	
	
	for(Map<String, Object> p :params) {
		
		String nomB=null;
		 try {
			 
			 String res=""+p.get("PARTY_ID");
			out.setPartyId(res);
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 
 try {
			 
			  nomB=""+p.get("first_name");
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 
 try {
	 
	 nomB+=" "+p.get("last_name");
	
	} catch (Exception e) {
		System.out.println(e);
	}
 
 out.setNomBankily(nomB);
 
            try {
			 
			 String status=""+p.get("KYC_STATUS");
			 out.setStatus(status);

			} catch (Exception e) {
				System.out.println(e);
			}
		 
return out;
		
	}
	
	

	return out;
}
static public BankilyResponse getAddRef( List<Map<String, Object>> params) {
	
	BankilyResponse out =new  BankilyResponse();
	
	
	for(Map<String, Object> p :params) {
		
		 try {
			 
			 String res=""+p.get("account_no");
			out.setAdditionalReference(res);
			
			 if(res!=null)
				 return out;
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 


		
	}
	
	

	return out;
}



static public BankilyResponse getInfoPIN( List<Map<String, Object>> params) {
	
	BankilyResponse out =new  BankilyResponse();
	
	
	for(Map<String, Object> p :params) {
		
	 try {
			 
			 Date exp=(Date)p.get("attempts_expiry_time");
			out.setDateExpiration(exp);
			
			} catch (Exception e) {
				System.out.println(e);
			}
	 
	 try {
		 
		 BigDecimal tentb=(BigDecimal)p.get("invalid_password_count");
		out.setTentative(tentb.intValue());
		
		} catch (Exception e) {
			System.out.println(e);
		}
		 try {
			 
			 String res=""+p.get("USER_ID");
			out.setUserId(res);
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 
 try {
	 String res=""+p.get("login_id");
	 out.setLogin_id(res);
			} catch (Exception e) {
				System.out.println(e);
			}

 try {
	 String res=""+p.get("otp");
	 out.setOtp(res);
			} catch (Exception e) {
				System.out.println(e);
			}

 
return out;
		
	}
	
	

	return out;
}



static public String getUserId( List<Map<String, Object>> params) {

	if(params==null || params.size()==0)
		return null;
	
	for(Map<String, Object> p :params) {
				
     
		 try {
			 
			String res=""+p.get("user_id");
            return res;			
			} catch (Exception e) {
				System.out.println(e);
			}

	}

	return null;
}


static public ResponseDto getKycStatus( List<Map<String, Object>> params) {
	
	for(Map<String, Object> p :params) {

		ResponseDto res=new ResponseDto();

		try {
			 
			String kyc=""+p.get("KYC_STATUS");
			res.setKycStatus(kyc);
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
			 int status= Integer.parseInt(""+p.get("status"));
			 res.setStatus(status);
				} catch (Exception e) {
					System.out.println(e);
				}

		 return res;
	}

	return null;
}



static public List<ClientStatistique> getUserIds( List<Map<String, Object>> params) {
	
	List<ClientStatistique> out= new ArrayList<>();
	
	
	if(params==null || params.size()==0)
		return null;
		
	
	for(Map<String, Object> p :params) {
	
		ClientStatistique c= new ClientStatistique();
	 try {
			 
		 c.setUserId(""+p.get("USER_ID"));
			} catch (Exception e) {
				System.out.println(e);
			}
	 try {
		 c.setNni(""+p.get("kyc_value"));
	} catch (Exception e) {
		System.out.println(e);
	}
	 
	 out.add(c);
         		
	}
	
	

	return out;
}


static public Client getTel( List<Map<String, Object>> params) {
	
	Client out =new  Client();
	
	
	for(Map<String, Object> p :params) {
				
     
		 try {
			 
			String res=""+p.get("msisdn");
			out.setTelephone(res);
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
			 
				int lang=Integer.parseInt(""+p.get("pref_language"));
				out.setLangue(lang);
				
				} catch (Exception e) {
					System.out.println(e);
				}
		 


 
     return out;
		
	}
	
	

	return out;
}


public static  List<ClientStatistique> getCLient( List<Map<String, Object>> params) {
	
	List<ClientStatistique> list= new ArrayList<>();
	
	
	for(Map<String, Object> p :params) {
		
		ClientStatistique c= new ClientStatistique();
		
		
		 try {
			 
			  c.setTokenFirebase(""+p.get("rnsid"));  				
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 try {
			 
			  c.setTelephone(""+p.get("MSISDN"));  				
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 try {
			 
			  c.setUserId(""+p.get("user_id"));  				
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
			 
			  c.setNom(""+p.get("first_name"));  				
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
		       c.setDateCreation((Date)p.get("created_on"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 

		 list.add(c);
	}


return list;
}



public static  List<ClientStatistique> getCLientNew( List<Map<String, Object>> params) {
	
	List<ClientStatistique> list= new ArrayList<>();
	
	
	for(Map<String, Object> p :params) {
		
		ClientStatistique c= new ClientStatistique();
		
		
		
		 try {
		       c.setDateCreation((Date)p.get("created_on"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		
		 try {
			 
			  c.setTelephone(""+p.get("MSISDN"));  				
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 try {
			 
			  c.setUserId(""+p.get("user_id"));  				
			
			} catch (Exception e) {
				System.out.println(e);
			}

		 list.add(c);
	}


return list;
}


public static  List<ClientStatistique> getCLientLiaisonFull( List<Map<String, Object>> params) {
	
	List<ClientStatistique> list= new ArrayList<>();
	
	
	for(Map<String, Object> p :params) {
		
		ClientStatistique c= new ClientStatistique();
		
		

		
		 try {
			 
			  c.setAgenceCreation(""+p.get("agence_creation"));  				
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 try {
			 
			  c.setAgence(""+p.get("agence_compte"));  				
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 try {
			 
			  c.setCif(""+p.get("cifid"));  				
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 try {
			 
			  c.setNom(""+p.get("approuver"));  				
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 

		 list.add(c);
	}


return list;
}


public static List<ClientStatistique> getCompleteCLientNew( List<Map<String, Object>> params) {
	
	List<ClientStatistique> res= new ArrayList<>();
	
	for(Map<String, Object> p :params) {
		
	  ClientStatistique c= new ClientStatistique();
		
	  
	  
	  try {
			 
		  c.setUserId(""+p.get("user_id"));  				
		
		} catch (Exception e) {
			System.out.println(e);
		}
		 try {
			 
			  c.setNom(""+p.get("cifname"));  				
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
			 
			  c.setCif(""+p.get("cifid"));  				
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
			 
			  c.setCompte(""+p.get("account_no"));  				
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
			 
			  c.setAgence(""+p.get("code_agence"));  				
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 res.add(c);
	}


return res;
}



public static List<ClientStatistique> getActifs( List<Map<String, Object>> params) {
	
	
	List<ClientStatistique> list= new ArrayList<>();
	
	for(Map<String, Object> p :params) {
		
		ClientStatistique c= new ClientStatistique();
		
		 try {
			 
			  c.setUserId(""+p.get("payee_user_id"));  				
			
			} catch (Exception e) {
				System.out.println(e);
			}

	    list.add(c);
	}


return list;
}

public static List<ClientStatistique> getActifsC( List<Map<String, Object>> params) {
	
	
	List<ClientStatistique> list= new ArrayList<>();
	
	for(Map<String, Object> p :params) {
		
		ClientStatistique c= new ClientStatistique();
		
		 try {
			 
			  c.setUserId(""+p.get("payer_user_id"));  				
			
			} catch (Exception e) {
				System.out.println(e);
			}

	    list.add(c);
	}


return list;
}

static public int getStatusUser( List<Map<String, Object>> params) {
	
	
	
	
	for(Map<String, Object> p :params) {
		
		 try {
			 
			 return Integer.parseInt(""+p.get("status"));
			
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 

	}
	
	

	return -1;
}




static public int getTotal( List<Map<String, Object>> params) {
	
	
	
	
	for(Map<String, Object> p :params) {
		
		 try {
			 
			 return Integer.parseInt(""+p.get("total"));
			
			
			} catch (Exception e) {
				System.out.println(e);
			}
		 

	}
	
	

	return 0;
}

static public String getLogin( List<Map<String, Object>> params) {
	
	String out =null;
	
	
	for(Map<String, Object> p :params) {
		
		 try {
			 
			 String res=""+p.get("LOGIN_ID");
			 
			 out= res; 
			 break;
			} catch (Exception e) {
				System.out.println(e);
			}

		
	}
	
	

	return out;
}


static public String getTelephone( List<Map<String, Object>> params) {
	
	String out =null;
	
	
	for(Map<String, Object> p :params) {
		
		 try {
			 
			 String res=""+p.get("MSISDN");
			 
			 out= res; 
			 break;
			} catch (Exception e) {
				System.out.println(e);
			}

		
	}
	
	

	return out;
}


static public String getStatus( List<Map<String, Object>> params) {	
	
	for(Map<String, Object> p :params) {
		
		 
		 try {
			 
			 String res=""+p.get("transfer_status");
			 
			return res;
			 
			} catch (Exception e) {
				System.out.println(e);
			}

	}
	
	return null;
		
	}

static public List<String> getTransactionIdMobile( List<Map<String, Object>> params) {	
	
	if(params==null || params.size()==0)
		return null;
	
	List<String> list=new ArrayList<>();

	for(Map<String, Object> p :params) {
		 try {
		      String trsId=  ""+p.get("transfer_id");
		      list.add(trsId);
			} catch (Exception e) {
				System.out.println(e);
			}	 
	}
	return list;
	
}
	

static public List<TrsMobileBus> getListMobile( List<Map<String, Object>> params) {	
	
	
	List<TrsMobileBus> list=new ArrayList<>();
	
	
	
	
	if(params==null || params.size()==0)
		return list;
	
	
	for(Map<String, Object> p :params) {
		
		TrsMobileBus res= new TrsMobileBus();
		
		 try {
		       res.setDateCreation((Date)p.get("date_creation"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
		       res.setTransactionId(""+p.get("transfer_id"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 
		 try {
		       res.setDateModification((Date)p.get("date_modification"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
		       res.setLanguage(""+p.get("language"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
		       res.setLanguage(""+p.get("language"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
		       res.setMontant(((BigDecimal)p.get("montant")).doubleValue()/100);
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
			 // chinguitel 45290573
			 // Mauritel 45290570
			 // mattel 45290575
			 String op=null;
			 String num=  ""+p.get("operateur");
			 if(num!=null) {
				 if(num.equals("45290573")) {
					op="CHINGUITEL" ;
				 }
				 else if(num.equals("45290570")) {
						op="MAURITEL" ;
					 }
				 else if(num.equals("45290575")) {
						op="MATTEL" ;
					 }
			 }
			 
		       res.setOperateur(op);
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
		       res.setStatus(""+p.get("status"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
		       res.setTelephoneClient(""+p.get("tel_source"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
		       res.setTypeOperation(""+p.get("type_operation"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 list.add(res);

	}
	
	return list;
		
	}


static public TrsMobileBus getTrsMobile( List<Map<String, Object>> params) {	
	
	
	
	
	
	
	if(params==null || params.size()==0)
		return null;
	
	
	for(Map<String, Object> p :params) {
		
		TrsMobileBus res= new TrsMobileBus();
		
		 try {
		       res.setDateCreation((Date)p.get("date_creation"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
		       res.setTransactionId(""+p.get("transfer_id"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 
		 try {
		       res.setDateModification((Date)p.get("date_modification"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
		       res.setLanguage(""+p.get("language"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
		       res.setLanguage(""+p.get("language"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
		       res.setMontant(((BigDecimal)p.get("montant")).doubleValue()/100);
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
			 // chinguitel 45290573
			 // Mauritel 45290570
			 // mattel 45290575
			 String op=null;
			 String num=  ""+p.get("operateur");
			 if(num!=null) {
				 if(num.equals("45290573")) {
					op="CHINGUITEL" ;
				 }
				 else if(num.equals("45290570")) {
						op="MAURITEL" ;
					 }
				 else if(num.equals("45290575")) {
						op="MATTEL" ;
					 }
			 }
			 
		       res.setOperateur(op);
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
		       res.setStatus(""+p.get("status"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
		       res.setTelephoneClient(""+p.get("tel_source"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {
		       res.setTypeOperation(""+p.get("type_operation"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
	     return res;

	}
	
	return null;
		
	}







static public Client getOtp( List<Map<String, Object>> params) {	
	
		
	Client res= new Client();
	
	if(params==null || params.size()==0)
		return null;
	
	
	for(Map<String, Object> p :params) {
		
		 try {		 
			 res.setOtp( ""+p.get("OTP"));
			} catch (Exception e) {
				System.out.println(e);
			}
		
		 try {	
			 res.setDateCreationOtp((Date)p.get("CREATED_ON"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {	
			 res.setDateExpirationOtp((Date)p.get("EXPIRY_TIME"));
			} catch (Exception e) {
				System.out.println(e);
			} 
		 
	    return res;

	}
	
	return null;
		
	}




static public List<ClientStatistique> getCifs( List<Map<String, Object>> params) {	
	
		
	List<ClientStatistique> clients=new ArrayList<>();
	
	if(params==null || params.size()==0)
		return null;
	
	
	for(Map<String, Object> p :params) {
		
		ClientStatistique client=new ClientStatistique();
		
		 try {		 
			 client.setCif( ""+p.get("CIF"));
			} catch (Exception e) {
				System.out.println(e);
			}

		 clients.add(client);

	}
	
	return clients;
		
	}





static public List<TransImal> getTransStatus( List<Map<String, Object>> params) {	
	
	
	List<TransImal> out = new ArrayList<>();
	
	for(Map<String, Object> p :params) {
		
		TransImal t=new TransImal();
		 
		 try {
			 
			 double montant= ((BigDecimal)p.get("TRANSFER_VALUE")).doubleValue();
			 montant=montant/100;
			 
			Date date = (Date)p.get("TRANSFER_ON");
			
			String idTrans=  ""+p.get("TRANSFER_ID");
			
			String status=  ""+p.get("TRANSFER_STATUS");
			
			t.setIdTrans(idTrans);
			t.setDate(date);
			t.setMontant(montant);
			t.setStatus(status);
			
			out.add(t);
			 
			} catch (Exception e) {
				System.out.println(e);
			}

	}
	
	return out;
		
	}







static public List<TrsMobile> getTransMobile( List<Map<String, Object>> params) {	
	
	
	List<TrsMobile> out = new ArrayList<>();
	
	String tel=null;
	Date date=null;
	String status=null;
	
	for(Map<String, Object> p :params) {
		
	 try {			 
		  tel=""+p.get("ATTR_4_VALUE");		 			 			   
		  date = (Date)p.get("CREATED_ON");	
		  status=""+p.get("transfer_status");	
		  
		  out.add(new TrsMobile(tel, date,status));
		  
		  
	 } catch (Exception e) {}

	}
	
	return out;
		
	}
	

static public boolean getStatusByIdParty( List<Map<String, Object>> params) {
	
	boolean out =false;
	
	
	for(Map<String, Object> p :params) {
		
		 
		 try {
			 
			 String res=""+p.get("KYC_STATUS");
			 
			 if(res.equals("PARTIAL_KYC")) {
				 out=false;
			 }
			 else if(res.equals("FULL_KYC")) {
				 out=true;
			 }
			 break;
			} catch (Exception e) {
				System.out.println(e);
			}

		
	}
	
	

	return out;
}





static public ClientConsultation getInfoClient( List<Map<String, Object>> params) {	
	
		
	ClientConsultation res= new ClientConsultation();
	
	if(params==null || params.size()==0)
		return null;
	
	
	for(Map<String, Object> p :params) {
		 try {

			 res.setTemporaire(""+p.get("otp"));
					} catch (Exception e) {
						System.out.println(e);
					}
		 try {
			 
			 BigDecimal tentb=(BigDecimal)p.get("invalid_password_count");
			 res.setNombreTentative(tentb.intValue());
			
			} catch (Exception e) {
				System.out.println(e);
			}
		
		 try {		 
			 res.setLogin( ""+p.get("login_id"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {		 
			 res.setDateExpirationBlocage( (Date)p.get("attempts_expiry_time"));
			} catch (Exception e) {
				System.out.println(e);
			}
		
		 try {		 
			 res.setCif( ""+p.get("CIF"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {		 
			 res.setNni( ""+p.get("KYC_VALUE"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 try {		 
			 res.setUserId( ""+p.get("USER_ID"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {		 
			 res.setTelephone( ""+p.get("MSISDN"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {		 
			 res.setFirstName( ""+p.get("FIRST_NAME"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {		 
			 res.setLastName( ""+p.get("LAST_NAME"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {		 
			 res.setPartyId( ""+p.get("PARTY_ID"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {		 
			 res.setKyc_label( ""+p.get("KYC_STATUS"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {		 
			 res.setKycStatusId( ""+p.get("KYC_STATUS"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {		 
			 res.setStatusLabel( ""+p.get("STATUS"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {		 
			 res.setBearer( ""+p.get("BEARER"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {		 
			 res.setStatusId(""+(BigDecimal)p.get("STATUS_ID"));
			} catch (Exception e) {
				System.out.println(e);
			}
		
		 try {		 
			 res.setDate((Date)p.get("created_on"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
	
	    return res;

	}
	
	return null;
		
	}






static public List<Merchant> getMerchant( List<Map<String, Object>> params) {	
	
	List<Merchant> res=new ArrayList<>();
			
	if(params==null || params.size()==0)
		return null;
	
	
	for(Map<String, Object> p :params) {
		
		Merchant m= new Merchant();
		
		 try {

			 m.setUserId(""+p.get("user_id"));
			} catch (Exception e) {
				System.out.println(e);
			}
		
		 try {

			 m.setParentId(""+p.get("parent_id"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {

			 m.setCaisse(""+p.get("user_name"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {

			 m.setCommercant(""+p.get("last_name"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 
		 try {

			 m.setTelephone(""+p.get("msisdn"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 
		 try {

			 m.setCategorie(""+p.get("category_code"));
			} catch (Exception e) {
				System.out.println(e);
			}
		
		 
	   res.add(m);
	   

	}
	
	 return res;
		
	}




static public TrsMobile getTrsMobileAddRef( List<Map<String, Object>> params) {	
	
			
	if(params==null || params.size()==0)
		return null;
	
	
	for(Map<String, Object> p :params) {
		
		TrsMobile m= new TrsMobile();
		
		 try {

			 m.setAdditionalReference(""+p.get("account_no"));
			} catch (Exception e) {
				System.out.println(e);
			}
		
		
		 
	   return m;

	}
	
	 return null;
		
	}


static public BankilyResponse getVerificationMobile( List<Map<String, Object>> params) throws Exception {	
	
	
	if(params==null || params.size()==0)
		return null;
	
	
	for(Map<String, Object> p :params) {
		
		BankilyResponse m= new BankilyResponse();
		
		

		
		 try {

			 m.setCif(""+p.get("CIF"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {

			 m.setNni(""+p.get("NNI"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		
		 try {
			 
			 m.setTelephone(""+p.get("telephone"));
			} catch (Exception e) {
				System.out.println(e);
			}
		
		 
	   return m;

	}
	
	 return null;
		
	}





static public BankilyResponse getNomMerchant( List<Map<String, Object>> params) throws Exception {	
	
	
	if(params==null || params.size()==0)
		return null;
	
	
	for(Map<String, Object> p :params) {
		
		BankilyResponse m= new BankilyResponse();
		
		 try {
			 m.setNomMerchant(""+p.get("user_name"));
			} catch (Exception e) {
				System.out.println(e);
			}

	   return m;

	}
	
	 return null;
		
	}



static public BankilyResponse getVerificationImal( List<Map<String, Object>> params) throws Exception {	
	
	
	if(params==null || params.size()==0)
		return null;
	
	
	for(Map<String, Object> p :params) {
		
		BankilyResponse m= new BankilyResponse();
		
		
		String branch=null;
		String tel= null;
		
		 try {

			 branch= ""+p.get("branch_code");
			} catch (Exception e) {
				System.out.println(e);
			}
		
		
		 try {

			 m.setCif(""+p.get("CIF"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {

			 m.setNni(""+p.get("NNI"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 if(branch==null)
			 throw new Exception("branch_code=null, cif= "+m.getCif());
		 
		 if(branch.equals("100")) { 
			 try {

				 tel=   ""+p.get("tel_mobile");
				} catch (Exception e) {
					System.out.println(e);
				}
			
			
		 }else {
			 try {

			 tel=   ""+p.get("tel_imal");
			} catch (Exception e) {
				System.out.println(e);
			}
		 }
		 
		 m.setTelephone(tel);
		 
	   return m;

	}
	
	 return null;
		
	}


static public List<PaiementMerchant> getPaiementMerchant( List<Map<String, Object>> params) {	
	
	List<PaiementMerchant> res=new ArrayList<>();
			
	if(params==null || params.size()==0)
		return null;
	
	
	for(Map<String, Object> p :params) {
		
		PaiementMerchant m= new PaiementMerchant();
		
		 try {

			 m.setTransactionId(""+p.get("transfer_id"));
			} catch (Exception e) {
				System.out.println(e);
			}
		
		 try {

			 m.setMontant(((BigDecimal)p.get("montant")).doubleValue());
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 
		 try {

			 m.setDatePaiement((Date)p.get("transfer_on"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 try {

			 m.setCaisse(""+p.get("caisse"));
			} catch (Exception e) {
				System.out.println(e);
			}
		 
		 
		
		 
	   res.add(m);
	   

	}
	
	 return res;
		
	}

	
	
}
