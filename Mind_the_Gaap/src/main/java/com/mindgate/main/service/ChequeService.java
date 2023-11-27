package com.mindgate.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mindgate.main.domain.Account;
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

	@Override
	public List<Cheque> getAllChequeListByReceiverAccountId(Account account) {
		// TODO Auto-generated method stub
		return chequeRepositoryInterface.getAllChequeListByReceiverAccountId(account);
	}

	@Override
	public List<Cheque> getAllChequeActive() {
		// TODO Auto-generated method stub
		return chequeRepositoryInterface.getAllChequeActive();
	}

	@Override
	public Cheque updateChequeAmount(Cheque cheque) {
		if (cheque.getFromAccount().getAccountType().equalsIgnoreCase("SAVING_ACCOUNT")) {
			if (cheque.getAmount() <= cheque.getFromAccount().getCurrentBalance()) {
				cheque.getFromAccount()
						.setCurrentBalance(cheque.getFromAccount().getCurrentBalance() - cheque.getAmount());
				cheque.getToAccount().setCurrentBalance(cheque.getToAccount().getCurrentBalance() + cheque.getAmount());
				return cheque;
			}
		} else if (cheque.getFromAccount().getAccountType().equalsIgnoreCase("CURRENT_ACCOUNT")) {
			if (cheque.getAmount() <= cheque.getFromAccount().getCurrentBalance()
					+ cheque.getFromAccount().getOverDraftBalance()) {
				if (cheque.getAmount() <= cheque.getFromAccount().getCurrentBalance()) {
					cheque.getFromAccount()
							.setCurrentBalance(cheque.getFromAccount().getCurrentBalance() - cheque.getAmount());
					cheque.getToAccount()
							.setCurrentBalance(cheque.getToAccount().getCurrentBalance() + cheque.getAmount());
					return cheque;
				} else if (cheque.getAmount() > cheque.getFromAccount().getCurrentBalance()
						&& cheque.getFromAccount().getCurrentBalance() > 0) {
					cheque.getFromAccount()
							.setCurrentBalance(cheque.getFromAccount().getCurrentBalance() - cheque.getAmount());
					if (cheque.getFromAccount().getCurrentBalance() < 0) {
						cheque.getFromAccount().setOverDraftBalance(cheque.getFromAccount().getOverDraftBalance()
								+ cheque.getFromAccount().getCurrentBalance());
						cheque.getFromAccount().setCurrentBalance(0);
						if (cheque.getAmount() > 0 && cheque.getToAccount().getOverDraftBalance() != 10000) {
							cheque.getToAccount().setOverDraftBalance(
									cheque.getToAccount().getOverDraftBalance() + cheque.getAmount());
							if (cheque.getToAccount().getOverDraftBalance() > 10000) {
								double temp = cheque.getToAccount().getOverDraftBalance() - 10000;
								cheque.getToAccount()
										.setCurrentBalance(cheque.getToAccount().getCurrentBalance() + temp);
								cheque.getToAccount()
										.setOverDraftBalance(cheque.getToAccount().getOverDraftBalance() - temp);
								return cheque;
							}
						} else {
							cheque.getToAccount()
									.setCurrentBalance(cheque.getToAccount().getCurrentBalance() + cheque.getAmount());
							return cheque;
						}

					}
				} else if (cheque.getFromAccount().getCurrentBalance() == 0
						&& cheque.getAmount() <= cheque.getFromAccount().getOverDraftBalance()) {
					cheque.getFromAccount()
							.setOverDraftBalance(cheque.getFromAccount().getOverDraftBalance() - cheque.getAmount());
					if (cheque.getAmount() > 0 && cheque.getToAccount().getOverDraftBalance() != 10000) {
						cheque.getToAccount()
								.setOverDraftBalance(cheque.getToAccount().getOverDraftBalance() + cheque.getAmount());
						if (cheque.getToAccount().getOverDraftBalance() > 10000) {
							double temp = cheque.getToAccount().getOverDraftBalance() - 10000;
							cheque.getToAccount().setCurrentBalance(cheque.getToAccount().getCurrentBalance() + temp);
							cheque.getToAccount()
									.setOverDraftBalance(cheque.getToAccount().getOverDraftBalance() - temp);
							return cheque;
						}
					} else {
						cheque.getToAccount()
								.setCurrentBalance(cheque.getToAccount().getCurrentBalance() + cheque.getAmount());
						return cheque;
					}
					return cheque;
				}

			}
		}
		return chequeRepositoryInterface.updateChequeAmount(cheque);
	}

}
