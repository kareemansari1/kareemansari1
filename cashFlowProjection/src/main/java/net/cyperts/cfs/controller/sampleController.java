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

import net.cyperts.cfs.entity.sample;
import net.cyperts.cfs.helper.SampleHelper;
import net.cyperts.cfs.services.SampleService;
@RestController
@CrossOrigin("*")
public class sampleController {
	
	@Autowired
  private SampleService sampleService;
	
	@PostMapping("/check")
	public ResponseEntity<?> uploadntfs(@RequestParam("file") MultipartFile file)
	{
		if(SampleHelper.checkExcelFormat(file))
		{
			// true 
		this.sampleService.savesample(file);
            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));
	
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
	}
	
	@GetMapping("/getsample")
	public List<sample>getAll()
	{
		return this.sampleService.getAll();
	}
}
