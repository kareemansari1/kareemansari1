package net.cyperts.cfs.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.cyperts.cfs.entity.NotesForFinancialStatementBSPL;
import net.cyperts.cfs.helper.NotesForFinancialStatementHelper;
import net.cyperts.cfs.repository.NotesForFinancialStatementRepository;

@Service
public class NotesForFinancialStatementServiceImpl implements NotesForFinancialStatementService {
	
	@Autowired
private	NotesForFinancialStatementRepository notesForFinancialStatementRepository;

	public void saventfs(MultipartFile file) 
	{

	
	try {
		List<NotesForFinancialStatementBSPL> products = NotesForFinancialStatementHelper.convertExcelToListOfProduct(file.getInputStream());
		this.notesForFinancialStatementRepository.saveAll(products);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	

	@Override
	public List<NotesForFinancialStatementBSPL> getAllntfs() {
		// TODO Auto-generated method stub
		return this.notesForFinancialStatementRepository.findAll();
	}

	@Override
	public void deletebyspecificidntfs(int id) {
		// TODO Auto-generated method stub
		notesForFinancialStatementRepository.deleteById(id);
		
	}

	
}
