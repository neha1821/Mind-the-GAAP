package com.mindgate.main.repository;

import java.util.List;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.Cheque;


public interface ChequeRepositoryInterface {
	
	public boolean addNewCheque(Cheque cheque);
	public Cheque updateCheque(Cheque cheque);
	public boolean deleteCheque(int chequeId);
	public Cheque getChequeByChequeId(int chequeId);
	public List<Cheque> getAllCheque();
	public List<Cheque> getAllChequeListByReceiverAccountId(Account account);
	public List<Cheque> getAllChequeActive();
	public Cheque updateChequeAmount(Cheque cheque);

	


}
