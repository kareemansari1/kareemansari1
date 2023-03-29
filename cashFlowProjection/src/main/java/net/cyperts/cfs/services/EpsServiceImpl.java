package net.cyperts.cfs.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.cyperts.cfs.entity.Eps;
import net.cyperts.cfs.helper.EpsHelper;
import net.cyperts.cfs.repository.EpsRepository;

@Service
public class EpsServiceImpl implements EpsService {
	@Autowired
	private EpsRepository epsRepository;
	
	public void saveEps(MultipartFile file) 
	{

	
	try {
		List<Eps> product = EpsHelper.convertExcelToListEps(file.getInputStream());
		this.epsRepository.saveAll(product);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}


	@Override
	public List<Eps> getAll() {
		// TODO Auto-generated method stub
		return this.epsRepository.findAll();
	}
}
