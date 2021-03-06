package org.hqf.spring.transcaction.service;

import org.hqf.spring.transcaction.dao.AccountDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Transactional(isolation= Isolation.REPEATABLE_READ,propagation= Propagation.REQUIRED,readOnly=true)
public class AccountAnnotationServiceImpl implements AccountService {

	private AccountDao ad ;
	private TransactionTemplate tt;

	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void transfer(final Integer from,final Integer to,final Double money) {
				//减钱
				ad.decreaseMoney(from, money);
				int i = 1/0;
				//加钱
				ad.increaseMoney(to, money);
	}

/*	@Override
	public void transfer(final Integer from,final Integer to,final Double money) {
		
		tt.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				//减钱
				ad.decreaseMoney(from, money);
				int i = 1/0;
				//加钱
				ad.increaseMoney(to, money);
			}
		});
		
		
	}
*/
	public void setAd(AccountDao ad) {
		this.ad = ad;
	}

	public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}
	
	

}
