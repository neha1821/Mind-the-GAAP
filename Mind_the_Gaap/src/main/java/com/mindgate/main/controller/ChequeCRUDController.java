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

	// http://localhost:8081/chequeCRUDapi/add
	@RequestMapping(value = "add" , method = RequestMethod.POST )
	public boolean addNewCheque(@RequestBody Cheque cheque) {
		System.out.println("add new cheque ");
		return chequeServiceInterface.addNewCheque(cheque);
	}

	// http://localhost:8081/chequeCRUDapi/update
	@RequestMapping(value = "update" , method = RequestMethod.PUT)
	public Cheque updateCheque(@RequestBody Cheque cheque) {
		return chequeServiceInterface.updateCheque(cheque);
	}

	// http://localhost:8081/chequeCRUDapi/delete
	@RequestMapping(value = "delete/{cheque_id}" , method = RequestMethod.DELETE)
	public boolean deleteCheque(@PathVariable int cheque_id) {
		return chequeServiceInterface.deleteCheque(cheque_id);
	}

	// http://localhost:8081/chequeCRUDapi/getone
	@RequestMapping(value = "getone/{cheque_id}" , method = RequestMethod.GET )
	public Cheque getChequeByChequeId(@PathVariable int cheque_id) {
		return chequeServiceInterface.getChequeByChequeId(cheque_id);
	}

	// http://localhost:8081/chequeCRUDapi/getall
	@RequestMapping(value = "getall" , method = RequestMethod.GET )
	public List<Cheque> getAllCheque() {
		return chequeServiceInterface.getAllCheque();
	}
}
	


