package net.cyperts.cfs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cyperts.cfs.entity.ClientDetailsAndInputs;
import net.cyperts.cfs.repository.ClientDetailsAndInputsRepository;
@Service
public class ClientDetailsAndInputsServiceImpl implements ClientDetailsAndInputsService {
	@Autowired
private ClientDetailsAndInputsRepository clientDetailsAndInputsRepository;
	@Override
	public void addservice(ClientDetailsAndInputs clientDetailsAndInputs) {
		// TODO Auto-generated method stub
		clientDetailsAndInputsRepository.save(clientDetailsAndInputs);
	}
	
	

}
