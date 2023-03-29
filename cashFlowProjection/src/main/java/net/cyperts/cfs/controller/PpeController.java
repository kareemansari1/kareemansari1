package net.cyperts.cfs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.cyperts.cfs.entity.Eps;
import net.cyperts.cfs.entity.Ppe;
import net.cyperts.cfs.helper.PpeHelper;
import net.cyperts.cfs.services.PpeService;

@RestController
@CrossOrigin("*")
public class PpeController {
	@Autowired
	private PpeService ppeService;
	@PostMapping("/uploadppe")
	public ResponseEntity<?> uploadppe(@RequestParam("file") MultipartFile file)
	{
		if(PpeHelper.checkExcelFormatPpe(file))
		{
			// true 
		this.ppeService.savePpe(file);
            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));
	
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
	}
	
	@GetMapping("/getppe")
	public List<Ppe>getAll()
	{
		return this.ppeService.getAll();
	}
	
}
