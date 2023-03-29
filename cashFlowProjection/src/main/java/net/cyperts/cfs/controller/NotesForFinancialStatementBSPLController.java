package net.cyperts.cfs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.cyperts.cfs.entity.NotesForFinancialStatementBSPL;
import net.cyperts.cfs.helper.NotesForFinancialStatementHelper;
import net.cyperts.cfs.services.NotesForFinancialStatementService;

@RestController
@CrossOrigin("*")
public class NotesForFinancialStatementBSPLController {

	@Autowired
	private NotesForFinancialStatementService notesForFinancialStatementService;
	
	@PostMapping("/uploadntfs")
	public ResponseEntity<?> uploadntfs(@RequestParam("file") MultipartFile file)
	{
		if(NotesForFinancialStatementHelper.checkExcelFormat(file))
		{
			// true 
		this.notesForFinancialStatementService.saventfs(file);
            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));
	
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
	}
	
	@GetMapping("/getallntfs")
	public List<NotesForFinancialStatementBSPL>getAllntfs()
	{
		return this.notesForFinancialStatementService.getAllntfs();
	}
	
	 @DeleteMapping("/deletebyspecificidntfs/{id}")
		public void deletebyspecificid(@PathVariable("id") int id) {
		 notesForFinancialStatementService.deletebyspecificidntfs(id);	
		}

}

