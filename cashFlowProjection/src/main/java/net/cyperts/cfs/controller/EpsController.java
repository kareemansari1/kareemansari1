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
import net.cyperts.cfs.helper.EpsHelper;
import net.cyperts.cfs.services.EpsService;

@RestController
@CrossOrigin("*")
public class EpsController {
	
	@Autowired
	private EpsService epsService;
	
	@PostMapping("/uploadeps")
	public ResponseEntity<?> uploadppe(@RequestParam("file") MultipartFile file)
	{
		if(EpsHelper.checkExcelFormatEps(file))
		{
			// true 
		this.epsService.saveEps(file);
            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));
	
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
	}
	
	@GetMapping("/geteps")
	public List<Eps>getAll()
	{
		return this.epsService.getAll();
	}
	

}
