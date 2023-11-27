package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Account;
import com.mindgate.main.domain.Cheque;
import com.mindgate.main.domain.LoginDetails;
import com.mindgate.main.service.ChequeServiceInterface;
import com.mindgate.main.service.EmailSenderService;

@RestController
@RequestMapping("chequeCRUDapi")
@CrossOrigin("*")
public class ChequeCRUDController {
	public ChequeCRUDController() {
		System.out.println("ChequeCRUDController object is created!!");
	}

	@Autowired
	private ChequeServiceInterface chequeServiceInterface;

	@Autowired
	private EmailSenderService emailSenderService;

	@RequestMapping(value = "send/cheque", method = RequestMethod.POST)
	public boolean sendMail(@RequestBody Cheque cheque) {
		int chequeId = cheque.getFromAccount().getAccountId();
		String chequeIdNew = Integer.toString(chequeId);
		double currentBalance = cheque.getToAccount().getCurrentBalance();
		String currentBalanceNew = Double.toString(currentBalance);
		String message = "ALERT MESSAGE\n\nYour Cheque Has Been Bounced Due to Insufficient Balance " + "\n \n"
				+ " Your Account No: XX" + chequeIdNew + " Rs.50 Deducted From Your Account \n\n Your Current Balance"
				+ currentBalanceNew + "  Thank you..";
		emailSenderService.sendEmail(cheque.getFromAccount().getCustomerId().getEmail(),
				"Cheque Bounced !!! - Apex Bank ", message);
		// emailSenderService.sendEmail("rajifalitmv@gmail.com","confirmation","this is
		// new email sent by rajif");
		System.out.println("email sent");
		return true;
	}

	// http://localhost:8081/chequeCRUDapi/add
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public boolean addNewCheque(@RequestBody Cheque cheque) {
		return chequeServiceInterface.addNewCheque(cheque);
	}

	// http://localhost:8081/chequeCRUDapi/update
	@RequestMapping(value = "update", method = RequestMethod.PUT)
	public Cheque updateCheque(@RequestBody Cheque cheque) {
		System.out.println("update cheque");
		return chequeServiceInterface.updateCheque(cheque);
	}

	// http://localhost:8081/chequeCRUDapi/delete
	@RequestMapping(value = "delete/{chequeId}", method = RequestMethod.DELETE)
	public boolean deleteCheque(@PathVariable int chequeId) {
		return chequeServiceInterface.deleteCheque(chequeId);
	}

	// http://localhost:8081/chequeCRUDapi/getone
	@RequestMapping(value = "getone/{chequeId}", method = RequestMethod.GET)
	public Cheque getChequeByChequeId(@PathVariable int chequeId) {
		System.out.println("in controller");
		return chequeServiceInterface.getChequeByChequeId(chequeId);
	}

	// http://localhost:8081/chequeCRUDapi/getall
	@RequestMapping(value = "getall", method = RequestMethod.GET)
	public List<Cheque> getAllCheque() {
		return chequeServiceInterface.getAllCheque();
	}

	@RequestMapping(value = "getall/receive/cheque", method = RequestMethod.POST)
	public List<Cheque> getAllCheque(@RequestBody Account account) {
		return chequeServiceInterface.getAllChequeListByReceiverAccountId(account);
	}

	@RequestMapping(value = "getall/active", method = RequestMethod.GET)
	public List<Cheque> getAllChequeActive() {
		return chequeServiceInterface.getAllChequeActive();
	}

	@RequestMapping(value = "updatecheque", method = RequestMethod.PUT)
	public Cheque updateChequeAmount(@RequestBody Cheque cheque) {
		System.out.println("update cheque");
		return chequeServiceInterface.updateChequeAmount(cheque);
	}

}
