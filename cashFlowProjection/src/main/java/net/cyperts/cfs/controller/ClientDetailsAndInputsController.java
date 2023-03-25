package net.cyperts.cfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.cyperts.cfs.entity.ClientDetailsAndInputs;
import net.cyperts.cfs.services.ClientDetailsAndInputsService;

@RestController
@CrossOrigin("*")
public class ClientDetailsAndInputsController {

	@Autowired
	private ClientDetailsAndInputsService clientDetailsAndInputsService;
	@PostMapping("/client")
	public void addservice(@RequestBody ClientDetailsAndInputs clientDetailsAndInputs)
	{
		clientDetailsAndInputsService.addservice(clientDetailsAndInputs);
	}
	

}
