package net.cyperts.cfs.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.cyperts.cfs.entity.Eps;
import net.cyperts.cfs.entity.Ppe;
import net.cyperts.cfs.helper.EpsHelper;
import net.cyperts.cfs.helper.PpeHelper;
import net.cyperts.cfs.repository.PpeRepository;

@Service
public class PpeServiceImpl implements PpeService{
	@Autowired
	private PpeRepository ppeRepository;
	public void savePpe(MultipartFile file) 
	{

	
	try {
		List<Ppe> product = PpeHelper.convertExcelToListPpe(file.getInputStream());
		this.ppeRepository.saveAll(product);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	@Override
	public List<Ppe> getAll() {
		// TODO Auto-generated method stub
		return this.ppeRepository.findAll();
	}
	


}
