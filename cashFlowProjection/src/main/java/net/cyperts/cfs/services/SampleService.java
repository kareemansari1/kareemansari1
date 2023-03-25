package net.cyperts.cfs.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.cyperts.cfs.entity.sample;

public interface SampleService {

public	void savesample(MultipartFile file);

public List<sample> getAll();

	

}
