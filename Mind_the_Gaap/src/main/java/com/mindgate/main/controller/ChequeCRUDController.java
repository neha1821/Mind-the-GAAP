package com.mindgate.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Cheque;

import com.mindgate.main.service.ChequeServiceInterface;


@RestController
@RequestMapping("chequeCRUDapi")
public class ChequeCRUDController {
	

	@Autowired
	private ChequeServiceInterface chequeServiceInterface;

	// http://localhost:8081/chequeCRUDapi/cheque
	@RequestMapping(value = "cheque" , method = RequestMethod.POST )
	public boolean addNewCheque(@RequestBody Cheque cheque) {
		return chequeServiceInterface.addNewCheque(cheque);
	}

	@RequestMapping(value = "cheque" , method = RequestMethod.PUT)
	public Cheque updateCheque(@RequestBody Cheque cheque) {
		return chequeServiceInterface.updateCheque(cheque);
	}

	@RequestMapping(value = "cheque/{cheque_id}" , method = RequestMethod.DELETE)
	public boolean deleteCheque(@PathVariable int cheque_id) {
		return chequeServiceInterface.deleteCheque(cheque_id);
	}

	@RequestMapping(value = "cheque/{cheque_id}" , method = RequestMethod.GET )
	public Cheque getChequeByChequeId(int cheque_id) {
		return chequeServiceInterface.getChequeByChequeId(cheque_id);
	}

	@RequestMapping(value = "cheques" , method = RequestMethod.GET )
	public List<Cheque> getAllCheque() {
		return chequeServiceInterface.getAllCheque();
	}
}
	


