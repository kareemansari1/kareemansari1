package net.cyperts.cfs.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.cyperts.cfs.entity.Ppe;

public interface PpeService {

public	List<Ppe> getAll();

public void savePpe(MultipartFile file);

}
