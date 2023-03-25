package net.cyperts.cfs.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.cyperts.cfs.entity.NotesForFinancialStatementBSPL;

public interface NotesForFinancialStatementService {

	
	public List<NotesForFinancialStatementBSPL> getAllntfs();

	public void deletebyspecificidntfs(int id);

	public void saventfs(MultipartFile file);
	
	
}
