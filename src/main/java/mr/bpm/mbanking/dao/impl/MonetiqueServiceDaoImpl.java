package mr.bpm.mbanking.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mr.bpm.mbanking.dao.MonetiqueServiceDao;
import mr.bpm.mbanking.dot.Historique;
import mr.bpm.mbanking.dot.MonetiqueClass;
import mr.bpm.mbanking.helper.MonetiqueCarteHelper;

@Repository
public class MonetiqueServiceDaoImpl implements MonetiqueServiceDao{
	@Autowired
	  private DataSource dataSource;
	  private JdbcTemplate jdbcTemplate;

	  @PostConstruct
	  private void postConstruct() {
	      jdbcTemplate = new JdbcTemplate(dataSource);
	  }

	@Override
	public List<MonetiqueClass> getAuthByPan(String pan) {
		// TODO Auto-generated method stub
		
		List<MonetiqueClass> out=null;
		
		List<Map<String,Object>>  res=null;
		
		String sql ="select s.aut_requ_syst_time, s.aut_retr_ref_numb_f037, s.aut_bill_amou_f006, " + 
				" s.aut_comm_amou, " + 
				" s.aut_bill_curr_f051,s.aut_tran_code, " + 
				" s.AUT_TRAN_AMOU_F004 , " + 
				" s.AUT_TRAN_CURR_F049 , " + 
				" s.AUT_BILL_CONV_RATE_F010 , " + 
				" s.aut_auth_id_resp_f038, " + 
				" s.AUT_REVE_STAT " + 
				" from online_authorization s where aut_prim_acct_numb_f002 = ? " + 
				" and s.aut_resp_code_f039_2 = 00 " + 
				" and s.aut_tran_code <> 21011 " + 
				" and s.aut_tran_code <> 21004 " + 
				" order by s.aut_requ_syst_time";
		
		System.out.println(sql);
		try {
			res =  jdbcTemplate.queryForList(sql, new Object[] { pan });

		} catch (Exception e) {
			//status = "ERREUR";
		}
		
		out=MonetiqueCarteHelper.toAuthtOut(res);

		//System.out.println("ok");
		
		return out;
	}

	@Override
	public List<MonetiqueClass> getClByPan(String pan) {
		
		List<MonetiqueClass> out=null;
		
		List<Map<String,Object>>  res=null;
		
		String sql =" select s.vtr_proc_date, " + 
				" s.vtr_aut_retr_ref_numb, " + 
				" s.vtr_tc_code, " + 
				" s.vtr_purc_date, " + 
				" s.vtr_bill_amou,s.vtr_bill_curr , " + 
				" s.VTR_TRAN_AMOU , " + 
				" s.VTR_TRAN_CURR , " + 
				" s.VTR_CHLD_ACC_CURR_RATE , " + 
				" s.VTR_AUTH_CODE " + 
				" from daily_valid_trans s " + 
				" where " + 
				" vtr_tc_code <> 10237 " + 
				" and vtr_tc_code <> 21031 " + 
				" and vtr_tc_code <> 10226 " + 
				" and vtr_card_numb= ? ";
		
		System.out.println(sql);
		try {
			res =  jdbcTemplate.queryForList(sql, new Object[] { pan });

		} catch (Exception e) {
			//status = "ERREUR";
		}
		
		out=MonetiqueCarteHelper.toClOut(res);

		//System.out.println("ok");
		
		return out;
	}

	@Override
	public List<Historique> getHistByPan(String pan) {
	
		List<Historique> out=null;
		
		List<Map<String,Object>>  res=null;
		
		String sql =" select ach_date, ach_new_avai_amou, ach_new_auth_cumu, ach_new_used_cumu , ach_user, host from account_history_new  " + 
				" where ach_acc_code in (select acc_code from account where acc_code in ( " + 
				" select cro_acc_code from cardholder_routing where cro_pan= ?))";
		
		System.out.println(sql);
		try {
			res =  jdbcTemplate.queryForList(sql, new Object[] { pan });

		} catch (Exception e) {
			//status = "ERREUR";
		}
		
		out=MonetiqueCarteHelper.toHistOut(res);

	//	System.out.println("ok");
		
		return out;
	}

	@Override
	public List<Double> getAllCarte() {
	
		List<Double> out=null;
		
		List<Map<String,Object>>  res=null;
		
		String sql =" select distinct z.aut_prim_acct_numb_f002 " + 
				" from online_authorization z,daily_valid_trans d " + 
				" where  vtr_aut_code = aut_code " + 
				" and aut_prim_acct_numb_f002 like '530347%' " + 
				" and  vtr_proc_date > to_date('01/01/2018','dd/mm/yyyy') " + 
				" and aut_requ_syst_time < to_date('01/01/2018','dd/mm/yyyy') ";
		
		System.out.println(sql);
		try {
			res =  jdbcTemplate.queryForList(sql, new Object[] {  });

		} catch (Exception e) {
			//status = "ERREUR";
		}
		
		out=MonetiqueCarteHelper.toCarteOut(res);

		//System.out.println("ok");
		
		return out;
	}
	
	
}
