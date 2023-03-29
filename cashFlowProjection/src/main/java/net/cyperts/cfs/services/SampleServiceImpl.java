package net.cyperts.cfs.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.cyperts.cfs.entity.sample;
import net.cyperts.cfs.helper.SampleHelper;
import net.cyperts.cfs.repository.SampleRepository;
@Service
public class SampleServiceImpl implements SampleService{
	@Autowired
	private SampleRepository sampleRepository;
	public void savesample(MultipartFile file) 
	{

	
	try {
		List<sample> products=SampleHelper.convertExcelToListOfProduct(file.getInputStream());
		this.sampleRepository.saveAll(products);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	@Override
	public List<sample> getAll() {
		// TODO Auto-generated method stub
		return this.sampleRepository.findAll();
	}

}
