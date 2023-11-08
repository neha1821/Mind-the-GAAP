package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Cheque;
import com.mindgate.main.repository.ChequeRepositoryInterface;

@Repository
public class ChequeService implements ChequeServiceInterface {
	
	@Autowired
	private ChequeRepositoryInterface chequeRepositoryInterface;

	@Override
	public boolean addNewCheque(Cheque cheque) {
		
		return chequeRepositoryInterface.addNewCheque(cheque);
	}

	@Override
	public Cheque updateCheque(Cheque cheque) {
		
		return chequeRepositoryInterface.updateCheque(cheque);
	}

	@Override
	public boolean deleteCheque(int chequeId) {
		
		return chequeRepositoryInterface.deleteCheque(chequeId);
	}

	@Override
	public Cheque getChequeByChequeId(int chequeId) {
		return chequeRepositoryInterface.getChequeByChequeId(chequeId);
	}

	@Override
	public List<Cheque> getAllCheque() {
		
		return chequeRepositoryInterface.getAllCheque();
	}

}
