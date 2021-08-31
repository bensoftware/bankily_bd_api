package mr.bpm.bankily.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mr.bpm.bankily.dao.MonetiqueServiceDao;
import mr.bpm.bankily.dot.BankilyResponse;
import mr.bpm.bankily.dot.Client;
import mr.bpm.bankily.dot.ClientConsultation;
import mr.bpm.bankily.dot.ClientStatistique;
import mr.bpm.bankily.dot.ListClientStatistique;
import mr.bpm.bankily.dot.ListTrsMobile;
import mr.bpm.bankily.dot.ListTrsMobileBus;
import mr.bpm.bankily.dot.Merchant;
import mr.bpm.bankily.dot.PaiementMerchant;
import mr.bpm.bankily.dot.RequestDto;
import mr.bpm.bankily.dot.ResponseDto;
import mr.bpm.bankily.dot.TrsMobile;
import mr.bpm.bankily.dot.TrsMobileBus;
import mr.bpm.bankily.helper.MonetiqueCarteHelper;

@Repository
public class MonetiqueServiceDaoImpl implements MonetiqueServiceDao{

	@Autowired
	private DataSource dataSourceDigitalWorkspace;
	
	@Autowired
	private DataSource dataSourceParty;
	
	@Autowired
	private DataSource dataSourceInstrumentMgmt;
	
	@Autowired
	private DataSource dataSourceBus;
	
	@Autowired
	private DataSource dataSourceMobiq;
	
	@Autowired
	@Qualifier("jdbcDigitalworkspace")
	protected JdbcTemplate jdbcTemplateDigit;
	
	@Autowired
	@Qualifier("jdbcParty")
	protected JdbcTemplate jdbcTemplateParty;

	
	@Autowired
	@Qualifier("jdbcInstrumentmgmt")
	protected JdbcTemplate jdbcTemplateInstr;
	
	@Autowired
	@Qualifier("jdbcBus")
	protected JdbcTemplate jdbcTemplateBus;
	
	@Autowired
	@Qualifier("jdbcMobiq")
	protected JdbcTemplate jdbcTemplateMobiq;
	
	
	  @PostConstruct
	  private void postConstruct() {
	      jdbcTemplateDigit = new JdbcTemplate(dataSourceDigitalWorkspace);
	      jdbcTemplateParty = new JdbcTemplate(dataSourceParty);
	      jdbcTemplateInstr = new JdbcTemplate(dataSourceInstrumentMgmt);
	      jdbcTemplateBus = new JdbcTemplate(dataSourceBus);
	      jdbcTemplateMobiq = new JdbcTemplate(dataSourceMobiq);
	  }

	  
	  
		@Override
		public ListTrsMobile getInfoPaiementFacturier(String idTransaction) {

			List<TrsMobile> out=null;

			   List<Map<String,Object>>  res=null;
						
				String sql ="select attr_4_value,created_on,transfer_status from mtx_transaction_header s where transfer_id = ?";			
				System.out.println(sql);
				try {
					res =  jdbcTemplateBus.queryForList(sql, new Object[] { idTransaction});

				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				out=MonetiqueCarteHelper.getTransMobile(res);
				
				

				ListTrsMobile tt= new ListTrsMobile();
				
				tt.setMobiles(out);
				
				return tt;
		}

	  
	  
	  @Override
		public String getCifByPartyId(String partyId) {
		String out=null;
			
			List<Map<String,Object>>  res=null;
			
			
			String sql =" select cif from party where party_id = ? ";
			
			System.out.println(sql);
			try {
				res =  jdbcTemplateParty.queryForList(sql, new Object[] { partyId });

			} catch (Exception e) {
				//status = "ERREUR";
			}
			
			out=MonetiqueCarteHelper.toCif(res);
			return out;
		}
	  
	  
	  @Override
		public BankilyResponse getPartyIdByTelephone(String telephone) {
		
			
		  BankilyResponse out=null;
				
			   List<Map<String,Object>>  res=null;
						
				String sql ="select kyc_status,party_id,first_name,last_name from user_details where msisdn = ?";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] { Integer.parseInt(telephone) });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				out=MonetiqueCarteHelper.getPartyId(res);

				return out;
		}


	  
	  
	   @Override
		public void debloquerClientBankily(String telephone) throws Exception {
		
					
			String sql ="update  user_status set status=1 where user_id in (select user_id from user_details where msisdn= ? ) and status=5 ";
			
			System.out.println(sql);
			try {
				  jdbcTemplateDigit.queryForList(sql, new Object[] { telephone });

			} catch (Exception e) {
				//throw new Exception(e.getMessage());
			}
		
		}

	  
	  @Override
		public Client getTelephoneByUserId(String userId) {
		
			
		  Client out=null;
				
			   List<Map<String,Object>>  res=null;
						
				String sql ="select msisdn,pref_language from user_details where user_id = ?";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] { userId });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				out=MonetiqueCarteHelper.getTel(res);

				return out;
		}
	  

	  
	@Override
	public String getCIFBANKILY(String mobileNumber) {
		
		
		List<Map<String,Object>>  res=null;
		// TODO Auto-generated method stub
		String sql ="select cif from party where mobilenumber = ? ";
		System.out.println(sql);
		try {
			res =  jdbcTemplateDigit.queryForList(sql,new Object[] {mobileNumber});//

		} catch (Exception e) {
			//status = "ERREUR";
		}
		  String out = (String) res.get(0).get("cif");
		 
		  return out;
		  
		// out = (double)res.get(0).get("cif");
		 // res.get(1);
		//out=(double) res.get(0).get(sql);

		//System.out.println("ok");
	}
	
	@Override
	public boolean getPartyIdUserId(String mobileNumber, String cifParticulier, String addRef) {
		String[] out = new String[2];
		List<Map<String,Object>>  res=null;
		// TODO Auto-generated method stub
		String sql ="select user_id,party_id from user_details where msisdn = ? ";
		System.out.println(sql);
		try {
			res =  jdbcTemplateDigit.queryForList(sql,new Object[] {mobileNumber});//

		} catch (Exception e) {
			//status = "ERREUR";
		}
		 out[0] = (String) res.get(0).get("user_id");
		 out[1]= (String) res.get(0).get("party_id");
		 
		 System.out.println(out[0] + "-----"+out[1]);
		 //update dans le shema digital workspace
		 boolean resultDigit = updateDigitalWokspace(cifParticulier,out[0]);
		//update dans le shema party
		 boolean resultParty = updateParty(cifParticulier, out[1]);
		 //update dans le shema InstrumentMgmt
		 boolean resultInstrument = updateInstrumentMgmt(cifParticulier, addRef, out[0]);
		  
		 if (resultDigit && resultParty && resultInstrument)  return true; 
		  	 
		 else return false;
	}

	@Override
	public boolean updateDigitalWokspace(String cifParticulier, String userId) {
		List<Map<String,Object>>  res=null;
		// TODO Auto-generated method stub
		String sql ="update host_mapping set customer_id= ? where user_id= ? ";
		System.out.println(sql);
		try {
			res =  jdbcTemplateDigit.queryForList(sql,new Object[] {cifParticulier,userId});//

			
		} catch (Exception e) {
			//status = "ERREUR";
		}
		return true;
		
	}
	

	@Override
	public boolean updateParty(String cifParticulier, String partyId) {
		List<Map<String,Object>>  res=null;
		// TODO Auto-generated method stub
		String sql ="update party set cif= ? where party_id= ? ";
		System.out.println(sql);
		try {
			res =  jdbcTemplateParty.queryForList(sql,new Object[] {cifParticulier,partyId});//
			System.out.println("partyyyyy");
		} catch (Exception e) {
			//status = "ERREUR";
		}
		return true;
	}

	@Override
	public boolean updateInstrumentMgmt(String cifParticulier, String addRef, String userId) {
		List<Map<String,Object>>  res=null;
		// TODO Auto-generated method stub
		String sql ="update cust_accounts set cifid= ?, account_no= ? where user_id= ? ";
		System.out.println(sql);
		try {
			res =  jdbcTemplateInstr.queryForList(sql,new Object[] {cifParticulier,addRef,userId});//
			System.out.println("cuuuuuust");
		} catch (Exception e) {
			//status = "ERREUR";
		}
		return true;
	}

	@Override
	public BankilyResponse getInfoPINTemp(String telephone) {
		
		  BankilyResponse out=null;
				
			   List<Map<String,Object>>  res=null;
						
				String sql ="select user_id,login_id,otp,attempts_expiry_time,invalid_password_count from user_details s where msisdn = ?";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] { Integer.parseInt(telephone) });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				out=MonetiqueCarteHelper.getInfoPIN(res);

				return out;
	}

	@Override
	public int getEtatUserByUserId(String userId) {
			
		   List<Map<String,Object>>  res=null;
					
			String sql ="select status  from user_status where user_id= ?";
			
			System.out.println(sql);
			try {
				res =  jdbcTemplateDigit.queryForList(sql, new Object[] { userId });

			} catch (Exception e) {
				//status = "ERREUR";
			}
			
			return  MonetiqueCarteHelper.getStatusUser(res);

		
	}

	@Override
	public BankilyResponse getNbLiaisonParAgence() {
		
		BankilyResponse out=null;
			
		   List<Map<String,Object>>  res=null;
					
			String sql ="";
			
			System.out.println(sql);
			try {
				res =  jdbcTemplateDigit.queryForList(sql, new Object[] { });

			} catch (Exception e) {
				//status = "ERREUR";
			}
			
			out=MonetiqueCarteHelper.getInfoPIN(res);

			return out;
	}

	@Override
	public BankilyResponse getAdditionalRefByCif(String cif) {
		BankilyResponse out=null;
		
		   List<Map<String,Object>>  res=null;
					
			String sql ="select account_no from cust_accounts where cifid=?";
			
			System.out.println(sql);
			try {
				res =  jdbcTemplateInstr.queryForList(sql, new Object[] {cif });

			} catch (Exception e) {
				//status = "ERREUR";
			}
			
			out=MonetiqueCarteHelper.getAddRef(res);

			return out;
	}

	@Override
	public String getKycIdByNni(String nni) {
		String out=null;
		
		List<Map<String,Object>>  res=null;
		
		
		String sql =" select kyc_id from kyc_details where kyc_value = ? ";
		
		System.out.println(sql);
		try {
			res =  jdbcTemplateParty.queryForList(sql, new Object[] { nni });

		} catch (Exception e) {
			//status = "ERREUR";
		}
		
		out=MonetiqueCarteHelper.getKycId(res);
		return out;
	}

	@Override
	public String getPartyIdByKycId(String kycId) {
		String out=null;
		
		List<Map<String,Object>>  res=null;
		
		
		String sql =" select party_id from party_kyc_details where kyc_id = ? ";
		
		System.out.println(sql);
		try {
			res =  jdbcTemplateParty.queryForList(sql, new Object[] { kycId });

		} catch (Exception e) {
			//status = "ERREUR";
		}
		
		out=MonetiqueCarteHelper.toPartyId(res);
		return out;
	}

	@Override
	public String getCifByNni(String nni) {
	
		String kycId= getKycIdByNni(nni);
		String partyId= getPartyIdByKycId(kycId);
		String cif = getCifByPartyId(partyId);
		
		return cif;
		
	}
	
	public String getUserIdByNni(String nni) {
		
		String kycId= getKycIdByNni(nni);
		String partyId= getPartyIdByKycId(kycId);
        String userId= getUserIdByPartyId(partyId) ;     		
		return userId;
		
	}
	

	@Override
	public ListTrsMobileBus getAllTransRechargeTA() {
		
		   List<TrsMobileBus>  out=null;
		   
		   List<Map<String,Object>>  res=null;
					
		String sql =" select transfer_id, attr_4_value as tel_source,attr_5_value as operateur,transfer_value as montant, " + 
					" created_on as date_creation,modified_on as date_modification,transfer_status as status,language, " + 
					" service_type as type_operation " + 
					" from mtx_transaction_header s where transfer_status ='TA'  and service_type='RECHRGDIGI'";
		   
			System.out.println(sql);
			try {
				res =  jdbcTemplateBus.queryForList(sql, new Object[] { });

			} catch (Exception e) {
				//status = "ERREUR";
			}
			
			out=MonetiqueCarteHelper.getListMobile(res);

			
			ListTrsMobileBus li=new ListTrsMobileBus();
			li.setMobiles(out);
			
			return li;
			}

	
	
	
	private String getUserIdByTel(String telephone) {
			
		String out=null;
				
			   List<Map<String,Object>>  res=null;
			   	
				String sql ="select user_id from user_details where msisdn = ?";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] { Integer.parseInt(telephone) });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				Map<String, Object> p=	res.get(0);
				out=""+p.get("user_id");
				
				
							
				return out;

			

		}
	

	private String getUserIdByLogin(String login) {
		
		String out=null;
				
			   List<Map<String,Object>>  res=null;
			   	
				String sql ="select user_id from users where login_id = ?";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateMobiq.queryForList(sql, new Object[] { login });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				Map<String, Object> p=	res.get(0);
				out=""+p.get("user_id");
				
				
							
				return out;

			

		}
	
	private String getUserIdByPartyId(String party) {
		
		String out=null;
				
			   List<Map<String,Object>>  res=null;
			   	
				String sql ="select user_id from user_details where party_id = ?";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] { party });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				Map<String, Object> p=	res.get(0);
				out=""+p.get("user_id");
				
				
							
				return out;

			

		}
	
private String getTelephoneByPartyId(String party) {
		
		String out=null;
				
			   List<Map<String,Object>>  res=null;
			   	
				String sql ="select msisdn from user_details where party_id = ?";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] { party });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				Map<String, Object> p=	res.get(0);
				out=""+p.get("msisdn");
				
				
							
				return out;

			

		}
	
	private void setFullKycStep1(String userId) {
			
		  BankilyResponse out=null;
				
			   List<Map<String,Object>>  res=null;
						
				String sql ="UPDATE HOST_MAPPING SET REGULATORY_PROFILE = 'TCP1905200759.002570',ACCESS_TYPE = 'FULL_KYC' WHERE USER_ID = ? ";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] { userId });

				} catch (Exception e) {
					//status = "ERREUR";
				}
			

		}
	
	private void setFullKycStep2(String userId) {
		
		  BankilyResponse out=null;
				
			   List<Map<String,Object>>  res=null;
						
				String sql ="UPDATE USER_STATUS SET STATUS = '1',REMARKS = 'Bulk manual upgarde' WHERE USER_ID = ? ";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] { userId });

				} catch (Exception e) {
					//status = "ERREUR";
				}
			

		}
	
	private void setFullKycStep3(String userId) {
		
		  BankilyResponse out=null;
				
			   List<Map<String,Object>>  res=null;
						
				String sql ="UPDATE USER_DETAILS SET KYC_STATUS = 'FULL_KYC' WHERE  USER_ID = ? ";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] { userId });

				} catch (Exception e) {
					//status = "ERREUR";
				}
			

		}
	
	
	private boolean isFullKyc(String idPartial) {
		
		boolean out=false;
			
		   List<Map<String,Object>>  res=null;
					
			String sql ="SELECT kyc_status FROM user_details WHERE party_id like ?";
			
			System.out.println(sql);
			try {
				res =  jdbcTemplateDigit.queryForList(sql, new Object[] { idPartial });

			} catch (Exception e) {
				//status = "ERREUR";
			}
			
			out=MonetiqueCarteHelper.getStatusByIdParty(res);
			
			return out;
	}
	
	
	    @Override
		public boolean setFullKyc(String nni) {
		
	    	boolean res=false;
	    	String partyId=null;
	    	// maj full Kyc
	    	try {
	    		
	    		String kycId= getKycIdByNni(nni);
	    		partyId= getPartyIdByKycId(kycId);
	    		
	    		
	    		String id=getUserIdByPartyId(partyId);
	    		setFullKycStep1(id);
	    		setFullKycStep2(id);
	    		setFullKycStep3(id);
	    		
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	
	    	
	    	// 
	    	try {
	    		boolean fullKyc= isFullKyc(partyId);
	    		
	    		if(fullKyc) {
	    			res=true;
	    		}
	    		
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	
	    	
	    return res;

		}

	    
		@Override
		public BankilyResponse getTelephoneByNni(String nni) {
			
			BankilyResponse res=new BankilyResponse();
	    	String partyId=null;
	    	// maj full Kyc
	    	try {
	    		
	    		String kycId= getKycIdByNni(nni);
	    		partyId= getPartyIdByKycId(kycId);
	    		
	    		
	    		String tel=getTelephoneByPartyId(partyId);
	    		
	    		res.setTelephone(tel);
	    		

	    		
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	

	    	
	    return res;

	    
		}

		private List<ClientStatistique> getAllClientPartial() {
			 List<Map<String,Object>>  res=null;
				
				String sql ="select created_on,rnsid,msisdn,user_id,first_name from user_details u where login_id is not null and party_id is not null and kyc_status like 'PARTIAL%' " + 
						" order by user_id asc ";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] {  });

				} catch (Exception e) {
					//status = "ERREUR";
				}

				
			return MonetiqueCarteHelper.getCLient(res);
		}

		private List<ClientStatistique> getAllClientFull() {
			 List<Map<String,Object>>  res=null;
				
				String sql ="select rnsid,created_on,msisdn,user_id,first_name from user_details u where login_id is not null and party_id is not null and kyc_status like 'FULL%' " + 
						" order by user_id asc ";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] {  });

				} catch (Exception e) {
					//status = "ERREUR";
				}

			return MonetiqueCarteHelper.getCLient(res);
		}
		
		
		private List<ClientStatistique> getAllClientFullBpm() {
			 List<Map<String,Object>>  res=null;
				
				String sql ="select rnsid,created_on,msisdn,user_id,first_name from user_details u where login_id is not null and party_id is not null and kyc_status like 'FULL%' and bearer='WEB' " + 
						" order by user_id asc ";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] {  });

				} catch (Exception e) {
					//status = "ERREUR";
				}

			return MonetiqueCarteHelper.getCLient(res);
		}

		private boolean isClientActif(String userId) {
			
			 List<Map<String,Object>>  res=null;
				
				String sql ="select count(*) as total " + 
						"from mtx_transaction_header where payee_user_id ='"+userId+"' or payer_user_id ='"+userId+"' ";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateBus.queryForList(sql, new Object[] {  });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				int total=MonetiqueCarteHelper.getTotal(res);
				boolean actif=false;
				if(total>0)
					actif=true;
				

			return actif;
		}
		
		private List<ClientStatistique> getDebitClient(List<String> userIds,int debut,int fin) {
			
			 List<Map<String,Object>>  res=null;
				
			 
				String sql ="select payee_user_id from mtx_transaction_header where service_type in ('FTOTHRBANK','RECHRGDIGI','FTHOMEBANK','REQUESTMNY','CASHINDIG','SPLITBILL','CASHOUTDIG','TXNCORDIG','COUTREG','FTUNREG','REFUND','ATMCOUTREG','ATMCOUTURG','FT','MERPAYDIG','BILLPAYDIG') and payee_user_id  in ( ";

				for(int i=debut;i<fin;i++) {
					String userId= userIds.get(i);
					if(i==fin-1) {
						sql+="'"+userId+"'";	
					}
					else
					sql+="'"+userId+"',";
				}
				
				sql+=") group by payee_user_id";
			 	System.out.println(sql);
			 	
			 	System.out.println(sql);
				try {
					res =  jdbcTemplateBus.queryForList(sql, new Object[] {  });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				return MonetiqueCarteHelper.getActifs(res);
		
		}
		

		private List<ClientStatistique> getUserIdByNni(List<ClientStatistique> list){
		
			List<ClientStatistique> res= new ArrayList<>();
			
			int debut=0;
			int fin=0;
			
			int size= list.size();
			int reste=size;
			int page=1000;
			
			int fragment=size /page;
			
			if(size%page!=0) {
				fragment++;
			}
			
			int index=1;
			
			
			while(index<=fragment) {
				
				debut=fin;
	
				if(reste>=page) {
					fin=fin+page;
				}
				else {
					fin=size;
				}
				
				reste-=page;
				
				// appel
				List<ClientStatistique> listFrag=getUserIdByNniFragement(list, debut, fin);
				
				if(listFrag!=null)
				res.addAll(listFrag);
				index++;
			}

			return res;
		}
		

	
		private List<ClientStatistique> getCreditClientByFragment(List<String> userIds){
			
			List<ClientStatistique> res= new ArrayList<>();
			
			int debut=0;
			int fin=0;
			
			int size= userIds.size();
			int reste=size;
			int page=1000;
			
			int fragment=size /page;
			
			if(size%page!=0) {
				fragment++;
			}
			
			int index=1;
			
			
			while(index<=fragment) {
				
				debut=fin;
	
				if(reste>=page) {
					fin=fin+page;
				}
				else {
					fin=size;
				}
				
				reste-=page;
				
				// appel
				List<ClientStatistique> listFrag=getCreditClient(userIds, debut, fin);
				
				res.addAll(listFrag);
				index++;
			}

			return res;
			
		}
		
		
private List<ClientStatistique> getDebitClientByFragment(List<String> userIds){
			
			List<ClientStatistique> res= new ArrayList<>();
			
			int debut=0;
			int fin=0;
			
			int size= userIds.size();
			int reste=size;
			int page=1000;
			
			int fragment=size /page;
			
			if(size%page!=0) {
				fragment++;
			}
			
			int index=1;
			
			
			while(index<=fragment) {
				
				debut=fin;
	
				if(reste>=page) {
					fin=fin+page;
				}
				else {
					fin=size;
				}
				
				reste-=page;
				
				// appel
				List<ClientStatistique> listFrag=getDebitClient(userIds, debut, fin);
				
				res.addAll(listFrag);
				index++;
			}
			
			
			
			
			return res;
			
		}


private List<ClientStatistique> getCompleteClientByFragment(List<String> userIds){
	
	List<ClientStatistique> res= new ArrayList<>();
	
	int debut=0;
	int fin=0;
	
	int size= userIds.size();
	int reste=size;
	int page=1000;
	
	int fragment=size /page;
	
	if(size%page!=0) {
		fragment++;
	}
	
	int index=1;
	
	
	while(index<=fragment) {
		
		debut=fin;

		if(reste>=page) {
			fin=fin+page;
		}
		else {
			fin=size;
		}
		
		reste-=page;
		
		// appel
		List<ClientStatistique> listFrag=getCompeteClient(userIds, debut, fin);
		
		res.addAll(listFrag);
		index++;
	}
	
	
	
	
	return res;
	
}
		

private List<ClientStatistique> getUserIdByNniFragement(List<ClientStatistique> userIds,int debut,int fin) {
	
	 List<Map<String,Object>>  res=null;
		
	 String sql ="select a.user_id,c.kyc_value from DIGITALWORKSPACE.user_details a, party_kyc_details b , kyc_details c where c.kyc_id=b.kyc_id and b.party_id=a.party_id and c.kyc_value in ( "; 		
						
		for(int i=debut;i<fin;i++) {
			String userId= userIds.get(i).getNni();
			
			if(i==fin-1) {
				sql+="'"+userId+"'";	
			}
			else
			sql+="'"+userId+"',";
		}
		
		sql+=" )";
	 	System.out.println(sql);
		try {
			res =  jdbcTemplateParty.queryForList(sql, new Object[] {  });

		} catch (Exception e) {
			//status = "ERREUR";
		}
		
		return MonetiqueCarteHelper.getUserIds(res);

}

		
		private List<ClientStatistique> getCreditClient(List<String> userIds,int debut,int fin) {
			
			 List<Map<String,Object>>  res=null;
				
			 
			 
			 
				String sql ="select payer_user_id from mtx_transaction_header where  service_type in ('FTOTHRBANK','RECHRGDIGI','FTHOMEBANK','REQUESTMNY','CASHINDIG','SPLITBILL','CASHOUTDIG','TXNCORDIG','COUTREG','FTUNREG','REFUND','ATMCOUTREG','ATMCOUTURG','FT','MERPAYDIG','BILLPAYDIG')   and payer_user_id  in ( ";
				
								
				for(int i=debut;i<fin;i++) {
					String userId= userIds.get(i);
					if(i==fin-1) {
						sql+="'"+userId+"'";	
					}
					else
					sql+="'"+userId+"',";
				}
				
				sql+=") group by payer_user_id";
			 	System.out.println(sql);
				try {
					res =  jdbcTemplateBus.queryForList(sql, new Object[] {  });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				return MonetiqueCarteHelper.getActifsC(res);
		
		}

		private List<ClientStatistique> getAllClientFullNew() {
			 List<Map<String,Object>>  res=null;
				
				String sql ="select msisdn,user_id,created_on from user_details u where login_id is null and question_id is null " + 
						" and security_ans is null and invalid_password_count=0  and party_id is not null and kyc_status like 'FULL%' " + 
						" order by user_id asc ";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] {  });

				} catch (Exception e) {
					//status = "ERREUR";
				}

			return MonetiqueCarteHelper.getCLientNew(res);
		}

		
		private List<ClientStatistique> getAllClientFullNewComplet() {
			 List<Map<String,Object>>  res=null;
				
				String sql =" select msisdn,user_id,created_on from user_details u where login_id is not null and question_id is not null " + 
						" and security_ans is not null  and party_id is not null and kyc_status like 'FULL%' and bearer='WEB' " + 
						" order by user_id asc  ";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] {  });

				} catch (Exception e) {
					//status = "ERREUR";
				}

			return MonetiqueCarteHelper.getCLientNew(res);
		}
	
	
		
		private List<ClientStatistique> getCompeteClient(List<String> userIds,int debut,int fin) {
			
			 List<Map<String,Object>>  res=null;
				
				String sql ="select user_id,cifname,cifid,account_no,SUBSTR(account_no, INSTR(account_no, '8')+1, 5) as code_agence from cust_accounts where user_id  in ( ";
				
								
				for(int i=debut;i<fin;i++) {
					String userId= userIds.get(i);
					if(i==fin-1) {
						sql+="'"+userId+"'";	
					}
					else
					sql+="'"+userId+"',";
				}
				
				sql+=")";
			 	System.out.println(sql);
				try {
					res =  jdbcTemplateInstr.queryForList(sql, new Object[] {  });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				return MonetiqueCarteHelper.getCompleteCLientNew(res);
		
		}

/*		@Override
		public ListClientStatistique getAllClientPartialActif() {

			List<ClientStatistique> list= getAllClientPartial();
			
			List<ClientStatistique> res= new ArrayList<>();
			
			for(ClientStatistique x : list) {
				boolean actif= isClientActif(x.getUserId());
				x.setActif(actif);
				if(actif)
					res.add(x);
				
			}
			ListClientStatistique out=new ListClientStatistique();
			out.setClients(res);
			return out;
		}*/
		
		
		
		
		@Override
		public ListClientStatistique getAllEtatClient(List<ClientStatistique> list){

			List<ClientStatistique> out= new ArrayList<>();
									
			// recuperation des UserId pour recherche des actifs
			/*List<String> userIds= new ArrayList<>();
			
			for(ClientStatistique x : list) {
				String userId= getUserIdByNni(x.getNni());
				userIds.add(userId);
				System.out.println(userId);
			}
			*/
			// 
			list=getUserIdByNni(list);
			
			List<String> userIds=new ArrayList<>();
			
			for(ClientStatistique x : list) {
				userIds.add(x.getUserId());
			}
		
			//	List<String> userIds = getUserIdByNni(list);
			
			
			// recherche et ajout / aux transactions credit
			List<ClientStatistique> actifs=getCreditClientByFragment(userIds);
			
			for(ClientStatistique x : list) {
				
				String userId=x.getUserId();
				
				for(ClientStatistique x2 :  actifs) {
					 
					  if(x2.getUserId().equals(userId)) {
						  x.setActif(true);
						  out.add(x);
						  break;
					 }
				}		
			}
			
			// recherche et ajout / aux transactions Debit
			actifs=getDebitClientByFragment(userIds);
						
						for(ClientStatistique x : list) {

							if(x.isActif())
								continue;
							
							String userId=x.getUserId();
							
							for(ClientStatistique x2 :  actifs) {
								 
								  if(x2.getUserId().equals(userId)) {
									  x.setActif(true);
									  out.add(x);
									  break;
								 }
							}		
						}

			ListClientStatistique lout=new ListClientStatistique();
			lout.setClients(out);
			return lout;
		}
		
		@Override
		public ListClientStatistique getAllClientPartialActif() {

			List<ClientStatistique> out= new ArrayList<>();
			
			List<ClientStatistique> list= getAllClientPartial();
						
			// recuperation des UserId pour recherche des actifs
			List<String> userIds= new ArrayList<>();
			
			for(ClientStatistique x : list) {
				userIds.add(x.getUserId());
			}
			
			// recherche et ajout / aux transactions credit
			List<ClientStatistique> actifs=getCreditClientByFragment(userIds);
			
			for(ClientStatistique x : list) {
				
				String userId=x.getUserId();
				
				for(ClientStatistique x2 :  actifs) {
					 
					  if(x2.getUserId().equals(userId)) {
						  x.setActif(true);
						  out.add(x);
						  break;
					 }
				}		
			}
			
			// recherche et ajout / aux transactions Debit
			actifs=getDebitClientByFragment(userIds);
						
						for(ClientStatistique x : list) {

							if(x.isActif())
								continue;
							
							String userId=x.getUserId();
							
							for(ClientStatistique x2 :  actifs) {
								 
								  if(x2.getUserId().equals(userId)) {
									  x.setActif(true);
									  out.add(x);
									  break;
								 }
							}		
						}

			ListClientStatistique lout=new ListClientStatistique();
			lout.setClients(out);
			return lout;
		}

		@Override
		public ListClientStatistique getAllClientPartialInactif() {
	
			
			List<ClientStatistique> list= getAllClientPartial();
            List<ClientStatistique> out= new ArrayList<>(list);

			
			// recuperation des UserId pour recherche des actifs
			List<String> userIds= new ArrayList<>();
			
			for(ClientStatistique x : list) {
				userIds.add(x.getUserId());
			}
			
			List<ClientStatistique> actifs=getCreditClientByFragment(userIds);
			
			for(ClientStatistique x : list) {
				
				String userId=x.getUserId();
				
				for(ClientStatistique x2 :  actifs) {
					 
					  if(x2.getUserId().equals(userId)) {
						  x.setActif(true);
						  out.remove(x);
						  break;
					 }
				}	
			}
			
			// recherche et ajout / aux transactions Debit
			actifs=getDebitClientByFragment(userIds);
						
						for(ClientStatistique x : list) {

							if(x.isActif())
								continue;
							
							String userId=x.getUserId();
							
							for(ClientStatistique x2 :  actifs) {
								 
								  if(x2.getUserId().equals(userId)) {
									  x.setActif(true);
									  out.remove(x);
									  break;
								 }
							}		
						}

			ListClientStatistique lout=new ListClientStatistique();
			lout.setClients(out);
			return lout;
			
		}

		@Override
		public ListClientStatistique getAllClientFullActif() {

			List<ClientStatistique> out= new ArrayList<>();
			
			List<ClientStatistique> list= getAllClientFull();
			
			
			// recuperation des UserId pour recherche des actifs
			List<String> userIds= new ArrayList<>();
			
			for(ClientStatistique x : list) {
				userIds.add(x.getUserId());
			}
			
			// recherche et ajout / aux transactions credit
			List<ClientStatistique> actifs=getCreditClientByFragment(userIds);
			
			for(ClientStatistique x : list) {
				
				String userId=x.getUserId();
				
				for(ClientStatistique x2 :  actifs) {
					 
					  if(x2.getUserId().equals(userId)) {
						  x.setActif(true);
						  out.add(x);
						  break;
					 }
				}		
			}
			
			// recherche et ajout / aux transactions Debit
			actifs=getDebitClientByFragment(userIds);
						
						for(ClientStatistique x : list) {

							if(x.isActif())
								continue;
							
							String userId=x.getUserId();
							
							for(ClientStatistique x2 :  actifs) {
								 
								  if(x2.getUserId().equals(userId)) {
									  x.setActif(true);
									  out.add(x);
									  break;
								 }
							}		
						}

			ListClientStatistique lout=new ListClientStatistique();
			lout.setClients(out);
			return lout;
		}

		
		@Override
		public ListClientStatistique getAllClientFullBpmActif() {

			List<ClientStatistique> out= new ArrayList<>();
			
			List<ClientStatistique> list= getAllClientFullBpm();
			
			
			// recuperation des UserId pour recherche des actifs
			List<String> userIds= new ArrayList<>();
			
			for(ClientStatistique x : list) {
				userIds.add(x.getUserId());
			}
			
			// recherche et ajout / aux transactions credit
			List<ClientStatistique> actifs=getCreditClientByFragment(userIds);
			
			for(ClientStatistique x : list) {
				
				String userId=x.getUserId();
				
				for(ClientStatistique x2 :  actifs) {
					 
					  if(x2.getUserId().equals(userId)) {
						  x.setActif(true);
						  out.add(x);
						  break;
					 }
				}		
			}
			
			// recherche et ajout / aux transactions Debit
			actifs=getDebitClientByFragment(userIds);
						
						for(ClientStatistique x : list) {

							if(x.isActif())
								continue;
							
							String userId=x.getUserId();
							
							for(ClientStatistique x2 :  actifs) {
								 
								  if(x2.getUserId().equals(userId)) {
									  x.setActif(true);
									  out.add(x);
									  break;
								 }
							}		
						}

			ListClientStatistique lout=new ListClientStatistique();
			lout.setClients(out);
			return lout;
		}
		
		@Override
		public ListClientStatistique getAllClientFullInactif() {
			
			List<ClientStatistique> list= getAllClientFull();
            List<ClientStatistique> out= new ArrayList<>(list);

			
			// recuperation des UserId pour recherche des actifs
			List<String> userIds= new ArrayList<>();
			
			for(ClientStatistique x : list) {
				userIds.add(x.getUserId());
			}
			
			List<ClientStatistique> actifs=getCreditClientByFragment(userIds);
			
			for(ClientStatistique x : list) {
				
				String userId=x.getUserId();
				
				for(ClientStatistique x2 :  actifs) {
					 
					  if(x2.getUserId().equals(userId)) {
						  x.setActif(true);
						  out.remove(x);
						  break;
					 }
				}	
			}
			
			// recherche et ajout / aux transactions Debit
			actifs=getDebitClientByFragment(userIds);
						
						for(ClientStatistique x : list) {

							if(x.isActif())
								continue;
							
							String userId=x.getUserId();
							
							for(ClientStatistique x2 :  actifs) {
								 
								  if(x2.getUserId().equals(userId)) {
									  x.setActif(true);
									  out.remove(x);
									  break;
								 }
							}		
						}

			ListClientStatistique lout=new ListClientStatistique();
			lout.setClients(out);
			return lout;
			
		}

		

		@Override
		public ListClientStatistique getAllClientFullBpmInactif() {
			
			List<ClientStatistique> list= getAllClientFullBpm();
            List<ClientStatistique> out= new ArrayList<>(list);

			
			// recuperation des UserId pour recherche des actifs
			List<String> userIds= new ArrayList<>();
			
			for(ClientStatistique x : list) {
				userIds.add(x.getUserId());
			}
			
			List<ClientStatistique> actifs=getCreditClientByFragment(userIds);
			
			for(ClientStatistique x : list) {
				
				String userId=x.getUserId();
				
				for(ClientStatistique x2 :  actifs) {
					 
					  if(x2.getUserId().equals(userId)) {
						  x.setActif(true);
						  out.remove(x);
						  break;
					 }
				}	
			}
			
			// recherche et ajout / aux transactions Debit
			actifs=getDebitClientByFragment(userIds);
						
						for(ClientStatistique x : list) {

							if(x.isActif())
								continue;
							
							String userId=x.getUserId();
							
							for(ClientStatistique x2 :  actifs) {
								 
								  if(x2.getUserId().equals(userId)) {
									  x.setActif(true);
									  out.remove(x);
									  break;
								 }
							}		
						}

			ListClientStatistique lout=new ListClientStatistique();
			lout.setClients(out);
			return lout;
			
		}

		
		@Override
		public ListClientStatistique getAllClientFullIncomplet() {
		
            List<ClientStatistique> list= getAllClientFullNew();
			
			// recuperation des UserId pour recherche des actifs
			List<String> userIds= new ArrayList<>();
			
			for(ClientStatistique x : list) {
				userIds.add(x.getUserId());
			}
			
			// recherche et ajout / aux transactions credit
			List<ClientStatistique> actifs=getCompleteClientByFragment(userIds);
			
			for(ClientStatistique x : list) {
				
				String userId=x.getUserId();
				
				for(ClientStatistique x2 :  actifs) {
					 
					  if(x2.getUserId().equals(userId)) {
						  // mettre les autres informations
						  x.setCif(x2.getCif());
						  x.setAgence(x2.getAgence());
						  x.setCompte(x2.getCompte());
						  x.setNom(x2.getNom());
						  break;
					 }
				}		
			}
			
			ListClientStatistique out= new ListClientStatistique();
			out.setClients(list);
			return out;
		}

		@Override
		public ListClientStatistique getAllClientLiaisonBpm() {

			List<Map<String,Object>>  res=null;
				
				String sql ="select branch_id as agence_creation,SUBSTR(account_no, INSTR(account_no, '8')+1, 5) as agence_compte,cifid,modified_by as approuver  from cust_accounts " + 
						" where SUBSTR(account_no, INSTR(account_no, '8')+1, 5)  not in ('00100')";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateInstr.queryForList(sql, new Object[] {  });

				} catch (Exception e) {
					//status = "ERREUR";
				}

			ListClientStatistique out= new ListClientStatistique();
			out.setClients(MonetiqueCarteHelper.getCLientLiaisonFull(res));
			return out;
		}

		@Override
		public TrsMobileBus getTrsMobByTrsId(String trsId) {

			TrsMobileBus  out=null;
			   
			   List<Map<String,Object>>  res=null;
						
			String sql =" select transfer_id, attr_4_value as tel_source,attr_5_value as operateur,transfer_value as montant, " + 
						" created_on as date_creation,modified_on as date_modification,transfer_status as status,language, " + 
						" service_type as type_operation " + 
						" from mtx_transaction_header s where  service_type='RECHRGDIGI' and transfer_id=?";
			   
				System.out.println(sql);
				try {
					res =  jdbcTemplateBus.queryForList(sql, new Object[] { trsId});

				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				out=MonetiqueCarteHelper.getTrsMobile(res);

				
		
				
				return out;
		}



		@Override
		public Client getOtpByTelephone(String telephone) throws Exception {
		
			
			// get OTP 
			   
			   List<Map<String,Object>>  res=null;
						
			String sql ="select otp,created_on,expiry_time from otp_record where mobile_number=? order by created_on desc FETCH NEXT 1 ROWS ONLY";
			   
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] { telephone});

				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				return MonetiqueCarteHelper.getOtp(res);
							
			
		}



		@Override
		public ListClientStatistique getAllCifParty() {
			
			
			   
			   List<Map<String,Object>>  res=null;
						
			String sql ="select cif from party where kyc_status='FULL_KYC' group by cif";
			   
				System.out.println(sql);
				try {
					res =  jdbcTemplateParty.queryForList(sql, new Object[] { });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				 List<ClientStatistique> clients= MonetiqueCarteHelper.getCifs(res);
				 
				 ListClientStatistique resp=   new ListClientStatistique();
				 resp.setClients(clients);
				 
				return  resp;
				
		}
		
		
	

		@Override
		public boolean deblocageUser(String userId) {
			// TODO Auto-generated method stub
			String sql ="update user_details set invalid_password_count=0,attempts_expiry_time=null where user_id= ? ";
			System.out.println(sql);
			try {
				jdbcTemplateDigit.queryForList(sql,new Object[] {userId});//
				return true;
				
			} catch (Exception e) {
				return false;
			}
			
		}

		@Override
		public boolean deblocageUserTel(String tel) {
			// TODO Auto-generated method stub
			String sql ="update user_details set invalid_password_count=0,attempts_expiry_time=null where msisdn= ? ";
			System.out.println(sql);
			try {
				jdbcTemplateDigit.queryForList(sql,new Object[] {tel});//
				return true;
				
			} catch (Exception e) {
				return false;
			}
			
		}

		@Override
		public ListClientStatistique getAllClientFullComplet() {
		     List<ClientStatistique> list= getAllClientFullNewComplet();
				
				// recuperation des UserId pour recherche des actifs
				List<String> userIds= new ArrayList<>();
				
				for(ClientStatistique x : list) {
					userIds.add(x.getUserId());
				}
				
				// recherche et ajout / aux transactions credit
				List<ClientStatistique> actifs=getCompleteClientByFragment(userIds);
				
				for(ClientStatistique x : list) {
					
					String userId=x.getUserId();
					
					for(ClientStatistique x2 :  actifs) {
						 
						  if(x2.getUserId().equals(userId)) {
							  // mettre les autres informations
							  x.setCif(x2.getCif());
							  x.setAgence(x2.getAgence());
							  x.setCompte(x2.getCompte());
							  x.setNom(x2.getNom());
							  break;
						 }
					}		
				}
				
				ListClientStatistique out= new ListClientStatistique();
				out.setClients(list);
				return out;
		}



		@Override
		public void setEtatClient(List<ClientStatistique> clients ) {
			
			
			int debut=0;
			int fin=0;
			
			int size= clients.size();
			int reste=size;
			int page=500;
			
			int fragment=size /page;
			
			if(size%page!=0) {
				fragment++;
			}
			
			int index=1;
			
			
			while(index<=fragment) {
				
				debut=fin;
	
				if(reste>=page) {
					fin=fin+page;
				}
				else {
					fin=size;
				}
				
				reste-=page;
				
				// appel
				setMayEtatClient(clients, debut, fin, "Blocage incomplet", 5);
				
				index++;
			}
			
			
		}
		
		
		
		
		private boolean setMayEtatClient(List<ClientStatistique> userIds,int debut,int fin, String remark,int etat) {
			 
				String sql ="update user_status set REMARKS = ?, status= ? where user_id  in ( ";

				for(int i=debut;i<fin;i++) {
					String userId=userIds.get(i).getUserId();;
					if(i==fin-1) {
						sql+="'"+userId+"'";	
					}
					else
					sql+="'"+userId+"',";
				}
				
				sql+=")";
			 	System.out.println(sql);
			 	
			 	System.out.println(sql);
				try {
				 jdbcTemplateBus.queryForList(sql, new Object[] {remark,etat });
                     return true;
				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				return false;
		
		}




		@Override
		public ClientConsultation getInfoClientByNni(String nni) throws Exception {
			
			
			   
			   List<Map<String,Object>>  res=null;
						
			String sql =" select u.otp,u.login_id,u.invalid_password_count,u.attempts_expiry_time, party.cif, kyc_details.kyc_value,u.user_id, u.msisdn, u.first_name, u.last_name, u.party_id, u.KYC_Status ,u.created_on, us.status, u.bearer,sl.* from " + 
					" KYC_DETAILS, PARTY, PARTY_KYC_DETAILS,DIGITALWORKSPACE.user_details u ,DIGITALWORKSPACE.status_lists sl, DIGITALWORKSPACE.user_status us where " + 
					" KYC_DETAILS.KYC_VALUE= ? AND " + 
					" kyc_details.kyc_id=party_kyc_details.kyc_id and " + 
					" party.party_id=party_kyc_details.party_id and " + 
					" party.party_id=u.party_id and " + 
					" us.user_id=u.user_id and " + 
					" us.status=sl.status_id ";
			   
				System.out.println(sql);
				try {
					res =  jdbcTemplateParty.queryForList(sql, new Object[] {nni });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				 ClientConsultation client= MonetiqueCarteHelper.getInfoClient(res);
				
				 
				return  client;
				
			
		}



		@Override
		public ClientConsultation getInfoClientByCif(String cif) throws Exception {
		
			   List<Map<String,Object>>  res=null;
				
			String sql =" select u.otp,u.login_id,u.invalid_password_count,u.attempts_expiry_time, party.cif, kyc_details.kyc_value, u.user_id, u.msisdn, u.first_name, u.last_name, u.party_id, u.KYC_Status,u.created_on, us.status ,u.bearer,sl.*  from " + 
					" KYC_DETAILS, PARTY, party_kyc_details , DIGITALWORKSPACE.user_details u ,DIGITALWORKSPACE.status_lists sl, DIGITALWORKSPACE.user_status us where " + 
					" party.cif= ? AND " + 
					" kyc_details.kyc_id=party_kyc_details.kyc_id and " + 
					" party.party_id=party_kyc_details.party_id and " + 
					" party.party_id=u.party_id and " + 
					" us.user_id=u.user_id and " + 
					" us.status=sl.status_id ";
			   
				System.out.println(sql);
				try {
					res =  jdbcTemplateParty.queryForList(sql, new Object[] {cif });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				 ClientConsultation client= MonetiqueCarteHelper.getInfoClient(res);
				
				 
				return  client;
				
		}
		
		public ResponseDto getUserIdByPhone(RequestDto d) throws Exception {
	
			   List<Map<String,Object>>  res=null;
						
				String sql ="select user_id from user_details where msisdn = ?";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] { d.getPhone() });
	
				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				String userId =MonetiqueCarteHelper.getUserId(res);
			
				ResponseDto resDto= new ResponseDto();
				resDto.setUserId(userId);
				
				return resDto;

		}



		@Override
		public ClientConsultation getInfoClientByTel(String tel) throws Exception {
			   List<Map<String,Object>>  res=null;
				
			String sql =" select u.otp,u.login_id,u.invalid_password_count,u.attempts_expiry_time, party.cif, kyc_details.kyc_value,u.user_id, u.msisdn, u.first_name, u.last_name, u.party_id, u.KYC_Status ,u.created_on, us.status, u.bearer ,sl.* from " + 
					" KYC_DETAILS, PARTY, PARTY_KYC_DETAILS, DIGITALWORKSPACE.user_details u ,DIGITALWORKSPACE.status_lists sl, DIGITALWORKSPACE.user_status us where " + 
					" u.msisdn= ? AND " + 
					" kyc_details.kyc_id=party_kyc_details.kyc_id and " + 
					" party.party_id=party_kyc_details.party_id and " + 
					" party.party_id=u.party_id and " + 
					" us.user_id=u.user_id and " + 
					" us.status=sl.status_id ";
			   
				System.out.println(sql);
				try {
					res =  jdbcTemplateParty.queryForList(sql, new Object[] {tel });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				 ClientConsultation client= MonetiqueCarteHelper.getInfoClient(res);
				
				 
				return  client;
		}
		
		public ResponseDto getKycStatusByUserId(RequestDto d) throws Exception {
		    	List<Map<String,Object>>  res=null;
				
				String sql ="select u.KYC_STATUS, s.status from user_details u, user_status s where u.user_id=s.user_id and   u.user_id = ? ";
				
				System.out.println(sql);
				try {
					res =  jdbcTemplateDigit.queryForList(sql, new Object[] { d.getUserId() });
	
				} catch (Exception e) {
					//status = "ERREUR";
				}
				
				ResponseDto resDto= MonetiqueCarteHelper.getKycStatus(res);
				return resDto;
		}



		@Override
		public List<Merchant> getAllMerchant() throws Exception {
			   List<Map<String,Object>>  res=null;
				
			String sql ="select user_id,user_name,last_name,msisdn,category_code,parent_id from users where category_code in ('HMER')";
			   
				System.out.println(sql);
				try {
					res =  jdbcTemplateMobiq.queryForList(sql, new Object[] { });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				  return MonetiqueCarteHelper.getMerchant(res);
				
				 
		}
		public ResponseDto getTotalCashinTrsBy(RequestDto d) throws Exception {
			 
			ResponseDto resDto= new ResponseDto();
			resDto.setTotalTrs(5);
			
			return resDto;
		}
	  
	  

		@Override
		public List<Merchant> getChildrenMerchant(String userId) throws Exception {
			  
			List<Map<String,Object>>  res=null;
			
			String ref= "'"+userId+"'";
				
			String sql ="select user_id,user_name,last_name,msisdn,category_code,parent_id from users where parent_id in ("+ref+") and (category_code in ('HMER','MER') or category_code like 'PSEUDO%') ";
			   
				System.out.println(sql);
				try {
					res =  jdbcTemplateMobiq.queryForList(sql, new Object[] { });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				  return MonetiqueCarteHelper.getMerchant(res);
				
				 
		}



		@Override
		public List<PaiementMerchant> getPaiementMerchantByIntervallDate(List<String> userIds, Date debut, Date fin)
				throws Exception {
	       
			List<Map<String,Object>>  res=null;
			
			
			if(userIds==null || userIds.size()==0)
				return null;
			
			String r="";
			String ref=null;
			for(String x : userIds) {
				ref= "'"+x+"'";
	
				if(r.equals(""))
					r+=ref;
				else
					r+=","+ref;
			}
			
			
				
			String sql =" select transfer_id, transfer_on,transfer_value/100 as montant,attr_5_value as caisse from mtx_transaction_header s where service_type='MERPAYDIG' and transfer_status='TS' " + 
					" and transfer_on >= ? and transfer_on < ? " + 
					" and payee_user_id in ("+r+") order by transfer_on asc";
			   
				System.out.println(sql);
				try {
					res =  jdbcTemplateMobiq.queryForList(sql, new Object[] {debut, fin });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				  return MonetiqueCarteHelper.getPaiementMerchant(res);
		}



		@Override
		public List<PaiementMerchant> getPaiementMerchantByTelAndIntervallDate(List<String> userIds, Date debut,
				Date fin) throws Exception {
	List<Map<String,Object>>  res=null;
			
			
			if(userIds==null || userIds.size()==0)
				return null;
			
			String r="";
			String ref=null;
			for(String x : userIds) {
				ref= "'"+x+"'";
	
				if(r.equals(""))
					r+=ref;
				else
					r+=","+ref;
			}
			
			
				
			String sql =" select transfer_id, transfer_on,transfer_value/100 as montant,attr_5_value as caisse from mtx_transaction_header s where service_type='MERPAYDIG' and transfer_status='TS' " + 
					" and transfer_on >= ? and transfer_on < ? " + 
					" and attr_5_value in ("+r+") order by transfer_on asc";
			   
				System.out.println(sql);
				try {
					res =  jdbcTemplateMobiq.queryForList(sql, new Object[] {debut, fin });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				  return MonetiqueCarteHelper.getPaiementMerchant(res);
		}



		@Override
		public List<PaiementMerchant> getAutoSweepMerchantByIntervallDate(List<String> userIds, Date debut, Date fin)
				throws Exception {
		List<Map<String,Object>>  res=null;
			
			
			if(userIds==null || userIds.size()==0)
				return null;
			
			String r="";
			String ref=null;
			for(String x : userIds) {
				ref= "'"+x+"'";
	
				if(r.equals(""))
					r+=ref;
				else
					r+=","+ref;
			}
			
			
				
			String sql =" select transfer_id, transfer_on,transfer_value/100 as montant,attr_5_value as caisse from mtx_transaction_header where transfer_status='TS' and service_type='CWBREQ' and request_source='WEB' " + 
					" and transfer_on >= ? and transfer_on < ? " + 
					" and payee_user_id in ("+r+") order by transfer_on asc";
			   
				System.out.println(sql);
				try {
					res =  jdbcTemplateMobiq.queryForList(sql, new Object[] {debut, fin });

				} catch (Exception e) {
					//status = "ERREUR";
				}
				  return MonetiqueCarteHelper.getPaiementMerchant(res);
		}



		@Override
		public TrsMobile getAdditionalReference(String userId) throws Exception {
			  
					List<Map<String,Object>>  res=null;

						
					String sql ="select account_no from cust_accounts where  user_id  = ?";
					   
						System.out.println(sql);
						try {
							res =  jdbcTemplateInstr.queryForList(sql, new Object[] {userId });

						} catch (Exception e) {
							//status = "ERREUR";
						}
						  return MonetiqueCarteHelper.getTrsMobileAddRef(res);
		}



		@Override
		public BankilyResponse getVerificationImalByCif(String cif) throws Exception {
			List<Map<String,Object>>  res=null;

			
/*			String sql ="Select  c.branch_code, c.cif_no as CIF,c.id_no as NNI,c.tel as tel_mobile,c.long_name_eng as NOM,a.branch_code,i.tel as tel_imal " + 
					"from imal.cif_address@imal i, imal.cif@imal c , imal.amf@imal a " + 
					"where  c.cif_no = a.cif_sub_no " + 
					"and  c.cif_no = i.cif_no " + 
					"and c.cif_no= ?";
			*/
			String sql ="Select c.tel as tel_mobile,i.tel as tel_imal,i.mobile,i.home_tel,i.work_tel,i.other_tel,c.branch_code, c.cif_no as CIF,c.id_no as NNI,c.long_name_eng as NOM,a.branch_code " + 
					"from imal.cif_address@imal i, imal.cif@imal c , imal.amf@imal a " + 
					"        where  c.cif_no = a.cif_sub_no " + 
					"        and  c.cif_no = i.cif_no " + 
					"        and c.cif_no= ?";
			   
				System.out.println(sql);
				try {
					res =  jdbcTemplateInstr.queryForList(sql, new Object[] {cif });

				} catch (Exception e) {
					System.out.println(e.getMessage());
					//status = "ERREUR";
				}
				  return MonetiqueCarteHelper.getVerificationImal(res);
		}



		@Override
		public BankilyResponse getVerificationMobileByTelephone(String telephone) throws Exception {
			
			List<Map<String,Object>>  res=null;
			
			String sql ="Select   p.cif as CIF,k.kyc_value as NNI,p.mobilenumber as telephone " + 
					"from    party.party p,party.party_kyc_details pk,party.kyc_details k " + 
					"where   p.party_id = pk.party_id " + 
					"and pk.kyc_id = k.kyc_id " + 
					"and  p.mobilenumber= ?";
			   
				System.out.println(sql);
				try {
					res =  jdbcTemplateParty.queryForList(sql, new Object[] {telephone });

				} catch (Exception e) {
					System.out.println(e.getMessage());
					//status = "ERREUR";
				}
				  return MonetiqueCarteHelper.getVerificationMobile(res);
		}



		@Override
		public BankilyResponse getUserIdClientByTelephone(String telephone) throws Exception {
			// TODO Auto-generated method stub
			String userId=getUserIdByTel(telephone);
			BankilyResponse res= new BankilyResponse();
			res.setUserId(userId);
			return res;
		}



		@Override
		public BankilyResponse getUserIdUserByLogin(String login) throws Exception {
			// TODO Auto-generated method stub
			
			String userId=getUserIdByLogin(login);
			BankilyResponse res= new BankilyResponse();
			res.setUserId(userId);
			return res;
		}
	





		
		@Override
		public void deleteLiaisonIncompleteMobile(RequestDto req) throws Exception {
            
			// controle des entrées
			if(req.getTelephone()==null || req.getTelephone().length()!=8) {
				throw new Exception("telephone invalide");
			}
			if(req.getCif()==null || req.getCif().length()<1) {
				throw new Exception("cif invalide");
			}
			if(req.getNni()==null || req.getNni().length()<1) {
				throw new Exception("NNI invalide");
			}
			if(req.getCompte()==null) {
				throw new Exception("Account invalide");
			}
			
			// verification incomplete
			List<String> comptes= new ArrayList<>();
			comptes.add(req.getCompte());
			req.setComptes(comptes);
			BankilyResponse resV=getVerificationMobile(req);
			
			boolean isIncomplete=resV.isIncomplet();
			boolean isFull= resV.isExiste();
			if(!isIncomplete)
				throw new Exception("la liaison n'est pas incomplete");
			else if(isFull)
				throw new Exception("la liaison est complete et sans exception");

			// voir si l'utilisation a pu se connecté
			List<Map<String,Object>>  res=null;
			long creq1=0;
			
			String req1="select count(*) as cpt from USER_CREDENTIALS where user_id in (select user_id from user_details where msisdn = ? )";

			res =  jdbcTemplateDigit.queryForList(req1, new Object[] {req.getTelephone() });					
			creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
			System.out.println(creq1);
			if(creq1>0)
				throw new Exception("le client a deja connecté");
			
			// voir si add_ref ou cif existe dans cust account et appartienne au numero téléphone
			// cif
			String req13_1="select count(*) as cpt from cust_accounts where cifid = ?";
			
			res =  jdbcTemplateInstr.queryForList(req13_1, new Object[] {req.getCif() });					
			creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
			System.out.println(creq1);
			if(creq1>1)
				throw new Exception("il existe plusieur enregistrement dans cust_account");
			
			
			String req13="select user_id from cust_accounts where cifid = ?";
			res =  jdbcTemplateInstr.queryForList(req13, new Object[] {req.getCif() });							   
			String userId= ""+res.get(0).get("user_id");
			System.out.println(userId);
			if(userId!=null) {
				String req14="select msisdn from user_details where user_id= ?";
				res =  jdbcTemplateDigit.queryForList(req14, new Object[] {userId });							   
				String telephone = null;
				if(res!=null && res.size()!=0) {
					telephone=""+res.get(0).get("msisdn");
					if(telephone!=null && !telephone.equals(req.getTelephone()))
						throw new Exception("le numero telephone dans cust account est difference dans digit workspce");
				}
				
			
			}
			
			
			
			
			// add ref
            String req13_2="select count(*) as cpt from cust_accounts where account_no = ?";
			
			res =  jdbcTemplateInstr.queryForList(req13_2, new Object[] {req.getCompte() });					
			creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
			System.out.println(creq1);
			if(creq1>1)
				throw new Exception("il existe plusieur enregistrement dans cust_account");
			
			
			String req133="select user_id from cust_accounts where account_no = ?";
			res =  jdbcTemplateInstr.queryForList(req133, new Object[] {req.getCompte() });			
			if(res!=null && res.size()!=0) {
				String userId2= ""+res.get(0).get("user_id");
				
				if(userId2!=null) {
					String req14_1="select msisdn from user_details where user_id= ?";
					res =  jdbcTemplateDigit.queryForList(req14_1, new Object[] {userId2 });		
					if(res!=null && res.size()!=0) {
	                    String telephone2 = ""+res.get(0).get("msisdn");
						
						if(telephone2!=null && !telephone2.equals(req.getTelephone()))
							throw new Exception("le numero telephone dans cust account est difference dans digit workspce");
			
						
					}
	
				
					}
					
				}
			
			
			// suppresion de l'utilisateur incomplet

			// digital workspace
			String req1_1="delete from USER_CREDENTIALS where user_id in (select user_id from user_details where msisdn = ? )";
			String req2="delete from  auth_value where auth_ref_id in (select auth_ref_id from USER_CREDENTIALS where user_id in (select user_id from user_details where msisdn = ? ))";
			// OK
			String req3="delete from  host_mapping where user_id in (select user_id from user_details where msisdn = ?)";
			String req4="delete from  host_utilities where user_id in (select user_id from user_details where msisdn = ?)";
			String req5="delete from  mtx_socialmedia where user_id in (select user_id from user_details where msisdn = ?)";
			String req6="delete from  request_money where requester_user_id in (select user_id from user_details where msisdn = ?)";
			// OK
			String req7="delete from  user_details where msisdn = ?";

			// party
			String req8="delete from  KYC_IMAGE_MAPPING where IMAGE_REF_ID in (select IMAGE_REF_ID from KYC_DETAILS where KYC_ID in (select kyc_id from PARTY_KYC_DETAILS where PARTY_ID in (select PARTY_ID from party where mobilenumber = ?)))";
			String req9="delete from  KYC_DETAILS where KYC_ID in (select kyc_id from PARTY_KYC_DETAILS where PARTY_ID in (select PARTY_ID from party where mobilenumber = ? ))";
			String req10="delete from  PARTY_KYC_DETAILS where PARTY_ID in (select PARTY_ID from party where mobilenumber = ?)";			
			String req11="delete from  party where mobilenumber = ? ";
			// instr
			String req12="delete  from cust_accounts where account_no = ?";
			String req13_3="delete  from cust_accounts where cifid = ? ";
			

			
			
			// digital work
			try {
				int e= jdbcTemplateDigit.update(req1_1, new Object[] {req.getTelephone() });
				System.out.println(e);
			} catch (Exception e) {
				throw new Exception("Erreur lors de la suppresion de la liaison incomplete"+e.getMessage());
			}
			
			try {
				int e=jdbcTemplateDigit.update(req2, new Object[] {req.getTelephone() });	
				System.out.println(e);
			} catch (Exception e) {
				throw new Exception("Erreur lors de la suppresion de la liaison incomplete"+e.getMessage());
			}
			
			try {
				int e=jdbcTemplateDigit.update(req3, new Object[] {req.getTelephone() });	
				System.out.println(e);
			} catch (Exception e) {
				throw new Exception("Erreur lors de la suppresion de la liaison incomplete"+e.getMessage());
			}
			
			try {
				int e=jdbcTemplateDigit.update(req4, new Object[] {req.getTelephone() });	
				System.out.println(e);
			} catch (Exception e) {
				throw new Exception("Erreur lors de la suppresion de la liaison incomplete"+e.getMessage());
			}
			
			try {
				int e=jdbcTemplateDigit.update(req5, new Object[] {req.getTelephone() });	
				System.out.println(e);
			} catch (Exception e) {
				throw new Exception("Erreur lors de la suppresion de la liaison incomplete"+e.getMessage());
			}
			
			try {
				int e=jdbcTemplateDigit.update(req6, new Object[] {req.getTelephone() });	
				System.out.println(e);
			} catch (Exception e) {
				throw new Exception("Erreur lors de la suppresion de la liaison incomplete"+e.getMessage());
			}
			try {
				int e=jdbcTemplateDigit.update(req7, new Object[] {req.getTelephone() });	
				System.out.println(e);
			} catch (Exception e) {
				throw new Exception("Erreur lors de la suppresion de la liaison incomplete"+e.getMessage());
			}
			// party
			try {
				int e=jdbcTemplateParty.update(req8, new Object[] {req.getTelephone() });	
				System.out.println(e);
			} catch (Exception e) {
				throw new Exception("Erreur lors de la suppresion de la liaison incomplete"+e.getMessage());
			}
			try {
				int e=jdbcTemplateParty.update(req9, new Object[] {req.getTelephone() });	
				System.out.println(e);
			} catch (Exception e) {
				throw new Exception("Erreur lors de la suppresion de la liaison incomplete"+e.getMessage());
			}
			try {
				int e=jdbcTemplateParty.update(req10, new Object[] {req.getTelephone() });	
				System.out.println(e);
			} catch (Exception e) {
				throw new Exception("Erreur lors de la suppresion de la liaison incomplete"+e.getMessage());
			}
			try {
				int e=jdbcTemplateParty.update(req11, new Object[] {req.getTelephone() });	
				System.out.println(e);
			} catch (Exception e) {
				throw new Exception("Erreur lors de la suppresion de la liaison incomplete"+e.getMessage());
			}

			// inst mngt
			try {
				int e=jdbcTemplateInstr.update(req12, new Object[] {req.getCompte() });	
				System.out.println(e);
			} catch (Exception e) {
				throw new Exception("Erreur lors de la suppresion de la liaison incomplete"+e.getMessage());
			}
			try {
				int e=jdbcTemplateInstr.update(req13_3, new Object[] {req.getCif() });	
				System.out.println(e);
			} catch (Exception e) {
				throw new Exception("Erreur lors de la suppresion de la liaison incomplete"+e.getMessage());
			}		
	
		}
		
		@Override
		public BankilyResponse getVerificationMobile(RequestDto req) throws Exception {
	
			List<Map<String,Object>>  res=null;
			
			boolean isIncomplet=false;
			boolean isExiste=false;
			
			int total=0;
			long creq1=0;
			
			// digital workspace
	//		String req1="select count(*) as cpt from USER_CREDENTIALS where user_id in (select user_id from user_details where msisdn = ? )";
	//		String req2="select count(*) as cpt from auth_value where auth_ref_id in (select auth_ref_id from USER_CREDENTIALS where user_id in (select user_id from user_details where msisdn = ? ))";
			// OK
			String req3="select count(*) as cpt from host_mapping where user_id in (select user_id from user_details where msisdn = ?)";
//			String req4="select count(*) as cpt from host_utilities where user_id in (select user_id from user_details where msisdn = ?)";
//			String req5="select count(*) as cpt from mtx_socialmedia where user_id in (select user_id from user_details where msisdn = ?)";
//			String req6="select count(*) as cpt from request_money where requester_user_id in (select user_id from user_details where msisdn = ?)";
			// OK
			String req7="select count(*) as cpt from user_details where msisdn = ?";

			// party
			String req8="select count(*) as cpt from KYC_IMAGE_MAPPING where IMAGE_REF_ID in (select IMAGE_REF_ID from KYC_DETAILS where KYC_ID in (select kyc_id from PARTY_KYC_DETAILS where PARTY_ID in (select PARTY_ID from party where mobilenumber = ?)))";
			String req9="select count(*) as cpt from KYC_DETAILS where KYC_ID in (select kyc_id from PARTY_KYC_DETAILS where PARTY_ID in (select PARTY_ID from party where mobilenumber = ? ))";
			String req10="select count(*) as cpt from PARTY_KYC_DETAILS where PARTY_ID in (select PARTY_ID from party where mobilenumber = ?)";			
			String req11="select count(*) as cpt from party where mobilenumber = ?";

			String req14="select count(*) as cpt from kyc_details where kyc_value= ? ";
			
			// instr
			String req12="select count(*) as cpt from cust_accounts where account_no in (";
			String accounts="";
			if(req.getComptes()!=null && req.getComptes().size()>0)
			for(String ac : req.getComptes()) {
				if(accounts.equals(""))
				    accounts+="'"+ac+"'";
				else
					accounts+=",'"+ac+"'";
			}
			req12+=accounts+")";
			
			String req13="select count(*) as cpt from cust_accounts where cifid =?";
			
			
			
					if(req.getTelephone()==null || req.getTelephone().length()!=8) {
						throw new Exception("telephone invalide");
					}
					if(req.getCif()==null || req.getCif().length()<1) {
						throw new Exception("cif invalide");
					}
					if(req.getNni()==null || req.getNni().length()<1) {
						throw new Exception("NNI invalide");
					}
					if(req.getComptes()==null || req.getComptes().size()==0) {
						throw new Exception("Account invalide");
					}
					// digital work
				/*	res =  jdbcTemplateDigit.queryForList(req1, new Object[] {req.getTelephone() });					
					creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
					System.out.println(creq1);
					if(creq1==0)
						isExiste=false;
					else
						isIncomplet=true;
					
					res =  jdbcTemplateDigit.queryForList(req2, new Object[] {req.getTelephone() });					
					creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
					System.out.println(creq1);
					if(creq1==0)
						isExiste=false;
					else
						isIncomplet=true;
					*/
					res =  jdbcTemplateDigit.queryForList(req3, new Object[] {req.getTelephone() });					
					creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
					System.out.println(creq1);
					if(creq1>0)
						total++;
					
				/*	res =  jdbcTemplateDigit.queryForList(req4, new Object[] {req.getTelephone() });					
					creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
					System.out.println(creq1);
					if(creq1==0)
						isExiste=false;
					else
						isIncomplet=true;
					
					res =  jdbcTemplateDigit.queryForList(req5, new Object[] {req.getTelephone() });					
					creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
					System.out.println(creq1);
					if(creq1==0)
						isExiste=false;
					else
						isIncomplet=true;
					
					res =  jdbcTemplateDigit.queryForList(req6, new Object[] {req.getTelephone() });					
					creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
					System.out.println(creq1);
					if(creq1==0)
						isExiste=false;
					else
						isIncomplet=true;
					*/
					res =  jdbcTemplateDigit.queryForList(req7, new Object[] {req.getTelephone() });					
					creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
					System.out.println(creq1);
					if(creq1>0)
						total++;
					
					
					// party
					System.out.println("*** party");
					
					res =  jdbcTemplateParty.queryForList(req8, new Object[] {req.getTelephone() });					
					creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
					System.out.println(creq1);
					if(creq1>0)
						total++;
					
					res =  jdbcTemplateParty.queryForList(req9, new Object[] {req.getTelephone() });					
					creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
					System.out.println(creq1);
					if(creq1>0)
						total++;
					
					res =  jdbcTemplateParty.queryForList(req10, new Object[] {req.getTelephone() });					
					creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
					System.out.println(creq1);
					if(creq1>0)
						total++;
					
					res =  jdbcTemplateParty.queryForList(req11, new Object[] {req.getTelephone() });					
					creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
					System.out.println(creq1);
					if(creq1>0)
						total++;
					
					res =  jdbcTemplateParty.queryForList(req14, new Object[] {req.getNni() });					
					creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
					System.out.println(creq1);
					if(creq1>0)
						total++;
					
					// intr mngt
					System.out.println("*** intr mngt");

					res =  jdbcTemplateInstr.queryForList(req12, new Object[] { });		
					creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
					System.out.println(creq1);
					if(creq1>0)
						total++;
					
					res =  jdbcTemplateInstr.queryForList(req13, new Object[] {req.getCif() });					
					creq1=	((BigDecimal) res.get(0).get("cpt")).longValueExact();
					System.out.println(creq1);
					if(creq1>0)
						total++;
					
					
					if(total==9) {
						// existe 
						isExiste=true;
						isIncomplet=false;
						
					}
					else if(total==0) {
						// non lié
						isExiste=false;
						isIncomplet=false;
					}
					else {
						// incomplet
						isExiste=false;
						isIncomplet=true;
					}
				
					
				
			       BankilyResponse br= new BankilyResponse();
			       br.setExiste(isExiste);
			       br.setIncomplet(isIncomplet);
			       
			       return br;
		}
		

		@Override
		public ResponseDto getTrsRechargeMobilebyTrsIdIntervall(RequestDto req) throws Exception {
			List<Map<String,Object>>  res=null;
			
			String sql ="select transfer_id  from mtx_transaction_header where transfer_status= 'TS' and service_type = 'RECHRGDIGI' and transfer_id >= ? and transfer_id <= ?";
			   
				System.out.println(sql);
				try {
					res =  jdbcTemplateBus.queryForList(sql, new Object[] {req.getTrsIdDebut(),req.getTrsIdFin()});

				} catch (Exception e) {
					System.out.println(e.getMessage());
					//status = "ERREUR";
				}
				List<String> list=MonetiqueCarteHelper.getTransactionIdMobile(res);
				ResponseDto r=new ResponseDto();
				r.setTransactionIds(list);
				return r;
		}



		@Override
		public BankilyResponse getNomMerchant(String trsId) throws Exception {
	   List<Map<String,Object>>  res=null;
	 		
	       String trs= "'"+trsId+"'";
	
			String sql ="select user_name from users where  user_id in (select payee_user_id from mtx_transaction_header where transfer_id in ("+trs+"))";
			   
				System.out.println(sql);
				try {
					res =  jdbcTemplateMobiq.queryForList(sql, new Object[] { });

				} catch (Exception e) {
					System.out.println(e.getMessage());
					//status = "ERREUR";
				}
				  return MonetiqueCarteHelper.getNomMerchant(res);
		}

		
}
